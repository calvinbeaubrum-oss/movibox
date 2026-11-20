package b3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f13977a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<d, SparseArray<c>> f13978b = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f13979c = new Object();

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class a {
        public static Drawable a(Resources resources, int i11, Resources.Theme theme) {
            return resources.getDrawable(i11, theme);
        }

        public static Drawable b(Resources resources, int i11, int i12, Resources.Theme theme) {
            return resources.getDrawableForDensity(i11, i12, theme);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class b {
        public static int a(Resources resources, int i11, Resources.Theme theme) {
            return resources.getColor(i11, theme);
        }

        @NonNull
        public static ColorStateList b(@NonNull Resources resources, int i11, @Nullable Resources.Theme theme) {
            return resources.getColorStateList(i11, theme);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ColorStateList f13980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Configuration f13981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13982c;

        public c(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration, @Nullable Resources.Theme theme) {
            this.f13980a = colorStateList;
            this.f13981b = configuration;
            this.f13982c = theme == null ? 0 : theme.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f13983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Resources.Theme f13984b;

        public d(@NonNull Resources resources, @Nullable Resources.Theme theme) {
            this.f13983a = resources;
            this.f13984b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f13983a.equals(dVar.f13983a) && androidx.core.util.d.a(this.f13984b, dVar.f13984b);
        }

        public int hashCode() {
            return androidx.core.util.d.b(this.f13983a, this.f13984b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class e {
        @NonNull
        public static Handler e(@Nullable Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(final int i11, @Nullable Handler handler) {
            e(handler).post(new Runnable() { // from class: b3.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13990a.f(i11);
                }
            });
        }

        public final void d(@NonNull final Typeface typeface, @Nullable Handler handler) {
            e(handler).post(new Runnable() { // from class: b3.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13988a.g(typeface);
                }
            });
        }

        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public abstract void f(int i11);

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public abstract void g(@NonNull Typeface typeface);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f {

        /* JADX INFO: compiled from: source.java */
        @RequiresApi(23)
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Object f13985a = new Object();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static Method f13986b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static boolean f13987c;

            @SuppressLint({"BanUncheckedReflection"})
            public static void a(@NonNull Resources.Theme theme) {
                synchronized (f13985a) {
                    if (!f13987c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f13986b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException unused) {
                        }
                        f13987c = true;
                    }
                    Method method = f13986b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                            f13986b = null;
                        }
                    }
                }
            }
        }

        /* JADX INFO: compiled from: source.java */
        @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
        public static class b {
            public static void a(@NonNull Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(@NonNull Resources.Theme theme) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 29) {
                b.a(theme);
            } else if (i11 >= 23) {
                a.a(theme);
            }
        }
    }

    public static void a(@NonNull d dVar, int i11, @NonNull ColorStateList colorStateList, @Nullable Resources.Theme theme) {
        synchronized (f13979c) {
            try {
                WeakHashMap<d, SparseArray<c>> weakHashMap = f13978b;
                SparseArray<c> sparseArray = weakHashMap.get(dVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                    weakHashMap.put(dVar, sparseArray);
                }
                sparseArray.append(i11, new c(colorStateList, dVar.f13983a.getConfiguration(), theme));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2.f13982c == r5.hashCode()) goto L22;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ColorStateList b(@NonNull d dVar, int i11) {
        c cVar;
        synchronized (f13979c) {
            try {
                SparseArray<c> sparseArray = f13978b.get(dVar);
                if (sparseArray != null && sparseArray.size() > 0 && (cVar = sparseArray.get(i11)) != null) {
                    if (cVar.f13981b.equals(dVar.f13983a.getConfiguration())) {
                        Resources.Theme theme = dVar.f13984b;
                        if (theme != null || cVar.f13982c != 0) {
                            if (theme != null) {
                            }
                        }
                        return cVar.f13980a;
                    }
                    sparseArray.remove(i11);
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Nullable
    public static Typeface c(@NonNull Context context, int i11) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i11, new TypedValue(), 0, null, null, false, true);
    }

    @Nullable
    public static ColorStateList d(@NonNull Resources resources, int i11, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        d dVar = new d(resources, theme);
        ColorStateList colorStateListB = b(dVar, i11);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListK = k(resources, i11, theme);
        if (colorStateListK == null) {
            return Build.VERSION.SDK_INT >= 23 ? b.b(resources, i11, theme) : resources.getColorStateList(i11);
        }
        a(dVar, i11, colorStateListK, theme);
        return colorStateListK;
    }

    @Nullable
    public static Drawable e(@NonNull Resources resources, int i11, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return a.a(resources, i11, theme);
    }

    @Nullable
    public static Drawable f(@NonNull Resources resources, int i11, int i12, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return a.b(resources, i11, i12, theme);
    }

    @Nullable
    public static Typeface g(@NonNull Context context, int i11) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i11, new TypedValue(), 0, null, null, false, false);
    }

    @Nullable
    public static Typeface h(@NonNull Context context, int i11, @NonNull TypedValue typedValue, int i12, @Nullable e eVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i11, typedValue, i12, eVar, null, true, false);
    }

    public static void i(@NonNull Context context, int i11, @NonNull e eVar, @Nullable Handler handler) throws Resources.NotFoundException {
        androidx.core.util.i.g(eVar);
        if (context.isRestricted()) {
            eVar.c(-4, handler);
        } else {
            m(context, i11, new TypedValue(), 0, eVar, handler, false, false);
        }
    }

    @NonNull
    public static TypedValue j() {
        ThreadLocal<TypedValue> threadLocal = f13977a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    @Nullable
    public static ColorStateList k(Resources resources, int i11, @Nullable Resources.Theme theme) {
        if (l(resources, i11)) {
            return null;
        }
        try {
            return b3.c.a(resources, resources.getXml(i11), theme);
        } catch (Exception e11) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e11);
            return null;
        }
    }

    public static boolean l(@NonNull Resources resources, int i11) {
        TypedValue typedValueJ = j();
        resources.getValue(i11, typedValueJ, true);
        int i12 = typedValueJ.type;
        return i12 >= 28 && i12 <= 31;
    }

    public static Typeface m(@NonNull Context context, int i11, @NonNull TypedValue typedValue, int i12, @Nullable e eVar, @Nullable Handler handler, boolean z11, boolean z12) {
        Resources resources = context.getResources();
        resources.getValue(i11, typedValue, true);
        Typeface typefaceN = n(context, resources, typedValue, i11, i12, eVar, handler, z11, z12);
        if (typefaceN != null || eVar != null || z12) {
            return typefaceN;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i11) + " could not be retrieved.");
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    public static Typeface n(@NonNull Context context, Resources resources, @NonNull TypedValue typedValue, int i11, int i12, @Nullable e eVar, @Nullable Handler handler, boolean z11, boolean z12) {
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i11) + "\" (" + Integer.toHexString(i11) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        int i13 = 0;
        if (!string.startsWith("res/")) {
            if (eVar != null) {
                eVar.c(-3, handler);
            }
            return null;
        }
        Typeface typefaceF = c3.f.f(resources, i11, string, typedValue.assetCookie, i12);
        if (typefaceF != null) {
            if (eVar != null) {
                eVar.d(typefaceF, handler);
            }
            return typefaceF;
        }
        if (z12) {
            return null;
        }
        try {
            try {
                if (!string.toLowerCase().endsWith(".xml")) {
                    Typeface typefaceD = c3.f.d(context, resources, i11, string, typedValue.assetCookie, i12);
                    if (eVar != null) {
                        if (typefaceD != null) {
                            eVar.d(typefaceD, handler);
                        } else {
                            eVar.c(-3, handler);
                        }
                    }
                    return typefaceD;
                }
                b3.e.b bVarB = b3.e.b(resources.getXml(i11), resources);
                if (bVarB != null) {
                    return c3.f.c(context, bVarB, resources, i11, string, typedValue.assetCookie, i12, eVar, handler, z11);
                }
                Log.e("ResourcesCompat", "Failed to find font-family tag");
                if (eVar != null) {
                    eVar.c(-3, handler);
                }
                return null;
            } catch (IOException e11) {
                e = e11;
                Log.e("ResourcesCompat", "Failed to read xml resource " + string, e);
                if (eVar != null) {
                    return null;
                }
                eVar.c(i13, handler);
                return null;
            } catch (XmlPullParserException e12) {
                e = e12;
                Log.e("ResourcesCompat", "Failed to parse xml resource " + string, e);
                if (eVar != null) {
                    return null;
                }
                eVar.c(i13, handler);
                return null;
            }
        } catch (IOException e13) {
            e = e13;
            i13 = -3;
        } catch (XmlPullParserException e14) {
            e = e14;
            i13 = -3;
        }
    }
}
