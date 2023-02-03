package Reader_Writer;

import java.util.Random;

public class Reader extends Thread{
    public String readerName;

    public Reader(String readerName) {
        this.readerName = readerName;
    }

    public void readerConnection() {
        for (int i = 0; i < 3; i++) {
            DataBase.getDataBase().terminal.connectionReader(this);
            try {
                Thread.sleep((new Random().nextInt(2)*2000));
            } catch (InterruptedException e) {}
        }
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            readerConnection();
            try {
                Thread.sleep((new Random().nextInt(2)*2000));
            } catch (InterruptedException e) {}
        }
    }
}
