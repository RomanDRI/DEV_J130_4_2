package Reader_Writer;

public class DataBase {
    Terminal terminal = new Terminal();
    private static DataBase dataBase = new DataBase();
    private DataBase(){}

    public static DataBase getDataBase() {
        return dataBase;
    }
}
