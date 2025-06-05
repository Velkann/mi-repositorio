<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BusinessEntity.UsuarioBE"%>
<%@page import="BusinessLogic.UsuarioBL"%>
<%
    UsuarioBL oUserBL = new UsuarioBL();
    List<UsuarioBE> lista = oUserBL.Listar();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista Auumnos</h1>
        <table>
            <thead>
            <th>header1</th>
            <th>header2</th>
            <th>header3</th>
            </thead>
            <tbody>
                <%for(int x =0 ; x < lista.size(); x++) {
                    UsuarioBE item = lista.get(x);
                %>
                <tr>
                <td><%=item.getId()%></td>
                <td><%=item.getApellido()%></td>
                <td><%=item.getDni()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>