package 날짜와시간;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

//LocalDate: 연월일(시간없음)
//LocalTime: 시,분,초,나노초(날짜없음)
//LocalDateTime: 날짜+시간(시간대없음
// -타임존없음(cmt)-지금사용 지역시간만)
//ZonedDateTime: 날짜+시간+시간대
public class DateMain {
    public static void main(String[] args) {
        //오늘 날짜
        LocalDate date = LocalDate.now();
        //현재 시간
        LocalTime time = LocalTime.now();
        //날짜 + 시간
        LocalDateTime dateTime = LocalDateTime.now();
        //시간대 포함
        ZonedDateTime zoned =ZonedDateTime.now();

        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println(zoned);

        Date now = new Date();
        System.out.println(now.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatted = sdf.format(now);
        System.out.println("포맷 적용 :"+formatted);

        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
        String formatted1= dateTime.format(formatter);
        System.out.println("포맷된 날짜: "+formatted1);
    }



}
