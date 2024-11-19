public class Ophthalmologist extends HealthProfessional {
    private String qualification;   // 资格证书
    private String clinicLocation;  // 诊所位置

    // 默认构造函数
    public Ophthalmologist() {
        super();
        this.qualification = "";
        this.clinicLocation = "";
    }

    // 带参构造函数
    public Ophthalmologist(int id, String name, String info, String contactEmail, String qualification, String clinicLocation) {
        super(id, name, info, contactEmail);
        this.qualification = qualification;
        this.clinicLocation = clinicLocation;
    }

    // Getter 和 Setter
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getClinicLocation() {
        return clinicLocation;
    }

    public void setClinicLocation(String clinicLocation) {
        this.clinicLocation = clinicLocation;
    }

    // 判断是否在特定地点工作
    public boolean isWorkingAt(String location) {
        return clinicLocation.equals(location);
    }

    // 打印详细信息
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Qualification  : " + qualification);
        System.out.println("Clinic Location: " + clinicLocation);
        System.out.println("------------------------------");
    }
}
