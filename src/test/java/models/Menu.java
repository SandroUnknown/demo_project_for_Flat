package models;


import java.util.List;

public class Menu {
    private List<Item> Item;

    public List<Item> getItem() {
        return Item;
    }

    public void setItem(List<Item> item) {
        this.Item = item;
    }

    public static class Item {
        private String Name;
        private String URL;
        private List<SubItem> SubItem;

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

        public List<SubItem> getSubItem() {
            return SubItem;
        }

        public void setSubItem(List<SubItem> subItem) {
            this.SubItem = subItem;
        }
    }

    public static class SubItem {
        private String Name;
        private String URL;

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
    }
}


