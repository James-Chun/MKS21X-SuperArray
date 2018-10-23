public class SuperArray{
  private String[] data;
  private int size;

  public SuperArray() {
    data = new String[10];
    size = 0;
  }

  public void clear() {
    size = 0;
    for (int i = 0; i < 10; i ++){
      this.data[i]=null;
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }
/*
  public boolean add(String) {

  }
*/
  public String toString() {
    String s = "[";
    for (int i = 0; i < 10;i++){
      s = s + this.data[i];

      if (i != 9){
        s = s +", ";
      }

    }
    return s+"]";
  }

  public String toStringDebug() {
    String s = "[";
    for (int i = 0; i < 10;i++){
      if (this.data[i] == null) {
        s = s + "null";
      }
      else {
        s = s + this.data[i];
      }

      if (i != 9){
        s = s +", ";
      }

    }
    return s+"]";
  }

  public String get(int index) {
    if (index < 0 || index > size) {
      return null;
    }
    return this.data[index];
  }
}
