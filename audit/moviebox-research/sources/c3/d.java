package c3;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeCompat;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<androidx.core.util.e<Rect, Rect>> f14558a = new ThreadLocal<>();

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class a {
        public static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class b {
        public static void a(Paint paint, Object obj) {
            paint.setBlendMode((BlendMode) obj);
        }
    }

    public static boolean a(@NonNull Paint paint, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(paint, str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float fMeasureText = paint.measureText("\udfffd");
        float fMeasureText2 = paint.measureText("m");
        float fMeasureText3 = paint.measureText(str);
        float fMeasureText4 = 0.0f;
        if (fMeasureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (fMeasureText3 > fMeasureText2 * 2.0f) {
                return false;
            }
            int i11 = 0;
            while (i11 < length) {
                int iCharCount = Character.charCount(str.codePointAt(i11)) + i11;
                fMeasureText4 += paint.measureText(str, i11, iCharCount);
                i11 = iCharCount;
            }
            if (fMeasureText3 >= fMeasureText4) {
                return false;
            }
        }
        if (fMeasureText3 != fMeasureText) {
            return true;
        }
        androidx.core.util.e<Rect, Rect> eVarB = b();
        paint.getTextBounds("\udfffd", 0, 2, eVarB.f7889a);
        paint.getTextBounds(str, 0, length, eVarB.f7890b);
        return !eVarB.f7889a.equals(eVarB.f7890b);
    }

    public static androidx.core.util.e<Rect, Rect> b() {
        ThreadLocal<androidx.core.util.e<Rect, Rect>> threadLocal = f14558a;
        androidx.core.util.e<Rect, Rect> eVar = threadLocal.get();
        if (eVar == null) {
            androidx.core.util.e<Rect, Rect> eVar2 = new androidx.core.util.e<>(new Rect(), new Rect());
            threadLocal.set(eVar2);
            return eVar2;
        }
        eVar.f7889a.setEmpty();
        eVar.f7890b.setEmpty();
        return eVar;
    }

    public static boolean c(@NonNull Paint paint, @Nullable BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.a(paint, blendModeCompat != null ? c3.a.b.a(blendModeCompat) : null);
            return true;
        }
        if (blendModeCompat == null) {
            paint.setXfermode(null);
            return true;
        }
        PorterDuff.Mode modeA = c3.a.a(blendModeCompat);
        paint.setXfermode(modeA != null ? new PorterDuffXfermode(modeA) : null);
        return modeA != null;
    }
}
