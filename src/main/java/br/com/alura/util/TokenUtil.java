package br.com.alura.util;

import br.com.alura.integration.Model;
import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.EncodingRegistry;

import java.math.BigDecimal;

public class TokenUtil {

    private static final BigDecimal ONE_THOUSAND = new BigDecimal("1000");

    private static final EncodingRegistry ENCODING_REGISTRY = Encodings.newDefaultEncodingRegistry();

    public static Integer count(Model model, String prompt) {
        var enc = ENCODING_REGISTRY.getEncodingForModel(model.toModelType());
        return enc.countTokens(prompt);
    }

    public static BigDecimal amount(Model model, String prompt) {
        Integer countTokens = TokenUtil.count(model, prompt);
        return new BigDecimal(countTokens)
                .divide(ONE_THOUSAND)
                .multiply(model.getPrice());
    }

}
