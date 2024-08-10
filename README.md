# Curso GPT e Java: Integração com a OpenAI

## Descrição

Este curso cobre a integração de uma aplicação Java com a API da OpenAI, incluindo práticas de engenharia de prompts, gestão de custos, e tratamento de erros.

### Tópicos Abordados

- Desenvolva uma aplicação Java integrada com a API da OpenAI.
- Utilize bibliotecas Java que facilitam a integração com a API.
- Aprenda boas práticas de engenharia de prompts para otimizar as interações com a IA.
- Diferencie e escolha entre os modelos de GPT disponíveis na API da OpenAI.
- Faça a gestão de custos relacionados ao uso de tokens.
- Implemente a contagem de tokens para estimar custos.
- Trate erros e use boas práticas ao se conectar com APIs externas.

### Aula 1: Recursos da API

- Crie uma conta no site da OpenAI.
- Realize configurações de meios de pagamento.
- Ajuste limites financeiros de utilização da API.
- Utilize o modo chat, via playground, para simular interações com a API da OpenAI.

### Aula 2: Integração via Java

- Crie um projeto Java no IntelliJ.
- Adicione ao projeto a dependência do `openai-java`.
- Escreva um código Java que se integra à API da OpenAI.
- Crie uma chave de API na OpenAI e utilize-a no código Java.
- Proteja a chave da API no código, utilizando variáveis de ambiente.

### Aula 3: Prompt Engineering e Template

- Ajuste o código para que a API devolva mais de uma resposta para uma mesma requisição.
- Avalie as respostas devolvidas pela API para realizar ajustes nos prompts.
- Aplique o prompt engineering para melhorar os prompts de sistema e do usuário.
- Utilize o prompt template para deixar a aplicação mais dinâmica.
- Minimize as chances dos usuários conseguirem manipular as respostas da API.

### Aula 4: Custos, Modelos e Tokens

- Entenda como funcionam os limites de tokens em requisições enviadas para a API da OpenAI.
- Saiba que tokens são representados em textos.
- O cálculo de tokens é feito pela OpenAI.
- Utilize uma biblioteca Java para realizar a contagem de tokens em requisições.
- Deixe o código da aplicação dinâmico, em relação ao modelo a ser utilizado nas requisições.

### Aula 5: Batch e Tratamento de Erros

- Realize chamadas em lote para a API.
- Compreenda os códigos de erros que a API da OpenAI retorna em caso de problemas.
- Realize o tratamento de erros no código da aplicação.
- Conheça os limites de requisições impostos pela OpenAI.
- Adapte o código para realizar novas tentativas de requisições após um período de tempo.

## Requirements

- [JDK 18](https://www.oracle.com/br/java/technologies/javase/jdk18-archive-downloads.html)
- [Maven](https://maven.apache.org)

## Build

```shell
cd alura-openai-java
mvn install
```

## Run

1. `br.com.alura.IntegrationTest`
2. `br.com.alura.ProductCategorizer`
3. `br.com.alura.TokenTest`
3. `br.com.alura.ProfileIdentifier`
3. `br.com.alura.SentimentAnalyzer`

## Environment variables

 Name                | Value           
---------------------|-----------------
 OPENAI_API_KEY      | OpenAI API Key  
 OPENAI_API_DURATION | OpenAI Duration 

## Important links

* [Alura | Curso de GPT e Java: Integre uma aplicação com a OpenAI](https://cursos.alura.com.br/course/gpt-java-integre-aplicacao-openai)
* [OpenAI | Docs](https://platform.openai.com/docs/overview)
* [OpenAI | Api Reference](https://platform.openai.com/docs/api-reference/introduction)
* [OpenAI | Libraries](https://platform.openai.com/docs/libraries/community-libraries)
* [GitHub | OpenAI Java Library](https://github.com/TheoKanning/openai-java)
* [OpenAI | API Keys](https://platform.openai.com/api-keys)
* [OpenAI | Create chat completion](https://platform.openai.com/docs/api-reference/chat/create)
* [OpenAI | Prompt engineering](https://platform.openai.com/docs/guides/prompt-engineering/prompt-engineering)
* [OpenAI | Models](https://platform.openai.com/docs/models)
* [OpenAI | Pricing](https://openai.com/api/pricing)
* [OpenAI | Tokenizer tool](https://platform.openai.com/tokenizer)
* [GitHub | Java Tokenizer Kit](https://github.com/knuddelsgmbh/jtokkit)
* [OpenAI | Error codes](https://platform.openai.com/docs/guides/error-codes)
* [OpenAI | Rate limits](https://platform.openai.com/docs/guides/rate-limits?context=tier-free)