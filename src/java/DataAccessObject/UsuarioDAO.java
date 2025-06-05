package DataAccessObject;

import BusinessEntity.UsuarioBE;
import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UsuarioDAO 
    extends ConexionMySQL
    implements IBaseDAO<UsuarioBE>{

    @Override
    public boolean Create(UsuarioBE input) {
        boolean result = false;
        try {
            String SQL = "INSERT usuarios(id,tipo,dni,nombre,apellido,email,fecha_nacimiento) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            
            pst.setString(1, UUID.randomUUID().toString());//uuid
            pst.setString(2, input.getDni());
            pst.setString(3, input.getNombre());
            pst.setString(4, input.getApellido());
            pst.setString(5, input.getEmail());
            pst.setString(6, input.getFecha_nacimiento());
            pst.setInt(7, input.getId());
            result = pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean Update(UsuarioBE input) {
        boolean result = false;
        try {
            String SQL = "UPDATE usuarios SET tipo=?, dni=?, nombre=?, apellido=?, email=?, fecha_nacimiento=? WHERE id=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, input.getTipo());
            pst.setString(2, input.getDni());
            pst.setString(3, input.getNombre());
            pst.setString(4, input.getApellido());
            pst.setString(5, input.getEmail());
            pst.setString(6, input.getFecha_nacimiento());
            pst.setInt(7, input.getId());
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
                    getConexion().prepareStatement("DELETE FROM usuarios WHERE id=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    @Override
    public UsuarioBE Read(String input) {
       UsuarioBE item = new UsuarioBE();
        try {
            PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM usuarios WHERE id=?");
            pst.setString(1, input);
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                item.setId(res.getInt("id"));
                item.setTipo(res.getString("tipo"));
                item.setDni(res.getString("dni"));
                item.setNombre(res.getString("nombre"));
                item.setApellido(res.getString("apellido"));
                item.setEmail(res.getString("email"));
                item.setFecha_nacimiento(res.getString("fecha_nacimiento"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return item;

    }
   
    
    
}
