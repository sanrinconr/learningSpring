import com.array.UtilsArray;
import com.radix.Radix;

public class Launcher {
    public static void main(String[] args) {
        int[] arr = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        arr = Radix.sort(arr);
        UtilsArray.printArray(arr);
    }
}
