package ls;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ValueAnimator.AnimatorUpdateListener f70371a = new C0754a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f70372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f70373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f70374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public ValueAnimator f70375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public com.transsion.baseui.widget.shimmer.a f70376f;

    /* JADX INFO: renamed from: ls.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0754a implements ValueAnimator.AnimatorUpdateListener {
        public C0754a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.invalidateSelf();
        }
    }

    public a() {
        Paint paint = new Paint();
        this.f70372b = paint;
        this.f70373c = new Rect();
        this.f70374d = new Matrix();
        paint.setAntiAlias(true);
    }

    public boolean a() {
        ValueAnimator valueAnimator = this.f70375e;
        return valueAnimator != null && valueAnimator.isStarted();
    }

    public void b() {
        com.transsion.baseui.widget.shimmer.a aVar;
        ValueAnimator valueAnimator = this.f70375e;
        if (valueAnimator == null || valueAnimator.isStarted() || (aVar = this.f70376f) == null || !aVar.f51583p || getCallback() == null) {
            return;
        }
        this.f70375e.start();
    }

    public final float c(float f11, float f12, float f13) {
        return f11 + ((f12 - f11) * f13);
    }

    public void d(@Nullable com.transsion.baseui.widget.shimmer.a aVar) {
        this.f70376f = aVar;
        if (aVar != null) {
            this.f70372b.setXfermode(new PorterDuffXfermode(this.f70376f.f51584q ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        i();
        j();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float fC;
        float fC2;
        if (this.f70376f == null || this.f70372b.getShader() == null) {
            return;
        }
        float fTan = (float) Math.tan(Math.toRadians(this.f70376f.f51581n));
        float fHeight = this.f70373c.height() + (this.f70373c.width() * fTan);
        float fWidth = this.f70373c.width() + (fTan * this.f70373c.height());
        ValueAnimator valueAnimator = this.f70375e;
        float f11 = 0.0f;
        float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
        int i11 = this.f70376f.f51571d;
        if (i11 != 1) {
            if (i11 == 2) {
                fC2 = c(fWidth, -fWidth, animatedFraction);
            } else if (i11 != 3) {
                fC2 = c(-fWidth, fWidth, animatedFraction);
            } else {
                fC = c(fHeight, -fHeight, animatedFraction);
            }
            f11 = fC2;
            fC = 0.0f;
        } else {
            fC = c(-fHeight, fHeight, animatedFraction);
        }
        this.f70374d.reset();
        this.f70374d.setRotate(this.f70376f.f51581n, this.f70373c.width() / 2.0f, this.f70373c.height() / 2.0f);
        this.f70374d.postTranslate(f11, fC);
        this.f70372b.getShader().setLocalMatrix(this.f70374d);
        canvas.drawRect(this.f70373c, this.f70372b);
    }

    public void e(Animator.AnimatorListener animatorListener) {
        ValueAnimator valueAnimator = this.f70375e;
        if (valueAnimator != null) {
            ArrayList<Animator.AnimatorListener> listeners = valueAnimator.getListeners();
            if (listeners != null && listeners.size() > 0) {
                listeners.clear();
            }
            this.f70375e.addListener(animatorListener);
        }
    }

    public void f() {
        if (this.f70375e == null || a() || getCallback() == null) {
            return;
        }
        this.f70375e.start();
    }

    public void g(int i11, AnimatorListenerAdapter animatorListenerAdapter) {
        com.transsion.baseui.widget.shimmer.a aVar;
        if (a() || getCallback() == null || (aVar = this.f70376f) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f70375e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        } else {
            this.f70375e = ValueAnimator.ofFloat(0.0f, (aVar.f51588u / aVar.f51587t) + 1.0f);
        }
        this.f70375e.setRepeatMode(this.f70376f.f51586s);
        this.f70375e.setRepeatCount(i11);
        ValueAnimator valueAnimator2 = this.f70375e;
        com.transsion.baseui.widget.shimmer.a aVar2 = this.f70376f;
        valueAnimator2.setDuration(aVar2.f51587t + aVar2.f51588u);
        this.f70375e.addUpdateListener(this.f70371a);
        if (animatorListenerAdapter != null) {
            this.f70375e.addListener(animatorListenerAdapter);
        }
        this.f70375e.start();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        com.transsion.baseui.widget.shimmer.a aVar = this.f70376f;
        return (aVar == null || !(aVar.f51582o || aVar.f51584q)) ? -1 : -3;
    }

    public void h() {
        if (this.f70375e == null || !a()) {
            return;
        }
        this.f70375e.end();
        this.f70375e.cancel();
    }

    public final void i() {
        com.transsion.baseui.widget.shimmer.a aVar;
        Shader radialGradient;
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (iWidth == 0 || iHeight == 0 || (aVar = this.f70376f) == null) {
            return;
        }
        int iD = aVar.d(iWidth);
        int iA = this.f70376f.a(iHeight);
        com.transsion.baseui.widget.shimmer.a aVar2 = this.f70376f;
        boolean z11 = true;
        if (aVar2.f51574g != 1) {
            int i11 = aVar2.f51571d;
            if (i11 != 1 && i11 != 3) {
                z11 = false;
            }
            if (z11) {
                iD = 0;
            }
            if (!z11) {
                iA = 0;
            }
            float f11 = iA;
            com.transsion.baseui.widget.shimmer.a aVar3 = this.f70376f;
            radialGradient = new LinearGradient(0.0f, 0.0f, iD, f11, aVar3.f51569b, aVar3.f51568a, Shader.TileMode.CLAMP);
        } else {
            float f12 = iA / 2.0f;
            float fMax = (float) (((double) Math.max(iD, iA)) / Math.sqrt(2.0d));
            com.transsion.baseui.widget.shimmer.a aVar4 = this.f70376f;
            radialGradient = new RadialGradient(iD / 2.0f, f12, fMax, aVar4.f51569b, aVar4.f51568a, Shader.TileMode.CLAMP);
        }
        this.f70372b.setShader(radialGradient);
    }

    public final void j() {
        boolean zIsStarted;
        if (this.f70376f == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f70375e;
        if (valueAnimator != null) {
            zIsStarted = valueAnimator.isStarted();
            this.f70375e.cancel();
            this.f70375e.removeAllUpdateListeners();
        } else {
            zIsStarted = false;
        }
        com.transsion.baseui.widget.shimmer.a aVar = this.f70376f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, (aVar.f51588u / aVar.f51587t) + 1.0f);
        this.f70375e = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setRepeatMode(this.f70376f.f51586s);
        this.f70375e.setRepeatCount(this.f70376f.f51585r);
        ValueAnimator valueAnimator2 = this.f70375e;
        com.transsion.baseui.widget.shimmer.a aVar2 = this.f70376f;
        valueAnimator2.setDuration(aVar2.f51587t + aVar2.f51588u);
        this.f70375e.addUpdateListener(this.f70371a);
        if (zIsStarted) {
            this.f70375e.start();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f70373c.set(0, 0, rect.width(), rect.height());
        i();
        b();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
