package model;

import java.io.*;
import java.util.ArrayList;

public class LeituraEscrita<T> {
    private File diretorio;
    private FileInputStream fis;
    private ObjectInputStream ois;
    private FileOutputStream fos;
    private ObjectOutputStream oos;

    public LeituraEscrita(String diretorio) {
        this.diretorio = new File(diretorio);
    }

    @SuppressWarnings("unchecked")
    public void lerDados(ArrayList<T> dados) {
        try {
            if (this.diretorio.exists() && this.diretorio.canRead() && this.diretorio.isFile()) {
                fis = new FileInputStream(this.diretorio);
                ois = new ObjectInputStream(fis);

                while (fis.available() > 0) {
                    dados.add((T) ois.readObject());
                }

                ois.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void escreverDados(ArrayList<T> dados) {

        if (this.diretorio.canWrite() && this.diretorio.isFile()) {
            try {
                fos = new FileOutputStream(this.diretorio);
                oos = new ObjectOutputStream(fos);

                for (int count = 0; count < dados.size(); count++)
                    oos.writeObject(dados.get(count));

                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}