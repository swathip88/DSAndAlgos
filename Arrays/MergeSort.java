public class MergeSort {

	private static void mergeSort(int[] arr, int length){
		if(length< 2){
			return;
		}
		
		int mid= length/2;
		int[] l = new int[mid];
		int[] r = new int[length-mid];
		
		for(int i=0;i<mid;i++){
			l[i] = arr[i];
		}
		
		for(int j=mid;j<length;j++){
			r[j-mid] = arr[j];
		}
		mergeSort(l, l.length);
		mergeSort(r, r.length);
		
		merge(arr, l, r, l.length, r.length );
	}
	
	private static void merge(int[]a, int[]l, int[]r, int lLength, int rLength){
		int i=0;
		int j=0;
		int k=0;
		
		while(i<lLength && j<rLength){
			if(l[i]<=r[j]){
				a[k++] = l[i++];
			}else{
				a[k++] = r[j++];
			}
		}
		
		while(i<lLength){
			a[k++] = l[i++];
		}
		
		while(j<rLength){
			a[k++] = r[j++];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{21,125,251,12,24,5,78,3221,214,13};
		System.out.println(arr.length);
		mergeSort(arr, arr.length);
		for(int num: arr){
			System.out.print(num+",");
		}
	}
}
