public class Appointment {
    private String patientName;  // 患者姓名
    private String patientMobile; // 患者手机
    private String timeSlot;     // 预约时间
    private HealthProfessional doctor; // 预约的医生（父类）

    // 默认构造函数
    public Appointment() {
        this.patientName = "";
        this.patientMobile = "";
        this.timeSlot = "";
        this.doctor = null;  // 默认为 null
    }

    // 第二个构造函数，初始化所有实例变量
    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.timeSlot = timeSlot;
        this.doctor = doctor;  // 传入医生对象
    }

    // 打印预约的所有信息
    public void printDetails() {
        System.out.println("Appointment Details:");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Preferred Time Slot: " + timeSlot);
        System.out.println("Doctor Details:");
        doctor.printDetails();  // 调用医生对象的 printDetails() 方法
    }

    // Getter 和 Setter 方法（可选）
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public HealthProfessional getDoctor() {
        return doctor;
    }

    public void setDoctor(HealthProfessional doctor) {
        this.doctor = doctor;
    }
}
