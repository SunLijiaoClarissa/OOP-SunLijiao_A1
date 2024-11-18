public class HealthProfessional {
    // 实例变量
    private int id;            // 医生ID
    private String name;       // 医生姓名
    private String info;       // 医生其他信息（如科室、资格证书等）
    private String contactEmail;  // 医生电子邮件

    // 默认构造函数
    public HealthProfessional() {
        this.id = 0;
        this.name = "";
        this.info = "";
        this.contactEmail = "";
    }

    // 带参构造函数，初始化实例变量
    public HealthProfessional(int id, String name, String info, String contactEmail) {
        this.id = id;
        this.name = name;
        this.info = info;
        setContactEmail(contactEmail);  // 使用setter方法验证电子邮件
    }

    // 设置电子邮件，并进行格式验证
    public void setContactEmail(String contactEmail) {
        if (contactEmail != null && contactEmail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            this.contactEmail = contactEmail;
        } else {
            System.out.println("Invalid email format.");
        }
    }

    // 获取电子邮件
    public String getContactEmail() {
        return contactEmail;
    }

    // 打印健康专业人员的详细信息
    public void printDetails() {
        System.out.println("Health Professional Details:");
        System.out.println("------------------------------");
        System.out.println("ID            : " + id);
        System.out.println("Name          : " + name);
        System.out.println("Info          : " + (info != null ? info : "No information available"));
        System.out.println("Contact Email : " + (contactEmail != null ? contactEmail : "No email provided"));
        System.out.println("------------------------------");
    }

    // toString 方法重写，便于打印健康专业人员的简洁信息
    @Override
    public String toString() {
        return "Health Professional [ID=" + id + ", Name=" + name + ", Info=" + info + ", Contact Email=" + contactEmail + "]";
    }
}
