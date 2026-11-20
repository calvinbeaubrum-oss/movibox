package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Field f831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Field f833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f834h;

    public static void a(@NonNull Resources resources) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            return;
        }
        if (i11 >= 24) {
            d(resources);
        } else if (i11 >= 23) {
            c(resources);
        } else {
            b(resources);
        }
    }

    @RequiresApi(21)
    public static void b(@NonNull Resources resources) {
        Map map;
        if (!f828b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f827a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e11);
            }
            f828b = true;
        }
        Field field = f827a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e12) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e12);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    @RequiresApi(23)
    public static void c(@NonNull Resources resources) {
        Object obj;
        if (!f828b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f827a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e11);
            }
            f828b = true;
        }
        Field field = f827a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e12) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e12);
                obj = null;
            }
        } else {
            obj = null;
        }
        if (obj == null) {
            return;
        }
        e(obj);
    }

    @RequiresApi(24)
    public static void d(@NonNull Resources resources) {
        Object obj;
        if (!f834h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f833g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e11);
            }
            f834h = true;
        }
        Field field = f833g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e12) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e12);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f828b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f827a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e13) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e13);
            }
            f828b = true;
        }
        Field field2 = f827a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e14) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e14);
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    public static void e(@NonNull Object obj) {
        LongSparseArray longSparseArray;
        if (!f830d) {
            try {
                f829c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e11) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e11);
            }
            f830d = true;
        }
        Class<?> cls = f829c;
        if (cls == null) {
            return;
        }
        if (!f832f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f831e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e12) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e12);
            }
            f832f = true;
        }
        Field field = f831e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e13) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e13);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
