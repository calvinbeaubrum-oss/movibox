package com.transsion.transfer.wifi.create;

import com.transsion.transfer.wifi.create.adapter.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.transfer.wifi.create.WifiCreateManager$createWifi$1", f = "WifiCreateManager.kt", l = {84}, m = "invokeSuspend")
public final class WifiCreateManager$createWifi$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $listener;
    final /* synthetic */ k0 $scope;
    final /* synthetic */ qy.a $wifiInfoModel;
    int label;
    final /* synthetic */ WifiCreateManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WifiCreateManager$createWifi$1(a aVar, qy.a aVar2, WifiCreateManager wifiCreateManager, k0 k0Var, Continuation<? super WifiCreateManager$createWifi$1> continuation) {
        super(2, continuation);
        this.$listener = aVar;
        this.$wifiInfoModel = aVar2;
        this.this$0 = wifiCreateManager;
        this.$scope = k0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiCreateManager$createWifi$1(this.$listener, this.$wifiInfoModel, this.this$0, this.$scope, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((WifiCreateManager$createWifi$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            WifiCreateManager wifiCreateManager = WifiCreateManager.f59169a;
            WifiCreateManager.f59170b = this.$listener;
            WifiCreateManager wifiCreateManager2 = WifiCreateManager.f59169a;
            wifiCreateManager2.onStart();
            if (WifiCreateManager.f59171c == null) {
                WifiCreateManager.f59171c = wifiCreateManager2.i();
            }
            b bVar = WifiCreateManager.f59171c;
            if (bVar != null) {
                qy.a aVar = this.$wifiInfoModel;
                WifiCreateManager wifiCreateManager3 = this.this$0;
                k0 k0Var = this.$scope;
                this.label = 1;
                if (bVar.i(aVar, wifiCreateManager3, k0Var, this) == objE) {
                    return objE;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
