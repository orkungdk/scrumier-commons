package tr.com.ogedik.commons.util;

import lombok.experimental.UtilityClass;
import tr.com.ogedik.commons.expection.ErrorException;
import tr.com.ogedik.commons.expection.constants.CommonErrorType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is a utility class for {@link java.util.Map}
 *
 * @author orkun.gedik
 */
@UtilityClass
public class MapUtils {

    public static Map<String, String> of(String... args) {
        if (args == null) {
            throw new ErrorException(CommonErrorType.INTERNAL_ERROR, "Arguments cannot be null for MapUtils.of().");
        } else if (args.length % 2 == 1) {
            throw new ErrorException(CommonErrorType.INTERNAL_ERROR, "Argument number cannot be odd.");
        }

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < args.length; i += 2) {
            map.put(args[i], args[i + 1]);
        }

        return map;
    }

    public static <K, V> Map<K, V> of(List<K> keys, List<V> values) {
        if (keys == null || values == null) {
            throw new ErrorException(CommonErrorType.INTERNAL_ERROR, "Arguments cannot be null for MapUtils.of().");
        } else if (keys.size() != values.size()) {
            throw new ErrorException(CommonErrorType.INTERNAL_ERROR, "Arguments size must be equal for MapUtils.of().");
        }

        Map<K, V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }

        return map;
    }
}
