public class HealthProfessional {
    // 实例变量
    private int id;            // 只能为数字
    private String name;       // 医生的姓名
    private String info;       // 其他与医生无关的基本信息（例如：科室、资格证书等）

    // 默认构造函数
    public HealthProfessional() {
        this.id = 0;
        this.name = "";
        this.info = "";
    }

    // 第二个构造函数，初始化所有实例变量
    public HealthProfessional(int id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    // 方法：打印所有实例变量
    public void printDetails() {
        System.out.println("Health Professional Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Info: " + info);
    }
}
