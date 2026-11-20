package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.home.adapter.trending.provider.OpNumberRankProvider$NumberRankAdapter$convert$2", f = "OpNumberRankProvider.kt", l = {127}, m = "invokeSuspend")
public final class OpNumberRankProvider$NumberRankAdapter$convert$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageView $coverImage;
    final /* synthetic */ Subject $item;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpNumberRankProvider$NumberRankAdapter$convert$2(Subject subject, ImageView imageView, Continuation<? super OpNumberRankProvider$NumberRankAdapter$convert$2> continuation) {
        super(2, continuation);
        this.$item = subject;
        this.$coverImage = imageView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OpNumberRankProvider$NumberRankAdapter$convert$2(this.$item, this.$coverImage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((OpNumberRankProvider$NumberRankAdapter$convert$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String url;
        AssetManager assets;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            Cover cover = this.$item.getCover();
            if (cover != null && (url = cover.getUrl()) != null) {
                ImageView imageView = this.$coverImage;
                Context context = imageView.getContext();
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(url));
                a2 a2VarC = w0.c();
                OpNumberRankProvider$NumberRankAdapter$convert$2$1$1 opNumberRankProvider$NumberRankAdapter$convert$2$1$1 = new OpNumberRankProvider$NumberRankAdapter$convert$2$1$1(imageView, bitmapDecodeStream, null);
                this.label = 1;
                if (kotlinx.coroutines.h.g(a2VarC, opNumberRankProvider$NumberRankAdapter$convert$2$1$1, this) == objE) {
                    return objE;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
