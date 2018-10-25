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

  public boolean add(String s) {
    if (size != 10) {
      this.data[size]=s;
      size ++;
    }
    else {
      return false;
    }
    return true;
  }

  public String toString() {
    String s = "[";
    for (int i = 0; i < 10;i++){
      if (this.data[i]!=null){
        s = s + this.data[i];
        if (i != size-1){
          s = s +", ";
        }
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

      if (i != size -1){
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

  public String set(int index, String element) {
    String old = "null; error out of bounds";
    if (index >= 0 && index <= size) {
      old = this.data[index];
      this.data[index] = element;
    }
    return old;
  }

  public boolean contains(String element) {
    for (int i = 0; i < size; i ++) {
      if (data[i].equals(element)) {
        return true;
      }
    }
    return false;
  }

  public void add(int index, String element) {
    String[] new = new String[10];
    if (size + index <= 10) {

    }
    else {
      return "error; out of bounds";
    }
  }



}
