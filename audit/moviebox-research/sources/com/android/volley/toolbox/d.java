package com.android.volley.toolbox;

import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static List<com.android.volley.e> a(List<com.android.volley.e> list, com.android.volley.c.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<com.android.volley.e> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<com.android.volley.e> list2 = aVar.f16497h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (com.android.volley.e eVar : aVar.f16497h) {
                    if (!treeSet.contains(eVar.a())) {
                        arrayList.add(eVar);
                    }
                }
            }
        } else if (!aVar.f16496g.isEmpty()) {
            for (Map.Entry<String, String> entry : aVar.f16496g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new com.android.volley.e(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    public static String b(long j11) {
        return d("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j11));
    }

    public static Map<String, String> c(com.android.volley.c.a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap();
        String str = aVar.f16491b;
        if (str != null) {
            map.put("If-None-Match", str);
        }
        long j11 = aVar.f16493d;
        if (j11 > 0) {
            map.put("If-Modified-Since", b(j11));
        }
        return map;
    }

    public static SimpleDateFormat d(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    @Nullable
    public static com.android.volley.c.a e(com.android.volley.g gVar) {
        boolean z11;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = gVar.f16506c;
        if (map == null) {
            return null;
        }
        String str = map.get(HttpHeaders.DATE);
        long jG = str != null ? g(str) : 0L;
        String str2 = map.get(HttpHeaders.CACHE_CONTROL);
        int i11 = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z11 = false;
            j11 = 0;
            j12 = 0;
            while (i11 < strArrSplit.length) {
                String strTrim = strArrSplit[i11].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j11 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j12 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z11 = true;
                }
                i11++;
            }
            i11 = 1;
        } else {
            z11 = false;
            j11 = 0;
            j12 = 0;
        }
        String str3 = map.get(HttpHeaders.EXPIRES);
        long jG2 = str3 != null ? g(str3) : 0L;
        String str4 = map.get(HttpHeaders.LAST_MODIFIED);
        long jG3 = str4 != null ? g(str4) : 0L;
        String str5 = map.get("ETag");
        if (i11 != 0) {
            j14 = jCurrentTimeMillis + (j11 * 1000);
            if (z11) {
                j15 = j14;
            } else {
                Long.signum(j12);
                j15 = (j12 * 1000) + j14;
            }
            j13 = j15;
        } else {
            j13 = 0;
            if (jG <= 0 || jG2 < jG) {
                j14 = 0;
            } else {
                j14 = jCurrentTimeMillis + (jG2 - jG);
                j13 = j14;
            }
        }
        com.android.volley.c.a aVar = new com.android.volley.c.a();
        aVar.f16490a = gVar.f16505b;
        aVar.f16491b = str5;
        aVar.f16495f = j14;
        aVar.f16494e = j13;
        aVar.f16492c = jG;
        aVar.f16493d = jG3;
        aVar.f16496g = map;
        aVar.f16497h = gVar.f16507d;
        return aVar;
    }

    public static String f(@Nullable Map<String, String> map, String str) {
        String str2;
        if (map != null && (str2 = map.get(HttpHeaders.CONTENT_TYPE)) != null) {
            String[] strArrSplit = str2.split(";", 0);
            for (int i11 = 1; i11 < strArrSplit.length; i11++) {
                String[] strArrSplit2 = strArrSplit[i11].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return str;
    }

    public static long g(String str) {
        try {
            return d("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e11) {
            if ("0".equals(str) || "-1".equals(str)) {
                com.android.volley.l.e("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            com.android.volley.l.d(e11, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    public static List<com.android.volley.e> h(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new com.android.volley.e(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    public static Map<String, String> i(List<com.android.volley.e> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (com.android.volley.e eVar : list) {
            treeMap.put(eVar.a(), eVar.b());
        }
        return treeMap;
    }
}
