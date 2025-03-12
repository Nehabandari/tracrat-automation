package tracratselenium.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CompanyDataDetails {

    private String name;
    private String url;
    private String phone;
    private String fax;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postalCode;
    private String description;
    private String primaryContactName;
    private String companyAnnouncements;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = String.valueOf(Integer.parseInt(phone));
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrimaryContactName() {
        return primaryContactName;
    }

    public void setPrimaryContactName(String primaryContactName) {
        this.primaryContactName = primaryContactName;
    }

    public String getCompanyAnnouncements() {
        return companyAnnouncements;
    }

    public void setCompanyAnnouncements(String companyAnnouncements) {
        this.companyAnnouncements = companyAnnouncements;
    }
}
