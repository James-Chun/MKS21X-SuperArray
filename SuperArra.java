public class SuperArra {
  private String[] data;
  private int size;
  public SuperArra(){
    data = new String[10];
    size = 0;
  }
  public SuperArra(int capacity){
    if (capacity < 0){
      throw new IllegalArgumentException("Parameter Out of Bounds");
    }
    else {
      data = new String[capacity];
    }
    size = 0;
  }


  public void clear(){
    size = 0;
  }
  public int size(){
    return size;
  }
  public boolean isEmpty(){
    return size() == 0;
  }
  public boolean add(String value){
    if (size() == data.length){
      this.resize();
    }

    size ++;
    return true;
  }
  public String toString(){
    String ans = "[";
    for (int i = 0; i < size()+1; i++){
      ans += get(i);
      if (i + 1 != size()+1){
        ans += ",";
      }
    }
    ans += "]";
    return ans;
  }
  public String toStringDebug(){
    String ans = "[";
    for (int i = 0; i < data.length; i++){
      ans += get(i);
      if (i + 1 != data.length){
        ans += ",";
      }
    }
    ans += "]";
    return ans;
  }
  public String get(int index){
    if (index < 0 || index >= data.length){
      throw new IndexOutOfBoundsException("Index Out of Bounds");
    }else{
      return data[index];
    }
  }
  public String set(int index, String value){
    String old = data[index];
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("Index Out of Bounds");
    }else{
      data[index] = value;
    }
    return old;
  }
  private void resize(){
    if (data.length == 0){
      data = (null);
    }
    else {
      String[] newArray = new String[data.length * 2];
      for (int i = 0; i < size(); i++){
        newArray[i] = data[i];
      }
      data = newArray;
    }
  }

  public boolean contains(String target){
    for (int i = 0; i < size()-1; i++){
      if (data[i].equals(target)){
        return true;
      }
    }
    return false;
  }
  public int indexOf(String target){
    for (int i = 0; i < size(); i++){
      if (data[i].equals(target)){
        return i;
      }
    }
    return -1;
  }
  public int lastIndexOf(String target){
    for (int i = size()-1; i > 0; i--){
      if (data[i].equals(target)){
        return i;
      }
    }
    return -1;
  }
  public void add(int index, String value){
    boolean inserted = false;
    if (index < 0 || index > size()){
      throw new IndexOutOfBoundsException("Index Out of Bound");

    }
    if (size() == data.length){
      resize();
    }
    String[] newArray = new String[data.length];
    for (int i = 0; i < size()+1; i++){
      if (i == index){
        newArray[i] = value;
        inserted = true;
      }
      if (inserted){
        newArray[i+1] = data[i];
      }else{
        newArray[i] = data[i];
      }
    }
    data = newArray;
  }
  public String remove(int target){
    boolean removed = false;
    String gone = "";
    String[] newArray = new String[data.length];
    if (target < 0 || target >= size()){
      throw new IndexOutOfBoundsException("Index Out of Bounds");
    }
    for (int i = 0; i < size(); i++){
      if (i == target){
        removed = true;
        gone = data[i];
      }
      if (removed){
        newArray[i] = data[i+1];
      }else{
        newArray[i] = data[i];
      }
    }
    data = newArray;
    return gone;
  }

  public boolean remove(String target){
    boolean removed = false;
    String[] newArray = new String[data.length];
    for (int i = 0; i < size(); i ++){
      if (data[i].equals(target)){
        removed = true;
      }
      if (removed){
        newArray[i] = data[i+1];
      }else{
        newArray[i] = data[i];
      }
    }
    data = newArray;
    return removed;
  }
}
