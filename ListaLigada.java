public class ListaLigada {
    private Celula primeira;
    private Celula ultima;
    private int total;

    public void adiciona(Object elemento){
        if(total == 0){
            this.adicionaNoComeco(elemento);
        } 
        else{
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            this.ultima = nova;
            this.total++;
        }
    }

    public void adicionaNoComeco(Object elemento){
        Celula nova = new Celula(this.primeira, elemento);
        this.primeira = nova;
        if(this.total == 0){
            this.ultima = this.primeira;
        }
        this.total++;
    }

    public Object pega(int posicao){
        return this.pegaCelula(posicao).getElemento();
    }

    public Celula pegaCelula(int posicao){
        if(!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição não existe");
        }
        Celula atual = this.primeira;
        for(int i = 0; i < posicao; i++){
            atual = atual.getProxima();
        }
        return atual;
    }

    public boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.total;
    }

    public void removeDoComeco(){
        if(!posicaoOcupada(0)){
            throw new IllegalArgumentException("Posição não existe");
        }
        this.primeira = this.primeira.getProxima();
        this.total--;
        if(this.total == 0){
            this.ultima = null;
        }
    }

    public void removeDoFim() {
        if (!this.posicaoOcupada(this.total - 1)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        if (this.total == 1) {
            this.removeDoComeco();
        } else {
            Celula penultima = this.pegaCelula(this.total - 2);
            penultima.setProxima(null);
            this.ultima = penultima;
            this.total--;
        }
    }

    public int tamanho(){
        return this.total;
    }

    public String toString(){
        if(total == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        Celula atual = primeira;
        for(int i = 0; i < total - 1; i++){
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
        }
        builder.append(atual.getElemento());
        builder.append("]");
        return builder.toString();
    }
}
