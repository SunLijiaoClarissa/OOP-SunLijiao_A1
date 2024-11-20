public class Appointment {
    private String patientName;  // Patient name
    private String patientMobile; // Patient mobile phone
    private String timeSlot;     // Appointment time
    private HealthProfessional doctor; // Doctor Appointments (Parent)
    private String status;       // Appointment status (e.g：Pending, Confirmed, Cancelled）

    // Default constructor
    public Appointment() {
        this.patientName = "";
        this.patientMobile = "";
        this.timeSlot = "";
        this.doctor = null;  // By default null
        this.status = "Pending"; // The default status is Pending
    }

    // The second constructor initializes all instance variables
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
        this.status = "Pending"; // The default status is Pending
    }

    //Print all the information for the appointment
    public void printDetails() {
        System.out.println("Appointment Details:");
        System.out.println("Patient Name       : " + patientName);
        System.out.println("Patient Mobile     : " + patientMobile);
        System.out.println("Preferred Time Slot: " + timeSlot);
        System.out.println("Appointment Status : " + status);
        System.out.println("Doctor Details:");
        doctor.printDetails();  // Call the printDetails() method of the doctor object
        System.out.println("------------------------------");
    }

    // Getter and Setter methods
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
        if (patientMobile != null && patientMobile.matches("\\d{10}")) { // The phone number is 10 digits
            this.patientMobile = patientMobile;
        } else {
            throw new IllegalArgumentException("Invalid mobile number. Please enter a 10-digit number.");
        }
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        if (timeSlot != null && timeSlot.matches("\\d{2}:\\d{2}")) { // Time format is HH:mm
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

    // Check for a conflict with another appointment
    public boolean isConflictWith(Appointment another) {
        return this.timeSlot.equals(another.timeSlot) && this.doctor.equals(another.doctor);
    }
}
