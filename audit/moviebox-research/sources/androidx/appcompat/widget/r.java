package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.api.Api;
import com.vungle.warren.error.VungleException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final RectF f1736l = new RectF();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Method> f1737m = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1738a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1739b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f1740c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1741d = -1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f1742e = -1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f1743f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1744g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextPaint f1745h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f1746i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f1747j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f1748k;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static final class a {
        @NonNull
        public static StaticLayout a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i11, int i12, @NonNull TextView textView, @NonNull TextPaint textPaint, @NonNull d dVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i11);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i12 == -1) {
                i12 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            hyphenationFrequency.setMaxLines(i12);
            try {
                dVar.a(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class b extends d {
        @Override // androidx.appcompat.widget.r.d
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) r.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class c extends b {
        @Override // androidx.appcompat.widget.r.b, androidx.appcompat.widget.r.d
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.r.d
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {
        public void a(StaticLayout.Builder builder, TextView textView) {
        }

        public boolean b(TextView textView) {
            return ((Boolean) r.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    public r(@NonNull TextView textView) {
        this.f1746i = textView;
        this.f1747j = textView.getContext();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            this.f1748k = new c();
        } else if (i11 >= 23) {
            this.f1748k = new b();
        } else {
            this.f1748k = new d();
        }
    }

    @Nullable
    public static Method k(@NonNull String str) {
        try {
            Method declaredMethod = f1737m.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                f1737m.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e11) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e11);
            return null;
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static <T> T m(@NonNull Object obj, @NonNull String str, @NonNull T t11) {
        try {
            return (T) k(str).invoke(obj, new Object[0]);
        } catch (Exception e11) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e11);
            return t11;
        }
    }

    public void a() {
        if (n()) {
            if (this.f1739b) {
                if (this.f1746i.getMeasuredHeight() <= 0 || this.f1746i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f1748k.b(this.f1746i) ? 1048576 : (this.f1746i.getMeasuredWidth() - this.f1746i.getTotalPaddingLeft()) - this.f1746i.getTotalPaddingRight();
                int height = (this.f1746i.getHeight() - this.f1746i.getCompoundPaddingBottom()) - this.f1746i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f1736l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fE = e(rectF);
                        if (fE != this.f1746i.getTextSize()) {
                            t(0, fE);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            this.f1739b = true;
        }
    }

    public final int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i11 : iArr) {
            if (i11 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i11)) < 0) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i12 = 0; i12 < size; i12++) {
            iArr2[i12] = ((Integer) arrayList.get(i12)).intValue();
        }
        return iArr2;
    }

    public final void c() {
        this.f1738a = 0;
        this.f1741d = -1.0f;
        this.f1742e = -1.0f;
        this.f1740c = -1.0f;
        this.f1743f = new int[0];
        this.f1739b = false;
    }

    @NonNull
    public StaticLayout d(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i11, int i12) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(charSequence, alignment, i11, i12, this.f1746i, this.f1745h, this.f1748k);
        }
        return new StaticLayout(charSequence, this.f1745h, i11, alignment, this.f1746i.getLineSpacingMultiplier(), this.f1746i.getLineSpacingExtra(), this.f1746i.getIncludeFontPadding());
    }

    public final int e(RectF rectF) {
        int length = this.f1743f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i11 = 1;
        int i12 = length - 1;
        int i13 = 0;
        while (i11 <= i12) {
            int i14 = (i11 + i12) / 2;
            if (x(this.f1743f[i14], rectF)) {
                int i15 = i14 + 1;
                i13 = i11;
                i11 = i15;
            } else {
                i13 = i14 - 1;
                i12 = i13;
            }
        }
        return this.f1743f[i13];
    }

    public int f() {
        return Math.round(this.f1742e);
    }

    public int g() {
        return Math.round(this.f1741d);
    }

    public int h() {
        return Math.round(this.f1740c);
    }

    public int[] i() {
        return this.f1743f;
    }

    public int j() {
        return this.f1738a;
    }

    public void l(int i11) {
        TextPaint textPaint = this.f1745h;
        if (textPaint == null) {
            this.f1745h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1745h.set(this.f1746i.getPaint());
        this.f1745h.setTextSize(i11);
    }

    public boolean n() {
        return y() && this.f1738a != 0;
    }

    public void o(@Nullable AttributeSet attributeSet, int i11) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f1747j.obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i11, 0);
        TextView textView = this.f1746i;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), R$styleable.AppCompatTextView, attributeSet, typedArrayObtainStyledAttributes, i11, 0);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeTextType)) {
            this.f1738a = typedArrayObtainStyledAttributes.getInt(R$styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeStepGranularity) ? typedArrayObtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeMinTextSize) ? typedArrayObtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeMaxTextSize) ? typedArrayObtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!y()) {
            this.f1738a = 0;
            return;
        }
        if (this.f1738a == 1) {
            if (!this.f1744g) {
                DisplayMetrics displayMetrics = this.f1747j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                z(dimension2, dimension3, dimension);
            }
            u();
        }
    }

    public void p(int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        if (y()) {
            DisplayMetrics displayMetrics = this.f1747j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i14, i11, displayMetrics), TypedValue.applyDimension(i14, i12, displayMetrics), TypedValue.applyDimension(i14, i13, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    public void q(@NonNull int[] iArr, int i11) throws IllegalArgumentException {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i11 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1747j.getResources().getDisplayMetrics();
                    for (int i12 = 0; i12 < length; i12++) {
                        iArrCopyOf[i12] = Math.round(TypedValue.applyDimension(i11, iArr[i12], displayMetrics));
                    }
                }
                this.f1743f = b(iArrCopyOf);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1744g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    public void r(int i11) {
        if (y()) {
            if (i11 == 0) {
                c();
                return;
            }
            if (i11 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i11);
            }
            DisplayMetrics displayMetrics = this.f1747j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public final void s(float f11) {
        if (f11 != this.f1746i.getPaint().getTextSize()) {
            this.f1746i.getPaint().setTextSize(f11);
            boolean zIsInLayout = this.f1746i.isInLayout();
            if (this.f1746i.getLayout() != null) {
                this.f1739b = false;
                try {
                    Method methodK = k("nullLayouts");
                    if (methodK != null) {
                        methodK.invoke(this.f1746i, new Object[0]);
                    }
                } catch (Exception e11) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e11);
                }
                if (zIsInLayout) {
                    this.f1746i.forceLayout();
                } else {
                    this.f1746i.requestLayout();
                }
                this.f1746i.invalidate();
            }
        }
    }

    public void t(int i11, float f11) {
        Context context = this.f1747j;
        s(TypedValue.applyDimension(i11, f11, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public final boolean u() {
        if (y() && this.f1738a == 1) {
            if (!this.f1744g || this.f1743f.length == 0) {
                int iFloor = ((int) Math.floor((this.f1742e - this.f1741d) / this.f1740c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i11 = 0; i11 < iFloor; i11++) {
                    iArr[i11] = Math.round(this.f1741d + (i11 * this.f1740c));
                }
                this.f1743f = b(iArr);
            }
            this.f1739b = true;
        } else {
            this.f1739b = false;
        }
        return this.f1739b;
    }

    public final void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i11 = 0; i11 < length; i11++) {
                iArr[i11] = typedArray.getDimensionPixelSize(i11, -1);
            }
            this.f1743f = b(iArr);
            w();
        }
    }

    public final boolean w() {
        int[] iArr = this.f1743f;
        int length = iArr.length;
        boolean z11 = length > 0;
        this.f1744g = z11;
        if (z11) {
            this.f1738a = 1;
            this.f1741d = iArr[0];
            this.f1742e = iArr[length - 1];
            this.f1740c = -1.0f;
        }
        return z11;
    }

    public final boolean x(int i11, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1746i.getText();
        TransformationMethod transformationMethod = this.f1746i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f1746i)) != null) {
            text = transformation;
        }
        int maxLines = this.f1746i.getMaxLines();
        l(i11);
        StaticLayout staticLayoutD = d(text, (Layout.Alignment) m(this.f1746i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutD.getLineCount() <= maxLines && staticLayoutD.getLineEnd(staticLayoutD.getLineCount() - 1) == text.length())) && ((float) staticLayoutD.getHeight()) <= rectF.bottom;
    }

    public final boolean y() {
        return !(this.f1746i instanceof AppCompatEditText);
    }

    public final void z(float f11, float f12, float f13) throws IllegalArgumentException {
        if (f11 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f11 + "px) is less or equal to (0px)");
        }
        if (f12 <= f11) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f12 + "px) is less or equal to minimum auto-size text size (" + f11 + "px)");
        }
        if (f13 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f13 + "px) is less or equal to (0px)");
        }
        this.f1738a = 1;
        this.f1741d = f11;
        this.f1742e = f12;
        this.f1740c = f13;
        this.f1744g = false;
    }
}
