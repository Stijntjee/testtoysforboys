package be.vdab.testtoysforboys.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String scale;
    private String description;
    private int inStock;
    private int inOrder;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id")
    private Productline productline;

    @Version
    private long version;
    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails;

    //CONSTRUCTORS
    protected Product() {
    }

    public Product(String name, String scale, String description, int inStock, int inOrder, BigDecimal price, Productline productline) {
        this.name = name;
        this.scale = scale;
        this.description = description;
        this.inStock = inStock;
        this.inOrder = inOrder;
        this.price = price;
        this.productline = productline;
        this.orderDetails = new LinkedHashSet<>();
    }

    //GETTERS
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScale() {
        return scale;
    }

    public String getDescription() {
        return description;
    }

    public int getInStock() {
        return inStock;
    }

    public int getInOrder() {
        return inOrder;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Productline getProductline() {
        return productline;
    }

    public Set<OrderDetail> getOrderDetails() {
        return Collections.unmodifiableSet(orderDetails);
    }

    //METHODS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return inStock == product.inStock &&
                inOrder == product.inOrder &&
                version == product.version &&
                Objects.equals(name.toUpperCase(), product.name.toUpperCase()) &&
                Objects.equals(scale, product.scale) &&
                Objects.equals(description, product.description) &&
                Objects.equals(price, product.price) &&
                Objects.equals(productline, product.productline) &&
                Objects.equals(orderDetails, product.orderDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toUpperCase());
    }
}
