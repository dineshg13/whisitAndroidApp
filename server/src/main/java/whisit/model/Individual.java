package whisit.model;

import whisit.model.social.FacebookAccount;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.Set;

/**
 * Created by dinesh on 11/20/2015.
 */
public class Individual extends AbstractIdElement {

    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private Date dateOfBirth;

    @DBRef
    private Set<FacebookAccount> facebookAccounts;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t");
        sb.append("Individual{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", facebookAccounts=").append(facebookAccounts);
        sb.append('}');
        return sb.toString();
    }
}
