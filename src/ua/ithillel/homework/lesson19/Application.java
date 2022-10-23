package ua.ithillel.homework.lesson19;

public class Application {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation();
        petrolStation.doRefuel(800);

        ThreadSafeList threadSafeList = new ThreadSafeList();
        threadSafeList.add("hallo");
        threadSafeList.add("world");
        threadSafeList.add("again");
        threadSafeList.remove(1);
        System.out.println(threadSafeList.get(1));

    }
}
