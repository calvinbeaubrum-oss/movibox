package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class f0 implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f13186a = new f0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13187b;

    static {
        String simpleName = f0.class.getSimpleName();
        Intrinsics.f(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        f13187b = simpleName;
    }

    public b0 a(Activity activity) {
        Rect rectC;
        Intrinsics.g(activity, "activity");
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            rectC = e.f13184a.a(activity);
        } else if (i11 >= 29) {
            rectC = e(activity);
        } else if (i11 >= 28) {
            rectC = d(activity);
        } else {
            rectC = i11 >= 24 ? c(activity) : b(activity);
        }
        return new b0(rectC);
    }

    @RequiresApi(14)
    public final Rect b(Activity activity) {
        int i11;
        Intrinsics.g(activity, "activity");
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Intrinsics.f(defaultDisplay, "defaultDisplay");
        Point pointH = h(defaultDisplay);
        Rect rect = new Rect();
        int i12 = pointH.x;
        if (i12 == 0 || (i11 = pointH.y) == 0) {
            defaultDisplay.getRectSize(rect);
        } else {
            rect.right = i12;
            rect.bottom = i11;
        }
        return rect;
    }

    @RequiresApi(24)
    public final Rect c(Activity activity) {
        Intrinsics.g(activity, "activity");
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!b.f13182a.a(activity)) {
            Intrinsics.f(defaultDisplay, "defaultDisplay");
            Point pointH = h(defaultDisplay);
            int iG = g(activity);
            int i11 = rect.bottom;
            if (i11 + iG == pointH.y) {
                rect.bottom = i11 + iG;
            } else {
                int i12 = rect.right;
                if (i12 + iG == pointH.x) {
                    rect.right = i12 + iG;
                }
            }
        }
        return rect;
    }

    @RequiresApi(28)
    @SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    public final Rect d(Activity activity) {
        DisplayCutout displayCutoutF;
        Intrinsics.g(activity, "activity");
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (b.f13182a.a(activity)) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
                if (objInvoke == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
                rect.set((Rect) objInvoke);
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(obj, new Object[0]);
                if (objInvoke2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
                rect.set((Rect) objInvoke2);
            }
        } catch (IllegalAccessException e11) {
            Log.w(f13187b, e11);
            i(activity, rect);
        } catch (NoSuchFieldException e12) {
            Log.w(f13187b, e12);
            i(activity, rect);
        } catch (NoSuchMethodException e13) {
            Log.w(f13187b, e13);
            i(activity, rect);
        } catch (InvocationTargetException e14) {
            Log.w(f13187b, e14);
            i(activity, rect);
        }
        Display currentDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        f fVar = f.f13185a;
        Intrinsics.f(currentDisplay, "currentDisplay");
        fVar.a(currentDisplay, point);
        b bVar = b.f13182a;
        if (!bVar.a(activity)) {
            int iG = g(activity);
            int i11 = rect.bottom;
            if (i11 + iG == point.y) {
                rect.bottom = i11 + iG;
            } else {
                int i12 = rect.right;
                if (i12 + iG == point.x) {
                    rect.right = i12 + iG;
                } else if (rect.left == iG) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !bVar.a(activity) && (displayCutoutF = f(currentDisplay)) != null) {
            int i13 = rect.left;
            k kVar = k.f13188a;
            if (i13 == kVar.b(displayCutoutF)) {
                rect.left = 0;
            }
            if (point.x - rect.right == kVar.c(displayCutoutF)) {
                rect.right += kVar.c(displayCutoutF);
            }
            if (rect.top == kVar.d(displayCutoutF)) {
                rect.top = 0;
            }
            if (point.y - rect.bottom == kVar.a(displayCutoutF)) {
                rect.bottom += kVar.a(displayCutoutF);
            }
        }
        return rect;
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    @SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    public final Rect e(Activity activity) {
        Intrinsics.g(activity, "activity");
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
            if (objInvoke != null) {
                return new Rect((Rect) objInvoke);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
        } catch (IllegalAccessException e11) {
            Log.w(f13187b, e11);
            return d(activity);
        } catch (NoSuchFieldException e12) {
            Log.w(f13187b, e12);
            return d(activity);
        } catch (NoSuchMethodException e13) {
            Log.w(f13187b, e13);
            return d(activity);
        } catch (InvocationTargetException e14) {
            Log.w(f13187b, e14);
            return d(activity);
        }
    }

    @RequiresApi(28)
    @SuppressLint({"BanUncheckedReflection"})
    public final DisplayCutout f(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(new Class[0]);
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(new Object[0]);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", objNewInstance.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, objNewInstance);
            Field declaredField = objNewInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objNewInstance);
            if (d0.a(obj)) {
                return e0.a(obj);
            }
        } catch (ClassNotFoundException e11) {
            Log.w(f13187b, e11);
        } catch (IllegalAccessException e12) {
            Log.w(f13187b, e12);
        } catch (InstantiationException e13) {
            Log.w(f13187b, e13);
        } catch (NoSuchFieldException e14) {
            Log.w(f13187b, e14);
        } catch (NoSuchMethodException e15) {
            Log.w(f13187b, e15);
        } catch (InvocationTargetException e16) {
            Log.w(f13187b, e16);
        }
        return null;
    }

    public final int g(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @RequiresApi(14)
    public final Point h(Display display) {
        Intrinsics.g(display, "display");
        Point point = new Point();
        f.f13185a.a(display, point);
        return point;
    }

    public final void i(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }
}
