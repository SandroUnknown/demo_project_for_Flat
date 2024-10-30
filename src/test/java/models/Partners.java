package models;

import java.util.List;

public class Partners {
    private List<City> City;

    public List<City> getCities() {
        return City;
    }

    public void setCities(List<City> city) {
        this.City = city;
    }

    public static class City {
        private String Name;
        private List<Partner> Partner;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }

        public List<Partner> getPartners() {
            return Partner;
        }

        public void setPartners(List<Partner> partner) {
            this.Partner = partner;
        }
    }

    public static class Partner {
        private String Name;
        private String URL;
        private String Phone;
        private String Level;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }

        public String getURL() {
            return URL;
        }

        public void setURL(String url) {
            this.URL = url;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String phone) {
            this.Phone = phone;
        }

        public String getLevel() {
            return Level;
        }

        public void setLevel(String level) {
            this.Level = level;
        }
    }
}