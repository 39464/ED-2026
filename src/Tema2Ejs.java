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
}
