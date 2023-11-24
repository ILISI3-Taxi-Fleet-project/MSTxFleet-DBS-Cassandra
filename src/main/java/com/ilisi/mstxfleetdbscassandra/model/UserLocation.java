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

    //make it auto generated
    @PrimaryKey
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

    // Altitude of the user's location
    @Column
    private double altitude;

    // Accuracy or precision of the location data
    @Column
    private double accuracy;

    // Speed at which the user is moving
    @Column
    private double speed;

    // Direction in which the user is heading
    @Column
    private double heading;

    // Name of the user
    @Column
    private String userName;

    // Unique identifier of the device from which the location was recorded
    @Column
    private String deviceId;

    // Type of device (e.g., smartphone, GPS tracker)
    @Column
    private String deviceType;

    // Type of location data (e.g., GPS, WiFi-based, cellular-based)
    @Column
    private String locationType;

    // Type of activity the user is engaged in (e.g., walking, driving)
    @Column
    private String activityType;

    // Relevant status information
    @Column
    private String status;

    // Destination of the user
    @Column
    private String destination;

}
