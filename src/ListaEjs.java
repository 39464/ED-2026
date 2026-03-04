public class ListaEjs {

    public Lista sinRepetir(Lista lista){
        Lista resultado = new Lista();
        Iterador it = lista.getIterador();
        while(it.hasNext()){
            int elemento = it.next();
            if(!resultado.contiene(elemento)){
                resultado.insertar(elemento);
            }
        }
        return resultado;
    }

    public boolean sonDistintos(Lista lista){
        Lista aux = new Lista();
        boolean res = true;
        Iterador it = lista.getIterador();
        while(it.hasNext() && res){
            int elemento = it.next();
            if(aux.contiene(elemento)){
                res = false;
            }else{
                aux.insertar(elemento);
            }
        }
        return res;
    }

    public boolean ordenada(Lista lista){
        boolean res = true;
        Iterador it = lista.getIterador();
        if(lista.getNumElementos()>0){ //preguntar, porque se accede al primer elemento
            int anterior= it.next();
            while(it.hasNext() && res){
                int elemento = it.next();
                if(elemento>anterior){
                    anterior = elemento;
                }else{ res = false; }
            }
        }
        return res;
    }

    public int mayorDeTres(Lista lista){
        int res = 0;
        if(lista.getNumElementos()>0){
            int prim = lista.getElemento(0);
            int ult = lista.getElemento(lista.getNumElementos()-1);
            int medio = lista.getElemento((lista.getNumElementos()-1)/2);
            if(prim<medio){
                if(medio<ult) res = ult;
                else res = medio;
            }
        }
        return res;
    }

    public boolean identicas(Lista l1, Lista l2){
        boolean res = true;
        if(l1.getNumElementos()==l2.getNumElementos()){
            Iterador it1 = l1.getIterador();
            Iterador it2 = l2.getIterador();
            while(it1.hasNext() && it2.hasNext() &&res){
                if(it1.next()!=it2.next()){
                    res = false;
                }
            }
        }else{ res = false; }
        return res;
    }

    public Lista interseccion(Lista l1, Lista l2){
        Lista res = new Lista();
        Iterador it = l1.getIterador();
        while(it.hasNext()){
            int ele = it.next();
            if(l2.contiene(ele) && !res.contiene(ele)){
                res.insertar(ele);
            }
        }
        return res;
    }

    public boolean mismoContenido(Lista l1, Lista l2){
        boolean res = true;
        Lista copia = new Lista();
        if(l1.getNumElementos()==l2.getNumElementos()){
            Iterador it = l2.getIterador();
            while(it.hasNext()){
                copia.insertar(it.next());
            }
            it = l1.getIterador();
            while(it.hasNext()){
                int ele = it.next();
                if(!copia.borrar(ele)){ res = false;}
            }
        }else{
            res = false;
        }
        return res && copia.getNumElementos()==0;
    }
}
