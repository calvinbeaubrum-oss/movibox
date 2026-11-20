package u5;

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
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f78423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f78424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f78425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f78426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f78427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final g f78428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String[] f78429g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f78430h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f78431i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final c f78432j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap<String, Integer> f78433k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HashMap<String, Integer> f78434l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<c> f78435m;

    public c(@Nullable String str, @Nullable String str2, long j11, long j12, @Nullable g gVar, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable c cVar) {
        this.f78423a = str;
        this.f78424b = str2;
        this.f78431i = str4;
        this.f78428f = gVar;
        this.f78429g = strArr;
        this.f78425c = str2 != null;
        this.f78426d = j11;
        this.f78427e = j12;
        this.f78430h = (String) z3.a.e(str3);
        this.f78432j = cVar;
        this.f78433k = new HashMap<>();
        this.f78434l = new HashMap<>();
    }

    public static c c(@Nullable String str, long j11, long j12, @Nullable g gVar, @Nullable String[] strArr, String str2, @Nullable String str3, @Nullable c cVar) {
        return new c(str, null, j11, j12, gVar, strArr, str2, str3, cVar);
    }

    public static c d(String str) {
        return new c(null, f.b(str), C.TIME_UNSET, C.TIME_UNSET, null, null, "", null, null);
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

    public static SpannableStringBuilder k(String str, Map<String, y3.a.b> map) {
        if (!map.containsKey(str)) {
            y3.a.b bVar = new y3.a.b();
            bVar.o(new SpannableStringBuilder());
            map.put(str, bVar);
        }
        return (SpannableStringBuilder) z3.a.e(map.get(str).e());
    }

    public void a(c cVar) {
        if (this.f78435m == null) {
            this.f78435m = new ArrayList();
        }
        this.f78435m.add(cVar);
    }

    public final void b(Map<String, g> map, y3.a.b bVar, int i11, int i12, int i13) {
        g gVarF = f.f(this.f78428f, this.f78429g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) bVar.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            bVar.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (gVarF != null) {
            f.a(spannableStringBuilder2, i11, i12, gVarF, this.f78432j, map, i13);
            if (TtmlNode.TAG_P.equals(this.f78423a)) {
                if (gVarF.k() != Float.MAX_VALUE) {
                    bVar.m((gVarF.k() * (-90.0f)) / 100.0f);
                }
                if (gVarF.m() != null) {
                    bVar.p(gVarF.m());
                }
                if (gVarF.h() != null) {
                    bVar.j(gVarF.h());
                }
            }
        }
    }

    public c f(int i11) {
        List<c> list = this.f78435m;
        if (list != null) {
            return list.get(i11);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List<c> list = this.f78435m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<y3.a> h(long j11, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        List<Pair<String, String>> arrayList = new ArrayList<>();
        n(j11, this.f78430h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j11, false, this.f78430h, treeMap);
        o(j11, map, map2, this.f78430h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                e eVar = (e) z3.a.e(map2.get(pair.first));
                arrayList2.add(new y3.a.b().f(bitmapDecodeByteArray).k(eVar.f78451b).l(0).h(eVar.f78452c, 0).i(eVar.f78454e).n(eVar.f78455f).g(eVar.f78456g).r(eVar.f78459j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            e eVar2 = (e) z3.a.e(map2.get(entry.getKey()));
            y3.a.b bVar = (y3.a.b) entry.getValue();
            e((SpannableStringBuilder) z3.a.e(bVar.e()));
            bVar.h(eVar2.f78452c, eVar2.f78453d);
            bVar.i(eVar2.f78454e);
            bVar.k(eVar2.f78451b);
            bVar.n(eVar2.f78455f);
            bVar.q(eVar2.f78458i, eVar2.f78457h);
            bVar.r(eVar2.f78459j);
            arrayList2.add(bVar.a());
        }
        return arrayList2;
    }

    public final void i(TreeSet<Long> treeSet, boolean z11) {
        boolean zEquals = TtmlNode.TAG_P.equals(this.f78423a);
        boolean zEquals2 = TtmlNode.TAG_DIV.equals(this.f78423a);
        if (z11 || zEquals || (zEquals2 && this.f78431i != null)) {
            long j11 = this.f78426d;
            if (j11 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j11));
            }
            long j12 = this.f78427e;
            if (j12 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j12));
            }
        }
        if (this.f78435m == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f78435m.size(); i11++) {
            this.f78435m.get(i11).i(treeSet, z11 || zEquals);
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
        return this.f78429g;
    }

    public boolean m(long j11) {
        long j12 = this.f78426d;
        return (j12 == C.TIME_UNSET && this.f78427e == C.TIME_UNSET) || (j12 <= j11 && this.f78427e == C.TIME_UNSET) || ((j12 == C.TIME_UNSET && j11 < this.f78427e) || (j12 <= j11 && j11 < this.f78427e));
    }

    public final void n(long j11, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.f78430h)) {
            str = this.f78430h;
        }
        if (m(j11) && TtmlNode.TAG_DIV.equals(this.f78423a) && this.f78431i != null) {
            list.add(new Pair<>(str, this.f78431i));
            return;
        }
        for (int i11 = 0; i11 < g(); i11++) {
            f(i11).n(j11, str, list);
        }
    }

    public final void o(long j11, Map<String, g> map, Map<String, e> map2, String str, Map<String, y3.a.b> map3) {
        int i11;
        if (m(j11)) {
            String str2 = "".equals(this.f78430h) ? str : this.f78430h;
            Iterator<Map.Entry<String, Integer>> it = this.f78434l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Integer> next = it.next();
                String key = next.getKey();
                int iIntValue = this.f78433k.containsKey(key) ? this.f78433k.get(key).intValue() : 0;
                int iIntValue2 = next.getValue().intValue();
                if (iIntValue != iIntValue2) {
                    b(map, (y3.a.b) z3.a.e(map3.get(key)), iIntValue, iIntValue2, ((e) z3.a.e(map2.get(str2))).f78459j);
                }
            }
            for (i11 = 0; i11 < g(); i11++) {
                f(i11).o(j11, map, map2, str2, map3);
            }
        }
    }

    public final void p(long j11, boolean z11, String str, Map<String, y3.a.b> map) {
        this.f78433k.clear();
        this.f78434l.clear();
        if (TtmlNode.TAG_METADATA.equals(this.f78423a)) {
            return;
        }
        if (!"".equals(this.f78430h)) {
            str = this.f78430h;
        }
        if (this.f78425c && z11) {
            k(str, map).append((CharSequence) z3.a.e(this.f78424b));
            return;
        }
        if (TtmlNode.TAG_BR.equals(this.f78423a) && z11) {
            k(str, map).append('\n');
            return;
        }
        if (m(j11)) {
            for (Map.Entry<String, y3.a.b> entry : map.entrySet()) {
                this.f78433k.put(entry.getKey(), Integer.valueOf(((CharSequence) z3.a.e(entry.getValue().e())).length()));
            }
            boolean zEquals = TtmlNode.TAG_P.equals(this.f78423a);
            for (int i11 = 0; i11 < g(); i11++) {
                f(i11).p(j11, z11 || zEquals, str, map);
            }
            if (zEquals) {
                f.c(k(str, map));
            }
            for (Map.Entry<String, y3.a.b> entry2 : map.entrySet()) {
                this.f78434l.put(entry2.getKey(), Integer.valueOf(((CharSequence) z3.a.e(entry2.getValue().e())).length()));
            }
        }
    }
}
