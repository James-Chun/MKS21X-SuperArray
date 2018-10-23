public class Test{
  public static void main(String[] args) {
    SuperArray test = new SuperArray();

    System.out.println("Testing toString: " + test);
    System.out.println("Testing toStringDebug: " + test);
    System.out.println("Testing size(): " + test.size() );
    test.clear();
    System.out.println("Testing clear(): " + test);
    }
}
