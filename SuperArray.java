public class SuperArray {
  private String[] data;
  private int size;
  public SuperArray(){
    data = new String[10];
    size = 0;
  }
  public SuperArray(int capacity){
    if (capacity < 0){
      throw new IllegalArgumentException("Parameter Out of Bounds");
    }
    else {
      data = new String[capacity];
      size = 0;
    }
  }
  public void clear(){
    size = 0;
  }
  public int size(){
    return size;
  }
  public boolean isEmpty(){
    return size == 0;
  }
  public boolean add(String value){
    if (size == data.length){
      resize();
    }
    data[size] = value;
    size ++;
    return true;
  }
  public String get(int index){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("Index Out of Bounds");
    }
    return data[index];
  }
  public String toString(){
    String ans = "[";
    for (int i = 0; i < size; i++){
      ans += get(i);
      if (i + 1 != size){
        ans += ",";
      }
    }
    ans += "]";
    return ans;
  }
  public String toStringDebug(){
    String ans = "[";
    if (data.length == 0){
      return null;
    }
    for(int c = 0; c != data.length - 1; c++){
      ans = ans + data[c] + ", ";
    }
    ans = ans + data[data.length -1];
    ans = ans + "]";
    return ans;

  }
  public String set(int index, String value){
    String old = data[index];
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("Index Out of Bounds");
    }
    data[index] = value;
    return old;
  }
  private void resize(){
    String[] newArray = new String[(data.length * 2)+1];
    for (int i = 0; i < size; i++){
      newArray[i] = data[i];
    }
    data = newArray;
  }
  public boolean contains(String target){
    for (int i = 0; i < size; i++){
      if (data[i].equals(target)){
        return true;
      }
    }
    return false;
  }
  public int indexOf(String target){
    for (int i = 0; i < size; i++){
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
    String[] newArray = new String[data.length + 1];
    if (index < 0 || index > size()){
      throw new IndexOutOfBoundsException("Index Out of Bound");
    }
    for (int i = 0; i < size; i++){
      if (i == index){
        newArray[i] = value;
        inserted = true;
      }
      if (inserted){
        newArray[i+1] = data[i];
      }
      if (inserted == false){
        newArray[i] = data[i];
      }
    }
    data = newArray;
    size ++;
  }
  public String remove(int target){
    boolean removed = false;
    String gone = "";
    String[] newArray = new String[data.length - 1];
    if (target < 0 || target >= size()){
      throw new IndexOutOfBoundsException("Index Out of Bounds");
    }
    for (int i = 0; i < size; i++){
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
    size --;
    return gone;
  }
  public boolean remove(String target){
    if (indexOf(target) == -1){
      return false;
    }
    int index = indexOf(target);
    remove(index);
    return true;
  }
}
