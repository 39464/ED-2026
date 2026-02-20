public class PruebasILC {
    public static void main(String[] args){
        Cola cola1 = new Cola();
        Cola cola2 = new Cola();
        cola1.encolar(1); cola1.encolar(3); cola1.encolar(5); cola1.encolar(7);
        cola2.encolar(2); cola2.encolar(4); cola2.encolar(6); cola2.encolar(8); cola2.encolar(10);

        Tema2EjsColas ejs = new Tema2EjsColas();
        ejs.mezclarColas(cola1, cola2).mostrar();
    }

}
