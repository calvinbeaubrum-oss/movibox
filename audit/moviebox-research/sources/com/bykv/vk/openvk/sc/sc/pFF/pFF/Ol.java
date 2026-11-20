package com.bykv.vk.openvk.sc.sc.pFF.pFF;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f25904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f25905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f25906c;

    /* JADX INFO: compiled from: source.java */
    public static final class We extends Exception {
        public We(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f25907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f25908b;

        public a(String str, String str2) {
            this.f25907a = str;
            this.f25908b = str2;
        }

        public static a a(String str) throws We {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                throw new We("request header format error, header: ".concat(str));
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1).trim();
            if (strTrim.length() == 0 || strTrim2.length() == 0) {
                throw new We("request header format error, header: ".concat(str));
            }
            return new a(strTrim, strTrim2);
        }

        public String toString() {
            return "Header{name='" + this.f25907a + "', value='" + this.f25908b + "'}";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f25909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f25910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f25911c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f25912d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f25913e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f25914f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<String> f25915g;

        public b(int i11, String str, String str2, int i12, int i13, String str3, List<String> list) {
            this.f25909a = i11;
            this.f25910b = str;
            this.f25911c = str2;
            this.f25912d = i12;
            this.f25913e = i13;
            this.f25914f = str3;
            this.f25915g = list;
        }

        public static b a(c cVar, List<a> list) throws We {
            String str;
            int i11;
            int i12;
            int iIndexOf = cVar.f25917b.indexOf("?");
            if (iIndexOf == -1) {
                throw new We("path format error, path: " + cVar.f25917b);
            }
            ArrayList arrayList = new ArrayList();
            String str2 = null;
            String strDecode = null;
            String strDecode2 = null;
            int i13 = 0;
            for (String str3 : cVar.f25917b.substring(iIndexOf + 1).split("&")) {
                String[] strArrSplit = str3.split("=");
                if (strArrSplit.length == 2) {
                    if ("rk".equals(strArrSplit[0])) {
                        strDecode = Uri.decode(strArrSplit[1]);
                    } else if (CampaignEx.JSON_KEY_AD_K.equals(strArrSplit[0])) {
                        strDecode2 = Uri.decode(strArrSplit[1]);
                    } else if (strArrSplit[0].startsWith("u")) {
                        arrayList.add(Uri.decode(strArrSplit[1]));
                    } else if ("f".equals(strArrSplit[0]) && p8.a.a(strArrSplit[1]) == 1) {
                        i13 = 1;
                    }
                }
            }
            if (TextUtils.isEmpty(strDecode) || TextUtils.isEmpty(strDecode2)) {
                throw new We("rawKey or key is empty, path: " + cVar.f25917b);
            }
            if (list != null) {
                i12 = 0;
                int i14 = 0;
                for (a aVar : list) {
                    if (aVar != null && "Range".equalsIgnoreCase(aVar.f25907a)) {
                        int iIndexOf2 = aVar.f25908b.indexOf("=");
                        if (iIndexOf2 == -1) {
                            throw new We("Range format error, Range: " + aVar.f25908b);
                        }
                        if (!"bytes".equalsIgnoreCase(aVar.f25908b.substring(0, iIndexOf2).trim())) {
                            throw new We("Range format error, Range: " + aVar.f25908b);
                        }
                        String strSubstring = aVar.f25908b.substring(iIndexOf2 + 1);
                        if (strSubstring.contains(",")) {
                            throw new We("Range format error, Range: " + aVar.f25908b);
                        }
                        int iIndexOf3 = strSubstring.indexOf("-");
                        if (iIndexOf3 == -1) {
                            throw new We("Range format error, Range: " + aVar.f25908b);
                        }
                        String strTrim = strSubstring.substring(0, iIndexOf3).trim();
                        String strTrim2 = strSubstring.substring(iIndexOf3 + 1).trim();
                        try {
                            if (strTrim.length() > 0) {
                                i12 = Integer.parseInt(strTrim);
                            }
                            if (strTrim2.length() > 0 && i12 > (i14 = Integer.parseInt(strTrim2))) {
                                throw new We("Range format error, Range: " + aVar.f25908b);
                            }
                            str2 = aVar.f25908b;
                        } catch (NumberFormatException unused) {
                            throw new We("Range format error, Range: " + aVar.f25908b);
                        }
                    }
                }
                i11 = i14;
                str = str2;
            } else {
                str = null;
                i11 = 0;
                i12 = 0;
            }
            if (!arrayList.isEmpty()) {
                return new b(i13, strDecode, strDecode2, i12, i11, str, arrayList);
            }
            throw new We("no url found: path: " + cVar.f25917b);
        }

        public String toString() {
            return "Extra{flag=" + this.f25909a + ", rawKey='" + this.f25910b + "', key='" + this.f25911c + "', from=" + this.f25912d + ", to=" + this.f25913e + ", urls=" + this.f25915g + '}';
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f25916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f25917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f25918c;

        public c(String str, String str2, String str3) {
            this.f25916a = str;
            this.f25917b = str2;
            this.f25918c = str3;
        }

        public static c a(String str) throws We {
            int iIndexOf = str.indexOf(32);
            if (iIndexOf == -1) {
                throw new We("request line format error, line: ".concat(str));
            }
            int iLastIndexOf = str.lastIndexOf(32);
            if (iLastIndexOf <= iIndexOf) {
                throw new We("request line format error, line: ".concat(str));
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1, iLastIndexOf).trim();
            String strTrim3 = str.substring(iLastIndexOf + 1).trim();
            if (strTrim.length() == 0 || strTrim2.length() == 0 || strTrim3.length() == 0) {
                throw new We("request line format error, line: ".concat(str));
            }
            return new c(strTrim, strTrim2, strTrim3);
        }

        public String toString() {
            return "RequestLine{method='" + this.f25916a + "', path='" + this.f25917b + "', version='" + this.f25918c + "'}";
        }
    }

    public Ol(c cVar, List<a> list, b bVar) {
        this.f25904a = cVar;
        this.f25905b = list;
        this.f25906c = bVar;
    }

    public static Ol a(InputStream inputStream) throws IOException, We {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, p8.a.f73721b));
        ArrayList arrayList = new ArrayList();
        c cVarA = null;
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                break;
            }
            String strTrim = line.trim();
            if (cVarA == null) {
                cVarA = c.a(strTrim);
            } else {
                arrayList.add(a.a(strTrim));
            }
        }
        if (cVarA != null) {
            return new Ol(cVarA, arrayList, b.a(cVarA, arrayList));
        }
        throw new We("request line is null");
    }

    public static String b(String str, String str2, List<String> list) {
        StringBuilder sb2 = new StringBuilder(512);
        String strC = null;
        do {
            if (strC != null) {
                if (list.size() == 1) {
                    return null;
                }
                list.remove(list.size() - 1);
            }
            strC = c(sb2, str, str2, list);
        } while (strC.length() > 3072);
        return strC;
    }

    public static String c(StringBuilder sb2, String str, String str2, List<String> list) {
        sb2.delete(0, sb2.length());
        sb2.append("rk=");
        sb2.append(Uri.encode(str));
        sb2.append("&k=");
        sb2.append(Uri.encode(str2));
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            sb2.append("&u");
            sb2.append(i11);
            sb2.append("=");
            sb2.append(Uri.encode(list.get(i11)));
        }
        return sb2.toString();
    }

    public String toString() {
        return "Request{requestLine=" + this.f25904a + ", headers=" + this.f25905b + ", extra=" + this.f25906c + '}';
    }
}
