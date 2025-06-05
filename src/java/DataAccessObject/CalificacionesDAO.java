package DataAccessObject;

import BusinessEntity.CalificacionesBE;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class CalificacionesDAO 
        extends ConexionMySQL 
        implements IBaseDAO<CalificacionesBE> {

    @Override
    public boolean Create(CalificacionesBE input) {
        boolean result = false;
        try {
            String SQL = "INSERT calificaciones(id,alumno_id,asignatura_id,profesor_id,calificacion) VALUES (?,?,?,?,?)";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            
            pst.setString(1, UUID.randomUUID().toString());//uuid
           pst.setInt(2, input.getAsignatura_id());
            pst.setInt(3, input.getProfesor_id());
            pst.setDouble(4, input.getCalificacion());
            pst.setInt(5, input.getId());
            result = pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean Update(CalificacionesBE input) {
        boolean result = false;
        try {
            String SQL = "UPDATE calificaciones SET alumno_id=?, asignatura_id=?, profesor_id=?, calificacion=?, WHERE id=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setInt(1, input.getAlumno_id());
            pst.setInt(2, input.getAsignatura_id());
            pst.setInt(3, input.getProfesor_id());
            pst.setDouble(4, input.getCalificacion());
            pst.setInt(5, input.getId());
            result = pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean Delete(String input) {
        boolean result = false;
        try {
            PreparedStatement pst = 
                    getConexion().prepareStatement("DELETE FROM calificaciones WHERE id=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public CalificacionesBE Read(String input) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     
    
}
