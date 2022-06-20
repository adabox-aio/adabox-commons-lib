package io.adabox.utils;

public class StringUtils {

    public static String toSnakeCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < str.length() ; i++) {
            // Converting space
            // to underscore
            if (str.charAt(i) == ' ')
                stringBuilder.append('_');
            else
                // If not space, convert
                // into lower character
                stringBuilder.append(Character.toLowerCase(str.charAt(i)));
        }
        return stringBuilder.toString();
    }
}
