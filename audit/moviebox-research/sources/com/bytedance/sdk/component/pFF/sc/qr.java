package com.bytedance.sdk.component.pFF.sc;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class qr {
    private static final char[] We = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String ExN;
    private final String Ol;
    private final List<String> Qj;
    private final String TRI;
    private final String WH;
    final String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final List<String> f26947qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    final String f26948sc;
    final int zY;

    /* JADX INFO: compiled from: source.java */
    public static final class sc {
        String Qj;
        final List<String> TRI;
        String We;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        List<String> f26949qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        String f26950sc;
        String pFF = "";
        String zY = "";
        int ExN = -1;

        /* JADX INFO: renamed from: com.bytedance.sdk.component.pFF.sc.qr$sc$sc, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public enum EnumC0261sc {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public sc() {
            ArrayList arrayList = new ArrayList();
            this.TRI = arrayList;
            arrayList.add("");
        }

        private static String ExN(String str, int i11, int i12) {
            return com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(qr.sc(str, i11, i12, false));
        }

        private boolean ExN(String str) {
            return str.equals(InstructionFileId.DOT) || str.equalsIgnoreCase("%2e");
        }

        private static int TRI(String str, int i11, int i12) {
            try {
                int i13 = Integer.parseInt(qr.sc(str, i11, i12, "", false, false, false, true, null));
                if (i13 <= 0 || i13 > 65535) {
                    return -1;
                }
                return i13;
            } catch (NumberFormatException unused) {
            }
        }

        private boolean TRI(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int We(String str, int i11, int i12) {
            while (i11 < i12) {
                char cCharAt = str.charAt(i11);
                if (cCharAt == ':') {
                    return i11;
                }
                if (cCharAt == '[') {
                    do {
                        i11++;
                        if (i11 >= i12) {
                            break;
                        }
                    } while (str.charAt(i11) != ']');
                }
                i11++;
            }
            return i12;
        }

        private static int pFF(String str, int i11, int i12) {
            if (i12 - i11 < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i11);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i11++;
                    if (i11 >= i12) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i11);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i11;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private sc sc(String str, boolean z11) {
            int i11 = 0;
            do {
                int iSc = com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(str, i11, str.length(), "/\\");
                sc(str, i11, iSc, iSc < str.length(), z11);
                i11 = iSc + 1;
            } while (i11 <= str.length());
            return this;
        }

        private void sc(String str, int i11, int i12) {
            if (i11 == i12) {
                return;
            }
            char cCharAt = str.charAt(i11);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.TRI.clear();
                this.TRI.add("");
                i11++;
            } else {
                List<String> list = this.TRI;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i13 = i11;
                if (i13 >= i12) {
                    return;
                }
                i11 = com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(str, i13, i12, "/\\");
                boolean z11 = i11 < i12;
                sc(str, i13, i11, z11, true);
                if (z11) {
                    i11++;
                }
            }
        }

        private void sc(String str, int i11, int i12, boolean z11, boolean z12) {
            String strSc = qr.sc(str, i11, i12, HttpUrl.PATH_SEGMENT_ENCODE_SET, z12, false, false, true, null);
            if (ExN(strSc)) {
                return;
            }
            if (TRI(strSc)) {
                zY();
                return;
            }
            List<String> list = this.TRI;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.TRI;
                list2.set(list2.size() - 1, strSc);
            } else {
                this.TRI.add(strSc);
            }
            if (z11) {
                this.TRI.add("");
            }
        }

        private static int zY(String str, int i11, int i12) {
            int i13 = 0;
            while (i11 < i12) {
                char cCharAt = str.charAt(i11);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i13++;
                i11++;
            }
            return i13;
        }

        private void zY() {
            List<String> list = this.TRI;
            if (!list.remove(list.size() - 1).isEmpty() || this.TRI.isEmpty()) {
                this.TRI.add("");
            } else {
                List<String> list2 = this.TRI;
                list2.set(list2.size() - 1, "");
            }
        }

        public sc We(String str) {
            this.f26949qr = str != null ? qr.pFF(qr.sc(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        public sc pFF(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strExN = ExN(str, 0, str.length());
            if (strExN == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(str));
            }
            this.We = strExN;
            return this;
        }

        public qr pFF() {
            if (this.f26950sc == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.We != null) {
                return new qr(this);
            }
            throw new IllegalStateException("host == null");
        }

        public int sc() {
            int i11 = this.ExN;
            return i11 != -1 ? i11 : qr.sc(this.f26950sc);
        }

        public EnumC0261sc sc(qr qrVar, String str) {
            int iSc;
            int i11;
            int iSc2 = com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(str, 0, str.length());
            int iPFF = com.bytedance.sdk.component.pFF.sc.pFF.Ol.pFF(str, iSc2, str.length());
            if (pFF(str, iSc2, iPFF) != -1) {
                if (str.regionMatches(true, iSc2, "https:", 0, 6)) {
                    this.f26950sc = "https";
                    iSc2 += 6;
                } else {
                    if (!str.regionMatches(true, iSc2, "http:", 0, 5)) {
                        return EnumC0261sc.UNSUPPORTED_SCHEME;
                    }
                    this.f26950sc = HttpHost.DEFAULT_SCHEME_NAME;
                    iSc2 += 5;
                }
            } else {
                if (qrVar == null) {
                    return EnumC0261sc.MISSING_SCHEME;
                }
                this.f26950sc = qrVar.f26948sc;
            }
            int iZY = zY(str, iSc2, iPFF);
            char c11 = '?';
            char c12 = '#';
            if (iZY >= 2 || qrVar == null || !qrVar.f26948sc.equals(this.f26950sc)) {
                int i12 = iSc2 + iZY;
                boolean z11 = false;
                boolean z12 = false;
                while (true) {
                    iSc = com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(str, i12, iPFF, "@/\\?#");
                    byte bCharAt = iSc != iPFF ? str.charAt(iSc) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c12 || bCharAt == 47 || bCharAt == 92 || bCharAt == c11) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z11) {
                            i11 = iSc;
                            this.zY += "%40" + qr.sc(str, i12, i11, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int iSc3 = com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(str, i12, iSc, ':');
                            i11 = iSc;
                            String strSc = qr.sc(str, i12, iSc3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z12) {
                                strSc = this.pFF + "%40" + strSc;
                            }
                            this.pFF = strSc;
                            if (iSc3 != i11) {
                                this.zY = qr.sc(str, iSc3 + 1, i11, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z11 = true;
                            }
                            z12 = true;
                        }
                        i12 = i11 + 1;
                        c11 = '?';
                        c12 = '#';
                    }
                }
                int iWe = We(str, i12, iSc);
                int i13 = iWe + 1;
                if (i13 < iSc) {
                    this.We = ExN(str, i12, iWe);
                    int iTRI = TRI(str, i13, iSc);
                    this.ExN = iTRI;
                    if (iTRI == -1) {
                        return EnumC0261sc.INVALID_PORT;
                    }
                } else {
                    this.We = ExN(str, i12, iWe);
                    this.ExN = qr.sc(this.f26950sc);
                }
                if (this.We == null) {
                    return EnumC0261sc.INVALID_HOST;
                }
                iSc2 = iSc;
            } else {
                this.pFF = qrVar.pFF();
                this.zY = qrVar.zY();
                this.We = qrVar.pFF;
                this.ExN = qrVar.zY;
                this.TRI.clear();
                this.TRI.addAll(qrVar.We());
                if (iSc2 == iPFF || str.charAt(iSc2) == '#') {
                    We(qrVar.ExN());
                }
            }
            int iSc4 = com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(str, iSc2, iPFF, "?#");
            sc(str, iSc2, iSc4);
            if (iSc4 < iPFF && str.charAt(iSc4) == '?') {
                int iSc5 = com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(str, iSc4, iPFF, '#');
                this.f26949qr = qr.pFF(qr.sc(str, iSc4 + 1, iSc5, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                iSc4 = iSc5;
            }
            if (iSc4 < iPFF && str.charAt(iSc4) == '#') {
                this.Qj = qr.sc(str, 1 + iSc4, iPFF, "", true, false, false, false, null);
            }
            return EnumC0261sc.SUCCESS;
        }

        public sc sc(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.f26950sc = HttpHost.DEFAULT_SCHEME_NAME;
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: ".concat(str));
                }
                this.f26950sc = "https";
            }
            return this;
        }

        public sc sc(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.f26949qr == null) {
                this.f26949qr = new ArrayList();
            }
            this.f26949qr.add(qr.sc(str, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
            this.f26949qr.add(str2 != null ? qr.sc(str2, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true) : null);
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f26950sc);
            sb2.append("://");
            if (!this.pFF.isEmpty() || !this.zY.isEmpty()) {
                sb2.append(this.pFF);
                if (!this.zY.isEmpty()) {
                    sb2.append(':');
                    sb2.append(this.zY);
                }
                sb2.append('@');
            }
            if (this.We.indexOf(58) != -1) {
                sb2.append('[');
                sb2.append(this.We);
                sb2.append(']');
            } else {
                sb2.append(this.We);
            }
            int iSc = sc();
            if (iSc != qr.sc(this.f26950sc)) {
                sb2.append(':');
                sb2.append(iSc);
            }
            qr.sc(sb2, this.TRI);
            if (this.f26949qr != null) {
                sb2.append('?');
                qr.pFF(sb2, this.f26949qr);
            }
            if (this.Qj != null) {
                sb2.append('#');
                sb2.append(this.Qj);
            }
            return sb2.toString();
        }

        public sc zY(String str) {
            if (str != null) {
                return sc(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }
    }

    public qr(sc scVar) {
        this.f26948sc = scVar.f26950sc;
        this.ExN = sc(scVar.pFF, false);
        this.TRI = sc(scVar.zY, false);
        this.pFF = scVar.We;
        this.zY = scVar.sc();
        this.f26947qr = sc(scVar.TRI, false);
        List<String> list = scVar.f26949qr;
        this.Qj = list != null ? sc(list, true) : null;
        String str = scVar.Qj;
        this.Ol = str != null ? sc(str, false) : null;
        this.WH = scVar.toString();
    }

    public static List<String> pFF(String str) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 <= str.length()) {
            int iIndexOf = str.indexOf(38, i11);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i11);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i11, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i11, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i11 = iIndexOf + 1;
        }
        return arrayList;
    }

    public static void pFF(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11 += 2) {
            String str = list.get(i11);
            String str2 = list.get(i11 + 1);
            if (i11 > 0) {
                sb2.append('&');
            }
            sb2.append(str);
            if (str2 != null) {
                sb2.append('=');
                sb2.append(str2);
            }
        }
    }

    public static int sc(String str) {
        if (str.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static String sc(String str, int i11, int i12, String str2, boolean z11, boolean z12, boolean z13, boolean z14, Charset charset) {
        int iCharCount = i11;
        while (iCharCount < i12) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z14)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z11 && (!z12 || sc(str, iCharCount, i12)))) && (iCodePointAt != 43 || !z13))) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
            }
            com.bytedance.sdk.component.pFF.sc.pFF.sc scVar = new com.bytedance.sdk.component.pFF.sc.pFF.sc();
            scVar.sc(str, i11, iCharCount);
            sc(scVar, str, iCharCount, i12, str2, z11, z12, z13, z14, charset);
            return scVar.zY();
        }
        return str.substring(i11, i12);
    }

    public static String sc(String str, int i11, int i12, boolean z11) {
        for (int i13 = i11; i13 < i12; i13++) {
            char cCharAt = str.charAt(i13);
            if (cCharAt == '%' || (cCharAt == '+' && z11)) {
                com.bytedance.sdk.component.pFF.sc.pFF.sc scVar = new com.bytedance.sdk.component.pFF.sc.pFF.sc();
                scVar.sc(str, i11, i13);
                sc(scVar, str, i13, i12, z11);
                return scVar.zY();
            }
        }
        return str.substring(i11, i12);
    }

    public static String sc(String str, String str2, boolean z11, boolean z12, boolean z13, boolean z14) {
        return sc(str, 0, str.length(), str2, z11, z12, z13, z14, null);
    }

    public static String sc(String str, boolean z11) {
        return sc(str, 0, str.length(), z11);
    }

    private List<String> sc(List<String> list, boolean z11) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            String str = list.get(i11);
            arrayList.add(str != null ? sc(str, z11) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static void sc(com.bytedance.sdk.component.pFF.sc.pFF.sc scVar, String str, int i11, int i12, String str2, boolean z11, boolean z12, boolean z13, boolean z14, Charset charset) {
        com.bytedance.sdk.component.pFF.sc.pFF.sc scVar2 = null;
        while (i11 < i12) {
            int iCodePointAt = str.codePointAt(i11);
            if (!z11 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z13) {
                    scVar.sc(z11 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z14) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z11 || (z12 && !sc(str, i11, i12)))))) {
                    if (scVar2 == null) {
                        scVar2 = new com.bytedance.sdk.component.pFF.sc.pFF.sc();
                    }
                    if (charset == null || charset.equals(com.bytedance.sdk.component.pFF.sc.pFF.Ol.f26942sc)) {
                        scVar2.sc(iCodePointAt);
                    } else {
                        scVar2.sc(str, i11, Character.charCount(iCodePointAt) + i11, charset);
                    }
                    while (!scVar2.sc()) {
                        byte bPFF = scVar2.pFF();
                        scVar.pFF(37);
                        char[] cArr = We;
                        scVar.pFF((int) cArr[((bPFF & 255) >> 4) & 15]);
                        scVar.pFF((int) cArr[bPFF & Ascii.SI]);
                    }
                } else {
                    scVar.sc(iCodePointAt);
                }
            }
            i11 += Character.charCount(iCodePointAt);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    public static void sc(com.bytedance.sdk.component.pFF.sc.pFF.sc scVar, String str, int i11, int i12, boolean z11) {
        int i13;
        while (i11 < i12) {
            int iCodePointAt = str.codePointAt(i11);
            if (iCodePointAt == 37 && (i13 = i11 + 2) < i12) {
                int iSc = com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(str.charAt(i11 + 1));
                int iSc2 = com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(str.charAt(i13));
                if (iSc == -1 || iSc2 == -1) {
                    scVar.sc(iCodePointAt);
                } else {
                    scVar.pFF((iSc << 4) + iSc2);
                    i11 = i13;
                }
            } else if (iCodePointAt == 43 && z11) {
                scVar.pFF(32);
            } else {
                scVar.sc(iCodePointAt);
            }
            i11 += Character.charCount(iCodePointAt);
        }
    }

    public static void sc(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            sb2.append('/');
            sb2.append(list.get(i11));
        }
    }

    public static boolean sc(String str, int i11, int i12) {
        int i13 = i11 + 2;
        return i13 < i12 && str.charAt(i11) == '%' && com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(str.charAt(i11 + 1)) != -1 && com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(str.charAt(i13)) != -1;
    }

    public static qr zY(String str) {
        sc scVar = new sc();
        if (scVar.sc((qr) null, str) == sc.EnumC0261sc.SUCCESS) {
            return scVar.pFF();
        }
        return null;
    }

    public String ExN() {
        if (this.Qj == null) {
            return null;
        }
        int iIndexOf = this.WH.indexOf(63) + 1;
        String str = this.WH;
        return this.WH.substring(iIndexOf, com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(str, iIndexOf, str.length(), '#'));
    }

    public List<String> We() {
        int iIndexOf = this.WH.indexOf(47, this.f26948sc.length() + 3);
        String str = this.WH;
        int iSc = com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iSc) {
            int i11 = iIndexOf + 1;
            int iSc2 = com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(this.WH, i11, iSc, '/');
            arrayList.add(this.WH.substring(i11, iSc2));
            iIndexOf = iSc2;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof qr) && ((qr) obj).WH.equals(this.WH);
    }

    public int hashCode() {
        return this.WH.hashCode();
    }

    public String pFF() {
        if (this.ExN.isEmpty()) {
            return "";
        }
        int length = this.f26948sc.length() + 3;
        String str = this.WH;
        return this.WH.substring(length, com.bytedance.sdk.component.pFF.sc.pFF.Ol.sc(str, length, str.length(), ":@"));
    }

    public URL sc() {
        try {
            return new URL(this.WH);
        } catch (MalformedURLException e11) {
            throw new RuntimeException(e11);
        }
    }

    public String toString() {
        return this.WH;
    }

    public String zY() {
        if (this.TRI.isEmpty()) {
            return "";
        }
        return this.WH.substring(this.WH.indexOf(58, this.f26948sc.length() + 3) + 1, this.WH.indexOf(64));
    }
}
