public class BubbleSort {

    public void example (){
        int[] array = {5, 4, 2, 1, 3};


        for (int i = 0; i <= array.length - 2; i++) {
            for (int j = 0; j <= array.length - 2 - i; j++) {
                System.out.println("iterating. j = " + j);

                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.printf("final array is :");
        for (int x = 0; x < array.length; x++) {

            System.out.printf(array[x] + ",");
        }
    }

}