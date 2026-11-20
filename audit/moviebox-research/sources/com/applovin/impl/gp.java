package com.applovin.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class gp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f19279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f19280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f19281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final jp f19282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String[] f19283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f19284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f19285i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final gp f19286j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final HashMap f19287k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final HashMap f19288l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private List f19289m;

    private gp(String str, String str2, long j11, long j12, jp jpVar, String[] strArr, String str3, String str4, gp gpVar) {
        this.f19277a = str;
        this.f19278b = str2;
        this.f19285i = str4;
        this.f19282f = jpVar;
        this.f19283g = strArr;
        this.f19279c = str2 != null;
        this.f19280d = j11;
        this.f19281e = j12;
        this.f19284h = (String) b1.a((Object) str3);
        this.f19286j = gpVar;
        this.f19287k = new HashMap();
        this.f19288l = new HashMap();
    }

    private static SpannableStringBuilder a(String str, Map map) {
        if (!map.containsKey(str)) {
            b5.b bVar = new b5.b();
            bVar.a(new SpannableStringBuilder());
            map.put(str, bVar);
        }
        return (SpannableStringBuilder) b1.a(((b5.b) map.get(str)).e());
    }

    public static gp a(String str) {
        return new gp(null, ip.a(str), C.TIME_UNSET, C.TIME_UNSET, null, null, "", null, null);
    }

    public static gp a(String str, long j11, long j12, jp jpVar, String[] strArr, String str2, String str3, gp gpVar) {
        return new gp(str, null, j11, j12, jpVar, strArr, str2, str3, gpVar);
    }

    private void a(long j11, String str, List list) {
        if (!"".equals(this.f19284h)) {
            str = this.f19284h;
        }
        if (a(j11) && TtmlNode.TAG_DIV.equals(this.f19277a) && this.f19285i != null) {
            list.add(new Pair(str, this.f19285i));
            return;
        }
        for (int i11 = 0; i11 < a(); i11++) {
            a(i11).a(j11, str, list);
        }
    }

    private void a(long j11, Map map, Map map2, String str, Map map3) {
        int i11;
        if (a(j11)) {
            String str2 = "".equals(this.f19284h) ? str : this.f19284h;
            Iterator it = this.f19288l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str3 = (String) entry.getKey();
                int iIntValue = this.f19287k.containsKey(str3) ? ((Integer) this.f19287k.get(str3)).intValue() : 0;
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (iIntValue != iIntValue2) {
                    a(map, (b5.b) b1.a((b5.b) map3.get(str3)), iIntValue, iIntValue2, ((hp) b1.a((hp) map2.get(str2))).f19529j);
                }
            }
            for (i11 = 0; i11 < a(); i11++) {
                a(i11).a(j11, map, map2, str2, map3);
            }
        }
    }

    private void a(long j11, boolean z11, String str, Map map) {
        this.f19287k.clear();
        this.f19288l.clear();
        if (TtmlNode.TAG_METADATA.equals(this.f19277a)) {
            return;
        }
        if (!"".equals(this.f19284h)) {
            str = this.f19284h;
        }
        if (this.f19279c && z11) {
            a(str, map).append((CharSequence) b1.a((Object) this.f19278b));
            return;
        }
        if (TtmlNode.TAG_BR.equals(this.f19277a) && z11) {
            a(str, map).append('\n');
            return;
        }
        if (a(j11)) {
            for (Map.Entry entry : map.entrySet()) {
                this.f19287k.put((String) entry.getKey(), Integer.valueOf(((CharSequence) b1.a(((b5.b) entry.getValue()).e())).length()));
            }
            boolean zEquals = TtmlNode.TAG_P.equals(this.f19277a);
            for (int i11 = 0; i11 < a(); i11++) {
                a(i11).a(j11, z11 || zEquals, str, map);
            }
            if (zEquals) {
                ip.a(a(str, map));
            }
            for (Map.Entry entry2 : map.entrySet()) {
                this.f19288l.put((String) entry2.getKey(), Integer.valueOf(((CharSequence) b1.a(((b5.b) entry2.getValue()).e())).length()));
            }
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder) {
        for (o6 o6Var : (o6[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), o6.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(o6Var), spannableStringBuilder.getSpanEnd(o6Var), "");
        }
        for (int i11 = 0; i11 < spannableStringBuilder.length(); i11++) {
            if (spannableStringBuilder.charAt(i11) == ' ') {
                int i12 = i11 + 1;
                int i13 = i12;
                while (i13 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i13) == ' ') {
                    i13++;
                }
                int i14 = i13 - i12;
                if (i14 > 0) {
                    spannableStringBuilder.delete(i11, i14 + i11);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i15 = 0; i15 < spannableStringBuilder.length() - 1; i15++) {
            if (spannableStringBuilder.charAt(i15) == '\n') {
                int i16 = i15 + 1;
                if (spannableStringBuilder.charAt(i16) == ' ') {
                    spannableStringBuilder.delete(i16, i15 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i17 = 0; i17 < spannableStringBuilder.length() - 1; i17++) {
            if (spannableStringBuilder.charAt(i17) == ' ') {
                int i18 = i17 + 1;
                if (spannableStringBuilder.charAt(i18) == '\n') {
                    spannableStringBuilder.delete(i17, i18);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    private void a(Map map, b5.b bVar, int i11, int i12, int i13) {
        jp jpVarA = ip.a(this.f19282f, this.f19283g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) bVar.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            bVar.a(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (jpVarA != null) {
            ip.a(spannableStringBuilder2, i11, i12, jpVarA, this.f19286j, map, i13);
            if (TtmlNode.TAG_P.equals(this.f19277a)) {
                if (jpVarA.j() != Float.MAX_VALUE) {
                    bVar.c((jpVarA.j() * (-90.0f)) / 100.0f);
                }
                if (jpVarA.l() != null) {
                    bVar.b(jpVarA.l());
                }
                if (jpVarA.g() != null) {
                    bVar.a(jpVarA.g());
                }
            }
        }
    }

    private void a(TreeSet treeSet, boolean z11) {
        boolean zEquals = TtmlNode.TAG_P.equals(this.f19277a);
        boolean zEquals2 = TtmlNode.TAG_DIV.equals(this.f19277a);
        if (z11 || zEquals || (zEquals2 && this.f19285i != null)) {
            long j11 = this.f19280d;
            if (j11 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j11));
            }
            long j12 = this.f19281e;
            if (j12 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j12));
            }
        }
        if (this.f19289m == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f19289m.size(); i11++) {
            ((gp) this.f19289m.get(i11)).a(treeSet, z11 || zEquals);
        }
    }

    public int a() {
        List list = this.f19289m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public gp a(int i11) {
        List list = this.f19289m;
        if (list != null) {
            return (gp) list.get(i11);
        }
        throw new IndexOutOfBoundsException();
    }

    public List a(long j11, Map map, Map map2, Map map3) {
        List<Pair> arrayList = new ArrayList();
        a(j11, this.f19284h, arrayList);
        TreeMap treeMap = new TreeMap();
        a(j11, false, this.f19284h, (Map) treeMap);
        a(j11, map, map2, this.f19284h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                hp hpVar = (hp) b1.a((hp) map2.get(pair.first));
                arrayList2.add(new b5.b().a(bitmapDecodeByteArray).b(hpVar.f19521b).b(0).a(hpVar.f19522c, 0).a(hpVar.f19524e).d(hpVar.f19525f).a(hpVar.f19526g).c(hpVar.f19529j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            hp hpVar2 = (hp) b1.a((hp) map2.get(entry.getKey()));
            b5.b bVar = (b5.b) entry.getValue();
            a((SpannableStringBuilder) b1.a(bVar.e()));
            bVar.a(hpVar2.f19522c, hpVar2.f19523d);
            bVar.a(hpVar2.f19524e);
            bVar.b(hpVar2.f19521b);
            bVar.d(hpVar2.f19525f);
            bVar.b(hpVar2.f19528i, hpVar2.f19527h);
            bVar.c(hpVar2.f19529j);
            arrayList2.add(bVar.a());
        }
        return arrayList2;
    }

    public void a(gp gpVar) {
        if (this.f19289m == null) {
            this.f19289m = new ArrayList();
        }
        this.f19289m.add(gpVar);
    }

    public boolean a(long j11) {
        long j12 = this.f19280d;
        return (j12 == C.TIME_UNSET && this.f19281e == C.TIME_UNSET) || (j12 <= j11 && this.f19281e == C.TIME_UNSET) || ((j12 == C.TIME_UNSET && j11 < this.f19281e) || (j12 <= j11 && j11 < this.f19281e));
    }

    public long[] b() {
        TreeSet treeSet = new TreeSet();
        int i11 = 0;
        a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i11] = ((Long) it.next()).longValue();
            i11++;
        }
        return jArr;
    }

    public String[] c() {
        return this.f19283g;
    }
}
