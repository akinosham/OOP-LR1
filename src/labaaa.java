import java.io.*;
import java.util.*;
public class labaaa {
    public static void main(String[] args) throws IOException
{
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите путь к файлу:");
    String filePath = sc.nextLine();

    System.out.println("Введите позицию буквы (k):");
    int k = sc.nextInt();

    System.out.println("Введите символ для замены:");
    char a = sc.next().charAt(0);

    sc.close(); // Закрываем Scanner

    String text = readFile(filePath);
    if (text != null) {
        String text2 = replaceKthLetter(text, k, a);
        System.out.println("Измененный текст:\n" + text2);
    } else {
        System.out.println("Ошибка чтения файла.");
    }
}

    public static String readFile(String filePath) {
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            StringBuilder file_Text = new StringBuilder();
            while (fileScanner.hasNextLine()) {
                file_Text.append(fileScanner.nextLine()).append("\n");
            }
            return file_Text.toString();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
            return null; //Возвращаем null, если файл не найден
        }
    }

    public static String replaceKthLetter(String text, int k, char a) {
        //Этот метод остается без изменений
        String[] words = text.split("\\s+");
        StringBuilder text2 = new StringBuilder();
        for (String word : words) {
            if (word.length() >= k) {
                char[] wordChars = word.toCharArray();
                wordChars[k - 1] = a;
                word = new String(wordChars);
            }
            text2.append(word).append(" ");
        }
        return text2.toString().trim();
    }
}
