package ua.ithillel.homework.lesson19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        PetrolStation fuelStation = new PetrolStation(3000);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(() -> fuelStation.doRefuel(100));
        executorService.submit(() -> fuelStation.doRefuel(50));
        executorService.submit(() -> fuelStation.doRefuel(300));
        executorService.submit(() -> fuelStation.doRefuel(120));
        executorService.submit(() -> fuelStation.doRefuel(180));
        executorService.submit(() -> fuelStation.doRefuel(200));

        executorService.shutdown();

        ThreadSafeList threadSafeList = new ThreadSafeList();
        threadSafeList.add("hallo");
        threadSafeList.add("world");
        threadSafeList.add("again");
        threadSafeList.remove(1);
        System.out.println(threadSafeList.get(1));

    }
}
