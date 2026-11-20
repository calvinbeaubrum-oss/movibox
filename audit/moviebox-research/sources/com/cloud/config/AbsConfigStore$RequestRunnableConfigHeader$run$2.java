package com.cloud.config;

import android.util.Log;
import com.cloud.config.AbsConfigStore$RequestRunnableConfigHeader$run$2;
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
import kotlin.jvm.internal.Ref;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

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
public final class AbsConfigStore$RequestRunnableConfigHeader$run$2 implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsConfigStore.RequestRunnableConfigHeader f28859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f28860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f28861c;

    public AbsConfigStore$RequestRunnableConfigHeader$run$2(AbsConfigStore.RequestRunnableConfigHeader requestRunnableConfigHeader, Ref.ObjectRef<String> objectRef, String str) {
        this.f28859a = requestRunnableConfigHeader;
        this.f28860b = objectRef;
        this.f28861c = str;
    }

    public static final void c(AbsConfigStore.RequestRunnableConfigHeader this$0) {
        Intrinsics.g(this$0, "this$0");
        s configResultListener = this$0.getConfigResultListener();
        if (configResultListener == null) {
            return;
        }
        configResultListener.a(1004, ConstantsKt.ERROR_1004_MESSAGE);
    }

    public static final void d(AbsConfigStore.RequestRunnableConfigHeader this$0) {
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
        final AbsConfigStore.RequestRunnableConfigHeader requestRunnableConfigHeader = this.f28859a;
        executorServiceMain.execute(new Runnable() { // from class: j9.j
            @Override // java.lang.Runnable
            public final void run() {
                AbsConfigStore$RequestRunnableConfigHeader$run$2.c(requestRunnableConfigHeader);
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
            String strHeader = response.header(ConstantsKt.CONTENT_MD5);
            MMKV mmkvL = this.f28859a.getStore().l();
            String str = this.f28860b.element;
            String string = mmkvL.getString(str == null ? null : ConstantsKt.toStoreMd5Name(str), "");
            MMKV mmkvL2 = this.f28859a.getStore().l();
            String str2 = this.f28860b.element;
            String string2 = mmkvL2.getString(str2 == null ? null : ConstantsKt.toStoreConfigName(str2), "");
            XLogUtil.Companion companion = XLogUtil.Companion;
            companion.getLog().i(XLogUtil.TAG, Intrinsics.p("contentMd5 --> ", strHeader));
            companion.getLog().i(XLogUtil.TAG, Intrinsics.p("storeMd5 --> ", string));
            if (string != null && string.length() > 0 && strHeader != null && strHeader.length() > 0 && Intrinsics.b(string, strHeader) && string2 != null && string2.length() > 0) {
                CloudConfigResponse cloudConfigResponse = (CloudConfigResponse) new Gson().fromJson(string2, new TypeToken<CloudConfigResponse>() { // from class: com.cloud.config.AbsConfigStore$RequestRunnableConfigHeader$run$2$onResponse$responseResult$1
                }.getType());
                if (cloudConfigResponse != null && (conditionInfo = cloudConfigResponse.getConditionInfo()) != null && (matchCacheUrl = conditionInfo.getMatchCacheUrl()) != null) {
                    AbsConfigStore.RequestRunnableConfigHeader requestRunnableConfigHeader = this.f28859a;
                    Ref.ObjectRef<String> objectRef = this.f28860b;
                    AbsConfigStore store = requestRunnableConfigHeader.getStore();
                    ConditionParam conditionParam = cloudConfigResponse.getConditionInfo().get_conditionParam();
                    ShuntInfo shuntInfo = conditionParam != null ? conditionParam.getShuntInfo() : null;
                    String str3 = objectRef.element;
                    AbsConfigStore store2 = requestRunnableConfigHeader.getStore();
                    requestRunnableConfigHeader.getConfigListener();
                    store.p(matchCacheUrl, shuntInfo, str3, store2, null, requestRunnableConfigHeader.getConfigResultListener());
                    return;
                }
                return;
            }
            ExecutorService executorServiceIo = ExecutorUtils.io();
            AbsConfigStore store3 = this.f28859a.getStore();
            String str4 = this.f28860b.element;
            this.f28859a.getConfigListener();
            executorServiceIo.execute(new AbsConfigStore.RequestRunnableConfig(store3, str4, null, this.f28859a.getConfigResultListener(), strHeader, this.f28861c));
        } catch (Throwable th2) {
            XLogUtil.Companion.getLog().e(XLogUtil.TAG, Intrinsics.p(Log.getStackTraceString(th2), Thread.currentThread().getName()));
            ExecutorService executorServiceMain = ExecutorUtils.main();
            final AbsConfigStore.RequestRunnableConfigHeader requestRunnableConfigHeader2 = this.f28859a;
            executorServiceMain.execute(new Runnable() { // from class: j9.i
                @Override // java.lang.Runnable
                public final void run() {
                    AbsConfigStore$RequestRunnableConfigHeader$run$2.d(requestRunnableConfigHeader2);
                }
            });
        }
    }
}
