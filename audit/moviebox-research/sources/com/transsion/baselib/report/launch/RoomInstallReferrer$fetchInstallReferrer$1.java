package com.transsion.baselib.report.launch;

import android.app.Application;
import com.applovin.sdk.AppLovinMediationProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import u7.d;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "com.transsion.baselib.report.launch.RoomInstallReferrer$fetchInstallReferrer$1", f = "RoomInstallReferrer.kt", l = {}, m = "invokeSuspend")
public final class RoomInstallReferrer$fetchInstallReferrer$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Application $context;
    final /* synthetic */ String $referrerUrl;
    final /* synthetic */ d $response;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomInstallReferrer$fetchInstallReferrer$1(Application application, String str, d dVar, Continuation<? super RoomInstallReferrer$fetchInstallReferrer$1> continuation) {
        super(2, continuation);
        this.$context = application;
        this.$referrerUrl = str;
        this.$response = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomInstallReferrer$fetchInstallReferrer$1(this.$context, this.$referrerUrl, this.$response, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((RoomInstallReferrer$fetchInstallReferrer$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        RoomInstallReferrer roomInstallReferrer = RoomInstallReferrer.f51273a;
        Application application = this.$context;
        String str = this.$referrerUrl;
        if (str == null) {
            str = AppLovinMediationProvider.UNKNOWN;
        }
        roomInstallReferrer.g(application, str, this.$response);
        return Unit.f68710a;
    }
}
