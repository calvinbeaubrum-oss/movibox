package com.transsion.baselib.net;

import com.transsion.mb.config.download.RequestConfig;
import com.transsion.memberapi.IMemberApi;
import com.transsion.wrapperadapi.IWrapperAdApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "com.transsion.baselib.net.AppLifeStatusInterceptor$requestForBackToForeground$1", f = "AppLifeStatusInterceptor.kt", l = {62}, m = "invokeSuspend")
public final class AppLifeStatusInterceptor$requestForBackToForeground$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;

    public AppLifeStatusInterceptor$requestForBackToForeground$1(Continuation<? super AppLifeStatusInterceptor$requestForBackToForeground$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppLifeStatusInterceptor$requestForBackToForeground$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((AppLifeStatusInterceptor$requestForBackToForeground$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            RequestConfig.f53099a.l();
            IWrapperAdApi iWrapperAdApi = (IWrapperAdApi) com.alibaba.android.arouter.launcher.a.d().h(IWrapperAdApi.class);
            this.label = 1;
            if (iWrapperAdApi.s1(this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Object objH = com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        Intrinsics.f(objH, "getInstance().navigation(IMemberApi::class.java)");
        IMemberApi.a.a((IMemberApi) objH, null, 1, null);
        return Unit.f68710a;
    }
}
