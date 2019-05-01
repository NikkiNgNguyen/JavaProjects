/**
 *
 * @author NikkiNguyen 014682900
 */
import java.util.ArrayList;
public class Exam1 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        Student s1 = new UnderGrad("Billy", "Computer Engineering", 12);
        students.add(s1);
        Student s2 = new Graduate("Rose", "Biology", 14);
        students.add(s2);
        Student s3 = new PostGraduate("Rachel", "Computer Science", 19);
        students.add(s3);

        System.out.println(students.get(0));
        System.out.println("Tuition: $" + s1.calculateTuition(12));
        System.out.println(students.get(1));
        System.out.println("Tuition: $" + s2.calculateTuition(14));
        System.out.println(students.get(2));
        System.out.println("Tuition: $" + s3.calculateTuition(19));



    }

}
