package 학생성적정렬하기;
//5명의 학생에 대해 이름과 성적을 입력 성적이 높은 사람 순으로 정렬하기
public class StudentGrade implements Comparable<StudentGrade>{
    String name;
    int grade;

    public StudentGrade(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(StudentGrade o) {
        if(this.grade >o.grade) return -1;
        else if(this.grade <o.grade) return 1;
        else {
            return this.name.compareTo(o.name);
            //return -1;
        }
    }
    public void printInfo(StudentGrade o){
        System.out.println("이름: "+o.name);
        System.out.println("성적: "+o.grade);
    }
    @Override
    public String toString(){
        return "이름: "+name+"성적: "+grade;
    }
}
