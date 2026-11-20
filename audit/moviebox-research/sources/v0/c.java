package v0;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends b implements Animatable, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f78674f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f78671b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f78672c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f78673d = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Path f78675g = new Path();

    public c() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(30, 3600);
        this.f78674f = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(10000L);
        this.f78674f.setInterpolator(null);
        this.f78674f.setRepeatCount(-1);
        this.f78674f.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        float f11 = iWidth;
        float fMax = Math.max(1.0f, f11 / 22.0f);
        if (this.f78671b != iWidth || this.f78672c != iHeight) {
            this.f78675g.reset();
            Path path = this.f78675g;
            float f12 = f11 - fMax;
            float f13 = iHeight / 2.0f;
            Path.Direction direction = Path.Direction.CW;
            path.addCircle(f12, f13, fMax, direction);
            float f14 = f11 - (5.0f * fMax);
            this.f78675g.addRect(f14, f13 - fMax, f12, f13 + fMax, direction);
            this.f78675g.addCircle(f14, f13, fMax, direction);
            this.f78671b = iWidth;
            this.f78672c = iHeight;
        }
        canvas.save();
        float f15 = f11 / 2.0f;
        float f16 = iHeight / 2.0f;
        canvas.rotate(this.f78673d, f15, f16);
        for (int i11 = 0; i11 < 12; i11++) {
            this.f78670a.setAlpha((i11 + 5) * 17);
            canvas.rotate(30.0f, f15, f16);
            canvas.drawPath(this.f78675g, this.f78670a);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f78674f.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f78673d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f78674f.isRunning()) {
            return;
        }
        this.f78674f.addUpdateListener(this);
        this.f78674f.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f78674f.isRunning()) {
            this.f78674f.removeAllListeners();
            this.f78674f.removeAllUpdateListeners();
            this.f78674f.cancel();
        }
    }
}
