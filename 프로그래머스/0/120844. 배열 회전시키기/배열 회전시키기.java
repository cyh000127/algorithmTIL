class Solution {
    public int[] solution(int[] numbers, String direction) {
    int[] a = new int[numbers.length];
        
        if(direction.equals("right")){
            for(int i=0; i<numbers.length-1; i++){
                a[i+1] = numbers[i];
            } a[0] = numbers[numbers.length-1];
        } else{
            for(int i=0; i<numbers.length -1; i++){
                a[i] = numbers[i+1];
            } a[numbers.length-1] = numbers[0]; 
        }
     return a;   
    }
}