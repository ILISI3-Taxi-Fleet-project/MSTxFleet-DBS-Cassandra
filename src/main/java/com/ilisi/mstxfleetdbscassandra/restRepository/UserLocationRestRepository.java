package com.ilisi.mstxfleetdbscassandra.restRepository;

import com.ilisi.mstxfleetdbscassandra.model.UserLocation;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "userLocations")
public interface UserLocationRestRepository extends CassandraRepository<UserLocation, String> {
}
