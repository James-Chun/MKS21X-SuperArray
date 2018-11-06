public class SuperArray{
  private String[] data;
  private int size;

  //Default Constructor
  public SuperArray(){
    data = new String[10];
    size = 0;
  }
  //Constructor w/ capacity
  public SuperArray(int capacity){
    if (capacity < 0){
      throw new IllegalArgumentException("Parameter Out of Bounds");
    }
    if (capacity == 0){
      data = new String[1];
    }else {
      data = new String[capacity];
    }
    size = 0;
  }

  //Clear method
  public void clear() {
    size = 0;
  }

  //Size method
  public int size(){
    return size;
  }

  //isEmpty method
  public boolean isEmpty(){
    return size() == 0;
  }

  //add method
  public boolean add(String value){
    if (size()==data.length){
      resize();
    }
    data[size()] = value;
    size ++;
    return true;
  }

  //toString (regular)
  public String toString(){
    String s = "[";
    for (int i = 0;i<size();i++){
      if (get(i)!= null){
        s += get(i);
        if (i + 1 != size()){
          s += ",";
        }
      }
    }
    s += "]";
    return s;
  }

  //toString (Debug)
  public String toStringDebug(){
    String s = "[";
    for (int i = 0;i<data.length;i++){
      s += get(i);
      if (i + 1 != data.length){
        s += ",";
      }
    }
    s += "]";
    return s;
  }

  //get method
  public String get(int index){
    if ( (index < 0 || index > size)){
      throw new IndexOutOfBoundsException("Index Out of Bounds");
    }else{
      return data[index];
    }
  }

  //resize
  private void resize(){
    String[] newArray = new String[data.length * 2];
      for (int i = 0; i < size(); i++){
        newArray[i] = data[i];
      }
    data = newArray;
  }

}
