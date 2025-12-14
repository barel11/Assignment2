package race;

public class Racer implements Runnable {

	private static int globalId = 1;
	private int id;
	private int speed; // 1 - 10
	private Track track;

	public Racer(int speed, Track track) {
		if (speed >= 1 && speed <= 10) {
			this.speed = speed;
		} else {
			System.err.println("Error: Speed must be between 1 and 10. Defaulting to 1.");
			this.speed = 1;
		}
		this.track = track;
		this.id = globalId;
		globalId++;
	}
	public void go() {
		Thread.currentThread().setPriority(this.speed);
		for (int i = 1; i < 100; i++) {
			System.out.println("Runner " + this.id + " ran " + i + " meters");
		}
		synchronized (this.track) {
			this.track.finishedRacers++;
			int place = this.track.finishedRacers;
			String suffix;
			if (place == 1) {
				suffix = "st";
			} else if (place == 2) {
				suffix = "nd";
			} else if (place == 3) {
				suffix = "rd";
			} else {
				suffix = "th";
			}
			System.out.println("Runner " + this.id + " finished " + place + suffix);
		}
	}

	public void run() {
		go();
	}
}
