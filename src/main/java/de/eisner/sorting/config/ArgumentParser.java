package de.eisner.sorting.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Utility class responsible for parsing command-line arguments
 * and converting them into a {@link Config} instance.
 *
 * <p>The parser supports the following parameters:
 * <ul>
 *     <li>-sortingType</li>
 *     <li>-dataType</li>
 *     <li>-inputFile</li>
 *     <li>-outputFile</li>
 * </ul>
 *
 * <p>Invalid parameters are ignored with a console warning.
 * If a provided {@code dataType} or {@code sortingType} value is invalid,
 * parsing fails and an empty {@link Optional} is returned.
 *
 * <p>If no {@code dataType} is specified, {@link DataType#WORD} is used as default.
 * If no {@code sortingType} is specified, {@link SortType#NATURAL} is used as default.
 *
 * <p>This class cannot be instantiated.
 */
public class ArgumentParser {
    private static final Set<String> VALID_ARGS = Set.of(
            "sortingType",
            "dataType",
            "inputFile",
            "outputFile"
    );

    private ArgumentParser() {
    }

    /**
     * Parses the given command-line arguments into a {@link Config} object.
     *
     * @param args the raw command-line arguments
     * @return an {@link Optional} containing the resulting {@link Config},
     *         or {@link Optional#empty()} if parsing fails due to invalid enum values
     */
    public static Optional<Config> parse(String[] args) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < args.length; i++) {

            String raw = args[i];

            if (!raw.startsWith("-")) continue;

            String key = raw.substring(1);

            if (!VALID_ARGS.contains(key)) {
                System.out.printf("\"%s\" is not a valid parameter. It will be skipped.%n", raw);
                continue;
            }

            map.put(key, args[++i]);
        }

        DataType dataType;
        SortType sortType;

        if (map.containsKey("dataType")) {
            try {
                dataType = DataType.from(map.get("dataType"));
            } catch (IllegalArgumentException iae) {
                System.out.println("No data type defined!");
                return Optional.empty();
            }
        } else {
            dataType = DataType.WORD;
        }

        if (map.containsKey("sortingType")) {
            try {
                sortType = SortType.from(map.get("sortingType"));
            } catch (IllegalArgumentException iae) {
                System.out.println("No sorting type defined!");
                return Optional.empty();
            }
        } else {
            sortType = SortType.NATURAL;
        }

        return Optional.of(new Config(
                dataType,
                sortType,
                map.get("inputFile"),
                map.get("outputFile")
        ));
    }
}
