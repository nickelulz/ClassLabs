public class ThingCount implements Comparable<ThingCount>
{
	private int count;
	private Object thing;
	
	public ThingCount() {}

	public ThingCount(Object thang, int cnt) {
		this.thing = thang;
		this.count = cnt;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int cnt) {
		this.count = cnt;
	}

	public void setThing(Object obj) {
		this.thing = obj;
	}
	
	public Object getThing() {
		return thing;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ThingCount))
			return false;
		ThingCount other = (ThingCount) obj;
		return this.count == other.count && this.thing.equals(other.thing);
	}
	
	@Override
	public int compareTo(ThingCount other) {
		return this.count - other.count;
	}
	
	@Override
	public String toString() {
		return ""+ getThing() + " - " + getCount();
	}
}