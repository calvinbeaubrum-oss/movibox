package com.mbridge.msdk.video.dynview.h;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private PropertyValuesHolder a(Property property, float f11) {
        float f12 = f11 - 0.2f;
        float f13 = f11 + 0.3f;
        return PropertyValuesHolder.ofKeyframe(property, Keyframe.ofFloat(0.0f, f11), Keyframe.ofFloat(0.1f, f11 - 0.4f), Keyframe.ofFloat(0.2f, f12), Keyframe.ofFloat(0.3f, f13), Keyframe.ofFloat(0.4f, f12), Keyframe.ofFloat(0.5f, f13), Keyframe.ofFloat(0.6f, f11 - 0.1f), Keyframe.ofFloat(0.7f, f13), Keyframe.ofFloat(0.8f, f11), Keyframe.ofFloat(0.9f, 0.1f + f11), Keyframe.ofFloat(1.0f, f11));
    }

    private PropertyValuesHolder b(Property property, float f11) {
        float f12 = (-2.0f) * f11;
        float f13 = f11 * 2.0f;
        return PropertyValuesHolder.ofKeyframe(property, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, f12), Keyframe.ofFloat(0.2f, f12), Keyframe.ofFloat(0.3f, f13), Keyframe.ofFloat(0.4f, f12), Keyframe.ofFloat(0.5f, f13), Keyframe.ofFloat(0.6f, f12), Keyframe.ofFloat(0.7f, f13), Keyframe.ofFloat(0.8f, f12), Keyframe.ofFloat(0.9f, f13), Keyframe.ofFloat(1.0f, 0.0f));
    }

    private PropertyValuesHolder c(Property property, float f11) {
        float f12 = f11 - 0.4f;
        return PropertyValuesHolder.ofKeyframe(property, Keyframe.ofFloat(0.0f, f11), Keyframe.ofFloat(0.1f, f12), Keyframe.ofFloat(0.2f, f12), Keyframe.ofFloat(0.3f, f11), Keyframe.ofFloat(0.4f, f11), Keyframe.ofFloat(0.5f, f11), Keyframe.ofFloat(0.6f, f11), Keyframe.ofFloat(0.7f, f11), Keyframe.ofFloat(0.8f, f11), Keyframe.ofFloat(0.9f, f11), Keyframe.ofFloat(1.0f, f11));
    }

    public final ObjectAnimator a(View view) {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, a(View.SCALE_X, 1.0f), a(View.SCALE_Y, 1.0f), b(View.ROTATION_X, 5.0f)).setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        duration.setRepeatCount(-1);
        return duration;
    }

    public final void a(final View view, int i11, int i12, int i13, int i14, long j11) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i11, i12);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mbridge.msdk.video.dynview.h.b.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                View view2 = view;
                if (view2 != null) {
                    view2.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    view.requestLayout();
                }
            }
        });
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(i13, i14);
        valueAnimatorOfInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mbridge.msdk.video.dynview.h.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                View view2 = view;
                if (view2 != null) {
                    view2.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    view.requestLayout();
                    if (view.getVisibility() != 0) {
                        view.setVisibility(0);
                    }
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfInt, valueAnimatorOfInt2);
        animatorSet.setDuration(j11);
        animatorSet.start();
    }

    public final void a(final View view, long j11) {
        if (view == null) {
            return;
        }
        int iF = ai.f(view.getContext().getApplicationContext());
        ValueAnimator valueAnimatorOfInt = view.getLayoutParams().width == 0 ? ValueAnimator.ofInt(0, iF) : ValueAnimator.ofInt(iF, 0);
        valueAnimatorOfInt.setDuration(j11);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mbridge.msdk.video.dynview.h.b.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                view.setLayoutParams(layoutParams);
            }
        });
        ValueAnimator valueAnimatorOfFloat = view.getLayoutParams().width == 0 ? ValueAnimator.ofFloat(0.0f, 1.0f) : ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(j11);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mbridge.msdk.video.dynview.h.b.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                view.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfInt, valueAnimatorOfFloat);
        animatorSet.start();
    }

    public final void a(final List<View> list, int i11, int i12, long j11) {
        ValueAnimator duration = ValueAnimator.ofInt(i11, i12).setDuration(j11);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mbridge.msdk.video.dynview.h.b.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                List list2 = list;
                if (list2 == null || list2.size() <= 0) {
                    return;
                }
                for (View view : list) {
                    if (view != null) {
                        view.setPadding(0, 0, 0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        view.requestLayout();
                    }
                }
            }
        });
        duration.start();
    }

    public final ObjectAnimator b(View view) {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, c(View.SCALE_X, 1.0f), c(View.SCALE_Y, 1.0f)).setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        duration.setRepeatCount(-1);
        return duration;
    }

    public final void b(final View view, long j11) {
        if (view != null) {
            view.setAlpha(1.0f);
            view.animate().alpha(0.0f).setDuration(j11).setListener(new Animator.AnimatorListener() { // from class: com.mbridge.msdk.video.dynview.h.b.1
                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                    View view2 = view;
                    if (view2 == null || !(view2 instanceof ViewGroup)) {
                        return;
                    }
                    ((ViewGroup) view2).removeAllViews();
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    View view2 = view;
                    if (view2 == null || !(view2 instanceof ViewGroup)) {
                        return;
                    }
                    ((ViewGroup) view2).removeAllViews();
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                }
            });
        }
    }

    public final ObjectAnimator c(View view) {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, b(View.ROTATION, 2.0f)).setDuration(1000L);
        duration.setRepeatCount(-1);
        return duration;
    }

    public final void c(View view, long j11) {
        if (view != null) {
            view.setVisibility(0);
            view.setAlpha(0.0f);
            view.animate().alpha(1.0f).setDuration(j11);
        }
    }
}
