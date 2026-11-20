package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ur {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f23700c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f23701d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bh f23702a = new bh();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StringBuilder f23703b = new StringBuilder();

    private static char a(bh bhVar, int i11) {
        return (char) bhVar.c()[i11];
    }

    private static String a(bh bhVar, StringBuilder sb2) {
        boolean z11 = false;
        sb2.setLength(0);
        int iD = bhVar.d();
        int iE = bhVar.e();
        while (iD < iE && !z11) {
            char c11 = (char) bhVar.c()[iD];
            if ((c11 < 'A' || c11 > 'Z') && ((c11 < 'a' || c11 > 'z') && !((c11 >= '0' && c11 <= '9') || c11 == '#' || c11 == '-' || c11 == '.' || c11 == '_'))) {
                z11 = true;
            } else {
                iD++;
                sb2.append(c11);
            }
        }
        bhVar.g(iD - bhVar.d());
        return sb2.toString();
    }

    private static void a(bh bhVar, vr vrVar, StringBuilder sb2) {
        f(bhVar);
        String strA = a(bhVar, sb2);
        if (!"".equals(strA) && ":".equals(b(bhVar, sb2))) {
            f(bhVar);
            String strC = c(bhVar, sb2);
            if (strC == null || "".equals(strC)) {
                return;
            }
            int iD = bhVar.d();
            String strB = b(bhVar, sb2);
            if (!";".equals(strB)) {
                if (!"}".equals(strB)) {
                    return;
                } else {
                    bhVar.f(iD);
                }
            }
            if (TtmlNode.ATTR_TTS_COLOR.equals(strA)) {
                vrVar.b(s3.a(strC));
                return;
            }
            if ("background-color".equals(strA)) {
                vrVar.a(s3.a(strC));
                return;
            }
            boolean z11 = true;
            if ("ruby-position".equals(strA)) {
                if ("over".equals(strC)) {
                    vrVar.d(1);
                    return;
                } else {
                    if ("under".equals(strC)) {
                        vrVar.d(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(strA)) {
                if (!"all".equals(strC) && !strC.startsWith("digits")) {
                    z11 = false;
                }
                vrVar.b(z11);
                return;
            }
            if ("text-decoration".equals(strA)) {
                if (TtmlNode.UNDERLINE.equals(strC)) {
                    vrVar.d(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(strA)) {
                vrVar.a(strC);
                return;
            }
            if ("font-weight".equals(strA)) {
                if (TtmlNode.BOLD.equals(strC)) {
                    vrVar.a(true);
                }
            } else if ("font-style".equals(strA)) {
                if (TtmlNode.ITALIC.equals(strC)) {
                    vrVar.c(true);
                }
            } else if ("font-size".equals(strA)) {
                a(strC, vrVar);
            }
        }
    }

    private void a(vr vrVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = f23700c.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                vrVar.d((String) b1.a((Object) matcher.group(1)));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrA = xp.a(str, "\\.");
        String str2 = strArrA[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            vrVar.c(str2.substring(0, iIndexOf2));
            vrVar.b(str2.substring(iIndexOf2 + 1));
        } else {
            vrVar.c(str2);
        }
        if (strArrA.length > 1) {
            vrVar.a((String[]) xp.a(strArrA, 1, strArrA.length));
        }
    }

    private static void a(String str, vr vrVar) {
        Matcher matcher = f23701d.matcher(Ascii.toLowerCase(str));
        if (!matcher.matches()) {
            pc.d("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) b1.a((Object) matcher.group(2));
        str2.hashCode();
        switch (str2) {
            case "%":
                vrVar.c(3);
                break;
            case "em":
                vrVar.c(2);
                break;
            case "px":
                vrVar.c(1);
                break;
            default:
                throw new IllegalStateException();
        }
        vrVar.a(Float.parseFloat((String) b1.a((Object) matcher.group(1))));
    }

    private static boolean a(bh bhVar) {
        int iD = bhVar.d();
        int iE = bhVar.e();
        byte[] bArrC = bhVar.c();
        int i11 = iD + 2;
        if (i11 > iE) {
            return false;
        }
        int i12 = iD + 1;
        if (bArrC[iD] != 47 || bArrC[i12] != 42) {
            return false;
        }
        while (true) {
            int i13 = i11 + 1;
            if (i13 >= iE) {
                bhVar.g(iE - bhVar.d());
                return true;
            }
            if (((char) bArrC[i11]) == '*' && ((char) bArrC[i13]) == '/') {
                i11 += 2;
                iE = i11;
            } else {
                i11 = i13;
            }
        }
    }

    public static String b(bh bhVar, StringBuilder sb2) {
        f(bhVar);
        if (bhVar.a() == 0) {
            return null;
        }
        String strA = a(bhVar, sb2);
        if (!"".equals(strA)) {
            return strA;
        }
        return "" + ((char) bhVar.w());
    }

    private static boolean b(bh bhVar) {
        char cA = a(bhVar, bhVar.d());
        if (cA != '\t' && cA != '\n' && cA != '\f' && cA != '\r' && cA != ' ') {
            return false;
        }
        bhVar.g(1);
        return true;
    }

    private static String c(bh bhVar, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder();
        boolean z11 = false;
        while (!z11) {
            int iD = bhVar.d();
            String strB = b(bhVar, sb2);
            if (strB == null) {
                return null;
            }
            if ("}".equals(strB) || ";".equals(strB)) {
                bhVar.f(iD);
                z11 = true;
            } else {
                sb3.append(strB);
            }
        }
        return sb3.toString();
    }

    private static String d(bh bhVar) {
        int i11;
        int iD = bhVar.d();
        int iE = bhVar.e();
        loop0: while (true) {
            boolean z11 = false;
            while (true) {
                if (iD >= iE || z11) {
                    break loop0;
                }
                i11 = iD + 1;
                if (((char) bhVar.c()[iD]) == ')') {
                    z11 = true;
                    iD = i11;
                }
            }
            iD = i11;
        }
        return bhVar.c((iD - 1) - bhVar.d()).trim();
    }

    private static String d(bh bhVar, StringBuilder sb2) {
        f(bhVar);
        if (bhVar.a() < 5 || !"::cue".equals(bhVar.c(5))) {
            return null;
        }
        int iD = bhVar.d();
        String strB = b(bhVar, sb2);
        if (strB == null) {
            return null;
        }
        if ("{".equals(strB)) {
            bhVar.f(iD);
            return "";
        }
        String strD = "(".equals(strB) ? d(bhVar) : null;
        if (")".equals(b(bhVar, sb2))) {
            return strD;
        }
        return null;
    }

    public static void e(bh bhVar) {
        while (!TextUtils.isEmpty(bhVar.l())) {
        }
    }

    public static void f(bh bhVar) {
        while (true) {
            for (boolean z11 = true; bhVar.a() > 0 && z11; z11 = false) {
                if (!b(bhVar) && !a(bhVar)) {
                }
            }
            return;
        }
    }

    public List c(bh bhVar) {
        this.f23703b.setLength(0);
        int iD = bhVar.d();
        e(bhVar);
        this.f23702a.a(bhVar.c(), bhVar.d());
        this.f23702a.f(iD);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strD = d(this.f23702a, this.f23703b);
            if (strD == null || !"{".equals(b(this.f23702a, this.f23703b))) {
                return arrayList;
            }
            vr vrVar = new vr();
            a(vrVar, strD);
            String str = null;
            boolean z11 = false;
            while (!z11) {
                int iD2 = this.f23702a.d();
                String strB = b(this.f23702a, this.f23703b);
                boolean z12 = strB == null || "}".equals(strB);
                if (!z12) {
                    this.f23702a.f(iD2);
                    a(this.f23702a, vrVar, this.f23703b);
                }
                str = strB;
                z11 = z12;
            }
            if ("}".equals(str)) {
                arrayList.add(vrVar);
            }
        }
    }
}
