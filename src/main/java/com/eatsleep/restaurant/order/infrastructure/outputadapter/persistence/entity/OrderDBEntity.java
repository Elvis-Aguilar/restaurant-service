package com.eatsleep.restaurant.order.infrastructure.outputadapter.persistence.entity;


import com.eatsleep.restaurant.orderDetails.infrastructure.outputadapter.persistence.entity.OrderDetailsDBEntity;
import com.eatsleep.restaurant.restaurant.infrastructure.outputadapter.presistence.entity.RestaurantDBEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity(name = "order")
@Table(name = "order", schema = "consumption")
@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class OrderDBEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID DEFAULT uuid_generate_v4()")
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private UUID customerId;

    @NonNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @NonNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal discountPercentage;

    @Column(nullable = true)
    private UUID promotionId;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "restaurant_id")
    private RestaurantDBEntity restaurant;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetailsDBEntity> details;

}
