package assignment5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * 
 * @author ?? Fill in this class as specified in the assignment5 instructions.
 *
 */
public class SortUtil {

	private static int threshold = 10;
	private static int pivotMethod = 1;

	/*
	 * 
	 */
	public static <T> void mergesort(ArrayList<T> toSort, Comparator<? super T> cmp) {
		ArrayList<T> temp = new ArrayList<T>(toSort.size());
		for (int i = 0; i < temp.size(); i++) {
			temp.add(null);
		}

		mergeSortRecursive(toSort, temp, cmp, 0, toSort.size() - 1);

	}

	/*
	 * 
	 */
	private static <T> void mergeSortRecursive(ArrayList<T> toSort, ArrayList<T> temp, Comparator<? super T> cmp,
			int start, int end) {
//		if ((end - start) <= threshold) {
//			// insertionSort when we get down to the insertionSort threshold
//			insertionSort(toSort, cmp, start, end);
//			return;
//		}
		if (start >= end)
			return;

		int mid = start + (end - start) / 2;
		mergeSortRecursive(toSort, temp, cmp, start, mid);
		mergeSortRecursive(toSort, temp, cmp, mid + 1, end);

		merge(toSort, temp, cmp, start, mid, end);
	}

	private static <T> void merge(ArrayList<T> toSort, ArrayList<T> temp, Comparator<? super T> cmp, int start, int mid,
			int end) {

		int j = mid + 1;
		int i = start;

		int mergePos = start;

		// Merge the arrays until one runs out.
		while (i <= mid && j <= end) {
			if (cmp.compare(toSort.get(i), toSort.get(j)) <= 0) {
				temp.set(mergePos, toSort.get(i));
				mergePos++;
				i++;
			} else {
				temp.set(mergePos, toSort.get(j));
				mergePos++;
				j++;
			}
		}
		// add in everything we missed.
		while (i <= mid) {
			temp.set(i++, toSort.get(i++));
		}
		while (j <= end) {
			temp.set(i++, toSort.get(j++));
		}
		// put it all back in toSort
		for (int index = start; index <= end; index++) {
			toSort.set(index, temp.get(index));
		}
	}

	/*
	 * 
	 */
	public static <T> void quicksort(ArrayList<T> toSort, Comparator<? super T> cmp) {
		quicksortRecursive(toSort, cmp, 0, toSort.size() - 1);
	}

	public static <T> void quicksortRecursive(ArrayList<T> toSort, Comparator<? super T> cmp, int start, int end) {
		int pivotIndex = ((end - start) / 2) + start;
		if (pivotMethod == 1) {
			pivotIndex = ((end - start) / 2) + start;
		}

		if (end <= start) {
			return;
		}
		partition(toSort, cmp, start, end, pivotIndex);
		quicksortRecursive(toSort, cmp, start, pivotIndex - 1);
		quicksortRecursive(toSort, cmp, pivotIndex + 1, end);

	}

	private static <T> void partition(ArrayList<T> toSort, Comparator<? super T> cmp, int start, int end,
			int pivotIndex) {

		int left = start;
		int right = end - 1;

		T pivot = toSort.get(pivotIndex);
		swap(toSort, pivotIndex, end);
		while (left <= right) {
			while (left < end && cmp.compare(toSort.get(left), pivot) <= 0) {
				left++;
			}
			while (right >= 0 && cmp.compare(toSort.get(right), pivot) >= 0) {
				right--;
			}
			if (left < right) {
				swap(toSort, left, right);
			}
		}
		swap(toSort, left, end);

	}

	private static <T> void swap(ArrayList<T> toSort, int left, int right) {
		T temp = toSort.get(left);
		toSort.set(left, toSort.get(right));
		toSort.set(right, temp);
	}

	/**
	 * This generic method sorts the input array within the given bounds using an
	 * insertion sort and the input Comparator object.
	 */
	private static <T> void insertionSort(ArrayList<T> toSort, Comparator<? super T> cmp, int start, int end) { // TODO
																												// test
		if (toSort == null || cmp == null) {
			return;
		}

		// Iterate through all of the elements forward
		for (int index = start + 1; index < end; index++) {
			T temp = toSort.get(index);
			// Move elements right as far as they need to go.
			int jindex;
			for (jindex = index; jindex > 0; jindex--) {
				if (cmp.compare(temp, toSort.get(jindex - 1)) >= 0) {// If it is in the right spot then break
					break;
				}
				toSort.set(jindex, toSort.get(jindex - 1));
			}
			toSort.set(jindex, temp);
		}
	}

	public static ArrayList<Integer> generateBestCase(int size) {
		ArrayList<Integer> testArray = new ArrayList<Integer>(size);
		for (int i = 0; i <= testArray.size(); i++) {
			testArray.add(i);
		}
		return testArray;
	}

	public static ArrayList<Integer> generateAverageCase(int size) {
		ArrayList<Integer> testArray = new ArrayList<Integer>(size);
		Random rand = new Random();

		for (int i = 0; i < testArray.size(); i++) {
			testArray.add(i);

		}
		for (int i = 0; i < testArray.size(); i++) {
			swap(testArray, i, rand.nextInt(testArray.size()));
		}

		return testArray;
	}

	public static ArrayList<Integer> generateWorstCase(int size) {
		ArrayList<Integer> testArray = new ArrayList<Integer>(size);
		for (int i = size; i >= 0; i--) {
			testArray.add(i);
		}
		return testArray;
	}

}
