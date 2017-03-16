/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Provedor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import Modelo.ArbolProvedor;

/**
 *
 * @author crist
 */
public class ProvedorDAO {
    private RandomAccessFile ProvedorDB;
    private ArbolProvedor arbol = new ArbolProvedor();
    public int id;
    public String nuevo1="";
    public String nuevo2="";
    public int tel;
    
    public int id2;
    public String nuevo3="";
    public String nuevo4="";
    public int tel2;
    
    public ProvedorDAO() throws FileNotFoundException {
        this.ProvedorDB = new RandomAccessFile("C:\\Users\\Labing\\Desktop\\provedor.txt", "rw");
    }
  
   
    public boolean insertar(Provedor estudiante) throws IOException {
        long posicionMemoria = this.ProvedorDB.length();
        this.ProvedorDB.seek(posicionMemoria);

        arbol.Ingresar(estudiante.getId(), posicionMemoria);
        this.ProvedorDB.writeInt(estudiante.getId());
        
        for (int i = 0; i < estudiante.getNombre().length; i++) {
            char letra = estudiante.getNombre()[i];
            this.ProvedorDB.writeChar(letra);
        }
        this.ProvedorDB.seek(posicionMemoria + 44);

        for (int i = 0; i < estudiante.getApellido().length; i++) {
            char letra2 = estudiante.getApellido()[i];
            this.ProvedorDB.writeChar(letra2);
        }
        this.ProvedorDB.seek(posicionMemoria + 84);

        this.ProvedorDB.writeInt(estudiante.getTelefono());

        return true;
    }

    public boolean actualizar(Provedor estudiante) {

        return false;
    }

    public boolean borrar(Provedor estudiante) {
        return false;
    }

    public ArrayList<Provedor> listarTodo() throws IOException {
        for (long i = 0; i < this.ProvedorDB.length(); i = i + 88) {
            this.ProvedorDB.seek(i);
            id2 = this.ProvedorDB.readInt();
            System.out.println(id2);
            for (int j = 0; j < 20; j++) {
                nuevo3 = nuevo3 + this.ProvedorDB.readChar();
            }
            System.out.println(nuevo3);
            for (int k = 0; k < 20; k++) {
                nuevo4 = nuevo4 + this.ProvedorDB.readChar();
            }
            System.out.println(nuevo4);
            tel2 = this.ProvedorDB.readInt();
            System.out.println(tel2);
            System.out.println("");
        }
        return null;
    }

    public void ListarUnitario(int identificacion) throws IOException {

        long posm = arbol.Buscar(identificacion);
        this.ProvedorDB.seek(posm);
        id = this.ProvedorDB.readInt();
        for (int j = 0; j < 20; j++) {
            nuevo1 = nuevo1 + this.ProvedorDB.readChar();
        }
        for (int k = 0; k < 20; k++) {
            nuevo2 = nuevo2 + this.ProvedorDB.readChar();
        }
        tel = this.ProvedorDB.readInt();
    }

    public void destructor() throws IOException {
        this.ProvedorDB.close();
    }

}
