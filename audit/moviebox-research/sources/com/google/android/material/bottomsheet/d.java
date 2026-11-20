package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class d extends WindowInsetsAnimationCompat.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f36389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f36392d;

    public d(View view) {
        super(0);
        this.f36392d = new int[2];
        this.f36389a = view;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f36389a.setTranslationY(0.0f);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onPrepare(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f36389a.getLocationOnScreen(this.f36392d);
        this.f36390b = this.f36392d[1];
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    @NonNull
    public WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list) {
        for (WindowInsetsAnimationCompat windowInsetsAnimationCompat : list) {
            if ((windowInsetsAnimationCompat.getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
                this.f36389a.setTranslationY(ii.b.c(this.f36391c, 0, windowInsetsAnimationCompat.getInterpolatedFraction()));
                break;
            }
        }
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    @NonNull
    public WindowInsetsAnimationCompat.BoundsCompat onStart(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat, @NonNull WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        this.f36389a.getLocationOnScreen(this.f36392d);
        int i11 = this.f36390b - this.f36392d[1];
        this.f36391c = i11;
        this.f36389a.setTranslationY(i11);
        return boundsCompat;
    }
}
