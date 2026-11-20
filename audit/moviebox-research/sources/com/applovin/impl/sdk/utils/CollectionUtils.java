package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class CollectionUtils {
    public static <T> boolean addObjectIfExists(@Nullable T t11, List<T> list) {
        if (t11 != null) {
            return list.add(t11);
        }
        return false;
    }

    public static <T> boolean addUniqueObjectIfExists(@Nullable T t11, List<T> list) {
        if (t11 == null || list.contains(t11)) {
            return false;
        }
        return list.add(t11);
    }

    public static <T> void addUniqueObjectsIfExists(@Nullable List<T> list, List<T> list2) {
        if (list == null) {
            return;
        }
        for (T t11 : list) {
            if (!list2.contains(t11)) {
                list2.add(t11);
            }
        }
    }

    public static List<String> explode(String str) {
        return explode(str, ",\\s*");
    }

    public static List<String> explode(String str, String str2) {
        return TextUtils.isEmpty(str) ? Collections.emptyList() : Arrays.asList(str.split(str2));
    }

    public static boolean getBoolean(Map<String, Object> map, String str) {
        return getBoolean(map, str, false);
    }

    public static boolean getBoolean(Map<String, Object> map, String str, boolean z11) {
        if (map != null && map.containsKey(str)) {
            Object obj = map.get(str);
            if (obj instanceof String) {
                return Boolean.parseBoolean((String) obj);
            }
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            if (obj instanceof Number) {
                return ((Number) obj).intValue() >= 1;
            }
        }
        return z11;
    }

    @Nullable
    public static <T> Set<T> getDifferenceSet(@Nullable Set<T> set, @Nullable Set<T> set2) {
        if (set == null) {
            return null;
        }
        if (set2 == null) {
            return new HashSet(set);
        }
        HashSet hashSet = new HashSet(set);
        hashSet.removeAll(set2);
        return hashSet;
    }

    public static HashMap<String, String> hashMap(String str, String str2) {
        return (HashMap) map(str, str2);
    }

    public static String implode(Collection<String> collection, int i11) {
        return implode(collection, ",", i11);
    }

    public static String implode(Collection<String> collection, String str, int i11) {
        if (str == null) {
            throw new IllegalArgumentException("No glue specified");
        }
        if (collection == null || collection.size() < 1) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i12 = 0;
        for (String str2 : collection) {
            if (i12 >= i11) {
                break;
            }
            i12++;
            sb2.append(str2);
            sb2.append(str);
        }
        if (sb2.length() > str.length()) {
            sb2.setLength(sb2.length() - str.length());
        }
        return sb2.toString();
    }

    public static <E> boolean isEmpty(@Nullable Collection<E> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <K, V> boolean isEmpty(@Nullable Map<K, V> map) {
        return map == null || map.isEmpty();
    }

    public static <K, V> Map<K, V> map(K k11, V v11) {
        HashMap map = new HashMap(1);
        map.put(k11, v11);
        return map;
    }

    public static <K, V> Map<K, V> map(Map<K, V> map) {
        return map == null ? new HashMap() : new HashMap(map);
    }

    public static void putBooleanIfValid(String str, Boolean bool, Map map) {
        if (!StringUtils.isValidString(str) || bool == null) {
            return;
        }
        map.put(str, bool);
    }

    public static void putDoubleIfValid(String str, Double d11, Map map) {
        if (!StringUtils.isValidString(str) || d11 == null) {
            return;
        }
        map.put(str, d11);
    }

    public static void putFloatIfValid(String str, Float f11, Map map) {
        if (!StringUtils.isValidString(str) || f11 == null) {
            return;
        }
        map.put(str, f11);
    }

    public static void putIntegerIfValid(String str, Integer num, Map map) {
        if (!StringUtils.isValidString(str) || num == null) {
            return;
        }
        map.put(str, num);
    }

    public static void putJsonArrayIfValid(String str, JSONArray jSONArray, Map map) {
        if (!StringUtils.isValidString(str) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        map.put(str, jSONArray);
    }

    public static void putLongIfValid(String str, Long l11, Map map) {
        if (!StringUtils.isValidString(str) || l11 == null) {
            return;
        }
        map.put(str, l11);
    }

    public static void putObjectToStringIfValid(String str, Object obj, Map map) {
        if (obj == null) {
            return;
        }
        putStringIfValid(str, obj.toString(), map);
    }

    public static void putStringIfValid(String str, String str2, Map map) {
        if (StringUtils.isValidString(str) && StringUtils.isValidString(str2)) {
            map.put(str, str2);
        }
    }

    public static List<String> removeTrimmedEmptyStrings(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String strTrim = it.next().trim();
            if (!TextUtils.isEmpty(strTrim)) {
                arrayList.add(strTrim);
            }
        }
        return arrayList;
    }

    public static <T> List<T> synchronizedList() {
        return synchronizedList(-1);
    }

    public static <T> List<T> synchronizedList(int i11) {
        return i11 >= 0 ? Collections.synchronizedList(new ArrayList(i11)) : Collections.synchronizedList(new ArrayList());
    }

    public static Bundle toBundle(Map<String, ?> map) {
        if (map == null || map.size() == 0) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof Map) {
                bundle.putBundle(str, toBundle((Map) obj));
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof String) {
                bundle.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
            }
        }
        return bundle;
    }

    @Nullable
    public static JSONArray toJSONArray(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : strArr) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    public static JSONObject toJson(Map<String, ?> map) throws JSONException {
        if (map == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    public static String toJsonString(Map<String, String> map, String str) {
        try {
            return toJson(map).toString();
        } catch (JSONException e11) {
            n.c("CollectionUtils", "Failed to convert map '" + map + "' to JSON string.", e11);
            return str;
        }
    }
}
