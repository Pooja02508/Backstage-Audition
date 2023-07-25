package casting.movie.audition.models;

public class UserDetails {

    private String userName,userMobile,userAge,userEmail,userPassword,userAddress,joiningTime;

    public UserDetails() {

    }
    public UserDetails(String userName, String userAge, String userMobile, String userEmail, String userPassword, String userAddress,String joiningTime) {
        this.userName = userName;
        this.userAge = userAge;
        this.userMobile = userMobile;
        this.userEmail = userEmail;
        this.userPassword=userPassword;
        this.userAddress=userAddress;
        this.joiningTime=joiningTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getJoiningTime() {
        return joiningTime;
    }

    public void setJoiningTime(String joiningTime) {
        this.joiningTime = joiningTime;
    }
}
