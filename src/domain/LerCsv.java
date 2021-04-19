package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LerCsv {

	public static ArrayList<Pojo> lerCSV(String caminhoArquivo, String separador, boolean temHeader) throws IOException {
        ArrayList<Pojo> pojos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            boolean eCabecalho = temHeader;
            while ((linha = br.readLine()) != null) {
                if (eCabecalho || linha.trim().isEmpty()) {
                    eCabecalho = false;
                    continue;
                }
                String[] colunas = linha.split(separador, 10); //Presumo que seu CSV tenha 10 colunas
                if (colunas.length != 10) {
                    System.out.println("O CSV tem mais ou menos de 10 colunas!");
                    continue;
                }
                try {
                    Integer corRaca= Integer.parseInt(colunas[0].trim());
                    String sexo = colunas[1].trim();
                    Integer idade = Integer.parseInt(colunas[2].trim());
                    Integer reservaEtnico = Integer.parseInt(colunas[3].trim());
                    Integer reservaEnsinoPub = Integer.parseInt(colunas[4].trim());
                    Integer reservaRenda = Integer.parseInt(colunas[5].trim());
                    Integer apoioSocial = Integer.parseInt(colunas[6].trim());
                    Integer atividadeExtracurricular = Integer.parseInt(colunas[7].trim());
                    Integer tipoEscola = Integer.parseInt(colunas[8].trim());
                    String situacao = colunas[9].trim();
                    //System.out.println(corRaca + ";" + sexo + ";" + idade +";" + reservaEtnico + ";" + reservaEnsinoPub + ";" + reservaRenda+ ";" + apoioSocial+ ";" + atividadeExtracurricular+ ";" + tipoEscola+ ";" + situacao);
                    Pojo pojo = new Pojo(); 
                    pojo.setCorRaca(corRaca);
                    pojo.setSexo(sexo);
                    pojo.setIdade(idade);
                    pojo.setReservaEtnico(reservaEtnico);
                    pojo.setReservaEnsinoPub(reservaEnsinoPub);
                    pojo.setReservaRenda(reservaRenda);
                    pojo.setApoioSocial(apoioSocial);
                    pojo.setAtividadeExtracurricular(atividadeExtracurricular);
                    pojo.setTipoEscola(tipoEscola);
                    pojo.setSituacao(situacao);
                    pojos.add(pojo);
                } catch (Exception ex) {
                    System.out.println("Deu algum problema!\n " + ex);
                }

            }
        }

        return pojos;
    }
}
