package com.eatsleep.restaurant.restaurant.infrastructure.outputadapter.presistence.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity(name = "restaurant")
@Table(name = "restaurant", schema = "restaurant")
@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class RestaurantDBEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID DEFAULT uuid_generate_v4()")
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @Column(nullable = false)
    private String address;

    @NonNull
    @Column(nullable = false)
    private String phone;

    @NonNull
    @Column(nullable = false)
    private Integer capacity;

    @NonNull
    @Column(nullable = false)
    private LocalTime openingTime;

    @NonNull
    @Column(nullable = false)
    private LocalTime closingTime;

    @Column(nullable = true)
    private UUID hotelId;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

}
