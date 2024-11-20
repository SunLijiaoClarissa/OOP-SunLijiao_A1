public class GeneralPractitioner extends HealthProfessional {
    private String specialization;  // Professional field
    private int yearsOfExperience;  // Years of service

    // Default constructor
    public GeneralPractitioner() {
        super();
        this.specialization = "";
        this.yearsOfExperience = 0;
    }

    // Parameterized constructor
    public GeneralPractitioner(int id, String name, String info, String contactEmail, String specialization, int yearsOfExperience) {
        super(id, name, info, contactEmail);
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Getter and Setter
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

    // Print details
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Specialization     : " + specialization);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("------------------------------");
    }

    // Methods for updating areas of expertise
    public void updateSpecialization(String newSpecialization) {
        this.specialization = newSpecialization;
        System.out.println("Specialization updated to: " + newSpecialization);
    }
}


