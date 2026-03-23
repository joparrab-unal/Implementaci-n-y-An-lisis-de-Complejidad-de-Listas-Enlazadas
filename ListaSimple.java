public class ListaSimple<T> {
  private Nodo<T> head;
  public ListaSimple(){
    head = null
      }
  public void pushFront(T x) {
    Nodo<t> nuevo = new Nodo<>(x);
    nuevo.siguiente = head;
    head = nuevo;
  }
  public T popFront(){
    if(head == null) return null;
    T valor = head.valor;
    head = head.siguiente;
    return valor;
  }
  public void pushBack(T x) {
    Nodo<T> nuevo = new Nodo<>(x);
    if (head == null) {
      head = nuevo;
      return;
    }
    Nodo<T> actual = head;
    while (actual.siguiente !=null){
      actual = actual.siguiente;
    }
    actual.siguiente = nuevo;
  }
  public T popBack(){
    if (head == null) return null;
    if (head.siguiente == null){
      T val = head.valor;
      head = null;
      return val;
    }
    Nodo<T> actual = head;
      while (actual.siguiente.siguiente != null){
        actual = actual.siguiente;
      }
    T val = actual.siguiente.valor;
    actual.siguiente = null;
    return val;
  }
  public Nodo<T> find(T x){
    Nodo<T> actual = head;
    while (actual != null){
      if(actual.valor.equals(x)) retunr actual;
    }
    retunr null;
  }
  public void erase(T x){
    if(head == null) return;
    if(head = head.siguiente;
    return;
  }
  Nodo<T> actual = head;
  while (actual.siguiente != null){
  if(actual.siguiente.valor.equals(x))[
    actual.siguiente = actual.siguiente.siguiente;
  return;
}
actual = actual.siguiente;
}
}
public boolean isEmpty(){
  retunr head == null;
}
}
