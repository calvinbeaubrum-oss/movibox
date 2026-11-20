package g4;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.common.collect.e0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f65388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Long> f65389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<List<Pair<String, Integer>>, h4.b> f65390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Random f65391d;

    public b() {
        this(new Random());
    }

    public b(Random random) {
        this.f65390c = new HashMap();
        this.f65391d = random;
        this.f65388a = new HashMap();
        this.f65389b = new HashMap();
    }

    public static <T> void b(T t11, long j11, Map<T, Long> map) {
        if (map.containsKey(t11)) {
            j11 = Math.max(j11, ((Long) u0.i(map.get(t11))).longValue());
        }
        map.put(t11, Long.valueOf(j11));
    }

    public static int d(h4.b bVar, h4.b bVar2) {
        int iCompare = Integer.compare(bVar.f66250c, bVar2.f66250c);
        return iCompare != 0 ? iCompare : bVar.f66249b.compareTo(bVar2.f66249b);
    }

    public static int f(List<h4.b> list) {
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < list.size(); i11++) {
            hashSet.add(Integer.valueOf(list.get(i11).f66250c));
        }
        return hashSet.size();
    }

    public static <T> void h(long j11, Map<T, Long> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<T, Long> entry : map.entrySet()) {
            if (entry.getValue().longValue() <= j11) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            map.remove(arrayList.get(i11));
        }
    }

    public final List<h4.b> c(List<h4.b> list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        h(jElapsedRealtime, this.f65388a);
        h(jElapsedRealtime, this.f65389b);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            h4.b bVar = list.get(i11);
            if (!this.f65388a.containsKey(bVar.f66249b) && !this.f65389b.containsKey(Integer.valueOf(bVar.f66250c))) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void e(h4.b bVar, long j11) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j11;
        b(bVar.f66249b, jElapsedRealtime, this.f65388a);
        int i11 = bVar.f66250c;
        if (i11 != Integer.MIN_VALUE) {
            b(Integer.valueOf(i11), jElapsedRealtime, this.f65389b);
        }
    }

    public int g(List<h4.b> list) {
        HashSet hashSet = new HashSet();
        List<h4.b> listC = c(list);
        for (int i11 = 0; i11 < listC.size(); i11++) {
            hashSet.add(Integer.valueOf(listC.get(i11).f66250c));
        }
        return hashSet.size();
    }

    public void i() {
        this.f65388a.clear();
        this.f65389b.clear();
        this.f65390c.clear();
    }

    @Nullable
    public h4.b j(List<h4.b> list) {
        List<h4.b> listC = c(list);
        if (listC.size() < 2) {
            return (h4.b) e0.f(listC, null);
        }
        Collections.sort(listC, new Comparator() { // from class: g4.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return b.d((h4.b) obj, (h4.b) obj2);
            }
        });
        ArrayList arrayList = new ArrayList();
        int i11 = listC.get(0).f66250c;
        for (int i12 = 0; i12 < listC.size(); i12++) {
            h4.b bVar = listC.get(i12);
            if (i11 != bVar.f66250c) {
                if (arrayList.size() != 1) {
                    break;
                }
                return listC.get(0);
            }
            arrayList.add(new Pair(bVar.f66249b, Integer.valueOf(bVar.f66251d)));
        }
        h4.b bVar2 = this.f65390c.get(arrayList);
        if (bVar2 != null) {
            return bVar2;
        }
        h4.b bVarK = k(listC.subList(0, arrayList.size()));
        this.f65390c.put(arrayList, bVarK);
        return bVarK;
    }

    public final h4.b k(List<h4.b> list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            i11 += list.get(i12).f66251d;
        }
        int iNextInt = this.f65391d.nextInt(i11);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            h4.b bVar = list.get(i14);
            i13 += bVar.f66251d;
            if (iNextInt < i13) {
                return bVar;
            }
        }
        return (h4.b) e0.g(list);
    }
}
