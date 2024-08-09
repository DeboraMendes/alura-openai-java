package br.com.alura;

import br.com.alura.integration.Model;
import br.com.alura.integration.OpenAI;

import java.util.Scanner;

public class ProductCategorizer {

    private static final String EXIT_COMMAND = "fim";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite as categorias válidas separadas por vírgula:");
        //eletrônicos, esportes, alimentação, educação
        String categories = scanner.nextLine();

        //livro
        String user;

        do {
            System.out.printf("\nDigite o nome do produto (ou '%s' para encerrar):%n", EXIT_COMMAND);
            user = scanner.nextLine();

            if (!user.equalsIgnoreCase(EXIT_COMMAND)) {
                String system = """
                        Você é um categorizador de produtos e deve responder apenas o nome da categoria do produto informado
                                        
                        Escolha uma categoria dentra a lista abaixo:
                                        
                        %s
                                        
                        ###### exemplo de uso:
                                        
                        Pergunta: Bola de futebol
                        Resposta: Esportes
                                                
                        ###### regras a serem seguidas:
                        Caso o usuário pergunte algo que não seja de categorização de produtos, você deve responder que não pode ajudar pois o seu papel é apenas responder a categoria dos produtos
                        """.formatted(categories);

                String response = OpenAI.getResponse(Model.GPT_4, system, user);
                System.out.println(response);
            }

        } while (!user.equalsIgnoreCase(EXIT_COMMAND));

        scanner.close();
    }

}