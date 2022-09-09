package vttp.csf.day34.server.models;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Registration {
    private String id;
    private String name;
    private String email;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public static Registration create(String json){
        InputStream is = new ByteArrayInputStream (json.getBytes ());	// Create inputstream
        JsonReader reader = Json.createReader(is);				     // Create reader for inputstream
        JsonObject data = reader.readObject();					     // Convert string to JSON object
        
        final Registration reg = new Registration();
            reg.setName(data.getString("name"));
            reg.setEmail(data.getString("email"));
            if (data.containsKey("id"))
                reg.setId(data.getString("id"));
        
        return reg;
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder()
        .add("id",id)
        .add("name",name)
        .add("email",email)
        .build();
    }
    
}
