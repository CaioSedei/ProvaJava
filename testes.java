
public static void main(String[] args) {
        Robo robo1 = new Robo(1, "Robo1", 20, 10);
        Robo robo2 = new Robo(2, "Robo2", 15, 5);
        Robo robo3 = new Robo(3, "Robo3", 10, 20);

        System.out.println("Robo 1: " + robo1.nome + ", Ataque: " + robo1.ataque + ", Defesa: " + robo1.defesa
                        + ", Energia: " + robo1.energia);
        System.out.println("Robo 2: " + robo2.nome + ", Ataque: " + robo2.ataque + ", Defesa: " + robo2.defesa
                        + ", Energia: " + robo2.energia);
        System.out.println("Robo 3: " + robo3.nome + ", Ataque: " + robo3.ataque + ", Defesa: " + robo3.defesa
                        + ", Energia: " + robo3.energia);

        robo1.batalha(robo2);
        robo2.batalha(robo3);
        robo3.batalha(robo1);

        // Simulação de batalha
        // robo1.perderEnergia(30);

        // System.out.println("Após a batalha:");
        // System.out.println("Robo 1 Energia: " + robo1.energia);
        // System.out.println("Robo 2 Energia: " + robo2.energia);
        // System.out.println("Robo 3 Energia: " + robo3.energia);

        // // Recuperação de energia
        // robo1.recuperarEnergia();
        // robo1.recuperarEnergia();
        // robo1.recuperarEnergia();
        // robo1.recuperarEnergia();
        // robo2.recuperarEnergia();
        // robo3.recuperarEnergia();

        // System.out.println("Após recuperação de energia:");
        // System.out.println("Robo 1 Energia: " + robo1.energia);
        // System.out.println("Robo 2 Energia: " + robo2.energia);
        // System.out.println("Robo 3 Energia: " + robo3.energia);

        // robo2.perderEnergia(200);
        // robo3.perderEnergia(50);

        // // Ganho de pontos
        // robo1.ganharPontos(100);
        // robo2.ganharPontos(3);
        // robo3.ganharPontos(50);

        // robo1.vitoria();
        // robo2.derrota();
        // robo3.vitoria();
        // robo3.vitoria();
        // robo3.derrota();
        // robo3.derrota();
        // robo3.derrota();

        // robo1.ativo(robo1);
        // robo2.ativo(robo2);
        // robo3.ativo(robo3);

        // System.out.println("Robo 1 Pontos: " + robo1.pontos + ", Vitórias: " +
        // robo1.vitoria + ", Derrotas: "
        // + robo1.derrota + ", Status: " + (robo1.status ? "ativo" : "inativo"));
        // System.out.println("Robo 2 Pontos: " + robo2.pontos + ", Vitórias: " +
        // robo2.vitoria + ", Derrotas: "
        // + robo2.derrota + ", Status: " + (robo2.status ? "ativo" : "inativo"));
        // System.out.println("Robo 3 Pontos: " + robo3.pontos + ", Vitórias: " +
        // robo3.vitoria + ", Derrotas: "
        // + robo3.derrota + ", Status: " + (robo3.status ? "ativo" : "inativo"));

        Robo.listarRobos();
        Robo.classficacao();

}