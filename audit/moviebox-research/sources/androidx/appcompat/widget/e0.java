package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.resources.R$drawable;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static e0 f1643i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHashMap<Context, androidx.collection.w0<ColorStateList>> f1645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.collection.v0<String, e> f1646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.collection.w0<String> f1647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap<Context, androidx.collection.v<WeakReference<Drawable.ConstantState>>> f1648d = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f1649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f1651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f1642h = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f1644j = new c(6);

    /* JADX INFO: compiled from: source.java */
    public static class a implements e {
        @Override // androidx.appcompat.widget.e0.e
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return androidx.appcompat.graphics.drawable.a.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e11) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e11);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements e {
        @Override // androidx.appcompat.widget.e0.e
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return l6.e.b(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e11) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e11);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends androidx.collection.x<Integer, PorterDuffColorFilter> {
        public c(int i11) {
            super(i11);
        }

        public static int a(int i11, PorterDuff.Mode mode) {
            return ((i11 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter b(int i11, PorterDuff.Mode mode) {
            return get(Integer.valueOf(a(i11, mode)));
        }

        public PorterDuffColorFilter c(int i11, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(a(i11, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements e {
        @Override // androidx.appcompat.widget.e0.e
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    e1.a.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e11) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e11);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme);
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        @Nullable
        Drawable a(@NonNull e0 e0Var, @NonNull Context context, int i11);

        @Nullable
        ColorStateList b(@NonNull Context context, int i11);

        boolean c(@NonNull Context context, int i11, @NonNull Drawable drawable);

        @Nullable
        PorterDuff.Mode d(int i11);

        boolean e(@NonNull Context context, int i11, @NonNull Drawable drawable);
    }

    /* JADX INFO: compiled from: source.java */
    public static class g implements e {
        @Override // androidx.appcompat.widget.e0.e
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return l6.j.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e11) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e11);
                return null;
            }
        }
    }

    public static long e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    public static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized e0 h() {
        try {
            if (f1643i == null) {
                e0 e0Var = new e0();
                f1643i = e0Var;
                p(e0Var);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f1643i;
    }

    public static synchronized PorterDuffColorFilter l(int i11, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterB;
        c cVar = f1644j;
        porterDuffColorFilterB = cVar.b(i11, mode);
        if (porterDuffColorFilterB == null) {
            porterDuffColorFilterB = new PorterDuffColorFilter(i11, mode);
            cVar.c(i11, mode, porterDuffColorFilterB);
        }
        return porterDuffColorFilterB;
    }

    public static void p(@NonNull e0 e0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            e0Var.a("vector", new g());
            e0Var.a("animated-vector", new b());
            e0Var.a("animated-selector", new a());
            e0Var.a("drawable", new d());
        }
    }

    public static boolean q(@NonNull Drawable drawable) {
        return (drawable instanceof l6.j) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    public static void w(Drawable drawable, l0 l0Var, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z11 = l0Var.f1720d;
            if (z11 || l0Var.f1719c) {
                drawable.setColorFilter(g(z11 ? l0Var.f1717a : null, l0Var.f1719c ? l0Var.f1718b : f1642h, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public final void a(@NonNull String str, @NonNull e eVar) {
        if (this.f1646b == null) {
            this.f1646b = new androidx.collection.v0<>();
        }
        this.f1646b.put(str, eVar);
    }

    public final synchronized boolean b(@NonNull Context context, long j11, @NonNull Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            androidx.collection.v<WeakReference<Drawable.ConstantState>> vVar = this.f1648d.get(context);
            if (vVar == null) {
                vVar = new androidx.collection.v<>();
                this.f1648d.put(context, vVar);
            }
            vVar.l(j11, new WeakReference<>(constantState));
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void c(@NonNull Context context, int i11, @NonNull ColorStateList colorStateList) {
        if (this.f1645a == null) {
            this.f1645a = new WeakHashMap<>();
        }
        androidx.collection.w0<ColorStateList> w0Var = this.f1645a.get(context);
        if (w0Var == null) {
            w0Var = new androidx.collection.w0<>();
            this.f1645a.put(context, w0Var);
        }
        w0Var.a(i11, colorStateList);
    }

    public final void d(@NonNull Context context) {
        if (this.f1650f) {
            return;
        }
        this.f1650f = true;
        Drawable drawableJ = j(context, R$drawable.abc_vector_test);
        if (drawableJ == null || !q(drawableJ)) {
            this.f1650f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public final Drawable f(@NonNull Context context, int i11) {
        if (this.f1649e == null) {
            this.f1649e = new TypedValue();
        }
        TypedValue typedValue = this.f1649e;
        context.getResources().getValue(i11, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        f fVar = this.f1651g;
        Drawable drawableA = fVar == null ? null : fVar.a(this, context, i11);
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, jE, drawableA);
        }
        return drawableA;
    }

    public final synchronized Drawable i(@NonNull Context context, long j11) {
        androidx.collection.v<WeakReference<Drawable.ConstantState>> vVar = this.f1648d.get(context);
        if (vVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceF = vVar.f(j11);
        if (weakReferenceF != null) {
            Drawable.ConstantState constantState = weakReferenceF.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            vVar.m(j11);
        }
        return null;
    }

    public synchronized Drawable j(@NonNull Context context, int i11) {
        return k(context, i11, false);
    }

    public synchronized Drawable k(@NonNull Context context, int i11, boolean z11) {
        Drawable drawableR;
        try {
            d(context);
            drawableR = r(context, i11);
            if (drawableR == null) {
                drawableR = f(context, i11);
            }
            if (drawableR == null) {
                drawableR = z2.a.getDrawable(context, i11);
            }
            if (drawableR != null) {
                drawableR = v(context, i11, z11, drawableR);
            }
            if (drawableR != null) {
                b0.b(drawableR);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return drawableR;
    }

    public synchronized ColorStateList m(@NonNull Context context, int i11) {
        ColorStateList colorStateListN;
        colorStateListN = n(context, i11);
        if (colorStateListN == null) {
            f fVar = this.f1651g;
            colorStateListN = fVar == null ? null : fVar.b(context, i11);
            if (colorStateListN != null) {
                c(context, i11, colorStateListN);
            }
        }
        return colorStateListN;
    }

    public final ColorStateList n(@NonNull Context context, int i11) {
        androidx.collection.w0<ColorStateList> w0Var;
        WeakHashMap<Context, androidx.collection.w0<ColorStateList>> weakHashMap = this.f1645a;
        if (weakHashMap == null || (w0Var = weakHashMap.get(context)) == null) {
            return null;
        }
        return w0Var.g(i11);
    }

    public PorterDuff.Mode o(int i11) {
        f fVar = this.f1651g;
        if (fVar == null) {
            return null;
        }
        return fVar.d(i11);
    }

    public final Drawable r(@NonNull Context context, int i11) {
        int next;
        androidx.collection.v0<String, e> v0Var = this.f1646b;
        if (v0Var == null || v0Var.isEmpty()) {
            return null;
        }
        androidx.collection.w0<String> w0Var = this.f1647c;
        if (w0Var != null) {
            String strG = w0Var.g(i11);
            if ("appcompat_skip_skip".equals(strG) || (strG != null && this.f1646b.get(strG) == null)) {
                return null;
            }
        } else {
            this.f1647c = new androidx.collection.w0<>();
        }
        if (this.f1649e == null) {
            this.f1649e = new TypedValue();
        }
        TypedValue typedValue = this.f1649e;
        Resources resources = context.getResources();
        resources.getValue(i11, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i11);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f1647c.a(i11, name);
                e eVar = this.f1646b.get(name);
                if (eVar != null) {
                    drawableI = eVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableI != null) {
                    drawableI.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, jE, drawableI);
                }
            } catch (Exception e11) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e11);
            }
        }
        if (drawableI == null) {
            this.f1647c.a(i11, "appcompat_skip_skip");
        }
        return drawableI;
    }

    public synchronized void s(@NonNull Context context) {
        androidx.collection.v<WeakReference<Drawable.ConstantState>> vVar = this.f1648d.get(context);
        if (vVar != null) {
            vVar.b();
        }
    }

    public synchronized Drawable t(@NonNull Context context, @NonNull x0 x0Var, int i11) {
        try {
            Drawable drawableR = r(context, i11);
            if (drawableR == null) {
                drawableR = x0Var.a(i11);
            }
            if (drawableR == null) {
                return null;
            }
            return v(context, i11, false, drawableR);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void u(f fVar) {
        this.f1651g = fVar;
    }

    public final Drawable v(@NonNull Context context, int i11, boolean z11, @NonNull Drawable drawable) {
        ColorStateList colorStateListM = m(context, i11);
        if (colorStateListM != null) {
            Drawable drawableR = d3.a.r(drawable.mutate());
            d3.a.o(drawableR, colorStateListM);
            PorterDuff.Mode modeO = o(i11);
            if (modeO == null) {
                return drawableR;
            }
            d3.a.p(drawableR, modeO);
            return drawableR;
        }
        f fVar = this.f1651g;
        if ((fVar == null || !fVar.e(context, i11, drawable)) && !x(context, i11, drawable) && z11) {
            return null;
        }
        return drawable;
    }

    public boolean x(@NonNull Context context, int i11, @NonNull Drawable drawable) {
        f fVar = this.f1651g;
        return fVar != null && fVar.c(context, i11, drawable);
    }
}
