package Reader_Writer;

import java.util.Random;

public class Writer extends Thread{
    public String writerName;

    public Writer(String writerName) {
        this.writerName = writerName;
    }

    public void writerConnection() {
        for (int i = 0; i < 3; i++) {
            DataBase.getDataBase().terminal.connectionWriter(this);
            try {
                Thread.sleep((new Random().nextInt(2)*1500));
            } catch (InterruptedException e) {}
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            writerConnection();
            try {
                Thread.sleep((new Random().nextInt(2)*1500));
            } catch (InterruptedException e) {}
        }
    }
}
