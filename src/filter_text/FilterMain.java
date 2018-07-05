package filter_text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterMain {
    public static void main(String[] args) {
        List<String> inputtedString = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите текст, в котором необходимо найти агрумент");
        //В цикле находим все введенные строки
        while (true) {
            String currentTemplate = scan.nextLine();
            //Если находим пустую строку, выходим из цикла
            if (currentTemplate.isEmpty()) {
                break;
            }
            //Добавляем строку в список
            inputtedString.add(currentTemplate);
        }
        System.out.println("Строки, которые содержат переданный агрумент:");
        Filter currentFilter = new Filter(args);
        currentFilter.search(inputtedString);
    }
}
