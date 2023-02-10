package ua.ithillel.homework.lesson19;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PetrolStation implements Refuel {

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Semaphore semaphore = new Semaphore(3);
    private int amount;

    public PetrolStation(int amount) {
        this.amount = amount;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void doRefuel(int fuel) {
        long start = System.currentTimeMillis();
        try {
            semaphore.acquire();
            lock.writeLock().lock();
            if (amount < fuel) {
                System.out.println("Not enough fuel");
                return;
            }
            TimeUnit.SECONDS.sleep((long) (3 + Math.random() * 7));
            amount = amount - fuel;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
            semaphore.release();
            System.out.println("Final amount: " + getAmount());
            System.out.println("Time needed for refueling: " + (System.currentTimeMillis() - start) + " milliseconds");
        }
    }
}
