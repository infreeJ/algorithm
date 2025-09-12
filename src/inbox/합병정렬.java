package inbox;

public class 합병정렬 {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10, 52};

        mergeSort(arr, 0, arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);

            mergeSort(arr, mid+1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left +1];

        int i = left;
        int j = mid +1;
        int k =0;

        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while(i <= mid) {
            tmp[k++] = arr[i++];
        }

        while(j <= right) {
            tmp[k++] = arr[j++];
        }

        for (int l = 0; l < tmp.length; l++) {
            arr[left + l] = tmp[l];
        }
        
    }


}




















