class QuickSort 
{ 
    // Time Complexity : Best case - O(N log N), 
                        //Worst Case - O(N^2) - when the partition of elements is consistently unbalanced
    // Space Complexity : Average Case - O(log N),
                        //Worst Case - O(N) - When the partition of elements is consistently unbalanced
    /* This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot */
    void swap(int arr[],int i,int j){
        //Your code here   
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    int partition(int arr[], int low, int high) 
    { 
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
      int pivotElement = arr[high];

      int i = low-1;
      for(int j = low; j <= high - 1; j++) {
        if(arr[j] < pivotElement) {
            i++;
            swap(arr, i, j);
        }
      }
      swap(arr, i+1, high);
      return i+1;
    }
    void sort(int arr[], int low, int high) 
    {  
            // Recursively sort elements before 
            // partition and after partition 
            if(low < high) {
                int partitionIndex = partition(arr, low, high);
                sort(arr, low, partitionIndex-1);
                sort(arr,partitionIndex+1,high);

            }

    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
  
    // Driver program 
    public static void main(String args[]) 
    { 
        int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
  
        QuickSort ob = new QuickSort(); 
        ob.sort(arr, 0, n-1); 
  
        System.out.println("sorted array"); 
        printArray(arr); 
    } 
} 
