package br.com.alura;

import br.com.alura.env.EnvironmentVariable;
import br.com.alura.integration.Model;
import br.com.alura.integration.OpenAI;
import br.com.alura.util.FileUtil;
import br.com.alura.util.TokenUtil;

public class ProfileIdentifier {

    public static void main(String[] args) {
        Model model = Model.GPT_3_5_TURBO;

        var system = """
                Identifique o perfil de compra de cada cliente.
                                
                A resposta deve ser:
                                
                Cliente - descreva o perfil do cliente em três palavras
                """;

        var user = FileUtil.loadFromFile("shopping_list _10_customers.csv");

        Integer systemCountTokens = TokenUtil.count(model, system);
        Integer userCountTokens = TokenUtil.count(model, user);
        Integer countTokens = systemCountTokens + userCountTokens;
        System.out.println("Quantidade de tokens: " + countTokens);

        Integer maxTokens = model.getTokenLimit() - EnvironmentVariable.getOpenAIMaxTokens();

        if (countTokens > maxTokens) {
            model = Model.GPT_3_5_TURBO_16k;
        }

        OpenAI.execute(model, user, system);
    }

}
