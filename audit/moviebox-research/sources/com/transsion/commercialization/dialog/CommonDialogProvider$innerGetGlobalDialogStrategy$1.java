package com.transsion.commercialization.dialog;

import com.blankj.utilcode.util.n;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.bean.HomePopupEntity;
import com.transsion.bean.HomePopupRequestDisplayedEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import okhttp3.RequestBody;

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
@DebugMetadata(c = "com.transsion.commercialization.dialog.CommonDialogProvider$innerGetGlobalDialogStrategy$1", f = "CommonDialogProvider.kt", l = {198}, m = "invokeSuspend")
public final class CommonDialogProvider$innerGetGlobalDialogStrategy$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CommonDialogProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonDialogProvider$innerGetGlobalDialogStrategy$1(CommonDialogProvider commonDialogProvider, Continuation<? super CommonDialogProvider$innerGetGlobalDialogStrategy$1> continuation) {
        super(2, continuation);
        this.this$0 = commonDialogProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CommonDialogProvider$innerGetGlobalDialogStrategy$1 commonDialogProvider$innerGetGlobalDialogStrategy$1 = new CommonDialogProvider$innerGetGlobalDialogStrategy$1(this.this$0, continuation);
        commonDialogProvider$innerGetGlobalDialogStrategy$1.L$0 = obj;
        return commonDialogProvider$innerGetGlobalDialogStrategy$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((CommonDialogProvider$innerGetGlobalDialogStrategy$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0104  */
    /* JADX WARN: Instruction removed from duplicated block: B:30:0x0104, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        CommonDialogProvider commonDialogProvider;
        Throwable thM166exceptionOrNullimpl;
        Unit unit;
        CommonDialogProvider commonDialogProvider2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
                if ((System.currentTimeMillis() / ((long) 1000)) - roomAppMMKV.a().getLong("global_dialog_request_time", 0L) < roomAppMMKV.a().getInt("global_dialog_request_interval_time", 3600)) {
                    uo.b.a.f(uo.b.f78622a, "zxb_popup", this.this$0.L1() + " --> innerGetGlobalDialogStrategy() --> 两次请求间隔时间未达到", false, 4, null);
                    return Unit.f68710a;
                }
                CommonDialogProvider commonDialogProvider3 = this.this$0;
                Result.Companion companion = Result.Companion;
                unit = null;
                List listM1 = commonDialogProvider3.M1(null, false, "popup");
                List listM2 = commonDialogProvider3.M1(null, false, "widget");
                new ArrayList();
                String requestJson = n.j(new HomePopupRequestDisplayedEntity(listM1, listM2));
                uo.b.a.f(uo.b.f78622a, "zxb_popup", commonDialogProvider3.L1() + " --> innerGetGlobalDialogStrategy() --> 请求参数 --> requestJson = " + requestJson, false, 4, null);
                ip.b.a aVar = ip.b.f67591a;
                Intrinsics.f(requestJson, "requestJson");
                RequestBody requestBodyA = aVar.a(requestJson);
                if (requestBodyA != null) {
                    d dVarO1 = commonDialogProvider3.O1();
                    this.L$0 = commonDialogProvider3;
                    this.label = 1;
                    Object objA = d.a.a(dVarO1, null, requestBodyA, this, 1, null);
                    if (objA == objE) {
                        return objE;
                    }
                    commonDialogProvider2 = commonDialogProvider3;
                    obj = objA;
                }
                objM163constructorimpl = Result.m163constructorimpl(unit);
                commonDialogProvider = this.this$0;
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl != null) {
                    uo.b.a.j(uo.b.f78622a, "zxb_popup", commonDialogProvider.L1() + " --> innerGetGlobalDialogStrategy() --> 请求接口的时候发生异常 --> it = " + thM166exceptionOrNullimpl, false, 4, null);
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            commonDialogProvider2 = (CommonDialogProvider) this.L$0;
            ResultKt.b(obj);
            BaseDto baseDto = (BaseDto) obj;
            commonDialogProvider2.I1((HomePopupEntity) baseDto.getData());
            commonDialogProvider2.J1((HomePopupEntity) baseDto.getData());
            unit = Unit.f68710a;
            objM163constructorimpl = Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        commonDialogProvider = this.this$0;
        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            uo.b.a.j(uo.b.f78622a, "zxb_popup", commonDialogProvider.L1() + " --> innerGetGlobalDialogStrategy() --> 请求接口的时候发生异常 --> it = " + thM166exceptionOrNullimpl, false, 4, null);
        }
        return Unit.f68710a;
    }
}
