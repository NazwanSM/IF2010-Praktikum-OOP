/**
 * DelayedOutput.java 
 * [Jelaskan kegunaan class ini]
 * @author 18223066 Nazwan Siddqi Muttaqin
 */
public class DelayedOutput {
    public static void printDelayed(int delayMillisec, String output) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delayMillisec);
                    System.out.println(output);
                } catch (InterruptedException e) {

                }
            }
        });
        t.start();
    }
}