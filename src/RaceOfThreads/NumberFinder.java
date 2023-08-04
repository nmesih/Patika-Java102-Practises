package RaceOfThreads;

import java.util.List;

public class NumberFinder implements Runnable{

    private final List<Integer> numbers;
    private final List<Integer> result;
    private final boolean findEven;

    public NumberFinder(List<Integer> numbers, List<Integer> result, boolean findEven) {
        this.numbers = numbers;
        this.result = result;
        this.findEven = findEven;
    }

    @Override
    public void run() {
        for (Integer number : numbers) {
            if ((number % 2 == 0 && findEven) || (number % 2 != 0 && !findEven)) {
                synchronized (result) {
                    result.add(number);
                }
            }
        }
    }
}
