public class Ophthalmologist extends HealthProfessional {
    private String qualification;  // 资格证书

    // 默认构造函数
    public Ophthalmologist() {
        super();  // 调用父类的默认构造函数
        this.qualification = "";
    }

    // 第二个构造函数，初始化所有实例变量
    public Ophthalmologist(int id, String name, String info, String contactEmail, String qualification) {
        super(id, name, info, contactEmail);  // 调用父类的带参构造函数
        this.qualification = qualification;
    }

    // 打印医生的详细信息
    @Override
    public void printDetails() {
        System.out.println("The health professional details are:");
        super.printDetails();  // 打印父类（HealthProfessional）的信息
        System.out.println("Qualification: " + qualification);  // 打印该医生的资格证书
    }

    // Getter 和 Setter 方法
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
