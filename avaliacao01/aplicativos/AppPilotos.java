package aplicativos;

import java.io.IOException;
import java.util.Scanner;

import aplicativos.aviacao.Pessoas;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Pessoas[] pilotos = new Pessoas[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);
        Pessoas[] array = new Pessoas[MAX_ELEMENTOS];
        int MAX_ELEMENTOS_novo = 0;
        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

           

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (MAX_ELEMENTOS > MAX_ELEMENTOS_novo){

                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }
            } else {
                if (qtdCadastrados == MAX_ELEMENTOS_novo){
                    System.out.println("\nAumente o espaço!!");
                    voltarMenu(in);
                        continue;
                    
                }
            }
                // Cadastre seu piloto aqui

                System.out.println("Nome do piloto: ");
                String nome = in.nextLine();

                System.out.println("CPF do piloto: ");
                String cpf = in.nextLine();
                
                System.out.println("Breve do piloto: ");
                String breve = in.nextLine();
                
                System.out.println("Matrícula do piloto: ");
                String matricula = in.nextLine();
                
                Pessoas p1 = new Pessoas(nome, cpf);

                pilotos[qtdCadastrados] = p1;

                qtdCadastrados++;

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);
            
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui

                for (int i = 0; i < qtdCadastrados; i++) {
                    System.out.println("O nome do piloto é: " + pilotos[i].getNome());
                }

                voltarMenu(in);
            } else if (opcao == 3) {
                boolean validar = false;
                int achar = 0;

                System.out.println("\nINFORME O CPF: ");
                String cpf = in.nextLine();

                for(int i = 0; i < qtdCadastrados; i++)
                {
                    if(pilotos[i].getCpf().equals(cpf))
                    {
                        validar = true;
                        achar = i;
                        i = qtdCadastrados;
                    }
                }
                if(validar)
                {
                    System.out.println("\nPiloto: " + pilotos[achar].getNome() + " Seu CPF é: " 
                    + pilotos[achar].getCpf());
                }else
                {
                    System.out.println("ERRO!! CPF NÃO ENCONTRADO!!!!");
                }
                voltarMenu(in);
            } else if (opcao == 4) {

                System.out.println("Digite o novo tamanho de armazenamento: ");
                int novovalor = in.nextInt();

                MAX_ELEMENTOS_novo = novovalor;

                array = new Pessoas[MAX_ELEMENTOS_novo];
                for (int i = 0; i < pilotos.length; i++) {
                    array[i] = pilotos[i];
                }

                pilotos = new Pessoas[MAX_ELEMENTOS_novo];
                for (int i = 0; i < array.length; i++) {
                    pilotos[i] = array[i];

                    System.out.println("O tamanho atual do array foi atualizado com sucesso");
                } 
                voltarMenu(in);
            }  
             else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }
}