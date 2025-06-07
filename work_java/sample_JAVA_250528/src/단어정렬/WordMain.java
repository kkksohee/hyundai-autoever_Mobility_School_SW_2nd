package 단어정렬;

import java.util.Scanner;
import java.util.TreeSet;

public class WordMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Word> wd = new TreeSet<>(new AscendingComparator());
        int num=sc.nextInt();

        for(int i=0; i<num; i++){
            System.out.print("입력: ");
            wd.add(new Word(sc.next()));
        }
        System.out.println("----출력----");
        for(Word word : wd){
            System.out.println(word.word+ " ");
        }
    }
}
