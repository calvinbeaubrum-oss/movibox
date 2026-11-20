package o000oOoO;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.miniapp.R$styleable;
import p0.e;
import p0.i;
import p017OoooOo0.Oooo000;
import x0.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class OooO00o extends Oooo000 implements e {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public float f72243OooO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public boolean f72244OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public Paint f72245OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public boolean f72246OooO0o0;
    public int OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public int f72247OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public long f72248OooOO0;
    public boolean OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public TimeInterpolator f72249OooOO0o;

    public OooO00o(Context context, @Nullable AttributeSet attributeSet) {
        super(context, null, 0);
        this.OooO0oO = -1118482;
        this.f72247OooO0oo = -1615546;
        this.f72248OooOO0 = 0L;
        this.OooOO0O = false;
        this.f72249OooOO0o = new AccelerateDecelerateInterpolator();
        setMinimumHeight(b.a(60.0f));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R$styleable.MiniBallPulseFooter);
        Paint paint = new Paint();
        this.f72245OooO0o = paint;
        paint.setColor(-1);
        this.f72245OooO0o.setStyle(Paint.Style.FILL);
        this.f72245OooO0o.setAntiAlias(true);
        this.OooO0O0 = s0.b.f75911d;
        this.OooO0O0 = s0.b.f75915h[typedArrayObtainStyledAttributes.getInt(R$styleable.MiniBallPulseFooter_srlClassicsSpinnerStyle, 0)];
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniBallPulseFooter_srlNormalColor)) {
            OooO0O0(typedArrayObtainStyledAttributes.getColor(R$styleable.MiniBallPulseFooter_srlNormalColor, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniBallPulseFooter_srlAnimatingColor)) {
            OooO00o(typedArrayObtainStyledAttributes.getColor(R$styleable.MiniBallPulseFooter_srlAnimatingColor, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f72243OooO = b.a(4.0f);
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public int OooO00o(@NonNull i iVar, boolean z11) {
        this.OooOO0O = false;
        this.f72248OooOO0 = 0L;
        this.f72245OooO0o.setColor(this.OooO0oO);
        return 0;
    }

    public OooO00o OooO00o(int i11) {
        this.f72247OooO0oo = i11;
        this.f72246OooO0o0 = true;
        if (this.OooOO0O) {
            this.f72245OooO0o.setColor(i11);
        }
        return this;
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public void OooO00o(@NonNull i iVar, int i11, int i12) {
        if (this.OooOO0O) {
            return;
        }
        invalidate();
        this.OooOO0O = true;
        this.f72248OooOO0 = System.currentTimeMillis();
        this.f72245OooO0o.setColor(this.f72247OooO0oo);
    }

    public OooO00o OooO0O0(int i11) {
        this.OooO0oO = i11;
        this.f72244OooO0Oo = true;
        if (!this.OooOO0O) {
            this.f72245OooO0o.setColor(i11);
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float fMin = Math.min(width, height);
        float f11 = this.f72243OooO;
        float f12 = (fMin - (f11 * 2.0f)) / 6.0f;
        float f13 = f12 * 2.0f;
        float f14 = (width / 2.0f) - (f11 + f13);
        float f15 = height / 2.0f;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i11 = 0;
        while (i11 < 3) {
            int i12 = i11 + 1;
            long j11 = (jCurrentTimeMillis - this.f72248OooOO0) - ((long) (i12 * 120));
            float interpolation = this.f72249OooOO0o.getInterpolation(j11 > 0 ? (j11 % 750) / 750.0f : 0.0f);
            canvas.save();
            float f16 = i11;
            canvas.translate((this.f72243OooO * f16) + (f13 * f16) + f14, f15);
            if (interpolation < 0.5d) {
                float f17 = 1.0f - ((interpolation * 2.0f) * 0.7f);
                canvas.scale(f17, f17);
            } else {
                float f18 = ((interpolation * 2.0f) * 0.7f) - 0.4f;
                canvas.scale(f18, f18);
            }
            canvas.drawCircle(0.0f, 0.0f, f12, this.f72245OooO0o);
            canvas.restore();
            i11 = i12;
        }
        super.dispatchDraw(canvas);
        if (this.OooOO0O) {
            invalidate();
        }
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (!this.f72246OooO0o0 && iArr.length > 1) {
            int i11 = iArr[0];
            this.f72247OooO0oo = i11;
            this.f72246OooO0o0 = true;
            if (this.OooOO0O) {
                this.f72245OooO0o.setColor(i11);
            }
            this.f72246OooO0o0 = false;
        }
        if (this.f72244OooO0Oo) {
            return;
        }
        if (iArr.length > 1) {
            OooO0O0(iArr[1]);
        } else if (iArr.length > 0) {
            OooO0O0(c3.b.g(-1711276033, iArr[0]));
        }
        this.f72244OooO0Oo = false;
    }
}
