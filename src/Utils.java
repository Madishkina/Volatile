import java.util.concurrent.atomic.AtomicInteger;

public class Utils {

    public static AtomicInteger counter3 = new AtomicInteger();
    public static AtomicInteger counter4 = new AtomicInteger();
    public static AtomicInteger counter5 = new AtomicInteger();

    public static boolean isPolindrome(String text) {
        return text.equals(new StringBuilder(text).reverse().toString());
    }

    public static boolean isSomeChar(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(i - 1))
                return false;
        }
        return true;
    }

    public  static boolean isAscendingOrder (String text){
        for (int i=1; i< text.length(); i++){
            if(text.charAt(i)<text.charAt(i-1))
                return false;
        }
        return true;
    }

    public static void incrementCounter(int textlength){
        if(textlength == 3){
            counter3.getAndIncrement();
        }else if(textlength == 4){
            counter4.getAndIncrement();
        } else{
            counter5.getAndIncrement();
        }

    }

}


