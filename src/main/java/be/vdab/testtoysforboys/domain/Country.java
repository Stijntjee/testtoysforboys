package be.vdab.testtoysforboys.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table( name = "countries")
public class Country
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String name;
   @Version
   private long version;
   @OneToMany(mappedBy = "country")
   @OrderBy("id, name")
   private Set<Customer> customers;

   //CONSTRUCTORS
    protected Country() {
    }

    public Country(String name) {
        this.name = name;
        this.version = version;
        this.customers = new LinkedHashSet<>();
    }

    //GETTERS
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Customer> getCustomers() {
        return Collections.unmodifiableSet(customers);
    }
}
