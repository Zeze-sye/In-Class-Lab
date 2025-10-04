import java.util.Scanner;
import java.util.Arrays;

public class inClassLab {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // Task 1 - Find index of a value
        int[] values = {2,5,8,3,4,6,10,15,20,1,11};
        int input;
        int indexValue = -1;

        // print out the whole array for user to see
        for (int i =0;i < values.length; i++){
            System.out.print(values[i] + ", ");
        }


        System.out.print("\nEnter a value in the set above: ");
        input = sc.nextInt();

        // loop to check where the input exists in the array
        for(int i = 0; i< values.length;i++){
            if(values[i] == input){
                indexValue = i; // save index when found
                break; // stop since we found it
            }
        }

        if(indexValue != -1){
            System.out.println("The index of the value is " + indexValue);
        }
        else{
            System.out.println("Index can't be found");
        }

        // Task 2 - Swapping two values
        System.out.print("\nEnter first number to swap: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number to swap: ");
        int num2 = sc.nextInt();

        int index1 = -1, index2 = -1;

        // find positions of the two numbers in the array
        for (int i = 0; i < values.length; i++) {
            if (values[i] == num1) index1 = i;
            if (values[i] == num2) index2 = i;
        }

        // check if both exist before swapping
        if (index1 != -1 && index2 != -1) {
            // swap values
            int temp = values[index1];
            values[index1] = values[index2];
            values[index2] = temp;

            System.out.println("Array after swap: " + Arrays.toString(values));
        } else {
            System.out.println("One or both numbers not found in the array!");
        }

        // Task 3 - Sorting
        // Ascending order
        for (int i = 0; i < values.length - 1; i++) {
            for (int k = 0; k < values.length - i - 1; k++) {
                if (values[k] > values[k+ 1]) { // if current bigger than next, swap
                    int temp = values[k];
                    values[k] = values[k+ 1];
                    values[k+ 1] = temp;
                }
            }
        }
        System.out.println("Ascending order: " + Arrays.toString(values));

        // keep a copy of ascending array for binary search later
        int[] ascendingValues = Arrays.copyOf(values,values.length);

        // Descending order (reverse comparison)
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] < values[j + 1]) { // if current smaller than next, swap
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
        System.out.println("Descending order: " + Arrays.toString(values));

        // Task 4 - Linear search
        int indexValueTwo = -1;
        System.out.print("Enter the number you want to find: ");
        int inputTwo = sc.nextInt();

        // loop one by one till found
        for(int i = 0; i < values.length; i++){
            if(values[i] == inputTwo){
                indexValueTwo = i;
                break;
            }
        }
        if (indexValueTwo != -1){
            System.out.println("The number " + inputTwo + " is at index " +indexValueTwo + " of the array swaped");
        }
        else{
            System.out.print("Number is not in array");
        }

        // Task 5 - Binary Search (using the sorted ascending array)
        System.out.print("\nEnter a number to search (Binary Search): ");
        int searchValue = sc.nextInt();

        int min = 0;
        int max = ascendingValues.length - 1;
        int foundIndex = -1;

        while (min <= max) {
            int mid = (min + max) / 2; // middle point

            if (ascendingValues[mid] == searchValue) {
                foundIndex = mid; // found!
                break;
            } else if (ascendingValues[mid] < searchValue) {
                min = mid + 1; // search in right half
            } else {
                max = mid - 1; // search in left half
            }
        }

        // print results for binary search
        if (foundIndex != -1) {
            System.out.println("The number " + searchValue + " is at index " + foundIndex + " in ascending order array");
        } else {
            System.out.println("Number not found in ascending order array");
        }


        sc.close();



    }
}
