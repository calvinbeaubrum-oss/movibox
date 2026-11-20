package com.transsion.upload.log;

import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.upload.bean.LoggerSwitchBean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "com.transsion.upload.log.UploadLoggerManager$requestConfig$1", f = "UploadLoggerManager.kt", l = {RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH}, m = "invokeSuspend")
public final class UploadLoggerManager$requestConfig$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;

    public UploadLoggerManager$requestConfig$1(Continuation<? super UploadLoggerManager$requestConfig$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UploadLoggerManager$requestConfig$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((UploadLoggerManager$requestConfig$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                Result.Companion companion = Result.Companion;
                a aVarG = UploadLoggerManager.f59261a.g();
                this.label = 1;
                obj = a.C0608a.a(aVarG, null, this, 1, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            b.a aVar = b.f78622a;
            LoggerSwitchBean loggerSwitchBean = (LoggerSwitchBean) baseDto.getData();
            b.a.f(aVar, "UploadLoggerManager", "retrieve=" + (loggerSwitchBean != null ? loggerSwitchBean.getRetrieve() : null), false, 4, null);
            LoggerSwitchBean loggerSwitchBean2 = (LoggerSwitchBean) baseDto.getData();
            if (loggerSwitchBean2 != null && Intrinsics.b(loggerSwitchBean2.getRetrieve(), Boxing.a(true))) {
                UploadLoggerManager.m(UploadLoggerManager.f59261a, null, 1, null);
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        return Unit.f68710a;
    }
}
