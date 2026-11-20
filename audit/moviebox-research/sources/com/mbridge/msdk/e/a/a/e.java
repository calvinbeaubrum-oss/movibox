package com.mbridge.msdk.e.a.a;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.e.a.aa;
import com.mbridge.msdk.e.a.m;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e {
    private static long a(String str) {
        try {
            Date date = b("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str);
            if (date != null) {
                return date.getTime();
            }
            return 0L;
        } catch (ParseException e11) {
            if ("0".equals(str) || "-1".equals(str)) {
                aa.a("Unable to parse dateStr: %s, falling back to 0", str);
            } else {
                aa.a(e11, "Unable to parse dateStr: %s, falling back to 0", str);
            }
            return 0L;
        }
    }

    public static com.mbridge.msdk.e.a.b.a a(m mVar) {
        boolean z11;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = mVar.f43804c;
        if (map == null) {
            return null;
        }
        String str = map.get(HttpHeaders.DATE);
        long jA = str != null ? a(str) : 0L;
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
        long jA2 = str3 != null ? a(str3) : 0L;
        String str4 = map.get(HttpHeaders.LAST_MODIFIED);
        long jA3 = str4 != null ? a(str4) : 0L;
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
            if (jA <= 0 || jA2 < jA) {
                j14 = 0;
            } else {
                j14 = jCurrentTimeMillis + (jA2 - jA);
                j13 = j14;
            }
        }
        com.mbridge.msdk.e.a.b.a aVar = new com.mbridge.msdk.e.a.b.a();
        aVar.f43769a = mVar.f43803b;
        aVar.f43770b = str5;
        aVar.f43774f = j14;
        aVar.f43773e = j13;
        aVar.f43771c = jA;
        aVar.f43772d = jA3;
        aVar.f43775g = map;
        aVar.f43776h = mVar.f43805d;
        return aVar;
    }

    public static String a(long j11) {
        return b("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j11));
    }

    public static String a(Map<String, String> map) {
        String str;
        if (map != null && (str = map.get(HttpHeaders.CONTENT_TYPE)) != null) {
            String[] strArrSplit = str.split(";", 0);
            for (int i11 = 1; i11 < strArrSplit.length; i11++) {
                String[] strArrSplit2 = strArrSplit[i11].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return "ISO-8859-1";
    }

    public static List<com.mbridge.msdk.e.a.i> a(List<com.mbridge.msdk.e.a.i> list, com.mbridge.msdk.e.a.b.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<com.mbridge.msdk.e.a.i> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<com.mbridge.msdk.e.a.i> list2 = aVar.f43776h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (com.mbridge.msdk.e.a.i iVar : aVar.f43776h) {
                    if (!treeSet.contains(iVar.a())) {
                        arrayList.add(iVar);
                    }
                }
            }
        } else if (!aVar.f43775g.isEmpty()) {
            for (Map.Entry<String, String> entry : aVar.f43775g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new com.mbridge.msdk.e.a.i(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    private static SimpleDateFormat b(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
