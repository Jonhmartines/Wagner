public class ListaSkip {

    private static class SkipNode {
        public int elem;
        public SkipNode[] next;

        public SkipNode(int pVal, int pLev) {
            elem = pVal;
            next = new SkipNode[pLev];
        }
    }

    private SkipNode head;
    private int maxLevel;
    private int actualLevel;
    private int total;

    public ListaSkip(int pVal, int pMaxLevel) {
        head = new SkipNode(pVal, pMaxLevel);
        maxLevel = pMaxLevel;
        actualLevel = 0;
        total = 1;
    }

    public boolean isEmpty() {
        for (int i = 0; i < head.next.length; i++) {
            if (head.next[i] != null)
                return false;
        }
        return true;
    }

    private int rand() {
        int i, j;
        double t = Math.random();
        for (i = 1, j = 2; i < maxLevel; i++, j += j) {
            if (t * j > 1.0)
                break;
        }
        if (i > actualLevel)
            actualLevel = i;
        return i;
    }

    public void insert(int pElem) {
        int rnd = rand();
        SkipNode novo = new SkipNode(pElem, rnd);
        recInsert(head, novo, actualLevel - 1);
        total++;
    }

    private static void recInsert(SkipNode phead, SkipNode pNew, int pLev) {
        if (phead.next[pLev] == null || pNew.elem < phead.next[pLev].elem) {

            if (pLev < pNew.next.length) {
                pNew.next[pLev] = phead.next[pLev];
                phead.next[pLev] = pNew;
            }

            if (pLev == 0)
                return;

            recInsert(phead, pNew, pLev - 1);

        } else {
            recInsert(phead.next[pLev], pNew, pLev);
        }
    }

    public String toString() {
        if (isEmpty())
            return "Lista vazia";

        SkipNode node;
        String str = "Lista Skip\n";
        str += head.elem;

        for (node = head.next[0]; node != null; node = node.next[0]) {
            str += "\t" + node.elem;
        }

        return str + "\t*\n";
    }

    public static void main(String[] args) {
        ListaSkip lista = new ListaSkip(-1, 5);

        lista.insert(10);
        lista.insert(20);
        lista.insert(35);
        lista.insert(40);
        lista.insert(46);
        lista.insert(50);

        System.out.println(lista);
    }
}