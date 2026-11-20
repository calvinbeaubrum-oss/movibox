package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import vi.d;
import yi.i;
import yi.n;
import yi.o;
import yi.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements q {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f36899t = R$style.Widget_MaterialComponents_ShapeableImageView;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f36900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f36901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f36902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f36903d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f36904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f36905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public ColorStateList f36906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public i f36907i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public n f36908j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f36909k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Path f36910l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f36911m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f36912n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f36913o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f36914p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f36915q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f36916r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f36917s;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes5.dex */
    @TargetApi(21)
    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f36918a = new Rect();

        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f36908j == null) {
                return;
            }
            if (ShapeableImageView.this.f36907i == null) {
                ShapeableImageView.this.f36907i = new i(ShapeableImageView.this.f36908j);
            }
            ShapeableImageView.this.f36901b.round(this.f36918a);
            ShapeableImageView.this.f36907i.setBounds(this.f36918a);
            ShapeableImageView.this.f36907i.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = f36899t;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        this.f36900a = o.k();
        this.f36905g = new Path();
        this.f36917s = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f36904f = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f36901b = new RectF();
        this.f36902c = new RectF();
        this.f36910l = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.ShapeableImageView, i11, i12);
        setLayerType(2, null);
        this.f36906h = d.a(context2, typedArrayObtainStyledAttributes, R$styleable.ShapeableImageView_strokeColor);
        this.f36909k = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_strokeWidth, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPadding, 0);
        this.f36911m = dimensionPixelSize;
        this.f36912n = dimensionPixelSize;
        this.f36913o = dimensionPixelSize;
        this.f36914p = dimensionPixelSize;
        this.f36911m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingLeft, dimensionPixelSize);
        this.f36912n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingTop, dimensionPixelSize);
        this.f36913o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingRight, dimensionPixelSize);
        this.f36914p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingBottom, dimensionPixelSize);
        this.f36915q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingStart, Integer.MIN_VALUE);
        this.f36916r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingEnd, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.f36903d = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.f36908j = n.e(context2, attributeSet, i11, i12).m();
        setOutlineProvider(new a());
    }

    private boolean g() {
        return getLayoutDirection() == 1;
    }

    public final void e(Canvas canvas) {
        if (this.f36906h == null) {
            return;
        }
        this.f36903d.setStrokeWidth(this.f36909k);
        int colorForState = this.f36906h.getColorForState(getDrawableState(), this.f36906h.getDefaultColor());
        if (this.f36909k <= 0.0f || colorForState == 0) {
            return;
        }
        this.f36903d.setColor(colorForState);
        canvas.drawPath(this.f36905g, this.f36903d);
    }

    public final boolean f() {
        return (this.f36915q == Integer.MIN_VALUE && this.f36916r == Integer.MIN_VALUE) ? false : true;
    }

    public int getContentPaddingBottom() {
        return this.f36914p;
    }

    public final int getContentPaddingEnd() {
        int i11 = this.f36916r;
        if (i11 != Integer.MIN_VALUE) {
            return i11;
        }
        return g() ? this.f36911m : this.f36913o;
    }

    public int getContentPaddingLeft() {
        int i11;
        int i12;
        if (f()) {
            if (g() && (i12 = this.f36916r) != Integer.MIN_VALUE) {
                return i12;
            }
            if (!g() && (i11 = this.f36915q) != Integer.MIN_VALUE) {
                return i11;
            }
        }
        return this.f36911m;
    }

    public int getContentPaddingRight() {
        int i11;
        int i12;
        if (f()) {
            if (g() && (i12 = this.f36915q) != Integer.MIN_VALUE) {
                return i12;
            }
            if (!g() && (i11 = this.f36916r) != Integer.MIN_VALUE) {
                return i11;
            }
        }
        return this.f36913o;
    }

    public final int getContentPaddingStart() {
        int i11 = this.f36915q;
        if (i11 != Integer.MIN_VALUE) {
            return i11;
        }
        return g() ? this.f36913o : this.f36911m;
    }

    public int getContentPaddingTop() {
        return this.f36912n;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @NonNull
    public n getShapeAppearanceModel() {
        return this.f36908j;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.f36906h;
    }

    public float getStrokeWidth() {
        return this.f36909k;
    }

    public final void h(int i11, int i12) {
        this.f36901b.set(getPaddingLeft(), getPaddingTop(), i11 - getPaddingRight(), i12 - getPaddingBottom());
        this.f36900a.d(this.f36908j, 1.0f, this.f36901b, this.f36905g);
        this.f36910l.rewind();
        this.f36910l.addPath(this.f36905g);
        this.f36902c.set(0.0f, 0.0f, i11, i12);
        this.f36910l.addRect(this.f36902c, Path.Direction.CCW);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f36910l, this.f36904f);
        e(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (!this.f36917s && isLayoutDirectionResolved()) {
            this.f36917s = true;
            if (isPaddingRelative() || f()) {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            } else {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        h(i11, i12);
    }

    public void setContentPadding(int i11, int i12, int i13, int i14) {
        this.f36915q = Integer.MIN_VALUE;
        this.f36916r = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.f36911m) + i11, (super.getPaddingTop() - this.f36912n) + i12, (super.getPaddingRight() - this.f36913o) + i13, (super.getPaddingBottom() - this.f36914p) + i14);
        this.f36911m = i11;
        this.f36912n = i12;
        this.f36913o = i13;
        this.f36914p = i14;
    }

    @RequiresApi(17)
    public void setContentPaddingRelative(int i11, int i12, int i13, int i14) {
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + i11, (super.getPaddingTop() - this.f36912n) + i12, (super.getPaddingEnd() - getContentPaddingEnd()) + i13, (super.getPaddingBottom() - this.f36914p) + i14);
        this.f36911m = g() ? i13 : i11;
        this.f36912n = i12;
        if (!g()) {
            i11 = i13;
        }
        this.f36913o = i11;
        this.f36914p = i14;
    }

    @Override // android.view.View
    public void setPadding(int i11, int i12, int i13, int i14) {
        super.setPadding(i11 + getContentPaddingLeft(), i12 + getContentPaddingTop(), i13 + getContentPaddingRight(), i14 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(int i11, int i12, int i13, int i14) {
        super.setPaddingRelative(i11 + getContentPaddingStart(), i12 + getContentPaddingTop(), i13 + getContentPaddingEnd(), i14 + getContentPaddingBottom());
    }

    @Override // yi.q
    public void setShapeAppearanceModel(@NonNull n nVar) {
        this.f36908j = nVar;
        i iVar = this.f36907i;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(nVar);
        }
        h(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        this.f36906h = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i11) {
        setStrokeColor(d1.a.a(getContext(), i11));
    }

    public void setStrokeWidth(float f11) {
        if (this.f36909k != f11) {
            this.f36909k = f11;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i11) {
        setStrokeWidth(getResources().getDimensionPixelSize(i11));
    }
}
