package ru.ok.journal.remote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import ru.ok.journal.remote.rmi.IRMIComment;

@Configuration
public class RemoteConfig {
    @Bean
    public RmiProxyFactoryBean rmiProxy() {
        RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
        bean.setServiceInterface(IRMIComment.class);
        bean.setServiceUrl("rmi://localhost:1099/rmi_comment");

        return bean;
    }
}
