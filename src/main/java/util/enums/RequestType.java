package util.enums;

public enum RequestType {
	INSERT("/insert", 1),
	UPDATE("/update", 2),
	DELETE("/delete", 3),
	SELECT("/list", 4),
	INSERTFORM("/new", 5),
	UPDATEFORM("/edit", 6);

	public String getUrl() {
		return url;
	}

	public int getValue() {
		return value;
	}

	public final String url;
	public final int value;
	
	private RequestType(String url, int value) {
		this.url = url;
		this.value = value;
	}
}
