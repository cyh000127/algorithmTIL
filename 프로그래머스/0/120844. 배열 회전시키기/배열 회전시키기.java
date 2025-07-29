class Solution {
    public int[] solution(int[] numbers, String direction) {
        
        int length = numbers.length;
        
        if(direction.equals("right")){
        	int r = numbers[length-1];
            for(int i=1; i<length; i++) {
            	numbers[length - i] = numbers[length -i - 1];
            }numbers[0] = r;
            return numbers;
        } else {
        	int r = numbers[0];
        	for(int i=0; i<length-1;i++) {
        		numbers[i] = numbers[i+1];
        	}
        	numbers[length-1] = r;
        	return numbers;
    }
}
}