package ei;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f64215c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f64216d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f64217a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f64218b = new StringBuilder();

    public static boolean b(c0 c0Var) {
        int iE = c0Var.e();
        int iF = c0Var.f();
        byte[] bArrD = c0Var.d();
        if (iE + 2 > iF) {
            return false;
        }
        int i11 = iE + 1;
        if (bArrD[iE] != 47) {
            return false;
        }
        int i12 = iE + 2;
        if (bArrD[i11] != 42) {
            return false;
        }
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= iF) {
                c0Var.Q(iF - c0Var.e());
                return true;
            }
            if (((char) bArrD[i12]) == '*' && ((char) bArrD[i13]) == '/') {
                i12 += 2;
                iF = i12;
            } else {
                i12 = i13;
            }
        }
    }

    public static boolean c(c0 c0Var) {
        char cK = k(c0Var, c0Var.e());
        if (cK != '\t' && cK != '\n' && cK != '\f' && cK != '\r' && cK != ' ') {
            return false;
        }
        c0Var.Q(1);
        return true;
    }

    public static void e(String str, d dVar) {
        Matcher matcher = f64216d.matcher(com.google.common.base.a.e(str));
        if (!matcher.matches()) {
            s.i("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(2));
        str2.hashCode();
        switch (str2) {
            case "%":
                dVar.t(3);
                break;
            case "em":
                dVar.t(2);
                break;
            case "px":
                dVar.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        dVar.s(Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))));
    }

    public static String f(c0 c0Var, StringBuilder sb2) {
        boolean z11 = false;
        sb2.setLength(0);
        int iE = c0Var.e();
        int iF = c0Var.f();
        while (iE < iF && !z11) {
            char c11 = (char) c0Var.d()[iE];
            if ((c11 < 'A' || c11 > 'Z') && ((c11 < 'a' || c11 > 'z') && !((c11 >= '0' && c11 <= '9') || c11 == '#' || c11 == '-' || c11 == '.' || c11 == '_'))) {
                z11 = true;
            } else {
                iE++;
                sb2.append(c11);
            }
        }
        c0Var.Q(iE - c0Var.e());
        return sb2.toString();
    }

    @Nullable
    public static String g(c0 c0Var, StringBuilder sb2) {
        n(c0Var);
        if (c0Var.a() == 0) {
            return null;
        }
        String strF = f(c0Var, sb2);
        if (!"".equals(strF)) {
            return strF;
        }
        return "" + ((char) c0Var.D());
    }

    @Nullable
    public static String h(c0 c0Var, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder();
        boolean z11 = false;
        while (!z11) {
            int iE = c0Var.e();
            String strG = g(c0Var, sb2);
            if (strG == null) {
                return null;
            }
            if ("}".equals(strG) || ";".equals(strG)) {
                c0Var.P(iE);
                z11 = true;
            } else {
                sb3.append(strG);
            }
        }
        return sb3.toString();
    }

    @Nullable
    public static String i(c0 c0Var, StringBuilder sb2) {
        n(c0Var);
        if (c0Var.a() < 5 || !"::cue".equals(c0Var.A(5))) {
            return null;
        }
        int iE = c0Var.e();
        String strG = g(c0Var, sb2);
        if (strG == null) {
            return null;
        }
        if ("{".equals(strG)) {
            c0Var.P(iE);
            return "";
        }
        String strL = "(".equals(strG) ? l(c0Var) : null;
        if (")".equals(g(c0Var, sb2))) {
            return strL;
        }
        return null;
    }

    public static void j(c0 c0Var, d dVar, StringBuilder sb2) {
        n(c0Var);
        String strF = f(c0Var, sb2);
        if (!"".equals(strF) && ":".equals(g(c0Var, sb2))) {
            n(c0Var);
            String strH = h(c0Var, sb2);
            if (strH == null || "".equals(strH)) {
                return;
            }
            int iE = c0Var.e();
            String strG = g(c0Var, sb2);
            if (!";".equals(strG)) {
                if (!"}".equals(strG)) {
                    return;
                } else {
                    c0Var.P(iE);
                }
            }
            if (TtmlNode.ATTR_TTS_COLOR.equals(strF)) {
                dVar.q(com.google.android.exoplayer2.util.g.b(strH));
                return;
            }
            if ("background-color".equals(strF)) {
                dVar.n(com.google.android.exoplayer2.util.g.b(strH));
                return;
            }
            boolean z11 = true;
            if ("ruby-position".equals(strF)) {
                if ("over".equals(strH)) {
                    dVar.v(1);
                    return;
                } else {
                    if ("under".equals(strH)) {
                        dVar.v(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(strF)) {
                if (!"all".equals(strH) && !strH.startsWith("digits")) {
                    z11 = false;
                }
                dVar.p(z11);
                return;
            }
            if ("text-decoration".equals(strF)) {
                if (TtmlNode.UNDERLINE.equals(strH)) {
                    dVar.A(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(strF)) {
                dVar.r(strH);
                return;
            }
            if ("font-weight".equals(strF)) {
                if (TtmlNode.BOLD.equals(strH)) {
                    dVar.o(true);
                }
            } else if ("font-style".equals(strF)) {
                if (TtmlNode.ITALIC.equals(strH)) {
                    dVar.u(true);
                }
            } else if ("font-size".equals(strF)) {
                e(strH, dVar);
            }
        }
    }

    public static char k(c0 c0Var, int i11) {
        return (char) c0Var.d()[i11];
    }

    public static String l(c0 c0Var) {
        int iE = c0Var.e();
        int iF = c0Var.f();
        boolean z11 = false;
        while (iE < iF && !z11) {
            int i11 = iE + 1;
            z11 = ((char) c0Var.d()[iE]) == ')';
            iE = i11;
        }
        return c0Var.A((iE - 1) - c0Var.e()).trim();
    }

    public static void m(c0 c0Var) {
        while (!TextUtils.isEmpty(c0Var.p())) {
        }
    }

    public static void n(c0 c0Var) {
        while (true) {
            for (boolean z11 = true; c0Var.a() > 0 && z11; z11 = false) {
                if (!c(c0Var) && !b(c0Var)) {
                }
            }
            return;
        }
    }

    public final void a(d dVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = f64215c.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                dVar.z((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrT0 = o0.T0(str, "\\.");
        String str2 = strArrT0[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            dVar.y(str2.substring(0, iIndexOf2));
            dVar.x(str2.substring(iIndexOf2 + 1));
        } else {
            dVar.y(str2);
        }
        if (strArrT0.length > 1) {
            dVar.w((String[]) o0.I0(strArrT0, 1, strArrT0.length));
        }
    }

    public List<d> d(c0 c0Var) {
        this.f64218b.setLength(0);
        int iE = c0Var.e();
        m(c0Var);
        this.f64217a.N(c0Var.d(), c0Var.e());
        this.f64217a.P(iE);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strI = i(this.f64217a, this.f64218b);
            if (strI == null || !"{".equals(g(this.f64217a, this.f64218b))) {
                return arrayList;
            }
            d dVar = new d();
            a(dVar, strI);
            String str = null;
            boolean z11 = false;
            while (!z11) {
                int iE2 = this.f64217a.e();
                String strG = g(this.f64217a, this.f64218b);
                boolean z12 = strG == null || "}".equals(strG);
                if (!z12) {
                    this.f64217a.P(iE2);
                    j(this.f64217a, dVar, this.f64218b);
                }
                str = strG;
                z11 = z12;
            }
            if ("}".equals(str)) {
                arrayList.add(dVar);
            }
        }
    }
}
