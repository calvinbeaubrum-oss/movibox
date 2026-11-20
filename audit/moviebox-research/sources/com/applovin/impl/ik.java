package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ik {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Comparator f19733h = new Comparator() { // from class: com.applovin.impl.py
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ik.a((ik.b) obj, (ik.b) obj2);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Comparator f19734i = new Comparator() { // from class: com.applovin.impl.qy
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ik.b((ik.b) obj, (ik.b) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19735a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19741g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b[] f19737c = new b[5];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f19736b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f19738d = -1;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f19744c;

        private b() {
        }
    }

    public ik(int i11) {
        this.f19735a = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(b bVar, b bVar2) {
        return bVar.f19742a - bVar2.f19742a;
    }

    private void a() {
        if (this.f19738d != 1) {
            Collections.sort(this.f19736b, f19733h);
            this.f19738d = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(b bVar, b bVar2) {
        return Float.compare(bVar.f19744c, bVar2.f19744c);
    }

    private void b() {
        if (this.f19738d != 0) {
            Collections.sort(this.f19736b, f19734i);
            this.f19738d = 0;
        }
    }

    public float a(float f11) {
        b();
        float f12 = f11 * this.f19740f;
        int i11 = 0;
        for (int i12 = 0; i12 < this.f19736b.size(); i12++) {
            b bVar = (b) this.f19736b.get(i12);
            i11 += bVar.f19743b;
            if (i11 >= f12) {
                return bVar.f19744c;
            }
        }
        if (this.f19736b.isEmpty()) {
            return Float.NaN;
        }
        ArrayList arrayList = this.f19736b;
        return ((b) arrayList.get(arrayList.size() - 1)).f19744c;
    }

    public void a(int i11, float f11) {
        b bVar;
        a();
        int i12 = this.f19741g;
        if (i12 > 0) {
            b[] bVarArr = this.f19737c;
            int i13 = i12 - 1;
            this.f19741g = i13;
            bVar = bVarArr[i13];
        } else {
            bVar = new b();
        }
        int i14 = this.f19739e;
        this.f19739e = i14 + 1;
        bVar.f19742a = i14;
        bVar.f19743b = i11;
        bVar.f19744c = f11;
        this.f19736b.add(bVar);
        this.f19740f += i11;
        while (true) {
            int i15 = this.f19740f;
            int i16 = this.f19735a;
            if (i15 <= i16) {
                return;
            }
            int i17 = i15 - i16;
            b bVar2 = (b) this.f19736b.get(0);
            int i18 = bVar2.f19743b;
            if (i18 <= i17) {
                this.f19740f -= i18;
                this.f19736b.remove(0);
                int i19 = this.f19741g;
                if (i19 < 5) {
                    b[] bVarArr2 = this.f19737c;
                    this.f19741g = i19 + 1;
                    bVarArr2[i19] = bVar2;
                }
            } else {
                bVar2.f19743b = i18 - i17;
                this.f19740f -= i17;
            }
        }
    }

    public void c() {
        this.f19736b.clear();
        this.f19738d = -1;
        this.f19739e = 0;
        this.f19740f = 0;
    }
}
