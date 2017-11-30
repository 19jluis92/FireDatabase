/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import DataBase.DataBase;
import Model.User;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
/**
 *
 * @author jluis
 */
public class EngineRegister extends DataBase {
    
    public void create(User usuario) throws IOException, Exception{
       
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(usuario);

        
        this.put(jsonInString, "user/"+usuario.getMatricula());
    }
    
    public User read(String matricula)
    {
        User user= new User();
        try{
            ObjectMapper mapper = new ObjectMapper();
            
          String json=   this.read(matricula, "/user/"+matricula+"/");
        
             user = mapper.readValue(json, User.class);
        }catch(Exception e)
        {
        }
        return user;
    }
    
    public User update(User usuario) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(usuario);
       
       
        this.put(jsonInString, "user/"+usuario.getMatricula()+"/");
        return usuario;
    }
    public void delete(String matricula)
    {
        try {
            this.deletePost( "user/"+matricula+"/");
        } catch (Exception e) {

        }
    }
}
