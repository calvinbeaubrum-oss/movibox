package k6;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f68424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property<View, Float> f68425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property<View, Rect> f68426c;

    /* JADX INFO: compiled from: source.java */
    public class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(z.b(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f11) {
            z.e(view, f11.floatValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends Property<View, Rect> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return view.getClipBounds();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            f68424a = new k0();
        } else if (i11 >= 23) {
            f68424a = new j0();
        } else if (i11 >= 22) {
            f68424a = new h0();
        } else {
            f68424a = new f0();
        }
        f68425b = new a(Float.class, "translationAlpha");
        f68426c = new b(Rect.class, "clipBounds");
    }

    public static void a(@NonNull View view) {
        f68424a.a(view);
    }

    public static float b(@NonNull View view) {
        return f68424a.c(view);
    }

    public static void c(@NonNull View view) {
        f68424a.d(view);
    }

    public static void d(@NonNull View view, int i11, int i12, int i13, int i14) {
        f68424a.e(view, i11, i12, i13, i14);
    }

    public static void e(@NonNull View view, float f11) {
        f68424a.f(view, f11);
    }

    public static void f(@NonNull View view, int i11) {
        f68424a.g(view, i11);
    }

    public static void g(@NonNull View view, @NonNull Matrix matrix) {
        f68424a.h(view, matrix);
    }

    public static void h(@NonNull View view, @NonNull Matrix matrix) {
        f68424a.i(view, matrix);
    }
}
