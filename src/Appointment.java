public class Appointment {
    private String patientName;  // 患者姓名
    private String patientMobile; // 患者手机
    private String timeSlot;     // 预约时间
    private HealthProfessional doctor; // 预约的医生（父类）
    private String status;       // 预约状态（例如：Pending, Confirmed, Cancelled）

    // 默认构造函数
    public Appointment() {
        this.patientName = "";
        this.patientMobile = "";
        this.timeSlot = "";
        this.doctor = null;  // 默认为 null
        this.status = "Pending"; // 默认状态为 Pending
    }

    // 第二个构造函数，初始化所有实例变量
    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        if (patientName == null || patientName.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }
        if (patientMobile == null || !patientMobile.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid mobile number. Please enter a 10-digit number.");
        }
        if (timeSlot == null || !timeSlot.matches("\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Invalid time slot. Please use the format HH:mm.");
        }
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor cannot be null.");
        }

        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
        this.status = "Pending"; // 默认状态为 Pending
    }

    // 打印预约的所有信息
    public void printDetails() {
        System.out.println("Appointment Details:");
        System.out.println("Patient Name       : " + patientName);
        System.out.println("Patient Mobile     : " + patientMobile);
        System.out.println("Preferred Time Slot: " + timeSlot);
        System.out.println("Appointment Status : " + status);
        System.out.println("Doctor Details:");
        doctor.printDetails();  // 调用医生对象的 printDetails() 方法
        System.out.println("------------------------------");
    }

    // Getter 和 Setter 方法
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        if (patientName != null && !patientName.trim().isEmpty()) {
            this.patientName = patientName;
        } else {
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        if (patientMobile != null && patientMobile.matches("\\d{10}")) { // 手机号为10位数字
            this.patientMobile = patientMobile;
        } else {
            throw new IllegalArgumentException("Invalid mobile number. Please enter a 10-digit number.");
        }
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        if (timeSlot != null && timeSlot.matches("\\d{2}:\\d{2}")) { // 时间格式为 HH:mm
            this.timeSlot = timeSlot;
        } else {
            throw new IllegalArgumentException("Invalid time slot. Please use the format HH:mm.");
        }
    }

    public HealthProfessional getDoctor() {
        return doctor;
    }

    public void setDoctor(HealthProfessional doctor) {
        if (doctor != null) {
            this.doctor = doctor;
        } else {
            throw new IllegalArgumentException("Doctor cannot be null.");
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status.equals("Pending") || status.equals("Confirmed") || status.equals("Cancelled")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status. Valid values are: Pending, Confirmed, Cancelled.");
        }
    }

    // 检查是否与另一个预约冲突
    public boolean isConflictWith(Appointment another) {
        return this.timeSlot.equals(another.timeSlot) && this.doctor.equals(another.doctor);
    }
}
