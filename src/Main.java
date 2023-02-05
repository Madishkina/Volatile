import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        Thread polindrome = new Thread(() ->
        {
            for (String text : texts) {
                if (Utils.isPolindrome(text) && Utils.isSomeChar(text)) {
                    Utils.incrementCounter(texts.length);

                }
            }
        });
        polindrome.start();


        Thread someChar = new Thread(() -> {
            for (String text : texts) {
                if (!Utils.isSomeChar(text) && Utils.isAscendingOrder(text)) {
                    Utils.incrementCounter (text.length());
                }
            }
        });
        someChar.start();

        Thread ascedingOrder = new Thread(() -> {
            for (String text: texts) {
                if(Utils.isSomeChar(text) && Utils.isAscendingOrder(text)){
                    Utils.incrementCounter(texts.length);
                }
            }
        });
        ascedingOrder.start();

        someChar.join();
        ascedingOrder.join();
        polindrome.join();

        System.out.println("Красивых слов с длиной 3: "+ Utils.counter3);
        System.out.println("Красивых слов с длиной 4: "+ Utils.counter4);
        System.out.println("Красивых слов с длиной 5: "+ Utils.counter5);
    }

        public static String generateText (String letters,int length){
            Random random = new Random();
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < length; i++) {
                text.append(letters.charAt(random.nextInt(letters.length())));
            }
            return text.toString();
        }


}