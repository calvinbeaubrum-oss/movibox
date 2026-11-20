package s5;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o5.e;
import o5.k;
import o5.r;
import o5.s;
import z3.c0;
import z3.h;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements s {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f76115g = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f76116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final a f76117b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, c> f76119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f76120e = -3.4028235E38f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f76121f = -3.4028235E38f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f76118c = new c0();

    public b(@Nullable List<byte[]> list) {
        if (list == null || list.isEmpty()) {
            this.f76116a = false;
            this.f76117b = null;
            return;
        }
        this.f76116a = true;
        String strH = u0.H(list.get(0));
        z3.a.a(strH.startsWith("Format:"));
        this.f76117b = (a) z3.a.e(a.a(strH));
        k(new c0(list.get(1)), com.google.common.base.c.f38165c);
    }

    public static int e(long j11, List<Long> list, List<List<y3.a>> list2) {
        int i11;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i11 = 0;
                break;
            }
            if (list.get(size).longValue() == j11) {
                return size;
            }
            if (list.get(size).longValue() < j11) {
                i11 = size + 1;
                break;
            }
            size--;
        }
        list.add(i11, Long.valueOf(j11));
        list2.add(i11, i11 == 0 ? new ArrayList() : new ArrayList(list2.get(i11 - 1)));
        return i11;
    }

    public static float f(int i11) {
        if (i11 == 0) {
            return 0.05f;
        }
        if (i11 != 1) {
            return i11 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    public static y3.a g(String str, @Nullable c cVar, c.b bVar, float f11, float f12) {
        SpannableString spannableString = new SpannableString(str);
        y3.a.b bVarO = new y3.a.b().o(spannableString);
        if (cVar != null) {
            if (cVar.f76124c != null) {
                spannableString.setSpan(new ForegroundColorSpan(cVar.f76124c.intValue()), 0, spannableString.length(), 33);
            }
            if (cVar.f76131j == 3 && cVar.f76125d != null) {
                spannableString.setSpan(new BackgroundColorSpan(cVar.f76125d.intValue()), 0, spannableString.length(), 33);
            }
            float f13 = cVar.f76126e;
            if (f13 != -3.4028235E38f && f12 != -3.4028235E38f) {
                bVarO.q(f13 / f12, 1);
            }
            boolean z11 = cVar.f76127f;
            if (z11 && cVar.f76128g) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z11) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (cVar.f76128g) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (cVar.f76129h) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (cVar.f76130i) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i11 = bVar.f76147a;
        if (i11 == -1) {
            i11 = cVar != null ? cVar.f76123b : -1;
        }
        bVarO.p(q(i11)).l(p(i11)).i(o(i11));
        PointF pointF = bVar.f76148b;
        if (pointF == null || f12 == -3.4028235E38f || f11 == -3.4028235E38f) {
            bVarO.k(f(bVarO.d()));
            bVarO.h(f(bVarO.c()), 0);
        } else {
            bVarO.k(pointF.x / f11);
            bVarO.h(bVar.f76148b.y / f12, 0);
        }
        return bVarO.a();
    }

    public static Map<String, c> m(c0 c0Var, Charset charset) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c.a aVarA = null;
        while (true) {
            String strT = c0Var.t(charset);
            if (strT == null || (c0Var.a() != 0 && c0Var.h(charset) == '[')) {
                break;
            }
            if (strT.startsWith("Format:")) {
                aVarA = c.a.a(strT);
            } else if (strT.startsWith("Style:")) {
                if (aVarA == null) {
                    o.h("SsaParser", "Skipping 'Style:' line before 'Format:' line: " + strT);
                } else {
                    c cVarB = c.b(strT, aVarA);
                    if (cVarB != null) {
                        linkedHashMap.put(cVarB.f76122a, cVarB);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static long n(String str) {
        Matcher matcher = f76115g.matcher(str.trim());
        return !matcher.matches() ? C.TIME_UNSET : (Long.parseLong((String) u0.i(matcher.group(1))) * 3600000000L) + (Long.parseLong((String) u0.i(matcher.group(2))) * 60000000) + (Long.parseLong((String) u0.i(matcher.group(3))) * 1000000) + (Long.parseLong((String) u0.i(matcher.group(4))) * 10000);
    }

    public static int o(int i11) {
        switch (i11) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                o.h("SsaParser", "Unknown alignment: " + i11);
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
        }
    }

    public static int p(int i11) {
        switch (i11) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                o.h("SsaParser", "Unknown alignment: " + i11);
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
        }
    }

    @Nullable
    public static Layout.Alignment q(int i11) {
        switch (i11) {
            case -1:
                return null;
            case 0:
            default:
                o.h("SsaParser", "Unknown alignment: " + i11);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    @Override // o5.s
    public /* synthetic */ void a(byte[] bArr, s.b bVar, h hVar) {
        r.a(this, bArr, bVar, hVar);
    }

    @Override // o5.s
    public /* synthetic */ k b(byte[] bArr, int i11, int i12) {
        return r.b(this, bArr, i11, i12);
    }

    @Override // o5.s
    public void c(byte[] bArr, int i11, int i12, s.b bVar, h<e> hVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        this.f76118c.S(bArr, i11 + i12);
        this.f76118c.U(i11);
        Charset charsetH = h(this.f76118c);
        if (!this.f76116a) {
            k(this.f76118c, charsetH);
        }
        j(this.f76118c, arrayList3, arrayList4, charsetH);
        ArrayList arrayList5 = (bVar.f72354a == C.TIME_UNSET || !bVar.f72355b) ? null : new ArrayList();
        int i13 = 0;
        while (i13 < arrayList3.size()) {
            List<y3.a> list = arrayList3.get(i13);
            if (list.isEmpty() && i13 != 0) {
                arrayList = arrayList3;
                arrayList2 = arrayList4;
            } else {
                if (i13 == arrayList3.size() - 1) {
                    throw new IllegalStateException();
                }
                long jLongValue = arrayList4.get(i13).longValue();
                long jLongValue2 = arrayList4.get(i13 + 1).longValue() - arrayList4.get(i13).longValue();
                arrayList = arrayList3;
                arrayList2 = arrayList4;
                long j11 = bVar.f72354a;
                if (j11 == C.TIME_UNSET || jLongValue >= j11) {
                    hVar.accept(new e(list, jLongValue, jLongValue2));
                } else if (arrayList5 != null) {
                    arrayList5.add(new e(list, jLongValue, jLongValue2));
                }
            }
            i13++;
            arrayList3 = arrayList;
            arrayList4 = arrayList2;
        }
        if (arrayList5 != null) {
            Iterator it = arrayList5.iterator();
            while (it.hasNext()) {
                hVar.accept((e) it.next());
            }
        }
    }

    @Override // o5.s
    public int d() {
        return 1;
    }

    public final Charset h(c0 c0Var) {
        Charset charsetP = c0Var.P();
        return charsetP != null ? charsetP : com.google.common.base.c.f38165c;
    }

    public final void i(String str, a aVar, List<List<y3.a>> list, List<Long> list2) {
        int i11;
        z3.a.a(str.startsWith("Dialogue:"));
        String[] strArrSplit = str.substring(9).split(",", aVar.f76114e);
        if (strArrSplit.length != aVar.f76114e) {
            o.h("SsaParser", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long jN = n(strArrSplit[aVar.f76110a]);
        if (jN == C.TIME_UNSET) {
            o.h("SsaParser", "Skipping invalid timing: " + str);
            return;
        }
        long jN2 = n(strArrSplit[aVar.f76111b]);
        if (jN2 == C.TIME_UNSET) {
            o.h("SsaParser", "Skipping invalid timing: " + str);
            return;
        }
        Map<String, c> map = this.f76119d;
        c cVar = (map == null || (i11 = aVar.f76112c) == -1) ? null : map.get(strArrSplit[i11].trim());
        String str2 = strArrSplit[aVar.f76113d];
        y3.a aVarG = g(c.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), cVar, c.b.b(str2), this.f76120e, this.f76121f);
        int iE = e(jN2, list2, list);
        for (int iE2 = e(jN, list2, list); iE2 < iE; iE2++) {
            list.get(iE2).add(aVarG);
        }
    }

    public final void j(c0 c0Var, List<List<y3.a>> list, List<Long> list2, Charset charset) {
        a aVarA = this.f76116a ? this.f76117b : null;
        while (true) {
            String strT = c0Var.t(charset);
            if (strT == null) {
                return;
            }
            if (strT.startsWith("Format:")) {
                aVarA = a.a(strT);
            } else if (strT.startsWith("Dialogue:")) {
                if (aVarA == null) {
                    o.h("SsaParser", "Skipping dialogue line before complete format: " + strT);
                } else {
                    i(strT, aVarA, list, list2);
                }
            }
        }
    }

    public final void k(c0 c0Var, Charset charset) {
        while (true) {
            String strT = c0Var.t(charset);
            if (strT == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strT)) {
                l(c0Var, charset);
            } else if ("[V4+ Styles]".equalsIgnoreCase(strT)) {
                this.f76119d = m(c0Var, charset);
            } else if ("[V4 Styles]".equalsIgnoreCase(strT)) {
                o.f("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strT)) {
                return;
            }
        }
    }

    public final void l(c0 c0Var, Charset charset) {
        while (true) {
            String strT = c0Var.t(charset);
            if (strT == null) {
                return;
            }
            if (c0Var.a() != 0 && c0Var.h(charset) == '[') {
                return;
            }
            String[] strArrSplit = strT.split(":");
            if (strArrSplit.length == 2) {
                String strE = com.google.common.base.a.e(strArrSplit[0].trim());
                strE.hashCode();
                if (strE.equals("playresx")) {
                    this.f76120e = Float.parseFloat(strArrSplit[1].trim());
                } else if (strE.equals("playresy")) {
                    try {
                        this.f76121f = Float.parseFloat(strArrSplit[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    @Override // o5.s
    public /* synthetic */ void reset() {
        r.c(this);
    }
}
