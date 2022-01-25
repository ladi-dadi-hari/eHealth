package Users;

import Hashing.Hashing;
import JDBC.Connect;

public class Patient extends Users.User {

    // Attributes

    private String birthday = null; // Implement Date type?
    private String healthInfo = null;
    private String insurance = null; // Enum?
    private String insuranceType = null; // Enum?

    public Patient(String firstName, String lastName, String location, String birthday, String healthInfo, String mailAddress, String pw, String insurance, String insuranceType) {

        String salt = Hashing.getSalt();

        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.birthday = birthday;
        this.healthInfo = healthInfo;
        this.mailAddress = mailAddress;
        this.pw = Hashing.doHashing(pw, salt);
        this.insurance = insurance;
        this.insuranceType = insuranceType;
        //this.health_info1 = health_info1;
        Connect.insertNewPatient(this.firstName,this.lastName,this.location,this.birthday,this.healthInfo,this.mailAddress, salt, this.pw,this.insurance,this.insuranceType, this.isDoc);

    }
}
