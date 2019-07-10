package be.vdab.testtoysforboys.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate ordered;
    private LocalDate required;
    private LocalDate shipped;
    private String comments;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerId")
    private Customer customer;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Version
    private long version;
    /*@ElementCollection
    @CollectionTable(name = "orderdetails", joinColumns = @JoinColumn(name = "orderId"))
    @OrderBy("orderId")*/
    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;

    //CONSTRUCTORS
    protected Order() {
    }

    //GETTERS
    public long getId() {
        return id;
    }

    public LocalDate getOrdered() {
        return ordered;
    }

    public LocalDate getRequired() {
        return required;
    }

    public LocalDate getShipped() {
        return shipped;
    }

    public String getComments() {
        return comments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Status getStatus() {
        return status;
    }

    public long getVersion() {
        return version;
    }

    public Set<OrderDetail> getOrderDetails() {
        return Collections.unmodifiableSet(orderDetails);
    }

    //METHODS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return version == order.version &&
                Objects.equals(ordered, order.ordered) &&
                Objects.equals(required, order.required) &&
                Objects.equals(shipped, order.shipped) &&
                Objects.equals(comments, order.comments) &&
                Objects.equals(customer, order.customer) &&
                status == order.status &&
                Objects.equals(orderDetails, order.orderDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordered, required, shipped);
    }
}
