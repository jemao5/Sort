import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] asdf = {3, 6, 7, 2, 1, 4, 9, 8, 5, 4};
        System.out.println(Arrays.toString(asdf));
        System.out.println(insertionSort(asdf));
        System.out.println(Arrays.toString(asdf));

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
}
