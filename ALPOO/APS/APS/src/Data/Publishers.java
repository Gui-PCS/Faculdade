package Data;
public class Publishers {
	
	private int publisher_id;
	private String name;
	private String URL;
	
	public Publishers(int publisher_id, String name, String uRL) {
		this.publisher_id = publisher_id;
		this.name = name;
		this.URL = uRL;
	}

	public int getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getURL() {
		return this.URL;
	}

	public void setURL(String uRL) {
		this.URL = uRL;
	}

	@Override
	public String toString() {
		return "Publishers [publisher_id=" + publisher_id + ", name=" + name + ", URL=" + URL + "]";
	}

}