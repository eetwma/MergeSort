public class MergeSort {
    public static int[] mergeSort(int[] array){
        if(array == null || array.length == 0){
            return array;
        }
        mergeSort(array,0,array.length-1);
        return array;
    }


    public static void mergeSort(int[] array, int left, int right){
        if(left == right){
            return;
        }
        int mid = left +(right-left)/2;
        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);
        merge(array,left,mid,right);
    }

    public static void merge(int[] array, int left, int mid, int right){
        int[] helper = new int[array.length];
        for(int i=left;i<=right;i++)
        {
            helper[i] = array[i];
        }
        int lIndex = left;
        int rIndex = mid+1;
        int x = left;
        while(lIndex<= mid && rIndex <= right)
        {
            if(helper[lIndex]<=helper[rIndex])
            {
                array[x++] = helper[lIndex++];
            }
            else{
                array[x++] = helper[rIndex++];
            }
        }
        while(lIndex<=mid){
            array[x++] = helper[lIndex++];
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {1,4,8,10,3,6,15,7};
        mergeSort(arr);
        for(int num:arr){
            System.out.println(num);
        }
    }
}