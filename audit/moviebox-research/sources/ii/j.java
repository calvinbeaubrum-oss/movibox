package ii;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f67216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f67217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public TimeInterpolator f67218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f67219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f67220e;

    public j(long j11, long j12) {
        this.f67218c = null;
        this.f67219d = 0;
        this.f67220e = 1;
        this.f67216a = j11;
        this.f67217b = j12;
    }

    public j(long j11, long j12, @NonNull TimeInterpolator timeInterpolator) {
        this.f67219d = 0;
        this.f67220e = 1;
        this.f67216a = j11;
        this.f67217b = j12;
        this.f67218c = timeInterpolator;
    }

    @NonNull
    public static j b(@NonNull ValueAnimator valueAnimator) {
        j jVar = new j(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        jVar.f67219d = valueAnimator.getRepeatCount();
        jVar.f67220e = valueAnimator.getRepeatMode();
        return jVar;
    }

    public static TimeInterpolator f(@NonNull ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return b.f67202b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return b.f67203c;
        }
        return interpolator instanceof DecelerateInterpolator ? b.f67204d : interpolator;
    }

    public void a(@NonNull Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f67216a;
    }

    public long d() {
        return this.f67217b;
    }

    @Nullable
    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f67218c;
        return timeInterpolator != null ? timeInterpolator : b.f67202b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (c() == jVar.c() && d() == jVar.d() && g() == jVar.g() && h() == jVar.h()) {
            return e().getClass().equals(jVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f67219d;
    }

    public int h() {
        return this.f67220e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    @NonNull
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }
}
