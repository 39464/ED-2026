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
        return numInsertados;
    }

    public boolean eliminar(int valor){
        boolean resultado = false;
        if(contiene(valor)){
            int pos = 0;
            while(pos < numElementos && datos[pos] < valor){
                pos++;
            }
            if(pos < numElementos) {
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
        nuevo.datos = this.datos;
        nuevo.numElementos = this.numElementos;
        return nuevo;
    }

    public void unir(Conjunto conjunto){
        insertar(conjunto.datos);
    }


}
