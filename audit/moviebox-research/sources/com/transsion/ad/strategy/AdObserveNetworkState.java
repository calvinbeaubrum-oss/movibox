package com.transsion.ad.strategy;

import android.net.Network;
import android.net.NetworkCapabilities;
import com.transsion.ad.monopoly.MonopolyAdManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AdObserveNetworkState implements com.tn.lib.util.networkinfo.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f50560a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f50561b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f50562c;

    /* JADX INFO: renamed from: com.transsion.ad.strategy.AdObserveNetworkState$onConnected$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.strategy.AdObserveNetworkState$onConnected$1", f = "AdObserveNetworkState.kt", l = {51, 53}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AdObserveNetworkState.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
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
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            this.label = 1;
            if (r0.a(500L, this) == objE) {
                return objE;
            }
            com.transsion.ad.a.b(com.transsion.ad.a.f50276a, AdObserveNetworkState.this.e() + " --> onConnected() --> 网络变化，请求广告配置", false, 2, null);
            MonopolyAdManager monopolyAdManager = MonopolyAdManager.f50522a;
            String str = AdObserveNetworkState.this.f50560a;
            if (str == null) {
                str = "";
            }
            final AdObserveNetworkState adObserveNetworkState = AdObserveNetworkState.this;
            Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.transsion.ad.strategy.AdObserveNetworkState.onConnected.1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    adObserveNetworkState.f50562c = z11;
                    com.transsion.ad.a.b(com.transsion.ad.a.f50276a, adObserveNetworkState.e() + " --> onConnected() --> 广告请求结果--> result == " + z11, false, 2, null);
                    adObserveNetworkState.f50561b.set(false);
                }
            };
            this.label = 2;
            if (monopolyAdManager.a(str, function1, this) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e() {
        String simpleName = AdObserveNetworkState.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void f(String adConfigUrl) {
        Intrinsics.g(adConfigUrl, "adConfigUrl");
        this.f50560a = adConfigUrl;
        com.transsion.ad.a.b(com.transsion.ad.a.f50276a, e() + " --> registerNetworkStatusChangedListener() --> 网络变化监听 success", false, 2, null);
        com.tn.lib.util.networkinfo.f.f49475a.l(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected() {
        com.tn.lib.util.networkinfo.g.a.a(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        if (this.f50561b.get()) {
            com.transsion.ad.a.b(com.transsion.ad.a.f50276a, e() + " --> onConnected() --> isLoading == true", false, 2, null);
            return;
        }
        this.f50561b.set(true);
        if (!this.f50562c) {
            kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new AnonymousClass1(null), 3, null);
            return;
        }
        com.transsion.ad.a.b(com.transsion.ad.a.f50276a, e() + " --> onConnected() --> result == true --> 生命周期内已经请求成功", false, 2, null);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
    }
}
