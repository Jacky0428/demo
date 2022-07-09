package com.example.demo.store.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MenuId implements Serializable {

    @Column(name = "store_id")
    private Long storeId;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuId menuId)) return false;
        return Objects.equals(storeId, menuId.storeId) && Objects.equals(name, menuId.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, name);
    }
}
