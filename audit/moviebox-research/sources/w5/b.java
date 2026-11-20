package w5;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import z3.c0;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f79289c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f79290d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f79291a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f79292b = new StringBuilder();

    public static boolean b(c0 c0Var) {
        int iF = c0Var.f();
        int iG = c0Var.g();
        byte[] bArrE = c0Var.e();
        if (iF + 2 > iG) {
            return false;
        }
        int i11 = iF + 1;
        if (bArrE[iF] != 47) {
            return false;
        }
        int i12 = iF + 2;
        if (bArrE[i11] != 42) {
            return false;
        }
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= iG) {
                c0Var.V(iG - c0Var.f());
                return true;
            }
            if (((char) bArrE[i12]) == '*' && ((char) bArrE[i13]) == '/') {
                i12 += 2;
                iG = i12;
            } else {
                i12 = i13;
            }
        }
    }

    public static boolean c(c0 c0Var) {
        char cK = k(c0Var, c0Var.f());
        if (cK != '\t' && cK != '\n' && cK != '\f' && cK != '\r' && cK != ' ') {
            return false;
        }
        c0Var.V(1);
        return true;
    }

    public static void e(String str, c cVar) {
        Matcher matcher = f79290d.matcher(com.google.common.base.a.e(str));
        if (!matcher.matches()) {
            o.h("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) z3.a.e(matcher.group(2));
        str2.hashCode();
        switch (str2) {
            case "%":
                cVar.t(3);
                break;
            case "em":
                cVar.t(2);
                break;
            case "px":
                cVar.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        cVar.s(Float.parseFloat((String) z3.a.e(matcher.group(1))));
    }

    public static String f(c0 c0Var, StringBuilder sb2) {
        boolean z11 = false;
        sb2.setLength(0);
        int iF = c0Var.f();
        int iG = c0Var.g();
        while (iF < iG && !z11) {
            char c11 = (char) c0Var.e()[iF];
            if ((c11 < 'A' || c11 > 'Z') && ((c11 < 'a' || c11 > 'z') && !((c11 >= '0' && c11 <= '9') || c11 == '#' || c11 == '-' || c11 == '.' || c11 == '_'))) {
                z11 = true;
            } else {
                iF++;
                sb2.append(c11);
            }
        }
        c0Var.V(iF - c0Var.f());
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
        return "" + ((char) c0Var.H());
    }

    @Nullable
    public static String h(c0 c0Var, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder();
        boolean z11 = false;
        while (!z11) {
            int iF = c0Var.f();
            String strG = g(c0Var, sb2);
            if (strG == null) {
                return null;
            }
            if ("}".equals(strG) || ";".equals(strG)) {
                c0Var.U(iF);
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
        if (c0Var.a() < 5 || !"::cue".equals(c0Var.E(5))) {
            return null;
        }
        int iF = c0Var.f();
        String strG = g(c0Var, sb2);
        if (strG == null) {
            return null;
        }
        if ("{".equals(strG)) {
            c0Var.U(iF);
            return "";
        }
        String strL = "(".equals(strG) ? l(c0Var) : null;
        if (")".equals(g(c0Var, sb2))) {
            return strL;
        }
        return null;
    }

    public static void j(c0 c0Var, c cVar, StringBuilder sb2) {
        n(c0Var);
        String strF = f(c0Var, sb2);
        if (!"".equals(strF) && ":".equals(g(c0Var, sb2))) {
            n(c0Var);
            String strH = h(c0Var, sb2);
            if (strH == null || "".equals(strH)) {
                return;
            }
            int iF = c0Var.f();
            String strG = g(c0Var, sb2);
            if (!";".equals(strG)) {
                if (!"}".equals(strG)) {
                    return;
                } else {
                    c0Var.U(iF);
                }
            }
            if (TtmlNode.ATTR_TTS_COLOR.equals(strF)) {
                cVar.q(z3.f.b(strH));
                return;
            }
            if ("background-color".equals(strF)) {
                cVar.n(z3.f.b(strH));
                return;
            }
            boolean z11 = true;
            if ("ruby-position".equals(strF)) {
                if ("over".equals(strH)) {
                    cVar.v(1);
                    return;
                } else {
                    if ("under".equals(strH)) {
                        cVar.v(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(strF)) {
                if (!"all".equals(strH) && !strH.startsWith("digits")) {
                    z11 = false;
                }
                cVar.p(z11);
                return;
            }
            if ("text-decoration".equals(strF)) {
                if (TtmlNode.UNDERLINE.equals(strH)) {
                    cVar.A(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(strF)) {
                cVar.r(strH);
                return;
            }
            if ("font-weight".equals(strF)) {
                if (TtmlNode.BOLD.equals(strH)) {
                    cVar.o(true);
                }
            } else if ("font-style".equals(strF)) {
                if (TtmlNode.ITALIC.equals(strH)) {
                    cVar.u(true);
                }
            } else if ("font-size".equals(strF)) {
                e(strH, cVar);
            }
        }
    }

    public static char k(c0 c0Var, int i11) {
        return (char) c0Var.e()[i11];
    }

    public static String l(c0 c0Var) {
        int iF = c0Var.f();
        int iG = c0Var.g();
        boolean z11 = false;
        while (iF < iG && !z11) {
            int i11 = iF + 1;
            z11 = ((char) c0Var.e()[iF]) == ')';
            iF = i11;
        }
        return c0Var.E((iF - 1) - c0Var.f()).trim();
    }

    public static void m(c0 c0Var) {
        while (!TextUtils.isEmpty(c0Var.s())) {
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

    public final void a(c cVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = f79289c.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                cVar.z((String) z3.a.e(matcher.group(1)));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrO1 = u0.o1(str, "\\.");
        String str2 = strArrO1[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            cVar.y(str2.substring(0, iIndexOf2));
            cVar.x(str2.substring(iIndexOf2 + 1));
        } else {
            cVar.y(str2);
        }
        if (strArrO1.length > 1) {
            cVar.w((String[]) u0.Y0(strArrO1, 1, strArrO1.length));
        }
    }

    public List<c> d(c0 c0Var) {
        this.f79292b.setLength(0);
        int iF = c0Var.f();
        m(c0Var);
        this.f79291a.S(c0Var.e(), c0Var.f());
        this.f79291a.U(iF);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strI = i(this.f79291a, this.f79292b);
            if (strI == null || !"{".equals(g(this.f79291a, this.f79292b))) {
                return arrayList;
            }
            c cVar = new c();
            a(cVar, strI);
            String str = null;
            boolean z11 = false;
            while (!z11) {
                int iF2 = this.f79291a.f();
                String strG = g(this.f79291a, this.f79292b);
                boolean z12 = strG == null || "}".equals(strG);
                if (!z12) {
                    this.f79291a.U(iF2);
                    j(this.f79291a, cVar, this.f79292b);
                }
                str = strG;
                z11 = z12;
            }
            if ("}".equals(str)) {
                arrayList.add(cVar);
            }
        }
    }
}
