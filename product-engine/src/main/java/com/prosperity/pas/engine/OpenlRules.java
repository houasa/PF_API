package com.prosperity.pas.engine;

import org.openl.rules.runtime.RulesEngineFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Loads and compiles the OpenL rules workbook once, returning a bound
 * {@link PremiumBonusRules} proxy.
 *
 * <p>Compilation is heavy, so callers should hold the returned instance as a
 * singleton (the {@code pas-api} wires it as a Spring bean at startup). The
 * classpath resource is copied to a temp file because {@link RulesEngineFactory}
 * loads from a file path.
 */
public final class OpenlRules {

    private static final String RESOURCE = "rules/PremiumBonus.xlsx";

    private OpenlRules() {
    }

    public static PremiumBonusRules load() {
        try (InputStream in = OpenlRules.class.getClassLoader().getResourceAsStream(RESOURCE)) {
            if (in == null) {
                throw new IllegalStateException("OpenL rules not found on classpath: " + RESOURCE);
            }
            Path tmp = Files.createTempFile("PremiumBonus", ".xlsx");
            tmp.toFile().deleteOnExit();
            Files.copy(in, tmp, StandardCopyOption.REPLACE_EXISTING);

            RulesEngineFactory<PremiumBonusRules> factory =
                    new RulesEngineFactory<>(tmp.toString(), PremiumBonusRules.class);
            return factory.newEngineInstance();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
