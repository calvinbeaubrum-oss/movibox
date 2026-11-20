package com.transsion.baseui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d extends RequestManager {
    public d(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d addDefaultRequestListener(RequestListener<Object> requestListener) {
        return (d) super.addDefaultRequestListener(requestListener);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized d applyDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        return (d) super.applyDefaultRequestOptions(requestOptions);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public <ResourceType> c<ResourceType> as(@NonNull Class<ResourceType> cls) {
        return new c<>(this.glide, this, cls, this.context);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public c<Bitmap> asBitmap() {
        return (c) super.asBitmap();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public c<Drawable> asDrawable() {
        return (c) super.asDrawable();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public c<File> asFile() {
        return (c) super.asFile();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public c<GifDrawable> asGif() {
        return (c) super.asGif();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public c<File> download(@Nullable Object obj) {
        return (c) super.download(obj);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public c<File> downloadOnly() {
        return (c) super.downloadOnly();
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<Drawable> load2(@Nullable Bitmap bitmap) {
        return (c) super.load2(bitmap);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<Drawable> load2(@Nullable Drawable drawable) {
        return (c) super.load2(drawable);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<Drawable> load2(@Nullable Uri uri) {
        return (c) super.load2(uri);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<Drawable> load2(@Nullable File file) {
        return (c) super.load2(file);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<Drawable> load2(@Nullable Integer num) {
        return (c) super.load2(num);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<Drawable> load2(@Nullable Object obj) {
        return (c) super.load2(obj);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<Drawable> load2(@Nullable String str) {
        return (c) super.load2(str);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<Drawable> load2(@Nullable URL url) {
        return (c) super.load2(url);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<Drawable> load2(@Nullable byte[] bArr) {
        return (c) super.load2(bArr);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public synchronized d setDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        return (d) super.setDefaultRequestOptions(requestOptions);
    }

    @Override // com.bumptech.glide.RequestManager
    public void setRequestOptions(@NonNull RequestOptions requestOptions) {
        if (requestOptions instanceof b) {
            super.setRequestOptions(requestOptions);
        } else {
            super.setRequestOptions(new b().apply(requestOptions));
        }
    }
}
