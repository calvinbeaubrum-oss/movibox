package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;
import l1.b;
import l1.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f1879i = {R.attr.colorBackground};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f1880j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1884d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f1885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f1886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f1887h;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f1888a;

        public a() {
        }

        @Override // l1.b
        public void a(int i11, int i12, int i13, int i14) {
            CardView.this.f1886g.set(i11, i12, i13, i14);
            CardView cardView = CardView.this;
            Rect rect = cardView.f1885f;
            CardView.super.setPadding(i11 + rect.left, i12 + rect.top, i13 + rect.right, i14 + rect.bottom);
        }

        @Override // l1.b
        public void b(Drawable drawable) {
            this.f1888a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // l1.b
        public boolean c() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // l1.b
        public Drawable d() {
            return this.f1888a;
        }

        @Override // l1.b
        public boolean e() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // l1.b
        public View f() {
            return CardView.this;
        }
    }

    static {
        l1.a aVar = new l1.a();
        f1880j = aVar;
        aVar.n();
    }

    public CardView(@NonNull Context context) {
        this(context, null);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.cardViewStyle);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i11);
        Rect rect = new Rect();
        this.f1885f = rect;
        this.f1886g = new Rect();
        a aVar = new a();
        this.f1887h = aVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CardView, i11, R$style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.CardView_cardBackgroundColor)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(R$styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f1879i);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(R$color.cardview_light_background) : getResources().getColor(R$color.cardview_dark_background));
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CardView_cardMaxElevation, 0.0f);
        this.f1881a = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CardView_cardUseCompatPadding, false);
        this.f1882b = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPadding, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f11 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1883c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minWidth, 0);
        this.f1884d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        f1880j.a(aVar, context, colorStateList, dimension, dimension2, f11);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return f1880j.m(this.f1887h);
    }

    public float getCardElevation() {
        return f1880j.o(this.f1887h);
    }

    public int getContentPaddingBottom() {
        return this.f1885f.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1885f.left;
    }

    public int getContentPaddingRight() {
        return this.f1885f.right;
    }

    public int getContentPaddingTop() {
        return this.f1885f.top;
    }

    public float getMaxCardElevation() {
        return f1880j.j(this.f1887h);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1882b;
    }

    public float getRadius() {
        return f1880j.h(this.f1887h);
    }

    public boolean getUseCompatPadding() {
        return this.f1881a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        c cVar = f1880j;
        if (cVar instanceof l1.a) {
            super.onMeasure(i11, i12);
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(cVar.g(this.f1887h)), View.MeasureSpec.getSize(i11)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i12);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i12 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(cVar.k(this.f1887h)), View.MeasureSpec.getSize(i12)), mode2);
        }
        super.onMeasure(i11, i12);
    }

    public void setCardBackgroundColor(int i11) {
        f1880j.l(this.f1887h, ColorStateList.valueOf(i11));
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        f1880j.l(this.f1887h, colorStateList);
    }

    public void setCardElevation(float f11) {
        f1880j.f(this.f1887h, f11);
    }

    public void setContentPadding(int i11, int i12, int i13, int i14) {
        this.f1885f.set(i11, i12, i13, i14);
        f1880j.e(this.f1887h);
    }

    public void setMaxCardElevation(float f11) {
        f1880j.c(this.f1887h, f11);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i11) {
        this.f1884d = i11;
        super.setMinimumHeight(i11);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i11) {
        this.f1883c = i11;
        super.setMinimumWidth(i11);
    }

    @Override // android.view.View
    public void setPadding(int i11, int i12, int i13, int i14) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i11, int i12, int i13, int i14) {
    }

    public void setPreventCornerOverlap(boolean z11) {
        if (z11 != this.f1882b) {
            this.f1882b = z11;
            f1880j.i(this.f1887h);
        }
    }

    public void setRadius(float f11) {
        f1880j.d(this.f1887h, f11);
    }

    public void setUseCompatPadding(boolean z11) {
        if (this.f1881a != z11) {
            this.f1881a = z11;
            f1880j.b(this.f1887h);
        }
    }
}
