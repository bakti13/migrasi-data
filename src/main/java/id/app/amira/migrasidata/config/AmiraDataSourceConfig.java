package id.app.amira.migrasidata.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "id.app.amira.migrasidata.repo.amira",
        entityManagerFactoryRef = "amiraEntityManagerFactory",
        transactionManagerRef= "amiraTransactionManager")
public class AmiraDataSourceConfig {

    @Bean(name = "amiraDataSourceProperties")
    @ConfigurationProperties("amira.datasource")
    public DataSourceProperties amiraDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "amiraDataSource")
    @ConfigurationProperties("amira.datasource.configuration")
    public DataSource amiraDataSource(@Qualifier("amiraDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean(name = "amiraEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean EntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("amiraDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("id.app.amira.migrasidata.model")
                .build();
    }

    @Bean(name = "amiraTransactionManager")
    public PlatformTransactionManager transactionManager(
            final @Qualifier("amiraEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
