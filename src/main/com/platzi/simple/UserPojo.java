package main.com.platzi.simple;

import main.com.platzi.simple.constants.Messages;

public class UserPojo {
    private int country;
    private int city;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String borndate;

    public UserPojo(int country, int city, String name, String surname, String email, String password, String borndate) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.borndate = borndate;
        this.city = city;
        this.country = country;
    }

    public UserPojo() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getBorndate() {
        return borndate;
    }

    public String getPassword() {
        return password;
    }

    public int getCity() {
        return city;
    }

    public int getCountry() {
        return country;
    }

    @Override
    public String toString() {
        String nextData = Messages.NEW_LINE.getValue();

        return super.toString() + nextData + this.getName() + nextData + this.getSurname() + nextData + this.getEmail() + nextData + this.getBorndate();
    }
}
