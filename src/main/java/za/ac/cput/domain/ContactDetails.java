package za.ac.cput.domain;

public class ContactDetails {
    protected String phoneNumber;
    protected String homeNumber;
    protected String email;

    public ContactDetails(){

    }

    public ContactDetails(Builder builder) {
        this.phoneNumber = builder.phoneNumber;
        this.homeNumber = builder.homeNumber;
        this.email = builder.email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public static class Builder{
        private String phoneNumber;
        private String homeNumber;
        private String email;

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setHomeNumber(String homeNumber) {
            this.homeNumber = homeNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder copy(ContactDetails contactDetails){
            this.phoneNumber = contactDetails.phoneNumber;
            this.homeNumber = contactDetails.homeNumber;
            this.email = contactDetails.email;
            return this;
        }
        public ContactDetails build(){
            return new ContactDetails(this);
        }

    }//end of Builder
}//end of class
