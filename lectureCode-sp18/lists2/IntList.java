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
	// Midterm 1 Q5:
	/** We want to add a method to IntList so that if 2 numbers in a row are thesame,
	we add them together and make one large node. For example:
	1 ⇒ 1 ⇒ 2 ⇒ 3 becomes 2 ⇒ 2 ⇒ 3 which becomes 4 ⇒ 3.For this problem,
	you will not have access to any add, size, or remove method.
	*/
	public void addAdjacent(){
		IntList p = this;
		if(p.rest == null){
			System.out.println("Nothing to do");
		}
		IntList s = p;
		while(s.rest != null){
			if(s.first == s.rest.first){
				s.first = s.first + s.rest.first;
				s.rest = s.rest.rest;
				s.addAdjacent();
			}else if(s.first != s.rest.first){
				s = s.rest;
				s.addAdjacent();
			}
		}
	}

	public IntList addSquare(int n){
		if (rest == null){
			rest = new IntList(first*first, new IntList(n, null));
			return this;
		}else{
			rest = new IntList(first*first, rest.addSquare(n));
			return this;
		}
	}
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
		IntList L = new IntList(2, null);
		L = new IntList(1, L);
//		L = new IntList(1, L);
//		L = new IntList(1, L);
		L.addSquare(5);
		L.addSquare(7);
		System.out.println(L.size());
//		System.out.printf("%s, %s\n", L.get(0), L.get(1));
	}
}
