public class ListaSimpleConCola<T> {
  private Nodo<T> head;
  private Nodo<T> tail;
public ListaSimpleConCola(){
  head= null;
  tail = null;
}
  public void pushFront(T x){
    Nodo<T> nuevo = new Nodo(x);
    nuevo.siguiente = head;
    head = nuevo;
    if(tail == null){
      tail = head;
    }
  }
  public T popFront(){
    if(head == null) return null;
    T val = head.valor;
    head = head.siguiente;
    if(head == null){
      tail = null;
    }
    return val;
  }
  public T popBack(){
    if(head == tail) {
      if (head == tail){
        T val = head.valor;
        head = tail = null;
        return val;
      }
      Nodo<T> actual = head;
      while (actual.siguiente != tail){
        actual = actual.siguiente;
      }
      T val = tail.valor;
      tail = actual;
      tail.siguiente = null;
      return val;
    }
  }
      
