import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedData {
	
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private String sharedData = "";

    // Method for readers
    public void read() {
        readWriteLock.readLock().lock();
        try {
            System.out.println("Reading value: " + sharedData);
            // Simulate read operation
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    // Method for writers
    public void write(String value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println("Writing value: " + value);
            sharedData += value;
            // Simulate write operation
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
