package com.transsion.photoview;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.transsion.gslb.Utils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f54154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f54155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f54156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f54157d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference<ImageView> f54158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f54159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f54160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f54161h;

    public n(final ImageView imageView) {
        this.f54158e = new WeakReference<>(imageView);
        int iC = o.c(imageView.getContext());
        this.f54156c = iC;
        this.f54154a = (int) (((double) iC) * 0.15d);
        imageView.post(new Runnable() { // from class: com.transsion.photoview.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f54152a.j(imageView);
            }
        });
    }

    public final void c(float f11, float f12) {
        ImageView imageView = this.f54158e.get();
        if (imageView == null) {
            return;
        }
        if (Math.abs(f12) < this.f54156c / 4.0f) {
            float fAbs = 1.0f - (Math.abs(f12) / this.f54156c);
            this.f54157d = 1.0f - (Math.abs(f12) / (this.f54156c / 3.0f));
            imageView.setScaleX(fAbs);
            imageView.setScaleY(fAbs);
            ((ViewGroup) imageView.getParent()).setBackgroundColor(f(this.f54157d));
        }
        imageView.setTranslationY(f12);
    }

    public void d() {
        final ImageView imageView = this.f54158e.get();
        if (imageView != null && this.f54160g) {
            this.f54160g = false;
            if (Math.abs(this.f54155b) <= this.f54154a) {
                imageView.animate().setDuration(200L).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.photoview.l
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f54150a.i(imageView, valueAnimator);
                    }
                }).start();
            } else {
                this.f54155b = 0.0f;
                g();
            }
        }
    }

    public void e(float f11, float f12, float f13) {
        if (Math.abs(f11 - 1.0f) != 0.0f) {
            return;
        }
        this.f54155b = f13;
        if (Math.abs(f13) > 50.0f) {
            this.f54160g = true;
            c(f12, this.f54155b);
        }
    }

    public final int f(float f11) {
        int iMin = (int) (Math.min(1.0f, Math.max(0.0f, f11)) * 255.0f);
        if (iMin <= 102) {
            return this.f54161h;
        }
        String lowerCase = Integer.toHexString(iMin).toLowerCase();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Utils.SEPARATOR);
        sb2.append(lowerCase.length() < 2 ? "0" : "");
        sb2.append(lowerCase);
        sb2.append("000000");
        int color = Color.parseColor(sb2.toString());
        this.f54161h = color;
        return color;
    }

    public final void g() {
        ImageView imageView = this.f54158e.get();
        if (imageView == null) {
            return;
        }
        i iVar = this.f54159f;
        if (iVar != null) {
            iVar.a();
        }
        try {
            ((Activity) imageView.getContext()).finish();
            ((Activity) imageView.getContext()).overridePendingTransition(0, 0);
        } catch (Exception unused) {
        }
    }

    public boolean h() {
        return this.f54160g;
    }

    public final /* synthetic */ void i(ImageView imageView, ValueAnimator valueAnimator) {
        if (this.f54157d < valueAnimator.getAnimatedFraction()) {
            ((ViewGroup) imageView.getParent()).setBackgroundColor(f(valueAnimator.getAnimatedFraction()));
        }
    }

    public final /* synthetic */ void j(ImageView imageView) {
        ((ViewGroup) imageView.getParent()).setBackgroundColor(f(this.f54157d));
    }

    public void k(i iVar) {
        this.f54159f = iVar;
    }
}
