package com.example.bookstoreonline.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_order_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "item_quantity")
    private Integer quantity;
    @Column(name = "item_price")
    private Double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderItem orderItem = (OrderItem) o;
        return id != null && Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
