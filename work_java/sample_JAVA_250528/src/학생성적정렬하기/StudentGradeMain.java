package 학생성적정렬하기;

import java.util.TreeSet;

//5명의 학생에 대해 이름과 성적을 입력 성적이 높은 사람 순으로 정렬하기
public class StudentGradeMain {
    public static void main(String[] args) {
        TreeSet<StudentGrade> st = new TreeSet<>();
        st.add(new StudentGrade("안유진",100));
        st.add(new StudentGrade("장원영",90));
        st.add(new StudentGrade("차은우",84));
        st.add(new StudentGrade("박재범",97));
        st.add(new StudentGrade("한소희",71));

        for(StudentGrade std : st)
            //std.printInfo(std);
            System.out.println(std);
    }

}
