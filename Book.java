

public class Book implements Measurable {
	
	private String author;
	private String title;
	private int pages;

	public Book(String auth, String titl, int pag) {
		author = auth;
		title = titl;
		pages = pag;
	}

	public int getPages() {
		return pages;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", pages=" + pages + "]\n";
	}

	@Override
	public int getMeasure() {
		return pages;
	}

}