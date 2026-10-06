import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int opt = -1;
        do {
            System.out.println("==== Rinha de robos ====");
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar robô");
            System.out.println("2. Consultar robô");
            System.out.println("3. Realizar um combate");
            System.out.println("4. Recuperar energia");
            System.out.println("5. Executar uma rodada geral");
            System.out.println("6. Exibir a classificação");
            System.out.println("7. Emitir estatísticas");
            System.out.println("8. Excluir participante");
            System.out.println("Digite a operação: ");
            opt = buscarOperacao(s);
            switch (opt) {
                case 0:
                    System.out.println("Adeus!");
                    break;
                case 1:
                    Robo.criarRobo(s);
                    break;
                case 2:
                    Robo.consultarRobo(s);
                    break;
                case 3:
                    Robo.escolherBatalha(s);
                    break;
                case 4:
                    Robo.recuperarEnergia(s);
                    break;
                case 5:
                    Robo.rodadaGeral();
                    break;
                case 6:
                    Robo.classficacao();
                    break;
                case 7:
                    Robo.estatisticasGerais();
                    break;
                case 8:
                    Robo.excluirRobo(s);
                    break;

            }

        } while (opt != 0);

        s.close();
    }

    public static int buscarOperacao(Scanner s) {
        int opt = -1;
        do {
            try {
                opt = s.nextInt();
            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Operação inválida");
                System.out.println("Digite novamente a informação!");
                opt = -1;
            }
        } while (opt < 0);

        return opt;
    }
}
