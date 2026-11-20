package com.transsion.subroom.activity;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.transsion.baselib.helper.ReferrerBean;
import com.transsion.baselib.report.launch.RoomInstallReferrer;
import com.transsion.fissionapi.IFissionProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "com.transsion.subroom.activity.SplashActivity$toMain$1", f = "SplashActivity.kt", l = {}, m = "invokeSuspend")
public final class SplashActivity$toMain$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SplashActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashActivity$toMain$1(SplashActivity splashActivity, Continuation<? super SplashActivity$toMain$1> continuation) {
        super(2, continuation);
        this.this$0 = splashActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashActivity$toMain$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SplashActivity$toMain$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        fp.b.a aVar = fp.b.f65208a;
        Application application = this.this$0.getApplication();
        Intrinsics.f(application, "application");
        if (TextUtils.equals(aVar.e(application), "gp")) {
            RoomInstallReferrer roomInstallReferrer = RoomInstallReferrer.f51273a;
            Application application2 = this.this$0.getApplication();
            Intrinsics.f(application2, "application");
            roomInstallReferrer.d(application2, new RoomInstallReferrer.a() { // from class: com.transsion.subroom.activity.SplashActivity$toMain$1.1
                @Override // com.transsion.baselib.report.launch.RoomInstallReferrer.a
                public void a(ReferrerBean referrer) {
                    String utmContent;
                    IFissionProvider iFissionProvider;
                    Intrinsics.g(referrer, "referrer");
                    if (TextUtils.isEmpty(referrer.getUtmContent())) {
                        return;
                    }
                    try {
                        if (Intrinsics.b(referrer.getUtmSource(), "fission-share") && (utmContent = referrer.getUtmContent()) != null && (iFissionProvider = (IFissionProvider) com.alibaba.android.arouter.launcher.a.d().h(IFissionProvider.class)) != null) {
                            iFissionProvider.I(utmContent);
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    Uri uriD = com.transsion.baselib.helper.b.f51184a.d(Uri.parse(referrer.getUtmContent()));
                    if (uriD != null) {
                        kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new SplashActivity$toMain$1$1$onResolved$2(uriD, null), 3, null);
                    }
                }
            });
        } else {
            RoomInstallReferrer roomInstallReferrer2 = RoomInstallReferrer.f51273a;
            Application application3 = this.this$0.getApplication();
            Intrinsics.f(application3, "application");
            roomInstallReferrer2.g(application3, AppLovinMediationProvider.UNKNOWN, null);
        }
        return Unit.f68710a;
    }
}
