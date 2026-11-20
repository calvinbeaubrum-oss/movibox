package ti;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.mbridge.msdk.MBridgeConstans;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class j {
    public static float a(String[] strArr, int i11) {
        float f11 = Float.parseFloat(strArr[i11]);
        if (f11 >= 0.0f && f11 <= 1.0f) {
            return f11;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f11);
    }

    public static String b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    public static TimeInterpolator c(String str) {
        if (!e(str, "cubic-bezier")) {
            if (e(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH)) {
                return PathInterpolatorCompat.create(c3.e.e(b(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH)));
            }
            throw new IllegalArgumentException("Invalid motion easing type: " + str);
        }
        String[] strArrSplit = b(str, "cubic-bezier").split(",");
        if (strArrSplit.length == 4) {
            return PathInterpolatorCompat.create(a(strArrSplit, 0), a(strArrSplit, 1), a(strArrSplit, 2), a(strArrSplit, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }

    public static boolean d(String str) {
        return e(str, "cubic-bezier") || e(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
    }

    public static boolean e(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append("(");
        return str.startsWith(sb2.toString()) && str.endsWith(")");
    }

    public static int f(@NonNull Context context, int i11, int i12) {
        return vi.b.c(context, i11, i12);
    }

    @NonNull
    public static TimeInterpolator g(@NonNull Context context, int i11, @NonNull TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i11, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        return d(strValueOf) ? c(strValueOf) : AnimationUtils.loadInterpolator(context, typedValue.resourceId);
    }
}
