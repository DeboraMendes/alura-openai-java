package br.com.alura;

import br.com.alura.integration.OpenAI;

public class IntegrationTest {
    public static void main(String[] args) {
        var user = "Gere 5 produtos";
        var system = "Você é um gerador de produtos fictícios para um ecommerce e deve gerar apenas o nome dos produtos solicitados pelo usuário";

        OpenAI.execute(user, system);
    }
}