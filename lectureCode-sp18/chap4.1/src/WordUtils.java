public class WordUtils {
  public static String longestString(Deque<String> S) {
    String longest = "";
    for (int i = 0; i < S.size(); i++) {
      if (S.get(i).length() > longest.length()) {
        longest = S.get(i);
      }
    }
    return longest;
  }

  public static void main(String[] args) {
    LinkedListDeque<String> someList = new LinkedListDeque<>();
//    ArrayDeque<String> someList = new ArrayDeque<>();
    someList.addLast("elk");
    someList.addLast("are");
    someList.addLast("watching");
    System.out.println(longestString(someList));
    someList.print();
  }
}
