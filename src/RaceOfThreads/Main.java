package RaceOfThreads;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1'den 10000 (10 bin)'e kadar olan sayılardan oluşan bir ArrayList oluşturunuz.
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            numbers.add(i);
        }

        // 4 eşit parçaya ayırınuz.
        int chunkSize = 2500;
        List<List<Integer>> chunks = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i += chunkSize) {
            chunks.add(numbers.subList(i, Math.min(i + chunkSize, numbers.size())));
        }

        // 4 ayrı Thread tasarlayınız.
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        Runnable evenFinder = new NumberFinder(chunks.get(0), evenNumbers, true);
        Runnable oddFinder = new NumberFinder(chunks.get(1), oddNumbers, false);
        Runnable evenFinder2 = new NumberFinder(chunks.get(2), evenNumbers, true);
        Runnable oddFinder2 = new NumberFinder(chunks.get(3), oddNumbers, false);

        // Thread'leri oluşturup çalıştırın.
        Thread thread1 = new Thread(evenFinder);
        Thread thread2 = new Thread(oddFinder);
        Thread thread3 = new Thread(evenFinder2);
        Thread thread4 = new Thread(oddFinder2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Thread'lerin işini bitirmesini bekleyin.
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Sonuçları ekrana yazdırın.
        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Odd Numbers: " + oddNumbers);
    }
}
