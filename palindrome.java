// Class checks if given characters can be turned into a palindrome
class Solution {
    public int solution(String S) {
        // Check there is content in string.
        if (S == null || S.equals("")) {
            return 0;
        }
	    char[] inputCharArray = S.toCharArray();
	    // In palindrome can be only one character that appears just once: the one in the middle of the word. 
	    boolean oddCharacterUsed = false;
        ArrayList<Character> checkedChars = new ArrayList<Character>();
    	char c;
        // Loop through al the characters
    	for (int i = 0; i < inputCharArray.length; i++){ 
    		c = inputCharArray[i];
            int countCharInstances = 0;           
            Character ch = new Character(c);
            // In case we are dealing with very long strings, it is efficient not to check one character several times
            if (checkedChars.contains(ch)) {
                continue;
            }               
            checkedChars.add(ch);
    		// For each character do another loop, where you count how many instances of it there is
    		for (int j = 0; j < inputCharArray.length; j++){
    			if (c == inputCharArray[j]) {
    				countCharInstances++;
    			}		    
    		}
    		// If there was even number of characters everything is OK for palindrome
    		if (countCharInstances % 2 == 0) {			  
    			continue;
    		} else {
    		    // If there is more than one pairless character palindrome can't be formed
    			if (oddCharacterUsed){
    				return 0;
    			} else {
    				oddCharacterUsed = true;
    			}
    		}
    	}
    	// If everything worked, return confirmation that palindrome can be formed
    	return 1;
    }
}