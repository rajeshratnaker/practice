package puzzle;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/*
 * Design an algorithm that, given a list of n elements in an array, finds all the elements that appear more 
 * than n/3 times in the list. The algorithm should run in linear time. (n >=0 ) You are expected to use 
 * comparisons and achieve linear time. No hashing/excessive space/ and don't use standard linear time 
 * deterministic selection algo"
 * 
 */
public class DuplicateNby3ListElelments<T> {
	private List<T> list;

	public DuplicateNby3ListElelments(final List<T> list) {
		this.list = list;
	}

	public Collection<T> findDuplicatesWhichAreNby3() {
		int[][] listStatus = new int[list.size()][2];
		int top = -1;
		Collection<T> resultantList = new HashSet<T>();

		for (int index = 0; index < list.size(); index++) {
			top = updateListStatus(index, top, listStatus, resultantList, 3);
		}

		return resultantList;
	}

	private int updateListStatus(int index, int top, int[][] listStatus, Collection<T> result, int n) {
		int COUNT = (int) list.size() / n;
		if (top == -1) {
			top++;
			listStatus[top][0] = index;
			listStatus[top][1] = 1;
		} else {
			for (int i = 0; i <= top; i++) {
				if (list.get(index).equals(list.get(listStatus[i][0]))) {
					listStatus[top][1] = listStatus[top][1] + 1;
					if (listStatus[top][1] >= COUNT) {
						result.add(list.get(index));
					}
					return top;
				}
			}
			top++;
			listStatus[top][0] = index;
			listStatus[top][1] = 1;
		}
		return top;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(new Integer[] { 4, 2, 3, 4, 9, 4, 2, 3, 4, 3 });
		DuplicateNby3ListElelments<Integer> duplicateNby3ListElelments = new DuplicateNby3ListElelments<Integer>(list);
		Collection<Integer> findDuplicatesWhichAreNby3 = duplicateNby3ListElelments.findDuplicatesWhichAreNby3();
		System.out.println(findDuplicatesWhichAreNby3);

		System.out.println(findCandidate(new int[] { 4, 2, 3, 4, 9, 4, 2, 3, 4, 3 }));
	}

	static int findCandidate(int a[]) {
		//Initialize index and count of majority element
		int maj_index = 0;
		int count = 0;
		
		for (int i = 0; i < a.length; i++) {
			if(a[maj_index] == a[i]){
				count++;
			}  else {
				count--;
			}

			if(count == 0) {
				maj_index = i;
				count = 1;
			}
		}
		System.out.println(count);
		return a[maj_index];
	}
}
