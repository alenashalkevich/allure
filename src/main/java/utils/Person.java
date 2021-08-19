package utils;

public class Person {

    private String firstName;
    private String lastName;
    private String postalCode;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public static class Builder {
        private Person newPerson;

        public Builder() {
            newPerson = new Person();
        }

        public Builder withFirstName(String firstName){
            newPerson.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName){
            newPerson.lastName = lastName;
            return this;
        }

        public Builder withPostalCode(String postalCode){
            newPerson.postalCode = postalCode;
            return this;
        }

        public Person build(){
            return newPerson;
        }
    }
}