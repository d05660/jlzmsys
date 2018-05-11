package org.cloud.jlzm.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

@EnableWebMvc
@Configuration
@ComponentScan(useDefaultFilters = false, basePackages = {"org.cloud.jlzm.controller"})
public class MvcConfiguration extends WebMvcConfigurerAdapter {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new PostAndPutCommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(500000000);
        return multipartResolver;
    }
    
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/assets/");
    }
    
    @Bean
    public MessageSource messageSource() {
         ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
         messageSource.setBasename("classpath:/messages/messages");
         return messageSource;
    }

    @Bean(name = "freemarkerConfig")
    public FreeMarkerConfigurer freeMarkerConfigurer() throws IOException, TemplateException {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPaths("classpath:/templates/");
        freemarker.template.Configuration configuration = configurer.createConfiguration();
        // Use this for local development. When a template exception occurs,
        // it will format the error using HTML so it can be easily read
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        // Makre sure everything is UTF-8 from the beginning to avoid headaches
        configuration.setDefaultEncoding("UTF-8");
        configuration.setLocale(Locale.CHINA);
        configuration.setDateFormat("yyyy-MM-dd");
        // Apply the configuration settings to the configurer
        configurer.setConfiguration(configuration);
        return configurer;
    }

    /**
     * 浏览器form表单只支持GET与POST请求，而DELETE、PUT等method并不支持
     * 解决不支持put form数据的问题
     */
    class PostAndPutCommonsMultipartResolver extends CommonsMultipartResolver {
        @Override
        public boolean isMultipart(HttpServletRequest request) {
            String method = request.getMethod().toLowerCase();
            //By default, only POST is allowed. Since this is an 'update' we should accept PUT.
            if (!Arrays.asList("put", "post").contains(method)) { return false; }
            String contentType = request.getContentType();
            return (contentType != null &&contentType.toLowerCase().startsWith("multipart/"));
        }
    }
}
