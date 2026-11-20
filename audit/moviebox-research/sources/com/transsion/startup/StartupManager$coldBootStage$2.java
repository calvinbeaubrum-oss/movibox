package com.transsion.startup;

import android.app.Application;
import com.mbridge.msdk.MBridgeConstans;
import com.tn.lib.util.device.TNDeviceHelper;
import com.transsion.memberapi.IMemberApi;
import com.transsion.payment.lib.PaymentManager;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "com.transsion.startup.StartupManager$coldBootStage$2", f = "StartupManager.kt", l = {172, 181}, m = "invokeSuspend")
public final class StartupManager$coldBootStage$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StartupManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartupManager$coldBootStage$2(StartupManager startupManager, Continuation<? super StartupManager$coldBootStage$2> continuation) {
        super(2, continuation);
        this.this$0 = startupManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StartupManager$coldBootStage$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((StartupManager$coldBootStage$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            uo.b.a.f(uo.b.f78622a, "StartupManager", "stage 2 end", false, 4, null);
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        this.this$0.O();
        StartupManager startupManager = this.this$0;
        this.label = 1;
        if (startupManager.w(this) == objE) {
            return objE;
        }
        TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f49455a;
        Application application = this.this$0.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        tNDeviceHelper.a(application);
        this.this$0.C();
        PaymentManager.f54037b.a().c();
        Object objH = com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        Intrinsics.f(objH, "getInstance().navigation(IMemberApi::class.java)");
        IMemberApi.a.a((IMemberApi) objH, null, 1, null);
        IWrapperAdApi iWrapperAdApi = (IWrapperAdApi) com.alibaba.android.arouter.launcher.a.d().h(IWrapperAdApi.class);
        this.label = 2;
        if (iWrapperAdApi.k(this) == objE) {
            return objE;
        }
        uo.b.a.f(uo.b.f78622a, "StartupManager", "stage 2 end", false, 4, null);
        return Unit.f68710a;
    }
}
