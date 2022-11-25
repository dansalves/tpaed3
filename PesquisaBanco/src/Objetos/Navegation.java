package Objetos;

import java.io.File;
import java.io.RandomAccessFile;

public class Navegation {
    public void criarConta(int id, long pos) {
        String filePath = new File("").getAbsolutePath();
        filePath.concat("\\Arquivos\\BancoDeDados.txt");
        try(RandomAccessFile randomAcess = new RandomAccessFile("../dados.db", "rw")){
            int hash = this.defHash(id);
            int posTabela = hash*20;
            randomAcess.seek(posTabela);
            int idLido;
            try{
                idLido = randomAcess.readInt();
            }catch(Exception e){
                idLido = 0;
            }
            if(idLido == 0){
                randomAcess.seek(posTabela);
                randomAcess.writeInt(id);
                randomAcess.writeLong(pos);
                randomAcess.writeLong(-1);
            }else if(idLido != 0){
                randomAcess.seek(idLido);
                while(true){
                    randomAcess.seek(randomAcess.getFilePointer()+12);
                    long ProximaPos = randomAcess.getFilePointer();
                    long ProximoDado = randomAcess.readLong();
                    if(ProximoDado == -1){
                        randomAcess.seek(ProximaPos);
                        randomAcess.writeLong((long)id*20);
                        randomAcess.seek((long)id*20);
                        randomAcess.writeInt(id);
                        randomAcess.writeLong(pos);
                        randomAcess.writeLong(-1);
                        break;
                    }else
                        randomAcess.seek(ProximoDado);
                }
            }
        }catch(Exception e){e.printStackTrace();}
    }
    public int defHash(int id){
        return id%101;
    }
}
