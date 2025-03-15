package dsaa.lab02;

public class Link{
	public String ref;
	public Link(String ref) {
		this.ref=ref;
	}
	// in the future there will be more fields

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Link)) {
			return false;
		}

		Link that = (Link) other;

		// Custom equality check here.
		return this.ref.equals(that.ref);
	}

}
