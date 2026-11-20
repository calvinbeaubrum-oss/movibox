package com.applovin.impl;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f24871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f24872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f24873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f24874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f24875g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f24876h;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f24878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f24879c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f24880d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f24881e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f24882f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f24883g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f24884h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f24885i;

        private a(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
            this.f24877a = i11;
            this.f24878b = i12;
            this.f24879c = i13;
            this.f24880d = i14;
            this.f24881e = i15;
            this.f24882f = i16;
            this.f24883g = i17;
            this.f24884h = i18;
            this.f24885i = i19;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:7:0x002d  */
        public static a a(String str) {
            String[] strArrSplit = TextUtils.split(str.substring(7), ",");
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            int i17 = -1;
            int i18 = -1;
            for (int i19 = 0; i19 < strArrSplit.length; i19++) {
                String lowerCase = Ascii.toLowerCase(strArrSplit[i19].trim());
                lowerCase.hashCode();
                switch (lowerCase) {
                    case "italic":
                        i16 = i19;
                        break;
                    case "underline":
                        i17 = i19;
                        break;
                    case "strikeout":
                        i18 = i19;
                        break;
                    case "primarycolour":
                        i13 = i19;
                        break;
                    case "bold":
                        i15 = i19;
                        break;
                    case "name":
                        i11 = i19;
                        break;
                    case "fontsize":
                        i14 = i19;
                        break;
                    case "alignment":
                        i12 = i19;
                        break;
                }
            }
            if (i11 != -1) {
                return new a(i11, i12, i13, i14, i15, i16, i17, i18, strArrSplit.length);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Pattern f24886c = Pattern.compile("\\{([^}]*)\\}");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Pattern f24887d = Pattern.compile(xp.a("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Pattern f24888e = Pattern.compile(xp.a("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Pattern f24889f = Pattern.compile("\\\\an(\\d+)");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PointF f24891b;

        private b(int i11, PointF pointF) {
            this.f24890a = i11;
            this.f24891b = pointF;
        }

        private static int a(String str) {
            Matcher matcher = f24889f.matcher(str);
            if (matcher.find()) {
                return zk.b((String) b1.a((Object) matcher.group(1)));
            }
            return -1;
        }

        public static b b(String str) {
            Matcher matcher = f24886c.matcher(str);
            PointF pointF = null;
            int i11 = -1;
            while (matcher.find()) {
                String str2 = (String) b1.a((Object) matcher.group(1));
                try {
                    PointF pointFC = c(str2);
                    if (pointFC != null) {
                        pointF = pointFC;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int iA = a(str2);
                    if (iA != -1) {
                        i11 = iA;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new b(i11, pointF);
        }

        private static PointF c(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = f24887d.matcher(str);
            Matcher matcher2 = f24888e.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    pc.c("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                strGroup = matcher.group(1);
                strGroup2 = matcher.group(2);
            } else {
                if (!zFind2) {
                    return null;
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) b1.a((Object) strGroup)).trim()), Float.parseFloat(((String) b1.a((Object) strGroup2)).trim()));
        }

        public static String d(String str) {
            return f24886c.matcher(str).replaceAll("");
        }
    }

    private zk(String str, int i11, Integer num, float f11, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.f24869a = str;
        this.f24870b = i11;
        this.f24871c = num;
        this.f24872d = f11;
        this.f24873e = z11;
        this.f24874f = z12;
        this.f24875g = z13;
        this.f24876h = z14;
    }

    public static zk a(String str, a aVar) {
        b1.a(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i11 = aVar.f24885i;
        if (length != i11) {
            pc.d("SsaStyle", xp.a("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i11), Integer.valueOf(strArrSplit.length), str));
            return null;
        }
        try {
            String strTrim = strArrSplit[aVar.f24877a].trim();
            int i12 = aVar.f24878b;
            int iB = i12 != -1 ? b(strArrSplit[i12].trim()) : -1;
            int i13 = aVar.f24879c;
            Integer numD = i13 != -1 ? d(strArrSplit[i13].trim()) : null;
            int i14 = aVar.f24880d;
            float fE = i14 != -1 ? e(strArrSplit[i14].trim()) : -3.4028235E38f;
            int i15 = aVar.f24881e;
            boolean z11 = i15 != -1 && c(strArrSplit[i15].trim());
            int i16 = aVar.f24882f;
            boolean z12 = i16 != -1 && c(strArrSplit[i16].trim());
            int i17 = aVar.f24883g;
            boolean z13 = i17 != -1 && c(strArrSplit[i17].trim());
            int i18 = aVar.f24884h;
            return new zk(strTrim, iB, numD, fE, z11, z12, z13, i18 != -1 && c(strArrSplit[i18].trim()));
        } catch (RuntimeException e11) {
            pc.c("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e11);
            return null;
        }
    }

    private static boolean a(int i11) {
        switch (i11) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(String str) {
        try {
            int i11 = Integer.parseInt(str.trim());
            if (a(i11)) {
                return i11;
            }
        } catch (NumberFormatException unused) {
        }
        pc.d("SsaStyle", "Ignoring unknown alignment: " + str);
        return -1;
    }

    private static boolean c(String str) {
        try {
            int i11 = Integer.parseInt(str);
            return i11 == 1 || i11 == -1;
        } catch (NumberFormatException e11) {
            pc.c("SsaStyle", "Failed to parse boolean value: '" + str + "'", e11);
            return false;
        }
    }

    public static Integer d(String str) {
        try {
            long j11 = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            b1.a(j11 <= 4294967295L);
            return Integer.valueOf(Color.argb(ub.a(((j11 >> 24) & 255) ^ 255), ub.a(j11 & 255), ub.a((j11 >> 8) & 255), ub.a((j11 >> 16) & 255)));
        } catch (IllegalArgumentException e11) {
            pc.c("SsaStyle", "Failed to parse color expression: '" + str + "'", e11);
            return null;
        }
    }

    private static float e(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e11) {
            pc.c("SsaStyle", "Failed to parse font size: '" + str + "'", e11);
            return -3.4028235E38f;
        }
    }
}
