public class Conjunto {
    private int[] datos;
    private final int MAXIMO;
    private int numElementos;

    public Conjunto(int maximo){
        MAXIMO = maximo;
        datos = new int[MAXIMO];
        numElementos = 0;
    }

    public Conjunto(){
        MAXIMO = 10;
        numElementos = 0;
    }

    public boolean vacio() {return numElementos == 0;}

    public int cardinalidad(){return numElementos;}

    public boolean contiene(int valor){
        int i =0;
        while(i <= numElementos && datos[i]<valor){
            i++;
        }
        return i<= numElementos && datos[i]==valor;
    }

    public boolean insertar(int valor) {
        boolean resultado;
        if (numElementos < MAXIMO) {
            int pos = 0;
            while (pos < numElementos && datos[pos] < valor) { //siempre localizar con un while
                pos++;
            }
            if (pos == numElementos || datos[pos] > valor) {
                for (int i = numElementos - 1; i >= pos; i--) {
                    datos[i + 1] = datos[i];
                }
                datos[pos] = valor;
                numElementos++;
                resultado = true;
            } else {
                resultado = false;
            }
    }else {
        resultado = false;
    }
        return resultado;
    }

    public int insertar(int[] vector){
        int numInsertados = 0;
        for (int i = 0; i < vector.length; i++) {
            if(this.insertar(vector[i])){
                numInsertados++;
            }
        }
        this.numElementos+=numInsertados;
        return numInsertados;
    }

    public boolean eliminar(int valor){
        boolean resultado = false;
        if(contiene(valor)){
            int pos = 0;
            while(pos < numElementos && datos[pos] < valor){
                pos++;
            }
            if(pos < numElementos && datos[pos] == valor) {
                for (int i = pos+1; i < numElementos; i++) {
                    datos[i-1] = datos[i];
                }
                numElementos--;
                datos[numElementos] = Integer.parseInt(null);
                resultado = true;
            }
        }
        return resultado;
    }

    public void mostrar(){
        System.out.println("[");
        for(int i = 0; i < numElementos-1; i++){
            System.out.println(datos[i]+ ", ");
        }
        if(numElementos > 0){
            System.out.println(datos[numElementos-1]);
        }
        System.out.println("]");
    }

    public int getElemento(int valor){ return datos[valor];}

    public Conjunto copia(){
        Conjunto nuevo = new Conjunto(MAXIMO);
        nuevo.insertar(this.datos);
        return nuevo;
    }

    public void unir(Conjunto conjunto){
        insertar(conjunto.datos);
    }

    public Conjunto union(Conjunto conjunto){
        Conjunto union = new Conjunto(this.MAXIMO+conjunto.MAXIMO);
        union.insertar(conjunto.datos);
        union.insertar(this.datos);
        return union;
    }

    public boolean iguales(Conjunto conjunto){
        boolean resultado = true;
        if(this.cardinalidad() != conjunto.cardinalidad()){
            resultado = false;
        }else {
            int i = 0;
            while (i < this.numElementos && resultado) {
                if (conjunto.datos[i] != this.datos[i]) {
                    resultado = false;
                }
                i++;
            }
        }
        return resultado;
    }

    public Conjunto interseccion(Conjunto conjunto){
        Conjunto interseccion = new Conjunto(Math.min(this.MAXIMO, conjunto.MAXIMO));
        interseccion.insertar(this.datos); interseccion.union(conjunto);
        for(int i = 0; i < this.numElementos; i++){
            if(interseccion.datos[i] == interseccion.datos[i+1]){
                interseccion.eliminar(datos[i]);
            }
        }
        return interseccion;
    }

    public boolean contiene(Conjunto conjunto){
        return (conjunto.cardinalidad() == this.interseccion(conjunto).cardinalidad());
    }

    public Conjunto diferencia(Conjunto conjunto){
        Conjunto diferencia = this.copia();
        Conjunto interseccion = this.interseccion(conjunto);
        for(int i = 0; i < this.numElementos; i++){
            for(int j = 0; j < this.numElementos; j++){
                if(diferencia.datos[i] == interseccion.datos[j]){
                    diferencia.eliminar(datos[i]);
                }
            }
        }
        return diferencia;
    }
}
