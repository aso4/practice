public class InsertionSort {

    public void example (){
        int[] array = {5, 4, 2, 6, 8, 1};

        System.out.println("array is 5 4 3 6 8 1");

        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int j = i-1;
            while (j >=0 && array[j] > current) {
                array[j+1] = array[j];
                j = j-1;
            }
            array[j+1] = current;
        }

        System.out.printf("final array is:");
        for (int x = 0; x < array.length; x++) {
            System.out.printf(array[x] + ",");
        }
    }

}