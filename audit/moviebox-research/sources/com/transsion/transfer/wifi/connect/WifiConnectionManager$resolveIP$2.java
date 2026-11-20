package com.transsion.transfer.wifi.connect;

import com.transsion.transfer.wifi.util.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt;
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
@DebugMetadata(c = "com.transsion.transfer.wifi.connect.WifiConnectionManager$resolveIP$2", f = "WifiConnectionManager.kt", l = {337}, m = "invokeSuspend")
public final class WifiConnectionManager$resolveIP$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;

    public WifiConnectionManager$resolveIP$2(Continuation<? super WifiConnectionManager$resolveIP$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiConnectionManager$resolveIP$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((WifiConnectionManager$resolveIP$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            WifiConnectionManager wifiConnectionManager = WifiConnectionManager.f59120a;
            this.label = 1;
            obj = wifiConnectionManager.p(this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        String str = (String) obj;
        if (StringsKt__StringsKt.Q(str, "192.168", false, 2, null)) {
            g gVar = g.f59252a;
            WifiConnectionManager wifiConnectionManager2 = WifiConnectionManager.f59120a;
            g.d(gVar, wifiConnectionManager2.o() + " --> resolveIP(netId: Int) --> 统级接入方添加Net成功，跳转传输页 ip = " + str, false, 2, null);
            wifiConnectionManager2.e(str);
        } else {
            g gVar2 = g.f59252a;
            WifiConnectionManager wifiConnectionManager3 = WifiConnectionManager.f59120a;
            g.d(gVar2, wifiConnectionManager3.o() + " --> resolveIP(netId: Int) --> result->连接P2P失败 原因 = P2P地址获取异常，重试后仍然异常 ip = " + str, false, 2, null);
            wifiConnectionManager3.b(2002);
        }
        return Unit.f68710a;
    }
}
