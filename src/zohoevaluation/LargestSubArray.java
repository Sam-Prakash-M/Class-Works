package zohoevaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestSubArray {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LargestSubArray lsa = new LargestSubArray();
		System.out.println("Enter a size of a array : ");
		int size = sc.nextInt();
		System.out.println("Enter a elements in the array : ");
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
		lsa.findTheArray(array);

	}

	private void findTheArray(int[] array) {

		int maxCount = Integer.MIN_VALUE, currCount = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {

			currCount += array[i];
			list.add(array[i]);
			if (currCount > maxCount) {
				maxCount = currCount;
			}
			if (currCount < 0) {
				currCount = 0;
				list.clear();
			}

		}
		
		int arrayCount = 0;
		for (int i = 0; i < list.size(); i++) {
			if (maxCount == arrayCount) {
				break;
			}
			arrayCount += list.get(i);
			System.out.print(list.get(i) + " ");
		}

	}

}
