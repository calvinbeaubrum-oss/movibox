package e20;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseBooleanArray f63788a = new SparseBooleanArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SparseArray<Float> f63789b = new SparseArray<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f63790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f63791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f63792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f63793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f63794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f63795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f63796i;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onDeselected(int i11, int i12);

        void onEnter(int i11, int i12, float f11, boolean z11);

        void onLeave(int i11, int i12, float f11, boolean z11);

        void onSelected(int i11, int i12);
    }

    public final void a(int i11) {
        a aVar = this.f63796i;
        if (aVar != null) {
            aVar.onDeselected(i11, this.f63790c);
        }
        this.f63788a.put(i11, true);
    }

    public final void b(int i11, float f11, boolean z11, boolean z12) {
        if (this.f63795h || i11 == this.f63791d || this.f63794g == 1 || z12) {
            a aVar = this.f63796i;
            if (aVar != null) {
                aVar.onEnter(i11, this.f63790c, f11, z11);
            }
            this.f63789b.put(i11, Float.valueOf(1.0f - f11));
        }
    }

    public final void c(int i11, float f11, boolean z11, boolean z12) {
        if (!this.f63795h && i11 != this.f63792e && this.f63794g != 1) {
            int i12 = this.f63791d;
            if (((i11 != i12 - 1 && i11 != i12 + 1) || this.f63789b.get(i11, Float.valueOf(0.0f)).floatValue() == 1.0f) && !z12) {
                return;
            }
        }
        a aVar = this.f63796i;
        if (aVar != null) {
            aVar.onLeave(i11, this.f63790c, f11, z11);
        }
        this.f63789b.put(i11, Float.valueOf(f11));
    }

    public final void d(int i11) {
        a aVar = this.f63796i;
        if (aVar != null) {
            aVar.onSelected(i11, this.f63790c);
        }
        this.f63788a.put(i11, false);
    }

    public int e() {
        return this.f63791d;
    }

    public int f() {
        return this.f63794g;
    }

    public int g() {
        return this.f63790c;
    }

    public void h(int i11) {
        this.f63794g = i11;
    }

    public void i(int i11, float f11, int i12) {
        boolean z11;
        float f12 = i11 + f11;
        float f13 = this.f63793f;
        boolean z12 = f13 <= f12;
        if (this.f63794g == 0) {
            for (int i13 = 0; i13 < this.f63790c; i13++) {
                if (i13 != this.f63791d) {
                    if (!this.f63788a.get(i13)) {
                        a(i13);
                    }
                    if (this.f63789b.get(i13, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                        c(i13, 1.0f, false, true);
                    }
                }
            }
            b(this.f63791d, 1.0f, false, true);
            d(this.f63791d);
        } else {
            if (f12 == f13) {
                return;
            }
            int i14 = i11 + 1;
            if (f11 == 0.0f && z12) {
                i14 = i11 - 1;
                z11 = false;
            } else {
                z11 = true;
            }
            for (int i15 = 0; i15 < this.f63790c; i15++) {
                if (i15 != i11 && i15 != i14 && this.f63789b.get(i15, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                    c(i15, 1.0f, z12, true);
                }
            }
            if (!z11) {
                float f14 = 1.0f - f11;
                c(i14, f14, true, false);
                b(i11, f14, true, false);
            } else if (z12) {
                c(i11, f11, true, false);
                b(i14, f11, true, false);
            } else {
                float f15 = 1.0f - f11;
                c(i14, f15, false, false);
                b(i11, f15, false, false);
            }
        }
        this.f63793f = f12;
    }

    public void j(int i11) {
        this.f63792e = this.f63791d;
        this.f63791d = i11;
        d(i11);
        for (int i12 = 0; i12 < this.f63790c; i12++) {
            if (i12 != this.f63791d && !this.f63788a.get(i12)) {
                a(i12);
            }
        }
    }

    public void k(a aVar) {
        this.f63796i = aVar;
    }

    public void l(boolean z11) {
        this.f63795h = z11;
    }

    public void m(int i11) {
        this.f63790c = i11;
        this.f63788a.clear();
        this.f63789b.clear();
    }
}
