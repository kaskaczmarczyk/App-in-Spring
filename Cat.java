package AplikacjaSpring;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cat {
    private String name;
    private Date dateOfBirth;
    private Float weight;
    private String catOwnerName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getCatOwnerName() {
        return catOwnerName;
    }

    public void setCatOwnerName(String catOwnerName) {
        this.catOwnerName = catOwnerName;
    }
}
