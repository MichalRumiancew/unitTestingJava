package pl.devfoundry.testing;

import java.io.*;

public class OrderBeckup {
    private Writer writer;

    public Writer getWriter() {
        return writer;
    }

    void createFile() throws FileNotFoundException {

        String pathname;
        File file = new File("orderBeckup.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        writer = new BufferedWriter(outputStreamWriter);

    }

    void beckupOrder(Order order) throws IOException {
        writer.append(order.toString());
    }


    void closeFile() throws IOException {
        writer.close();
    }
}
