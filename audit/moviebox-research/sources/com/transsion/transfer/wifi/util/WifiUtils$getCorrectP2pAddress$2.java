package com.transsion.transfer.wifi.util;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;

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
@DebugMetadata(c = "com.transsion.transfer.wifi.util.WifiUtils$getCorrectP2pAddress$2", f = "WifiUtils.kt", l = {262}, m = "invokeSuspend")
public final class WifiUtils$getCorrectP2pAddress$2 extends SuspendLambda implements Function2<k0, Continuation<? super String>, Object> {
    int I$0;
    int I$1;
    int label;

    public WifiUtils$getCorrectP2pAddress$2(Continuation<? super WifiUtils$getCorrectP2pAddress$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiUtils$getCorrectP2pAddress$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super String> continuation) {
        return ((WifiUtils$getCorrectP2pAddress$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i11;
        int i12;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i13 = this.label;
        if (i13 == 0) {
            ResultKt.b(obj);
            i11 = 0;
            i12 = 60;
        } else {
            if (i13 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i11 = this.I$1;
            i12 = this.I$0;
            ResultKt.b(obj);
        }
        while (i11 < i12) {
            WifiUtils wifiUtils = WifiUtils.f59242a;
            long j11 = wifiUtils.j();
            g.b(g.f59252a, wifiUtils.d() + " --> getCorrectP2pAddress() --> 第" + i11 + "次p2p连接 -- ip信息 gateway = " + j11, false, 2, null);
            if (j11 != 0 || wifiUtils.n(wifiUtils.i())) {
                return wifiUtils.s(wifiUtils.j());
            }
            i11++;
            this.I$0 = i12;
            this.I$1 = i11;
            this.label = 1;
            if (r0.a(200L, this) == objE) {
                return objE;
            }
        }
        g gVar = g.f59252a;
        WifiUtils wifiUtils2 = WifiUtils.f59242a;
        g.b(gVar, wifiUtils2.d() + " --> getCorrectP2pAddress() --> 多次获取当前wifi ip，仍然异常，返回默认的0.0.0.0", false, 2, null);
        return wifiUtils2.s(0L);
    }
}
