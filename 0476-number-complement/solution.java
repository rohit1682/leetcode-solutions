class Solution {
    public int findComplement(int num) {
		String binary = Integer.toBinaryString(num);
		String complement = "";
		for(int i = 0; i < binary.length(); i++) {
			if(binary.charAt(i) == '1') {
				complement += '0';
			}
			else if(binary.charAt(i) == '0') {
				complement += '1';
			}
		}
		int decimal = Integer.parseInt(complement, 2); 
		return decimal;  
    }
}