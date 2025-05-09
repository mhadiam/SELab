public class SearchAlgorithms {
    public static void main(String[] args) {
        int size = 100_000_000;
        int[] data = new int[size];
        for (int i = 0; i < size; i++) data[i] = i; // Sorted array

        int target = 99_999_999;

//        int indexLinear = linearSearch(data, target);
//        System.out.println("Index: " + indexLinear);
        int indexBinary = binarySearch(data, target);
        System.out.println("Index: " + indexBinary);

    }


    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found
            }
        }
        return -1; // Not found
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Found
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Not found
    }
}
