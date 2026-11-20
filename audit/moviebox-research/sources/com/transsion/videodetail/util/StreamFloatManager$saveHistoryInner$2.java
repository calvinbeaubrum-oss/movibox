package com.transsion.videodetail.util;

import com.transsion.baselib.db.video.VideoDetailPlayDao;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import uo.b;

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
@DebugMetadata(c = "com.transsion.videodetail.util.StreamFloatManager$saveHistoryInner$2", f = "StreamFloatManager.kt", l = {87}, m = "invokeSuspend")
public final class StreamFloatManager$saveHistoryInner$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ vz.a $floatBean;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamFloatManager$saveHistoryInner$2(vz.a aVar, Continuation<? super StreamFloatManager$saveHistoryInner$2> continuation) {
        super(2, continuation);
        this.$floatBean = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StreamFloatManager$saveHistoryInner$2 streamFloatManager$saveHistoryInner$2 = new StreamFloatManager$saveHistoryInner$2(this.$floatBean, continuation);
        streamFloatManager$saveHistoryInner$2.L$0 = obj;
        return streamFloatManager$saveHistoryInner$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((StreamFloatManager$saveHistoryInner$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                vz.a aVar = this.$floatBean;
                if (aVar != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    b.f78622a.c("VideoFloat", "stream-----saveHistory, subjectId:" + aVar.q() + " time:" + jCurrentTimeMillis + ",se:" + aVar.p() + " ep:" + aVar.b() + ", progress:" + aVar.m(), true);
                    Result.Companion companion = Result.Companion;
                    VideoDetailPlayDao videoDetailPlayDaoL = StreamFloatManager.f60006b.l();
                    String strQ = aVar.q();
                    int iP = aVar.p();
                    int iB = aVar.b();
                    long jM = aVar.m();
                    this.label = 1;
                    if (videoDetailPlayDaoL.e(strQ, iP, iB, jCurrentTimeMillis, jM, this) == objE) {
                        return objE;
                    }
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            b.a.f(b.f78622a, "VideoFloat", "saveHistory--end", false, 4, null);
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        return Unit.f68710a;
    }
}
