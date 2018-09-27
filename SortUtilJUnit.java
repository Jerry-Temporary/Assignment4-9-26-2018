package assignment5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

class SortUtilJUnit {

	//TODO mergeSort tests
	
	
	
//	@Test
//	void test10Average() {
//		ArrayList<Integer> list = SortUtil.generateAverageCase(10);
//		ArrayList<Integer> result = SortUtil.generateBestCase(10);
//		SortUtil.mergesort(list, Comparator.naturalOrder());
//		for (int i = 0; i < list.size(); i++) {
//			assertTrue(list.get(i) == result.get(i));
//		}
//	}
	
	@Test
	void premadeArray() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 10; i >= 1; i--) {
			list.add(i);
		}
		for (int i = 1; i <= 10; i++) {
			result.add(i);
		}
		SortUtil.mergesort(list, new IntegerComparator());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
