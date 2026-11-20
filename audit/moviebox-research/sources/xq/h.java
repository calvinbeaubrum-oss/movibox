package xq;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f80675a = new h();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends CustomTarget<GifDrawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<GifDrawable, Unit> f80676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f80677b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super GifDrawable, Unit> function1, Function0<Unit> function0) {
            this.f80676a = function1;
            this.f80677b = function0;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(GifDrawable resource, Transition<? super GifDrawable> transition) {
            Intrinsics.g(resource, "resource");
            this.f80676a.invoke(resource);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            this.f80677b.invoke();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends CustomTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Bitmap, Unit> f80678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f80679b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Bitmap, Unit> function1, Function0<Unit> function0) {
            this.f80678a = function1;
            this.f80679b = function0;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            this.f80679b.invoke();
        }

        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
            Intrinsics.g(resource, "resource");
            this.f80678a.invoke(resource);
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }
    }

    public final void a(Context context, String str, Function0<Unit> onLoadFailed, Function1<? super GifDrawable, Unit> onResourceReady) {
        Intrinsics.g(context, "context");
        Intrinsics.g(onLoadFailed, "onLoadFailed");
        Intrinsics.g(onResourceReady, "onResourceReady");
        Glide.with(context).asGif().diskCacheStrategy(DiskCacheStrategy.ALL).load2(str).into(new a(onResourceReady, onLoadFailed));
    }

    public final void b(Context context, String str, Function0<Unit> onLoadFailed, Function1<? super Bitmap, Unit> onResourceReady) {
        Intrinsics.g(context, "context");
        Intrinsics.g(onLoadFailed, "onLoadFailed");
        Intrinsics.g(onResourceReady, "onResourceReady");
        Glide.with(context).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).load2(str).into(new b(onResourceReady, onLoadFailed));
    }
}
