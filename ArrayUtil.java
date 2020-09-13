import java.util.function.Predicate;

public class ArrayUtil {



	/**
	 * "pops" the last element of the array off.
	 * 
	 * @return the element.
	 */
	public static <T> T pop(T[] array) {
		int length = array.length;

		if (length == 0 || array == null)
			return null;
		T temp = array[length];
		array[length] = null;
		return temp;

	}

	/**
	 * Takes an array, and ...arguments, and <b>push</b>es the elements inside the array
	 * 
	 * @return the new length of the array
	 */
	public static <T> int push(T[] array, T... elements) {
		int length = array.length;
		for (T element: elements) 
			array[++length] = element;

		return length;
	}

	/**
	 * 
	 * @param <T>
	 * @param array
	 * @param element
	 * @return the index of the element inside the array, returns -1 if it doesn't exist.
	 */
	public static <T> int indexOf(T[] array, T element) {
		return findIndex(array, r -> r == element);
	}
	/**
	 * 
	 * @param <T>
	 * @param array
	 * @param predicate the function to be called on the array
	 * @return the index of the <b>first</b> found test of the predicate to return to true.
	 * <br>
	 * <code>
	 * 	int index = findIndex(new Integer[] { 1, 2, 3, 4, 5, 6}, val -> val <= 2);
	 * </code>
	 * <br>
	 * PRIMITIVE TYPES ARE NOT ALLOWED!
	 */
	public static <T> int findIndex(T[] array, Predicate predicate) {
		int k = -1;

		for (T t: array) {
			k++;
			if (predicate.test(t))
				break;
		}
		return k;
	}


}
