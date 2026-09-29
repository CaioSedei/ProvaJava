// o nome não poderá estar vazio;
// o ataque deverá estar entre 10 e 30;
// e a defesa, entre 0 e 20.
// Cada robô começará com 100 de energia
// e os demais indicadores zerados.

import java.util.ArrayList;

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

    // não pode passar de 100 de energia, e cada recuperação de energia custa 1
    // ponto.
    public void recuperarEnergia() {
        if (this.energia < 100) {
            this.energia += 10;
            this.pontos -= 1;
            if (this.energia > 100) {
                this.energia = 100;
            }
        }

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

    // * Caso ambos sobrevivam às cinco rodadas, vencerá aquele com mais energia
    // restante. Se as energias forem iguais, haverá empate.
    public void empate() {
        this.pontos += 1;
    }

    public void atacarPrimeiro() {

    }

    public void mostrarStatus(Robo robo) {
        System.out.println("Status após a rodada:");
        System.out.println(this.nome + ", Energia: " + this.energia);
        System.out.println(robo.nome + ", Energia: " + robo.energia);
    }

    public void batalha(Robo robo) {
        if (this.energia > 30 || robo.energia > 30) {
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
        } else {
            System.out.println("Um dos robôs não tem energia suficiente para lutar.");

        }

    }

}
