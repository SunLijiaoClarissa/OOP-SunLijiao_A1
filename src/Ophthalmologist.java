public class Ophthalmologist extends HealthProfessional {
    private String qualification;   // Qualification certificate
    private String clinicLocation;  // Clinic location

    // Default constructor
    public Ophthalmologist() {
        super();
        this.qualification = "";
        this.clinicLocation = "";
    }

    // Parameterized constructor
    public Ophthalmologist(int id, String name, String info, String contactEmail, String qualification, String clinicLocation) {
        super(id, name, info, contactEmail);
        this.qualification = qualification;
        this.clinicLocation = clinicLocation;
    }

    // Getter and Setter
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

    // Determine whether to work in a particular location
    public boolean isWorkingAt(String location) {
        return clinicLocation.equals(location);
    }

    // Print details
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Qualification  : " + qualification);
        System.out.println("Clinic Location: " + clinicLocation);
        System.out.println("------------------------------");
    }
}
