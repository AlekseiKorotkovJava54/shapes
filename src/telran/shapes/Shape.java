package telran.shapes;

public abstract class Shape {
	public long id;

	public Shape(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}
	protected abstract int square();
	protected abstract int perimeter();
}
