import java.util.ArrayList;

public class AssignmentOne {
    public static void main(String[] args) {
        // Part 3 – Using classes and objects
        System.out.println("// Part 3 - Using classes and objects");

        // 创建 3 个 General Practitioner 对象
        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr. John", "General Practitioner in Family Medicine", "dr.john@example.com", "Family Medicine");
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr. Emily", "General Practitioner in Pediatrics", "dr.emily@example.com", "Pediatrics");
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr. Chris", "General Practitioner in Dermatology", "dr.chris@example.com", "Dermatology");

        // 创建 2 个 Ophthalmologist 对象
        Ophthalmologist oph1 = new Ophthalmologist(4, "Dr. Lisa", "Ophthalmologist specializing in retina", "dr.lisa@example.com", "Retina Specialist");
        Ophthalmologist oph2 = new Ophthalmologist(5, "Dr. James", "Ophthalmologist specializing in cataracts", "dr.james@example.com", "Cataract Specialist");

        // 打印所有健康专业人员的详细信息
        System.out.println("------------------------------");
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

        // Part 3 – 创建预约
        System.out.println("// Part 3 - Creating appointments");

        Appointment appointment1 = new Appointment("Alice", "1234567890", "10:00", gp1);
        Appointment appointment2 = new Appointment("Bob", "9876543210", "14:30", oph1);

        // 打印预约详情
        System.out.println("------------------------------");
        appointment1.printDetails();
        System.out.println("------------------------------");
        appointment2.printDetails();
        System.out.println("------------------------------");

        // Part 5 – 使用集合管理预约
        System.out.println("// Part 5 - Collection of appointments");

        ArrayList<Appointment> appointmentList = new ArrayList<>();  // 创建一个 ArrayList 来存储预约

        // 添加预约
        createAppointment(appointmentList, "Charlie", "1112223333", "09:00", gp2);
        createAppointment(appointmentList, "David", "4445556666", "13:30", oph2);
        createAppointment(appointmentList, "Eve", "7778889990", "11:00", gp3);

        // 打印现有预约
        System.out.println("Existing Appointments:");
        printExistingAppointments(appointmentList);

        // 取消预约
        System.out.println("// Canceling appointment for Charlie");
        cancelBooking(appointmentList, "1112223333");

        // 打印更新后的预约列表
        System.out.println("Updated Appointments:");
        printExistingAppointments(appointmentList);
    }

    // 创建预约的方法
    public static void createAppointment(ArrayList<Appointment> appointmentList, String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        if (patientName != null && !patientName.isEmpty() && patientMobile != null && !patientMobile.isEmpty() && timeSlot != null && !timeSlot.isEmpty() && doctor != null) {
            Appointment newAppointment = new Appointment(patientName, patientMobile, timeSlot, doctor);
            appointmentList.add(newAppointment);
            System.out.println("Appointment created successfully for " + patientName + " at " + timeSlot);
        } else {
            System.out.println("Error: Missing required appointment information. Appointment not created.");
        }
    }

    // 打印现有预约的方法
    public static void printExistingAppointments(ArrayList<Appointment> appointmentList) {
        if (appointmentList.isEmpty()) {
            System.out.println("No existing appointments.");
        } else {
            for (Appointment appointment : appointmentList) {
                appointment.printDetails();
                System.out.println("------------------------------");
            }
        }
    }

    // 取消预约的方法
    public static void cancelBooking(ArrayList<Appointment> appointmentList, String patientMobile) {
        boolean found = false;
        for (Appointment appointment : appointmentList) {
            if (appointment.getPatientMobile().equals(patientMobile)) {
                appointmentList.remove(appointment);
                System.out.println("Appointment cancelled for patient with mobile: " + patientMobile);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Error: No appointment found for patient with mobile: " + patientMobile);
        }
    }
}

