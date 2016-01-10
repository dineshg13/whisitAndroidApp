package whisit.model;

/**
 * Created by dinesh on 11/20/2015.
 */
public enum Gender {
    MALE(0), FEMALE(1), OTHERS(2);
    int value;

    private Gender(int value) {
        this.value = value;
    }
}
