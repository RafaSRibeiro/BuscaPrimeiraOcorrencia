package app;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Controller Principal da Aplicação
 */
public class Controller {

    private int[] populacao11Elementos = new int[11];
    private int[] populacao21Elementos = new int[21];
    private int[] populacao42Elementos = new int[42];
    Date data;

    public Controller() throws InterruptedException {
        populaElementos();

        buscaElemento(populacao11Elementos, 2);
    }

    /**
     * Popula elementos 11, 21, 42
     */
    private void populaElementos() {
        populaDados(populacao11Elementos);
        populaDados(populacao21Elementos);
        populaDados(populacao42Elementos);
    }

    /**
     * Popula dados iniciais da populacao
     */
    private void populaDados(int[] populacaoElementos) {
        for (int i = 0; i < populacaoElementos.length; i++)
            populacaoElementos[i] = i + 1;
    }

    /**
     * Busca um número por meio de um Array
     * @param populacaoElementos
     * @param busca
     * @return
     */
    private boolean buscaElemento(int[] populacaoElementos, int busca) throws InterruptedException {
        showTempoAtual();
        for (int i = 0; i < populacaoElementos.length; i++) {
            java.util.concurrent.TimeUnit.SECONDS.sleep(2);
            if (populacaoElementos[i] == busca) {
                showTempoFinal();
                return true;
            }

        }
        showTempoFinal();
        return false;
    }

    /**
     * Mostra o momento em HH:mm:ss.SSS
     */
    private void showTempoAtual() {
        data = new Date();
        SimpleDateFormat estiloData = new SimpleDateFormat("mm:ss.SSS");
        System.out.println(estiloData.format(data));
    }

    private void showTempoFinal() {
        Date dataFinal = new Date();
        SimpleDateFormat estiloData = new SimpleDateFormat("mm:ss.SSS");
        System.out.println(estiloData.format(dataFinal));
        System.out.println(estiloData.format(dataFinal.getTime() - data.getTime()));
    }

}
