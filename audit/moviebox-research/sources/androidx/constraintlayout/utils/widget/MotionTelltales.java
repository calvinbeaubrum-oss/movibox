package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class MotionTelltales extends MockView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f7248m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MotionLayout f7249n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float[] f7250o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Matrix f7251p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7252q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f7253r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f7254s;

    public MotionTelltales(Context context) {
        super(context);
        this.f7248m = new Paint();
        this.f7250o = new float[2];
        this.f7251p = new Matrix();
        this.f7252q = 0;
        this.f7253r = -65281;
        this.f7254s = 0.25f;
        a(context, null);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7248m = new Paint();
        this.f7250o = new float[2];
        this.f7251p = new Matrix();
        this.f7252q = 0;
        this.f7253r = -65281;
        this.f7254s = 0.25f;
        a(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7248m = new Paint();
        this.f7250o = new float[2];
        this.f7251p = new Matrix();
        this.f7252q = 0;
        this.f7253r = -65281;
        this.f7254s = 0.25f;
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MotionTelltales);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MotionTelltales_telltales_tailColor) {
                    this.f7253r = typedArrayObtainStyledAttributes.getColor(index, this.f7253r);
                } else if (index == R$styleable.MotionTelltales_telltales_velocityMode) {
                    this.f7252q = typedArrayObtainStyledAttributes.getInt(index, this.f7252q);
                } else if (index == R$styleable.MotionTelltales_telltales_tailScale) {
                    this.f7254s = typedArrayObtainStyledAttributes.getFloat(index, this.f7254s);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f7248m.setColor(this.f7253r);
        this.f7248m.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.f7251p);
        if (this.f7249n == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f7249n = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i11 = 0; i11 < 5; i11++) {
            float f11 = fArr[i11];
            for (int i12 = 0; i12 < 5; i12++) {
                float f12 = fArr[i12];
                this.f7249n.getViewVelocity(this, f12, f11, this.f7250o, this.f7252q);
                this.f7251p.mapVectors(this.f7250o);
                float f13 = width * f12;
                float f14 = height * f11;
                float[] fArr2 = this.f7250o;
                float f15 = fArr2[0];
                float f16 = this.f7254s;
                float f17 = f14 - (fArr2[1] * f16);
                this.f7251p.mapVectors(fArr2);
                canvas.drawLine(f13, f14, f13 - (f15 * f16), f17, this.f7248m);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f7208g = charSequence.toString();
        requestLayout();
    }
}
