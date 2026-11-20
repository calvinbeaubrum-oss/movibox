package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.b;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T extends b<T>> implements androidx.dynamicanimation.animation.a.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final r f8237m = new f("translationX");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final r f8238n = new g("translationY");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final r f8239o = new h("translationZ");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final r f8240p = new i("scaleX");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final r f8241q = new j("scaleY");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final r f8242r = new k("rotation");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final r f8243s = new l("rotationX");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final r f8244t = new m("rotationY");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final r f8245u = new n("x");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final r f8246v = new a("y");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final r f8247w = new C0081b("z");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final r f8248x = new c("alpha");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final r f8249y = new d("scrollX");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final r f8250z = new e("scrollY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f8254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.dynamicanimation.animation.c f8255e;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f8260j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8251a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f8252b = Float.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8253c = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8256f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f8257g = Float.MAX_VALUE;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f8258h = -Float.MAX_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f8259i = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<p> f8261k = new ArrayList<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<q> f8262l = new ArrayList<>();

    /* JADX INFO: compiled from: source.java */
    public static class a extends r {
        public a(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setY(f11);
        }
    }

    /* JADX INFO: renamed from: androidx.dynamicanimation.animation.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0081b extends r {
        public C0081b(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return ViewCompat.getZ(view);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            ViewCompat.setZ(view, f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends r {
        public c(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setAlpha(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends r {
        public d(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setScrollX((int) f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends r {
        public e(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setScrollY((int) f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f extends r {
        public f(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setTranslationX(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g extends r {
        public g(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setTranslationY(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h extends r {
        public h(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return ViewCompat.getTranslationZ(view);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            ViewCompat.setTranslationZ(view, f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i extends r {
        public i(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setScaleX(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j extends r {
        public j(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setScaleY(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class k extends r {
        public k(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotation();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setRotation(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class l extends r {
        public l(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setRotationX(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class m extends r {
        public m(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setRotationY(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class n extends r {
        public n(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setX(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f8263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f8264b;
    }

    /* JADX INFO: compiled from: source.java */
    public interface p {
        void a(b bVar, boolean z11, float f11, float f12);
    }

    /* JADX INFO: compiled from: source.java */
    public interface q {
        void a(b bVar, float f11, float f12);
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class r extends androidx.dynamicanimation.animation.c<View> {
        public r(String str) {
            super(str);
        }

        public /* synthetic */ r(String str, f fVar) {
            this(str);
        }
    }

    public <K> b(K k11, androidx.dynamicanimation.animation.c<K> cVar) {
        this.f8254d = k11;
        this.f8255e = cVar;
        if (cVar == f8242r || cVar == f8243s || cVar == f8244t) {
            this.f8260j = 0.1f;
            return;
        }
        if (cVar == f8248x) {
            this.f8260j = 0.00390625f;
        } else if (cVar == f8240p || cVar == f8241q) {
            this.f8260j = 0.00390625f;
        } else {
            this.f8260j = 1.0f;
        }
    }

    public static <T> void f(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    @Override // androidx.dynamicanimation.animation.a.b
    public boolean a(long j11) {
        long j12 = this.f8259i;
        if (j12 == 0) {
            this.f8259i = j11;
            g(this.f8252b);
            return false;
        }
        this.f8259i = j11;
        boolean zK = k(j11 - j12);
        float fMin = Math.min(this.f8252b, this.f8257g);
        this.f8252b = fMin;
        float fMax = Math.max(fMin, this.f8258h);
        this.f8252b = fMax;
        g(fMax);
        if (zK) {
            b(false);
        }
        return zK;
    }

    public final void b(boolean z11) {
        this.f8256f = false;
        androidx.dynamicanimation.animation.a.d().g(this);
        this.f8259i = 0L;
        this.f8253c = false;
        for (int i11 = 0; i11 < this.f8261k.size(); i11++) {
            if (this.f8261k.get(i11) != null) {
                this.f8261k.get(i11).a(this, z11, this.f8252b, this.f8251a);
            }
        }
        f(this.f8261k);
    }

    public final float c() {
        return this.f8255e.a(this.f8254d);
    }

    public float d() {
        return this.f8260j * 0.75f;
    }

    public boolean e() {
        return this.f8256f;
    }

    public void g(float f11) {
        this.f8255e.b(this.f8254d, f11);
        for (int i11 = 0; i11 < this.f8262l.size(); i11++) {
            if (this.f8262l.get(i11) != null) {
                this.f8262l.get(i11).a(this, this.f8252b, this.f8251a);
            }
        }
        f(this.f8262l);
    }

    public T h(float f11) {
        this.f8252b = f11;
        this.f8253c = true;
        return this;
    }

    public void i() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f8256f) {
            return;
        }
        j();
    }

    public final void j() {
        if (this.f8256f) {
            return;
        }
        this.f8256f = true;
        if (!this.f8253c) {
            this.f8252b = c();
        }
        float f11 = this.f8252b;
        if (f11 > this.f8257g || f11 < this.f8258h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        androidx.dynamicanimation.animation.a.d().a(this, 0L);
    }

    public abstract boolean k(long j11);
}
