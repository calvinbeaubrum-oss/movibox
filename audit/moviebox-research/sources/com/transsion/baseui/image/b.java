package com.transsion.baseui.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends RequestOptions {
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public b onlyRetrieveFromCache(boolean z11) {
        return (b) super.onlyRetrieveFromCache(z11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public b optionalCenterCrop() {
        return (b) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public b optionalCenterInside() {
        return (b) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public b optionalCircleCrop() {
        return (b) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public b optionalFitCenter() {
        return (b) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public b optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        return (b) super.optionalTransform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public <Y> b optionalTransform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (b) super.optionalTransform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public b override(int i11) {
        return (b) super.override(i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public b override(int i11, int i12) {
        return (b) super.override(i11, i12);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public b placeholder(int i11) {
        return (b) super.placeholder(i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public b placeholder(@Nullable Drawable drawable) {
        return (b) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public b priority(@NonNull Priority priority) {
        return (b) super.priority(priority);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public <Y> b set(@NonNull Option<Y> option, @NonNull Y y11) {
        return (b) super.set(option, y11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public b signature(@NonNull Key key) {
        return (b) super.signature(key);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public b sizeMultiplier(float f11) {
        return (b) super.sizeMultiplier(f11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public b skipMemoryCache(boolean z11) {
        return (b) super.skipMemoryCache(z11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public b theme(@Nullable Resources.Theme theme) {
        return (b) super.theme(theme);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public b timeout(int i11) {
        return (b) super.timeout(i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public b transform(@NonNull Transformation<Bitmap> transformation) {
        return (b) super.transform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public <Y> b transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (b) super.transform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @SafeVarargs
    @CheckResult
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final b transform(@NonNull Transformation<Bitmap>... transformationArr) {
        return (b) super.transform(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @Deprecated
    @SafeVarargs
    @CheckResult
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public final b transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return (b) super.transforms(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public b useAnimationPool(boolean z11) {
        return (b) super.useAnimationPool(z11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public b useUnlimitedSourceGeneratorsPool(boolean z11) {
        return (b) super.useUnlimitedSourceGeneratorsPool(z11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        return (b) super.apply(baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b autoClone() {
        return (b) super.autoClone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public b centerCrop() {
        return (b) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public b centerInside() {
        return (b) super.centerInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public b circleCrop() {
        return (b) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @CheckResult
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public b mo98clone() {
        return (b) super.mo98clone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public b decode(@NonNull Class<?> cls) {
        return (b) super.decode(cls);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public b disallowHardwareConfig() {
        return (b) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public b diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (b) super.diskCacheStrategy(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public b dontAnimate() {
        return (b) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public b dontTransform() {
        return (b) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public b downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return (b) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public b encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return (b) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public b encodeQuality(int i11) {
        return (b) super.encodeQuality(i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public b error(int i11) {
        return (b) super.error(i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public b error(@Nullable Drawable drawable) {
        return (b) super.error(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public b fallback(int i11) {
        return (b) super.fallback(i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public b fallback(@Nullable Drawable drawable) {
        return (b) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public b fitCenter() {
        return (b) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public b format(@NonNull DecodeFormat decodeFormat) {
        return (b) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public b frame(long j11) {
        return (b) super.frame(j11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public b lock() {
        return (b) super.lock();
    }
}
