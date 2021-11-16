package business.entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kunde
{
    private int kundeId;
    private String name;
    private String address;
    private int postNr;
    private String password;
    private String email;

    List<Kunde> kundeList;

    boolean isEditing = false;

    public Kunde(String name, String email, String password, String address, int postNr)
    {
        this.name = name;
        this.password = password;
        this.address = address;
        this.email = email;
        this.postNr = postNr;
    }

    public Kunde(int kundeId, String name, String email, String password, String address, int postNr)
    {
        this.kundeId = kundeId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.postNr = postNr;
    }

    public String getName() {
        return name;
    }

    public String encryptPassword()
    {
        String encryptedPass = "*";
        for (int i = 0; i < password.length(); i++)
        {
            encryptedPass += "*";
        }
        return encryptedPass;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getPostNr() {
        return postNr;
    }

    public List<Kunde> getKundeList() {
        return kundeList;
    }

    public int getKundeId() {
        return kundeId;
    }

    public void setKundeList(List<Kunde> kundeList) {
        this.kundeList = kundeList;
    }

    public void setEditing(boolean editing)
    {
        isEditing = editing;
    }

    public void setKundeId(int kundeId) {
        this.kundeId = kundeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostNr(int postNr) {
        this.postNr = postNr;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}