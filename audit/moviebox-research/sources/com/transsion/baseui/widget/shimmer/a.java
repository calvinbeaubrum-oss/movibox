package com.transsion.baseui.widget.shimmer;

import android.content.res.TypedArray;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import com.transsion.baseui.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f51568a = new float[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f51569b = new int[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f51570c = new RectF();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f51571d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f51572e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f51573f = 1291845631;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f51574g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f51575h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f51576i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f51577j = 1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f51578k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f51579l = 0.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f51580m = 0.5f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f51581n = 20.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f51582o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f51583p = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f51584q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f51585r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f51586s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f51587t = 1000;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f51588u;

    /* JADX INFO: renamed from: com.transsion.baseui.widget.shimmer.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0559a extends b<C0559a> {
        public C0559a() {
            this.f51589a.f51584q = true;
        }

        @Override // com.transsion.baseui.widget.shimmer.a.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public C0559a d() {
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b<T extends b<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f51589a = new a();

        public static float b(float f11, float f12, float f13) {
            return Math.min(f12, Math.max(f11, f13));
        }

        public a a() {
            this.f51589a.b();
            this.f51589a.c();
            return this.f51589a;
        }

        public T c(TypedArray typedArray) {
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_clip_to_children)) {
                g(typedArray.getBoolean(R$styleable.ShimmerFrameLayout_shimmer_clip_to_children, this.f51589a.f51582o));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_auto_start)) {
                e(typedArray.getBoolean(R$styleable.ShimmerFrameLayout_shimmer_auto_start, this.f51589a.f51583p));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_base_alpha)) {
                f(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_base_alpha, 0.3f));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_highlight_alpha)) {
                n(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_highlight_alpha, 1.0f));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_duration)) {
                j(typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_duration, (int) this.f51589a.f51587t));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_repeat_count)) {
                p(typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_repeat_count, this.f51589a.f51585r));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_repeat_delay)) {
                q(typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_repeat_delay, (int) this.f51589a.f51588u));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_repeat_mode)) {
                r(typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_repeat_mode, this.f51589a.f51586s));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_direction)) {
                int i11 = typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_direction, this.f51589a.f51571d);
                if (i11 == 1) {
                    h(1);
                } else if (i11 == 2) {
                    h(2);
                } else if (i11 != 3) {
                    h(0);
                } else {
                    h(3);
                }
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_shape)) {
                if (typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_shape, this.f51589a.f51574g) != 1) {
                    s(0);
                } else {
                    s(1);
                }
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_dropoff)) {
                i(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_dropoff, this.f51589a.f51580m));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_fixed_width)) {
                l(typedArray.getDimensionPixelSize(R$styleable.ShimmerFrameLayout_shimmer_fixed_width, this.f51589a.f51575h));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_fixed_height)) {
                k(typedArray.getDimensionPixelSize(R$styleable.ShimmerFrameLayout_shimmer_fixed_height, this.f51589a.f51576i));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_intensity)) {
                o(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_intensity, this.f51589a.f51579l));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_width_ratio)) {
                u(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_width_ratio, this.f51589a.f51577j));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_height_ratio)) {
                m(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_height_ratio, this.f51589a.f51578k));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_tilt)) {
                t(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_tilt, this.f51589a.f51581n));
            }
            return (T) d();
        }

        public abstract T d();

        public T e(boolean z11) {
            this.f51589a.f51583p = z11;
            return (T) d();
        }

        public T f(float f11) {
            int iB = (int) (b(0.0f, 1.0f, f11) * 255.0f);
            a aVar = this.f51589a;
            aVar.f51573f = (iB << 24) | (aVar.f51573f & 16777215);
            return (T) d();
        }

        public T g(boolean z11) {
            this.f51589a.f51582o = z11;
            return (T) d();
        }

        public T h(int i11) {
            this.f51589a.f51571d = i11;
            return (T) d();
        }

        public T i(float f11) {
            if (f11 >= 0.0f) {
                this.f51589a.f51580m = f11;
                return (T) d();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f11);
        }

        public T j(long j11) {
            if (j11 >= 0) {
                this.f51589a.f51587t = j11;
                return (T) d();
            }
            throw new IllegalArgumentException("Given a negative duration: " + j11);
        }

        public T k(int i11) {
            if (i11 >= 0) {
                this.f51589a.f51576i = i11;
                return (T) d();
            }
            throw new IllegalArgumentException("Given invalid height: " + i11);
        }

        public T l(int i11) {
            if (i11 >= 0) {
                this.f51589a.f51575h = i11;
                return (T) d();
            }
            throw new IllegalArgumentException("Given invalid width: " + i11);
        }

        public T m(float f11) {
            if (f11 >= 0.0f) {
                this.f51589a.f51578k = f11;
                return (T) d();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f11);
        }

        public T n(float f11) {
            int iB = (int) (b(0.0f, 1.0f, f11) * 255.0f);
            a aVar = this.f51589a;
            aVar.f51572e = (iB << 24) | (aVar.f51572e & 16777215);
            return (T) d();
        }

        public T o(float f11) {
            if (f11 >= 0.0f) {
                this.f51589a.f51579l = f11;
                return (T) d();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f11);
        }

        public T p(int i11) {
            this.f51589a.f51585r = i11;
            return (T) d();
        }

        public T q(long j11) {
            if (j11 >= 0) {
                this.f51589a.f51588u = j11;
                return (T) d();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j11);
        }

        public T r(int i11) {
            this.f51589a.f51586s = i11;
            return (T) d();
        }

        public T s(int i11) {
            this.f51589a.f51574g = i11;
            return (T) d();
        }

        public T t(float f11) {
            this.f51589a.f51581n = f11;
            return (T) d();
        }

        public T u(float f11) {
            if (f11 >= 0.0f) {
                this.f51589a.f51577j = f11;
                return (T) d();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends b<c> {
        public c() {
            this.f51589a.f51584q = false;
        }

        @Override // com.transsion.baseui.widget.shimmer.a.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public c c(TypedArray typedArray) {
            super.c(typedArray);
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_base_color)) {
                x(typedArray.getColor(R$styleable.ShimmerFrameLayout_shimmer_base_color, this.f51589a.f51573f));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_highlight_color)) {
                y(typedArray.getColor(R$styleable.ShimmerFrameLayout_shimmer_highlight_color, this.f51589a.f51572e));
            }
            return d();
        }

        @Override // com.transsion.baseui.widget.shimmer.a.b
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public c d() {
            return this;
        }

        public c x(int i11) {
            a aVar = this.f51589a;
            aVar.f51573f = (i11 & 16777215) | (aVar.f51573f & ViewCompat.MEASURED_STATE_MASK);
            return d();
        }

        public c y(int i11) {
            this.f51589a.f51572e = i11;
            return d();
        }
    }

    public int a(int i11) {
        int i12 = this.f51576i;
        return i12 > 0 ? i12 : Math.round(this.f51578k * i11);
    }

    public void b() {
        if (this.f51574g != 1) {
            int[] iArr = this.f51569b;
            int i11 = this.f51573f;
            iArr[0] = i11;
            int i12 = this.f51572e;
            iArr[1] = i12;
            iArr[2] = i12;
            iArr[3] = i11;
            return;
        }
        int[] iArr2 = this.f51569b;
        int i13 = this.f51572e;
        iArr2[0] = i13;
        iArr2[1] = i13;
        int i14 = this.f51573f;
        iArr2[2] = i14;
        iArr2[3] = i14;
    }

    public void c() {
        if (this.f51574g != 1) {
            this.f51568a[0] = Math.max(((1.0f - this.f51579l) - this.f51580m) / 2.0f, 0.0f);
            this.f51568a[1] = Math.max(((1.0f - this.f51579l) - 0.001f) / 2.0f, 0.0f);
            this.f51568a[2] = Math.min(((this.f51579l + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.f51568a[3] = Math.min(((this.f51579l + 1.0f) + this.f51580m) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.f51568a;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.f51579l, 1.0f);
        this.f51568a[2] = Math.min(this.f51579l + this.f51580m, 1.0f);
        this.f51568a[3] = 1.0f;
    }

    public int d(int i11) {
        int i12 = this.f51575h;
        return i12 > 0 ? i12 : Math.round(this.f51577j * i11);
    }
}
