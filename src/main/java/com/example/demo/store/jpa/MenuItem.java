package com.example.demo.store.jpa;

import javax.persistence.*;

/**
 * The item of menu.
 */
@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The meal name.
     * ex: Fried pork rice, Red tea, ... and so on.
     */
    private String mealName;

    /**
     * The price of the meal.
     */
    private double price;

    /**
     * The description of the meal.
     * ex: The pork is from Yilan and the rice is from Taitung.
     */
    private String description;

    /**
     * note
     */
    private String note;

    /**
     * the menuItem belong this menu.
     */
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "store_id", referencedColumnName = "store_id"),
            @JoinColumn(name = "menu_name", referencedColumnName = "name")
    })
    private Menu menu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
