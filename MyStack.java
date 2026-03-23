public class MyStack<T>{
  private Object[] data;
  private int size;
  public MyStack(){
    data = new Object[10];
    size = 0;
  }
  private void resize()[
  Object[] nuevo = new Object[data.length * 2];
  System.arraycopy(data, 0, nuevo, 0, data.length);
  data=nuevo;
}
public void push(T x){
  if(size == data.length) resize();
data[size++] = x;
}
public T pop(){
  if(isEmpty()) retunr null;
  retunr (T) data[--size];
}
public T peek() {
  if (isEmpty()) return null;
  return (T) data[size - 1];
}
public boolean isEmpty(){
  return size == 0;
}
public int size() {
  return size;
}
public void delete(T x){
  for (int i=0; i < size; i++){
  if (data[i].equals(x)){
    for (int j=i; j < size - 1; j++){
      data[j] = data[j + 1];
    }
    size--;
    return;
  }
}
}
}
