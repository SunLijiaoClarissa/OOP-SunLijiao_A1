public class HealthProfessional {
    // 实例变量
    private int id;            // 只能为数字
    private String name;       // 医生的姓名
    private String info;       // 其他与医生无关的基本信息（例如：科室、资格证书等）
    private String contactEmail;  // 电子邮箱

    // 默认构造函数
    public HealthProfessional() {
        this.id = 0;
        this.name = "";
        this.info = "";
        this.contactEmail = "";
    }

    // 第二个构造函数，初始化所有实例变量
    public HealthProfessional(int id, String name, String info, String contactEmail) {
        this.id = id;
        this.name = name;
        this.info = info;
        setContactEmail(contactEmail);  // 使用 setter 方法进行验证
    }

    // 设置电子邮件
    public void setContactEmail(String contactEmail) {
        // 简单的电子邮件格式验证
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

    // 打印所有实例变量
    public void printDetails() {
        System.out.println("Health Professional Details:");
        System.out.println("------------------------------");
        System.out.println("ID            : " + id);
        System.out.println("Name          : " + name);
        System.out.println("Info          : " + (info != null ? info : "No information available"));
        System.out.println("Contact Email : " + (contactEmail != null ? contactEmail : "No email provided"));
        System.out.println("------------------------------");
    }

    // 覆盖 toString 方法
    @Override
    public String toString() {
        return "Health Professional [ID=" + id + ", Name=" + name + ", Info=" + info + ", Contact Email=" + contactEmail + "]";
    }
}
