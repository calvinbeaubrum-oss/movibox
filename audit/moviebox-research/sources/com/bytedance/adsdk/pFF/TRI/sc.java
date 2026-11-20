package com.bytedance.adsdk.pFF.TRI;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sc extends ValueAnimator {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Set<ValueAnimator.AnimatorUpdateListener> f26155sc = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorListener> pFF = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorPauseListener> zY = new CopyOnWriteArraySet();

    public void ExN() {
        Iterator<Animator.AnimatorPauseListener> it = this.zY.iterator();
        while (it.hasNext()) {
            it.next().onAnimationResume(this);
        }
    }

    public void We() {
        Iterator<Animator.AnimatorPauseListener> it = this.zY.iterator();
        while (it.hasNext()) {
            it.next().onAnimationPause(this);
        }
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.pFF.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.zY.add(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f26155sc.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void pFF() {
        Iterator<Animator.AnimatorListener> it = this.pFF.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    public void pFF(boolean z11) {
        for (Animator.AnimatorListener animatorListener : this.pFF) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z11);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.pFF.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.f26155sc.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.pFF.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.zY.remove(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f26155sc.remove(animatorUpdateListener);
    }

    public void sc() {
        Iterator<Animator.AnimatorListener> it = this.pFF.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    public void sc(boolean z11) {
        for (Animator.AnimatorListener animatorListener : this.pFF) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z11);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j11) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j11) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    public void zY() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.f26155sc.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }
}
