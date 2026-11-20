package com.applovin.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class sh extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f22902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f22903h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f22904i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f22905j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final fo[] f22906k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object[] f22907l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final HashMap f22908m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sh(Collection collection, wj wjVar) {
        super(false, wjVar);
        int iB = 0;
        int size = collection.size();
        this.f22904i = new int[size];
        this.f22905j = new int[size];
        this.f22906k = new fo[size];
        this.f22907l = new Object[size];
        this.f22908m = new HashMap();
        Iterator it = collection.iterator();
        int iA = 0;
        int i11 = 0;
        while (it.hasNext()) {
            ee eeVar = (ee) it.next();
            this.f22906k[i11] = eeVar.b();
            this.f22905j[i11] = iB;
            this.f22904i[i11] = iA;
            iB += this.f22906k[i11].b();
            iA += this.f22906k[i11].a();
            this.f22907l[i11] = eeVar.a();
            this.f22908m.put(this.f22907l[i11], Integer.valueOf(i11));
            i11++;
        }
        this.f22902g = iB;
        this.f22903h = iA;
    }

    @Override // com.applovin.impl.fo
    public int a() {
        return this.f22903h;
    }

    @Override // com.applovin.impl.fo
    public int b() {
        return this.f22902g;
    }

    @Override // com.applovin.impl.b
    public int b(Object obj) {
        Integer num = (Integer) this.f22908m.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.applovin.impl.b
    public int d(int i11) {
        return xp.a(this.f22904i, i11 + 1, false, false);
    }

    public List d() {
        return Arrays.asList(this.f22906k);
    }

    @Override // com.applovin.impl.b
    public int e(int i11) {
        return xp.a(this.f22905j, i11 + 1, false, false);
    }

    @Override // com.applovin.impl.b
    public Object f(int i11) {
        return this.f22907l[i11];
    }

    @Override // com.applovin.impl.b
    public int g(int i11) {
        return this.f22904i[i11];
    }

    @Override // com.applovin.impl.b
    public int h(int i11) {
        return this.f22905j[i11];
    }

    @Override // com.applovin.impl.b
    public fo i(int i11) {
        return this.f22906k[i11];
    }
}
