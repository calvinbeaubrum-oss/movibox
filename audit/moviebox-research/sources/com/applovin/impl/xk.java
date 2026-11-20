package com.applovin.impl;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class xk extends ek {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Pattern f24339t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f24340o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final yk f24341p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Map f24342q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f24343r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f24344s;

    public xk(List list) {
        super("SsaDecoder");
        this.f24343r = -3.4028235E38f;
        this.f24344s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.f24340o = false;
            this.f24341p = null;
            return;
        }
        this.f24340o = true;
        String strA = xp.a((byte[]) list.get(0));
        b1.a(strA.startsWith("Format:"));
        this.f24341p = (yk) b1.a(yk.a(strA));
        a(new bh((byte[]) list.get(1)));
    }

    private static int a(long j11, List list, List list2) {
        int i11;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i11 = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j11) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j11) {
                i11 = size + 1;
                break;
            }
            size--;
        }
        list.add(i11, Long.valueOf(j11));
        list2.add(i11, i11 == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i11 - 1)));
        return i11;
    }

    private static long a(String str) {
        Matcher matcher = f24339t.matcher(str.trim());
        return !matcher.matches() ? C.TIME_UNSET : (Long.parseLong((String) xp.a((Object) matcher.group(1))) * 3600000000L) + (Long.parseLong((String) xp.a((Object) matcher.group(2))) * 60000000) + (Long.parseLong((String) xp.a((Object) matcher.group(3))) * 1000000) + (Long.parseLong((String) xp.a((Object) matcher.group(4))) * 10000);
    }

    private static b5 a(String str, zk zkVar, zk.b bVar, float f11, float f12) {
        SpannableString spannableString = new SpannableString(str);
        b5.b bVarA = new b5.b().a(spannableString);
        if (zkVar != null) {
            if (zkVar.f24871c != null) {
                spannableString.setSpan(new ForegroundColorSpan(zkVar.f24871c.intValue()), 0, spannableString.length(), 33);
            }
            float f13 = zkVar.f24872d;
            if (f13 != -3.4028235E38f && f12 != -3.4028235E38f) {
                bVarA.b(f13 / f12, 1);
            }
            boolean z11 = zkVar.f24873e;
            if (z11 && zkVar.f24874f) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z11) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (zkVar.f24874f) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (zkVar.f24875g) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (zkVar.f24876h) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i11 = bVar.f24890a;
        if (i11 == -1) {
            i11 = zkVar != null ? zkVar.f24870b : -1;
        }
        bVarA.b(e(i11)).b(d(i11)).a(c(i11));
        PointF pointF = bVar.f24891b;
        if (pointF == null || f12 == -3.4028235E38f || f11 == -3.4028235E38f) {
            bVarA.b(b(bVarA.d()));
            bVarA.a(b(bVarA.c()), 0);
        } else {
            bVarA.b(pointF.x / f11);
            bVarA.a(bVar.f24891b.y / f12, 0);
        }
        return bVarA.a();
    }

    private void a(bh bhVar) {
        while (true) {
            String strL = bhVar.l();
            if (strL == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strL)) {
                b(bhVar);
            } else if ("[V4+ Styles]".equalsIgnoreCase(strL)) {
                this.f24342q = c(bhVar);
            } else if ("[V4 Styles]".equalsIgnoreCase(strL)) {
                pc.c("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strL)) {
                return;
            }
        }
    }

    private void a(bh bhVar, List list, List list2) {
        yk ykVarA = this.f24340o ? this.f24341p : null;
        while (true) {
            String strL = bhVar.l();
            if (strL == null) {
                return;
            }
            if (strL.startsWith("Format:")) {
                ykVarA = yk.a(strL);
            } else if (strL.startsWith("Dialogue:")) {
                if (ykVarA == null) {
                    pc.d("SsaDecoder", "Skipping dialogue line before complete format: " + strL);
                } else {
                    a(strL, ykVarA, list, list2);
                }
            }
        }
    }

    private void a(String str, yk ykVar, List list, List list2) {
        int i11;
        b1.a(str.startsWith("Dialogue:"));
        String[] strArrSplit = str.substring(9).split(",", ykVar.f24688e);
        if (strArrSplit.length != ykVar.f24688e) {
            pc.d("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long jA = a(strArrSplit[ykVar.f24684a]);
        if (jA == C.TIME_UNSET) {
            pc.d("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        long jA2 = a(strArrSplit[ykVar.f24685b]);
        if (jA2 == C.TIME_UNSET) {
            pc.d("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        Map map = this.f24342q;
        zk zkVar = (map == null || (i11 = ykVar.f24686c) == -1) ? null : (zk) map.get(strArrSplit[i11].trim());
        String str2 = strArrSplit[ykVar.f24687d];
        b5 b5VarA = a(zk.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), zkVar, zk.b.b(str2), this.f24343r, this.f24344s);
        int iA = a(jA2, list2, list);
        for (int iA2 = a(jA, list2, list); iA2 < iA; iA2++) {
            ((List) list.get(iA2)).add(b5VarA);
        }
    }

    private static float b(int i11) {
        if (i11 == 0) {
            return 0.05f;
        }
        if (i11 != 1) {
            return i11 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private void b(bh bhVar) {
        while (true) {
            String strL = bhVar.l();
            if (strL == null) {
                return;
            }
            if (bhVar.a() != 0 && bhVar.g() == 91) {
                return;
            }
            String[] strArrSplit = strL.split(":");
            if (strArrSplit.length == 2) {
                String lowerCase = Ascii.toLowerCase(strArrSplit[0].trim());
                lowerCase.hashCode();
                if (lowerCase.equals("playresx")) {
                    this.f24343r = Float.parseFloat(strArrSplit[1].trim());
                } else if (lowerCase.equals("playresy")) {
                    try {
                        this.f24344s = Float.parseFloat(strArrSplit[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    private static int c(int i11) {
        switch (i11) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                pc.d("SsaDecoder", "Unknown alignment: " + i11);
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

    private static Map c(bh bhVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        zk.a aVarA = null;
        while (true) {
            String strL = bhVar.l();
            if (strL == null || (bhVar.a() != 0 && bhVar.g() == 91)) {
                break;
            }
            if (strL.startsWith("Format:")) {
                aVarA = zk.a.a(strL);
            } else if (strL.startsWith("Style:")) {
                if (aVarA == null) {
                    pc.d("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: " + strL);
                } else {
                    zk zkVarA = zk.a(strL, aVarA);
                    if (zkVarA != null) {
                        linkedHashMap.put(zkVarA.f24869a, zkVarA);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static int d(int i11) {
        switch (i11) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                pc.d("SsaDecoder", "Unknown alignment: " + i11);
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

    private static Layout.Alignment e(int i11) {
        switch (i11) {
            case -1:
                return null;
            case 0:
            default:
                pc.d("SsaDecoder", "Unknown alignment: " + i11);
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

    @Override // com.applovin.impl.ek
    public nl a(byte[] bArr, int i11, boolean z11) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        bh bhVar = new bh(bArr, i11);
        if (!this.f24340o) {
            a(bhVar);
        }
        a(bhVar, arrayList, arrayList2);
        return new al(arrayList, arrayList2);
    }
}
