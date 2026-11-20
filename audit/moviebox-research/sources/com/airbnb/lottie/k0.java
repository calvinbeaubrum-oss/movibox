package com.airbnb.lottie;

import android.annotation.SuppressLint;
import android.os.Build;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<LottieFeatureFlag> f15133a = new HashSet<>();

    @SuppressLint({"DefaultLocale"})
    public boolean a(LottieFeatureFlag lottieFeatureFlag, boolean z11) {
        if (!z11) {
            return this.f15133a.remove(lottieFeatureFlag);
        }
        if (Build.VERSION.SDK_INT >= lottieFeatureFlag.minRequiredSdkVersion) {
            return this.f15133a.add(lottieFeatureFlag);
        }
        g7.f.c(String.format("%s is not supported pre SDK %d", lottieFeatureFlag.name(), Integer.valueOf(lottieFeatureFlag.minRequiredSdkVersion)));
        return false;
    }

    public boolean b(LottieFeatureFlag lottieFeatureFlag) {
        return this.f15133a.contains(lottieFeatureFlag);
    }
}
