package com.transsion.transfer.wifi.create.adapter;

import com.google.logging.type.LogSeverity;
import com.transsion.transfer.wifi.util.WifiUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
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
@DebugMetadata(c = "com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$closeWifiAndReCreateHot$1", f = "P2PWifiAdapter.kt", l = {294, 296, LogSeverity.NOTICE_VALUE, 310, 311, 313}, m = "invokeSuspend")
public final class P2PWifiAdapter$closeWifiAndReCreateHot$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $retryCount;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ P2PWifiAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P2PWifiAdapter$closeWifiAndReCreateHot$1(Ref.IntRef intRef, P2PWifiAdapter p2PWifiAdapter, Continuation<? super P2PWifiAdapter$closeWifiAndReCreateHot$1> continuation) {
        super(2, continuation);
        this.$retryCount = intRef;
        this.this$0 = p2PWifiAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new P2PWifiAdapter$closeWifiAndReCreateHot$1(this.$retryCount, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((P2PWifiAdapter$closeWifiAndReCreateHot$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x009f A[Catch: all -> 0x00c0, TryCatch #0 {all -> 0x00c0, blocks: (B:48:0x0104, B:45:0x00f9, B:39:0x00b1, B:32:0x0091, B:34:0x009f, B:36:0x00a3, B:42:0x00c6), top: B:59:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x0103 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x0122  */
    /* JADX WARN: Code duplicated, block: B:56:0x012f A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ae -> B:59:0x00b1). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object obj2;
        P2PWifiAdapter$closeWifiAndReCreateHot$1 p2PWifiAdapter$closeWifiAndReCreateHot$1;
        Object objM163constructorimpl;
        P2PWifiAdapter$closeWifiAndReCreateHot$1 p2PWifiAdapter$closeWifiAndReCreateHot$2;
        P2PWifiAdapter p2PWifiAdapter;
        P2PWifiAdapter p2PWifiAdapter2;
        Ref.IntRef intRef;
        WifiUtils wifiUtils;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.b(obj);
                    Ref.IntRef intRef2 = this.$retryCount;
                    p2PWifiAdapter2 = this.this$0;
                    Result.Companion companion = Result.Companion;
                    WifiUtils.f59242a.l().setWifiEnabled(false);
                    this.L$0 = intRef2;
                    this.L$1 = p2PWifiAdapter2;
                    this.label = 1;
                    if (r0.a(500L, this) == objE) {
                        return objE;
                    }
                    intRef = intRef2;
                    WifiUtils.f59242a.l().setWifiEnabled(true);
                    this.L$0 = intRef;
                    this.L$1 = p2PWifiAdapter2;
                    this.label = 2;
                    if (r0.a(100L, this) == objE) {
                        return objE;
                    }
                    p2PWifiAdapter$closeWifiAndReCreateHot$2 = this;
                    wifiUtils = WifiUtils.f59242a;
                    if (!wifiUtils.l().isWifiEnabled() || intRef.element > 5) {
                        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, p2PWifiAdapter2.b() + " --> 关闭wifi，重启wifi后重新创建WIFI热点 -- wifiEnable = " + wifiUtils.l().isWifiEnabled(), false, 2, null);
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = p2PWifiAdapter2;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$1 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 4;
                        if (r0.a(200L, p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                            return objE;
                        }
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 5;
                        if (p2PWifiAdapter2.a(p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                            return objE;
                        }
                        objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                        p2PWifiAdapter = p2PWifiAdapter$closeWifiAndReCreateHot$2.this$0;
                        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                            p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = null;
                            p2PWifiAdapter$closeWifiAndReCreateHot$2.L$1 = null;
                            p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 6;
                            if (p2PWifiAdapter.a(p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                                return objE;
                            }
                        }
                        return Unit.f68710a;
                    }
                    try {
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = intRef;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$1 = p2PWifiAdapter2;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 3;
                        if (r0.a(200L, p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                            return objE;
                        }
                        WifiUtils.f59242a.l().setWifiEnabled(true);
                        intRef.element++;
                        wifiUtils = WifiUtils.f59242a;
                        if (wifiUtils.l().isWifiEnabled()) {
                        }
                        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, p2PWifiAdapter2.b() + " --> 关闭wifi，重启wifi后重新创建WIFI热点 -- wifiEnable = " + wifiUtils.l().isWifiEnabled(), false, 2, null);
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = p2PWifiAdapter2;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$1 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 4;
                        if (r0.a(200L, p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                            return objE;
                        }
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 5;
                        if (p2PWifiAdapter2.a(p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                            return objE;
                        }
                        objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                        break;
                    } catch (Throwable th2) {
                        p2PWifiAdapter$closeWifiAndReCreateHot$1 = p2PWifiAdapter$closeWifiAndReCreateHot$2;
                        th = th2;
                        obj2 = objE;
                        Result.Companion companion2 = Result.Companion;
                        Object obj3 = obj2;
                        objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                        p2PWifiAdapter$closeWifiAndReCreateHot$2 = p2PWifiAdapter$closeWifiAndReCreateHot$1;
                        objE = obj3;
                    }
                    p2PWifiAdapter = p2PWifiAdapter$closeWifiAndReCreateHot$2.this$0;
                    if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$1 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 6;
                        if (p2PWifiAdapter.a(p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                            return objE;
                        }
                    }
                    return Unit.f68710a;
                case 1:
                    p2PWifiAdapter2 = (P2PWifiAdapter) this.L$1;
                    intRef = (Ref.IntRef) this.L$0;
                    ResultKt.b(obj);
                    WifiUtils.f59242a.l().setWifiEnabled(true);
                    this.L$0 = intRef;
                    this.L$1 = p2PWifiAdapter2;
                    this.label = 2;
                    if (r0.a(100L, this) == objE) {
                        return objE;
                    }
                    p2PWifiAdapter$closeWifiAndReCreateHot$2 = this;
                    wifiUtils = WifiUtils.f59242a;
                    if (wifiUtils.l().isWifiEnabled()) {
                        break;
                    }
                    com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, p2PWifiAdapter2.b() + " --> 关闭wifi，重启wifi后重新创建WIFI热点 -- wifiEnable = " + wifiUtils.l().isWifiEnabled(), false, 2, null);
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = p2PWifiAdapter2;
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.L$1 = null;
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 4;
                    if (r0.a(200L, p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                        return objE;
                    }
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = null;
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 5;
                    if (p2PWifiAdapter2.a(p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                        return objE;
                    }
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                    p2PWifiAdapter = p2PWifiAdapter$closeWifiAndReCreateHot$2.this$0;
                    if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$1 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 6;
                        if (p2PWifiAdapter.a(p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                            return objE;
                        }
                    }
                    return Unit.f68710a;
                case 2:
                    p2PWifiAdapter2 = (P2PWifiAdapter) this.L$1;
                    intRef = (Ref.IntRef) this.L$0;
                    ResultKt.b(obj);
                    p2PWifiAdapter$closeWifiAndReCreateHot$2 = this;
                    wifiUtils = WifiUtils.f59242a;
                    if (wifiUtils.l().isWifiEnabled()) {
                        break;
                    }
                    com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, p2PWifiAdapter2.b() + " --> 关闭wifi，重启wifi后重新创建WIFI热点 -- wifiEnable = " + wifiUtils.l().isWifiEnabled(), false, 2, null);
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = p2PWifiAdapter2;
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.L$1 = null;
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 4;
                    if (r0.a(200L, p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                        return objE;
                    }
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = null;
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 5;
                    if (p2PWifiAdapter2.a(p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                        return objE;
                    }
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                    p2PWifiAdapter = p2PWifiAdapter$closeWifiAndReCreateHot$2.this$0;
                    if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$1 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 6;
                        if (p2PWifiAdapter.a(p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                            return objE;
                        }
                    }
                    return Unit.f68710a;
                case 3:
                    p2PWifiAdapter2 = (P2PWifiAdapter) this.L$1;
                    intRef = (Ref.IntRef) this.L$0;
                    ResultKt.b(obj);
                    p2PWifiAdapter$closeWifiAndReCreateHot$2 = this;
                    WifiUtils.f59242a.l().setWifiEnabled(true);
                    intRef.element++;
                    wifiUtils = WifiUtils.f59242a;
                    if (wifiUtils.l().isWifiEnabled()) {
                        break;
                    }
                    com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, p2PWifiAdapter2.b() + " --> 关闭wifi，重启wifi后重新创建WIFI热点 -- wifiEnable = " + wifiUtils.l().isWifiEnabled(), false, 2, null);
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = p2PWifiAdapter2;
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.L$1 = null;
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 4;
                    if (r0.a(200L, p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                        return objE;
                    }
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = null;
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 5;
                    if (p2PWifiAdapter2.a(p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                        return objE;
                    }
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                    p2PWifiAdapter = p2PWifiAdapter$closeWifiAndReCreateHot$2.this$0;
                    if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$1 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 6;
                        if (p2PWifiAdapter.a(p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                            return objE;
                        }
                    }
                    return Unit.f68710a;
                case 4:
                    p2PWifiAdapter2 = (P2PWifiAdapter) this.L$0;
                    ResultKt.b(obj);
                    p2PWifiAdapter$closeWifiAndReCreateHot$2 = this;
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = null;
                    p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 5;
                    if (p2PWifiAdapter2.a(p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                        return objE;
                    }
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                    p2PWifiAdapter = p2PWifiAdapter$closeWifiAndReCreateHot$2.this$0;
                    if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$1 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 6;
                        if (p2PWifiAdapter.a(p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                            return objE;
                        }
                    }
                    return Unit.f68710a;
                case 5:
                    ResultKt.b(obj);
                    p2PWifiAdapter$closeWifiAndReCreateHot$2 = this;
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                    p2PWifiAdapter = p2PWifiAdapter$closeWifiAndReCreateHot$2.this$0;
                    if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$0 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.L$1 = null;
                        p2PWifiAdapter$closeWifiAndReCreateHot$2.label = 6;
                        if (p2PWifiAdapter.a(p2PWifiAdapter$closeWifiAndReCreateHot$2) == objE) {
                            return objE;
                        }
                    }
                    return Unit.f68710a;
                case 6:
                    ResultKt.b(obj);
                    return Unit.f68710a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th3) {
            th = th3;
            obj2 = objE;
            p2PWifiAdapter$closeWifiAndReCreateHot$1 = this;
        }
    }
}
