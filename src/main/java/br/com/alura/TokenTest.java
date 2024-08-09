package br.com.alura;

import br.com.alura.integration.Model;
import br.com.alura.util.TokenUtil;

public class TokenTest {

    public static void main(String[] args) {
        Model model = Model.GPT_3_5_TURBO;

        String prompt = "Identifique o perfil de compra de cada cliente";

        var countTokens = TokenUtil.count(model, prompt);

        System.out.println("Quantidade de tokens: " + countTokens);

        var amount = TokenUtil.amount(model, prompt);

        System.out.println("Custo aproximado da requisição: R$ " + amount);
    }

}
