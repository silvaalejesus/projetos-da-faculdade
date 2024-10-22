import java.time.*;
import java.util.Scanner;
import java.util.*;

import entity.*;
import enumeration.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Proprietario> proprietarios = new ArrayList<Proprietario>();
        List<Imovel> imoveis = new ArrayList<Imovel>();
        List<Locacao> locacoes = new ArrayList<Locacao>();

        // Gerar dados fictícios
        clientes.add(new Cliente("João Silva", "123456789", "98765432100", "01/01/1980", Sexo.M,
                "Rua A, 123", "joao@example.com", "123456789", LocalDate.now()));
        clientes.add(new Cliente("Maria Oliveira", "987654321", "12345678900", "02/02/1990", Sexo.F,
                "Rua B, 456", "maria@example.com", "987654321", LocalDate.now()));

        proprietarios.add(new Proprietario("Severino Isaac Mateus Moraes", "315350283", "71313561584",
                "14/03/1977", Sexo.M, "Travessa Dona Maria, 487, Mangueira, Rio de Janeiro, RJ, 20943240",
                "severinoisaacmoraes@dedicasa.com.br", "21998523684", LocalDate.now()));

        imoveis.add(new Imovel(1L, "Rua A, 123", TipoDeImovel.CASA, 3, 2, 142.20, new Preco(100.00),
                Disponibilidade.S,
                "Casa grande muito bonita."));

        imoveis.add(
                new Imovel(2L, "Rua B, 456", TipoDeImovel.APARTAMENTO, 2, 1, 80.0, new Preco(300.00), Disponibilidade.S,
                        "Apartamento aconchegante."));
        imoveis.add(new Imovel(3L, "Avenida C, 789", TipoDeImovel.CHACARA, 4, 3, 200.0, new Preco(250.00),
                Disponibilidade.N, "Casa espaçosa com jardim."));

        Locacao locacao = null;
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("Menu:");
            System.out.println("1. Iniciar cadastro");
            System.out.println("2. Adicionar informacoes do imóvel");
            System.out.println("3. Iniciar locação");
            System.out.println("4. Cancelar locação");
            System.out.println("5. Exibir informaçoes dos clientes e proprietarios cadastrados");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Gostaria de cadastrar um cliente ou proprietario?");
                    System.out.println("1. Cliente");
                    System.out.println("2. Proprietario");
                    int opcaoCliente = scanner.nextInt();

                    // Código para criar cliente
                    System.out.println("Informe os dados");

                    // System.out.print("ID: ");
                    // Long id = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("RG: ");
                    String rg = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Data de Nascimento (dd/MM/yyyy): ");
                    String dataNascimento = scanner.nextLine();

                    System.out.print("Sexo (M ou F): ");
                    Sexo sexo = Sexo.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    if (opcaoCliente == 1) {
                        System.out.println("Cadastre as informações de pagamento");
                        Cliente cliente = new Cliente(nome, rg, cpf, dataNascimento, sexo, endereco, email,
                                telefone,
                                LocalDate.now());

                        // scanner.nextLine();

                        System.out.print("ID do cliente: ");
                        Long idClientePagamento = scanner.nextLong();
                        scanner.nextLine();

                        System.out.print("Número do cartão: ");
                        String numeroCartao = scanner.nextLine();

                        System.out.print("Nome no cartão: ");
                        String nomeCartao = scanner.nextLine();

                        System.out.print("Data de validade (MM/yyyy): ");
                        String dataValidade = scanner.nextLine();

                        System.out.print("Código de segurança: ");
                        String codigoSeguranca = scanner.nextLine();

                        System.out.print("Forma de pagamento (credito ou debito): ");
                        FormaDePagamento formaPagamento = FormaDePagamento.valueOf(scanner.nextLine().toUpperCase());

                        System.out.print("CPF do titular do cartão: ");
                        String cpfTitular = scanner.nextLine();

                        // CRIA INFORMACOES DE DADOS DE PAGAMENTO DE UM CLIENTE
                        DadosDePagamento dadosDePagamento = new DadosDePagamento(1L, idClientePagamento,
                                numeroCartao, nomeCartao, dataValidade, codigoSeguranca, formaPagamento, cpfTitular);
                        List<DadosDePagamento> dadosDePagamentoList = new ArrayList<DadosDePagamento>();
                        dadosDePagamentoList.add(dadosDePagamento);
                        cliente.setdadosDePagamento(dadosDePagamentoList);

                        clientes.add(cliente);
                        // clientes.add(dadosDePagamento);
                        // EXIBE NO CONSOLE AS INFORMACOES DO CLIENTE
                        cliente.dados();
                    } else {
                        System.out.println("sou proprietario");

                        // CRIA UM PROPRIETÁRIO
                        Proprietario proprietario = new Proprietario(nome, rg, cpf, dataNascimento, sexo, endereco,
                                email, telefone,
                                LocalDate.now());

                        System.out.println("Digite as informações bancárias do proprietário:");

                        System.out.print("Banco: ");
                        String banco = scanner.nextLine();

                        System.out.print("Agência: ");
                        String agencia = scanner.nextLine();

                        System.out.print("Número da conta: ");
                        String numeroConta = scanner.nextLine();

                        System.out.print("Dígito: ");
                        String digito = scanner.nextLine();

                        System.out.print("Tipo de conta (CORRENTE ou POUPANCA): ");
                        TipoDeConta tipoConta = TipoDeConta.valueOf(scanner.nextLine().toUpperCase());

                        // CRIA INFORMACOES DE DADOS BANCARIOS DO PROPRIETARIO
                        DadosBancarios dadosBancarios = new DadosBancarios(banco, agencia, numeroConta, digito,
                                tipoConta);
                        proprietario.setDadosBancarios(dadosBancarios);
                        proprietarios.add(proprietario);
                        // EXIBE NO CONSOLE AS INFORMACOES DO PROPRIETÁRIO
                        proprietario.dados();
                        // scanner.close();

                    }

                    break;

                case 2:
                    System.out.println("Digite as informações do imóvel:");

                    // System.out.print("ID: ");
                    // Long idImovel = scanner.nextLong();
                    // scanner.nextLine();

                    System.out.print("ID do proprietário: ");
                    Long idProprietarioImovel = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Endereço: ");
                    String enderecoImovel = scanner.nextLine();

                    System.out.print("Tipo de imóvel (CASA, APARTAMENTO, etc.): ");
                    TipoDeImovel tipoImovel = TipoDeImovel.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Número de quartos: ");
                    int quartos = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Número de banheiros: ");
                    int banheiros = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Área em metros quadrados: ");
                    double area = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Preço: ");
                    double precoImovel = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Disponibilidade (S ou N): ");
                    Disponibilidade disponibilidade = Disponibilidade.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();

                    // CRIA UM IMOVEL
                    Imovel imovelSla = new Imovel(idProprietarioImovel, enderecoImovel, tipoImovel, quartos,
                            banheiros, area, new Preco(precoImovel), disponibilidade, descricao);

                    // EXIBE NO CONSOLE AS INFORMACOES DO IMOVEL
                    imovelSla.dados();
                    break;
                case 3:
                    // Código para iniciar locação
                    System.out.println("Digite as informações para iniciar a locação:\n");

                    // System.out.print("ID da locação: ");
                    // Long idLocacao = scanner.nextLong();
                    // scanner.nextLine();

                    System.out.print("ID do cliente: ");
                    Long idClienteLocacao = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("ID do imóvel: ");
                    Long idImovelLocacao = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Data de início da locação - Check in (dd/MM/yyyy): ");
                    String dataInicioLocacao = scanner.nextLine();

                    System.out.print("Hora de início da locação - Check in (HH:mm): ");
                    String horaInicioLocacao = scanner.nextLine();

                    System.out.print("Data de término - Check out (dd/MM/yyyy): ");
                    String dataTerminoLocacao = scanner.nextLine();

                    System.out.print("Hora de término - Check out (HH:mm): ");
                    String horaTerminoLocacao = scanner.nextLine();

                    System.out.print("Valor: ");
                    Double valorLocacao = scanner.nextDouble();
                    scanner.nextLine();
                    // Encontrar o imóvel pelo ID
                    Imovel imovel = null;
                    for (Imovel i : imoveis) {
                        if (i.getId().equals(idImovelLocacao)) {
                            imovel = i;
                            break;
                        }
                    }

                    if (imovel == null) {
                        System.out.println("Imóvel não encontrado.");
                        break;
                    }

                    // Verificar disponibilidade do imóvel
                    if (imovel.getDisponibilidade() != Disponibilidade.S) {
                        System.out.println("Imóvel não está disponível para locação.");
                        break;
                    }

                    // INICIA A LOCAÇÃO
                    locacao = new Locacao(idClienteLocacao, imovel, idImovelLocacao,
                            dataInicioLocacao, horaInicioLocacao, dataTerminoLocacao, horaTerminoLocacao,
                            valorLocacao,
                            Status.PENDENTE);

                    locacoes.add(locacao);
                    // EXIBE NO CONSOLE AS INFORMACOES DA LOCAÇÃO
                    locacao.dados();

                    // scanner.close();
                    break;
                case 4:
                    System.out.println("Cancelar locação");
                    if (locacao != null) {
                        locacao.cancelarLocacao();
                        locacao.dados();
                    } else {
                        System.out.println("Nenhuma locação ativa para cancelar.");
                    }
                    break;

                case 5:
                    // Códigos ANSI para cores
                    final String RESET = "\u001B[0m";
                    final String RED = "\u001B[31m";
                    final String GREEN = "\u001B[32m";
                    final String YELLOW = "\u001B[33m";
                    final String BLUE = "\u001B[34m";

                    System.out.println(GREEN + "Clientes cadastrados:\n" + RESET);
                    for (Cliente cliente : clientes) {
                        System.out.println(RED + "ID: " + cliente.getId() + RESET);
                        System.out.println("Nome: " + cliente.getNome());
                        System.out.println("RG: " + cliente.getRg());
                        System.out.println("CPF: " + cliente.getCpf());
                        System.out.println("Data de Nascimento: " + cliente.getData_nascimento());
                        System.out.println("Sexo: " + cliente.getSexo());
                        System.out.println("Endereço: " + cliente.getEndereco());
                        System.out.println("Email: " + cliente.getEmail());
                        System.out.println("Telefone: " + cliente.getTelefone());
                        System.out.println("Data de Cadastro: " + cliente.getData_cadastro());
                        System.out.println("----------------------------");
                    }

                    System.out.println(YELLOW + "Proprietários cadastrados:\n" + RESET);
                    for (Proprietario proprietario : proprietarios) {
                        System.out.println(BLUE + "ID: " + proprietario.getId() + RESET);
                        System.out.println("Nome: " + proprietario.getNome());
                        System.out.println("RG: " + proprietario.getRg());
                        System.out.println("CPF: " + proprietario.getCpf());
                        System.out.println("Data de Nascimento: " + proprietario.getData_nascimento());
                        System.out.println("Sexo: " + proprietario.getSexo());
                        System.out.println("Endereço: " + proprietario.getEndereco());
                        System.out.println("Email: " + proprietario.getEmail());
                        System.out.println("Telefone: " + proprietario.getTelefone());
                        System.out.println("Data de Cadastro: " + proprietario.getData_cadastro());
                        System.out.println("----------------------------");
                    }

                    System.out.println(RED + "Imóveis cadastrados:\n" + RESET);
                    for (Imovel imovell : imoveis) {
                        System.out.println(GREEN + "ID: " + imovell.getId() + RESET);
                        System.out.println("Endereço: " + imovell.getEndereco());
                        System.out.println("Tipo: " + imovell.getTipo());
                        System.out.println("Quartos: " + imovell.getQuartos());
                        System.out.println("Banheiros: " + imovell.getBanheiros());
                        System.out.println("Área: " + imovell.getArea() + " m²");
                        System.out.println("Preço: " + imovell.getPreco());
                        System.out.println("Disponibilidade: " + imovell.getDisponibilidade());
                        System.out.println("Descrição: " + imovell.getDescricao());
                        System.out.println("----------------------------");
                    }

                    System.out.println(BLUE + "Locações:\n" + RESET);
                    for (Locacao loca : locacoes) {
                        System.out.println(YELLOW + "ID: " + loca.getId() + RESET);
                        System.out.println("Cliente: " + loca.getClienteId());
                        System.out.println("Imóvel: " + loca.getImovelId());
                        System.out.println("Data de Início: " + loca.getInicioLocacao());
                        System.out.println("Hora de Início: " + loca.getHoraInicioLocacao());
                        System.out.println("Data de Término: " + loca.getFimLocacao());
                        System.out.println("Hora de Término: " + loca.getHoraFimLocacao());
                        System.out.println("Adiantamento já pago: " + loca.getValorCaucao());
                        System.out.println("Status: " + loca.getStatusLocacao());
                        System.out.println("Total do aluguel: " + loca.calcularValorTotal());
                        System.out.println("Quantidade de dias de aluguel: " + loca.calcularQuantidadeDias());
                        System.out.println("----------------------------");
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

    }
}
