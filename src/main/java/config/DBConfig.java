package config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Java configuration class for DB
 */
@Configuration
//@PropertySource("classpath:dbprops.properties")
@EnableTransactionManagement
@ComponentScan({"model","services","repository"})
@EnableJpaRepositories("repository")
public class DBConfig {

    @Value("${db.url}")
    private String DATABASE_URL;
    @Value("${db.username}")
    private String DATABASE_USERNAME;
    @Value("${db.password}")
    private String DATABASE_PASSWORD;
    @Value("${db.driver}")
    private String PROP_DATABASE_DRIVER;
    @Value("${db.hibernate.dialect}")
    private String HIBERNATE_DIALECT = "db.hibernate.dialect";
    @Value("${db.hibernate.show_sql}")
    private String HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
    @Value("${db.entitymanager.packages.to.scan}")
    private String ENTITYMANAGER_PACKAGES_TO_SCAN = "db.entitymanager.packages.to.scan";
    @Value("${db.hibernate.hbm2ddl.auto}")
    private String HIBERNATE_HBM2DDL_AUTO = "db.hibernate.hbm2ddl.auto";

    @Bean
    public DataSource dataSource(){
        System.out.println(PROP_DATABASE_DRIVER);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(PROP_DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);
        return dataSource;
    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource());
//        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        entityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
//
//        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
//
//        return entityManagerFactoryBean;
//    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(getHibernateProperties());

        return em;
    }

//    @Bean
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//
//        return transactionManager;
//    }

    @Bean
    public PlatformTransactionManager transactionManager(
            EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(HIBERNATE_DIALECT, HIBERNATE_DIALECT);
        properties.put(HIBERNATE_SHOW_SQL, HIBERNATE_SHOW_SQL);
        properties.put(HIBERNATE_HBM2DDL_AUTO, HIBERNATE_HBM2DDL_AUTO);

        return properties;
    }
}
