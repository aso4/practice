public class SelectionSort {

    public void example (){
        int[] array = {5, 4, 2, 6, 8, 1};

        for (int i = 0; i <= array.length - 2; i++) {
            int minIndex = i;
            for (int j = i+1; j <= array.length-1; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        System.out.printf("final array is:");
        for (int x = 0; x < array.length; x++) {
            System.out.printf(array[x] + ",");
        }
    }

}