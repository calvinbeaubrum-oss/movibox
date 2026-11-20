package com.bytedance.sdk.component.adexpress.dynamic.animation.sc;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.cJ;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class We implements cJ {
    com.bytedance.sdk.component.adexpress.dynamic.We.sc pFF;
    public View zY;
    private Set<ScheduledFuture<?>> We = new HashSet();

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public List<ObjectAnimator> f26778sc = sc();

    /* JADX INFO: compiled from: source.java */
    public class sc implements Runnable {
        ScheduledFuture<?> pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        ObjectAnimator f26781sc;

        public sc(ObjectAnimator objectAnimator) {
            this.f26781sc = objectAnimator;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY() != null) {
                com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().zY().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.sc.We.sc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        sc.this.f26781sc.resume();
                    }
                });
                if (this.pFF != null) {
                    We.this.We.remove(this.pFF);
                }
            }
        }

        public void sc(ScheduledFuture<?> scheduledFuture) {
            this.pFF = scheduledFuture;
        }
    }

    public We(View view, com.bytedance.sdk.component.adexpress.dynamic.We.sc scVar) {
        this.zY = view;
        this.pFF = scVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.cJ
    public void pFF() {
        List<ObjectAnimator> list = this.f26778sc;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.We.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    public ObjectAnimator sc(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.pFF.SR() * 1000.0d));
        if (this.pFF.BT() > 0) {
            objectAnimator.setRepeatCount(this.pFF.BT() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!"normal".equals(this.pFF.dE())) {
            if ("alternate".equals(this.pFF.dE()) || "alternate-reverse".equals(this.pFF.dE())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.pFF.Ql())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.pFF.dE())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.pFF.dE())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.sc.We.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    We.this.zY.setVisibility(0);
                    if (We.this.zY.getParent() instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI) {
                        ((View) We.this.zY.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }

    public abstract List<ObjectAnimator> sc();

    public void zY() {
        List<ObjectAnimator> list = this.f26778sc;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.pFF.Xc() > 0.0d) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.sc.We.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        objectAnimator.pause();
                        sc scVar = We.this.new sc(objectAnimator);
                        ScheduledFuture<?> scheduledFutureSc = com.bytedance.sdk.component.adexpress.We.We.sc(scVar, (long) (We.this.pFF.Xc() * 1000.0d), TimeUnit.MILLISECONDS);
                        scVar.sc(scheduledFutureSc);
                        We.this.We.add(scheduledFutureSc);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }
    }
}
