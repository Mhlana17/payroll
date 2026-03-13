package za.ac.cput.domain;

public class Address {
    protected String streetAddress;
    protected String postalAddress;

    public  Address() {
    }

    public Address(Builder builder) {
        this.streetAddress = builder.streetAddress;
        this.postalAddress = builder.postalAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                '}';
    }
    public static class Builder{
        private String streetAddress;
        private String postalAddress;

        public Builder setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public Builder setPostalAddress(String postalAddress) {
            this.postalAddress = postalAddress;
            return this;
        }

        public Builder copy(Address address){
            this.streetAddress = address.streetAddress;
            this.postalAddress = address.postalAddress;
            return this;
        }
        public Address build(){
            return new Address(this);
        }


    }// end of Builder

}//end of class
