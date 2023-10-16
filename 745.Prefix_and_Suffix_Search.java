class WordFilter {

    final Node prefRoot;
    final Node suffRoot;

    public WordFilter(String[] words) {
        prefRoot = new Node();
        for (int i=0; i<words.length; i++) {
            Node head = prefRoot;
            for (char c : words[i].toCharArray()) {
                int index = c-'a';
                if (head.children[index] == null) {
                    head.children[index] = new Node();
                }
                head = head.children[index];
                head.ref.add(i);
            }
        }
        suffRoot = new Node();
        for (int i=0; i<words.length; i++) {
            Node tail = suffRoot;
            for (char c : new StringBuilder(words[i]).reverse().toString().toCharArray()) {
                int index = c-'a';
                if (tail.children[index] == null) {
                    tail.children[index] = new Node();
                }
                tail = tail.children[index];
                tail.ref.add(i);
            }
        }
    }
    
    public int f(String pref, String suff) {
        Node head = prefRoot;
        for (char c : pref.toCharArray()) {
            int index = c-'a';
            if (head.children[index] == null) {
                return -1;
            }
            head = head.children[index];
        }

        Node tail = suffRoot;
        for (char c : new StringBuilder(suff).reverse().toString().toCharArray()) {
            int index = c-'a';
            if (tail.children[index] == null) {
                return -1;
            }
            tail = tail.children[index];
        }

        int i=head.ref.size()-1;
        int j=tail.ref.size()-1;
        while (i>=0 && j>=0) {
            if (head.ref.get(i) > tail.ref.get(j)) {
                i--;
            } else if (head.ref.get(i) < tail.ref.get(j)) {
                j--;
            } else {
                return head.ref.get(i);
            }
        }
        
        return -1;
    }
}

class Node {
    Node[] children;
    List<Integer> ref;
    public Node() {
        children = new Node[26];
        ref = new ArrayList<>();
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
