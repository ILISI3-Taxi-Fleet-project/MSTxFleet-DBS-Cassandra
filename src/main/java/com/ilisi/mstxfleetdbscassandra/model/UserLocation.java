package com.ilisi.mstxfleetdbscassandra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("user_locations")
public class UserLocation {

    // Unique identifier for the location
    @PrimaryKey
    @Column
    private String key = UUID.randomUUID().toString();

    // Unique identifier for the user
    @Column
    private String userId;

    // Time when the location was recorded
    @Column
    private Instant createdAt;

    // the user's location in the form of a WKT point (e.g., POINT(2.3 4.5))
    @Column
    private String location;

    // Type of user (e.g., driver, passenger)
    @Column
    private String userType;

    // Whether the user is online or not
    @Column
    private Boolean isOnline;

    // Altitude of the user's location
    @Column
    private double altitude;

    // Accuracy or precision of the location data
    @Column
    private double accuracy;


    // Type of location data (e.g., GPS, WiFi-based, cellular-based)
    @Column
    private String locationType;


}
