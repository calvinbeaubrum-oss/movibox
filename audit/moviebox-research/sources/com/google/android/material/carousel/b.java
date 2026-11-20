package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f36488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f36489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f36490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f36491d;

    /* JADX INFO: renamed from: com.google.android.material.carousel.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0379b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f36492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f36493b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f36495d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f36496e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<c> f36494c = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f36497f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f36498g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f36499h = 0.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f36500i = -1;

        public C0379b(float f11, float f12) {
            this.f36492a = f11;
            this.f36493b = f12;
        }

        public static float j(float f11, float f12, int i11, int i12) {
            return (f11 - (i11 * f12)) + (i12 * f12);
        }

        @NonNull
        public C0379b a(float f11, float f12, float f13) {
            return d(f11, f12, f13, false, true);
        }

        @NonNull
        public C0379b b(float f11, float f12, float f13) {
            return c(f11, f12, f13, false);
        }

        @NonNull
        public C0379b c(float f11, float f12, float f13, boolean z11) {
            return d(f11, f12, f13, z11, false);
        }

        @NonNull
        public C0379b d(float f11, float f12, float f13, boolean z11, boolean z12) {
            float f14;
            float fAbs;
            float f15 = f13 / 2.0f;
            float f16 = f11 - f15;
            float f17 = f15 + f11;
            float f18 = this.f36493b;
            if (f17 <= f18) {
                if (f16 < 0.0f) {
                    fAbs = Math.abs(f16 - Math.min(f16 + f13, 0.0f));
                } else {
                    f14 = 0.0f;
                }
                return e(f11, f12, f13, z11, z12, f14);
            }
            fAbs = Math.abs(f17 - Math.max(f17 - f13, f18));
            f14 = fAbs;
            return e(f11, f12, f13, z11, z12, f14);
        }

        @NonNull
        public C0379b e(float f11, float f12, float f13, boolean z11, boolean z12, float f14) {
            return f(f11, f12, f13, z11, z12, f14, 0.0f, 0.0f);
        }

        @NonNull
        public C0379b f(float f11, float f12, float f13, boolean z11, boolean z12, float f14, float f15, float f16) {
            if (f13 <= 0.0f) {
                return this;
            }
            if (z12) {
                if (z11) {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
                int i11 = this.f36500i;
                if (i11 != -1 && i11 != 0) {
                    throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                }
                this.f36500i = this.f36494c.size();
            }
            c cVar = new c(Float.MIN_VALUE, f11, f12, f13, z12, f14, f15, f16);
            if (z11) {
                if (this.f36495d == null) {
                    this.f36495d = cVar;
                    this.f36497f = this.f36494c.size();
                }
                if (this.f36498g != -1 && this.f36494c.size() - this.f36498g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f13 != this.f36495d.f36504d) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.f36496e = cVar;
                this.f36498g = this.f36494c.size();
            } else {
                if (this.f36495d == null && cVar.f36504d < this.f36499h) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.f36496e != null && cVar.f36504d > this.f36499h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.f36499h = cVar.f36504d;
            this.f36494c.add(cVar);
            return this;
        }

        @NonNull
        public C0379b g(float f11, float f12, float f13, int i11) {
            return h(f11, f12, f13, i11, false);
        }

        @NonNull
        public C0379b h(float f11, float f12, float f13, int i11, boolean z11) {
            if (i11 > 0 && f13 > 0.0f) {
                for (int i12 = 0; i12 < i11; i12++) {
                    c((i12 * f13) + f11, f12, f13, z11);
                }
            }
            return this;
        }

        @NonNull
        public b i() {
            if (this.f36495d == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < this.f36494c.size(); i11++) {
                c cVar = this.f36494c.get(i11);
                arrayList.add(new c(j(this.f36495d.f36502b, this.f36492a, this.f36497f, i11), cVar.f36502b, cVar.f36503c, cVar.f36504d, cVar.f36505e, cVar.f36506f, cVar.f36507g, cVar.f36508h));
            }
            return new b(this.f36492a, arrayList, this.f36497f, this.f36498g);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f36501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f36502b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f36503c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f36504d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f36505e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f36506f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f36507g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f36508h;

        public c(float f11, float f12, float f13, float f14) {
            this(f11, f12, f13, f14, false, 0.0f, 0.0f, 0.0f);
        }

        public c(float f11, float f12, float f13, float f14, boolean z11, float f15, float f16, float f17) {
            this.f36501a = f11;
            this.f36502b = f12;
            this.f36503c = f13;
            this.f36504d = f14;
            this.f36505e = z11;
            this.f36506f = f15;
            this.f36507g = f16;
            this.f36508h = f17;
        }

        public static c a(c cVar, c cVar2, float f11) {
            return new c(ii.b.a(cVar.f36501a, cVar2.f36501a, f11), ii.b.a(cVar.f36502b, cVar2.f36502b, f11), ii.b.a(cVar.f36503c, cVar2.f36503c, f11), ii.b.a(cVar.f36504d, cVar2.f36504d, f11));
        }
    }

    public b(float f11, List<c> list, int i11, int i12) {
        this.f36488a = f11;
        this.f36489b = Collections.unmodifiableList(list);
        this.f36490c = i11;
        this.f36491d = i12;
    }

    public static b m(b bVar, b bVar2, float f11) {
        if (bVar.f() != bVar2.f()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List<c> listG = bVar.g();
        List<c> listG2 = bVar2.g();
        if (listG.size() != listG2.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < bVar.g().size(); i11++) {
            arrayList.add(c.a(listG.get(i11), listG2.get(i11), f11));
        }
        return new b(bVar.f(), arrayList, ii.b.c(bVar.b(), bVar2.b(), f11), ii.b.c(bVar.i(), bVar2.i(), f11));
    }

    public static b n(b bVar, float f11) {
        C0379b c0379b = new C0379b(bVar.f(), f11);
        float f12 = (f11 - bVar.j().f36502b) - (bVar.j().f36504d / 2.0f);
        int size = bVar.g().size() - 1;
        while (size >= 0) {
            c cVar = bVar.g().get(size);
            c0379b.d(f12 + (cVar.f36504d / 2.0f), cVar.f36503c, cVar.f36504d, size >= bVar.b() && size <= bVar.i(), cVar.f36505e);
            f12 += cVar.f36504d;
            size--;
        }
        return c0379b.i();
    }

    public c a() {
        return this.f36489b.get(this.f36490c);
    }

    public int b() {
        return this.f36490c;
    }

    public c c() {
        return this.f36489b.get(0);
    }

    @Nullable
    public c d() {
        for (int i11 = 0; i11 < this.f36489b.size(); i11++) {
            c cVar = this.f36489b.get(i11);
            if (!cVar.f36505e) {
                return cVar;
            }
        }
        return null;
    }

    public List<c> e() {
        return this.f36489b.subList(this.f36490c, this.f36491d + 1);
    }

    public float f() {
        return this.f36488a;
    }

    public List<c> g() {
        return this.f36489b;
    }

    public c h() {
        return this.f36489b.get(this.f36491d);
    }

    public int i() {
        return this.f36491d;
    }

    public c j() {
        List<c> list = this.f36489b;
        return list.get(list.size() - 1);
    }

    @Nullable
    public c k() {
        for (int size = this.f36489b.size() - 1; size >= 0; size--) {
            c cVar = this.f36489b.get(size);
            if (!cVar.f36505e) {
                return cVar;
            }
        }
        return null;
    }

    public int l() {
        Iterator<c> it = this.f36489b.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            if (it.next().f36505e) {
                i11++;
            }
        }
        return this.f36489b.size() - i11;
    }
}
