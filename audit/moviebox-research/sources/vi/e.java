package vi;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final ColorStateList f78895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final ColorStateList f78896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final ColorStateList f78897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f78898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f78899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f78900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f78901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f78902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f78903i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f78904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f78905k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f78906l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public ColorStateList f78907m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f78908n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f78909o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f78910p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Typeface f78911q;

    /* JADX INFO: compiled from: source.java */
    public class a extends b3.h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f78912a;

        public a(g gVar) {
            this.f78912a = gVar;
        }

        @Override // b3.h.e
        /* JADX INFO: renamed from: h */
        public void f(int i11) {
            e.this.f78910p = true;
            this.f78912a.a(i11);
        }

        @Override // b3.h.e
        /* JADX INFO: renamed from: i */
        public void g(@NonNull Typeface typeface) {
            e eVar = e.this;
            eVar.f78911q = Typeface.create(typeface, eVar.f78899e);
            e.this.f78910p = true;
            this.f78912a.b(e.this.f78911q, false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f78914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextPaint f78915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f78916c;

        public b(Context context, TextPaint textPaint, g gVar) {
            this.f78914a = context;
            this.f78915b = textPaint;
            this.f78916c = gVar;
        }

        @Override // vi.g
        public void a(int i11) {
            this.f78916c.a(i11);
        }

        @Override // vi.g
        public void b(@NonNull Typeface typeface, boolean z11) {
            e.this.p(this.f78914a, this.f78915b, typeface);
            this.f78916c.b(typeface, z11);
        }
    }

    public e(@NonNull Context context, int i11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i11, R$styleable.TextAppearance);
        l(typedArrayObtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f));
        k(d.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColor));
        this.f78895a = d.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        this.f78896b = d.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.f78899e = typedArrayObtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.f78900f = typedArrayObtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int iG = d.g(typedArrayObtainStyledAttributes, R$styleable.TextAppearance_fontFamily, R$styleable.TextAppearance_android_fontFamily);
        this.f78909o = typedArrayObtainStyledAttributes.getResourceId(iG, 0);
        this.f78898d = typedArrayObtainStyledAttributes.getString(iG);
        this.f78901g = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.f78897c = d.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.f78902h = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f78903i = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f78904j = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i11, R$styleable.MaterialTextAppearance);
        this.f78905k = typedArrayObtainStyledAttributes2.hasValue(R$styleable.MaterialTextAppearance_android_letterSpacing);
        this.f78906l = typedArrayObtainStyledAttributes2.getFloat(R$styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void d() {
        String str;
        if (this.f78911q == null && (str = this.f78898d) != null) {
            this.f78911q = Typeface.create(str, this.f78899e);
        }
        if (this.f78911q == null) {
            int i11 = this.f78900f;
            if (i11 == 1) {
                this.f78911q = Typeface.SANS_SERIF;
            } else if (i11 == 2) {
                this.f78911q = Typeface.SERIF;
            } else if (i11 != 3) {
                this.f78911q = Typeface.DEFAULT;
            } else {
                this.f78911q = Typeface.MONOSPACE;
            }
            this.f78911q = Typeface.create(this.f78911q, this.f78899e);
        }
    }

    public Typeface e() {
        d();
        return this.f78911q;
    }

    @NonNull
    public Typeface f(@NonNull Context context) {
        if (this.f78910p) {
            return this.f78911q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceG = b3.h.g(context, this.f78909o);
                this.f78911q = typefaceG;
                if (typefaceG != null) {
                    this.f78911q = Typeface.create(typefaceG, this.f78899e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception unused2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error loading font ");
                sb2.append(this.f78898d);
            }
        }
        d();
        this.f78910p = true;
        return this.f78911q;
    }

    public void g(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull g gVar) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, gVar));
    }

    public void h(@NonNull Context context, @NonNull g gVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i11 = this.f78909o;
        if (i11 == 0) {
            this.f78910p = true;
        }
        if (this.f78910p) {
            gVar.b(this.f78911q, true);
            return;
        }
        try {
            b3.h.i(context, i11, new a(gVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f78910p = true;
            gVar.a(1);
        } catch (Exception unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error loading font ");
            sb2.append(this.f78898d);
            this.f78910p = true;
            gVar.a(-3);
        }
    }

    @Nullable
    public ColorStateList i() {
        return this.f78907m;
    }

    public float j() {
        return this.f78908n;
    }

    public void k(@Nullable ColorStateList colorStateList) {
        this.f78907m = colorStateList;
    }

    public void l(float f11) {
        this.f78908n = f11;
    }

    public final boolean m(Context context) {
        if (f.a()) {
            return true;
        }
        int i11 = this.f78909o;
        return (i11 != 0 ? b3.h.c(context, i11) : null) != null;
    }

    public void n(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull g gVar) {
        o(context, textPaint, gVar);
        ColorStateList colorStateList = this.f78907m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : ViewCompat.MEASURED_STATE_MASK);
        float f11 = this.f78904j;
        float f12 = this.f78902h;
        float f13 = this.f78903i;
        ColorStateList colorStateList2 = this.f78897c;
        textPaint.setShadowLayer(f11, f12, f13, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull g gVar) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, gVar);
        }
    }

    public void p(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        Typeface typefaceA = i.a(context, typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i11 = this.f78899e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i11 & 1) != 0);
        textPaint.setTextSkewX((i11 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f78908n);
        if (this.f78905k) {
            textPaint.setLetterSpacing(this.f78906l);
        }
    }
}
