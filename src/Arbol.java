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

    public int altura(){
        return altura(this.raiz, 1);
    }

    private int altura(NodoArbol nodo, int cont){
        int res=0;
        if(nodo != null){
            if(nodo.getIzquierdo()== null && nodo.getDerecho()== null){ res = cont; }
            else{
                res = Math.max(altura(nodo.getIzquierdo(), cont+1), altura(nodo.getDerecho(), cont+1));
            }
        }
        return res;
    }

    public void completar2hijos(){
        if(this.raiz != null) completar2hijos(this.raiz, 1);
    }

    public void completar2hijos(NodoArbol nodo, int nivel){
        if(nodo != null){
            if(nodo.getIzquierdo() != null && nodo.getDerecho() != null){
                completar2hijos(nodo.getIzquierdo(), nivel+1);
                completar2hijos(nodo.getDerecho(), nivel+1);
            }
            else if(nodo.getIzquierdo() != null){
                nodo.setDerecho(new NodoArbol(nivel+1, null, null));
                completar2hijos(nodo.getIzquierdo(), nivel+1);
            }
            else if(nodo.getDerecho() != null){
                nodo.setIzquierdo(new NodoArbol(nivel+1, null, null));
                completar2hijos(nodo.getDerecho(), nivel+1);
            } //si ambos hijos son null, no hacer nada
        }//si nodo es null, no hacer nada
    }
}
