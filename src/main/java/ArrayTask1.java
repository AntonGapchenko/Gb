

public class ArrayTask1 {

    public static boolean checkArrayForOneAndFour(int[] arr) {
        boolean hasOne = false;
        boolean hasFour = false;
        for (int number : arr) {
            if (number == 1) {
                hasOne = true;
            } else if (number == 4) {
                hasFour = true;
            } else {
                return false;
            }

        }
        return hasOne && hasFour;
    }


}
