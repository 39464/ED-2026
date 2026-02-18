public class Tema2Ejs {

    public void repetirNVeces(Pila p, int num){
        int elem;
        if (!p.vacia()){
            elem = p.desapilar();

        }
    }

    public void eliminarElemento(Pila p, int dato){
        int elemento;
        if(!p.vacia()){
            elemento = p.desapilar();
            if(elemento != dato) {
                eliminarElemento(p, dato);
                p.apilar(dato);
            }
        }
    }

    public void pilaReorganizable(Pila p, int num){
        eliminarElemento(p, num);
        p.apilar(num);
    }

    public void eliminarElemFondo(Pila p) {
        int ele, resul = -1;
        if (!p.vacia()) {
            ele = p.desapilar();
            if (!p.vacia()) {
                eliminarElemFondo(p);
            } else {
                resul = ele;
            }
        }
    }

    private int comprobarFondo(Pila p, int contador){
        int elem, res = 0;
        if (!p.vacia()) {
            elem = p.desapilar();
            if(!p.vacia()){
                res = comprobarFondo(p, ++contador);
            }else if(contador == elem) {
                res = 0;
            }else if(contador < elem){
                res = 1;
            }else{
                res = -1;
            }
            p.apilar(contador);
        }
        return res;
    }

    public int eliminarElemPosFondo(Pila p, int cont){
        int ele, res = 0;
        if (!p.vacia()) {
            ele = p.desapilar();
            cont++;
            if(!p.vacia()){
                eliminarElemento(p, cont); //si no estoy en el ultimo, sigue
            }else res = ele;
            if(cont != res) p.apilar(ele);
        }
        return res;
    }

    // insertar en el fondo de la pila el dato que te pasan como parámetro
    private void insertarEnFondo(Pila p, int dato){
        int ele;
        if(!p.vacia()){
            ele = p.desapilar();
            insertarEnFondo(p, dato);
            p.apilar(ele);
        }else p.apilar(dato);
    }

    public void moverElementoFondo(Pila p){
        if(!p.vacia()) p.apilar(sacarElemFondo(p));
    }

    private int sacarElemFondo(Pila p){
        int ele, res = 0;
        if (!p.vacia()) {
            ele = p.desapilar();
            if(!p.vacia()){
                res = sacarElemFondo(p); //si no estoy en el ultimo, sigue
                p.apilar(ele);
            }else res = ele;
        }
        return res;
    }

    public void hacerPilaCapicua(Pila p){
        int ele;
        if(!p.vacia()){
            ele = p.desapilar();
            hacerPilaCapicua(p);
            insertarEnFondo(p, ele);
            p.apilar(ele);
        }
    }

    public int eliminarDato(Pila p, int dato){
        int ele;
        int cont= 0;
        if(!p.vacia()){
            ele = p.desapilar();
            cont=eliminarDato(p, ++dato); //????
            if(ele != dato){
                p.apilar(ele);
            }else ++cont;
        }
        return cont;
    }

    public int mayorElemento(Pila p){
        int res=-1;
        if(!p.vacia()){
            res = mayorElemento(p, Integer.MIN_VALUE);
        }
        return res;
    }

    private int mayorElemento(Pila p, int mayor){
        int ele; int res = -1;
        if(!p.vacia()){
            ele = p.desapilar();
            if(ele > mayor){
                mayor = ele;
            }
            res = mayorElemento(p, mayor);
            p.apilar(ele);
        }
        return mayor;
    }

    private Pila quitarPosicionesPares(Pila p, int posicion){
        int ele;
        Pila res;
        if(p.vacia()){
            res = new Pila();
        }else {
            ele = p.desapilar();
            posicion++;
            res = quitarPosicionesPares(p, posicion);
            if(posicion % 2 == 0){
                res.apilar(ele);
            }else p.apilar(ele);
        }
        return res;
    }

    public Pila quitarPosicionesPares(Pila p){
        return quitarPosicionesPares(p, 0);
    }

    public void poneFondoDiferenciaMaximoMinimo(Pila p){ //antes lo hiciste con tres recorridos de la pila, normalmente no se puede
        if(!p.vacia()){
            ponerFondoDiferenciaMaximoMinimo(p, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
    }

    private void ponerFondoDiferenciaMaximoMinimo(Pila p, int min, int max){
        int ele;
        if(!p.vacia()){
            ele = p.desapilar();
            if (ele > max) max = ele;
            if(ele < min) min = ele;
            ponerFondoDiferenciaMaximoMinimo(p, min, max);
            p.apilar(ele);
        }else p.apilar(max-min);
    }

    private int menorElemento(Pila p, int menor){
        int ele; int res = -1;
        if(!p.vacia()){
            ele = p.desapilar();
            if(ele < menor){
                menor = ele;
            }
            res = menorElemento(p, menor);
            p.apilar(ele);
        }
        return menor;
    }
}
