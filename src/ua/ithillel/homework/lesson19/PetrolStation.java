package ua.ithillel.homework.lesson19;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PetrolStation implements Refuel {

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private int amount = 3000;


    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void doRefuel(int fuel) {
        long start = System.currentTimeMillis();
        Semaphore semaphore = new Semaphore(3);

        var t1 = new Thread(remainingFuel(fuel));
        var t2 = new Thread(remainingFuel(fuel));
        var t3 = new Thread(remainingFuel(fuel));

        try {
            TimeUnit.SECONDS.sleep((long) (3 + Math.random() * 7));
        } catch (InterruptedException e) {
            System.out.println("Error message: " + e.getMessage());
            throw new RuntimeException("There is problem in running thread in doRefuel method PetrolStation class");
        }

        t1.start();
        t2.start();
        t3.start();

        try {
            semaphore.acquire();
            t1.join();
            t2.join();
            t3.join();
            lock.writeLock().lock();
        } catch (InterruptedException e) {
            System.out.println("Error message: " + e.getMessage());
            throw new RuntimeException("There is problem in running thread in doRefuel method PetrolStation class");
        } finally {
            semaphore.release();
            lock.writeLock().unlock();
        }
        System.out.println("Final amount: " + getAmount());
        System.out.println("Time needed for refueling: " + (System.currentTimeMillis() - start) + " milliseconds");
    }

    private Runnable remainingFuel(int fuel) {
        return () -> {
            amount -= fuel;
            System.out.printf(
                    "Fuel left after refueling on dispenser # %s : %s %n",
                    Thread.currentThread().getName(),
                    amount);
        };
    }
}
