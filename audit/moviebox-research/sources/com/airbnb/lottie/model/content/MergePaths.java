package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import c7.c;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieFeatureFlag;
import com.airbnb.lottie.h;
import g7.f;
import x6.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class MergePaths implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MergePathsMode f15162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15163c;

    /* JADX INFO: compiled from: source.java */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i11) {
            if (i11 == 1) {
                return MERGE;
            }
            if (i11 == 2) {
                return ADD;
            }
            if (i11 == 3) {
                return SUBTRACT;
            }
            if (i11 != 4) {
                return i11 != 5 ? MERGE : EXCLUDE_INTERSECTIONS;
            }
            return INTERSECT;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z11) {
        this.f15161a = str;
        this.f15162b = mergePathsMode;
        this.f15163c = z11;
    }

    @Override // c7.c
    @Nullable
    public x6.c a(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar) {
        if (lottieDrawable.n0(LottieFeatureFlag.MergePathsApi19)) {
            return new l(this);
        }
        f.c("Animation contains merge paths but they are disabled.");
        return null;
    }

    public MergePathsMode b() {
        return this.f15162b;
    }

    public String c() {
        return this.f15161a;
    }

    public boolean d() {
        return this.f15163c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f15162b + '}';
    }
}
