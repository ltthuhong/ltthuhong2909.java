
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    static String[] oneDimention;
    static String[][] twoDimention;
    static int typeArray;

    // print one dimention
    public static String printArray(String[] array) {
        String tmp = "[";
        for (int i = 0; i < array.length - 1; i++) {
            tmp += array[i] + ",";
        }
        tmp += array[array.length - 1];
        tmp += "]";
        return tmp;
    }

    // print two dimention
    public static String printArray(String[][] array) {
        String tmp = "[";
        for (String[] string : array) {
            tmp += printArray(string);
        }
        tmp += "]";
        return tmp;
    }

    // load data if have
    public static String dataLoader(String kw) {
        String pattern = "_getData*";
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(kw);
        if (!matcher.find()) {
            return kw;
        } else {
            if (typeArray == 1) {
                int frequencyOfArrayCharacter = Collections.frequency(Arrays.asList(kw.split("")), "[");
                if (frequencyOfArrayCharacter != 1) {
                    return "This is a one dimention, please input keyword for one dimention";
                } else {
                    int position = Integer.parseInt(kw.substring(11, 12));
                    if (position >= oneDimention.length) {
                        return "Out of length array one dimention";
                    } else {
                        return oneDimention[position];
                    }
                }
            } else if (typeArray == 2) {
                int frequencyOfArrayCharacter = Collections.frequency(Arrays.asList(kw.split("")), "[");
                if (frequencyOfArrayCharacter != 2) {
                    return "This is a two dimention, please input keyword for two dimention";
                } else {
                    int positionRow = Integer.parseInt(kw.substring(11, 12));
                    int positionColumn = Integer.parseInt(kw.substring(14, 15));
                    if (positionRow >= twoDimention.length || positionColumn >= twoDimention[0].length) {
                        return "Out of length array two dimention";
                    } else {
                        return twoDimention[positionRow][positionColumn];
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Scanner sc = new Scanner(System.in);
        System.out.println("type: ");
        typeArray = sc.nextInt();
        System.out.println("size: ");
        int size = 0;
        int sizeRow = 0;
        int sizeColumn = 0;
        if (typeArray == 1) {
            size = sc.nextInt();
        } else if (typeArray == 2) {
            sizeRow = sc.nextInt();
            sizeColumn = sc.nextInt();
        }
        System.out.println("element: ");
        if (typeArray == 1) {
            // array 1 dimention
            oneDimention = new String[size];
            for (int i = 0; i < size; i++) {
                oneDimention[i] = sc.next();
            }
            System.out.println("Your array: " + printArray(oneDimention));
        } else if (typeArray == 2) {
            // array 2 dimention
            twoDimention = new String[sizeRow][sizeColumn];
            for (int i = 0; i < sizeRow; i++) {
                for (int j = 0; j < sizeColumn; j++) {
                    twoDimention[i][j] = sc.next();
                }
            }
            System.out.println("Your array: " + printArray(twoDimention));
        }
        System.out.println("Input keyword: ");
        System.out.println(dataLoader("${_getData[1][2]}"));

    }
}
