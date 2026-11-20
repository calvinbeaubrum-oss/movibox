package com.transsion.baseui.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import java.io.File;
import java.net.URL;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class c<TranscodeType> extends RequestBuilder<TranscodeType> {
    public c(@NonNull Glide glide, @NonNull RequestManager requestManager, @NonNull Class<TranscodeType> cls, @NonNull Context context) {
        super(glide, requestManager, cls, context);
    }

    public c(@NonNull Class<TranscodeType> cls, @NonNull RequestBuilder<?> requestBuilder) {
        super(cls, requestBuilder);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> format(@NonNull DecodeFormat decodeFormat) {
        return (c) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> frame(long j11) {
        return (c) super.frame(j11);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public c<File> getDownloadOnlyRequest() {
        return new c(File.class, this).apply(RequestBuilder.DOWNLOAD_ONLY_OPTIONS);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> listener(@Nullable RequestListener<TranscodeType> requestListener) {
        return (c) super.listener(requestListener);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable Bitmap bitmap) {
        return (c) super.load2(bitmap);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable Drawable drawable) {
        return (c) super.load2(drawable);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable Uri uri) {
        return (c) super.load2(uri);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable File file) {
        return (c) super.load2(file);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable Integer num) {
        return (c) super.load2(num);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable Object obj) {
        return (c) super.load2(obj);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable String str) {
        return (c) super.load2(str);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable URL url) {
        return (c) super.load2(url);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable byte[] bArr) {
        return (c) super.load2(bArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> lock() {
        return (c) super.lock();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> onlyRetrieveFromCache(boolean z11) {
        return (c) super.onlyRetrieveFromCache(z11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> optionalCenterCrop() {
        return (c) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> optionalCenterInside() {
        return (c) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> optionalCircleCrop() {
        return (c) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> optionalFitCenter() {
        return (c) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        return (c) super.optionalTransform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public <Y> c<TranscodeType> optionalTransform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (c) super.optionalTransform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> override(int i11) {
        return (c) super.override(i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> override(int i11, int i12) {
        return (c) super.override(i11, i12);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> placeholder(int i11) {
        return (c) super.placeholder(i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> placeholder(@Nullable Drawable drawable) {
        return (c) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> priority(@NonNull Priority priority) {
        return (c) super.priority(priority);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> addListener(@Nullable RequestListener<TranscodeType> requestListener) {
        return (c) super.addListener(requestListener);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public <Y> c<TranscodeType> set(@NonNull Option<Y> option, @NonNull Y y11) {
        return (c) super.set(option, y11);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        return (c) super.apply(baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> signature(@NonNull Key key) {
        return (c) super.signature(key);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> autoClone() {
        return (c) super.autoClone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> sizeMultiplier(float f11) {
        return (c) super.sizeMultiplier(f11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> centerCrop() {
        return (c) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> skipMemoryCache(boolean z11) {
        return (c) super.skipMemoryCache(z11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> theme(@Nullable Resources.Theme theme) {
        return (c) super.theme(theme);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> centerInside() {
        return (c) super.centerInside();
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> thumbnail(float f11) {
        return (c) super.thumbnail(f11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> circleCrop() {
        return (c) super.circleCrop();
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        return (c) super.thumbnail(requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    @CheckResult
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> mo98clone() {
        return (c) super.mo98clone();
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> thumbnail(@Nullable List<RequestBuilder<TranscodeType>> list) {
        return (c) super.thumbnail(list);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @SafeVarargs
    @CheckResult
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public final c<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType>... requestBuilderArr) {
        return (c) super.thumbnail(requestBuilderArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> decode(@NonNull Class<?> cls) {
        return (c) super.decode(cls);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> timeout(int i11) {
        return (c) super.timeout(i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> disallowHardwareConfig() {
        return (c) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> transform(@NonNull Transformation<Bitmap> transformation) {
        return (c) super.transform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (c) super.diskCacheStrategy(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public <Y> c<TranscodeType> transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (c) super.transform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> dontAnimate() {
        return (c) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> transform(@NonNull Transformation<Bitmap>... transformationArr) {
        return (c) super.transform(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> dontTransform() {
        return (c) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return (c) super.transforms(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return (c) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> transition(@NonNull TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        return (c) super.transition(transitionOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return (c) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> useAnimationPool(boolean z11) {
        return (c) super.useAnimationPool(z11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> encodeQuality(int i11) {
        return (c) super.encodeQuality(i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean z11) {
        return (c) super.useUnlimitedSourceGeneratorsPool(z11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> error(int i11) {
        return (c) super.error(i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> error(@Nullable Drawable drawable) {
        return (c) super.error(drawable);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> error(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        return (c) super.error((RequestBuilder) requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> error(Object obj) {
        return (c) super.error(obj);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> fallback(int i11) {
        return (c) super.fallback(i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> fallback(@Nullable Drawable drawable) {
        return (c) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public c<TranscodeType> fitCenter() {
        return (c) super.fitCenter();
    }
}
