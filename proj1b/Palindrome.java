public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> w = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            w.addLast(word.charAt(i));
        }
        return w;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> w = this.wordToDeque(word);
        int flag = 1;
        int size = w.size();
        if (size == 1 || size == 0) {
            return true;
        }
        while (w.size() > 1) {
            if (w.removeFirst() != w.removeLast()) {
                flag = 0;
                break;
            }
        }
        if (flag == 0) {
            return false;
        }
        return  true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(len - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
