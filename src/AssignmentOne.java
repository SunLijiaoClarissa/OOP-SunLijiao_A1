import java.util.ArrayList;

public class AssignmentOne {
    public static void main(String[] args) {
// Part 3 – Using classes and objects
        // Part 3 – Using classes and objects
        System.out.println("// Part 3 - Using classes and objects");

        // Create three General Practitioner objects
        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr. Luhaiou", "General Practitioner in Cardiovascular Chronic Diseases", "dr.Luhaiou@example.com", "Cardiovascular Chronic Diseases", 10);
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr. liqihua", "General Practitioner in Common disease", "dr.Liqihua@qq.com", "Common disease", 8);
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr. Xiaolihong", "General Practitioner in Internal secretion", "dr.Xiaolihong@qq.com", "Master's degree in Endocrinology", 12);

        // Create 2 Ophthalmologist objects
        Ophthalmologist oph1 = new Ophthalmologist(4, "Dr. Shennian", "Ophthalmologist specializing in Internal glaucoma, cataracts", "dr.Shennian@qq.com", "Internal glaucoma, cataracts", "Ophthalmic clinic 201");
        Ophthalmologist oph2 = new Ophthalmologist(5, "Dr. Qinlao", "Ophthalmologist specializing in Myopia correction", "dr.Qinlao@qq.com", "Myopia correction", "Ophthalmic optometry clinic 303");

        // Print details for all health professionals
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
        

        // Demonstrate polymorphism
    System.out.println("// Demonstrating Polymorphism");

    // Creates an array of type HealthProfessional to store GeneralPractitioner and Ophthalmologist objects
    HealthProfessional[] professionals = {gp1, gp2, gp3, oph1, oph2};

    // The printDetails method is called using the for-each loop
    for (HealthProfessional professional : professionals) {
        professional.printDetails();
        System.out.println("------------------------------");
    }


        // Part 5 – Use collections to manage appointments
        System.out.println("// Part 5 - Collection of appointments");

        ArrayList<Appointment> appointmentList = new ArrayList<>(); // Create an ArrayList to store the reservation

        // Add 2 GP appointments
        createAppointment(appointmentList, "Yuehao", "1325487541", "09:00", gp1);
        createAppointment(appointmentList, "Pengyi", "1645879642", "14:30", gp2);

        // Add 2 eye doctor appointments
        createAppointment(appointmentList, "Shijie", "1346572659", "10:30", oph1);
        createAppointment(appointmentList, "Sunli", "1542921624", "15:00", oph2);

        // Print existing appointment
        System.out.println("Existing Appointments:");
        printExistingAppointments(appointmentList);

        // Cancel an appointment
        System.out.println("// Canceling appointment for Yuehao");
        cancelBooking(appointmentList, "1325487541", "09:00");

        // Print the updated appointment list
        System.out.println("Updated Appointments:");
        printExistingAppointments(appointmentList);
    }

    // How to create an appointment
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

        //Check appointment conflict
        for (Appointment existing : appointmentList) {
            if (existing.isConflictWith(new Appointment(patientName, patientMobile, timeSlot, doctor))) {
                System.out.println("Error: Appointment conflict detected with another appointment.");
                return;
            }
        }

        // Create and add an appointment
        Appointment newAppointment = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointmentList.add(newAppointment);
        System.out.println("Appointment created successfully for " + patientName + " at " + timeSlot);
    }

    // A way to print an existing appointment
    public static void printExistingAppointments(ArrayList<Appointment> appointmentList) {
        if (appointmentList.isEmpty()) {
            System.out.println("No existing appointments.");
        } else {
            for (Appointment appointment : appointmentList) {
                appointment.printDetails();
            }
        }
    }

    // How to cancel an appointment
    public static void cancelBooking(ArrayList<Appointment> appointmentList, String patientMobile, String appointmentTime) {
        boolean found = false;
        for (Appointment appointment : appointmentList) {
            // Use the patient's mobile phone number and appointment time to uniquely confirm the appointment
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
