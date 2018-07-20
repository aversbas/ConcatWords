import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by alexm on 19.07.2018.
 */
public class ConcatWords {
    public static void main(String[] args) {
        String arr[] = new String[] { "five","fivetwo","fourfive","fourfivetwo",
                "one","onefiveone","two","twofivefourone" };
        ArrayList<String> cwords = new ArrayList<String>();

        for ( int i = 0; i < arr.length; ++i ) {
            for ( int j = 0; j < arr.length; ++j ) {
                for ( int k = 0; k < arr.length; ++k ) {
                    if ( ( i != j && i != k && j != k) && ( arr[i].equals(arr[j] + arr[k]) || arr[i].equals(arr[k] + arr[j]) ) )
                        cwords.add(arr[i]);
                }
            }
        }

        if ( cwords.isEmpty() )
            System.out.println("Не найдено подходящих слов");
        else {
            Collections.sort(cwords, new Comparator<String>() {
                public int compare(String a, String b) {
                    return b.length() - a.length();
                }
            });
            System.out.println("Самое длинное составное слово: " + cwords.get(0));
        }
    }
}
