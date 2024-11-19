public class GeneralPractitioner extends HealthProfessional {
    private String specialization;  // 专业领域
    private int yearsOfExperience;  // 从业年限

    // 默认构造函数
    public GeneralPractitioner() {
        super();
        this.specialization = "";
        this.yearsOfExperience = 0;
    }

    // 带参构造函数
    public GeneralPractitioner(int id, String name, String info, String contactEmail, String specialization, int yearsOfExperience) {
        super(id, name, info, contactEmail);
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Getter 和 Setter
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience >= 0) {
            this.yearsOfExperience = yearsOfExperience;
        } else {
            System.out.println("Invalid years of experience.");
        }
    }

    // 打印详细信息
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Specialization     : " + specialization);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("------------------------------");
    }

    // 更新专业领域的方法
    public void updateSpecialization(String newSpecialization) {
        this.specialization = newSpecialization;
        System.out.println("Specialization updated to: " + newSpecialization);
    }
}


