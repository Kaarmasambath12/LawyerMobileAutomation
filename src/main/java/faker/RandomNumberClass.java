package faker;

import java.util.Random;

public class RandomNumberClass {
    Random random;
    int number;

    public String randomNumberWithLimit(String value){
        random = new Random();
        number = random.nextInt(Integer.parseInt(value));
        System.out.println("The random number is generated" + number);
        return value;
    }

    public String randomNumber(){
        random = new Random();
        number = random.nextInt();
        System.out.println("The random number is generated" + number);
        return (String.valueOf(Integer.parseInt(String.valueOf(number))));
    }
}
