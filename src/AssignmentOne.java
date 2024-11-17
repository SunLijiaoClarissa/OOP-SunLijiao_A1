public class AssignmentOne {
    public static void main(String[] args) {
        // Part 3 – Using classes and objects
        
        // 创建 3 个普通医生（GeneralPractitioner）对象
        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr. John", "General Practitioner in Family Medicine", "dr.john@example.com", "Family Medicine");
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr. Sarah", "General Practitioner in Internal Medicine", "dr.sarah@example.com", "Internal Medicine");
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr. Mike", "General Practitioner in Pediatrics", "dr.mike@example.com", "Pediatrics");

        // 创建 2 个眼科医生（Ophthalmologist）对象
        Ophthalmologist oph1 = new Ophthalmologist(4, "Dr. Lisa", "Ophthalmologist specializing in retina", "dr.lisa@example.com", "Fellow of Royal Australian College of Ophthalmologists");
        Ophthalmologist oph2 = new Ophthalmologist(5, "Dr. Ahmed", "Ophthalmologist specializing in corneal diseases", "dr.ahmed@example.com", "Specialist in Corneal Diseases");

        // 打印普通医生的详细信息
        System.out.println("General Practitioner Details:");
        gp1.printDetails();
        System.out.println("------------------------------");
        gp2.printDetails();
        System.out.println("------------------------------");
        gp3.printDetails();
        System.out.println("------------------------------");

        // 打印眼科医生的详细信息
        System.out.println("Ophthalmologist Details:");
        oph1.printDetails();
        System.out.println("------------------------------");
        oph2.printDetails();
        System.out.println("------------------------------");
    }
}
