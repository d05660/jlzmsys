package org.cloud.jlzm.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.cloud.jlzm.security.PasswordHash;
import org.cloud.jlzm.security.RetryLimitCredentialsMatcher;
import org.cloud.jlzm.security.ShiroAjaxSessionFilter;
import org.cloud.jlzm.security.ShiroSecurityRealm;
import org.cloud.jlzm.security.UserFilter;
import org.cloud.jlzm.security.cache.ShiroSpringCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ShiroConfiguration {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public ShiroFilterFactoryBean shirFilter() {
        logger.debug("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager());
        
        shiroFilter.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilter.setSuccessUrl("/home");
        //未授权界面;
        shiroFilter.setUnauthorizedUrl("/403");
        Map<String, String> filterChainDefinitionMapping = new HashMap<>();
        filterChainDefinitionMapping.put("/assets/**", "anon");
        filterChainDefinitionMapping.put("/login", "anon");
        filterChainDefinitionMapping.put("/**", "user");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMapping);
        Map<String, Filter> filters = new HashMap<>();
        filters.put("user", new ShiroAjaxSessionFilter());
        shiroFilter.setFilters(filters);
        return shiroFilter;
    }
    
    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager() {
        EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
        cmfb.setConfigLocation(new ClassPathResource("config/ehcache.xml"));
        cmfb.setShared(true);
        return cmfb;
    }
    
    @Bean
    public EhCacheCacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheCacheManager().getObject());
    }
    
    @Bean
    public ShiroSpringCacheManager shiroSpringCacheManager() {
        ShiroSpringCacheManager shiroSpringCacheManager = new ShiroSpringCacheManager();
        shiroSpringCacheManager.setCacheManager(cacheManager());
        return shiroSpringCacheManager;
    }
    
    /**
     * cookie对象;
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie(){
       //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
       SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
       simpleCookie.setHttpOnly(true);
       //<!-- 记住我cookie生效时间30天 ,单位秒;-->
       simpleCookie.setMaxAge(7 * 24 * 60 * 60);
       return simpleCookie;
    }
    
    /**
     * cookie管理对象;
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
       CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
       cookieRememberMeManager.setCookie(rememberMeCookie());
       return cookieRememberMeManager;
    }
    
    @Bean
    public RetryLimitCredentialsMatcher credentialsMatcher() {
        RetryLimitCredentialsMatcher credentialsMatcher = new RetryLimitCredentialsMatcher(shiroSpringCacheManager());
        credentialsMatcher.setRetryLimitCacheName("halfHour");
        credentialsMatcher.setPasswordHash(passwordHash());
        return credentialsMatcher;
    }
    
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public ShiroSecurityRealm shiroSecurityRealm() {
        ShiroSecurityRealm shiroSecurityRealm = new ShiroSecurityRealm(shiroSpringCacheManager(), credentialsMatcher());
        shiroSecurityRealm.setAuthenticationCachingEnabled(true);
        shiroSecurityRealm.setAuthenticationCacheName("authenticationCache");
        shiroSecurityRealm.setAuthorizationCacheName("authorizationCache");
        return shiroSecurityRealm;
    }
    
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroSecurityRealm());
        //注入缓存管理器;
        securityManager.setCacheManager(shiroSpringCacheManager());//这个如果执行多次，也是同样的一个对象;
        //注入记住我管理器;
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    @Bean
    public SimpleCookie sessionIdCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("sid");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(-1);
        return simpleCookie;
    }

    @Bean
    public UserFilter userFilter() {
        return new UserFilter();
    }

    @Bean
    public PasswordHash passwordHash() {
        PasswordHash passwordHash = new PasswordHash();
        passwordHash.setAlgorithmName("md5");
        passwordHash.setHashIterations(1);
        return passwordHash;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}
