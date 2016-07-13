package main.com.platzi.simple.connection;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CrudDatabase {
    public String getParsedVarchar(String data) {
        return data.trim();
    }

    public Date getParsedDate(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yy-mm-dd");
        java.util.Date date = formatter.parse(data);
        return new Date(date.getTime());
    }

    public int getParsedInt(int data) {
        return data;
    }
}
