package halpers;

import org.lwjgl.Sys;

public class Clock {

	private static boolean paused = false;
	public static long LastFrame, totalTime;
	public static float d = 0, multiplier = 1;

	public static long getTime() {
		return Sys.getTime() * 1000 / Sys.getTimerResolution();
	}

	public static float getDelta() {
		long currentTime = getTime();
		int delta = (int) (currentTime - LastFrame);
		LastFrame = getTime();		
		if (delta * 0.01f > 0.5f)
			return 0.5f;
		return delta * 0.01f;
	}

	public static float Delta() {
		if (paused)
			return 0;
		else
			return d * multiplier;
	}

	public static float TotalTime() {
		return totalTime;
	}

	public static float Multiplier() {
		return multiplier;
	}

	public static void Update() {
		d = getDelta();
		totalTime += d;
	}

	public static void ChangeMultiplier(int change) {
		if (multiplier + change < -1 && multiplier + change > 7) {
		} else {
			multiplier += change;
		}
	}

	public static void Pause() {
		if (paused)
			paused = false;
		else
			paused = true;

	}
}
