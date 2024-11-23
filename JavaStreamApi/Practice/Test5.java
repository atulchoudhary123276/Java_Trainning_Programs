package JavaStreamApi.Practice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Test5 {
    String name="atul";
    public static void main(String[] args) {
//        System.out.println("1.1"+new BigDecimal(-1.1).setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.2"+new BigDecimal(-1.2).setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.3"+new BigDecimal(-1.3).setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.4"+new BigDecimal(-1.4).setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.5"+new BigDecimal(-1.5).setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.6"+new BigDecimal(-1.6).setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.7"+new BigDecimal(-1.7).setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.8"+new BigDecimal(-1.8).setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.9"+new BigDecimal(-1.9).setScale(4, BigDecimal.ROUND_CEILING));
//
//        System.out.println("----------------------");
//        System.out.println("1.1" + new BigDecimal("-1.599999999999").setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.kjhjk" + new BigDecimal(-1.599999999999).setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.2" + new BigDecimal("-1.8757879072").setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.3" + new BigDecimal("-1.3").setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.4" + new BigDecimal("-1.4").setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.5" + new BigDecimal("-1.5").setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.6" + new BigDecimal("-1.6").setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.7" + new BigDecimal("-1.7").setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.8" + new BigDecimal("-1.8").setScale(4, BigDecimal.ROUND_CEILING));
//        System.out.println("1.9" + new BigDecimal("-1.9").setScale(4, BigDecimal.ROUND_CEILING));
//
//        System.out.println(BigDecimal.valueOf(3000.5).setScale(2, RoundingMode.HALF_UP));
//

//             Test5 t=new Test5();
//        System.out.println(Optional.ofNullable(t.name).map(s -> s+"kumar").orElse("na"));
//        System.out.println(Optional.ofNullable(t.name).orElse("aaa"));
//        List<Stu> list= List.of(new Stu(){{setId(1);
//        setName("atul");}},new Stu(){{setId(2);setName("shivam");}},new Stu(){{setId(3);}});
//        Map<Integer, String> collect = list.stream()
//                .collect(Collectors.toMap(Stu::getId, Stu::getName));
//        System.out.println(collect);

//        BigDecimal a= BigDecimal.valueOf(0d);
//        a=BigDecimal.valueOf(Double.parseDouble("text"));
//        if (null == a || !(a instanceof BigDecimal)) {
//            System.out.println("Invalid amount or type");
//        }

//        System.out.println(formatAmount(BigDecimal.valueOf(2000)));
//        BigDecimal bigDecimal = new BigDecimal("0.0000");
//        System.out.println(String.valueOf(bigDecimal));


//        String text = "This - text ! has \\ /allot # of % special % characters 12121";
//        text = text.replaceAll("[^a-zA-Z0-9]", "");
//        System.out.println(text);

        LocalDateTime now1 = LocalDateTime.now();
        Timestamp now2=Timestamp.valueOf(now1);

        Timestamp now = Timestamp.valueOf(now1.minusMinutes(1439));
        System.out.println("now time "+now2);
        System.out.println("after cooling period minus"+now);
        Timestamp createDateTime = Timestamp.valueOf(now1.minusMinutes(2));
//        Timestamp createDateTime = Timestamp.valueOf("2024-09-09 15:52:08");
        if (createDateTime.after(now)) {
            Duration between = Duration.between(now.toLocalDateTime(), createDateTime.toLocalDateTime());
            System.out.println("duration "+between.toMinutes());
            long hours = between.toHours() % 24;
            long minutes = between.toMinutes() % 60;
            long seconds = between.getSeconds() % 60;

            String readableDuration = String.format("%d hours, %d minutes, %d seconds",
                    hours, minutes, seconds);

            System.out.println(readableDuration);
            String readableDuration1 = between.toHours() % 24 +" hours,"+between.toMinutes() % 60 +" minutes,"+between.getSeconds() % 60+" seconds";
            System.out.println(readableDuration1);

            Long hrs=between.toHours() % 24;
            Long min=between.toMinutes() % 60;
            Long sec=between.getSeconds() % 60;
            StringBuilder st=new StringBuilder("Please try again after ");
            if (hrs >0) {
                st.append(hrs +" hours ");
            }
            if (min>0){
                st.append(",");
                st.append(min +" minutes ");
            }
            if (sec>0) {
                st.append(",");
                st.append(sec+" seconds ");

            }


            System.out.println(st.toString());





////            String input = "BLACKJACK:INITBET;5\\1";
//            String input = "BLACKJACK:sideBet21p3;5\\1";
////
//            if (input.length() > 30) {
//                input = input.substring(0, 30);
//            }
//            input=input.replace("INITBET","WIN");
//            input=input.replace("sideBet21p3","SIDE_BET__WIN");
//            input=input.replace("sideBetPpair","SIDE_BET__WIN");
//            System.out.println(input.length());
//            // Find the index of the semicolon and extract the part after it
////            int i = ;
//            int i1 = input.lastIndexOf(':') + 1;
//            String extracted =input.substring(0,input.lastIndexOf(';') +4);
//            if (input.contains("SIDE_BE")){
//                System.out.println("order fetching start");
//            }
//                    extracted=extracted.substring(i,i+3);
//            String extracted1  = input.substring(input.lastIndexOf(':') + 1, input.lastIndexOf(';') + 1 + 3);

//
//            System.out.println(extracted);  // Output: 5\1
////            System.out.println(extracted1);  // Output: 5\1
//
//
//            // Check if all strings in the list are the same
////            boolean allSame = strings.stream()
////                    .allMatch(s -> s.equals("hello1"));
////
////            System.out.println("Are all strings the same? " + allSame); // Output: true
//
//
//
//            System.out.println((int)4000.0d);
//
//
//            // String in dd/MM/yyyy format
//            String dateString = "11/09/2024";
//
//            try {
//                // Define the input format
//                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
//
//                // Parse the String into java.util.Date
//                java.util.Date parsedDate = dateFormat.parse(dateString);
//
//                // Convert java.util.Date to java.sql.Date
//                Date sqlDate = new Date(parsedDate.getTime());
//
//                // Output the result
//                System.out.println("SQL Date: " + sqlDate);
//            } catch (ParseException e) {
//                e.printStackTrace(); // Handle the exception if the string is in an invalid format
//            }

//            BigDecimal payout = null;
//            BigDecimal bal= BigDecimal.valueOf(10.0);
//            System.out.println(payout.add(bal));
            String url="";
            String host="https://cdnet-launch.apac.spribegaming.com/{game}";

            url = host.replace("dev-test.spribe.io/games", "demo.spribe.io").replace("{game}", "aviator" + "?");
            url = url.replace("cdnet-launch.apac.spribegaming.com", "demo.spribe.io/launch");
            System.out.println(url);
            Set<Long> userIds = new HashSet<>();
//            userIds=null;
            userIds.add(null);
            System.out.println(userIds);


            int a=0123;
            System.out.println();
        }
    }
    private  static BigDecimal formatAmount(BigDecimal amount) {
        // Check if the amount is a whole number
        if (amount.stripTrailingZeros().scale() <= 0) {
            return amount.setScale(0, RoundingMode.UNNECESSARY); // No scaling needed
        } else {
            return amount.setScale(2, RoundingMode.HALF_UP); // Scale to 2 decimal places
        }
    }
}

class Stu{

    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
interface R{
    Stu s = new Stu();


}