package br.com.alura;

import br.com.alura.integration.Model;
import br.com.alura.integration.OpenAI;
import br.com.alura.util.FileUtil;

import java.nio.file.Path;

public class SentimentAnalyzer {

    public static void main(String[] args) {
        var system = """
                Você é um analisador de sentimentos de avaliações de produtos.
                Escreva um parágrafo com até 50 palavras resumindo as avaliações e depois atribua qual o sentimento geral para o produto.
                Identifique também 3 pontos fortes e 3 pontos fracos identificados a partir das avaliações.

                #### Formato de saída
                Nome do produto:
                Resumo das avaliações: [resuma em até 50 palavras]
                Sentimento geral: [deve ser: POSITIVO, NEUTRO ou NEGATIVO]
                Pontos fortes: [3 bullets points]
                Pontos fracos: [3 bullets points]
                """;

        var fileType = ".txt";

        var reviews = FileUtil.loadFile("reviews", fileType);

        for (Path review : reviews) {
            String productName = review.getFileName().toString().replace(fileType, "");

            System.out.println("Iniciando análise do produto: " + productName);

            var user = FileUtil.readFile(review);

            var response = OpenAI.getResponse(Model.GPT_4_1106_PREVIEW, system, user);

            FileUtil.saveFile("analysis", productName + "-sentiment-analysis" + fileType, response);

            System.out.println("Finalizada a análise do produto: " + productName);
            System.out.println("-----------------------------------------------");
        }

    }

}
