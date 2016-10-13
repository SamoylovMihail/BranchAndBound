
public class TimeInterval {

	private long timeMillisStart;
	private long timeMillisEnd;
	
	public void startTiming() {
		timeMillisStart = System.currentTimeMillis();
	}

	public void endTiming() {
		timeMillisEnd = System.currentTimeMillis();
	}

	public String getElapsedTime() {
		return Long.toString((timeMillisEnd - timeMillisStart) / 1000);
	}

}
