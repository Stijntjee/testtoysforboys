package be.vdab.testtoysforboys.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Embedded
    private Address adress;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id")
    private Country country;
    @OneToMany(mappedBy = "customer")
    @OrderBy("id")
    private Set<Order> orders;
    @Version
    private long version;

    //CONSTRUCTORS
    protected Customer() {
    }

    public Customer(String name, Address adress, Country country) {
        this.name = name;
        this.adress = adress;
        this.country = country;
        this.orders = new LinkedHashSet<>();
    }

    //GETTERS
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return adress;
    }

    public Country getCountry() {
        return country;
    }

    public Set<Order> getOrders() {
        return Collections.unmodifiableSet(orders);
    }

    //METHODS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return version == customer.version &&
                Objects.equals(name, customer.name) &&
                Objects.equals(adress, customer.adress) &&
                Objects.equals(country, customer.country) &&
                Objects.equals(orders, customer.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
