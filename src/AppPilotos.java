import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import classes.Aeronave;
import classes.Pessoa;
import classes.Piloto;

public class AppPilotos {
    public static void main(String[] args) throws Exception {
        
        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados = 0;
        String cpf;

        Scanner sc = new Scanner(System.in);
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        
        do{
            limpa();
            System.out.println("****\nMENU\n****");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            limpa();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    
                    Boolean cpfCorreto = false;
                    Piloto plt = new Piloto();

                    if(qtdCadastrados == MAX_ELEMENTOS ){

                        System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                        voltarMenu(sc);
                        continue;
                    }

                    System.out.print("Cadastramento de pilotos...\n");
                    System.out.print("\nInforme o nome do piloto: ");
                    plt.setNome(sc.nextLine());
                    try {

                        System.out.print("Informe o CPF do piloto " + plt.getNome() + ": ");
                        plt.setCpf(sc.nextLine());
                    } catch (InputMismatchException e) {

                        System.out.println(e.getMessage());
                        cpfCorreto = true;
                        voltarMenu(sc);
                    } catch (NullPointerException e){

                        System.out.println(e.getMessage());
                        cpfCorreto = true;
                        voltarMenu(sc);
                    }
                    if( cpfCorreto == false ){
                        System.out.print("Informe o breve do piloto " + plt.getNome() + ": ");
                        plt.setBreve(sc.nextLine());

                        pilotos[qtdCadastrados] = plt;
                        qtdCadastrados++;

                        System.out.println("\nPiloto cadastrado com sucesso.");
                        voltarMenu(sc);
                    }           
                    break;

                case 2:

                    if (qtdCadastrados == 0) {
                        System.out.println("\nNão há pilotos cadastrados para exibir.");
                        voltarMenu(sc);
                        continue;
                    }else{
                        for (Pessoa pessoa : pilotos) {
                            if( pessoa != null ){
                                System.out.println(pessoa);
                            }
                        }
                    }
                    voltarMenu(sc);
                    break;

                case 3:
                    
                    Boolean achouCPF = false;
                    System.out.print("Informe o CPF do piloto: ");
                    cpf = sc.nextLine();
                    limpa();

                    for (Pessoa pessoa : pilotos) {
                        if( pessoa != null && cpf.equals(pessoa.getCpf()) ){
                            System.out.println(pessoa);
                            achouCPF = true;
                        }
                    }
                    if( ! achouCPF ){
                        System.out.println("CPF não encontrado.");
                    }
                    voltarMenu(sc);
                    break;

                case 4:

                    if (qtdCadastrados == 0) {
                        System.out.println("\nSem pilotos, não há como cadastrar uma aeronave");
                        voltarMenu(sc);
                        continue;
                    }

                    System.out.print("Informe o CPF do piloto para cadastrar uma aeronave: ");
                    cpf = sc.nextLine();


                    Aeronave aer = new Aeronave();
                    for (Pessoa pessoa : pilotos) {

                        if( ! cpf.equals(pessoa.getCpf()) ){

                            System.out.println("\nNão existe nenhum piloto cadastrado com o CPF informado.");
                        }

                        if( pessoa != null && cpf.equals(pessoa.getCpf()) ){
                            
                            System.out.println("\nBem vindo " + pessoa.getNome());
                            System.out.print("Informe o modelo da aeronave: ");
                            aer.setModelo(sc.nextLine());
                            System.out.print("Informe o número de série da aeronave " + aer.getModelo() + ": ");
                            aer.setNumeroSerie(sc.nextLine());
                            limpa();

                            System.out.println("\nAeronave cadastrada com sucesso.");

                            System.out.println("\nModelo: " + aer.getModelo() + "\nNúmero de série: " + aer.getNumeroSerie() );
                        }
                        voltarMenu(sc);
                        break;
                    }
                    break;
                    
            
                default:
                    break;
            }
        }while(opcao != 0);

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
    private static void limpa(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}