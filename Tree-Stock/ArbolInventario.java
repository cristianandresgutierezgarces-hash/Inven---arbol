// Mejora: se agregan comentarios para explicar el funcionamiento del árbol
public class ArbolInventario {

    Producto raiz;

    public ArbolInventario() {
        raiz = null;
    }

    public Producto insertarRec(Producto raiz, int id, String nombre) {
        if (raiz == null) {
            return new Producto(id, nombre);
        }

        if (id < raiz.id) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, id, nombre);
        } else if (id > raiz.id) {
            raiz.derecho = insertarRec(raiz.derecho, id, nombre);
        }

        return raiz;
    }

    public void insertar(int id, String nombre) {
        raiz = insertarRec(raiz, id, nombre);
    }

    public void inorden(Producto raiz) {
        if (raiz != null) {
            inorden(raiz.izquierdo);
            System.out.println("ID: " + raiz.id + " | Nombre: " + raiz.nombre);
            inorden(raiz.derecho);
        }
    }

    public void mostrarInventario() {
        if (raiz == null) {
            System.out.println("El inventario está vacío.");
        } else {
            inorden(raiz);
        }
    }

    public Producto buscar(Producto raiz, int id) {
        if (raiz == null || raiz.id == id) {
            return raiz;
        }

        if (id < raiz.id) {
            return buscar(raiz.izquierdo, id);
        } else {
            return buscar(raiz.derecho, id);
        }
    }

    public boolean existe(int id) {
        return buscar(raiz, id) != null;
    }
}
