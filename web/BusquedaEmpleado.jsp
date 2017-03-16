<%-- 
    Document   : BusquedaEmpleado
    Created on : 12/03/2017, 01:03:35 PM
    Author     : User7
--%>

<%@page import="controlador.EmpleadoDao"%>
<%@page import="Modelo.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
        <title>Buscar Empleado
        </title></head><body>
            <div style="text-align: center;">
                    <form method="get" action="BusquedaEmpleados" name="BusquedaEmpleados">
                    Buscar Empleado<br>
                    <br>Por favor ingrese el Codigo del Empleado que desea encontrar:<br>
                     ID: <input name="codigo" type="text"><br>
                    <br>
                    <input name="Buscar" type="submit">
                </form>
                 <%
         Empleado empdo = (Empleado)request.getAttribute("empleado");
           if(empdo != null){
               EmpleadoDao empleado = new EmpleadoDao();
               empleado.ListarUnitario(empdo.getCodigo());
               int id = empleado.codigo;
               String nombre = empleado.nuevo1;
               int dura = empleado.dur;
               int Pagar = empleado.pago;
        %>   
          <br>
        <table >
            <tr>
               <td>Codigo</td>
               <td>Nombre</td> 
               <td>Duracion</td>
               <td>Id del Profesor</td> 
            </tr>
            <tr>
               <td><%=id%></td>
               <td><%=nombre%></td>
               <td><%=dura%></td>
               <td><%=Pagar%></td> 
        </tr>
        </table>
        
        <%
           }
        %>
            </div>
        </body>
</html>