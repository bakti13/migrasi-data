package id.app.amira.migrasidata.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "id.app.amira.migrasidata.repo.simkeu",
        entityManagerFactoryRef = "simkeuEntityManagerFactory",
        transactionManagerRef = "simkeuTransactionManager")
public class SimakeuDataSourceConfig {

    @Primary
    @Bean(name = "simkeuDataSourceProperties")
    @ConfigurationProperties("simkeu.datasource")
    public DataSourceProperties simkeuDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "simkeuDataSource")
    @ConfigurationProperties("simkeu.datasource.configuration")
    public DataSource simkeudataSource(@Qualifier("simkeuDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Primary
    @Bean(name = "simkeuEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("simkeuDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("id.app.amira.migrasidata.model")
                .persistenceUnit("simkeu")
                .build();
    }

    @Primary
    @Bean(name = "simkeuTransactionManager")
    public PlatformTransactionManager transactionManager(
            final @Qualifier("simkeuEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
