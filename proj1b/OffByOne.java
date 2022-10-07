public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        char a = Character.toLowerCase(x);
        char b = Character.toLowerCase(y);
        return Math.abs(a - b) == 1;
    }
}
