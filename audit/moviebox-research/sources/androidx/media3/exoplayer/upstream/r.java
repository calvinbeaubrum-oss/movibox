package androidx.media3.exoplayer.upstream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Comparator<b> f11506h = new Comparator() { // from class: androidx.media3.exoplayer.upstream.p
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return r.g((r.b) obj, (r.b) obj2);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Comparator<b> f11507i = new Comparator() { // from class: androidx.media3.exoplayer.upstream.q
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return r.h((r.b) obj, (r.b) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11508a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11514g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b[] f11510c = new b[5];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f11509b = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11511d = -1;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f11517c;

        public b() {
        }
    }

    public r(int i11) {
        this.f11508a = i11;
    }

    public static /* synthetic */ int g(b bVar, b bVar2) {
        return bVar.f11515a - bVar2.f11515a;
    }

    public static /* synthetic */ int h(b bVar, b bVar2) {
        return Float.compare(bVar.f11517c, bVar2.f11517c);
    }

    public void c(int i11, float f11) {
        b bVar;
        d();
        int i12 = this.f11514g;
        if (i12 > 0) {
            b[] bVarArr = this.f11510c;
            int i13 = i12 - 1;
            this.f11514g = i13;
            bVar = bVarArr[i13];
        } else {
            bVar = new b();
        }
        int i14 = this.f11512e;
        this.f11512e = i14 + 1;
        bVar.f11515a = i14;
        bVar.f11516b = i11;
        bVar.f11517c = f11;
        this.f11509b.add(bVar);
        this.f11513f += i11;
        while (true) {
            int i15 = this.f11513f;
            int i16 = this.f11508a;
            if (i15 <= i16) {
                return;
            }
            int i17 = i15 - i16;
            b bVar2 = this.f11509b.get(0);
            int i18 = bVar2.f11516b;
            if (i18 <= i17) {
                this.f11513f -= i18;
                this.f11509b.remove(0);
                int i19 = this.f11514g;
                if (i19 < 5) {
                    b[] bVarArr2 = this.f11510c;
                    this.f11514g = i19 + 1;
                    bVarArr2[i19] = bVar2;
                }
            } else {
                bVar2.f11516b = i18 - i17;
                this.f11513f -= i17;
            }
        }
    }

    public final void d() {
        if (this.f11511d != 1) {
            Collections.sort(this.f11509b, f11506h);
            this.f11511d = 1;
        }
    }

    public final void e() {
        if (this.f11511d != 0) {
            Collections.sort(this.f11509b, f11507i);
            this.f11511d = 0;
        }
    }

    public float f(float f11) {
        e();
        float f12 = f11 * this.f11513f;
        int i11 = 0;
        for (int i12 = 0; i12 < this.f11509b.size(); i12++) {
            b bVar = this.f11509b.get(i12);
            i11 += bVar.f11516b;
            if (i11 >= f12) {
                return bVar.f11517c;
            }
        }
        if (this.f11509b.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<b> arrayList = this.f11509b;
        return arrayList.get(arrayList.size() - 1).f11517c;
    }

    public void i() {
        this.f11509b.clear();
        this.f11511d = -1;
        this.f11512e = 0;
        this.f11513f = 0;
    }
}
