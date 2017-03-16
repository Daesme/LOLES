<%-- 
    Document   : BusquedaAlumnos
    Created on : 19/02/2017, 01:03:35 AM
    Author     : crist
--%>

<%@page import="Modelo.Provedor"%>
<%@page import="controlador.ProvedorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
        <title>Buscar Proveedor
        </title></head><body>
            <div style="text-align: center;">
                <form method="get" action="BusquedaProvedores" name="BusquedaProvedores">
                    Buscar Proveedor<br>
                    <br>Por favor ingrese el ID del Provedor que desea encontrar:<br>
                     ID: <input name="id" type="text"><br>
                    <br>
                    <input name="Buscar" type="submit">
                </form>
                 <%
          Provedor pro = (Provedor)request.getAttribute("provedor");
           if(pro != null){
               ProvedorDAO est = new ProvedorDAO();
               est.ListarUnitario(pro.getId());
               int id = est.id;
               String nombre = est.nuevo1;
               String apellido = est.nuevo2;
               int tel = est.tel;
        %>   
          <br>
        <table >
            <tr>
               <td>Id</td>
               <td>Nombre</td> 
               <td>Apellido</td>
               <td>Telefono</td> 
            </tr>
            <tr>
               <td><%=id%></td>
               <td><%=nombre%></td>
               <td><%=apellido%></td>
               <td><%=tel%></td> 
        </tr>
        </table>
        
        <%
           }
        %>
            </div>
        </body>
</html>