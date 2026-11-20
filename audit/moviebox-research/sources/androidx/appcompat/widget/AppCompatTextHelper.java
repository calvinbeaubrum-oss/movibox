package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f1370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l0 f1371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l0 f1372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l0 f1373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l0 f1374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l0 f1375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l0 f1376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l0 f1377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final r f1378i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1379j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1380k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Typeface f1381l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1382m;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a extends b3.h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f1385c;

        public a(int i11, int i12, WeakReference weakReference) {
            this.f1383a = i11;
            this.f1384b = i12;
            this.f1385c = weakReference;
        }

        @Override // b3.h.e
        /* JADX INFO: renamed from: h */
        public void f(int i11) {
        }

        @Override // b3.h.e
        /* JADX INFO: renamed from: i */
        public void g(@NonNull Typeface typeface) {
            int i11;
            if (Build.VERSION.SDK_INT >= 28 && (i11 = this.f1383a) != -1) {
                typeface = e.a(typeface, i11, (this.f1384b & 2) != 0);
            }
            AppCompatTextHelper.this.n(this.f1385c, typeface);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(21)
    public static class b {
        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(24)
    public static class c {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(26)
    public static class d {
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void b(TextView textView, int i11, int i12, int i13, int i14) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i11, i12, i13, i14);
        }

        public static void c(TextView textView, int[] iArr, int i11) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i11);
        }

        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(28)
    public static class e {
        public static Typeface a(Typeface typeface, int i11, boolean z11) {
            return Typeface.create(typeface, i11, z11);
        }
    }

    public AppCompatTextHelper(@NonNull TextView textView) {
        this.f1370a = textView;
        this.f1378i = new r(textView);
    }

    public static l0 d(Context context, f fVar, int i11) {
        ColorStateList colorStateListF = fVar.f(context, i11);
        if (colorStateListF == null) {
            return null;
        }
        l0 l0Var = new l0();
        l0Var.f1720d = true;
        l0Var.f1717a = colorStateListF;
        return l0Var;
    }

    public void A(int i11, float f11) {
        if (y0.f1796c || l()) {
            return;
        }
        B(i11, f11);
    }

    public final void B(int i11, float f11) {
        this.f1378i.t(i11, f11);
    }

    public final void C(Context context, n0 n0Var) {
        String strO;
        this.f1379j = n0Var.k(R$styleable.TextAppearance_android_textStyle, this.f1379j);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            int iK = n0Var.k(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.f1380k = iK;
            if (iK != -1) {
                this.f1379j &= 2;
            }
        }
        if (!n0Var.s(R$styleable.TextAppearance_android_fontFamily) && !n0Var.s(R$styleable.TextAppearance_fontFamily)) {
            if (n0Var.s(R$styleable.TextAppearance_android_typeface)) {
                this.f1382m = false;
                int iK2 = n0Var.k(R$styleable.TextAppearance_android_typeface, 1);
                if (iK2 == 1) {
                    this.f1381l = Typeface.SANS_SERIF;
                    return;
                } else if (iK2 == 2) {
                    this.f1381l = Typeface.SERIF;
                    return;
                } else {
                    if (iK2 != 3) {
                        return;
                    }
                    this.f1381l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f1381l = null;
        int i12 = n0Var.s(R$styleable.TextAppearance_fontFamily) ? R$styleable.TextAppearance_fontFamily : R$styleable.TextAppearance_android_fontFamily;
        int i13 = this.f1380k;
        int i14 = this.f1379j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = n0Var.j(i12, this.f1379j, new a(i13, i14, new WeakReference(this.f1370a)));
                if (typefaceJ != null) {
                    if (i11 < 28 || this.f1380k == -1) {
                        this.f1381l = typefaceJ;
                    } else {
                        this.f1381l = e.a(Typeface.create(typefaceJ, 0), this.f1380k, (this.f1379j & 2) != 0);
                    }
                }
                this.f1382m = this.f1381l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1381l != null || (strO = n0Var.o(i12)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f1380k == -1) {
            this.f1381l = Typeface.create(strO, this.f1379j);
        } else {
            this.f1381l = e.a(Typeface.create(strO, 0), this.f1380k, (this.f1379j & 2) != 0);
        }
    }

    public final void a(Drawable drawable, l0 l0Var) {
        if (drawable == null || l0Var == null) {
            return;
        }
        f.i(drawable, l0Var, this.f1370a.getDrawableState());
    }

    public void b() {
        if (this.f1371b != null || this.f1372c != null || this.f1373d != null || this.f1374e != null) {
            Drawable[] compoundDrawables = this.f1370a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1371b);
            a(compoundDrawables[1], this.f1372c);
            a(compoundDrawables[2], this.f1373d);
            a(compoundDrawables[3], this.f1374e);
        }
        if (this.f1375f == null && this.f1376g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f1370a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f1375f);
        a(compoundDrawablesRelative[2], this.f1376g);
    }

    public void c() {
        this.f1378i.a();
    }

    public int e() {
        return this.f1378i.f();
    }

    public int f() {
        return this.f1378i.g();
    }

    public int g() {
        return this.f1378i.h();
    }

    public int[] h() {
        return this.f1378i.i();
    }

    public int i() {
        return this.f1378i.j();
    }

    @Nullable
    public ColorStateList j() {
        l0 l0Var = this.f1377h;
        if (l0Var != null) {
            return l0Var.f1717a;
        }
        return null;
    }

    @Nullable
    public PorterDuff.Mode k() {
        l0 l0Var = this.f1377h;
        if (l0Var != null) {
            return l0Var.f1718b;
        }
        return null;
    }

    public boolean l() {
        return this.f1378i.n();
    }

    /* JADX WARN: Code duplicated, block: B:163:0x034f  */
    /* JADX WARN: Code duplicated, block: B:165:0x0356  */
    /* JADX WARN: Code duplicated, block: B:168:0x035f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:169:0x0361  */
    /* JADX WARN: Code duplicated, block: B:170:0x0368  */
    /* JADX WARN: Code duplicated, block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0118  */
    /* JADX WARN: Code duplicated, block: B:46:0x011f  */
    /* JADX WARN: Code duplicated, block: B:51:0x0131  */
    @SuppressLint({"NewApi"})
    public void m(@Nullable AttributeSet attributeSet, int i11) {
        String strO;
        ColorStateList colorStateListC;
        boolean zA;
        boolean z11;
        ColorStateList colorStateListC2;
        ColorStateList colorStateListC3;
        String strO2;
        boolean z12;
        int i12;
        int i13;
        float f11;
        int i14;
        Context context = this.f1370a.getContext();
        f fVarB = f.b();
        n0 n0VarV = n0.v(context, attributeSet, R$styleable.AppCompatTextHelper, i11, 0);
        TextView textView = this.f1370a;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), R$styleable.AppCompatTextHelper, attributeSet, n0VarV.r(), i11, 0);
        int iN = n0VarV.n(R$styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (n0VarV.s(R$styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f1371b = d(context, fVarB, n0VarV.n(R$styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (n0VarV.s(R$styleable.AppCompatTextHelper_android_drawableTop)) {
            this.f1372c = d(context, fVarB, n0VarV.n(R$styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (n0VarV.s(R$styleable.AppCompatTextHelper_android_drawableRight)) {
            this.f1373d = d(context, fVarB, n0VarV.n(R$styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (n0VarV.s(R$styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.f1374e = d(context, fVarB, n0VarV.n(R$styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (n0VarV.s(R$styleable.AppCompatTextHelper_android_drawableStart)) {
            this.f1375f = d(context, fVarB, n0VarV.n(R$styleable.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (n0VarV.s(R$styleable.AppCompatTextHelper_android_drawableEnd)) {
            this.f1376g = d(context, fVarB, n0VarV.n(R$styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }
        n0VarV.x();
        boolean z13 = this.f1370a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iN != -1) {
            n0 n0VarT = n0.t(context, iN, R$styleable.TextAppearance);
            if (z13 || !n0VarT.s(R$styleable.TextAppearance_textAllCaps)) {
                zA = false;
                z11 = false;
            } else {
                zA = n0VarT.a(R$styleable.TextAppearance_textAllCaps, false);
                z11 = true;
            }
            C(context, n0VarT);
            int i15 = Build.VERSION.SDK_INT;
            if (i15 < 23) {
                colorStateListC = n0VarT.s(R$styleable.TextAppearance_android_textColor) ? n0VarT.c(R$styleable.TextAppearance_android_textColor) : null;
                colorStateListC2 = n0VarT.s(R$styleable.TextAppearance_android_textColorHint) ? n0VarT.c(R$styleable.TextAppearance_android_textColorHint) : null;
                colorStateListC3 = n0VarT.s(R$styleable.TextAppearance_android_textColorLink) ? n0VarT.c(R$styleable.TextAppearance_android_textColorLink) : null;
                if (n0VarT.s(R$styleable.TextAppearance_textLocale)) {
                    strO = n0VarT.o(R$styleable.TextAppearance_textLocale);
                } else {
                    strO = null;
                }
                if (i15 >= 26 || !n0VarT.s(R$styleable.TextAppearance_fontVariationSettings)) {
                    strO2 = null;
                } else {
                    strO2 = n0VarT.o(R$styleable.TextAppearance_fontVariationSettings);
                }
                n0VarT.x();
            } else {
                colorStateListC = null;
                colorStateListC2 = null;
            }
            if (n0VarT.s(R$styleable.TextAppearance_textLocale)) {
                strO = n0VarT.o(R$styleable.TextAppearance_textLocale);
            } else {
                strO = null;
            }
            if (i15 >= 26) {
                strO2 = null;
            } else {
                strO2 = null;
            }
            n0VarT.x();
        } else {
            strO = null;
            colorStateListC = null;
            zA = false;
            z11 = false;
            colorStateListC2 = null;
            colorStateListC3 = null;
            strO2 = null;
        }
        n0 n0VarV2 = n0.v(context, attributeSet, R$styleable.TextAppearance, i11, 0);
        if (z13 || !n0VarV2.s(R$styleable.TextAppearance_textAllCaps)) {
            z12 = z11;
        } else {
            zA = n0VarV2.a(R$styleable.TextAppearance_textAllCaps, false);
            z12 = true;
        }
        int i16 = Build.VERSION.SDK_INT;
        if (i16 < 23) {
            if (n0VarV2.s(R$styleable.TextAppearance_android_textColor)) {
                colorStateListC = n0VarV2.c(R$styleable.TextAppearance_android_textColor);
            }
            if (n0VarV2.s(R$styleable.TextAppearance_android_textColorHint)) {
                colorStateListC2 = n0VarV2.c(R$styleable.TextAppearance_android_textColorHint);
            }
            if (n0VarV2.s(R$styleable.TextAppearance_android_textColorLink)) {
                colorStateListC3 = n0VarV2.c(R$styleable.TextAppearance_android_textColorLink);
            }
        }
        if (n0VarV2.s(R$styleable.TextAppearance_textLocale)) {
            strO = n0VarV2.o(R$styleable.TextAppearance_textLocale);
        }
        if (i16 >= 26 && n0VarV2.s(R$styleable.TextAppearance_fontVariationSettings)) {
            strO2 = n0VarV2.o(R$styleable.TextAppearance_fontVariationSettings);
        }
        if (i16 >= 28 && n0VarV2.s(R$styleable.TextAppearance_android_textSize) && n0VarV2.f(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f1370a.setTextSize(0, 0.0f);
        }
        C(context, n0VarV2);
        n0VarV2.x();
        if (colorStateListC != null) {
            this.f1370a.setTextColor(colorStateListC);
        }
        if (colorStateListC2 != null) {
            this.f1370a.setHintTextColor(colorStateListC2);
        }
        if (colorStateListC3 != null) {
            this.f1370a.setLinkTextColor(colorStateListC3);
        }
        if (!z13 && z12) {
            s(zA);
        }
        Typeface typeface = this.f1381l;
        if (typeface != null) {
            if (this.f1380k == -1) {
                this.f1370a.setTypeface(typeface, this.f1379j);
            } else {
                this.f1370a.setTypeface(typeface);
            }
        }
        if (strO2 != null) {
            d.d(this.f1370a, strO2);
        }
        if (strO != null) {
            if (i16 >= 24) {
                c.b(this.f1370a, c.a(strO));
            } else {
                this.f1370a.setTextLocale(b.a(strO.split(",")[0]));
            }
        }
        this.f1378i.o(attributeSet, i11);
        if (y0.f1796c && this.f1378i.j() != 0) {
            int[] iArrI = this.f1378i.i();
            if (iArrI.length > 0) {
                if (d.a(this.f1370a) != -1.0f) {
                    d.b(this.f1370a, this.f1378i.g(), this.f1378i.f(), this.f1378i.h(), 0);
                } else {
                    d.c(this.f1370a, iArrI, 0);
                }
            }
        }
        n0 n0VarU = n0.u(context, attributeSet, R$styleable.AppCompatTextView);
        int iN2 = n0VarU.n(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
        Drawable drawableC = iN2 != -1 ? fVarB.c(context, iN2) : null;
        int iN3 = n0VarU.n(R$styleable.AppCompatTextView_drawableTopCompat, -1);
        Drawable drawableC2 = iN3 != -1 ? fVarB.c(context, iN3) : null;
        int iN4 = n0VarU.n(R$styleable.AppCompatTextView_drawableRightCompat, -1);
        Drawable drawableC3 = iN4 != -1 ? fVarB.c(context, iN4) : null;
        int iN5 = n0VarU.n(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
        Drawable drawableC4 = iN5 != -1 ? fVarB.c(context, iN5) : null;
        int iN6 = n0VarU.n(R$styleable.AppCompatTextView_drawableStartCompat, -1);
        Drawable drawableC5 = iN6 != -1 ? fVarB.c(context, iN6) : null;
        int iN7 = n0VarU.n(R$styleable.AppCompatTextView_drawableEndCompat, -1);
        y(drawableC, drawableC2, drawableC3, drawableC4, drawableC5, iN7 != -1 ? fVarB.c(context, iN7) : null);
        if (n0VarU.s(R$styleable.AppCompatTextView_drawableTint)) {
            androidx.core.widget.m.h(this.f1370a, n0VarU.c(R$styleable.AppCompatTextView_drawableTint));
        }
        if (n0VarU.s(R$styleable.AppCompatTextView_drawableTintMode)) {
            i12 = -1;
            androidx.core.widget.m.i(this.f1370a, b0.e(n0VarU.k(R$styleable.AppCompatTextView_drawableTintMode, -1), null));
        } else {
            i12 = -1;
        }
        int iF = n0VarU.f(R$styleable.AppCompatTextView_firstBaselineToTopHeight, i12);
        int iF2 = n0VarU.f(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, i12);
        if (n0VarU.s(R$styleable.AppCompatTextView_lineHeight)) {
            TypedValue typedValueW = n0VarU.w(R$styleable.AppCompatTextView_lineHeight);
            if (typedValueW == null || typedValueW.type != 5) {
                i13 = -1;
                f11 = n0VarU.f(R$styleable.AppCompatTextView_lineHeight, -1);
            } else {
                int iA = androidx.core.util.n.a(typedValueW.data);
                f11 = TypedValue.complexToFloat(typedValueW.data);
                i14 = iA;
                i13 = -1;
            }
            n0VarU.x();
            if (iF != i13) {
                androidx.core.widget.m.k(this.f1370a, iF);
            }
            if (iF2 != i13) {
                androidx.core.widget.m.l(this.f1370a, iF2);
            }
            if (f11 != -1.0f) {
                if (i14 == i13) {
                    androidx.core.widget.m.m(this.f1370a, (int) f11);
                } else {
                    androidx.core.widget.m.n(this.f1370a, i14, f11);
                }
            }
        }
        i13 = -1;
        f11 = -1.0f;
        i14 = -1;
        n0VarU.x();
        if (iF != i13) {
            androidx.core.widget.m.k(this.f1370a, iF);
        }
        if (iF2 != i13) {
            androidx.core.widget.m.l(this.f1370a, iF2);
        }
        if (f11 != -1.0f) {
            if (i14 == i13) {
                androidx.core.widget.m.m(this.f1370a, (int) f11);
            } else {
                androidx.core.widget.m.n(this.f1370a, i14, f11);
            }
        }
    }

    public void n(WeakReference<TextView> weakReference, final Typeface typeface) {
        if (this.f1382m) {
            this.f1381l = typeface;
            final TextView textView = weakReference.get();
            if (textView != null) {
                if (!textView.isAttachedToWindow()) {
                    textView.setTypeface(typeface, this.f1379j);
                } else {
                    final int i11 = this.f1379j;
                    textView.post(new Runnable() { // from class: androidx.appcompat.widget.AppCompatTextHelper.2
                        @Override // java.lang.Runnable
                        public void run() {
                            textView.setTypeface(typeface, i11);
                        }
                    });
                }
            }
        }
    }

    public void o(boolean z11, int i11, int i12, int i13, int i14) {
        if (y0.f1796c) {
            return;
        }
        c();
    }

    public void p() {
        b();
    }

    public void q(Context context, int i11) {
        String strO;
        ColorStateList colorStateListC;
        ColorStateList colorStateListC2;
        ColorStateList colorStateListC3;
        n0 n0VarT = n0.t(context, i11, R$styleable.TextAppearance);
        if (n0VarT.s(R$styleable.TextAppearance_textAllCaps)) {
            s(n0VarT.a(R$styleable.TextAppearance_textAllCaps, false));
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 23) {
            if (n0VarT.s(R$styleable.TextAppearance_android_textColor) && (colorStateListC3 = n0VarT.c(R$styleable.TextAppearance_android_textColor)) != null) {
                this.f1370a.setTextColor(colorStateListC3);
            }
            if (n0VarT.s(R$styleable.TextAppearance_android_textColorLink) && (colorStateListC2 = n0VarT.c(R$styleable.TextAppearance_android_textColorLink)) != null) {
                this.f1370a.setLinkTextColor(colorStateListC2);
            }
            if (n0VarT.s(R$styleable.TextAppearance_android_textColorHint) && (colorStateListC = n0VarT.c(R$styleable.TextAppearance_android_textColorHint)) != null) {
                this.f1370a.setHintTextColor(colorStateListC);
            }
        }
        if (n0VarT.s(R$styleable.TextAppearance_android_textSize) && n0VarT.f(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f1370a.setTextSize(0, 0.0f);
        }
        C(context, n0VarT);
        if (i12 >= 26 && n0VarT.s(R$styleable.TextAppearance_fontVariationSettings) && (strO = n0VarT.o(R$styleable.TextAppearance_fontVariationSettings)) != null) {
            d.d(this.f1370a, strO);
        }
        n0VarT.x();
        Typeface typeface = this.f1381l;
        if (typeface != null) {
            this.f1370a.setTypeface(typeface, this.f1379j);
        }
    }

    public void r(@NonNull TextView textView, @Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textView.getText());
    }

    public void s(boolean z11) {
        this.f1370a.setAllCaps(z11);
    }

    public void t(int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        this.f1378i.p(i11, i12, i13, i14);
    }

    public void u(@NonNull int[] iArr, int i11) throws IllegalArgumentException {
        this.f1378i.q(iArr, i11);
    }

    public void v(int i11) {
        this.f1378i.r(i11);
    }

    public void w(@Nullable ColorStateList colorStateList) {
        if (this.f1377h == null) {
            this.f1377h = new l0();
        }
        l0 l0Var = this.f1377h;
        l0Var.f1717a = colorStateList;
        l0Var.f1720d = colorStateList != null;
        z();
    }

    public void x(@Nullable PorterDuff.Mode mode) {
        if (this.f1377h == null) {
            this.f1377h = new l0();
        }
        l0 l0Var = this.f1377h;
        l0Var.f1718b = mode;
        l0Var.f1719c = mode != null;
        z();
    }

    public final void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f1370a.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.f1370a;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.f1370a.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.f1370a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f1370a.getCompoundDrawables();
        TextView textView2 = this.f1370a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public final void z() {
        l0 l0Var = this.f1377h;
        this.f1371b = l0Var;
        this.f1372c = l0Var;
        this.f1373d = l0Var;
        this.f1374e = l0Var;
        this.f1375f = l0Var;
        this.f1376g = l0Var;
    }
}
