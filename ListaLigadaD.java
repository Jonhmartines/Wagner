public class ListaLigadaD {
    private CelulaDupla primeira;
    private CelulaDupla ultima;
    private int total;

    public void adiciona(Object elemento) {
        if (this.total == 0) {
            this.adicionaNoComeco(elemento);
        } else {
            CelulaDupla nova = new CelulaDupla(elemento);
            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.total++;
        }
    }

    public void adiciona(int posicao, Object elemento) {
        if (posicao == 0) {
            this.adicionaNoComeco(elemento);
        } else if (posicao == this.total) {
            this.adiciona(elemento);
        } else {
            CelulaDupla anterior = this.pegaCelula(posicao - 1);
            CelulaDupla proxima = anterior.getProxima();
            CelulaDupla nova = new CelulaDupla(proxima, elemento);
            
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            
            this.total++;
        }
    }

    public void adicionaNoComeco(Object elemento) {
        if (this.total == 0) {
            CelulaDupla nova = new CelulaDupla(elemento);
            this.primeira = nova;
            this.ultima = nova;
        } else {
            CelulaDupla nova = new CelulaDupla(this.primeira, elemento);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }
        this.total++;
    }

    public Object pega(int posicao) {
        return this.pegaCelula(posicao).getElemento();
    }

    public CelulaDupla pegaCelula(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        
        CelulaDupla atual = this.primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }

    public boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.total;
    }

    public void removeDoComeco() {
        if (!this.posicaoOcupada(0)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        
        this.primeira = this.primeira.getProxima();
        this.total--;
        
        if (this.total == 0) {
            this.ultima = null;
        } else {
            this.primeira.setAnterior(null);
        }
    }

    public void removeDoFim() {
        if (!this.posicaoOcupada(this.total - 1)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        
        if (this.total == 1) {
            this.removeDoComeco();
        } else {
            CelulaDupla penultima = this.ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.total--;
        }
    }

    public void remove(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        
        if (posicao == 0) {
            this.removeDoComeco();
        } else if (posicao == this.total - 1) {
            this.removeDoFim();
        } else {
            CelulaDupla anterior = this.pegaCelula(posicao - 1);
            CelulaDupla atual = anterior.getProxima();
            CelulaDupla proxima = atual.getProxima();
            
            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);
            
            this.total--;
        }
    }

    public int tamanho() {
        return this.total;
    }

    public String toString() {
        if (this.total == 0) {
            return "[]";
        }
        
        StringBuilder builder = new StringBuilder("[");
        CelulaDupla atual = this.primeira;
        
        for (int i = 0; i < this.total - 1; i++) {
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
        }
        
        builder.append(atual.getElemento());
        builder.append("]");
        return builder.toString();
    }
}