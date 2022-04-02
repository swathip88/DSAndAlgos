public class QuickSort {

	private static void quickSort(int[] arr, int start, int end){
		if(start<end){
			int partitionIndex = partition(arr, start, end);
			quickSort(arr, start, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, end);
		}
	}
	
	private static int partition(int[]arr, int begin, int end){
		int pivot = arr[end];
		int i = begin-1;
		for(int j=begin;j<end;j++){
			if(arr[j]< pivot){
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = pivot;
		arr[end] = temp;
		
		return i+1;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{21,125,251,12,24,5,78,3221,214,13};
		System.out.println(arr.length);
		quickSort(arr, 0, arr.length-1);
		for(int num: arr){
			System.out.print(num+",");
		}
	}
}
