package be.vdab.testtoysforboys.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Productline implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Version
    private long version;
    @OneToMany(mappedBy = "productline")
    private Set<Product> products;

    //CONSTRUCTORS
    protected Productline() {
    }

    public Productline(String name, String description) {
        this.name = name;
        this.description = description;
        this.products = new LinkedHashSet<>();
    }

    //GETTERS
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Product> getProducts() {
        return Collections.unmodifiableSet(products);
    }
}
