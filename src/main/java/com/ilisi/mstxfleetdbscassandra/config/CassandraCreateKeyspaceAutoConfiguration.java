package com.ilisi.mstxfleetdbscassandra.config;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.cql.generator.CreateKeyspaceCqlGenerator;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;

/**
 * create the configured keyspace before the first cqlSession is instantiated. This is guaranteed by running this
 * autoconfiguration before the spring-boot one.
 */
@Configuration
@ConditionalOnClass(CqlSession.class)
@ConditionalOnProperty(name = "spring.cassandra.create-keyspace", havingValue = "true")
@AutoConfigureBefore(CassandraAutoConfiguration.class)
@Slf4j
public class CassandraCreateKeyspaceAutoConfiguration {

    public CassandraCreateKeyspaceAutoConfiguration(CqlSessionBuilder cqlSessionBuilder, CassandraProperties properties) {
        // It's OK to mutate cqlSessionBuilder because it has prototype scope.
        try (CqlSession session = cqlSessionBuilder.withKeyspace((CqlIdentifier) null).build()) {
            log.info("Creating keyspace {} ...", properties.getKeyspaceName());
            session.execute(CreateKeyspaceCqlGenerator.toCql(
                    CreateKeyspaceSpecification.createKeyspace(properties.getKeyspaceName()).ifNotExists()));
        } catch (Exception e) {
            log.error("Custom : Error creating keyspace ", e);
        }
    }
}