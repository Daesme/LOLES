/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.ArbolEmpleados;
import Modelo.Empleado;
import Modelo.Provedor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author crist
 */
public class EmpleadoDao {
    private RandomAccessFile EmpleadoDataBase;
    private ArbolEmpleados arbol = new ArbolEmpleados();
    public int codigo;
    public String nuevo1="";
    public int dur;
    public int pago;
    
    public int codigo2;
    public String nuevo2="";
    public int dur2;
    public int pago2;
    
    public EmpleadoDao() throws FileNotFoundException {
        this.EmpleadoDataBase = new RandomAccessFile("C:\\Users\\Labing\\Desktop\\empleado.txt", "rw");
    }
  
   
    public boolean insertar(Empleado empleado) throws IOException {
        long posicionMemoria = this.EmpleadoDataBase.length();
        this.EmpleadoDataBase.seek(posicionMemoria);

        arbol.Ingresar(empleado.getCodigo(), posicionMemoria);
        arbol.ListarArbol();
        this.EmpleadoDataBase.writeInt(empleado.getCodigo());
        
        for (int i = 0; i < empleado.getNombre().length; i++) {
            char letra = empleado.getNombre()[i];
            this.EmpleadoDataBase.writeChar(letra);
        }
        this.EmpleadoDataBase.seek(posicionMemoria + 44);

        this.EmpleadoDataBase.writeInt(empleado.getDuracion());

        this.EmpleadoDataBase.writeInt(empleado.getpago());

        return true;
    }

    public boolean actualizar(Provedor estudiante) {

        return false;
    }

    public boolean borrar(Provedor estudiante) {
        return false;
    }

    public ArrayList<Empleado> listarTodo() throws IOException {
        for (long i = 0; i < this.EmpleadoDataBase.length(); i = i + 52) {
            this.EmpleadoDataBase.seek(i);
            codigo2 = this.EmpleadoDataBase.readInt();
            System.out.println(codigo2);
            for (int j = 0; j < 20; j++) {
                nuevo2 = nuevo2 + this.EmpleadoDataBase.readChar();
            }
            System.out.println(nuevo2);
            dur2 = this.EmpleadoDataBase.readInt();
            System.out.println(dur2);
            pago2 = this.EmpleadoDataBase.readInt();
            System.out.println(pago2);
            System.out.println("");
        }
        return null;
    }

    public void ListarUnitario(int identificacion) throws IOException {
        
        long posm = arbol.Buscar(identificacion);
        this.EmpleadoDataBase.seek(posm);
        codigo = this.EmpleadoDataBase.readInt();
        for (int j = 0; j < 20; j++) {
            nuevo1 = nuevo1 + this.EmpleadoDataBase.readChar();
           
        }
        dur = this.EmpleadoDataBase.readInt();
        pago = this.EmpleadoDataBase.readInt();
    }

    public void destructor() throws IOException {
        this.EmpleadoDataBase.close();
    }
}
