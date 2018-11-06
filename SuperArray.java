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
      s += data[i];
      if (i + 1 != data.length){
        s += ",";
      }
    }
    s += "]";
    return s;
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

  //second add method
  public void add(int index, String value){
    boolean inserted = false;
    if (index < 0 || index > size()+1){
      throw new IndexOutOfBoundsException("Index Out of Bound");

    }
    if (size() == data.length){
      resize();
    }
    String[] newArray = new String[data.length];
    for (int i = 0; i <index;i++){
      newArray[i]=data[i];
    }
    newArray[index]=value;
    size ++;
    for (int i = index+1; i < size();i++){
      newArray[i+1]=data[i];
    }
    data = newArray;
  }




  //get method
  public String get(int index){
    if ( (index < 0 || index > size())){
      throw new IndexOutOfBoundsException("Index Out of Bounds");
    }else{
      return data[index];
    }
  }

  //resize
  public void resize(){
    String[] newArray = new String[data.length * 2];
      for (int i = 0; i < size(); i++){
        newArray[i] = data[i];
      }
    data = newArray;
  }

//set method
public String set (int index, String value){
  if (index < 0 || index >= data.length){
    throw new IndexOutOfBoundsException("Index Out of Bounds");
  }
  String old = data[index];
  data[index]=value;
  return old;
}

//contains method
public boolean contains(String target){
  for (int i = 0;i<size();i++){
    if (data[i].equals(target)){
      return true;
    }
  }
  return false;
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
  size--;
  return gone;
}

public boolean remove(String target){
  boolean removed = false;
  String[] newArray = new String[data.length];
  for (int i = 0; i < size(); i ++){
    if (data[i]!=null&&data[i].equals(target)){
      removed = true;
    }
    if (removed){
      newArray[i] = data[i+1];
    }else{
      newArray[i] = data[i];
    }
  }
  data = newArray;
  size --;
  return removed;
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
}
