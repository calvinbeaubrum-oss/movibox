package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class z extends k6.j {

    /* JADX INFO: compiled from: source.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f37120a;

        public a(TextView textView) {
            this.f37120a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f37120a.setScaleX(fFloatValue);
            this.f37120a.setScaleY(fFloatValue);
        }
    }

    private void i0(@NonNull k6.w wVar) {
        View view = wVar.f68417b;
        if (view instanceof TextView) {
            wVar.f68416a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // k6.j
    public void g(@NonNull k6.w wVar) {
        i0(wVar);
    }

    @Override // k6.j
    public void k(@NonNull k6.w wVar) {
        i0(wVar);
    }

    @Override // k6.j
    public Animator o(@NonNull ViewGroup viewGroup, @Nullable k6.w wVar, @Nullable k6.w wVar2) {
        if (wVar == null || wVar2 == null || !(wVar.f68417b instanceof TextView)) {
            return null;
        }
        View view = wVar2.f68417b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map<String, Object> map = wVar.f68416a;
        Map<String, Object> map2 = wVar2.f68416a;
        float fFloatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float fFloatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new a(textView));
        return valueAnimatorOfFloat;
    }
}
