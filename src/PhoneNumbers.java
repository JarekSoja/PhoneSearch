
import java.util.ArrayList;
import java.util.List;

public class PhoneNumbers {

    private List<String> numbers;

    public PhoneNumbers() {
        this.numbers = new ArrayList();
    }

    public void addNumber(String number) {
        if (!this.numbers.contains(number)){
        this.numbers.add(number);
        }
    }
    
    public List<String> getNumbers() {
        return this.numbers;
    }

    public void removeNumbers() {
        this.numbers.clear();
    }
}