import java.awt.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("Enter the type of the message(1 - long / 2 - spam): ");
        int msgType = sc.nextInt();

        System.out.println("Enter the message: ");
        String msg = sc2.nextLine();

        System.out.println("Enter the number of messages: ");
        int numberOfMessages = sc.nextInt();

        char[] arr = msg.toCharArray();
        int key;
        int keycode;
        keycode = arr[1];
        System.out.println(keycode);
        Robot robot = new Robot();
        System.out.println("Waiting...");
        Thread.sleep(2500);
        if(msgType == 1)
        {
            //long message
            int counter = 0;
            while (counter < numberOfMessages) {
                for (char c : arr) {
                    key = c;
                    if (key != 32)
                        keycode = key - 32;
                    else
                        keycode = key;
                    robot.keyPress(keycode);
                    robot.keyRelease(keycode);
                }
                robot.keyPress(32);
                robot.keyRelease(32);//space
                counter++;
            }
        }else{
            //spam
            for(int counter=0;counter<numberOfMessages;counter++)
            {
                for (char c : arr) {
                    key = c;
                    if (key != 32)
                        keycode = key - 32;
                    else
                        keycode = key;
                    robot.keyPress(keycode);
                    robot.keyRelease(keycode);
                }
                robot.keyPress(10);
                robot.keyRelease(10);//enter
                Thread.sleep(500);
            }
        }


    }
}
