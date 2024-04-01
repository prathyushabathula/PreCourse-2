class MergeSort 
{   // Time Complexity : Best, Worst and Average Case - O(N log N) - As the array is divided into two equal halves and to sort the array at every step it takes linear time
    // Space Complexity : O(N) - As a temporary space is required for recursively merging the two halves of elements in the sub arrays
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    void merge(int arr[], int l, int m, int r) 
    {  
       int l1 = m-l+1;
       int l2 = r-m;

       int leftArray[] = new int[l1];
       int rightArray[] = new int[l2];

       for(int i=0;i<l1;i++)
        leftArray[i] = arr[l+i];
       for(int i=0;i<l2;i++)
        rightArray[i] = arr[m+1+i];

        int i=0, j=0;
        int k=l;

        while(i<l1 && j<l2) {
            if(leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i < l1) {
            arr[k] = leftArray[i];
            k++;
            i++;
        }
        while(j < l2) {
            arr[k] = rightArray[j];
            k++;
            j++;
        }


    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) 
    { 
	//Write your code here
        //Call mergeSort from here 
        int n = arr.length;
        if (n < 2) return;
        if(l < r) {
            int mid = l+(r-l)/2;
            sort(arr, 0, mid);
            sort(arr, mid+1, r);
            merge(arr, 0, mid, r);
         }
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
} 