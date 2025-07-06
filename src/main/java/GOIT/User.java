package GOIT;

public class User {
    public int id;

    public User() {
    }
    public User defaultt () {
        Geo geo = new Geo("-37.3159", "81.1496");
        Address address = new Address("Kulas Light","Apt. 556", "Gwenborough", "92998-3874", geo);
        Company company = new Company("Romaguera-Crona", "Multi-layered client-server neural-net", "harness real-time e-markets");
        return new User(1, "Leanne Graham", "Bret", "Sincere@april.biz", address, "1-770-736-8031 x56442", "hildegard.org", company );
    }

    public User(int id, String name, String username, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;

    public static class Address {
        public String street;
        public String suite;
        public String city;
        public String zipcode;

        public Address() {
        }

        public Address(String street, String suite, String city, String zipcode, Geo geo) {
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
            this.geo = geo;
        }

        public Geo geo;
    }

    public static class Geo {
        public String lat;
        public String lng;

        public Geo() {
        }

        public Geo(String lat, String lng) {
            this.lat = lat;
            this.lng = lng;
        }


    }

    public static class Company {
        public String name;
        public String catchPhrase;

        public Company() {
        }

        public Company(String name, String catchPhrase, String bs) {
            this.name = name;
            this.catchPhrase = catchPhrase;
            this.bs = bs;
        }

        public String bs;
    }
}