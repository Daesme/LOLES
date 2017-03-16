/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.ArbolProductos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import Modelo.Producto;

/**
 *
 * @author Labing
 */
public class ProductoDao {

    private RandomAccessFile productoDB;
    private ArbolProductos arbol = new ArbolProductos();
    
    public int id;
    public String nuevo1="";
    public int nuevo2;
    public int ext;
    
    public int id2;
    public String nuevo3="";
    public int nuevo4;
    public int ext2;
    
    public ProductoDao() throws FileNotFoundException {
       
        this.productoDB = new RandomAccessFile("C:\\Users\\Labing\\Desktop\\producto.txt", "rw");
    }
  
    public boolean insertar(Producto producto) throws IOException {
        long posicionMemoria = this.productoDB.length();
        this.productoDB.seek(posicionMemoria);
        arbol.Ingresar(producto.getId(), posicionMemoria);
        arbol.ListarArbol();
        this.productoDB.writeInt(producto.getId());
        
        for (int i = 0; i < producto.getDescripcion().length; i++) {
            char letra = producto.getDescripcion()[i];
            this.productoDB.writeChar(letra);
        }
        this.productoDB.seek(posicionMemoria + 44);
//        System.out.println(this.profesorDB.getFilePointer());

       
            
            this.productoDB.writeInt(producto.getCantidad());
        
        this.productoDB.seek(posicionMemoria + 84);
//        System.out.println(this.profesorDB.getFilePointer());

        this.productoDB.writeInt(producto.getValor());

        return true;
    }

    public boolean actualizar(Producto profesor) {

        return false;
    }

    public boolean borrar(Producto profesor) {
        return false;
    }

    public ArrayList<Producto> listarTodo() throws IOException {
        
        
        
        
        for (long i = 0; i < this.productoDB.length(); i = i + 88) {
            this.productoDB.seek(i);
            id2 = this.productoDB.readInt();
            System.out.println(id2);
            for (int j = 0; j < 20; j++) {
                nuevo3 = nuevo3 + this.productoDB.readChar();
            }
            System.out.println(nuevo3);
             System.out.println(nuevo4);
            nuevo4 = this.productoDB.readInt();
            System.out.println(nuevo4);
            System.out.println("");
            
            System.out.println(nuevo4);
            ext2 = this.productoDB.readInt();
            System.out.println(ext2);
            System.out.println("");
        }
        return null;
    }

    public void ListarUnitario(int identificacion) throws IOException {
   
        long posm = arbol.Buscar(identificacion);
        this.productoDB.seek(posm);
        id = this.productoDB.readInt();
        for (int j = 0; j < 20; j++) {
            nuevo1 = nuevo1 + this.productoDB.readChar();
        }
       nuevo2=this.productoDB.readInt();
       
        ext = this.productoDB.readInt();

    }

    public void destructor() throws IOException {
        this.productoDB.close();
    }
}
