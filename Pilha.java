public class Pilha{
    private ListaLigadaD lista = new ListaLigadaD();

    public void empilha(Object elemento){
        this.lista.adiciona(elemento);
    }

    public Object desempilha(){
        if(!this.vazia()){
            Object dados = this.lista.pega(lista.tamanho()-1);
            this.lista.remove(lista.tamanho()-1);
            return dados;
        }
        return null;
    }

    public boolean vazia(){
        return this.lista.tamanho() == 0;
    }

    public boolean top(){
        return this.lista.tamanho() > 0 ? true : false;
    }

    public ListaLigadaD mostra(){
        return this.lista;
    }
}