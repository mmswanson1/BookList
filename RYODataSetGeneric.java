
public class RYODataSetGeneric<E extends Measurable> extends MyArrayList<E> {
	
	public E getMin() {
		if (this.isEmpty()) return null;
		E rv = get(0);
		for (E ele: this) {
			if (ele.getMeasure() < rv.getMeasure()) rv = ele;
		}
		return rv;
	}	
	
	public E getMax() {
		if (this.isEmpty()) return null;
		E rv = get(0);
		for (E ele: this) {
			if (ele.getMeasure() > rv.getMeasure()) rv = ele;
		}
		return rv;
	}
	
	public MyArrayList<E> sort() {
		MyArrayList<E> list = new MyArrayList<E>();
		list = this;
		return sort(list);
	}
	
	public MyArrayList<E> sort(MyArrayList<E> list) {
		// base case:  list of 1 is sorted
		if (list.size() <= 1) return list;
		

		// Divide the incoming list into first and second halves
		MyArrayList<E> firstHalf = new MyArrayList<E>();
		MyArrayList<E> secondHalf = new MyArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (i < list.size() / 2) {
				firstHalf.add(list.get(i));
		}
			else {
				secondHalf.add(list.get(i));
			}
		}
		MyArrayList<E> mergeFirst = sort(firstHalf);
		MyArrayList<E> mergeSecond = sort(secondHalf);

		// Merge firstHalf with secondHalf into list
		return merge(mergeFirst, mergeSecond);
	}

	/** Merge two sorted lists */
	private MyArrayList<E> merge(MyArrayList<E> list1, MyArrayList<E> list2) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		
		MyArrayList<E> retList = new MyArrayList<>();

		while (current1 < list1.size() && current2 < list2.size()) {
			if (list1.get(current1).getMeasure() < list2.get(current2).getMeasure())
				retList.add(list1.get(current1++));
			else
				retList.add(list2.get(current2++));
		}

		while (current1 < list1.size())
			retList.add(list1.get(current1++));

		while (current2 < list2.size())
			retList.add(list2.get(current2++));
		
		return retList;
	}


	/**
	 * A String representation of the store.
	 * 
	 * @return A String containing the number of books in the store, 
	 * the minimum book, the largest book, and 
	 * the contents of the entire store.
	 */
	@Override
	public String toString() {
		return "DataSetMeasurable [\n size()=" + size() + "\n getMin()=" + getMin() + " getMax()=" + getMax()
				+ " Elements=\n" + super.toString() + "]";
	}
}
