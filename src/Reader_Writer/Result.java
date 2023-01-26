package Reader_Writer;

public class Result {
    public static void main(String[] args) {
        int readersValue = 10;
        int writersValue = 5;
        Reader[] readers = new Reader[readersValue];
        Writer[] writers = new Writer[writersValue];
        for (int i = 0; i < readersValue; i++) {
            readers[i] = new Reader("Читатель " + (i+1));
        }
        for (int i = 0; i < writersValue; i++) {
            writers[i] = new Writer("Писатель " + (i+1));
        }
        for(Reader reader: readers) reader.start();
        for(Writer writer: writers) writer.start();
    }
}
