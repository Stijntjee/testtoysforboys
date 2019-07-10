package be.vdab.testtoysforboys.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Address implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String streetAndNumber;
    private String city;
    private String state;
    private String postalCode;

    //CONSTRUCTORS
    protected Address() {
    }

    public Address(String streetAndNumber, String city, String state, String postalCode) {
        this.streetAndNumber = streetAndNumber;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    //METHODS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address adres = (Address) o;
        return Objects.equals(streetAndNumber, adres.streetAndNumber) &&
                Objects.equals(city, adres.city) &&
                Objects.equals(state, adres.state) &&
                Objects.equals(state, adres.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetAndNumber, city, state, postalCode);
    }

    //GETTERS
    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
