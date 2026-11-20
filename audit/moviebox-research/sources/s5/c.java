package s5;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.common.primitives.Ints;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f76122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f76123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Integer f76124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final Integer f76125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f76126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f76127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f76128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f76129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f76130i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f76131j;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f76132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f76133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f76134c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f76135d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f76136e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f76137f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f76138g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f76139h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f76140i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f76141j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f76142k;

        public a(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22) {
            this.f76132a = i11;
            this.f76133b = i12;
            this.f76134c = i13;
            this.f76135d = i14;
            this.f76136e = i15;
            this.f76137f = i16;
            this.f76138g = i17;
            this.f76139h = i18;
            this.f76140i = i19;
            this.f76141j = i21;
            this.f76142k = i22;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:7:0x0031  */
        @Nullable
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
            int i19 = -1;
            int i21 = -1;
            for (int i22 = 0; i22 < strArrSplit.length; i22++) {
                String strE = com.google.common.base.a.e(strArrSplit[i22].trim());
                strE.hashCode();
                switch (strE) {
                    case "italic":
                        i17 = i22;
                        break;
                    case "underline":
                        i18 = i22;
                        break;
                    case "strikeout":
                        i19 = i22;
                        break;
                    case "primarycolour":
                        i13 = i22;
                        break;
                    case "bold":
                        i16 = i22;
                        break;
                    case "name":
                        i11 = i22;
                        break;
                    case "fontsize":
                        i15 = i22;
                        break;
                    case "borderstyle":
                        i21 = i22;
                        break;
                    case "alignment":
                        i12 = i22;
                        break;
                    case "outlinecolour":
                        i14 = i22;
                        break;
                }
            }
            if (i11 != -1) {
                return new a(i11, i12, i13, i14, i15, i16, i17, i18, i19, i21, strArrSplit.length);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Pattern f76143c = Pattern.compile("\\{([^}]*)\\}");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Pattern f76144d = Pattern.compile(u0.G("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Pattern f76145e = Pattern.compile(u0.G("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Pattern f76146f = Pattern.compile("\\\\an(\\d+)");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f76147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final PointF f76148b;

        public b(int i11, @Nullable PointF pointF) {
            this.f76147a = i11;
            this.f76148b = pointF;
        }

        public static int a(String str) {
            Matcher matcher = f76146f.matcher(str);
            if (matcher.find()) {
                return c.e((String) z3.a.e(matcher.group(1)));
            }
            return -1;
        }

        public static b b(String str) {
            Matcher matcher = f76143c.matcher(str);
            PointF pointF = null;
            int i11 = -1;
            while (matcher.find()) {
                String str2 = (String) z3.a.e(matcher.group(1));
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

        @Nullable
        public static PointF c(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = f76144d.matcher(str);
            Matcher matcher2 = f76145e.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    o.f("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
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
            return new PointF(Float.parseFloat(((String) z3.a.e(strGroup)).trim()), Float.parseFloat(((String) z3.a.e(strGroup2)).trim()));
        }

        public static String d(String str) {
            return f76143c.matcher(str).replaceAll("");
        }
    }

    public c(String str, int i11, @Nullable Integer num, @Nullable Integer num2, float f11, boolean z11, boolean z12, boolean z13, boolean z14, int i12) {
        this.f76122a = str;
        this.f76123b = i11;
        this.f76124c = num;
        this.f76125d = num2;
        this.f76126e = f11;
        this.f76127f = z11;
        this.f76128g = z12;
        this.f76129h = z13;
        this.f76130i = z14;
        this.f76131j = i12;
    }

    @Nullable
    public static c b(String str, a aVar) {
        z3.a.a(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i11 = aVar.f76142k;
        if (length != i11) {
            o.h("SsaStyle", u0.G("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i11), Integer.valueOf(strArrSplit.length), str));
            return null;
        }
        try {
            String strTrim = strArrSplit[aVar.f76132a].trim();
            int i12 = aVar.f76133b;
            int iE = i12 != -1 ? e(strArrSplit[i12].trim()) : -1;
            int i13 = aVar.f76134c;
            Integer numH = i13 != -1 ? h(strArrSplit[i13].trim()) : null;
            int i14 = aVar.f76135d;
            Integer numH2 = i14 != -1 ? h(strArrSplit[i14].trim()) : null;
            int i15 = aVar.f76136e;
            float fI = i15 != -1 ? i(strArrSplit[i15].trim()) : -3.4028235E38f;
            int i16 = aVar.f76137f;
            boolean z11 = i16 != -1 && f(strArrSplit[i16].trim());
            int i17 = aVar.f76138g;
            boolean z12 = i17 != -1 && f(strArrSplit[i17].trim());
            int i18 = aVar.f76139h;
            boolean z13 = i18 != -1 && f(strArrSplit[i18].trim());
            int i19 = aVar.f76140i;
            boolean z14 = i19 != -1 && f(strArrSplit[i19].trim());
            int i21 = aVar.f76141j;
            return new c(strTrim, iE, numH, numH2, fI, z11, z12, z13, z14, i21 != -1 ? g(strArrSplit[i21].trim()) : -1);
        } catch (RuntimeException e11) {
            o.i("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e11);
            return null;
        }
    }

    public static boolean c(int i11) {
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

    public static boolean d(int i11) {
        return i11 == 1 || i11 == 3;
    }

    public static int e(String str) {
        try {
            int i11 = Integer.parseInt(str.trim());
            if (c(i11)) {
                return i11;
            }
        } catch (NumberFormatException unused) {
        }
        o.h("SsaStyle", "Ignoring unknown alignment: " + str);
        return -1;
    }

    public static boolean f(String str) {
        try {
            int i11 = Integer.parseInt(str);
            return i11 == 1 || i11 == -1;
        } catch (NumberFormatException e11) {
            o.i("SsaStyle", "Failed to parse boolean value: '" + str + "'", e11);
            return false;
        }
    }

    public static int g(String str) {
        try {
            int i11 = Integer.parseInt(str.trim());
            if (d(i11)) {
                return i11;
            }
        } catch (NumberFormatException unused) {
        }
        o.h("SsaStyle", "Ignoring unknown BorderStyle: " + str);
        return -1;
    }

    @Nullable
    public static Integer h(String str) {
        try {
            long j11 = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            z3.a.a(j11 <= 4294967295L);
            return Integer.valueOf(Color.argb(Ints.d(((j11 >> 24) & 255) ^ 255), Ints.d(j11 & 255), Ints.d((j11 >> 8) & 255), Ints.d((j11 >> 16) & 255)));
        } catch (IllegalArgumentException e11) {
            o.i("SsaStyle", "Failed to parse color expression: '" + str + "'", e11);
            return null;
        }
    }

    public static float i(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e11) {
            o.i("SsaStyle", "Failed to parse font size: '" + str + "'", e11);
            return -3.4028235E38f;
        }
    }
}
