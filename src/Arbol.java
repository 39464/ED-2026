public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
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

    public int sumaDatosNivel(int nivel) {
        return sumaDatosNivel(this.raiz, nivel, 1);
    }

    private int sumaDatosNivel(NodoArbol nodo, int nivel, int actual) {
        int res = 0;
        if (nodo != null) {
            if (actual == nivel) {
                res = nodo.getDato();
            } else {
                res = sumaDatosNivel(nodo.getDerecho(), nivel, actual + 1) + sumaDatosNivel(nodo.getIzquierdo(), nivel, actual + 1);
            }
        }
        return res;
    }

    public int altura() {
        return altura(this.raiz, 1);
    }

    private int altura(NodoArbol nodo, int cont) {
        int res = 0;
        if (nodo != null) {
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                res = cont;
            } else {
                res = Math.max(altura(nodo.getIzquierdo(), cont + 1), altura(nodo.getDerecho(), cont + 1));
            }
        }
        return res;
    }

    public void completar2hijos() {
        if (this.raiz != null) completar2hijos(this.raiz, 1);
    }

    public void completar2hijos(NodoArbol nodo, int nivel) {
        if (nodo != null) {
            if (nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
                completar2hijos(nodo.getIzquierdo(), nivel + 1);
                completar2hijos(nodo.getDerecho(), nivel + 1);
            } else if (nodo.getIzquierdo() != null) {
                nodo.setDerecho(new NodoArbol(nivel + 1, null, null));
                completar2hijos(nodo.getIzquierdo(), nivel + 1);
            } else if (nodo.getDerecho() != null) {
                nodo.setIzquierdo(new NodoArbol(nivel + 1, null, null));
                completar2hijos(nodo.getDerecho(), nivel + 1);
            } //si ambos hijos son null, no hacer nada
        }//si nodo es null, no hacer nada
    }

    public int sumarHojasNivel(int maxNivel) {
        return sumarHojasNivel(this.raiz, maxNivel, 1);
    }

    private int sumarHojasNivel(NodoArbol nodo, int nivel, int maxNivel) {
        int res = 0;
        if (nodo != null && nivel < maxNivel) { //TERMINA DE CONTAR EN EL MAXNIVEL
            if (nodo.getDerecho() == null && nodo.getIzquierdo() == null) {
                res = nodo.getDato();
            } else {
                res = sumarHojasNivel(nodo.getDerecho(), nivel + 1, maxNivel) + sumarHojasNivel(nodo.getIzquierdo(), nivel + 1, maxNivel);
            }
        }
        return res;
    }

    public void invertir() {
        invertir(this.raiz);
    }

    private NodoArbol invertir(NodoArbol nodo) {
        NodoArbol aux;
        if (nodo != null) {
            aux = nodo.getIzquierdo();
            nodo.setIzquierdo(this.invertir(nodo.getDerecho()));
            nodo.setDerecho(invertir(aux));
        }
        return nodo;
    }

    public boolean esUnivaluado() {
        if (this.raiz == null) return true;
        else return esUnivaluado(this.raiz, raiz.getDato());
    }

    private boolean esUnivaluado(NodoArbol nodo, int valor) {
        boolean res = true;
        if (nodo != null) {
            res = valor == nodo.getDato() && esUnivaluado(nodo.getIzquierdo(), valor) && esUnivaluado(nodo.getDerecho(), valor);
        }
        return res;
    }

    public void mostrarClavesUnHijo() {
        System.out.println("Clas con un hijo, descendiente: ");

    }

    private void mostrarClavesUnHijoRec(NodoArbol nodo) {
        if (nodo != null) {
            mostrarClavesUnHijoRec(nodo.getDerecho());
            if (nodo.getIzquierdo() != null) {
            }
        }
    }

    public void mostrarClavesEntreDos(int c1, int c2) {
        System.out.println("Claves entre " + c1 + " y " + c2);
        if (c1 < c2) mostrarClavesEntreDos(raiz, c1, c2);
        else mostrarClavesEntreDos(raiz, c2, c1);
    }

    private void mostrarClavesEntreDos(NodoArbol nodo, int menor, int mayor) {
        if (nodo != null) {
            if (nodo.getDato() >= mayor) mostrarClavesEntreDos(nodo.getIzquierdo(), menor, mayor);
            else if (nodo.getDato() <= menor) mostrarClavesEntreDos(nodo.getDerecho(), menor, mayor);
            else {
                mostrarClavesEntreDos(nodo.getIzquierdo(), menor, mayor);
                System.out.println(nodo.getDato() + " ");
                mostrarClavesEntreDos(nodo.getDerecho(), menor, mayor);
            }
        }
    }

    public boolean comprobarSiEnHoja(int clave) {
        return comprobarSiEnHojaRec(raiz, clave);
    }

    private boolean comprobarSiEnHojaRec(NodoArbol nodo, int clave) {
        boolean res = false;
        if (nodo != null) {
            if (nodo.getDato() == clave && nodo.getDerecho() == null && nodo.getIzquierdo() == null) res = true;
            else if (nodo.getDato() < clave) res = comprobarSiEnHojaRec(nodo.getIzquierdo(), clave);
            else if (nodo.getDato() > clave) res = comprobarSiEnHojaRec(nodo.getDerecho(), clave);
        }
        return res;
    }


    public int antecesoresComunes(int c1, int c2) {
        int res = 0;
        if (c1 > c2) res = antecesoresComunes(raiz, c1, c2);
        else res = antecesoresComunes(raiz, c2, c1);
        return res;
    }

    private int antecesoresComunes(NodoArbol nodo, int mayor, int menor) {
        int res = 0;
        if (nodo != null) {
            if (nodo.getDato() > mayor) res = 1 + antecesoresComunes(nodo.getIzquierdo(), mayor, menor);
            else if (nodo.getDato() < menor) res = 1 + antecesoresComunes(nodo.getDerecho(), mayor, menor);
            else if (nodo.getDato() > menor && nodo.getDato() < mayor) res = 1;
        }
        return res;
    }

    public int diferenciaNiveles(int c1, int c2) {
        int res = 0;
        int altC1 = buscarNivel(raiz, c1);
        int altC2 = buscarNivel(raiz, c2);
        if (altC1 > altC2) res = altC1 - altC2;
        else res = altC2 - altC1;
        return res;
    }

    private int buscarNivel(NodoArbol nodo, int dato) {
        int res = 0;
        if (nodo.getDato() == dato) {
            res = 1;
        } else if (nodo.getDato() > dato) {
            res = 1 + buscarNivel(nodo.getIzquierdo(), dato);
        } else {
            res = 1 + buscarNivel(nodo.getDerecho(), dato);
        }
        return res;
    }
}




