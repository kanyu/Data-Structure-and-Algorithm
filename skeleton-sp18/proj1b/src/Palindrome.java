public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        /* *
         * create an empty Deque;
         * get character from string and add to the Deque until there is no character left;
         * */
        // get string character by index
        // https://stackoverflow.com/questions/11229986/get-string-character-by-index-java
        // https://www.tutorialspoint.com/java/java_string_length.htm
        Deque<Character> D = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            D.addLast(tmp);
        }
        return D;
    }
    private boolean palinHelper(Deque<Character> D) {
        if (D.size() == 1 || D.isEmpty()) {
            return true;
        }
        if (D.removeFirst() == D.removeLast()) {
            return palinHelper(D);
        }
        return false;
    }
    public boolean isPalindrome(String word) {
        return palinHelper(wordToDeque(word));
    }
}
