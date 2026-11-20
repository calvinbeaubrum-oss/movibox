package com.transsion.ad;

import com.transsion.ad.hi.HiSavanaAdManager;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.ad.MBAd$initAd$2$1$sdkHi$1", f = "MBAd.kt", l = {118}, m = "invokeSuspend")
public final class MBAd$initAd$2$1$sdkHi$1 extends SuspendLambda implements Function2<k0, Continuation<? super String>, Object> {
    final /* synthetic */ MBAd.a $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MBAd$initAd$2$1$sdkHi$1(MBAd.a aVar, Continuation<? super MBAd$initAd$2$1$sdkHi$1> continuation) {
        super(2, continuation);
        this.$params = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MBAd$initAd$2$1$sdkHi$1(this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super String> continuation) {
        return ((MBAd$initAd$2$1$sdkHi$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return "HiSavana 广告SDK初始化完成";
        }
        ResultKt.b(obj);
        HiSavanaAdManager hiSavanaAdManager = HiSavanaAdManager.f50400a;
        String strD = this.$params.d();
        boolean zB = this.$params.b();
        boolean zG = this.$params.g();
        this.label = 1;
        return hiSavanaAdManager.d(strD, zB, zG, this) == objE ? objE : "HiSavana 广告SDK初始化完成";
    }
}
