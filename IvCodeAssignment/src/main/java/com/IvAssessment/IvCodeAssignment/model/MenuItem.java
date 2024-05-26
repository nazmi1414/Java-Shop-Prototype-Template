package com.IvAssessment.IvCodeAssignment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Setter
@Getter
@Entity(name = "menu_item")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    @Column(name = "shop_id")
    private Long shopId;

    public MenuItem() {
    }

    public MenuItem(Long id, String name, String description, BigDecimal price, Long shopId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.shopId = shopId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(id, menuItem.id) && Objects.equals(name, menuItem.name) && Objects.equals(description, menuItem.description) && Objects.equals(price, menuItem.price) && Objects.equals(shopId, menuItem.shopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, shopId);
    }
}