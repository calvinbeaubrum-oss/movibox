package com.transsion.ad;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.c;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.ad.strategy.AdObserveNetworkState;
import com.transsion.ad.strategy.AppManager;
import com.transsion.ad.strategy.NationalInformationManager;
import com.transsion.ad.strategy.NewUserManager;
import com.transsion.gslb.Worker;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.w0;
import oq.d;
import xq.f;

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
@DebugMetadata(c = "com.transsion.ad.MBAd$initAd$2", f = "MBAd.kt", l = {102, Worker.WHAT_SYNC_DATA, 108, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m = "invokeSuspend")
public final class MBAd$initAd$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ MBAd.a $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MBAd$initAd$2(MBAd.a aVar, Continuation<? super MBAd$initAd$2> continuation) {
        super(2, continuation);
        this.$params = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MBAd$initAd$2 mBAd$initAd$2 = new MBAd$initAd$2(this.$params, continuation);
        mBAd$initAd$2.L$0 = obj;
        return mBAd$initAd$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MBAd$initAd$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0153 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x01a1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:45:0x01b6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:53:0x01f7  */
    /* JADX WARN: Instruction removed from duplicated block: B:53:0x01f7, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        Throwable thM166exceptionOrNullimpl;
        k0 k0Var;
        MBAd.a aVar;
        k0 k0Var2;
        a2 a2VarC;
        MBAd$initAd$2$1$1 mBAd$initAd$2$1$1;
        o0 o0VarB;
        a aVar2;
        String strC;
        Object objC;
        o0 o0Var;
        String str;
        Object objC2;
        Object obj2;
        a aVar3;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    aVar = (MBAd.a) this.L$1;
                    k0Var = (k0) this.L$0;
                    ResultKt.b(obj);
                } else if (i11 == 2) {
                    aVar = (MBAd.a) this.L$1;
                    k0Var = (k0) this.L$0;
                    ResultKt.b(obj);
                    k0Var2 = k0Var;
                    f fVar = f.f80673a;
                    b bVar = b.f50277a;
                    fVar.a(bVar.b());
                    fVar.a(bVar.a());
                    a2VarC = w0.c();
                    mBAd$initAd$2$1$1 = new MBAd$initAd$2$1$1(null);
                    this.L$0 = k0Var2;
                    this.L$1 = aVar;
                    this.label = 3;
                    if (h.g(a2VarC, mBAd$initAd$2$1$1, this) == objE) {
                        return objE;
                    }
                    new AdObserveNetworkState().f(aVar.a());
                    o0VarB = j.b(k0Var2, null, null, new MBAd$initAd$2$1$sdkHi$1(aVar, null), 3, null);
                    o0 o0VarB2 = j.b(k0Var2, null, null, new MBAd$initAd$2$1$sdkMb$1(aVar, null), 3, null);
                    aVar2 = a.f50276a;
                    strC = MBAd.f50258a.c();
                    this.L$0 = o0VarB;
                    this.L$1 = strC;
                    this.L$2 = aVar2;
                    this.label = 4;
                    objC = o0VarB2.c(this);
                    if (objC == objE) {
                        return objE;
                    }
                    o0Var = o0VarB;
                    str = strC;
                    this.L$0 = str;
                    this.L$1 = aVar2;
                    this.L$2 = objC;
                    this.label = 5;
                    objC2 = o0Var.c(this);
                    if (objC2 == objE) {
                        return objE;
                    }
                    obj2 = objC;
                    aVar3 = aVar2;
                } else if (i11 == 3) {
                    aVar = (MBAd.a) this.L$1;
                    k0Var2 = (k0) this.L$0;
                    ResultKt.b(obj);
                    new AdObserveNetworkState().f(aVar.a());
                    o0VarB = j.b(k0Var2, null, null, new MBAd$initAd$2$1$sdkHi$1(aVar, null), 3, null);
                    o0 o0VarB3 = j.b(k0Var2, null, null, new MBAd$initAd$2$1$sdkMb$1(aVar, null), 3, null);
                    aVar2 = a.f50276a;
                    strC = MBAd.f50258a.c();
                    this.L$0 = o0VarB;
                    this.L$1 = strC;
                    this.L$2 = aVar2;
                    this.label = 4;
                    objC = o0VarB3.c(this);
                    if (objC == objE) {
                        return objE;
                    }
                    o0Var = o0VarB;
                    str = strC;
                    this.L$0 = str;
                    this.L$1 = aVar2;
                    this.L$2 = objC;
                    this.label = 5;
                    objC2 = o0Var.c(this);
                    if (objC2 == objE) {
                        return objE;
                    }
                    obj2 = objC;
                    aVar3 = aVar2;
                } else if (i11 == 4) {
                    a aVar4 = (a) this.L$2;
                    String str2 = (String) this.L$1;
                    o0Var = (o0) this.L$0;
                    ResultKt.b(obj);
                    str = str2;
                    aVar2 = aVar4;
                    objC = obj;
                    this.L$0 = str;
                    this.L$1 = aVar2;
                    this.L$2 = objC;
                    this.label = 5;
                    objC2 = o0Var.c(this);
                    if (objC2 == objE) {
                        return objE;
                    }
                    obj2 = objC;
                    aVar3 = aVar2;
                } else {
                    if (i11 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj2 = this.L$2;
                    aVar3 = (a) this.L$1;
                    str = (String) this.L$0;
                    ResultKt.b(obj);
                    objC2 = obj;
                }
                a.d(aVar3, " ================= " + str + " --> initAd() --> " + obj2 + " -- " + objC2 + " ================= ", false, 2, null);
                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl != null) {
                    thM166exceptionOrNullimpl.printStackTrace();
                    a.d(a.f50276a, MBAd.f50258a.c() + " --> initAd() --> 初始化异常 --> it = " + thM166exceptionOrNullimpl, false, 2, null);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            k0 k0Var3 = (k0) this.L$0;
            MBAd.a aVar5 = this.$params;
            Result.Companion companion = Result.Companion;
            a.b(a.f50276a, MBAd.f50258a.c() + " --> initAd() --> 当前包名 = " + c.c() + " --> monopoly广告SDK 开始初始化 --> hisavanaAppId = " + aVar5.d() + " --> adTestDevice = " + aVar5.b() + " --> isDebug = " + aVar5.g() + " --> appEnum = " + aVar5.c().getValue() + " --> host = " + cp.a.f62775a.a(), false, 2, null);
            AppManager.f50567a.a(aVar5.c());
            vq.a.f79051a.b(aVar5.f());
            d.f72515a.b(aVar5.e());
            NewUserManager newUserManager = NewUserManager.f50581a;
            this.L$0 = k0Var3;
            this.L$1 = aVar5;
            this.label = 1;
            if (newUserManager.b(this) == objE) {
                return objE;
            }
            k0Var = k0Var3;
            aVar = aVar5;
            NationalInformationManager nationalInformationManager = NationalInformationManager.f50580a;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            this.L$0 = k0Var;
            this.L$1 = aVar;
            this.label = 2;
            if (nationalInformationManager.f(applicationA, this) == objE) {
                return objE;
            }
            k0Var2 = k0Var;
            f fVar2 = f.f80673a;
            b bVar2 = b.f50277a;
            fVar2.a(bVar2.b());
            fVar2.a(bVar2.a());
            a2VarC = w0.c();
            mBAd$initAd$2$1$1 = new MBAd$initAd$2$1$1(null);
            this.L$0 = k0Var2;
            this.L$1 = aVar;
            this.label = 3;
            if (h.g(a2VarC, mBAd$initAd$2$1$1, this) == objE) {
                return objE;
            }
            new AdObserveNetworkState().f(aVar.a());
            o0VarB = j.b(k0Var2, null, null, new MBAd$initAd$2$1$sdkHi$1(aVar, null), 3, null);
            o0 o0VarB4 = j.b(k0Var2, null, null, new MBAd$initAd$2$1$sdkMb$1(aVar, null), 3, null);
            aVar2 = a.f50276a;
            strC = MBAd.f50258a.c();
            this.L$0 = o0VarB;
            this.L$1 = strC;
            this.L$2 = aVar2;
            this.label = 4;
            objC = o0VarB4.c(this);
            if (objC == objE) {
                return objE;
            }
            o0Var = o0VarB;
            str = strC;
            this.L$0 = str;
            this.L$1 = aVar2;
            this.L$2 = objC;
            this.label = 5;
            objC2 = o0Var.c(this);
            if (objC2 == objE) {
                return objE;
            }
            obj2 = objC;
            aVar3 = aVar2;
            a.d(aVar3, " ================= " + str + " --> initAd() --> " + obj2 + " -- " + objC2 + " ================= ", false, 2, null);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
            thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
            if (thM166exceptionOrNullimpl != null) {
                thM166exceptionOrNullimpl.printStackTrace();
                a.d(a.f50276a, MBAd.f50258a.c() + " --> initAd() --> 初始化异常 --> it = " + thM166exceptionOrNullimpl, false, 2, null);
            }
            return Unit.f68710a;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
    }
}
