package whisit.model.social;

import whisit.model.AbstractIdElement;
import whisit.model.Individual;

import java.util.Date;

/**
 * Created by dinesh on 11/20/2015.
 */
public class FacebookAccount extends AbstractIdElement {


    private Date registeredDate;
    private FacebookAccountDetail facebookAccountDetail;
    private Individual individual;

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public FacebookAccountDetail getFacebookAccountDetail() {
        return facebookAccountDetail;
    }

    public void setFacebookAccountDetail(FacebookAccountDetail facebookAccountDetail) {
        this.facebookAccountDetail = facebookAccountDetail;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("FacebookAccount{");
        sb.append("registeredDate=").append(registeredDate);
        sb.append(", facebookAccountDetail=").append(facebookAccountDetail);
        sb.append(", individual=").append(individual);
        sb.append('}');
        return sb.toString();
    }
}
