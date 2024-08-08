package br.com.alura.integration;

import com.knuddels.jtokkit.api.ModelType;

import java.math.BigDecimal;

public enum Model {

    GPT_4("gpt-4", new BigDecimal("0.03"), 8192),
    GPT_3_5_TURBO("gpt-3.5-turbo", new BigDecimal("0.0010"), 4096),
    GPT_3_5_TURBO_16k("gpt-3.5-turbo-16k", new BigDecimal("0.0015"), 16385);

    private final String name;
    private final BigDecimal price;
    private final Integer tokenLimit;

    Model(String name, BigDecimal price, Integer tokenLimit) {
        this.name = name;
        this.price = price;
        this.tokenLimit = tokenLimit;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getTokenLimit() {
        return tokenLimit;
    }

    public ModelType toModelType() {
        return ModelType.fromName(this.name)
                .orElseThrow(() -> new RuntimeException("Error getting model type"));
    }

}
