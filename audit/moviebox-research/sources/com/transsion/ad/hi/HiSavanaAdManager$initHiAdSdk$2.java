package com.transsion.ad.hi;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import com.cloud.hisavana.net.CommonOkHttpClient;
import com.google.gson.JsonArray;
import com.hisavana.mediation.config.TAdManager;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.ad.strategy.AdMmkv;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;
import okhttp3.OkHttpClient;

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
@DebugMetadata(c = "com.transsion.ad.hi.HiSavanaAdManager$initHiAdSdk$2", f = "HiSavanaAdManager.kt", l = {84}, m = "invokeSuspend")
public final class HiSavanaAdManager$initHiAdSdk$2 extends SuspendLambda implements Function2<k0, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ boolean $adTestDevice;
    final /* synthetic */ String $hisavanaAppId;
    final /* synthetic */ boolean $isDebug;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiSavanaAdManager$initHiAdSdk$2(String str, boolean z11, boolean z12, Continuation<? super HiSavanaAdManager$initHiAdSdk$2> continuation) {
        super(2, continuation);
        this.$hisavanaAppId = str;
        this.$isDebug = z11;
        this.$adTestDevice = z12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HiSavanaAdManager$initHiAdSdk$2(this.$hisavanaAppId, this.$isDebug, this.$adTestDevice, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(k0 k0Var, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(k0Var, (Continuation<? super Result<Unit>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(k0 k0Var, Continuation<? super Result<Unit>> continuation) {
        return ((HiSavanaAdManager$initHiAdSdk$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        boolean z11;
        Object objE = a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                String str = this.$hisavanaAppId;
                boolean z12 = this.$isDebug;
                boolean z13 = this.$adTestDevice;
                Result.Companion companion = Result.Companion;
                OkHttpClient okHttpClientG = NetServiceGenerator.f49399d.a().g();
                CommonOkHttpClient.p(okHttpClientG != null ? okHttpClientG.dispatcher() : null);
                Application applicationA = Utils.a();
                TAdManager.init(applicationA != null ? applicationA.getApplicationContext() : null, new TAdManager.AdConfigBuilder().setAppId(str).setDebug(z12).testDevice(z12 && z13).setMuteVideo(true).build());
                this.Z$0 = z12;
                this.label = 1;
                if (r0.a(5000L, this) == objE) {
                    return objE;
                }
                z11 = z12;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z11 = this.Z$0;
                ResultKt.b(obj);
            }
            HiSavanaAdManager.f50402c.set(true);
            com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
            HiSavanaAdManager hiSavanaAdManager = HiSavanaAdManager.f50400a;
            com.transsion.ad.a.b(aVar, hiSavanaAdManager.c() + " --> initHiAdSdk() --> complete -- isInitialized = " + HiSavanaAdManager.f50402c.get(), false, 2, null);
            if (z11) {
                JsonArray jsonArray = (JsonArray) n.d(AdMmkv.f50558a.b().getString("non_ad_scene_config_data", ""), JsonArray.class);
                com.transsion.ad.a.b(aVar, hiSavanaAdManager.c() + " --> 场景配置信息 --> config = " + jsonArray, false, 2, null);
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        return Result.m162boximpl(objM163constructorimpl);
    }
}
