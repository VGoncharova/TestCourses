package filter_text;

import java.util.List;

public class Filter {
    private String[] arguments;

    public Filter(String[] arguments) {
        this.arguments = arguments;
    }

    public void search(List<String> inputtedString) {
        for (String eachString : inputtedString) {
            for (String argument : arguments) {
                if (eachString.toLowerCase().contains(argument.toLowerCase())) {
                    System.out.println(eachString);
                    //Чтобы не выводить повторно строку, если один из агрументов уже найден и строка выведена
                    break;
                }
            }
        }
    }
}
