public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size(){
    if(this.rest == null){
      return 1;
    }else{
      return 1 + this.rest.size();
    }
  }

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList L = this;
    int size = 1;
    while(L.rest != null){
      size += 1;
      L = L.rest;
    }
    return size;
  }

	/** Returns the ith value in this list.*/
	public int get(int i) {
		if(i == 0){
      return this.first;
    }else{
      return this.rest.get(i - 1);
    }
  }
	// return number at index i iterative method
  public int getIter(int i){
    int index = 0;
    IntList L = this;
    if(index == i){
      return L.first;
    }else{
      while ((index < i) && (L != null)){
        index += 1;
        L = L.rest;
      }
      return L.first;
    }
  }
	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);

		System.out.println(L.iterativeSize());
	}
}
