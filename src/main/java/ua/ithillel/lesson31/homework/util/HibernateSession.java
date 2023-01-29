package ua.ithillel.lesson31.homework.util;

import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateSession {

    @Bean
    public static LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
        var sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("ua.ithillel.lesson31.homework.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private static Properties hibernateProperties() {
        var props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.highlight_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        return props;
    }

    @Bean
    public DataSource dataSource() {
        var ds = new SimpleDriverDataSource();
        ds.setDriverClass(Driver.class);
        ds.setUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setUsername("Yevhen");
        ds.setPassword("mysecretpassword");
        return ds;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(LocalSessionFactoryBean sessionFactory) {
        var txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory.getObject());
        return txManager;
    }

}
