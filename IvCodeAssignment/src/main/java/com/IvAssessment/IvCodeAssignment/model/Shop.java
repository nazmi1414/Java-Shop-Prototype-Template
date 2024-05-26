package com.IvAssessment.IvCodeAssignment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Getter
    private String name;

    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = MenuItem.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "shop_id")
    private List<MenuItem> menuItems;

    public Shop() {
    }

    public Shop(Long id,String name, List<MenuItem> menuItems) {
        this.id = id;
        this.name = name;
        this.menuItems = menuItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop that = (Shop) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(menuItems, that.menuItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, menuItems);
    }
}