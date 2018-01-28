

import java.util.Arrays;

public class Adress {

    private String[] adress;

    public Adress() {
        this.adress = new String[2];
        this.adress[0] = "";
        this.adress[1] = "";
    }

    public void setStreet(String street) {
        this.adress[0] = street;
    }

    public void setCity(String city) {
        this.adress[1] = city;
    }

    public String getStreet() {
        return this.adress[0];
    }

    public String getCity() {
        return this.adress[1];
    }

    public void removeAdress() {
        Arrays.fill(this.adress, null);
    }

}