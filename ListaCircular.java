public class ListaCircular {

    private Celula cursor;
    private int total;

    public ListaCircular() {
        this.cursor = null;
    }

    public int tamanho() {
        return this.total;
    }

    public void proximo() {
        this.cursor = this.cursor.getProximo();
    }

    public Object getElemento() {
        return this.cursor.getElemento();
    }

    public boolean ultimoElemento() {
        return (this.cursor == this.cursor.getProximo());
    }

    public void avanca(int posicao) {
        for (int i = 1; i <= posicao; i++) {
            this.proximo();
        }
    }

    public void adiciona(Object elemento) {
        Celula nodo = new Celula(elemento);
        if (this.cursor == null) {
            nodo.setProximo(nodo);
            this.cursor = nodo;
        }
        else {
            nodo.setProximo(this.cursor.getProximo());
            this.cursor.setProximo(nodo);
            this.cursor = nodo;
        }
        this.total++;
    }

    public void remove() {
        if (this.cursor != null) {
            if (this.cursor == this.cursor.getProximo()) {
                this.cursor = null;
            }
            else {
                this.cursor.setProximo(this.cursor.getProximo().getProximo());
                this.total--;
            }
        }
    }

    public String toString() {
        if (this.total == 0) {
            return "[]";
        }
        String s = "[" + this.getElemento();
        Celula velhoCursor = this.cursor;
        for (this.proximo(); velhoCursor != this.cursor; this.proximo()) {
            s += "," + this.getElemento();
        }
        return s + "]";
    }

     public String toString() {
         if (this.total == 0) {
             return "[]";
         }
       StringBuilder builder = new StringBuilder("[");
         Celula atual = this.cursor;
         for (int i = 0; i < this.total - 1; i++) {
             builder.append(atual.getElemento());
             builder.append(", ");
             atual = atual.getProximo();
         }
         builder.append(atual.getElemento());
         builder.append("]");
         return builder.toString();
     }
}
