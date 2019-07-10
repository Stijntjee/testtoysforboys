package be.vdab.testtoysforboys.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "orderdetails")
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderid")
    private Order order;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productid")
    private Product product;
    private int ordered;
    private BigDecimal priceEach;

    //CONSTRUCTORS
    public OrderDetail() {
    }

    public OrderDetail(Order order, Product product, int ordered, BigDecimal priceEach) {
        this.order = order;
        this.product = product;
        this.ordered = ordered;
        this.priceEach = priceEach;
    }

    //GETTERS
    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public int getOrdered() {
        return ordered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    //METHODS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetail)) return false;
        OrderDetail that = (OrderDetail) o;
        return ordered == that.ordered &&
                Objects.equals(order, that.order) &&
                Objects.equals(product, that.product) &&
                Objects.equals(priceEach, that.priceEach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product, ordered, priceEach);
    }
}