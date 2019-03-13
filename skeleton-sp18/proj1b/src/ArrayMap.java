import java.util.ArrayList;
import java.util.List;

public class ArrayMap<K, V> implements Map61B<K, V>{
  private K[] keys;
  private V[] values;
  int size;

  public ArrayMap() {
    keys = (K[]) new Object[100];
    values = (V[]) new Object[100];
    size = 0;
  }

  /** Returns the index of the given key if it exists,
   * -1 otherwise.
   */
  private int keyIndex(K key) {
    for (int i = 0; i < size; i += 1) {
      if (keys[i].equals(key)) {
        return i;
      }
    }
    return -1;
  }

  public boolean containsKey(K key) {
    int index = keyIndex(key);
    if (index > -1) {
      return true;
    }
    return false;
//    return index > -1;
  }
  public void put(K key, V value) {

  }
  public V get(K key) {
    return null;
  }
  public int size() {
    return size;
  }
  public List<K> keys() {
    List<K> keyList = new ArrayList<>();
    for (int i = 0; i < keys.length; i++) {
      keyList.add(keys[i]);
    }
    return keyList;
  }
}
