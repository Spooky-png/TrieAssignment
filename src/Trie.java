import java.util.HashMap;

public class Trie {
    public Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void insertWord(String word) {
        // gets the root node;
        Node currentNode = this.root;
        
        // iterates over every character in the word
        for(int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
                child = new Node();
                currentNode.children.put(currentLetter, child); 
            } 
            
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
    public boolean isPrefixValid(String prefix) {
    	
    	Node pNode = this.root;
    	for(int j = 0; j < prefix.length(); j++) {
    		Character pLetter = prefix.charAt(j);
    		if(pNode.children.get(pLetter) != null) {
    			return true;
    		}
    	}
		return false;
    	
    }
    
    public boolean isWordValid(String word) {
    	Node wNode = this.root;
    	for(int k = 0; k < word.length(); k++) {
    		Character wLetter = word.charAt(k);
    		if(wNode.children.get(wLetter) != null) {
    			return true;
    		}
    		if(wNode.isCompleteWord == true) {
    			return true;
    		}
    	}
		return false;
    	
    }
    public void printAllKeys() {
    	Node kNode = this.root;
    	
    	for(int b = 0; b < kNode.children.size();b++);
    	System.out.println(kNode.children);
    	
    }
}