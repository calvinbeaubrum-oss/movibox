package com.transsion.shorttv.utils;

import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.h;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.shorttv.utils.ShortTVFloatManager$saveHistoryInner$1", f = "ShortTVFloatManager.kt", l = {64, RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH}, m = "invokeSuspend")
public final class ShortTVFloatManager$saveHistoryInner$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ vz.a $floatBean;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVFloatManager$saveHistoryInner$1(vz.a aVar, Function0<Unit> function0, Continuation<? super ShortTVFloatManager$saveHistoryInner$1> continuation) {
        super(2, continuation);
        this.$floatBean = aVar;
        this.$callback = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVFloatManager$saveHistoryInner$1(this.$floatBean, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTVFloatManager$saveHistoryInner$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0089 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Function0<Unit> function0;
        a2 a2VarC;
        ShortTVFloatManager$saveHistoryInner$1$1$1 shortTVFloatManager$saveHistoryInner$1$1$1;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            vz.a aVar = this.$floatBean;
            if (aVar != null) {
                function0 = this.$callback;
                uo.b.a.f(uo.b.f78622a, "VideoFloat", "shorttv-----saveHistory, ep:" + aVar.b() + ", progress:" + aVar.m(), false, 4, null);
                ShortTVPlayDao shortTVPlayDaoH = ShortTVFloatManager.f57884b.h();
                String strQ = aVar.q();
                int iB = aVar.b();
                long jM = aVar.m();
                this.L$0 = function0;
                this.label = 1;
                if (shortTVPlayDaoH.e(strQ, iB, jM, this) == objE) {
                    return objE;
                }
                a2VarC = w0.c();
                shortTVFloatManager$saveHistoryInner$1$1$1 = new ShortTVFloatManager$saveHistoryInner$1$1$1(function0, null);
                this.L$0 = null;
                this.label = 2;
                if (h.g(a2VarC, shortTVFloatManager$saveHistoryInner$1$1$1, this) == objE) {
                    return objE;
                }
            }
        } else if (i11 == 1) {
            function0 = (Function0) this.L$0;
            ResultKt.b(obj);
            a2VarC = w0.c();
            shortTVFloatManager$saveHistoryInner$1$1$1 = new ShortTVFloatManager$saveHistoryInner$1$1$1(function0, null);
            this.L$0 = null;
            this.label = 2;
            if (h.g(a2VarC, shortTVFloatManager$saveHistoryInner$1$1$1, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
