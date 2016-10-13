
public class TimeInterval {

	private long timeMillisStart;
	
	public void startTiming() {
		timeMillisStart = System.currentTimeMillis();
	}

	/* only for theft code compatibility */
	public void endTiming() {}

	public String getElapsedTime() {
		return Long.toString((System.currentTimeMillis() - timeMillisStart) / 1000);
	}

}
