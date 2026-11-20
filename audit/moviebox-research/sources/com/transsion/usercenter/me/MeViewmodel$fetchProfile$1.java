package com.transsion.usercenter.me;

import com.blankj.utilcode.util.n;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.usercenter.profile.ProfileKV;
import com.transsion.usercenter.profile.bean.MinePageInfo;
import com.transsnet.loginapi.bean.UserInfo;
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
@DebugMetadata(c = "com.transsion.usercenter.me.MeViewmodel$fetchProfile$1", f = "MeViewmodel.kt", l = {TsExtractor.TS_STREAM_TYPE_DVBSUBS}, m = "invokeSuspend")
public final class MeViewmodel$fetchProfile$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MeViewmodel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeViewmodel$fetchProfile$1(MeViewmodel meViewmodel, Continuation<? super MeViewmodel$fetchProfile$1> continuation) {
        super(2, continuation);
        this.this$0 = meViewmodel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MeViewmodel$fetchProfile$1 meViewmodel$fetchProfile$1 = new MeViewmodel$fetchProfile$1(this.this$0, continuation);
        meViewmodel$fetchProfile$1.L$0 = obj;
        return meViewmodel$fetchProfile$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MeViewmodel$fetchProfile$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        MeViewmodel meViewmodel;
        MinePageInfo minePageInfo;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                MeViewmodel meViewmodel2 = this.this$0;
                Result.Companion companion = Result.Companion;
                com.transsion.usercenter.profile.b bVarT = meViewmodel2.t();
                this.L$0 = meViewmodel2;
                this.label = 1;
                Object objC = com.transsion.usercenter.profile.b.a.c(bVarT, null, null, this, 3, null);
                if (objC == objE) {
                    return objE;
                }
                meViewmodel = meViewmodel2;
                obj = objC;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                meViewmodel = (MeViewmodel) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fetchProfile, result:");
            sb2.append(baseDto);
            if (Intrinsics.b(baseDto.getCode(), "0") && (minePageInfo = (MinePageInfo) baseDto.getData()) != null) {
                UserInfo userInfo = minePageInfo.getUserInfo();
                if (userInfo != null) {
                    ProfileKV.f59540a.a().putString("PROFILE_JSON", n.j(userInfo));
                }
                meViewmodel.f59436l = minePageInfo;
                meViewmodel.x();
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("fetchProfile, error:");
            sb3.append(thM166exceptionOrNullimpl);
        }
        return Unit.f68710a;
    }
}
