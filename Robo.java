
import java.util.ArrayList;
import java.util.Scanner;

public class Robo {
    public int codigo;
    public String nome;
    public int ataque;
    public int defesa;
    public int energia;
    public int vitoria;
    public int derrota;
    public int pontos;
    public boolean status;
    public static ArrayList<Robo> robos = new ArrayList<>();

    Robo(int codigo, String nome, int ataque, int defesa) {
        this.codigo = codigo;
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.energia = 100;
        this.vitoria = 0;
        this.derrota = 0;
        this.pontos = 0;
        this.status = true;

        robos.add(this);
    }

    public static Robo buscarRobo(int codigo) {
        for (Robo r : robos) {
            if (r.codigo == codigo) {
                return r;
            }
        }
        return null;
    }

    public static void recuperarEnergia(Scanner sc) {
        System.out.print("Digite o código do robô que deseja recuperar energia: ");
        int codigo = sc.nextInt();

        Robo robo = null;
        for (Robo r : robos) {
            if (r.codigo == codigo) {
                robo = r;
                break;
            }
        }

        if (robo == null) {
            System.out.println("Robô não encontrado.");
            return;
        }

        if (robo.energia >= 100) {
            System.out.println(robo.nome + " já está com a energia máxima.");
            return;
        }
        if (robo.pontos <= 0) {
            System.out.println(robo.nome + " não tem pontos suficientes para recuperar energia.");
            return;
        }
        robo.energia += 10;
        robo.pontos -= 1;
        if (robo.energia > 100) {
            robo.energia = 100;
        }

        System.out.println(robo.nome + " recuperou energia. Energia atual: " + robo.energia);
    }

    public static void criarRobo(Scanner sc) {
        System.out.print("Digite o código do robô: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        for (Robo r : robos) {
            if (r.codigo == codigo) {
                System.out.println("Já existe um robô com esse código.");
                return;
            }
        }

        System.out.print("Digite o nome do robô: ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("O nome não pode estar vazio.");
            return;
        }

        System.out.print("Digite o ataque (10 a 30): ");
        int ataque = sc.nextInt();
        if (ataque < 10 || ataque > 30) {
            System.out.println("O ataque deve estar entre 10 e 30.");
            return;
        }

        System.out.print("Digite a defesa (0 a 20): ");
        int defesa = sc.nextInt();
        if (defesa < 0 || defesa > 20) {
            System.out.println("A defesa deve estar entre 0 e 20.");
            return;
        }

        new Robo(codigo, nome, ataque, defesa);
        System.out.println("Robô " + nome + " criado com sucesso!");

    }

    public static void excluirRobo(Scanner sc) {
        System.out.print("Digite o código do robô que deseja excluir: ");
        int codigo = sc.nextInt();

        Robo robo = buscarRobo(codigo);

        if (robo == null) {
            System.out.println("Robô não encontrado.");
            return;
        }

        robos.remove(robo);
        System.out.println("Robô " + robo.nome + " excluído com sucesso.");
    }

    // não pode passar de 0 de energia
    public void perderEnergia(int energia) {
        this.energia -= energia;
        if (this.energia < 0) {
            this.energia = 0;
        }
    }

    public void ganharPontos(int pontos) {
        this.pontos += pontos;
    }

    public void vitoria() {
        this.vitoria += 1;
        this.pontos += 3;
    }

    public void derrota() {
        if (this.energia <= 0) {
            this.derrota += 1;

        }
    }

    public void atacar(Robo robo) {
        int dano = this.ataque - robo.defesa;
        if (dano > 0) {
            robo.calcularDano(robo, dano);
            robo.calcularDanoBase(robo);
            robo.perderEnergia(dano);
        }

    }

    public void ativo(Robo robo) {
        if (robo.energia >= 30) {
            this.status = true;
        } else {
            this.status = false;
        }

    }

    static void consultarRobo(Scanner sc) {
        System.out.print("Digite o código do robô que deseja consultar: ");
        int codigo = sc.nextInt();
        try {

            Robo robo = null;

            for (Robo r : robos) {
                if (r.codigo == codigo) {
                    robo = r;
                    break;
                }
            }

            if (robo == null) {
                System.out.println("Robô não encontrado.");
                return;
            }

            System.out.println("Código: " + robo.codigo);
            System.out.println("Nome: " + robo.nome);
            System.out.println("Ataque: " + robo.ataque);
            System.out.println("Defesa: " + robo.defesa);
            System.out.println("Energia: " + robo.energia);
            System.out.println("Vitórias: " + robo.vitoria);
            System.out.println("Derrotas: " + robo.derrota);
            System.out.println("Pontos: " + robo.pontos);
        } catch (Exception e) {
            System.out.println("Erro ao listar robôs: " + e.getMessage());
            return;
        }

    }

    static void listarRobos() {
        System.out.println("Lista de Robôs:");
        for (Robo robo : robos) {
            System.out.println("Código: " + robo.codigo + ", Nome: " + robo.nome + ", Ataque: " + robo.ataque
                    + ", Defesa: " + robo.defesa + ", Energia: " + robo.energia);
        }
    }

    static void classficacao() {
        System.out.println("Classificação dos Robôs:");
        robos.sort((r1, r2) -> Integer.compare(r2.pontos, r1.pontos));
        for (Robo robo : robos) {
            System.out.println("Código: " + robo.codigo + ", Nome: " + robo.nome + ", Pontos: " + robo.pontos
                    + ", Vitórias: " + robo.vitoria + ", Derrotas: " + robo.derrota);
        }
    }

    public void empate() {
        this.pontos += 1;
    }

