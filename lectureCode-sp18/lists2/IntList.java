public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	// Try to create addFirst method compare to addFirst method of SLList
	public void addFirst(int x){
			IntList instL = rest;
			IntList copyL = new IntList(first, null);
			IntList copyLL = copyL;
			while(instL != null){
				copyLL.rest = new IntList(instL.first, null);
				copyLL = copyLL.rest;
				instL = instL.rest;
			}
			first = x;
			rest = copyL;
	}
	// conclusion: verbose and inefficien: take O(n) compare to O(1) time complex

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);
		L.addFirst(99);
		System.out.printf("%s, %s, %s, %s", L.get(0), L.get(1), L.get(2), L.get(3));
	}
}
