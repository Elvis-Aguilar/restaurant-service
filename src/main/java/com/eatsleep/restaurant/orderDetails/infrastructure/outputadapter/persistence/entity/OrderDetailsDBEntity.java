package com.eatsleep.restaurant.orderDetails.infrastructure.outputadapter.persistence.entity;

import com.eatsleep.restaurant.dishes.infrastructure.outputadapter.persistence.entity.DishesDBEntity;
import com.eatsleep.restaurant.order.infrastructure.outputadapter.persistence.entity.OrderDBEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity(name = "order_detail")
@Table(name = "order_detail", schema = "consumption")
@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class OrderDetailsDBEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID DEFAULT uuid_generate_v4()")
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private Integer quantity;

    @NonNull
    @Column(nullable = false)
    private BigDecimal unitPrice;

    @NonNull
    @Column(nullable = false)
    private BigDecimal unitCost;

    @NonNull
    @Column(nullable = false)
    private BigDecimal subtotal;

    @NonNull
    @Column(nullable = true)
    private BigDecimal discountPercentage;

    @Column(nullable = true)
    private UUID promotionId;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id")
    private OrderDBEntity order;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dish_id")
    private DishesDBEntity dish;
}
