package com.transsnet.downloader.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.transsion.baseui.R$mipmap;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.util.DownloadUtilKt$loadImageWithBuiltIn$1", f = "DownloadUtil.kt", l = {}, m = "invokeSuspend")
public final class DownloadUtilKt$loadImageWithBuiltIn$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ String $url;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadUtilKt$loadImageWithBuiltIn$1(Context context, String str, ImageView imageView, Continuation<? super DownloadUtilKt$loadImageWithBuiltIn$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$url = str;
        this.$imageView = imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ImageView imageView, Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ImageView imageView) {
        imageView.setImageResource(R$mipmap.ic_default_video);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadUtilKt$loadImageWithBuiltIn$1(this.$context, this.$url, this.$imageView, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadUtilKt$loadImageWithBuiltIn$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        try {
            InputStream inputStreamOpen = this.$context.getAssets().open(this.$url);
            final ImageView imageView = this.$imageView;
            final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
            imageView.post(new Runnable() { // from class: com.transsnet.downloader.util.l
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadUtilKt$loadImageWithBuiltIn$1.g(imageView, bitmapDecodeStream);
                }
            });
        } catch (Exception unused) {
            final ImageView imageView2 = this.$imageView;
            imageView2.post(new Runnable() { // from class: com.transsnet.downloader.util.m
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadUtilKt$loadImageWithBuiltIn$1.h(imageView2);
                }
            });
        }
        return Unit.f68710a;
    }
}
