package practice;

public class selectionSort {

    public static void main(String args[]){

//        int[] arr = {54, 31, 6, 74, 8, 4, -1};
//        int[] arr_sorted = selectionSort(arr);
//        displayArray(arr_sorted);

          int[] arr = {-4,-1,0,3,10};
        int[] arr_sorted = sortSquaresOfArrayElementsUsingSelectionSort(arr);
        displayArray(arr_sorted);

    }

    public static int[] selectionSort(int[] arr){
        int temp, temp_min;
        for (int i=0; i< arr.length-1; i++){
            temp_min = i;
            for (int j=i+1; j< arr.length; j++){
                if (arr[j]< arr[temp_min]){
//                    temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
                    temp_min = j;
                }
            }
            if(temp_min!=i){
                temp = arr[i];
                arr[i] = arr[temp_min];
                arr[temp_min] = temp;
            }
        }
        return arr;
    }

    public static int[] sortSquaresOfArrayElementsUsingSelectionSort(int[] arr){
        int temp, temp_min;
        for (int i=0; i< arr.length-1; i++){
            for (int j=i+1; j< arr.length; j++){
                if (Math.pow(arr[j],2) < Math.pow(arr[i],2)){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            arr[i] = (int) Math.pow(arr[i],2);
        }
        arr[arr.length-1] = (int) Math.pow(arr[arr.length-1],2);
        return arr;
    }

    public static void displayArray(int[] arr){
        for (int ele :arr) {
            System.out.print(ele + ", ");
        }
    }
}
