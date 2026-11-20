package aj;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.color.b;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.y;
import vi.d;
import vi.e;
import yi.g;
import yi.h;
import yi.i;
import yi.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a extends i implements y.b {
    public static final int S = R$style.Widget_MaterialComponents_Tooltip;
    public static final int T = R$attr.tooltipStyle;

    @Nullable
    public CharSequence A;

    @NonNull
    public final Context B;

    @Nullable
    public final Paint.FontMetrics C;

    @NonNull
    public final y D;

    @NonNull
    public final View.OnLayoutChangeListener E;

    @NonNull
    public final Rect F;
    public int G;
    public int H;
    public int I;
    public int J;
    public boolean K;
    public int L;
    public int M;
    public float N;
    public float O;
    public final float P;
    public float Q;
    public float R;

    /* JADX INFO: renamed from: aj.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class ViewOnLayoutChangeListenerC0025a implements View.OnLayoutChangeListener {
        public ViewOnLayoutChangeListenerC0025a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            a.this.G0(view);
        }
    }

    public a(@NonNull Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.C = new Paint.FontMetrics();
        y yVar = new y(this);
        this.D = yVar;
        this.E = new ViewOnLayoutChangeListenerC0025a();
        this.F = new Rect();
        this.N = 1.0f;
        this.O = 1.0f;
        this.P = 0.5f;
        this.Q = 0.5f;
        this.R = 1.0f;
        this.B = context;
        yVar.g().density = context.getResources().getDisplayMetrics().density;
        yVar.g().setTextAlign(Paint.Align.CENTER);
    }

    private void B0(@Nullable AttributeSet attributeSet, int i11, int i12) {
        TypedArray typedArrayI = b0.i(this.B, attributeSet, R$styleable.Tooltip, i11, i12, new int[0]);
        this.L = this.B.getResources().getDimensionPixelSize(R$dimen.mtrl_tooltip_arrowSize);
        boolean z11 = typedArrayI.getBoolean(R$styleable.Tooltip_showMarker, true);
        this.K = z11;
        if (z11) {
            setShapeAppearanceModel(G().v().s(x0()).m());
        } else {
            this.L = 0;
        }
        E0(typedArrayI.getText(R$styleable.Tooltip_android_text));
        e eVarH = d.h(this.B, typedArrayI, R$styleable.Tooltip_android_textAppearance);
        if (eVarH != null && typedArrayI.hasValue(R$styleable.Tooltip_android_textColor)) {
            eVarH.k(d.a(this.B, typedArrayI, R$styleable.Tooltip_android_textColor));
        }
        F0(eVarH);
        d0(ColorStateList.valueOf(typedArrayI.getColor(R$styleable.Tooltip_backgroundTint, b.j(c3.b.k(b.c(this.B, R.attr.colorBackground, a.class.getCanonicalName()), 229), c3.b.k(b.c(this.B, R$attr.colorOnBackground, a.class.getCanonicalName()), 153)))));
        n0(ColorStateList.valueOf(b.c(this.B, R$attr.colorSurface, a.class.getCanonicalName())));
        this.G = typedArrayI.getDimensionPixelSize(R$styleable.Tooltip_android_padding, 0);
        this.H = typedArrayI.getDimensionPixelSize(R$styleable.Tooltip_android_minWidth, 0);
        this.I = typedArrayI.getDimensionPixelSize(R$styleable.Tooltip_android_minHeight, 0);
        this.J = typedArrayI.getDimensionPixelSize(R$styleable.Tooltip_android_layout_margin, 0);
        typedArrayI.recycle();
    }

    private float u0() {
        this.D.g().getFontMetrics(this.C);
        Paint.FontMetrics fontMetrics = this.C;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    @NonNull
    public static a w0(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        a aVar = new a(context, attributeSet, i11, i12);
        aVar.B0(attributeSet, i11, i12);
        return aVar;
    }

    public final float A0() {
        CharSequence charSequence = this.A;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.D.h(charSequence.toString());
    }

    public void C0(@Nullable View view) {
        if (view == null) {
            return;
        }
        G0(view);
        view.addOnLayoutChangeListener(this.E);
    }

    public void D0(float f11) {
        this.Q = 1.2f;
        this.N = f11;
        this.O = f11;
        this.R = ii.b.b(0.0f, 1.0f, 0.19f, 1.0f, f11);
        invalidateSelf();
    }

    public void E0(@Nullable CharSequence charSequence) {
        if (TextUtils.equals(this.A, charSequence)) {
            return;
        }
        this.A = charSequence;
        this.D.m(true);
        invalidateSelf();
    }

    public void F0(@Nullable e eVar) {
        this.D.k(eVar, this.B);
    }

    public final void G0(@NonNull View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.M = iArr[0];
        view.getWindowVisibleDisplayFrame(this.F);
    }

    @Override // com.google.android.material.internal.y.b
    public void a() {
        invalidateSelf();
    }

    @Override // yi.i, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        float fT0 = t0();
        float f11 = (float) (-((((double) this.L) * Math.sqrt(2.0d)) - ((double) this.L)));
        canvas.scale(this.N, this.O, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.Q));
        canvas.translate(fT0, f11);
        super.draw(canvas);
        z0(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.D.g().getTextSize(), this.I);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.G * 2) + A0(), this.H);
    }

    @Override // yi.i, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.K) {
            setShapeAppearanceModel(G().v().s(x0()).m());
        }
    }

    @Override // yi.i, android.graphics.drawable.Drawable, com.google.android.material.internal.y.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public final float t0() {
        int i11;
        if (((this.F.right - getBounds().right) - this.M) - this.J < 0) {
            i11 = ((this.F.right - getBounds().right) - this.M) - this.J;
        } else {
            if (((this.F.left - getBounds().left) - this.M) + this.J <= 0) {
                return 0.0f;
            }
            i11 = ((this.F.left - getBounds().left) - this.M) + this.J;
        }
        return i11;
    }

    public final float v0(@NonNull Rect rect) {
        return rect.centerY() - u0();
    }

    public final g x0() {
        float f11 = -t0();
        float fWidth = ((float) (((double) getBounds().width()) - (((double) this.L) * Math.sqrt(2.0d)))) / 2.0f;
        return new k(new h(this.L), Math.min(Math.max(f11, -fWidth), fWidth));
    }

    public void y0(@Nullable View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.E);
    }

    public final void z0(@NonNull Canvas canvas) {
        if (this.A == null) {
            return;
        }
        Rect bounds = getBounds();
        int iV0 = (int) v0(bounds);
        if (this.D.e() != null) {
            this.D.g().drawableState = getState();
            this.D.n(this.B);
            this.D.g().setAlpha((int) (this.R * 255.0f));
        }
        CharSequence charSequence = this.A;
        canvas.drawText(charSequence, 0, charSequence.length(), bounds.centerX(), iV0, this.D.g());
    }
}
