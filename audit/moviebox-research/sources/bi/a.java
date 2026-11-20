package bi;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.t;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vh.h;
import vh.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends h {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Pattern f14271q = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Pattern f14272r = Pattern.compile("\\{\\\\.*?\\}");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final StringBuilder f14273o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<String> f14274p;

    public a() {
        super("SubripDecoder");
        this.f14273o = new StringBuilder();
        this.f14274p = new ArrayList<>();
    }

    public static float y(int i11) {
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

    public static long z(Matcher matcher, int i11) {
        String strGroup = matcher.group(i11 + 1);
        long j11 = (strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L) + (Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(i11 + 2))) * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) + (Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(i11 + 3))) * 1000);
        String strGroup2 = matcher.group(i11 + 4);
        if (strGroup2 != null) {
            j11 += Long.parseLong(strGroup2);
        }
        return j11 * 1000;
    }

    public final String A(String str, ArrayList<String> arrayList) {
        String strTrim = str.trim();
        StringBuilder sb2 = new StringBuilder(strTrim);
        Matcher matcher = f14272r.matcher(strTrim);
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

    @Override // vh.h
    public i w(byte[] bArr, int i11, boolean z11) {
        String str;
        ArrayList arrayList = new ArrayList();
        t tVar = new t();
        c0 c0Var = new c0(bArr, i11);
        while (true) {
            String strP = c0Var.p();
            int i12 = 0;
            if (strP == null) {
                break;
            }
            if (strP.length() != 0) {
                try {
                    Integer.parseInt(strP);
                    String strP2 = c0Var.p();
                    if (strP2 == null) {
                        s.i("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = f14271q.matcher(strP2);
                    if (matcher.matches()) {
                        tVar.a(z(matcher, 1));
                        tVar.a(z(matcher, 6));
                        this.f14273o.setLength(0);
                        this.f14274p.clear();
                        for (String strP3 = c0Var.p(); !TextUtils.isEmpty(strP3); strP3 = c0Var.p()) {
                            if (this.f14273o.length() > 0) {
                                this.f14273o.append("<br>");
                            }
                            this.f14273o.append(A(strP3, this.f14274p));
                        }
                        Spanned spannedFromHtml = Html.fromHtml(this.f14273o.toString());
                        while (true) {
                            if (i12 >= this.f14274p.size()) {
                                str = null;
                                break;
                            }
                            str = this.f14274p.get(i12);
                            if (str.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            }
                            i12++;
                        }
                        arrayList.add(x(spannedFromHtml, str));
                        arrayList.add(vh.b.f78816s);
                    } else {
                        s.i("SubripDecoder", "Skipping invalid timing: " + strP2);
                    }
                } catch (NumberFormatException unused) {
                    s.i("SubripDecoder", "Skipping invalid index: " + strP);
                }
            }
        }
        return new b((vh.b[]) arrayList.toArray(new vh.b[0]), tVar.d());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x007b  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e6  */
    public final vh.b x(Spanned spanned, @Nullable String str) {
        byte b11;
        byte b12;
        vh.b.C0875b c0875bO = new vh.b.C0875b().o(spanned);
        if (str == null) {
            return c0875bO.a();
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
            c0875bO.l(0);
        } else if (b11 == 3 || b11 == 4 || b11 == 5) {
            c0875bO.l(2);
        } else {
            c0875bO.l(1);
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
            c0875bO.i(2);
        } else if (b12 == 3 || b12 == 4 || b12 == 5) {
            c0875bO.i(0);
        } else {
            c0875bO.i(1);
        }
        return c0875bO.k(y(c0875bO.d())).h(y(c0875bO.c()), 0).a();
    }
}
