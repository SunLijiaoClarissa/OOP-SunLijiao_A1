import java.util.ArrayList;

public class AssignmentOne {
    public static void main(String[] args) {
// Part 3 – Using classes and objects
        // Part 3 – Using classes and objects
        System.out.println("// Part 3 - Using classes and objects");

        // 创建 3 个 General Practitioner 对象
        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr. John", "General Practitioner in Family Medicine", "dr.john@example.com", "Family Medicine", 10);
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr. Emily", "General Practitioner in Pediatrics", "dr.emily@example.com", "Pediatrics", 8);
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr. Chris", "General Practitioner in Dermatology", "dr.chris@example.com", "Dermatology", 12);

        // 创建 2 个 Ophthalmologist 对象
        Ophthalmologist oph1 = new Ophthalmologist(4, "Dr. Lisa", "Ophthalmologist specializing in retina", "dr.lisa@example.com", "Retina Specialist", "Downtown Clinic");
        Ophthalmologist oph2 = new Ophthalmologist(5, "Dr. James", "Ophthalmologist specializing in cataracts", "dr.james@example.com", "Cataract Specialist", "Uptown Clinic");

        // 打印所有健康专业人员的详细信息
        gp1.printDetails();
        System.out.println("------------------------------");
        gp2.printDetails();
        System.out.println("------------------------------");
        gp3.printDetails();
        System.out.println("------------------------------");
        oph1.printDetails();
        System.out.println("------------------------------");
        oph2.printDetails();
        System.out.println("------------------------------");
        
        // Part 5 – 使用集合管理预约
        System.out.println("// Part 5 - Collection of appointments");

        ArrayList<Appointment> appointmentList = new ArrayList<>(); // 创建一个 ArrayList 来存储预约

        // 添加 2 个全科医生的预约
        createAppointment(appointmentList, "Charlie", "1112223333", "09:00", gp1);
        createAppointment(appointmentList, "David", "4445556666", "13:30", gp2);

        // 添加 2 个眼科医生的预约
        createAppointment(appointmentList, "Eve", "7778889990", "11:00", oph1);
        createAppointment(appointmentList, "Frank", "9998887770", "15:00", oph2);

        // 打印现有预约
        System.out.println("Existing Appointments:");
        printExistingAppointments(appointmentList);

        // 取消预约
        System.out.println("// Canceling appointment for Charlie");
        cancelBooking(appointmentList, "1112223333", "09:00");

        // 打印更新后的预约列表
        System.out.println("Updated Appointments:");
        printExistingAppointments(appointmentList);
    }

    // 创建预约的方法
    public static void createAppointment(ArrayList<Appointment> appointmentList, String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        if (patientName == null || patientName.isEmpty()) {
            System.out.println("Error: Patient name cannot be empty.");
            return;
        }
        if (patientMobile == null || !patientMobile.matches("\\d{10}")) {
            System.out.println("Error: Invalid mobile number. Please enter a 10-digit number.");
            return;
        }
        if (timeSlot == null || !timeSlot.matches("\\d{2}:\\d{2}")) {
            System.out.println("Error: Invalid time slot. Please use the format HH:mm.");
            return;
        }
        if (doctor == null) {
            System.out.println("Error: Doctor cannot be null.");
            return;
        }

        // 检查预约冲突
        for (Appointment existing : appointmentList) {
            if (existing.isConflictWith(new Appointment(patientName, patientMobile, timeSlot, doctor))) {
                System.out.println("Error: Appointment conflict detected with another appointment.");
                return;
            }
        }

        // 创建并添加预约
        Appointment newAppointment = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointmentList.add(newAppointment);
        System.out.println("Appointment created successfully for " + patientName + " at " + timeSlot);
    }

    // 打印现有预约的方法
    public static void printExistingAppointments(ArrayList<Appointment> appointmentList) {
        if (appointmentList.isEmpty()) {
            System.out.println("No existing appointments.");
        } else {
            for (Appointment appointment : appointmentList) {
                appointment.printDetails();
            }
        }
    }

    // 取消预约的方法
    public static void cancelBooking(ArrayList<Appointment> appointmentList, String patientMobile, String appointmentTime) {
        boolean found = false;
        for (Appointment appointment : appointmentList) {
            // 使用患者手机号和预约时间来唯一确定预约
            if (appointment.getPatientMobile().equals(patientMobile) && appointment.getTimeSlot().equals(appointmentTime)) {
                appointment.setStatus("Cancelled");
                System.out.println("Appointment cancelled for patient with mobile: " + patientMobile + " at " + appointmentTime);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Error: No appointment found for patient with mobile: " + patientMobile + " at " + appointmentTime);
        }
    }
}
