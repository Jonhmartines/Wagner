
public class Fila{
    private ListaLigadaD lista = new ListaLigadaD();

    public void insere(Object objeto){
        this.lista.adiciona(objeto);
    }

    public Object pega(){
        if(!this.vazia()){
            Object elemento = this.lista.pega(0);
            this.remove();
            return elemento;
        }
        return null;
    }

    private void remove(){
        this.lista.removeDoComeco();
    }

    public boolean vazia(){
        return this.lista.tamanho() == 0;
    }

    public boolean top(){
        return this.lista.tamanho() > 0 ? true : false;
    }

    public ListaLigadaD mostraFila(){
        return this.lista;
    }


}