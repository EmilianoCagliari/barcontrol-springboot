package egcdev.barcontrol.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Table( name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( nullable = false )
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal emptyWeight;

    @Column(nullable = false)
    private BigDecimal fullWeight;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String barcode;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand_id;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(BigDecimal emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public BigDecimal getFullWeight() {
        return fullWeight;
    }

    public void setFullWeight(BigDecimal fullWeight) {
        this.fullWeight = fullWeight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Brand getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Brand brand_id) {
        this.brand_id = brand_id;
    }
}
