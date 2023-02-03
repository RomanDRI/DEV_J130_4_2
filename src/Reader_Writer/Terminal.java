package Reader_Writer;

public class Terminal {
    private boolean readerConnect;
    private boolean writerConnect;
    private int currantReader;
    private int currantWriter;

    public void connectionReader(Reader reader) {
        if (writerConnect == true) {
            System.out.println(reader.readerName + " ЖДЕТ выхода писателя из базы данных");
        } else {
            if(currantWriter!=0){
                System.out.println(reader.readerName + " ЖДЕТ выхода писателя из базы данных");
            } else {
                readerConnection(reader);
                System.out.println(reader.readerName + " производит операцию чтения");
                readerDisconnection(reader);
            }
        }
    }
    public synchronized Boolean readerConnection(Reader reader) {
            System.out.println(reader.readerName + " подключился к базе данных. Писателей в базе: " + currantWriter);
            currantReader++;
            return readerConnect = true;

    }
    public synchronized Boolean readerDisconnection(Reader reader) {
        currantReader--;
        System.out.println(reader.readerName + " отключился от базы данных.");
        return readerConnect = false;
    }
    public synchronized void connectionWriter(Writer writer){
        if (readerConnect == true) {
            System.out.println("________ " + writer.writerName + " ЖДЕТ выхода читателей из базы данных");
        } else {
           if(currantReader!=0) {
               System.out.println("________ " + writer.writerName + " ЖДЕТ выхода читателей из базы данных");
           } else {
               writerConnection(writer);
               System.out.println("________ " + writer.writerName + " производит операцию записи");
               writerDisconnection(writer);
           }
        }
    }
    public Boolean writerConnection(Writer writer) {
            System.out.println("________ " + writer.writerName + " подключился к базе данных. Читателей в базе: "
                    + currantReader + ". Писателей в базе: " + currantWriter);
            currantWriter++;
        return writerConnect = true;
    }
    public Boolean writerDisconnection(Writer writer) {
        currantWriter--;
        System.out.println("________ " + writer.writerName + " отключился от базы данных");
        return writerConnect = false;
    }
}
