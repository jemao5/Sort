import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] nums10 = { 7, 6, 5, 2, 9, 1, 3, 10, 4, 8 };
        mergeSort(nums10);
        System.out.println(Arrays.toString(nums10));
        int[] nums20 = { 10, 14, 19, 20, 3, 11, 9, 15, 6, 13, 4, 7, 18, 5, 12, 2, 8, 1, 17, 16 };
//        bubbleSort(nums20);
//        int[] nums30 = { 17, 10, 18, 13, 5, 2, 29, 14, 6, 3, 22, 28, 19, 25, 12, 8, 7, 26, 27, 21, 23, 24, 30, 1, 20, 16, 9, 15, 4, 11 };
//        System.out.print(selectionSort(nums30));
    }

    public static void swap(int a, int b, int[] array){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static int bubbleSort(int[] sort){
        int compares = 0;
        int length = sort.length;
        int sortedIndex = length;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < sortedIndex - 1; j++){
                compares++;
                if(sort[j] > sort[j+1])
                    swap(j, j+1, sort);
            }
            sortedIndex--;
        }
        return(compares);
    }

    public static int selectionSort(int[] sort){
        int compares = 0;
        int length = sort.length;
        int sortedIndex = 0;
        for(int i = 0; i < length; i++){
            int selection = sortedIndex;
            for(int j = sortedIndex + 1; j < length; j++){
                compares++;
                if(sort[selection] > sort[j])
                    selection = j;
            }
            swap(sortedIndex, selection, sort);
            sortedIndex++;
        }
        return(compares);
    }

    public static int insertionSort(int[] sort){
        int compares = 0;
        int sortedIndex = -1;
        for(int i = 0; i < sort.length; i++){
            int temp = i;
            for(int j = sortedIndex; j >= 0; j--){
                compares++;
                if(sort[temp]<sort[j]){
                    swap(temp, j, sort);
                    temp = j;
                } else {
                    break;
                }
            }
            sortedIndex++;
        }
        return compares;
    }

//    public static void mergesort(int[] arr) {
//        ms(arr, 0, arr.length-1);
//    }
//
//    private static void ms(int[] a, int low, int high) {
//        if (low < high) {
//            int mid = (low + high) / 2;
//            ms(a, low, mid);
//            ms(a, mid+1, high);
//            merge(a, low, mid, high);
//        }
//    }
//
//    private static void merge (int[] a, int low, int mid, int high) {
//        int[] b = new int[a.length];
//        int i, j, k;
//
//        for (i = low; i <= high; i++)
//            b[i]=a[i];
//
//        i = low; j = mid+1; k = low;
//        while (i <= mid && j <= high)
//            if (b[i]<=b[j])
//                a[k++]=b[i++];
//            else
//                a[k++]=b[j++];
//
//        while (i <= mid)
//            a[k++]=b[i++];
//    }

    public static void mergeSort(int[] a){
        sorter(a, 0, a.length - 1);
    }

    public static void sorter(int[] a, int l, int h){
        if(l<h) {
            sorter(a, l, (l + h) / 2);
            sorter(a, (l + h) / 2 + 1, h);
            merge(a, l, (l + h) / 2 + 1, h);
        }
    }

    public static void merge(int[] a, int l, int m, int h){
        int[] ret = new int[a.length];
        int indx1 = l;
        int indx2 = m;
        for(int i = l; i<= h; i++){
            if(indx1>=m){
                ret[i] = a[indx2];
                indx2++;
            } else if(indx2>h){
                ret[i] = a[indx1];
                indx1++;
            }
            else if (a[indx1] < a[indx2]){
                ret[i] = a[indx1];
                indx1++;
            } else {
                ret[i] = a[indx2];
                indx2++;
            }
        }
        for(int i = h; i>=l; i--){
            a[i] = ret[i];
        }

    }


//    public static int[] merge(int[] a, int[] b){
//        int size = a.length + b.length;
//        int[] ret = new int[size];
//        System.arraycopy(a, 0, ret, 0, a.length);
//        System.arraycopy(b, 0, ret, a.length, b.length);
//        return ret;
//    }
}
