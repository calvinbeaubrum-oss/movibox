package com.google.android.exoplayer2.upstream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class h0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Comparator<b> f35396h = new Comparator() { // from class: com.google.android.exoplayer2.upstream.f0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return h0.g((h0.b) obj, (h0.b) obj2);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Comparator<b> f35397i = new Comparator() { // from class: com.google.android.exoplayer2.upstream.g0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return h0.h((h0.b) obj, (h0.b) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35398a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f35402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f35404g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b[] f35400c = new b[5];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f35399b = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f35401d = -1;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f35405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f35406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f35407c;

        public b() {
        }
    }

    public h0(int i11) {
        this.f35398a = i11;
    }

    public static /* synthetic */ int g(b bVar, b bVar2) {
        return bVar.f35405a - bVar2.f35405a;
    }

    public static /* synthetic */ int h(b bVar, b bVar2) {
        return Float.compare(bVar.f35407c, bVar2.f35407c);
    }

    public void c(int i11, float f11) {
        b bVar;
        d();
        int i12 = this.f35404g;
        if (i12 > 0) {
            b[] bVarArr = this.f35400c;
            int i13 = i12 - 1;
            this.f35404g = i13;
            bVar = bVarArr[i13];
        } else {
            bVar = new b();
        }
        int i14 = this.f35402e;
        this.f35402e = i14 + 1;
        bVar.f35405a = i14;
        bVar.f35406b = i11;
        bVar.f35407c = f11;
        this.f35399b.add(bVar);
        this.f35403f += i11;
        while (true) {
            int i15 = this.f35403f;
            int i16 = this.f35398a;
            if (i15 <= i16) {
                return;
            }
            int i17 = i15 - i16;
            b bVar2 = this.f35399b.get(0);
            int i18 = bVar2.f35406b;
            if (i18 <= i17) {
                this.f35403f -= i18;
                this.f35399b.remove(0);
                int i19 = this.f35404g;
                if (i19 < 5) {
                    b[] bVarArr2 = this.f35400c;
                    this.f35404g = i19 + 1;
                    bVarArr2[i19] = bVar2;
                }
            } else {
                bVar2.f35406b = i18 - i17;
                this.f35403f -= i17;
            }
        }
    }

    public final void d() {
        if (this.f35401d != 1) {
            Collections.sort(this.f35399b, f35396h);
            this.f35401d = 1;
        }
    }

    public final void e() {
        if (this.f35401d != 0) {
            Collections.sort(this.f35399b, f35397i);
            this.f35401d = 0;
        }
    }

    public float f(float f11) {
        e();
        float f12 = f11 * this.f35403f;
        int i11 = 0;
        for (int i12 = 0; i12 < this.f35399b.size(); i12++) {
            b bVar = this.f35399b.get(i12);
            i11 += bVar.f35406b;
            if (i11 >= f12) {
                return bVar.f35407c;
            }
        }
        if (this.f35399b.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<b> arrayList = this.f35399b;
        return arrayList.get(arrayList.size() - 1).f35407c;
    }

    public void i() {
        this.f35399b.clear();
        this.f35401d = -1;
        this.f35402e = 0;
        this.f35403f = 0;
    }
}
