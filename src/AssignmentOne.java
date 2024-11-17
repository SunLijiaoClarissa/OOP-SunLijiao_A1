public class AssignmentOne {
    public static void main(String[] args) {
        // 创建一个普通医生实例
        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr. John", "General Practitioner", "dr.john@example.com", "Internal Medicine");
        // 创建一个眼科医生实例
        Ophthalmologist oph1 = new Ophthalmologist(2, "Dr. Lisa", "Ophthalmologist", "dr.lisa@example.com", "Fellow of Royal Australian College of Ophthalmologists");

        // 打印医生的详细信息
        gp1.printDetails();
        oph1.printDetails();
    }
}
