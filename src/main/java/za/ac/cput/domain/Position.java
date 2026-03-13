package za.ac.cput.domain;

public class Position {
   protected String positionCode;
   protected String status;

   public Position(){

   }

   public Position(Builder builder){

       this.positionCode = builder.positionCode;
       this.status = builder.status;
   }

    public String getPositionCode() {
        return positionCode;
    }

    public String getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "Position{" +
                "positionCode='" + positionCode + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder{
       private String positionCode;
       private String status;

        public Builder setPositionCode(String positionCode) {
            this.positionCode = positionCode;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Position position){
            this.positionCode = position.positionCode;
            this.status = position.status;
            return this;
        }
        public Position build(){
            return new Position(this);
        }
    }//end of builder
}//end of class
