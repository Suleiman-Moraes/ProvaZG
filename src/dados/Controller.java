package dados;

import enuns.Controle;

public class Controller {

    private StringBuffer tudo;
    private int num;
    private Controle controle;
    private boolean abre;

    public String execute(String instrucao) {
        tudo = new StringBuffer("");
        num = 0;
        controle = Controle.MANTEM;
        abre = false;
        for (int i = 0; i < instrucao.length(); i++) {
            if (instrucao.charAt(i) == '.') {
                ponto();
            } else if (instrucao.charAt(i) == 'P') {
                abre = !abre;
                p(abre);
            } else {//'O'
                o();
            }
        }
        
        return tudo.toString();
    }

    private void p(boolean abre) {
        if (abre) {
            switch (controle) {
                case MANTEM:
                    incrementa();
                    controle = Controle.ABRE;
                    break;
                case ABREM:
                    incrementa();
                    controle = Controle.ABRE;
                    break;
                case ABRE:
                    incrementa();
                    controle = Controle.ABREM;
                    break;
                case FECHAM:
                    controle = Controle.FECHA;
                    decrementa();
                    break;
                case FECHA:
                    controle = Controle.FECHAM;
                    decrementa();
                    break;
            }
        } 
        else {
            switch (controle) {
                case ABRE:
                    controle = Controle.ABREM;
                    break;
                case FECHA:
                    controle = Controle.FECHAM;
                    break;
            }
        }
        tudo.append(num);
    }

    private void o() {
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
        tudo.append(num);
    }
    
    private void ponto(){
        switch (controle) {
            case ABRE:
                incrementa();
                break;
            case FECHA:
                decrementa();
                break;
        }
        tudo.append(num);
    }

    private void incrementa() {
        if (num != 5) {
            num++;
        }
        else{
            controle = Controle.FECHAM;
            abre = false;
        }
    }

    private void decrementa() {
        if (num != 0) {
            num--;
        }
        else{
            controle = Controle.ABREM;
            abre = false;
        }
    }
}
