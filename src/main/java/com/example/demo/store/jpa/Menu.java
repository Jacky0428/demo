package com.example.demo.store.jpa;

import javax.persistence.*;
import java.util.List;

/**
 * The menu of the store.
 */
@Entity
public class Menu {

    @EmbeddedId
    private MenuId id;

    /**
     * 菜單類型
     * 例如: 早餐菜單、午餐菜單、下午茶菜單...
     * The type of menu.
     * ex: Breakfast menu, lunch menu, tea time menu...and so on.
     *
     */
    private String menuType;

    /**
     * The description of the menu.
     */
    private String description;

    /**
     * The menu's owner.
     */
    @ManyToOne
    @JoinColumn(name = "STORE_ID", referencedColumnName = "id")
    private Store store;

    @OneToMany(mappedBy = "menu")
    private List<MenuItem> menuItems;

    /**
     * The menuItemType of this menuItem.
     * ex: Appetizer, main meal, drink.
     */
    private String menuItemType;

    public MenuId getId() {
        return id;
    }

    public void setId(MenuId id) {
        this.id = id;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public String getMenuItemType() {
        return menuItemType;
    }

    public void setMenuItemType(String menuItemType) {
        this.menuItemType = menuItemType;
    }

}
