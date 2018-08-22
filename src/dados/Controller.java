package dados;

import enuns.Controle;

public class Controller {

    private StringBuilder tudo;
    private int numero;
    private Controle controle;
    private boolean abre;

    public String execute(String instrucao) {
        tudo = new StringBuilder("");
        numero = 0;
        controle = Controle.MANTEM;
        abre = false;
        for (int i = 0; i < instrucao.length(); i++) {
            if (instrucao.charAt(i) == '.') {
                executarQuandoNaoHouveAcao();
            } else if (instrucao.charAt(i) == 'P') {
                abre = !abre;
                executarQuandoHouverCliqueNoBotao(abre);
            } else {//'O'
                executarAcaoQuandoHouverObstaculo();
            }
        }
        
        return tudo.toString();
    }

    /**
     * Executar acao caso hover
     * clique no botao
     */
    private void executarQuandoHouverCliqueNoBotao(boolean abre) {
        if (abre) {
            switch (controle) {
                case MANTEM:
                    incrementa();
                    controle = Controle.ABRE;
                    break;
                case ABRE_MANTEM:
                    incrementa();
                    controle = Controle.ABRE;
                    break;
                case ABRE:
                    incrementa();
                    controle = Controle.ABRE_MANTEM;
                    break;
                case FECHA_MANTEM:
                    controle = Controle.FECHA;
                    decrementa();
                    break;
                case FECHA:
                    controle = Controle.FECHA_MANTEM;
                    decrementa();
                    break;
            }
        } 
        else {
            switch (controle) {
                case ABRE:
                    controle = Controle.ABRE_MANTEM;
                    break;
                case FECHA:
                    controle = Controle.FECHA_MANTEM;
                    break;
            }
        }
        tudo.append(numero);
    }

    /**
     * Executar ação acao quando houver 
     * obstaculo
     */
    private void executarAcaoQuandoHouverObstaculo() {
        switch (controle) {
            case ABRE:
                decrementa();
                controle = Controle.FECHA;
                break;
            case FECHA:
                incrementa();
                controle = Controle.ABRE;
                break;
        }
        tudo.append(numero);
    }
    
    /**
     * Qaundo ninguem apertar o controle
     * E não tiver nenhum obstaculo no caminho 
     */
    private void executarQuandoNaoHouveAcao(){
        switch (controle) {
            case ABRE:
                incrementa();
                break;
            case FECHA:
                decrementa();
                break;
        }
        tudo.append(numero);
    }

    private void incrementa() {
        if (numero != 5) {
            numero++;
        }
        else{
            controle = Controle.FECHA_MANTEM;
            abre = false;
        }
    }

    private void decrementa() {
        if (numero != 0) {
            numero--;
        }
        else{
            controle = Controle.ABRE_MANTEM;
            abre = false;
        }
    }
}
