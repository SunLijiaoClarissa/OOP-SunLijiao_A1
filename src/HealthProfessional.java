public class HealthProfessional {
    // 实例变量
    private int id;                // 医生ID
    private String name;           // 医生姓名
    private String info;           // 医生其他信息
    private String contactEmail;   // 医生电子邮件

    // 默认构造函数
    public HealthProfessional() {
        this.id = 0;
        this.name = "Unknown";
        this.info = "No information available";
        this.contactEmail = "No email provided";
    }

    // 带参构造函数，初始化实例变量
    public HealthProfessional(int id, String name, String info, String contactEmail) {
        this.id = id;
        this.name = name;
        this.info = info;
        setContactEmail(contactEmail);  // 使用 setter 方法验证电子邮件
    }

    // Getter 和 Setter 方法
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
            System.out.println("Invalid email format. Setting email to 'No email provided'.");
            this.contactEmail = "No email provided";
        }
    }

    // 打印健康专业人员的详细信息
    public void printDetails() {
        System.out.println("Health Professional Details:");
        System.out.println("------------------------------");
        System.out.println("ID            : " + id);
        System.out.println("Name          : " + name);
        System.out.println("Info          : " + info);
        System.out.println("Contact Email : " + contactEmail);
        System.out.println("------------------------------");
    }

    // toString 方法重写
    @Override
    public String toString() {
        return "Health Professional [ID=" + id + ", Name=" + name + ", Info=" + info + ", Contact Email=" + contactEmail + "]";
    }
}