    public void mostrarStatus(Robo robo) {
        System.out.println("Status após a rodada:");
        System.out.println(this.nome + ", Energia: " + this.energia);
        System.out.println(robo.nome + ", Energia: " + robo.energia);
    }

    public void batalha(Robo robo) {
        for (int i = 1; i <= 5; i++) {
            this.atacar(robo);
            robo.atacar(this);
            System.out.println("Status após a rodada" + i + ":");
            System.out.println(this.nome + ", Energia: " + this.energia);
            System.out.println(robo.nome + ", Energia: " + robo.energia);

            if (this.energia <= 0 || robo.energia <= 0) {
                break;
            }
        }

        if (this.energia > robo.energia) {
            this.vitoria();
            robo.derrota();
        } else if (this.energia < robo.energia) {
            this.derrota();
            robo.vitoria();
        } else {
            this.empate();
            robo.empate();
        }
    }

    public static void validarAtivo(Robo robo) {
        if (robo.energia <= 30) {
            throw new IllegalStateException(robo.nome + " não está ativo (energia: " + robo.energia + ").");
        }
    }

    public static void escolherBatalha(Scanner sc) {
        System.out.print("Digite o código do primeiro robô: ");
        int codigo1 = sc.nextInt();
        System.out.print("Digite o código do segundo robô: ");
        int codigo2 = sc.nextInt();

        if (codigo1 == codigo2) {
            System.out.println("Escolha dois robôs diferentes.");
            return;
        }

        Robo robo1 = buscarRobo(codigo1);
        Robo robo2 = buscarRobo(codigo2);

        if (robo1 == null) {
            System.out.println("Robô com código " + codigo1 + " não encontrado.");
            return;
        }
        if (robo2 == null) {
            System.out.println("Robô com código " + codigo2 + " não encontrado.");
            return;
        }

        try {
            validarAtivo(robo1);
            validarAtivo(robo2);
        } catch (IllegalStateException e) {
            System.out.println("Batalha cancelada: " + e.getMessage());
            return;
        }

        System.out.println(robo1.nome + " vs " + robo2.nome);
        robo1.batalha(robo2);
    }

    public static void rodadaGeral() {
        ArrayList<Robo> robosDisponiveis = new ArrayList<>();
        for (Robo robo : robos) {
            if (robo.status) {
                robosDisponiveis.add(robo);
            }
        }

        if (robosDisponiveis.size() < 2) {
            System.out.println("Não há robôs suficientes disponíveis para a rodada geral.");
            return;
        }

        robosDisponiveis.sort((r1, r2) -> {
            if (r1.pontos != r2.pontos) {
                return Integer.compare(r2.pontos, r1.pontos);
            }
            return Integer.compare(r1.codigo, r2.codigo);
        });

        System.out.println("Confrontos da rodada geral:");
        for (int i = 0; i < robosDisponiveis.size() - 1; i += 2) {
            Robo robo1 = robosDisponiveis.get(i);
            Robo robo2 = robosDisponiveis.get(i + 1);
            System.out.println(robo1.nome + " vs " + robo2.nome);
            robo1.batalha(robo2);
        }

        if (robosDisponiveis.size() % 2 != 0) {
            Robo roboFolga = robosDisponiveis.get(robosDisponiveis.size() - 1);
            System.out.println(roboFolga.nome + " recebe ponto de folga.");
            roboFolga.ganharPontos(1);
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public int getPontos() {
        return pontos;
    }

    public static boolean atacaPrimeiro(Robo r1, Robo r2) {
        if (r1.getPontos() != r2.getPontos()) {
            return r1.getPontos() < r2.getPontos();
        }
        return r1.getCodigo() < r2.getCodigo();
    }

    public int calcularDanoBase(Robo alvo) {
        int dano = this.ataque - alvo.defesa;
        if (dano < 5) {
            dano = 5;
        }
        return dano;
    }

    public int aplicarBonusRodada(int dano, int rodada) {
        if (rodada % 2 == 0) {
            return dano + 5;
        }
        return dano;
    }

    public int calcularDano(Robo alvo, int rodada) {
        int dano = calcularDanoBase(alvo);
        return aplicarBonusRodada(dano, rodada);
    }

    public static void estatisticasGerais() {
        int totalRobos = robos.size();

        if (totalRobos == 0) {
            System.out.println("Não há robôs cadastrados.");
            return;
        }

        int somaEnergia = 0;
        int robosRecuperacao = 0;
        double maiorAproveitamento = 0;
        ArrayList<Robo> robosMaiorAproveitamento = new ArrayList<>();

        for (Robo robo : robos) {
            somaEnergia += robo.energia;
            if (robo.energia < 100) {
                robosRecuperacao++;
            }

            int totalCombates = robo.vitoria + robo.derrota;
            if (totalCombates > 0) {
                double aproveitamento = ((double) robo.vitoria / totalCombates) * 100;
                if (aproveitamento > maiorAproveitamento) {
                    maiorAproveitamento = aproveitamento;
                    robosMaiorAproveitamento.clear();
                    robosMaiorAproveitamento.add(robo);
                } else if (aproveitamento == maiorAproveitamento) {
                    robosMaiorAproveitamento.add(robo);
                }
            }
        }

        System.out.println("Estatísticas Gerais:");
        System.out.println("Total de Robôs: " + totalRobos);
        System.out.printf("Média de Energia: %.1f%n", (double) somaEnergia / totalRobos);
        System.out.println("Robôs em Recuperação: " + robosRecuperacao);
        System.out.printf("Maior Aproveitamento: %.1f%%%n", maiorAproveitamento);
        System.out.println("Robôs com Maior Aproveitamento:");
        for (Robo robo : robosMaiorAproveitamento) {
            System.out.println("Código: " + robo.codigo + ", Nome: " + robo.nome);
        }
    }
}