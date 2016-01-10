package whisit.model;

import whisit.types.Role;
import whisit.types.SocialMediaService;

import java.util.Date;

/**
 * Created by dinesh on 12/5/2015.
 */
public class User extends AbstractIdElement {

    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
    private SocialMediaService signInProvider;
    private Picture picture;
    private Date dob;
    private Date dateRegistered;
    private Address address;
    private String phone;


    public User() {
        this.role = Role.ROLE_USER;
        signInProvider = SocialMediaService.FACEBOOK;
    }


    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }

    public SocialMediaService getSignInProvider() {
        return signInProvider;
    }

    public User setSignInProvider(SocialMediaService signInProvider) {
        this.signInProvider = signInProvider;
        return this;
    }

    public Picture getPicture() {
        return picture;
    }

    public User setPicture(Picture picture) {
        this.picture = picture;
        return this;
    }

    public Date getDob() {
        return dob;
    }

    public User setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public User setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public User setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    static class Address {
        private String street;
        private String city;
        private String state;
        private String zip;

        public String getStreet() {
            return street;
        }

        public Address setStreet(String street) {
            this.street = street;
            return this;
        }

        public String getCity() {
            return city;
        }

        public Address setCity(String city) {
            this.city = city;
            return this;
        }

        public String getState() {
            return state;
        }

        public Address setState(String state) {
            this.state = state;
            return this;
        }

        public String getZip() {
            return zip;
        }

        public Address setZip(String zip) {
            this.zip = zip;
            return this;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Address{");
            sb.append("street='").append(street).append('\'');
            sb.append(", city='").append(city).append('\'');
            sb.append(", state='").append(state).append('\'');
            sb.append(", zip='").append(zip).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("User{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", role=").append(role);
        sb.append(", signInProvider=").append(signInProvider);
        sb.append(", picture=").append(picture);
        sb.append(", dob=").append(dob);
        sb.append(", dateRegistered=").append(dateRegistered);
        sb.append(", address=").append(address);
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
