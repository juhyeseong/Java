package summaryAbstract5;

public class Friend extends Human implements Companion {
	Friend(String name) {
		super(name);
	}

	@Override
	public String getName() {
		return name;
	}
}
