package t5;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.common.base.c;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o5.e;
import o5.k;
import o5.r;
import o5.s;
import z3.c0;
import z3.h;
import z3.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f76910d = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f76911e = Pattern.compile("\\{\\\\.*?\\}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f76912a = new StringBuilder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f76913b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f76914c = new c0();

    private Charset f(c0 c0Var) {
        Charset charsetP = c0Var.P();
        return charsetP != null ? charsetP : c.f38165c;
    }

    public static float g(int i11) {
        if (i11 == 0) {
            return 0.08f;
        }
        if (i11 == 1) {
            return 0.5f;
        }
        if (i11 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    public static long h(Matcher matcher, int i11) {
        String strGroup = matcher.group(i11 + 1);
        long j11 = (strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L) + (Long.parseLong((String) z3.a.e(matcher.group(i11 + 2))) * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) + (Long.parseLong((String) z3.a.e(matcher.group(i11 + 3))) * 1000);
        String strGroup2 = matcher.group(i11 + 4);
        if (strGroup2 != null) {
            j11 += Long.parseLong(strGroup2);
        }
        return j11 * 1000;
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
        String str;
        String str2;
        h<e> hVar2;
        h<e> hVar3 = hVar;
        String str3 = "SubripParser";
        this.f76914c.S(bArr, i11 + i12);
        this.f76914c.U(i11);
        Charset charsetF = f(this.f76914c);
        ArrayList arrayList = (bVar.f72354a == C.TIME_UNSET || !bVar.f72355b) ? null : new ArrayList();
        while (true) {
            String strT = this.f76914c.t(charsetF);
            if (strT == null) {
                break;
            }
            if (strT.length() != 0) {
                try {
                    Integer.parseInt(strT);
                    String strT2 = this.f76914c.t(charsetF);
                    if (strT2 == null) {
                        o.h(str3, "Unexpected end");
                        break;
                    }
                    Matcher matcher = f76910d.matcher(strT2);
                    if (matcher.matches()) {
                        long jH = h(matcher, 1);
                        long jH2 = h(matcher, 6);
                        int i13 = 0;
                        this.f76912a.setLength(0);
                        this.f76913b.clear();
                        String strT3 = this.f76914c.t(charsetF);
                        while (!TextUtils.isEmpty(strT3)) {
                            if (this.f76912a.length() > 0) {
                                this.f76912a.append("<br>");
                            }
                            this.f76912a.append(i(strT3, this.f76913b));
                            strT3 = this.f76914c.t(charsetF);
                        }
                        Spanned spannedFromHtml = Html.fromHtml(this.f76912a.toString());
                        while (true) {
                            if (i13 >= this.f76913b.size()) {
                                str2 = null;
                                break;
                            }
                            str2 = this.f76913b.get(i13);
                            if (str2.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            } else {
                                i13++;
                            }
                        }
                        long j11 = bVar.f72354a;
                        if (j11 == C.TIME_UNSET || jH >= j11) {
                            hVar2 = hVar;
                            hVar2.accept(new e(ImmutableList.of(e(spannedFromHtml, str2)), jH, jH2 - jH));
                        } else {
                            if (arrayList != null) {
                                arrayList.add(new e(ImmutableList.of(e(spannedFromHtml, str2)), jH, jH2 - jH));
                            }
                            hVar2 = hVar;
                        }
                        hVar3 = hVar2;
                        str3 = str3;
                    } else {
                        str = str3;
                        o.h(str, "Skipping invalid timing: " + strT2);
                        hVar3 = hVar3;
                        str3 = str;
                    }
                } catch (NumberFormatException unused) {
                    str = str3;
                    o.h(str, "Skipping invalid index: " + strT);
                }
            }
        }
        h<e> hVar4 = hVar3;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                hVar4.accept((e) it.next());
            }
        }
    }

    @Override // o5.s
    public int d() {
        return 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x007b  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e6  */
    public final y3.a e(Spanned spanned, @Nullable String str) {
        byte b11;
        byte b12;
        y3.a.b bVarO = new y3.a.b().o(spanned);
        if (str == null) {
            return bVarO.a();
        }
        switch (str) {
            case "{\an1}":
                b11 = 0;
                break;
            case "{\an2}":
                b11 = 6;
                break;
            case "{\an3}":
                b11 = 3;
                break;
            case "{\an4}":
                b11 = 1;
                break;
            case "{\an5}":
                b11 = 7;
                break;
            case "{\an6}":
                b11 = 4;
                break;
            case "{\an7}":
                b11 = 2;
                break;
            case "{\an8}":
                b11 = 8;
                break;
            case "{\an9}":
                b11 = 5;
                break;
            default:
                b11 = -1;
                break;
        }
        if (b11 == 0 || b11 == 1 || b11 == 2) {
            bVarO.l(0);
        } else if (b11 == 3 || b11 == 4 || b11 == 5) {
            bVarO.l(2);
        } else {
            bVarO.l(1);
        }
        switch (str) {
            case "{\an1}":
                b12 = 0;
                break;
            case "{\an2}":
                b12 = 1;
                break;
            case "{\an3}":
                b12 = 2;
                break;
            case "{\an4}":
                b12 = 6;
                break;
            case "{\an5}":
                b12 = 7;
                break;
            case "{\an6}":
                b12 = 8;
                break;
            case "{\an7}":
                b12 = 3;
                break;
            case "{\an8}":
                b12 = 4;
                break;
            case "{\an9}":
                b12 = 5;
                break;
            default:
                b12 = -1;
                break;
        }
        if (b12 == 0 || b12 == 1 || b12 == 2) {
            bVarO.i(2);
        } else if (b12 == 3 || b12 == 4 || b12 == 5) {
            bVarO.i(0);
        } else {
            bVarO.i(1);
        }
        return bVarO.k(g(bVarO.d())).h(g(bVarO.c()), 0).a();
    }

    public final String i(String str, ArrayList<String> arrayList) {
        String strTrim = str.trim();
        StringBuilder sb2 = new StringBuilder(strTrim);
        Matcher matcher = f76911e.matcher(strTrim);
        int i11 = 0;
        while (matcher.find()) {
            String strGroup = matcher.group();
            arrayList.add(strGroup);
            int iStart = matcher.start() - i11;
            int length = strGroup.length();
            sb2.replace(iStart, iStart + length, "");
            i11 += length;
        }
        return sb2.toString();
    }

    @Override // o5.s
    public /* synthetic */ void reset() {
        r.c(this);
    }
}
