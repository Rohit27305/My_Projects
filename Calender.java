
import java.util.*;

public class Calender {
    public static void main(String[] args) {

        String Day[] = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
        String Month[] = { "JANAURY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER",
                "OCTOBER", "NOVEMBER", "DECEMBER" };

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a Year : ");
        int year = in.nextInt();
        System.out.print("Enter Month : ");
        int month = in.nextInt();

        int maxDay[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            maxDay[1] = 29;
        } else
            maxDay[1] = 28;

        System.out.println("MOTNTH : " + Month[month - 1]);
        if (month > 12 || month < 1) {
            System.out.println("\t\t----Invalid Choice----");
            return;
        }
        for (int i = 0; i < 7; i++) {
            System.out.print(Day[i] + "\t");
        }
        System.out.println();
        int d = 1, m = 1, y = 1, day = 1;
        while (true) {
            if (d == 1 && m == month && y == year) {
                break;
            }
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                maxDay[1] = 29;
            } else
                maxDay[1] = 28;
            d++;
            day++;
            if (d > maxDay[month - 1]) {
                d = 1;
                month++;
            }
            if (month > 12) {
                month = 1;
                y++;
            }
            if (day == 7) {
                day = 0;
            }
        }
        int sp = day - 1;
        for (int i = 0; i < sp; i++)
            System.out.print(" \t ");
        for (int i = 0; i < maxDay[month - 1]; i++) {
            if (((i + sp) % 7 == 0) || i == maxDay[month - 1])
                System.out.println("\n");
            System.out.print(" " + (i + 1) + "\t");

        }

    }
}
