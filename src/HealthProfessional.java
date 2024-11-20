public class HealthProfessional {
    // Instance variable
    private int id;                  // Doctor ID
    private String name;             // Doctor's name
    private String info;             // Doctor Other Information
    private String contactEmail;     // Doctor email

    // Default constructor
    public HealthProfessional() {
        this.id = 0;
        this.name = "";
        this.info = "";
        this.contactEmail = "";
    }

    // Parameterized constructor
    public HealthProfessional(int id, String name, String info, String contactEmail) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.contactEmail = validateEmail(contactEmail); // Invoke a private method to validate the E-mail
    }

    // Private method: Validate and return the email
    private String validateEmail(String contactEmail) {
        if (contactEmail != null && contactEmail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return contactEmail;
        } else {
            System.out.println("Invalid email format.");
            return "";
        }
    }

    // Getter and Setter methods
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        if (contactEmail != null && contactEmail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            this.contactEmail = contactEmail;
        } else {
            System.out.println("Invalid email format.");
            this.contactEmail = "";
        }
    }

    // Print details of health professionals
    public void printDetails() {
        System.out.println("Health Professional Details:");
        System.out.println("------------------------------");
        System.out.println("ID            : " + id);
        System.out.println("Name          : " + name);
        System.out.println("Info          : " + (info != null ? info : "No information available"));
        System.out.println("Contact Email : " + (contactEmail != null ? contactEmail : "No email provided"));
        System.out.println("------------------------------");
    }

    // toString methods
    @Override
    public String toString() {
        return "HealthProfessional [ID=" + id + ", Name=" + name + ", Info=" + info + ", Contact Email=" + contactEmail + "]";
    }
}
