public class Tema2EjsColas {

    public void invertirCola(Cola cola){
        if(!cola.vacia()){
            int elemento = cola.desencolar();
            invertirCola(cola);
            cola.encolar(elemento);
        }
    }

    public int posicionEnCola(Cola cola, int dato){
        int n = cola.getNumElementos();
        int resultado = -1;
        for(int i = 0; i < n; i++){
            int ele = cola.desencolar();
            cola.encolar(ele); //encolar next para asegurar que la cola se quede como estaba
            if(ele == dato && resultado == -1) resultado = i; //tiene que ser el primero que encuentro !!
        }
        return resultado;
    }

    public Cola mezclarColas(Cola cola1, Cola cola2){
        int n1 = cola1.getNumElementos(), n2 = cola2.getNumElementos();
        int n = Integer.min(n1, n2);
        Cola colaR = new Cola();
        int i, j;
        for(i = 0; i < n; i++){
            int ele1 = cola1.desencolar();
            int ele2 = cola2.desencolar();
            cola1.encolar(ele1); cola2.encolar(ele2);
            colaR.encolar(ele1); colaR.encolar(ele2);
        }
        n = Integer.max(n1, n2);
        for(j = i; j < n; j++){
            if(n == n1) {
                colaR.encolar(cola1.desencolar());
            }else{
                colaR.encolar(cola2.desencolar());
            }
        }
        return colaR;
    }

    public Cola colaMenores(Cola c1, Cola c2){
        int n1 = c1.getNumElementos(), n2= c2.getNumElementos();
        int n;
        if(n1<=n2) n= n1;
        else n= n2;
        Cola colaR = new Cola();
        for(int i=0; i < n; i++){
            int ele1 = c1.desencolar();
            int ele2 = c2.desencolar();
            n1--;
            n2--;

            if(ele1 <= ele2){
                colaR.encolar(ele1);
                c2.encolar(ele2);
            }else {
                colaR.encolar(ele2);
                c1.encolar(ele1);
            }
        }
        for(int i=0; i < n1; i++){
            int dato1 = c1.desencolar();
            c1.encolar(dato1);
        }
        for(int i=0; i < n2; i++){
            int dato2 = c2.desencolar();
            c2.encolar(dato2);
        }
        return colaR;
    }

    public void separarCola(Cola cola, Pila pila){
        int n = cola.getNumElementos();
        for(int i = 0; i < n; i++){
            int ele = cola.desencolar();
            if(i%2==0){
                cola.encolar(ele);
            }
        }
    }
}
