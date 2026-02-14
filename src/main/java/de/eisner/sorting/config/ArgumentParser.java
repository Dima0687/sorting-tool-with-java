package de.eisner.sorting.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ArgumentParser {
    private static final Set<String> VALID_ARGS = Set.of(
            "sortingType",
            "dataType",
            "inputFile",
            "outputFile"
    );

    private ArgumentParser() {
    }

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
