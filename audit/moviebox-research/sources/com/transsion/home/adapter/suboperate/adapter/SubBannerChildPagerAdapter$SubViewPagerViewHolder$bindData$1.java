package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.adapter.SubBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1", f = "SubBannerChildPagerAdapter.kt", l = {143}, m = "invokeSuspend")
public final class SubBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $coverUrl;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SubBannerChildPagerAdapter.SubViewPagerViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1(String str, SubBannerChildPagerAdapter.SubViewPagerViewHolder subViewPagerViewHolder, Continuation<? super SubBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1> continuation) {
        super(2, continuation);
        this.$coverUrl = str;
        this.this$0 = subViewPagerViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SubBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1 subBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1 = new SubBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1(this.$coverUrl, this.this$0, continuation);
        subBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1.L$0 = obj;
        return subBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AssetManager assets;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                String str = this.$coverUrl;
                if (str != null) {
                    SubBannerChildPagerAdapter.SubViewPagerViewHolder subViewPagerViewHolder = this.this$0;
                    Result.Companion companion = Result.Companion;
                    Context context = subViewPagerViewHolder.g().getContext();
                    InputStream inputStreamOpen = (context == null || (assets = context.getAssets()) == null) ? null : assets.open(str);
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    a2 a2VarC = w0.c();
                    SubBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1$1$1$1 subBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1$1$1$1 = new SubBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1$1$1$1(subViewPagerViewHolder, bitmapDecodeStream, null);
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(a2VarC, subBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1$1$1$1, this) == objE) {
                        return objE;
                    }
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        return Unit.f68710a;
    }
}
