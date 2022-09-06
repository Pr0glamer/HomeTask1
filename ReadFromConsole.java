import java.util.Scanner;

public class ReadFromConsole {

    public static void main(String[] args) {

        System.out.println("Enter some text");

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String s = scanner.nextLine();
        sb.append(s);
        while (!s.equals("")) {
            s = scanner.nextLine();
            sb.append(s);
        }

        System.out.println(sb.toString());


    }



}
