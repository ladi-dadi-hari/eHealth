package Users;

public class User {

    protected String firstName = null;
    protected String lastName = null;
    protected String location = null;
    protected String mailAddress = null; // Check for mail format? Class?
    protected String pw = null;






    //protected String insurance = null; // Enum?
    //protected String insuranceType = null; // Enum?
    //protected String birthday = null; // Implement Date type?
    //protected String healthInfo = null;

    //private ArrayList<String> health_info1 = new ArrayList<String>();
    //private enum insurances {
    //    AOK, BARMER, DAK, TKK, BKK, IKK, HKK, KKH
    //}
    //private enum insurance_Type {
    //    PRIVATE, PUBLIC
    //}



    // Constructor


    // Constructor called upon registration

    //public user(String firstName, String lastName, String location, String birthday, String healthInfo, String mailAddress, String pw, String insurance, String insuranceType) {

    //    String salt = Hashing.getSalt();

    //  this.firstName = firstName;
    //  this.lastName = lastName;
    //    this.location = location;
    //    this.birthday = birthday;
    //    this.healthInfo = healthInfo;
    //    this.mailAddress = mailAddress;
    //    this.pw = Hashing.doHashing(pw, salt);
    //    this.insurance = insurance;
    //    this.insuranceType = insuranceType;
    //this.health_info1 = health_info1;
    //    Connect.create_user(this.firstName,this.lastName,this.location,this.birthday,this.healthInfo,this.mailAddress, salt, this.pw,this.insurance,this.insuranceType, this.isDoc);

    //}

    //user() {}




    // Getters and Setters



    //public ArrayList<String> getHealth_info1() {
    //    return health_info1;
    //}

    //public void setHealth_info1(ArrayList<String> health_info1) {
    //    this.health_info1 = health_info1;
    //}


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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
