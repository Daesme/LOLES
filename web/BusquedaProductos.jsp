

<%@page import="controlador.ProductoDao"%>
<%@page import="Modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
        <title>Busqueda Producto
        </title></head><body>
            <div style="text-align: center;">
                <form method="get" action="BusquedaProductos" name="BusquedaProductos">
                    Buscar Producto<br>
                    <br>Por favor ingrese el ID del Producto que desea encontrar:<br>
                     ID: <input name="id" type="text"><br>
                    <br>
                    <input name="Buscar" type="submit">
                </form>
                 <%
          Producto producto = (Producto)request.getAttribute("producto");
           if(producto != null){
               ProductoDao prd = new ProductoDao();
               prd.ListarUnitario(producto.getId());
               int id = prd.id;
               String decripcion = prd.nuevo1;
               int cantidad  = prd.nuevo2;
               int valor = prd.ext;
        %>   
          <br>
        <table >
            <tr>
               <td>Id</td>
               <td>descripcion</td> 
               <td>cantidad</td>
               <td>valor</td> 
            </tr>
            <tr>
               <td><%=id%></td>
               <td><%=decripcion%></td>
               <td><%=cantidad%></td>
               <td><%=valor%></td> 
        </tr>
        </table>
        
        <%
           }
        %>
            </div>
        </body>
</html>