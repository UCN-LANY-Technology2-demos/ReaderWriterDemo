
public class ReaderWriterDemo {

	public static void main(String[] args) {

		SharedData example = new SharedData();
		Thread[] workers = new Thread[12];

		// Creating reader threads
		for (int i = 0; i < 5; i++) {
			workers[i] = new Thread(() -> example.read());
		}

		// Creating writer threads
		workers[5] = new Thread(() -> example.write("The rain in Spain "));
		workers[6] = new Thread(() -> example.write("falls mainly on the plain. "));

		// Creating more reader threads
		for (int i = 7; i < 12; i++) {
			workers[i] = new Thread(() -> example.read());
		}

		for (Thread thread : workers) {
			thread.start();
		}
	}
}
