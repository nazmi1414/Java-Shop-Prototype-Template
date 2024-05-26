package com.IvAssessment.IvCodeAssignment;

import com.IvAssessment.IvCodeAssignment.model.MenuItem;
import com.IvAssessment.IvCodeAssignment.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@Controller
@RequestMapping("/shops")
public class ShopController {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopController(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @GetMapping("/{id}")
    public String viewShop(@PathVariable("id")Long id, Model model) {
        var shop = shopRepository.findById(id).orElseThrow();
        model.addAttribute("shop", shop);
        return "shop-view";
    }


    @GetMapping("/{id}/create-menu-item")
    public String viewCreateMenuItem(@PathVariable("id") Long id, Model model) {
        var menuItem = new MenuItem();
        menuItem.setShopId(id);
        model.addAttribute("menuItem", menuItem);
        return "create-menu-item-view";
    }

    @PostMapping("/menu-item/save")
    public String saveMenuItem(@ModelAttribute MenuItem menuItem, Model model) {
        var shop = shopRepository.findById(menuItem.getShopId()).orElseThrow();
        shop.getMenuItems().add(menuItem);
        shop = shopRepository.save(shop);
        model.addAttribute("shop", shop);
        return "shop-view";
    }

    @GetMapping("/menu-item/edit/{id}")
    public String editMenuItem(@PathVariable("id") Long id, Model model) {
        var menuItem = shopRepository.findById(id).orElseThrow();
        model.addAttribute("menuItem", menuItem);
        return "edit-menu-item-view";
    }

    @PostMapping("/menu-item/update")
    public String updateMenuItem(@ModelAttribute MenuItem menuItem, Model model) {
        var shop = shopRepository.findById(menuItem.getShopId()).orElseThrow();

        MenuItem existingMenuItem = shop.getMenuItems().stream()
                .filter(item -> item.getId().equals(menuItem.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Menu item not found"));

        existingMenuItem.setName(menuItem.getName());
        existingMenuItem.setDescription(menuItem.getDescription());
        existingMenuItem.setPrice(menuItem.getPrice());

        shop = shopRepository.save(shop);
        model.addAttribute("shop", shop);
        return "shop-view" + menuItem.getShopId();
    }

    @DeleteMapping("/menu-item/delete")
    public String deleteMenuItem(@ModelAttribute MenuItem menuItem, Model model) {
        var shop = shopRepository.findById(menuItem.getShopId()).orElseThrow();
        shop.getMenuItems().removeIf(item -> item.getId().equals(menuItem.getId()));
        shop = shopRepository.save(shop);
        model.addAttribute("shop", shop);
        return "shop-view";
    }
}