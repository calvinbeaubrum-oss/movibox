package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ii.i;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface b {
    void a();

    @Nullable
    i b();

    boolean c();

    void d(@NonNull Animator.AnimatorListener animatorListener);

    void e();

    int f();

    void g(@NonNull Animator.AnimatorListener animatorListener);

    void h();

    void i(@Nullable i iVar);

    AnimatorSet j();

    List<Animator.AnimatorListener> k();

    void l(@Nullable ExtendedFloatingActionButton.l lVar);

    void onAnimationStart(Animator animator);
}
