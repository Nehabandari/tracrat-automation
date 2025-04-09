package tracratselenium.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LocationDataDetails {
    private String name;
    private String location;
    private String status;
    private String critical;
    private String vendorlocation;
    private String desiredspareratio;
    private String parentlocation;
    private String addressline1;
    private String addressline2;
    private String city;
    private String state;
    private String postalcode;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getVendorlocation() {
        return vendorlocation;
    }

    public void setVendorlocation(String vendorlocation) {
        this.vendorlocation = vendorlocation;
    }

    public String getDesiredspareratio() {
        return desiredspareratio;
    }

    public void setDesiredspareratio(String desiredspareratio) {
        this.desiredspareratio = desiredspareratio;
    }

    public String getParentlocation() {
        return parentlocation;
    }

    public void setParentlocation(String parentlocation) {
        this.parentlocation = parentlocation;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

