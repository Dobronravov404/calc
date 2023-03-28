import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final Set<String> FIRST_NUMBERS = Set.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();
        System.out.println(calc(expression));
    }
    public static String calc(String input){
        String[] arrayExpression = input.split(" ");
        String firstNumber = arrayExpression[0];
        String secondNumber = arrayExpression[2];
        if (FIRST_NUMBERS.contains(firstNumber)) {
            return arab(Integer.parseInt(firstNumber), Integer.parseInt(secondNumber), arrayExpression);
        } else
            return rome(firstNumber, secondNumber, arrayExpression);
    }
    public static String arab (int numberOne, int numberTwo, String[] array) {
        String error = "error";
        if (array.length > 3 || Integer.parseInt(array[0])>10 || Integer.parseInt(array[2])>10) return error;
        int resultArab = 0;
        switch (array[1]){
            case "+", "-", "*", "/" ->
                resultArab = result(numberOne, numberTwo, array);

            default -> System.out.println("ErrorOne");
        }
        return Integer.toString(resultArab);
    }

    public static String rome (String numberOne, String numberTwo, String[] array) {
        String error = "error";
        String[] arrayRome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arrayRomeResult = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        int resultRome = 0;
        String romeNumberFirst = null;
        String romeNumberSecond = null;
        for (String s : arrayRome) {
            if (array[0].equals(s))
                romeNumberFirst = s;
            if (array[2].equals(s))
                romeNumberSecond = s;
        }
        for (int i = 0; i<arrayRome.length; i++){
            if (romeNumberFirst.equals(arrayRome[i])) {
                numberOne = String.valueOf(i + 1);
            }
            if (romeNumberSecond.equals(arrayRome[i])) {
                numberTwo = String.valueOf(i + 1);
            }
        }
        if (array.length > 3 || Integer.parseInt(numberOne)>10 || Integer.parseInt(numberTwo)>10) return error;


        switch (array[1]){
            case "+", "-", "*", "/" ->
                    resultRome = result(Integer.parseInt(numberOne), Integer.parseInt(numberTwo), array);

            default -> System.out.println("ErrorOne");
        }
        return arrayRomeResult[resultRome - 1];
    }
    public static int result(int numberOne, int numberTwo, String[] array) {
        return switch (array[1]) {
            case "+" -> numberOne + numberTwo;
            case "-" -> numberOne - numberTwo;
            case "*" -> numberOne * numberTwo;
            case "/" -> numberOne / numberTwo;

            default -> 0;
        };
    }
}