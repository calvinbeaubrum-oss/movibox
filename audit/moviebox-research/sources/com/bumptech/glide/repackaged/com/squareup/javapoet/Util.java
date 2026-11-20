package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Modifier;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class Util {
    static final Modifier DEFAULT;

    static {
        Modifier modifierValueOf;
        try {
            modifierValueOf = Modifier.valueOf("DEFAULT");
        } catch (IllegalArgumentException unused) {
            modifierValueOf = null;
        }
        DEFAULT = modifierValueOf;
    }

    public static String characterLiteralWithoutSingleQuotes(char c11) {
        if (c11 == '\f') {
            return "\\f";
        }
        if (c11 == '\r') {
            return "\\r";
        }
        if (c11 == '\"') {
            return "\"";
        }
        if (c11 == '\'') {
            return "\\'";
        }
        if (c11 == '\\') {
            return "\\\\";
        }
        switch (c11) {
            case '\b':
                return "\\b";
            case '\t':
                return "\\t";
            case '\n':
                return "\\n";
            default:
                return Character.isISOControl(c11) ? String.format("\\u%04x", Integer.valueOf(c11)) : Character.toString(c11);
        }
    }

    public static void checkArgument(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T checkNotNull(T t11, String str, Object... objArr) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static void checkState(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static boolean hasDefaultModifier(Collection<Modifier> collection) {
        Modifier modifier = DEFAULT;
        return modifier != null && collection.contains(modifier);
    }

    public static <T> List<T> immutableList(Collection<T> collection) {
        return Collections.unmodifiableList(new ArrayList(collection));
    }

    public static <K, V> Map<K, V> immutableMap(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static <K, V> Map<K, List<V>> immutableMultimap(Map<K, List<V>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                linkedHashMap.put(entry.getKey(), immutableList(entry.getValue()));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static <T> Set<T> immutableSet(Collection<T> collection) {
        return Collections.unmodifiableSet(new LinkedHashSet(collection));
    }

    public static String join(String str, List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(list.get(0));
        for (int i11 = 1; i11 < list.size(); i11++) {
            sb2.append(str);
            sb2.append(list.get(i11));
        }
        return sb2.toString();
    }

    public static void requireExactlyOneOf(Set<Modifier> set, Modifier... modifierArr) {
        int i11 = 0;
        for (Modifier modifier : modifierArr) {
            if ((modifier != null || DEFAULT != null) && set.contains(modifier)) {
                i11++;
            }
        }
        checkArgument(i11 == 1, "modifiers %s must contain one of %s", set, Arrays.toString(modifierArr));
    }

    public static String stringLiteralWithDoubleQuotes(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str.length() + 2);
        sb2.append('\"');
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '\'') {
                sb2.append("'");
            } else if (cCharAt == '\"') {
                sb2.append("\\\"");
            } else {
                sb2.append(characterLiteralWithoutSingleQuotes(cCharAt));
                if (cCharAt == '\n' && i11 + 1 < str.length()) {
                    sb2.append("\"\n");
                    sb2.append(str2);
                    sb2.append(str2);
                    sb2.append("+ \"");
                }
            }
        }
        sb2.append('\"');
        return sb2.toString();
    }

    public static <T> Set<T> union(Set<T> set, Set<T> set2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set);
        linkedHashSet.addAll(set2);
        return linkedHashSet;
    }
}
