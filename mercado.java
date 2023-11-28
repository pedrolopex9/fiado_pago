package fiadopago;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mercado {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<produto> produtos;
    private static Map<produto, Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        menu();
    }

    private static void menu() {
        System.out.println("-----------------------------------");
        System.out.println("--------Cadastrar produtos---------------------------");
        System.out.println("Selecione a opção que deseja");
        System.out.println("Opção 1 - Cadastrar");
        System.out.println("Opção 2 - Listar");
        System.out.println("Opção 3 - Comprar");
        System.out.println("Opção 4 - Carrinho");
        System.out.println("Opção 5 - Sair");

        int option = input.nextInt();
        switch (option) {
            case 1:
                cadastrarProdutos();
                break;

            case 2:
                listarProdutos();
                break;

            case 3:
                comprarProdutos();
                break;

            case 4:
                verCarrinho();
                break;

            case 5:
                System.out.println("Obrigado pela preferência");
                System.exit(0);

            default:
                System.out.println("Opção inválida");
                menu();
                break;
        }
    }

    private static void cadastrarProdutos() {
        System.out.println("Nome do produto:");
        String nome = input.next();

        System.out.println("Preço do produto:");
        double preco = input.nextDouble();

        produto produto = new produto(nome, preco);
        produtos.add(produto);

        System.out.println(produto.getNome() + " cadastrado com sucesso");

        menu();
    }

    private static void listarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("Lista de produtos! \n");

            for (produto p : produtos) {
                System.out.println(p);
            }
        } else {
            System.out.println("Nenhum produto cadastrado");
        }

        menu();
    }

    private static void comprarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("Código do produto: \n");
            System.out.println("-----Produtos Disponíveis");

            for (produto p : produtos) {
                System.out.println(p + "\n");
            }

            int id = input.nextInt();
            boolean isPresent = false;

            for (produto p : produtos) {
                if (p.getId() == id) {
                    int qtd = 0;
                    try {
                        qtd = carrinho.get(p);
                        carrinho.put(p, qtd + 1);
                    } catch (NullPointerException e) {
                        carrinho.put(p, 1);
                    }

                    System.out.println(p.getNome() + " adicionado ao carrinho.");
                    isPresent = true;

                    if (isPresent) {
                        System.out.println("Deseja adicionar outro produto ao carrinho?");
                        System.out.println("Digite 1 para sim, ou 0 para finalizar a compra.\n");
                        int option = input.nextInt();
                        if (option == 1) {
                            comprarProdutos();
                        } else {
                            finalizarCompra();
                        }
                    }
                } else {
                    System.out.println("Produto não encontrado");
                    menu();
                }
            }
        } else {
            System.out.println("Produto não encontrado");
            menu();
        }
    }

    private static void verCarrinho() {
        System.out.println("--- Produtos no seu carrinho!---");

        if (carrinho.size() > 0) {
            for (produto p : carrinho.keySet()) {
                System.out.println("Produto " + p + "\nQuantidade: " + carrinho.get(p));
            }
        } else {
            System.out.println("Carrinho está vazio");
        }

        menu();
    }

    private static void finalizarCompra() {
        double valorTotal = 0.0;
        System.out.println("Seus Produtos");

        for (produto p : carrinho.keySet()) {
            int qtd = carrinho.get(p);
            valorTotal += p.getPreco() * qtd;
            System.out.println(p);
            System.out.println("Quantidade: " + qtd);
        }

        System.out.println("O valor da sua compra é " + utils.doubleToString(valorTotal));
        carrinho.clear();
        System.out.println("Obrigado pela preferência");
        menu();
    }
}
