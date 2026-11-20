package b3;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {
    public static boolean a(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i11, boolean z11) {
        return !j(xmlPullParser, str) ? z11 : typedArray.getBoolean(i11, z11);
    }

    public static int b(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i11, int i12) {
        return !j(xmlPullParser, str) ? i12 : typedArray.getColor(i11, i12);
    }

    @Nullable
    public static ColorStateList c(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, int i11) {
        if (!j(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i11, typedValue);
        int i12 = typedValue.type;
        if (i12 != 2) {
            return (i12 < 28 || i12 > 31) ? c.d(typedArray.getResources(), typedArray.getResourceId(i11, 0), theme) : d(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i11 + ": " + typedValue);
    }

    @NonNull
    public static ColorStateList d(@NonNull TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static d e(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, int i11, int i12) {
        if (j(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i11, typedValue);
            int i13 = typedValue.type;
            if (i13 >= 28 && i13 <= 31) {
                return d.b(typedValue.data);
            }
            d dVarG = d.g(typedArray.getResources(), typedArray.getResourceId(i11, 0), theme);
            if (dVarG != null) {
                return dVarG;
            }
        }
        return d.b(i12);
    }

    public static float f(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i11, float f11) {
        return !j(xmlPullParser, str) ? f11 : typedArray.getFloat(i11, f11);
    }

    public static int g(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i11, int i12) {
        return !j(xmlPullParser, str) ? i12 : typedArray.getInt(i11, i12);
    }

    public static int h(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i11, int i12) {
        return !j(xmlPullParser, str) ? i12 : typedArray.getResourceId(i11, i12);
    }

    @Nullable
    public static String i(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i11) {
        if (j(xmlPullParser, str)) {
            return typedArray.getString(i11);
        }
        return null;
    }

    public static boolean j(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    @NonNull
    public static TypedArray k(@NonNull Resources resources, @Nullable Resources.Theme theme, @NonNull AttributeSet attributeSet, @NonNull int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @Nullable
    public static TypedValue l(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i11) {
        if (j(xmlPullParser, str)) {
            return typedArray.peekValue(i11);
        }
        return null;
    }
}
