package com.cloud.config;

import android.util.Log;
import com.cloud.config.AbsConfigStore$RequestRunnableConfig$run$1;
import com.cloud.config.bean.CloudConfigResponse;
import com.cloud.config.bean.ConditionInfo;
import com.cloud.config.bean.ConditionParam;
import com.cloud.config.bean.ShuntInfo;
import com.cloud.config.utils.ConstantsKt;
import com.cloud.config.utils.ExecutorUtils;
import com.cloud.config.utils.XLogUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import j9.s;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AbsConfigStore$RequestRunnableConfig$run$1 implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsConfigStore.RequestRunnableConfig f28858a;

    public AbsConfigStore$RequestRunnableConfig$run$1(AbsConfigStore.RequestRunnableConfig requestRunnableConfig) {
        this.f28858a = requestRunnableConfig;
    }

    public static final void c(AbsConfigStore.RequestRunnableConfig this$0) {
        Intrinsics.g(this$0, "this$0");
        s configResultListener = this$0.getConfigResultListener();
        if (configResultListener == null) {
            return;
        }
        configResultListener.a(1004, ConstantsKt.ERROR_1004_MESSAGE);
    }

    public static final void d(AbsConfigStore.RequestRunnableConfig this$0) {
        Intrinsics.g(this$0, "this$0");
        s configResultListener = this$0.getConfigResultListener();
        if (configResultListener == null) {
            return;
        }
        configResultListener.a(1003, ConstantsKt.ERROR_1003_MESSAGE);
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e11) {
        Intrinsics.g(call, "call");
        Intrinsics.g(e11, "e");
        XLogUtil log = XLogUtil.Companion.getLog();
        String stackTraceString = Log.getStackTraceString(e11);
        Intrinsics.f(stackTraceString, "getStackTraceString(e)");
        log.e(XLogUtil.TAG, stackTraceString);
        ExecutorService executorServiceMain = ExecutorUtils.main();
        final AbsConfigStore.RequestRunnableConfig requestRunnableConfig = this.f28858a;
        executorServiceMain.execute(new Runnable() { // from class: j9.f
            @Override // java.lang.Runnable
            public final void run() {
                AbsConfigStore$RequestRunnableConfig$run$1.c(requestRunnableConfig);
            }
        });
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) throws IOException {
        ConditionInfo conditionInfo;
        String matchCacheUrl;
        Intrinsics.g(call, "call");
        Intrinsics.g(response, "response");
        try {
            if (response.body() == null) {
                return;
            }
            AbsConfigStore.RequestRunnableConfig requestRunnableConfig = this.f28858a;
            ResponseBody responseBodyBody = response.body();
            Intrinsics.d(responseBodyBody);
            String strString = responseBodyBody.string();
            MMKV mmkvL = requestRunnableConfig.getStore().l();
            String str = requestRunnableConfig.packageName;
            mmkvL.putString(str == null ? null : ConstantsKt.toStoreConfigName(str), strString);
            MMKV mmkvL2 = requestRunnableConfig.getStore().l();
            String str2 = requestRunnableConfig.packageName;
            mmkvL2.putString(str2 == null ? null : ConstantsKt.toStoreMd5Name(str2), requestRunnableConfig.getContentMd5());
            XLogUtil.Companion.getLog().i(XLogUtil.TAG, Intrinsics.p("response --> ", strString));
            CloudConfigResponse cloudConfigResponse = (CloudConfigResponse) new Gson().fromJson(strString, new TypeToken<CloudConfigResponse>() { // from class: com.cloud.config.AbsConfigStore$RequestRunnableConfig$run$1$onResponse$1$responseResult$1
            }.getType());
            if (cloudConfigResponse != null && (conditionInfo = cloudConfigResponse.getConditionInfo()) != null && (matchCacheUrl = conditionInfo.getMatchCacheUrl()) != null) {
                AbsConfigStore store = requestRunnableConfig.getStore();
                ConditionParam conditionParam = cloudConfigResponse.getConditionInfo().get_conditionParam();
                ShuntInfo shuntInfo = conditionParam != null ? conditionParam.getShuntInfo() : null;
                String str3 = requestRunnableConfig.packageName;
                AbsConfigStore store2 = requestRunnableConfig.getStore();
                requestRunnableConfig.getConfigListener();
                store.p(matchCacheUrl, shuntInfo, str3, store2, null, requestRunnableConfig.getConfigResultListener());
            }
        } catch (Throwable th2) {
            XLogUtil log = XLogUtil.Companion.getLog();
            String stackTraceString = Log.getStackTraceString(th2);
            Intrinsics.f(stackTraceString, "getStackTraceString(e)");
            log.e(XLogUtil.TAG, stackTraceString);
            ExecutorService executorServiceMain = ExecutorUtils.main();
            final AbsConfigStore.RequestRunnableConfig requestRunnableConfig2 = this.f28858a;
            executorServiceMain.execute(new Runnable() { // from class: j9.e
                @Override // java.lang.Runnable
                public final void run() {
                    AbsConfigStore$RequestRunnableConfig$run$1.d(requestRunnableConfig2);
                }
            });
        }
    }
}
