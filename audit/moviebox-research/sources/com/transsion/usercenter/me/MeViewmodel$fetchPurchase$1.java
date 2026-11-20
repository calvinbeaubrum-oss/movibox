package com.transsion.usercenter.me;

import com.blankj.utilcode.util.n;
import com.tencent.mmkv.MMKV;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.util.device.TNDeviceHelper;
import com.transsion.usercenter.profile.bean.ZeroBody;
import com.transsion.usercenter.profile.bean.ZeroConfig;
import com.transsion.usercenter.profile.bean.ZeroInfo;
import com.transsion.usercenter.profile.bean.ZeroResponse;
import com.transsion.usercenter.profile.c;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.g;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.usercenter.me.MeViewmodel$fetchPurchase$1", f = "MeViewmodel.kt", l = {148}, m = "invokeSuspend")
public final class MeViewmodel$fetchPurchase$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MeViewmodel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeViewmodel$fetchPurchase$1(MeViewmodel meViewmodel, Continuation<? super MeViewmodel$fetchPurchase$1> continuation) {
        super(2, continuation);
        this.this$0 = meViewmodel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MeViewmodel$fetchPurchase$1 meViewmodel$fetchPurchase$1 = new MeViewmodel$fetchPurchase$1(this.this$0, continuation);
        meViewmodel$fetchPurchase$1.L$0 = obj;
        return meViewmodel$fetchPurchase$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MeViewmodel$fetchPurchase$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        String upperCase;
        Object objA;
        MeViewmodel meViewmodel;
        String string;
        List<ZeroInfo> listL;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                MeViewmodel meViewmodel2 = this.this$0;
                Result.Companion companion = Result.Companion;
                String string2 = TimeZone.getDefault().getID().toString();
                UserInfo userInfoP = meViewmodel2.s().P();
                String phone = userInfoP != null ? userInfoP.getPhone() : null;
                UserInfo userInfoP2 = meViewmodel2.s().P();
                String userId = userInfoP2 != null ? userInfoP2.getUserId() : null;
                String strH = TNDeviceHelper.f49455a.h();
                MMKV mmkvC = ip.a.f67589a.c();
                if (mmkvC == null || (string = mmkvC.getString("custom_local_iso", "")) == null) {
                    upperCase = null;
                } else {
                    upperCase = string.toUpperCase(Locale.ROOT);
                    Intrinsics.f(upperCase, "toUpperCase(...)");
                }
                ip.b.a aVar = ip.b.f67591a;
                String strJ = n.j(new ZeroBody(upperCase == null ? "" : upperCase, phone, userId, strH, string2, 0, null, 96, null));
                Intrinsics.f(strJ, "toJson(ZeroBody(countryI…le, uid, gaId, timezone))");
                RequestBody requestBodyA = aVar.a(strJ);
                if (requestBodyA == null) {
                    return Unit.f68710a;
                }
                ZeroConfig zeroConfig = meViewmodel2.f59430f;
                String urlPath = zeroConfig != null ? zeroConfig.getUrlPath() : null;
                if (urlPath == null || urlPath.length() == 0) {
                    urlPath = "campaign/v1/freebuy/campaign/recent";
                }
                c cVarU = meViewmodel2.u();
                this.L$0 = meViewmodel2;
                this.label = 1;
                objA = cVarU.a(requestBodyA, urlPath, this);
                if (objA == objE) {
                    return objE;
                }
                meViewmodel = meViewmodel2;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                meViewmodel = (MeViewmodel) this.L$0;
                ResultKt.b(obj);
                objA = obj;
            }
            BaseDto baseDto = (BaseDto) objA;
            uo.b.a.f(uo.b.f78622a, "MeViewmodel", "zero entrance:" + baseDto, false, 4, null);
            if (Intrinsics.b(baseDto.getCode(), "0")) {
                meViewmodel.f59429d.clear();
                List list = meViewmodel.f59429d;
                ZeroResponse zeroResponse = (ZeroResponse) baseDto.getData();
                if (zeroResponse == null || (listL = zeroResponse.getItems()) == null) {
                    listL = g.l();
                }
                list.addAll(listL);
                meViewmodel.x();
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("error:");
            sb2.append(thM166exceptionOrNullimpl);
        }
        return Unit.f68710a;
    }
}
