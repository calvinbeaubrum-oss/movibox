package qh;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.e0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f74780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Long> f74781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<List<Pair<String, Integer>>, rh.b> f74782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Random f74783d;

    public b() {
        this(new Random());
    }

    public b(Random random) {
        this.f74782c = new HashMap();
        this.f74783d = random;
        this.f74780a = new HashMap();
        this.f74781b = new HashMap();
    }

    public static <T> void b(T t11, long j11, Map<T, Long> map) {
        if (map.containsKey(t11)) {
            j11 = Math.max(j11, ((Long) o0.j(map.get(t11))).longValue());
        }
        map.put(t11, Long.valueOf(j11));
    }

    public static int d(rh.b bVar, rh.b bVar2) {
        int iCompare = Integer.compare(bVar.f75392c, bVar2.f75392c);
        return iCompare != 0 ? iCompare : bVar.f75391b.compareTo(bVar2.f75391b);
    }

    public static int f(List<rh.b> list) {
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < list.size(); i11++) {
            hashSet.add(Integer.valueOf(list.get(i11).f75392c));
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

    public final List<rh.b> c(List<rh.b> list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        h(jElapsedRealtime, this.f74780a);
        h(jElapsedRealtime, this.f74781b);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            rh.b bVar = list.get(i11);
            if (!this.f74780a.containsKey(bVar.f75391b) && !this.f74781b.containsKey(Integer.valueOf(bVar.f75392c))) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void e(rh.b bVar, long j11) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j11;
        b(bVar.f75391b, jElapsedRealtime, this.f74780a);
        int i11 = bVar.f75392c;
        if (i11 != Integer.MIN_VALUE) {
            b(Integer.valueOf(i11), jElapsedRealtime, this.f74781b);
        }
    }

    public int g(List<rh.b> list) {
        HashSet hashSet = new HashSet();
        List<rh.b> listC = c(list);
        for (int i11 = 0; i11 < listC.size(); i11++) {
            hashSet.add(Integer.valueOf(listC.get(i11).f75392c));
        }
        return hashSet.size();
    }

    public void i() {
        this.f74780a.clear();
        this.f74781b.clear();
        this.f74782c.clear();
    }

    @Nullable
    public rh.b j(List<rh.b> list) {
        List<rh.b> listC = c(list);
        if (listC.size() < 2) {
            return (rh.b) e0.f(listC, null);
        }
        Collections.sort(listC, new Comparator() { // from class: qh.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return b.d((rh.b) obj, (rh.b) obj2);
            }
        });
        ArrayList arrayList = new ArrayList();
        int i11 = listC.get(0).f75392c;
        for (int i12 = 0; i12 < listC.size(); i12++) {
            rh.b bVar = listC.get(i12);
            if (i11 != bVar.f75392c) {
                if (arrayList.size() != 1) {
                    break;
                }
                return listC.get(0);
            }
            arrayList.add(new Pair(bVar.f75391b, Integer.valueOf(bVar.f75393d)));
        }
        rh.b bVar2 = this.f74782c.get(arrayList);
        if (bVar2 != null) {
            return bVar2;
        }
        rh.b bVarK = k(listC.subList(0, arrayList.size()));
        this.f74782c.put(arrayList, bVarK);
        return bVarK;
    }

    public final rh.b k(List<rh.b> list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            i11 += list.get(i12).f75393d;
        }
        int iNextInt = this.f74783d.nextInt(i11);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            rh.b bVar = list.get(i14);
            i13 += bVar.f75393d;
            if (iNextInt < i13) {
                return bVar;
            }
        }
        return (rh.b) e0.g(list);
    }
}
