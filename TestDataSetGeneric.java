import org.junit.Test;
import static org.junit.Assert.*;

public class TestDataSetGeneric {
	
	// DataSetGeneric<Books> list of books by Stephen King plus 2 additional
	// "books" with zero and negative page numbers for sort testing purposes
	private RYODataSetGeneric<Book> king = new RYODataSetGeneric<Book>();
	private MyList<Book> sorted = new MyArrayList<>();
	private MyArrayList<Book> kingSorted;
	
	private Book petSematary = new Book("Stephen King", "Pet Sematary", 416);
	private Book salemsLot = new Book("Stephen King", "Salem's Lot", 672);
	private Book it = new Book("Stephen King", "It", 1138);
	private Book stand = new Book("Stephen King", "The Stand", 823);
	private Book carrie = new Book("Stephen King", "Carrie", 199);
	private Book shining = new Book("Stephen King", "The Shining", 447);
	private Book darkTower = new Book("Stephen King", "The Dark Tower", 224);
	private Book cujo = new Book("Stephen King", "Cujo", 319);
	private Book unknown = new Book("Stephen King", "Unknown", 0);
	private Book unwritten = new Book("Stephen King", "Unwritten", -300);
	

	@Test
	// testing merge sort for a DataSetGeneric<Book> list with only 2 values (minimum to sort)
	public void testSort1() {
		king.add(it);
		king.add(petSematary);
		sorted.add(petSematary);
		sorted.add(it);
		
		kingSorted = king.sort();
		
		for (int i = 0; i < kingSorted.size(); i++)
		    assertEquals(kingSorted.get(i), sorted.get(i));
	}
	
	@Test
	// testing merge sort for a DataSetGeneric<Book> list with 8 values (requiring more iterations)
	public void testSort2() {
		king.add(it);
		king.add(petSematary);
		king.add(shining);
		king.add(cujo);
		king.add(salemsLot);
		king.add(carrie);
		king.add(darkTower);
		king.add(stand);
		sorted.add(carrie);
		sorted.add(darkTower);
		sorted.add(cujo);
		sorted.add(petSematary);
		sorted.add(shining);
		sorted.add(salemsLot);
		sorted.add(stand);
		sorted.add(it);
		
		kingSorted = king.sort();
		
		for (int i = 0; i < kingSorted.size(); i++)
		    assertEquals(kingSorted.get(i), sorted.get(i));
	}

	@Test
	// testing merge sort for a DataSetGeneric<Book> list with an odd number of Books
	public void testSort3() {
		king.add(it);
		king.add(carrie);
		king.add(stand);
		king.add(salemsLot);
		king.add(cujo);
		sorted.add(carrie);
		sorted.add(cujo);
		sorted.add(salemsLot);
		sorted.add(stand);
		sorted.add(it);
		
		kingSorted = king.sort();
		
		for (int i = 0; i < kingSorted.size(); i++)
		    assertEquals(kingSorted.get(i), sorted.get(i));
		
	}
	
	@Test
	// testing merge sort for a DataSetGeneric<Book> list with a zero page value
	public void testSort4() {
		king.add(it);
		king.add(carrie);
		king.add(unknown); // 0 pages
		king.add(salemsLot);
		king.add(cujo);
		sorted.add(unknown);
		sorted.add(carrie);
		sorted.add(cujo);
		sorted.add(salemsLot);
		sorted.add(it);

		kingSorted = king.sort();
		
		for (int i = 0; i < kingSorted.size(); i++)
		    assertEquals(kingSorted.get(i), sorted.get(i));
		
	}
	
	@Test
	// testing merge sort for a DataSetGeneric<Book> list with a negative page value
	public void testSort5() {
		king.add(it);
		king.add(unwritten);
		king.add(carrie);
		king.add(salemsLot);
		king.add(cujo);
		sorted.add(unwritten);
		sorted.add(carrie);
		sorted.add(cujo);
		sorted.add(salemsLot);
		sorted.add(it);
		
		kingSorted = king.sort();
		
		for (int i = 0; i < kingSorted.size(); i++)
		    assertEquals(kingSorted.get(i), sorted.get(i));
		
	}

	@Test
	// testing merge sort for a DataSetGeneric<Book> list with a duplicate
	//book creating duplicate page values to sort
	public void testSort6() {
		king.add(it);
		king.add(carrie);
		king.add(carrie);
		king.add(salemsLot);
		king.add(cujo);
		sorted.add(carrie);
		sorted.add(carrie);
		sorted.add(cujo);
		sorted.add(salemsLot);
		sorted.add(it);

		kingSorted = king.sort();
		
		for (int i = 0; i < kingSorted.size(); i++)
		    assertEquals(kingSorted.get(i), sorted.get(i));
		
	}
	
	@Test
	// testing merge sort for a DataSetGeneric<Book> list with a descending insertion order
	public void testSort7() {
		king.add(it);
		king.add(salemsLot);
		king.add(cujo);
		king.add(darkTower);
		king.add(carrie);
		sorted.add(carrie);
		sorted.add(darkTower);
		sorted.add(cujo);
		sorted.add(salemsLot);
		sorted.add(it);

		kingSorted = king.sort();
		
		for (int i = 0; i < kingSorted.size(); i++)
		    assertEquals(kingSorted.get(i), sorted.get(i));
		
	}
	
	@Test
	// testing merge sort for a DataSetGeneric<Book> list with an ascending insertion order
	public void testSort8() {
		king.add(carrie);
		king.add(darkTower);
		king.add(cujo);
		king.add(salemsLot);
		king.add(it);
		sorted.add(carrie);
		sorted.add(darkTower);
		sorted.add(cujo);
		sorted.add(salemsLot);
		sorted.add(it);
		
		kingSorted = king.sort();
		
		for (int i = 0; i < kingSorted.size(); i++)
		    assertEquals(kingSorted.get(i), sorted.get(i));
		
	}
	
	@Test
	// testing merge sort for an empty DataSetGeneric<Book> list
	public void testSort9() {
		
		kingSorted = king.sort();
		
		for (int i = 0; i < kingSorted.size(); i++)
		    assertEquals(kingSorted.get(i), sorted.get(i));
	}
	
	@Test
	// testing merge sort for a DataSetGeneric<Book> list with one entry
	public void testSort10() {
		king.add(it);
		sorted.add(it);
		
		kingSorted = king.sort();
		
		for (int i = 0; i < kingSorted.size(); i++)
		    assertEquals(kingSorted.get(i), sorted.get(i));
	
	}
	
}