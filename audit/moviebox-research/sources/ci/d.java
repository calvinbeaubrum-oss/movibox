package ci;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
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
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f14879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f14880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f14882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f14883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final g f14884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String[] f14885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f14886h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f14887i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final d f14888j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap<String, Integer> f14889k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HashMap<String, Integer> f14890l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<d> f14891m;

    public d(@Nullable String str, @Nullable String str2, long j11, long j12, @Nullable g gVar, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable d dVar) {
        this.f14879a = str;
        this.f14880b = str2;
        this.f14887i = str4;
        this.f14884f = gVar;
        this.f14885g = strArr;
        this.f14881c = str2 != null;
        this.f14882d = j11;
        this.f14883e = j12;
        this.f14886h = (String) com.google.android.exoplayer2.util.a.e(str3);
        this.f14888j = dVar;
        this.f14889k = new HashMap<>();
        this.f14890l = new HashMap<>();
    }

    public static d c(@Nullable String str, long j11, long j12, @Nullable g gVar, @Nullable String[] strArr, String str2, @Nullable String str3, @Nullable d dVar) {
        return new d(str, null, j11, j12, gVar, strArr, str2, str3, dVar);
    }

    public static d d(String str) {
        return new d(null, f.b(str), C.TIME_UNSET, C.TIME_UNSET, null, null, "", null, null);
    }

    public static void e(SpannableStringBuilder spannableStringBuilder) {
        for (a aVar : (a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar), spannableStringBuilder.getSpanEnd(aVar), "");
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

    public static SpannableStringBuilder k(String str, Map<String, vh.b.C0875b> map) {
        if (!map.containsKey(str)) {
            vh.b.C0875b c0875b = new vh.b.C0875b();
            c0875b.o(new SpannableStringBuilder());
            map.put(str, c0875b);
        }
        return (SpannableStringBuilder) com.google.android.exoplayer2.util.a.e(map.get(str).e());
    }

    public void a(d dVar) {
        if (this.f14891m == null) {
            this.f14891m = new ArrayList();
        }
        this.f14891m.add(dVar);
    }

    public final void b(Map<String, g> map, vh.b.C0875b c0875b, int i11, int i12, int i13) {
        g gVarF = f.f(this.f14884f, this.f14885g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) c0875b.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            c0875b.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (gVarF != null) {
            f.a(spannableStringBuilder2, i11, i12, gVarF, this.f14888j, map, i13);
            if (TtmlNode.TAG_P.equals(this.f14879a)) {
                if (gVarF.k() != Float.MAX_VALUE) {
                    c0875b.m((gVarF.k() * (-90.0f)) / 100.0f);
                }
                if (gVarF.m() != null) {
                    c0875b.p(gVarF.m());
                }
                if (gVarF.h() != null) {
                    c0875b.j(gVarF.h());
                }
            }
        }
    }

    public d f(int i11) {
        List<d> list = this.f14891m;
        if (list != null) {
            return list.get(i11);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List<d> list = this.f14891m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<vh.b> h(long j11, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        List<Pair<String, String>> arrayList = new ArrayList<>();
        n(j11, this.f14886h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j11, false, this.f14886h, treeMap);
        o(j11, map, map2, this.f14886h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                e eVar = (e) com.google.android.exoplayer2.util.a.e(map2.get(pair.first));
                arrayList2.add(new vh.b.C0875b().f(bitmapDecodeByteArray).k(eVar.f14893b).l(0).h(eVar.f14894c, 0).i(eVar.f14896e).n(eVar.f14897f).g(eVar.f14898g).r(eVar.f14901j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            e eVar2 = (e) com.google.android.exoplayer2.util.a.e(map2.get(entry.getKey()));
            vh.b.C0875b c0875b = (vh.b.C0875b) entry.getValue();
            e((SpannableStringBuilder) com.google.android.exoplayer2.util.a.e(c0875b.e()));
            c0875b.h(eVar2.f14894c, eVar2.f14895d);
            c0875b.i(eVar2.f14896e);
            c0875b.k(eVar2.f14893b);
            c0875b.n(eVar2.f14897f);
            c0875b.q(eVar2.f14900i, eVar2.f14899h);
            c0875b.r(eVar2.f14901j);
            arrayList2.add(c0875b.a());
        }
        return arrayList2;
    }

    public final void i(TreeSet<Long> treeSet, boolean z11) {
        boolean zEquals = TtmlNode.TAG_P.equals(this.f14879a);
        boolean zEquals2 = TtmlNode.TAG_DIV.equals(this.f14879a);
        if (z11 || zEquals || (zEquals2 && this.f14887i != null)) {
            long j11 = this.f14882d;
            if (j11 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j11));
            }
            long j12 = this.f14883e;
            if (j12 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j12));
            }
        }
        if (this.f14891m == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f14891m.size(); i11++) {
            this.f14891m.get(i11).i(treeSet, z11 || zEquals);
        }
    }

    public long[] j() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i11 = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i11] = it.next().longValue();
            i11++;
        }
        return jArr;
    }

    @Nullable
    public String[] l() {
        return this.f14885g;
    }

    public boolean m(long j11) {
        long j12 = this.f14882d;
        return (j12 == C.TIME_UNSET && this.f14883e == C.TIME_UNSET) || (j12 <= j11 && this.f14883e == C.TIME_UNSET) || ((j12 == C.TIME_UNSET && j11 < this.f14883e) || (j12 <= j11 && j11 < this.f14883e));
    }

    public final void n(long j11, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.f14886h)) {
            str = this.f14886h;
        }
        if (m(j11) && TtmlNode.TAG_DIV.equals(this.f14879a) && this.f14887i != null) {
            list.add(new Pair<>(str, this.f14887i));
            return;
        }
        for (int i11 = 0; i11 < g(); i11++) {
            f(i11).n(j11, str, list);
        }
    }

    public final void o(long j11, Map<String, g> map, Map<String, e> map2, String str, Map<String, vh.b.C0875b> map3) {
        int i11;
        if (m(j11)) {
            String str2 = "".equals(this.f14886h) ? str : this.f14886h;
            Iterator<Map.Entry<String, Integer>> it = this.f14890l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Integer> next = it.next();
                String key = next.getKey();
                int iIntValue = this.f14889k.containsKey(key) ? this.f14889k.get(key).intValue() : 0;
                int iIntValue2 = next.getValue().intValue();
                if (iIntValue != iIntValue2) {
                    b(map, (vh.b.C0875b) com.google.android.exoplayer2.util.a.e(map3.get(key)), iIntValue, iIntValue2, ((e) com.google.android.exoplayer2.util.a.e(map2.get(str2))).f14901j);
                }
            }
            for (i11 = 0; i11 < g(); i11++) {
                f(i11).o(j11, map, map2, str2, map3);
            }
        }
    }

    public final void p(long j11, boolean z11, String str, Map<String, vh.b.C0875b> map) {
        this.f14889k.clear();
        this.f14890l.clear();
        if (TtmlNode.TAG_METADATA.equals(this.f14879a)) {
            return;
        }
        if (!"".equals(this.f14886h)) {
            str = this.f14886h;
        }
        if (this.f14881c && z11) {
            k(str, map).append((CharSequence) com.google.android.exoplayer2.util.a.e(this.f14880b));
            return;
        }
        if (TtmlNode.TAG_BR.equals(this.f14879a) && z11) {
            k(str, map).append('\n');
            return;
        }
        if (m(j11)) {
            for (Map.Entry<String, vh.b.C0875b> entry : map.entrySet()) {
                this.f14889k.put(entry.getKey(), Integer.valueOf(((CharSequence) com.google.android.exoplayer2.util.a.e(entry.getValue().e())).length()));
            }
            boolean zEquals = TtmlNode.TAG_P.equals(this.f14879a);
            for (int i11 = 0; i11 < g(); i11++) {
                f(i11).p(j11, z11 || zEquals, str, map);
            }
            if (zEquals) {
                f.c(k(str, map));
            }
            for (Map.Entry<String, vh.b.C0875b> entry2 : map.entrySet()) {
                this.f14890l.put(entry2.getKey(), Integer.valueOf(((CharSequence) com.google.android.exoplayer2.util.a.e(entry2.getValue().e())).length()));
            }
        }
    }
}
