package com.samsung.phanvantiendung.repositories.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Đánh dấu có mỗi quan hệ 1-1 với Person ở phía dưới
    @JoinColumn(name = "user_id") // Liên kết với nhau qua khóa ngoại person_id
    private User user;

    private Integer total_qty;
    private Long total_amount;

    @ColumnDefault("0") // 0 is new order
    private Boolean status;
}
