package com.transsion.postdetail.util;

import com.transsnet.downloader.manager.DownloadEsHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;
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
@DebugMetadata(c = "com.transsion.postdetail.util.LocalFloatManager$saveHistoryInner$1", f = "LocalFloatManager.kt", l = {60, 62, 63}, m = "invokeSuspend")
public final class LocalFloatManager$saveHistoryInner$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ vz.a $floatBean;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalFloatManager$saveHistoryInner$1(vz.a aVar, Function0<Unit> function0, Continuation<? super LocalFloatManager$saveHistoryInner$1> continuation) {
        super(2, continuation);
        this.$floatBean = aVar;
        this.$callback = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalFloatManager$saveHistoryInner$1(this.$floatBean, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocalFloatManager$saveHistoryInner$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0086 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x009b A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Function0<Unit> function0;
        a2 a2VarC;
        LocalFloatManager$saveHistoryInner$1$1$2 localFloatManager$saveHistoryInner$1$1$2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            vz.a aVar = this.$floatBean;
            if (aVar != null) {
                function0 = this.$callback;
                String strO = aVar.o();
                if (strO != null) {
                    uo.b.f78622a.c("VideoFloat", "local-----saveHistory, ep:" + aVar.b() + ", progress:" + aVar.m(), true);
                    DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
                    long jM = aVar.m();
                    this.L$0 = function0;
                    this.label = 1;
                    if (downloadEsHelperA.S(strO, jM, this) == objE) {
                        return objE;
                    }
                }
                this.L$0 = function0;
                this.label = 2;
                if (r0.a(200L, this) == objE) {
                    return objE;
                }
                a2VarC = w0.c();
                localFloatManager$saveHistoryInner$1$1$2 = new LocalFloatManager$saveHistoryInner$1$1$2(function0, null);
                this.L$0 = null;
                this.label = 3;
                if (kotlinx.coroutines.h.g(a2VarC, localFloatManager$saveHistoryInner$1$1$2, this) == objE) {
                    return objE;
                }
            }
        } else if (i11 == 1) {
            function0 = (Function0) this.L$0;
            ResultKt.b(obj);
            this.L$0 = function0;
            this.label = 2;
            if (r0.a(200L, this) == objE) {
                return objE;
            }
            a2VarC = w0.c();
            localFloatManager$saveHistoryInner$1$1$2 = new LocalFloatManager$saveHistoryInner$1$1$2(function0, null);
            this.L$0 = null;
            this.label = 3;
            if (kotlinx.coroutines.h.g(a2VarC, localFloatManager$saveHistoryInner$1$1$2, this) == objE) {
                return objE;
            }
        } else if (i11 == 2) {
            function0 = (Function0) this.L$0;
            ResultKt.b(obj);
            a2VarC = w0.c();
            localFloatManager$saveHistoryInner$1$1$2 = new LocalFloatManager$saveHistoryInner$1$1$2(function0, null);
            this.L$0 = null;
            this.label = 3;
            if (kotlinx.coroutines.h.g(a2VarC, localFloatManager$saveHistoryInner$1$1$2, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
