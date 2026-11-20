package com.applovin.impl;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacerSettings;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vg f24830a = new vg();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TreeSet f24831b = new TreeSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f24832c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f24833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f24834e;

    public zc(MaxAdPlacerSettings maxAdPlacerSettings) {
        a(maxAdPlacerSettings);
    }

    private int a(int i11, boolean z11) {
        int iC = this.f24830a.c(Integer.valueOf(i11));
        if (!z11) {
            int i12 = i11 + iC;
            while (iC < this.f24830a.size() && i12 >= ((Integer) this.f24830a.a(iC)).intValue()) {
                i12++;
                iC++;
            }
        }
        return iC;
    }

    private void a(int i11, int i12) {
        if (this.f24832c.containsKey(Integer.valueOf(i11))) {
            this.f24832c.put(Integer.valueOf(i12), (MaxAd) this.f24832c.get(Integer.valueOf(i11)));
            this.f24831b.add(Integer.valueOf(i12));
            this.f24832c.remove(Integer.valueOf(i11));
            this.f24831b.remove(Integer.valueOf(i11));
        }
    }

    private void a(MaxAdPlacerSettings maxAdPlacerSettings) {
        if (!maxAdPlacerSettings.hasValidPositioning()) {
            com.applovin.impl.sdk.n.h("MaxAdPlacerData", "No positioning info was provided with ad placer settings. You must set at least (1) one or more fixed positions or (2) a repeating interval greater than or equal to 2 for the ad placer to determine where to position ads.");
            return;
        }
        this.f24830a.addAll(maxAdPlacerSettings.getFixedPositions());
        if (!maxAdPlacerSettings.isRepeatingEnabled()) {
            return;
        }
        int repeatingInterval = maxAdPlacerSettings.getRepeatingInterval();
        if (this.f24830a.isEmpty()) {
            this.f24830a.add(Integer.valueOf(repeatingInterval - 1));
        }
        int iIntValue = ((Integer) this.f24830a.a()).intValue();
        while (true) {
            iIntValue += repeatingInterval;
            if (this.f24830a.size() >= maxAdPlacerSettings.getMaxAdCount()) {
                return;
            } else {
                this.f24830a.add(Integer.valueOf(iIntValue));
            }
        }
    }

    public MaxAd a(int i11) {
        return (MaxAd) this.f24832c.get(Integer.valueOf(i11));
    }

    public void a() {
        this.f24832c.clear();
        this.f24831b.clear();
    }

    public void a(MaxAd maxAd, int i11) {
        this.f24832c.put(Integer.valueOf(i11), maxAd);
        this.f24831b.add(Integer.valueOf(i11));
    }

    public void a(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            this.f24832c.remove(num);
            this.f24831b.remove(num);
        }
    }

    public int b(int i11) {
        if (i11 == 0) {
            return 0;
        }
        return i11 + a(i11 - 1, false);
    }

    public Collection b() {
        return new TreeSet((SortedSet) this.f24831b);
    }

    public void b(int i11, int i12) {
        i(i11);
        f(i12);
    }

    public int c() {
        int i11 = this.f24833d;
        if (i11 != -1 && this.f24834e != -1) {
            while (i11 <= this.f24834e) {
                if (g(i11) && !h(i11)) {
                    return i11;
                }
                i11++;
            }
        }
        return -1;
    }

    public int c(int i11) {
        return i11 + a(i11, false);
    }

    public void c(int i11, int i12) {
        this.f24833d = i11;
        this.f24834e = i12;
    }

    public int d(int i11) {
        if (g(i11)) {
            return -1;
        }
        return i11 - a(i11, true);
    }

    public Collection e(int i11) {
        return new TreeSet((SortedSet) this.f24831b.tailSet(Integer.valueOf(i11), false));
    }

    public void f(int i11) {
        int iB = this.f24830a.b(Integer.valueOf(i11));
        for (int size = this.f24830a.size() - 1; size >= iB; size--) {
            Integer num = (Integer) this.f24830a.a(size);
            int iIntValue = num.intValue() + 1;
            a(num.intValue(), iIntValue);
            this.f24830a.a(size, Integer.valueOf(iIntValue));
        }
    }

    public boolean g(int i11) {
        return this.f24830a.contains(Integer.valueOf(i11));
    }

    public boolean h(int i11) {
        return this.f24831b.contains(Integer.valueOf(i11));
    }

    public void i(int i11) {
        int iB = this.f24830a.b(Integer.valueOf(i11));
        if (g(i11)) {
            this.f24832c.remove(Integer.valueOf(i11));
            this.f24831b.remove(Integer.valueOf(i11));
            this.f24830a.b(iB);
        }
        while (iB < this.f24830a.size()) {
            Integer num = (Integer) this.f24830a.a(iB);
            int iIntValue = num.intValue() - 1;
            a(num.intValue(), iIntValue);
            this.f24830a.a(iB, Integer.valueOf(iIntValue));
            iB++;
        }
    }
}
