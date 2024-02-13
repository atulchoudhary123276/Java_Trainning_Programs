package Company_Collection.assignments.HashMapTask;

public class Address {
    private  int id;
    private  String city;
    private  String state;
    private  String country;
    private  String loaclAdd;
    public Address(int id, String city, String state, String country, String localAddress) {
        if (city == null || state == null || country == null || localAddress == null) {
            throw new IllegalArgumentException("City, state, country, and localAddress cannot be null");
        }
        this.id = id;
        this.city = city;
        this.state = state;
        this.country = country;
        this.loaclAdd = localAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress(){
        return country+" "+state+" "+city+" "+loaclAdd;
    }


    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", loaclAdd='" + loaclAdd + '\'' +
                '}';
    }
}
