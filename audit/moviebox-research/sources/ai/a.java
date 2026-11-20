package ai;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vh.h;
import vh.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends h {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Pattern f535t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f536o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public final b f537p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Map<String, c> f538q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f539r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f540s;

    public a(@Nullable List<byte[]> list) {
        super("SsaDecoder");
        this.f539r = -3.4028235E38f;
        this.f540s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.f536o = false;
            this.f537p = null;
            return;
        }
        this.f536o = true;
        String strD = o0.D(list.get(0));
        com.google.android.exoplayer2.util.a.a(strD.startsWith("Format:"));
        this.f537p = (b) com.google.android.exoplayer2.util.a.e(b.a(strD));
        C(new c0(list.get(1)));
    }

    public static Map<String, c> E(c0 c0Var) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c.a aVarA = null;
        while (true) {
            String strP = c0Var.p();
            if (strP == null || (c0Var.a() != 0 && c0Var.h() == 91)) {
                break;
            }
            if (strP.startsWith("Format:")) {
                aVarA = c.a.a(strP);
            } else if (strP.startsWith("Style:")) {
                if (aVarA == null) {
                    s.i("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: " + strP);
                } else {
                    c cVarB = c.b(strP, aVarA);
                    if (cVarB != null) {
                        linkedHashMap.put(cVarB.f546a, cVarB);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static long F(String str) {
        Matcher matcher = f535t.matcher(str.trim());
        return !matcher.matches() ? C.TIME_UNSET : (Long.parseLong((String) o0.j(matcher.group(1))) * 3600000000L) + (Long.parseLong((String) o0.j(matcher.group(2))) * 60000000) + (Long.parseLong((String) o0.j(matcher.group(3))) * 1000000) + (Long.parseLong((String) o0.j(matcher.group(4))) * 10000);
    }

    public static int G(int i11) {
        switch (i11) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                s.i("SsaDecoder", "Unknown alignment: " + i11);
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

    public static int H(int i11) {
        switch (i11) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                s.i("SsaDecoder", "Unknown alignment: " + i11);
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
    public static Layout.Alignment I(int i11) {
        switch (i11) {
            case -1:
                return null;
            case 0:
            default:
                s.i("SsaDecoder", "Unknown alignment: " + i11);
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

    public static int x(long j11, List<Long> list, List<List<vh.b>> list2) {
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

    public static float y(int i11) {
        if (i11 == 0) {
            return 0.05f;
        }
        if (i11 != 1) {
            return i11 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    public static vh.b z(String str, @Nullable c cVar, c.b bVar, float f11, float f12) {
        SpannableString spannableString = new SpannableString(str);
        vh.b.C0875b c0875bO = new vh.b.C0875b().o(spannableString);
        if (cVar != null) {
            if (cVar.f548c != null) {
                spannableString.setSpan(new ForegroundColorSpan(cVar.f548c.intValue()), 0, spannableString.length(), 33);
            }
            if (cVar.f555j == 3 && cVar.f549d != null) {
                spannableString.setSpan(new BackgroundColorSpan(cVar.f549d.intValue()), 0, spannableString.length(), 33);
            }
            float f13 = cVar.f550e;
            if (f13 != -3.4028235E38f && f12 != -3.4028235E38f) {
                c0875bO.q(f13 / f12, 1);
            }
            boolean z11 = cVar.f551f;
            if (z11 && cVar.f552g) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z11) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (cVar.f552g) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (cVar.f553h) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (cVar.f554i) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i11 = bVar.f571a;
        if (i11 == -1) {
            i11 = cVar != null ? cVar.f547b : -1;
        }
        c0875bO.p(I(i11)).l(H(i11)).i(G(i11));
        PointF pointF = bVar.f572b;
        if (pointF == null || f12 == -3.4028235E38f || f11 == -3.4028235E38f) {
            c0875bO.k(y(c0875bO.d()));
            c0875bO.h(y(c0875bO.c()), 0);
        } else {
            c0875bO.k(pointF.x / f11);
            c0875bO.h(bVar.f572b.y / f12, 0);
        }
        return c0875bO.a();
    }

    public final void A(String str, b bVar, List<List<vh.b>> list, List<Long> list2) {
        int i11;
        com.google.android.exoplayer2.util.a.a(str.startsWith("Dialogue:"));
        String[] strArrSplit = str.substring(9).split(",", bVar.f545e);
        if (strArrSplit.length != bVar.f545e) {
            s.i("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long jF = F(strArrSplit[bVar.f541a]);
        if (jF == C.TIME_UNSET) {
            s.i("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        long jF2 = F(strArrSplit[bVar.f542b]);
        if (jF2 == C.TIME_UNSET) {
            s.i("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        Map<String, c> map = this.f538q;
        c cVar = (map == null || (i11 = bVar.f543c) == -1) ? null : map.get(strArrSplit[i11].trim());
        String str2 = strArrSplit[bVar.f544d];
        vh.b bVarZ = z(c.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), cVar, c.b.b(str2), this.f539r, this.f540s);
        int iX = x(jF2, list2, list);
        for (int iX2 = x(jF, list2, list); iX2 < iX; iX2++) {
            list.get(iX2).add(bVarZ);
        }
    }

    public final void B(c0 c0Var, List<List<vh.b>> list, List<Long> list2) {
        b bVarA = this.f536o ? this.f537p : null;
        while (true) {
            String strP = c0Var.p();
            if (strP == null) {
                return;
            }
            if (strP.startsWith("Format:")) {
                bVarA = b.a(strP);
            } else if (strP.startsWith("Dialogue:")) {
                if (bVarA == null) {
                    s.i("SsaDecoder", "Skipping dialogue line before complete format: " + strP);
                } else {
                    A(strP, bVarA, list, list2);
                }
            }
        }
    }

    public final void C(c0 c0Var) {
        while (true) {
            String strP = c0Var.p();
            if (strP == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strP)) {
                D(c0Var);
            } else if ("[V4+ Styles]".equalsIgnoreCase(strP)) {
                this.f538q = E(c0Var);
            } else if ("[V4 Styles]".equalsIgnoreCase(strP)) {
                s.f("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strP)) {
                return;
            }
        }
    }

    public final void D(c0 c0Var) {
        while (true) {
            String strP = c0Var.p();
            if (strP == null) {
                return;
            }
            if (c0Var.a() != 0 && c0Var.h() == 91) {
                return;
            }
            String[] strArrSplit = strP.split(":");
            if (strArrSplit.length == 2) {
                String strE = com.google.common.base.a.e(strArrSplit[0].trim());
                strE.hashCode();
                if (strE.equals("playresx")) {
                    this.f539r = Float.parseFloat(strArrSplit[1].trim());
                } else if (strE.equals("playresy")) {
                    try {
                        this.f540s = Float.parseFloat(strArrSplit[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    @Override // vh.h
    public i w(byte[] bArr, int i11, boolean z11) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        c0 c0Var = new c0(bArr, i11);
        if (!this.f536o) {
            C(c0Var);
        }
        B(c0Var, arrayList, arrayList2);
        return new d(arrayList, arrayList2);
    }
}
