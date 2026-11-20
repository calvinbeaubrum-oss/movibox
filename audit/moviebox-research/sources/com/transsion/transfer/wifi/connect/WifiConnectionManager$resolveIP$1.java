package com.transsion.transfer.wifi.connect;

import android.text.TextUtils;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.g;
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
@DebugMetadata(c = "com.transsion.transfer.wifi.connect.WifiConnectionManager$resolveIP$1", f = "WifiConnectionManager.kt", l = {316}, m = "invokeSuspend")
public final class WifiConnectionManager$resolveIP$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;

    public WifiConnectionManager$resolveIP$1(Continuation<? super WifiConnectionManager$resolveIP$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiConnectionManager$resolveIP$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((WifiConnectionManager$resolveIP$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            g.b(g.f59252a, WifiConnectionManager.f59120a.o() + " --> resolveIP(address: InetAddress?) --> P2P连接成功但ip为空，尝试轮询获取正确ip ....", false, 2, null);
            WifiUtils wifiUtils = WifiUtils.f59242a;
            this.label = 1;
            obj = wifiUtils.g(this);
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
        if (TextUtils.isEmpty(str)) {
            long jCurrentTimeMillis = System.currentTimeMillis() - WifiConnectionManager.f59128i;
            g gVar = g.f59252a;
            WifiConnectionManager wifiConnectionManager = WifiConnectionManager.f59120a;
            g.b(gVar, wifiConnectionManager.o() + " --> resolveIP(address: InetAddress?) --> 连接P2P失败, 耗时 = " + jCurrentTimeMillis + " -- 原因 = P2P地址获取异常，重试后仍然异常", false, 2, null);
            wifiConnectionManager.b(2002);
        } else {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - WifiConnectionManager.f59128i;
            g gVar2 = g.f59252a;
            WifiConnectionManager wifiConnectionManager2 = WifiConnectionManager.f59120a;
            g.b(gVar2, wifiConnectionManager2.o() + " --> resolveIP(address: InetAddress?) --> P2P连接成功轮询后成功连接耗时 = " + jCurrentTimeMillis2 + " -- P2P连接成功轮询后ip = " + str, false, 2, null);
            wifiConnectionManager2.e(str);
        }
        return Unit.f68710a;
    }
}
