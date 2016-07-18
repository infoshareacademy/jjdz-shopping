package com.speed.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="tempcategory")
public class TempFavoriteCategory implements Serializable{


    @Id
    @Column(name = "catId")
    private int catId;
    @Column(name = "catName")
    private String catName;
    @Column(name = "catParent")
    private int catParent;
    @Column(name = "catPosition")
    private int catPosition;
    @Column(name = "catIsProductCatalogueEnabled")
    private int catIsProductCatalogueEnabled;

    public TempFavoriteCategory(int catId, int catParent, String catName) {
        this.catId = catId;
        this.catName = catName;
        this.catParent = catParent;
    }

    public TempFavoriteCategory() {
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatParent() {
        return catParent;
    }

    public void setCatParent(int catParent) {
        this.catParent = catParent;
    }

    public int getCatPosition() {
        return catPosition;
    }

    public void setCatPosition(int catPosition) {
        this.catPosition = catPosition;
    }

    public int getCatIsProductCatalogueEnabled() {
        return catIsProductCatalogueEnabled;
    }

    public void setCatIsProductCatalogueEnabled(int catIsProductCatalogueEnabled) {
        this.catIsProductCatalogueEnabled = catIsProductCatalogueEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TempFavoriteCategory category = (TempFavoriteCategory) o;

        if (getCatId() != category.getCatId()) return false;
        if (getCatParent() != category.getCatParent()) return false;
        if (getCatPosition() != category.getCatPosition()) return false;
        if (getCatIsProductCatalogueEnabled() != category.getCatIsProductCatalogueEnabled()) return false;
        return getCatName().equals(category.getCatName());

    }

    @Override
    public int hashCode() {
        int result = getCatId();
        result = 31 * result + getCatName().hashCode();
        result = 31 * result + getCatParent();
        result = 31 * result + getCatPosition();
        result = 31 * result + getCatIsProductCatalogueEnabled();
        return result;
    }

    @Override
    public String toString() {
        return "TempFavoriteCategory{" +
                "catId=" + catId +
                ", catName='" + catName + '\'' +
                ", catParent=" + catParent +
                ", catPosition=" + catPosition +
                ", catIsProductCatalogueEnabled=" + catIsProductCatalogueEnabled +
                '}';
    }
}

