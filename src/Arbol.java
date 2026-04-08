public class Arbol {
    private NodoArbol raiz;
    public Arbol(){
        raiz = null;
    }
    public Arbol(int dato) {
        raiz = new NodoArbol(dato);
    }
    public Arbol(int dato, Arbol izquierdo, Arbol derecho) {
        NodoArbol nodoIzq = null;
        NodoArbol nodoDer = null;
        if (izquierdo != null) {
            nodoIzq = izquierdo.raiz;
        }
        if (derecho != null) {
            nodoDer = derecho.raiz;
        }
        raiz = new NodoArbol(dato, nodoIzq, nodoDer);
    }
    public boolean igual(Arbol arbol){
        return igualRec(this.raiz, arbol.raiz);
    }

    private boolean igualRec(NodoArbol nodo1, NodoArbol nodo2){
        boolean resul = false;
        if(nodo1 == null && nodo2 == null){
            resul = true;
        } else if(nodo1 == null || nodo2 == null){
            resul = false;
        }else{
            if(nodo1.getDato() == nodo2.getDato()){
                resul = igualRec(nodo1.getDerecho(), nodo2.getDerecho());
            }
        }
    }

    public int sumaDatosNivel(int nivel){
        return sumaDatosNivel(this.raiz, nivel, 1);
    }

    private int sumaDatosNivel(NodoArbol nodo, int nivel, int actual){
        int res = 0;
        if(nodo != null){
            if(actual == nivel){
                res = nodo.getDato();
            }else{
                res = sumaDatosNivel(nodo.getDerecho(), nivel, actual+1)+sumaDatosNivel(nodo.getIzquierdo(), nivel, actual+1);
            }
        }
        return res;
    }

}
