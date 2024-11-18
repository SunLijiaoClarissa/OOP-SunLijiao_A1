public class GeneralPractitioner extends HealthProfessional {
    private String specialization;  // 专业领域（如内科、外科等）

    // 默认构造函数
    public GeneralPractitioner() {
        super();  // 调用父类的默认构造函数
        this.specialization = "";
    }

    // 第二个构造函数，初始化所有实例变量
    public GeneralPractitioner(int id, String name, String info, String contactEmail, String specialization) {
        super(id, name, info, contactEmail);  // 调用父类的带参构造函数
        this.specialization = specialization;
    }

    // 打印医生的详细信息，重写父类的 printDetails 方法
    @Override
    public void printDetails() {
        System.out.println("The health professional details are:");
        super.printDetails();  // 打印父类（HealthProfessional）的信息
        System.out.println("Specialization: " + specialization);  // 打印该医生的专业领域
    }

    // Getter 和 Setter 方法
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}

