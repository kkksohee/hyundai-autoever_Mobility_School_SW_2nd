package 단어정렬;

import java.util.Comparator;

public class AscendingComparator implements Comparator<Word> {
    //꼭 1, -1 아니여도 되고 양수, 음수여도 됨.
    @Override
    public int compare(Word o1, Word o2) {
        if(o1.word.length()> o2.word.length()){
            return 1;
        }else if(o1.word.length()== o2.word.length()){
            return o1.word.compareTo(o2.word);
        }else if(o1.word.equals(o2.word)) return 0;
        else return -1;
    }
}
