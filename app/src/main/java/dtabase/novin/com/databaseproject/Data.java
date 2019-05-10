package dtabase.novin.com.databaseproject;


public class Data {
    private int id;
    private String name;
    private String family;
    private String phone;
    private String date;

    public Data() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Data(String name, String family, String phone, String date) {
        this.name = name;
        this.family = family;
        this.phone = phone;
        this.date = date;
    }
}
