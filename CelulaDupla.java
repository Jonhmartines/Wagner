public class CelulaDupla {
    private CelulaDupla proxima;
    private CelulaDupla anterior;
    private Object elemento;

    public CelulaDupla(CelulaDupla proxima, Object elemento){
        this.proxima = proxima;
        this.elemento = elemento;
    }

    public CelulaDupla(Object elemento){
        this.elemento = elemento;
    }

    public void setProxima(CelulaDupla proxima){
        this.proxima = proxima;
    }

    public CelulaDupla getProxima(){
        return proxima;
    }

    public Object getElemento() {
        return elemento;
    } 

    public CelulaDupla getAnterior() {
        return anterior;
    }

    public void setAnterior(CelulaDupla anterior) {
        this.anterior = anterior;
    }
}