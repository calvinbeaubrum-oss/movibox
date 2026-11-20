package com.cloud.tmc.integration.defaultImpl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.cloud.tmc.integration.R$drawable;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.miniutils.util.x;
import fb.i;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class DefaultImageLoaderImpl implements ImageLoaderProxy {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends CustomViewTarget<ImageView, Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vc.a<Drawable> f30697a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageView imageView, vc.a<Drawable> aVar) {
            super(imageView);
            this.f30697a = aVar;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
            Intrinsics.g(resource, "resource");
            try {
                vc.a<Drawable> aVar = this.f30697a;
                if (aVar != null) {
                    aVar.b(resource);
                }
            } catch (Throwable th2) {
                TmcLogger.h("[DefaultImageLoaderImpl]: loadImg", th2);
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            try {
                vc.a<Drawable> aVar = this.f30697a;
                if (aVar != null) {
                    aVar.a("error");
                }
            } catch (Throwable th2) {
                TmcLogger.h("[DefaultImageLoaderImpl]: loadImg", th2);
            }
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void onResourceCleared(Drawable drawable) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vc.b f30698a;

        public b(vc.b bVar) {
            this.f30698a = bVar;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
            Intrinsics.g(resource, "resource");
            vc.b bVar = this.f30698a;
            if (bVar != null) {
                bVar.b(resource);
            }
        }

        @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            vc.b bVar = this.f30698a;
            if (bVar != null) {
                bVar.a("load failed");
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements RequestListener<GifDrawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vc.b f30699a;

        public c(vc.b bVar) {
            this.f30699a = bVar;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target<GifDrawable> target, DataSource dataSource, boolean z11) {
            vc.b bVar = this.f30699a;
            if (bVar == null) {
                return false;
            }
            bVar.b(null);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<GifDrawable> target, boolean z11) {
            String message;
            vc.b bVar = this.f30699a;
            if (bVar == null) {
                return false;
            }
            if (glideException == null || (message = glideException.getMessage()) == null) {
                message = "load error";
            }
            bVar.a(message);
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements RequestListener<GifDrawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Drawable, Unit> f30700a;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends l6.b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1<Drawable, Unit> f30701b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ GifDrawable f30702c;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Function1<? super Drawable, Unit> function1, GifDrawable gifDrawable) {
                this.f30701b = function1;
                this.f30702c = gifDrawable;
            }

            @Override // l6.b
            public void b(Drawable drawable) {
                super.b(drawable);
                Function1<Drawable, Unit> function1 = this.f30701b;
                if (function1 != null) {
                    function1.invoke(drawable);
                }
                this.f30702c.unregisterAnimationCallback(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super Drawable, Unit> function1) {
            this.f30700a = function1;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target<GifDrawable> target, DataSource dataSource, boolean z11) {
            if (gifDrawable == null) {
                return false;
            }
            Function1<Drawable, Unit> function1 = this.f30700a;
            gifDrawable.setLoopCount(1);
            gifDrawable.registerAnimationCallback(new a(function1, gifDrawable));
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<GifDrawable> target, boolean z11) {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements RequestListener<GifDrawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Drawable, Unit> f30703a;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends l6.b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1<Drawable, Unit> f30704b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ GifDrawable f30705c;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Function1<? super Drawable, Unit> function1, GifDrawable gifDrawable) {
                this.f30704b = function1;
                this.f30705c = gifDrawable;
            }

            @Override // l6.b
            public void b(Drawable drawable) {
                super.b(drawable);
                Function1<Drawable, Unit> function1 = this.f30704b;
                if (function1 != null) {
                    function1.invoke(drawable);
                }
                this.f30705c.unregisterAnimationCallback(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(Function1<? super Drawable, Unit> function1) {
            this.f30703a = function1;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target<GifDrawable> target, DataSource dataSource, boolean z11) {
            if (gifDrawable == null) {
                return false;
            }
            Function1<Drawable, Unit> function1 = this.f30703a;
            gifDrawable.setLoopCount(1);
            gifDrawable.registerAnimationCallback(new a(function1, gifDrawable));
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<GifDrawable> target, boolean z11) {
            return false;
        }
    }

    public final void a(Context context, RequestOptions requestOptions, String str, ImageView imageView) {
        try {
            if (isDestroy(context)) {
                return;
            }
            RequestManager requestManagerWith = Glide.with(context);
            requestManagerWith.applyDefaultRequestOptions(requestOptions);
            requestManagerWith.load2(str).into(imageView);
        } catch (Exception e11) {
            TmcLogger.h("[DefaultImageLoaderImpl]: glideLoad", e11);
        }
    }

    public final boolean isDestroy(Context context) {
        if (context == null) {
            return true;
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            return activity.isFinishing() || activity.isDestroyed();
        }
        if (!(context instanceof FragmentActivity)) {
            return false;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        return fragmentActivity.isFinishing() || fragmentActivity.isDestroyed();
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImg(Context context, int i11, int i12, ImageView imageView) {
        Intrinsics.g(context, "context");
        Intrinsics.g(imageView, "imageView");
        if (isDestroy(context)) {
            return;
        }
        try {
            RequestBuilder<Drawable> requestBuilderLoad2 = Glide.with(context).load2(Integer.valueOf(i11));
            Intrinsics.f(requestBuilderLoad2, "with(context).load(resId)");
            if (i11 != 0) {
                Cloneable cloneablePlaceholder = requestBuilderLoad2.placeholder(i12);
                Intrinsics.f(cloneablePlaceholder, "handle.placeholder(placeHolderResId)");
                requestBuilderLoad2 = (RequestBuilder) cloneablePlaceholder;
            }
            requestBuilderLoad2.into(imageView);
        } catch (Throwable th2) {
            TmcLogger.h("[DefaultImageLoaderImpl]: loadImg", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImg(Context context, int i11, int i12, ImageView imageView, vc.a<Drawable> aVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(imageView, "imageView");
        if (isDestroy(context)) {
            return;
        }
        try {
            RequestBuilder<Drawable> requestBuilderLoad2 = Glide.with(context).load2(Integer.valueOf(i11));
            Intrinsics.f(requestBuilderLoad2, "with(context).load(resId)");
            if (i12 != 0) {
                Cloneable cloneablePlaceholder = requestBuilderLoad2.placeholder(i12);
                Intrinsics.f(cloneablePlaceholder, "handle.placeholder(placeHolderResId)");
                requestBuilderLoad2 = (RequestBuilder) cloneablePlaceholder;
            }
            requestBuilderLoad2.into(new a(imageView, aVar));
        } catch (Throwable th2) {
            TmcLogger.h("[DefaultImageLoaderImpl]: loadImg", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImg(Context context, String url, ImageView imageView) {
        Intrinsics.g(context, "context");
        Intrinsics.g(url, "url");
        Intrinsics.g(imageView, "imageView");
        RequestOptions requestOptionsError = new RequestOptions().placeholder(R$drawable.mini_ic_palceholder).error(R$drawable.mini_ic_palceholder);
        Intrinsics.f(requestOptionsError, "RequestOptions().placeho…able.mini_ic_palceholder)");
        a(context, requestOptionsError, url, imageView);
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImg(Context context, String url, ImageView imageView, Drawable drawable) {
        Intrinsics.g(context, "context");
        Intrinsics.g(url, "url");
        Intrinsics.g(imageView, "imageView");
        RequestOptions requestOptionsError = new RequestOptions().placeholder(drawable).error(drawable);
        Intrinsics.f(requestOptionsError, "RequestOptions().placeho…older).error(placeHolder)");
        a(context, requestOptionsError, url, imageView);
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImg(Context context, String url, ImageView imageView, Drawable drawable, Drawable drawable2) {
        Intrinsics.g(context, "context");
        Intrinsics.g(url, "url");
        Intrinsics.g(imageView, "imageView");
        RequestOptions requestOptionsError = new RequestOptions().placeholder(drawable).error(drawable2);
        Intrinsics.f(requestOptionsError, "RequestOptions().placeho…older).error(errorHolder)");
        a(context, requestOptionsError, url, imageView);
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public Bitmap loadImgBitmap(Context context, String url) {
        Intrinsics.g(context, "context");
        Intrinsics.g(url, "url");
        if (isDestroy(context)) {
            return null;
        }
        try {
            RequestOptions requestOptionsBitmapTransform = RequestOptions.bitmapTransform(new i(x.a(8.0f)));
            Intrinsics.f(requestOptionsBitmapTransform, "bitmapTransform(RoundedC…rop(SizeUtils.dp2px(8f)))");
            RequestManager requestManagerWith = Glide.with(context);
            requestManagerWith.applyDefaultRequestOptions(requestOptionsBitmapTransform);
            FutureTarget<Bitmap> futureTargetSubmit = requestManagerWith.asBitmap().load2(url).submit();
            Intrinsics.f(futureTargetSubmit, "with(context)\n          …                .submit()");
            return futureTargetSubmit.get();
        } catch (Exception e11) {
            TmcLogger.h("[DefaultImageLoaderImpl]: loadImgBitmap", e11);
            return null;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImgBitmapNoRound(Context context, String url, vc.b bVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(url, "url");
        if (isDestroy(context)) {
            return;
        }
        try {
            Glide.with(context).asBitmap().load2(url).transform(new CenterCrop()).into(new b(bVar));
        } catch (Exception e11) {
            TmcLogger.h("[DefaultImageLoaderImpl]: loadImgBitmapNoRound", e11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public Bitmap loadImgBitmapSize(Context context, String url, int i11, int i12, int i13) {
        Intrinsics.g(context, "context");
        Intrinsics.g(url, "url");
        if (isDestroy(context)) {
            return null;
        }
        try {
            RequestOptions requestOptionsBitmapTransform = RequestOptions.bitmapTransform(new RoundedCorners(i13));
            Intrinsics.f(requestOptionsBitmapTransform, "bitmapTransform(RoundedCorners(roundingRadius))");
            RequestManager requestManagerWith = Glide.with(context);
            requestManagerWith.applyDefaultRequestOptions(requestOptionsBitmapTransform);
            FutureTarget futureTargetSubmit = requestManagerWith.asBitmap().load2(url).override(i11, i12).submit();
            Intrinsics.f(futureTargetSubmit, "with(context)\n          …                .submit()");
            return (Bitmap) futureTargetSubmit.get();
        } catch (Exception e11) {
            TmcLogger.h("[DefaultImageLoaderImpl]: loadImgBitmapSize", e11);
            return null;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public File loadImgFile(Context context, String url) {
        Intrinsics.g(context, "context");
        Intrinsics.g(url, "url");
        if (isDestroy(context)) {
            return null;
        }
        try {
            FutureTarget<File> futureTargetSubmit = Glide.with(context).asFile().load2(url).submit();
            Intrinsics.f(futureTargetSubmit, "with(context)\n          …                .submit()");
            return futureTargetSubmit.get();
        } catch (Exception e11) {
            TmcLogger.h("[DefaultImageLoaderImpl]: loadImgFile", e11);
            return null;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImgGifPlay(Context context, int i11, int i12, ImageView imageView) {
        Intrinsics.g(context, "context");
        Intrinsics.g(imageView, "imageView");
        try {
            if (isDestroy(context)) {
                return;
            }
            Glide.with(context).asGif().load2(Integer.valueOf(i11)).placeholder(i12).apply((BaseRequestOptions<?>) new RequestOptions().fitCenter().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA)).into(imageView);
        } catch (Exception e11) {
            TmcLogger.h("[DefaultImageLoaderImpl]: loadImgGifPlayOnce", e11);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImgGifPlay(Context context, File file, Drawable drawable, ImageView imageView) {
        Intrinsics.g(context, "context");
        Intrinsics.g(imageView, "imageView");
        try {
            if (isDestroy(context)) {
                return;
            }
            Glide.with(context).asGif().load2(file).placeholder(drawable).apply((BaseRequestOptions<?>) new RequestOptions().fitCenter().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA)).into(imageView);
        } catch (Exception e11) {
            TmcLogger.h("[DefaultImageLoaderImpl]: loadImgGifPlayOnce", e11);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImgGifPlay(Context context, File file, Drawable drawable, ImageView imageView, vc.b bVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(imageView, "imageView");
        Glide.with(context).asGif().load2(file).placeholder(drawable).listener(new c(bVar)).apply((BaseRequestOptions<?>) new RequestOptions().fitCenter().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA)).into(imageView);
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImgGifPlayOnce(Context context, int i11, int i12, ImageView imageView, Function1<? super Drawable, Unit> function1) {
        Intrinsics.g(context, "context");
        Intrinsics.g(imageView, "imageView");
        try {
            if (isDestroy(context)) {
                return;
            }
            Glide.with(context).asGif().load2(Integer.valueOf(i11)).placeholder(i12).listener(new d(function1)).apply((BaseRequestOptions<?>) new RequestOptions().fitCenter().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA)).into(imageView);
        } catch (Exception e11) {
            TmcLogger.h("[DefaultImageLoaderImpl]: loadImgGifPlayOnce", e11);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImgGifPlayOnce(Context context, File file, int i11, ImageView imageView, Function1<? super Drawable, Unit> function1) {
        Intrinsics.g(context, "context");
        Intrinsics.g(imageView, "imageView");
        try {
            if (isDestroy(context)) {
                return;
            }
            Glide.with(context).asGif().load2(file).placeholder(i11).listener(new e(function1)).apply((BaseRequestOptions<?>) new RequestOptions().fitCenter().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA)).into(imageView);
        } catch (Exception e11) {
            TmcLogger.h("[DefaultImageLoaderImpl]: loadImgGifPlayOnce", e11);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImgRoundCorners(Context context, File file, ImageView imageView, int i11, int i12) {
        Intrinsics.g(context, "context");
        Intrinsics.g(file, "file");
        Intrinsics.g(imageView, "imageView");
        RequestOptions requestOptionsPlaceholder = RequestOptions.bitmapTransform(new RoundedCorners(i11)).placeholder(i12);
        Intrinsics.f(requestOptionsPlaceholder, "bitmapTransform(RoundedC….placeholder(placeHolder)");
        RequestOptions requestOptions = requestOptionsPlaceholder;
        try {
            if (isDestroy(context)) {
                return;
            }
            RequestManager requestManagerWith = Glide.with(context);
            requestManagerWith.applyDefaultRequestOptions(requestOptions);
            requestManagerWith.load2(file).into(imageView);
        } catch (Exception e11) {
            TmcLogger.h("[DefaultImageLoaderImpl]: glideLoad", e11);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImgRoundCorners(Context context, String url, ImageView imageView, int i11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(url, "url");
        Intrinsics.g(imageView, "imageView");
        RequestOptions requestOptionsError = RequestOptions.bitmapTransform(new RoundedCorners(i11)).placeholder(R$drawable.mini_ic_palceholder).error(R$drawable.mini_ic_palceholder);
        Intrinsics.f(requestOptionsError, "bitmapTransform(RoundedC…able.mini_ic_palceholder)");
        a(context, requestOptionsError, url, imageView);
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImgRoundCorners(Context context, String url, ImageView imageView, int i11, int i12) {
        Intrinsics.g(context, "context");
        Intrinsics.g(url, "url");
        Intrinsics.g(imageView, "imageView");
        RequestOptions requestOptionsError = RequestOptions.bitmapTransform(new RoundedCorners(i11)).placeholder(i12).error(R$drawable.mini_ic_palceholder);
        Intrinsics.f(requestOptionsError, "bitmapTransform(RoundedC…able.mini_ic_palceholder)");
        a(context, requestOptionsError, url, imageView);
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImgRoundCorners(Context context, String url, ImageView imageView, int i11, int i12, int i13) {
        Intrinsics.g(context, "context");
        Intrinsics.g(url, "url");
        Intrinsics.g(imageView, "imageView");
        RequestOptions requestOptionsError = RequestOptions.bitmapTransform(new RoundedCorners(i11)).placeholder(i12).error(i13);
        Intrinsics.f(requestOptionsError, "bitmapTransform(RoundedC…      .error(errorHolder)");
        a(context, requestOptionsError, url, imageView);
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImgRoundCornersCenterCrop(Context context, String url, ImageView imageView, int i11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(url, "url");
        Intrinsics.g(imageView, "imageView");
        int i12 = R$drawable.mini_ic_palceholder;
        loadImgRoundCornersCenterCrop(context, url, imageView, i11, i12, i12);
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public void loadImgRoundCornersCenterCrop(Context context, String url, ImageView imageView, int i11, int i12, int i13) {
        Intrinsics.g(context, "context");
        Intrinsics.g(url, "url");
        Intrinsics.g(imageView, "imageView");
        RequestOptions requestOptionsError = RequestOptions.bitmapTransform(new i(i11)).placeholder(i12).error(i12);
        Intrinsics.f(requestOptionsError, "bitmapTransform(RoundedC…      .error(placeHolder)");
        a(context, requestOptionsError, url, imageView);
    }

    @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy
    public boolean queryImgIsExist(Context context, String str) {
        Intrinsics.g(context, "context");
        if (isDestroy(context)) {
            return false;
        }
        try {
            return Glide.with(context).asFile().load2(str).onlyRetrieveFromCache(true).submit().get() != 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}
