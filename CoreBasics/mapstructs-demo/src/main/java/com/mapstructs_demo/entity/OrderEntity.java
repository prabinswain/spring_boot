package com.mapstructs_demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "orders", schema = "basics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderId;
    private String customerId;
    private LocalDateTime orderDate;
    private  String orderStatus;
    private  BigDecimal subtotal;
    private  BigDecimal taxAmount;
    private  BigDecimal shippingFee;
    private BigDecimal discountAmount;
    private BigDecimal totalAmount;
    private String paymentMethod;
    private String paymentStatus;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_addresses" , referencedColumnName = "address_id")
    private ShippingAddressEntity shippingAddress;
    private   String trackingNumber;
    private  LocalDateTime updatedAt;
    private String shippingMethod;

}
