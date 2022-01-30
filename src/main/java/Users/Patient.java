package Users;

import Hashing.Hashing;
import JDBC.Connect;
import eHealth_GUI.Healthcare_Login;

public class Patient extends Users.User {

    // Attributes

    private String birthday = null; // Implement Date type?



    private String healthInfo = null;
    private String insurance = null; // Enum?
    private String insuranceType = null; // Enum?
    private int isDoc = 0;
    private String username = null;
    private float longitude = 0;
    private float latitude = 0;

    public Patient(String firstName, String lastName, String location, String birthday, String healthInfo, String mailAddress, String pw, String insurance, String insuranceType, float longitude, float latitude) {

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
        this.latitude = latitude;
        this.longitude = longitude;
        //this.health_info1 = health_info1;
       // Connect.insertNewPatient(this.firstName,this.lastName,this.location,this.birthday,this.healthInfo,this.mailAddress, salt, this.pw,this.insurance,this.insuranceType, this.isDoc);

    }

    public Patient(){}

    /**
     * When calling this function, the object patient gets deleted and logged out.
     *
     * @param patient
     */

    public void logOutPat (Patient patient){

        patient.setFirstName(null);
        patient.setLastName(null);
        patient.setUsername(null);
        patient.setMailAddress(null);
        patient.setBirthday(null);
        patient.setLocation(null);
        patient.setHealthInfo(null);
        patient.setInsurance(null);
        patient.setInsuranceType(null);

        System.gc();
        System.out.println("patient is logged out and object deleted");

    }

    public void setMailAddress(String mail){
        this.mailAddress = mail;
    }
    public void setUsername(String usname){
        this.username = usname;
    }

    public void setLongitude(float longitude){
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getBirthday() {return birthday;}

    public void setBirthday(String birthday) {this.birthday = birthday;}

    public String getHealthInfo() {return healthInfo;}

    public void setHealthInfo(String healthInfo) {this.healthInfo = healthInfo;}

    public String getInsurance() {return insurance;}

    public void setInsurance(String insurance) {this.insurance = insurance;}

    public String getInsuranceType() {return insuranceType;}

    public void setInsuranceType(String insuranceType) {this.insuranceType = insuranceType;}

    public int getIsDoc() {return isDoc;}

    public void setIsDoc(int isDoc) {this.isDoc = isDoc;}

    public String getUsername() {return username;}

    public float getLatitude() {return latitude;}

    public float getLongitude() {return longitude;}

}
