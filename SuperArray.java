public class SuperArray{
  private String[] data;
  private int size;

  public SuperArray() {
    data = 10;
    size = 0;
  }

  public void clear() {
    size = 0;
    for (int i = 0; i < this.length; i ++){
      this[i]=null;
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size = 0;
  }
/*
  public boolean add(String) {

  }
*/
  public String toString() {
    String s = "[";
    for (int i = 0; i < this.length;i++){
      s = s + this[i];

      if (i != this.length-1){
        s = s +", ";
      }

    }
    return s+"]";
  }

}
