package com.transsion.home.viewmodel.preload;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.q1;

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
@DebugMetadata(c = "com.transsion.home.viewmodel.preload.PreloadTrendingData$loadOperatingDataFromNet$1", f = "PreloadTrendingData.kt", l = {136, 137}, m = "invokeSuspend")
public final class PreloadTrendingData$loadOperatingDataFromNet$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $version;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PreloadTrendingData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadTrendingData$loadOperatingDataFromNet$1(PreloadTrendingData preloadTrendingData, String str, Continuation<? super PreloadTrendingData$loadOperatingDataFromNet$1> continuation) {
        super(2, continuation);
        this.this$0 = preloadTrendingData;
        this.$version = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PreloadTrendingData$loadOperatingDataFromNet$1 preloadTrendingData$loadOperatingDataFromNet$1 = new PreloadTrendingData$loadOperatingDataFromNet$1(this.this$0, this.$version, continuation);
        preloadTrendingData$loadOperatingDataFromNet$1.L$0 = obj;
        return preloadTrendingData$loadOperatingDataFromNet$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PreloadTrendingData$loadOperatingDataFromNet$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        q1 q1Var;
        Object objE = a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                q1Var = (q1) this.L$0;
                ResultKt.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            this.this$0.f52794b = false;
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        k0 k0Var = (k0) this.L$0;
        q1 q1VarD = j.d(k0Var, null, null, new PreloadTrendingData$loadOperatingDataFromNet$1$op$1(this.this$0, this.$version, null), 3, null);
        this.this$0.A().n(null);
        q1 q1VarD2 = j.d(k0Var, null, null, new PreloadTrendingData$loadOperatingDataFromNet$1$games$1(this.this$0, null), 3, null);
        this.L$0 = q1VarD2;
        this.label = 1;
        if (q1VarD.join(this) == objE) {
            return objE;
        }
        q1Var = q1VarD2;
        this.L$0 = null;
        this.label = 2;
        if (q1Var.join(this) == objE) {
            return objE;
        }
        this.this$0.f52794b = false;
        return Unit.f68710a;
    }
}
