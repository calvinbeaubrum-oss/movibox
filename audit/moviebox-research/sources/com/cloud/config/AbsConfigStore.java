package com.cloud.config;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.config.AbsConfigStore;
import com.cloud.config.bean.ShuntInfo;
import com.cloud.config.utils.CommonUtils;
import com.cloud.config.utils.ConfigHttpRequest;
import com.cloud.config.utils.Constants;
import com.cloud.config.utils.ConstantsKt;
import com.cloud.config.utils.ExecutorUtils;
import com.cloud.config.utils.XLogUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hisavana.common.tracking.TrackingKey;
import com.tencent.mmkv.MMKV;
import com.tmc.network.HttpRequestor;
import com.transsion.core.utils.f;
import com.transsion.push.PushConstants;
import j9.r;
import j9.s;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class AbsConfigStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f28856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MMKV f28857b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class RequestRunnableConfig implements Runnable {
        private final r configListener;
        private final s configResultListener;
        private final String contentMd5;
        private final String packageName;
        private final String requestUrl;
        private final AbsConfigStore store;

        public RequestRunnableConfig(AbsConfigStore store, String str, r rVar, s sVar, String str2, String requestUrl) {
            Intrinsics.g(store, "store");
            Intrinsics.g(requestUrl, "requestUrl");
            this.store = store;
            this.packageName = str;
            this.configResultListener = sVar;
            this.contentMd5 = str2;
            this.requestUrl = requestUrl;
        }

        public /* synthetic */ RequestRunnableConfig(AbsConfigStore absConfigStore, String str, r rVar, s sVar, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(absConfigStore, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? null : rVar, (i11 & 8) != 0 ? null : sVar, (i11 & 16) != 0 ? "" : str2, str3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: run$lambda-0, reason: not valid java name */
        public static final void m101run$lambda0(RequestRunnableConfig this$0) {
            Intrinsics.g(this$0, "this$0");
            s sVar = this$0.configResultListener;
            if (sVar == null) {
                return;
            }
            sVar.a(1003, ConstantsKt.ERROR_1003_MESSAGE);
        }

        public final r getConfigListener() {
            return null;
        }

        public final s getConfigResultListener() {
            return this.configResultListener;
        }

        public final String getContentMd5() {
            return this.contentMd5;
        }

        public final String getRequestUrl() {
            return this.requestUrl;
        }

        public final AbsConfigStore getStore() {
            return this.store;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                XLogUtil.Companion.getLog().i(XLogUtil.TAG, Intrinsics.p("requestUrl --> ", this.requestUrl));
                HttpRequestor companion = HttpRequestor.Companion.getInstance();
                if (companion == null) {
                    return;
                }
                companion.get(this.requestUrl, new LinkedHashMap(), (Map<String, String>) null, new AbsConfigStore$RequestRunnableConfig$run$1(this));
            } catch (Throwable th2) {
                XLogUtil log = XLogUtil.Companion.getLog();
                String stackTraceString = Log.getStackTraceString(th2);
                Intrinsics.f(stackTraceString, "getStackTraceString(e)");
                log.e(XLogUtil.TAG, stackTraceString);
                ExecutorUtils.main().execute(new Runnable() { // from class: j9.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbsConfigStore.RequestRunnableConfig.m101run$lambda0(this.f67946a);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class RequestRunnableConfigHeader implements Runnable {
        private final r configListener;
        private final s configResultListener;
        private final String packageNameKey;
        private final AbsConfigStore store;

        public RequestRunnableConfigHeader(AbsConfigStore store, String str, r rVar, s sVar) {
            Intrinsics.g(store, "store");
            this.store = store;
            this.packageNameKey = str;
            this.configResultListener = sVar;
        }

        public /* synthetic */ RequestRunnableConfigHeader(AbsConfigStore absConfigStore, String str, r rVar, s sVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(absConfigStore, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? null : rVar, (i11 & 8) != 0 ? null : sVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: run$lambda-0, reason: not valid java name */
        public static final void m102run$lambda0(RequestRunnableConfigHeader this$0) {
            Intrinsics.g(this$0, "this$0");
            s sVar = this$0.configResultListener;
            if (sVar == null) {
                return;
            }
            sVar.a(1005, ConstantsKt.ERROR_1005_MESSAGE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: run$lambda-1, reason: not valid java name */
        public static final void m103run$lambda1(RequestRunnableConfigHeader this$0) {
            Intrinsics.g(this$0, "this$0");
            s sVar = this$0.configResultListener;
            if (sVar == null) {
                return;
            }
            sVar.a(1003, ConstantsKt.ERROR_1003_MESSAGE);
        }

        public final r getConfigListener() {
            return null;
        }

        public final s getConfigResultListener() {
            return this.configResultListener;
        }

        public final AbsConfigStore getStore() {
            return this.store;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [T, java.lang.String] */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.store.s()) {
                    XLogUtil.Companion.getLog().setLogSwitch(true);
                } else {
                    XLogUtil.Companion.getLog().setLogSwitch(Log.isLoggable("CONFIG", 3));
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? r11 = this.packageNameKey;
                objectRef.element = r11;
                if (TextUtils.isEmpty((CharSequence) r11)) {
                    String strJ = this.store.j();
                    objectRef.element = (strJ == null || l.y(strJ)) ? this.store.f28856a.getPackageName() : this.store.j();
                }
                String strEncryptMD5 = CommonUtils.INSTANCE.encryptMD5((String) objectRef.element);
                if (strEncryptMD5 != null && strEncryptMD5.length() != 0) {
                    String str = Constants.Companion.getConfigUrl(this.store.s()) + ((Object) strEncryptMD5) + '/' + ((Object) strEncryptMD5) + ".json";
                    XLogUtil.Companion.getLog().i(XLogUtil.TAG, Intrinsics.p("requestUrl --> ", str));
                    ConfigHttpRequest.Companion.getInstance().getHeader(str, new AbsConfigStore$RequestRunnableConfigHeader$run$2(this, objectRef, str));
                    return;
                }
                ExecutorUtils.main().execute(new Runnable() { // from class: j9.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbsConfigStore.RequestRunnableConfigHeader.m102run$lambda0(this.f67949a);
                    }
                });
            } catch (Throwable th2) {
                XLogUtil log = XLogUtil.Companion.getLog();
                String stackTraceString = Log.getStackTraceString(th2);
                Intrinsics.f(stackTraceString, "getStackTraceString(e)");
                log.e(XLogUtil.TAG, stackTraceString);
                ExecutorUtils.main().execute(new Runnable() { // from class: j9.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbsConfigStore.RequestRunnableConfigHeader.m103run$lambda1(this.f67950a);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class RequestRunnableShunt implements Runnable {
        private final r configListener;
        private final s configResultListener;
        private final Map<String, String> headers;
        private final String packageName;
        private final Map<String, String> requestJson;
        private final String requestUrl;
        private final AbsConfigStore store;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a implements Callback {
            public a() {
            }

            public static final void g(RequestRunnableShunt this$0) {
                Intrinsics.g(this$0, "this$0");
                s configResultListener = this$0.getConfigResultListener();
                if (configResultListener == null) {
                    return;
                }
                configResultListener.a(1004, ConstantsKt.ERROR_1004_MESSAGE);
            }

            public static final void h(RequestRunnableShunt this$0) {
                Intrinsics.g(this$0, "this$0");
                s configResultListener = this$0.getConfigResultListener();
                if (configResultListener == null) {
                    return;
                }
                configResultListener.a(1000, ConstantsKt.ERROR_1000_MESSAGE);
            }

            public static final void i(RequestRunnableShunt this$0, JsonObject dataJsonObject) {
                Intrinsics.g(this$0, "this$0");
                Intrinsics.g(dataJsonObject, "$dataJsonObject");
                AbsConfigStore store = this$0.getStore();
                this$0.getConfigListener();
                store.n(dataJsonObject, null, this$0.getConfigResultListener(), this$0.getPackageName(), this$0.getRequestUrl());
            }

            public static final void j(RequestRunnableShunt this$0, String message) {
                Intrinsics.g(this$0, "this$0");
                Intrinsics.g(message, "$message");
                s configResultListener = this$0.getConfigResultListener();
                if (configResultListener == null) {
                    return;
                }
                configResultListener.a(1001, message);
            }

            public static final void k(RequestRunnableShunt this$0) {
                Intrinsics.g(this$0, "this$0");
                s configResultListener = this$0.getConfigResultListener();
                if (configResultListener == null) {
                    return;
                }
                configResultListener.a(1002, ConstantsKt.ERROR_1002_MESSAGE);
            }

            public static final void l(RequestRunnableShunt this$0) {
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
                final RequestRunnableShunt requestRunnableShunt = RequestRunnableShunt.this;
                executorServiceMain.execute(new Runnable() { // from class: j9.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbsConfigStore.RequestRunnableShunt.a.g(requestRunnableShunt);
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String string;
                Intrinsics.g(call, "call");
                Intrinsics.g(response, "response");
                try {
                    if (response.body() == null) {
                        return;
                    }
                    final RequestRunnableShunt requestRunnableShunt = RequestRunnableShunt.this;
                    ResponseBody responseBodyBody = response.body();
                    Intrinsics.d(responseBodyBody);
                    String responseStr = responseBodyBody.string();
                    XLogUtil.Companion companion = XLogUtil.Companion;
                    companion.getLog().i(XLogUtil.TAG, Intrinsics.p("response --> ", responseStr));
                    Intrinsics.f(responseStr, "responseStr");
                    if (!StringsKt__StringsKt.Q(responseStr, TrackingKey.CODE, false, 2, null) || !StringsKt__StringsKt.Q(responseStr, "data", false, 2, null)) {
                        ExecutorUtils.main().execute(new Runnable() { // from class: j9.p
                            @Override // java.lang.Runnable
                            public final void run() {
                                AbsConfigStore.RequestRunnableShunt.a.k(requestRunnableShunt);
                            }
                        });
                        return;
                    }
                    JsonObject asJsonObject = JsonParser.parseString(responseStr).getAsJsonObject();
                    Intrinsics.f(asJsonObject, "parseString(responseStr).asJsonObject");
                    if (asJsonObject.get(TrackingKey.CODE).getAsInt() != 0) {
                        JsonElement jsonElement = asJsonObject.get("message");
                        final String str = ConstantsKt.ERROR_1001_MESSAGE;
                        if (jsonElement != null && (string = jsonElement.toString()) != null) {
                            str = string;
                        }
                        companion.getLog().e(XLogUtil.TAG, Intrinsics.p("message", str));
                        ExecutorUtils.main().execute(new Runnable() { // from class: j9.o
                            @Override // java.lang.Runnable
                            public final void run() {
                                AbsConfigStore.RequestRunnableShunt.a.j(requestRunnableShunt, str);
                            }
                        });
                        return;
                    }
                    String string2 = asJsonObject.get("data").toString();
                    Intrinsics.f(string2, "jsonObject.get(\"data\").toString()");
                    if (l.y(string2)) {
                        return;
                    }
                    if (Intrinsics.b("{}", string2)) {
                        ExecutorUtils.main().execute(new Runnable() { // from class: j9.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                AbsConfigStore.RequestRunnableShunt.a.h(requestRunnableShunt);
                            }
                        });
                        return;
                    }
                    final JsonObject asJsonObject2 = JsonParser.parseString(string2).getAsJsonObject();
                    Intrinsics.f(asJsonObject2, "parseString(dataStr).asJsonObject");
                    ExecutorUtils.io().execute(new Runnable() { // from class: j9.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            AbsConfigStore.RequestRunnableShunt.a.i(requestRunnableShunt, asJsonObject2);
                        }
                    });
                } catch (Throwable th2) {
                    XLogUtil log = XLogUtil.Companion.getLog();
                    String stackTraceString = Log.getStackTraceString(th2);
                    Intrinsics.f(stackTraceString, "getStackTraceString(e)");
                    log.e(XLogUtil.TAG, stackTraceString);
                    ExecutorService executorServiceMain = ExecutorUtils.main();
                    final RequestRunnableShunt requestRunnableShunt2 = RequestRunnableShunt.this;
                    executorServiceMain.execute(new Runnable() { // from class: j9.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            AbsConfigStore.RequestRunnableShunt.a.l(requestRunnableShunt2);
                        }
                    });
                }
            }
        }

        public RequestRunnableShunt(String str, AbsConfigStore store, Map<String, String> map, Map<String, String> map2, String requestUrl, r rVar, s sVar) {
            Intrinsics.g(store, "store");
            Intrinsics.g(requestUrl, "requestUrl");
            this.packageName = str;
            this.store = store;
            this.headers = map;
            this.requestJson = map2;
            this.requestUrl = requestUrl;
            this.configResultListener = sVar;
        }

        public /* synthetic */ RequestRunnableShunt(String str, AbsConfigStore absConfigStore, Map map, Map map2, String str2, r rVar, s sVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, absConfigStore, map, map2, str2, (i11 & 32) != 0 ? null : rVar, (i11 & 64) != 0 ? null : sVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: run$lambda-0, reason: not valid java name */
        public static final void m104run$lambda0(RequestRunnableShunt this$0) {
            Intrinsics.g(this$0, "this$0");
            s sVar = this$0.configResultListener;
            if (sVar == null) {
                return;
            }
            sVar.a(1003, ConstantsKt.ERROR_1003_MESSAGE);
        }

        public final r getConfigListener() {
            return null;
        }

        public final s getConfigResultListener() {
            return this.configResultListener;
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final Map<String, String> getRequestJson() {
            return this.requestJson;
        }

        public final String getRequestUrl() {
            return this.requestUrl;
        }

        public final AbsConfigStore getStore() {
            return this.store;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                XLogUtil.Companion companion = XLogUtil.Companion;
                companion.getLog().i(XLogUtil.TAG, Intrinsics.p("requestJson --> ", this.requestJson));
                companion.getLog().i(XLogUtil.TAG, Intrinsics.p("requestUrl --> ", this.requestUrl));
                HttpRequestor companion2 = HttpRequestor.Companion.getInstance();
                if (companion2 == null) {
                    return;
                }
                String str = this.requestUrl;
                Map<String, String> linkedHashMap = this.headers;
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                companion2.get(str, linkedHashMap, this.requestJson, new a());
            } catch (Throwable th2) {
                XLogUtil log = XLogUtil.Companion.getLog();
                String stackTraceString = Log.getStackTraceString(th2);
                Intrinsics.f(stackTraceString, "getStackTraceString(e)");
                log.e(XLogUtil.TAG, stackTraceString);
                ExecutorUtils.main().execute(new Runnable() { // from class: j9.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbsConfigStore.RequestRunnableShunt.m104run$lambda0(this.f67953a);
                    }
                });
            }
        }
    }

    public AbsConfigStore(Context context) {
        Intrinsics.g(context, "context");
        this.f28856a = context;
    }

    public static final void o(r rVar, s sVar) {
        if (rVar != null) {
            rVar.b();
        }
        if (sVar == null) {
            return;
        }
        sVar.b();
    }

    public static final void q(r rVar, s sVar) {
        if (rVar != null) {
            rVar.b();
        }
        if (sVar == null) {
            return;
        }
        sVar.b();
    }

    public static final void r(s sVar) {
        if (sVar == null) {
            return;
        }
        sVar.a(1003, ConstantsKt.ERROR_1003_MESSAGE);
    }

    public Map<String, String> h() {
        return null;
    }

    public abstract List<String> i();

    public abstract String j();

    public final Map<String, String> k(ShuntInfo shuntInfo, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (shuntInfo != null && str != null) {
            List<String> conditionParamKeys = shuntInfo.getConditionParamKeys();
            if (conditionParamKeys != null) {
                for (String str2 : conditionParamKeys) {
                    linkedHashMap.put(str2, CommonUtils.INSTANCE.getShuntValue(str2));
                }
            }
            linkedHashMap.put(CommonUtils.PARAM_UID, CommonUtils.INSTANCE.getShuntValue(CommonUtils.PARAM_UID));
            linkedHashMap.put(CommonUtils.PARAM_KEY, str);
            linkedHashMap.put(CommonUtils.PARAM_SHUNTTYPE, String.valueOf(shuntInfo.getShuntType()));
            String json = new Gson().toJson(shuntInfo.getConditionParamKeys());
            Intrinsics.f(json, "Gson().toJson(info.conditionParamKeys)");
            linkedHashMap.put(CommonUtils.PARAM_CONDITIONPARAMKEYS, json);
        }
        return linkedHashMap;
    }

    public final MMKV l() {
        MMKV mmkv = this.f28857b;
        if (mmkv != null) {
            Intrinsics.d(mmkv);
            return mmkv;
        }
        MMKV.u(this.f28856a, Intrinsics.p(this.f28856a.getFilesDir().getAbsolutePath(), PushConstants.CONFIG_URL_PATH));
        MMKV mmkvJ = MMKV.j();
        this.f28857b = mmkvJ;
        Intrinsics.d(mmkvJ);
        return mmkvJ;
    }

    @JvmOverloads
    public final void m(String str, s sVar) {
        f.a(this.f28856a.getApplicationContext());
        CommonUtils commonUtils = CommonUtils.INSTANCE;
        commonUtils.setContext(this.f28856a.getApplicationContext());
        commonUtils.getGaid();
        ExecutorUtils.io().execute(new RequestRunnableConfigHeader(this, str, null, sVar, 4, null));
    }

    public final void n(JsonObject jsonObject, final r rVar, final s sVar, String str, String str2) {
        String storeConfigUrlName;
        try {
            Iterator<String> it = i().iterator();
            while (true) {
                storeConfigUrlName = null;
                JsonElement jsonElement = null;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                JsonElement jsonElement2 = jsonObject.get(next);
                if (jsonElement2 != null) {
                    jsonElement = jsonElement2;
                }
                if (jsonElement == null || jsonElement.isJsonNull()) {
                    l().remove(next);
                } else if (jsonElement.isJsonArray() || jsonElement.isJsonObject()) {
                    l().putString(next, jsonElement.toString());
                } else {
                    l().putString(next, jsonElement.getAsString());
                }
            }
            MMKV mmkvL = l();
            if (str != null) {
                storeConfigUrlName = ConstantsKt.toStoreConfigUrlName(str);
            }
            mmkvL.putString(storeConfigUrlName, str2);
            ExecutorUtils.main().execute(new Runnable(rVar, sVar) { // from class: j9.c

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ s f67945a;

                {
                    this.f67945a = sVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AbsConfigStore.o(null, this.f67945a);
                }
            });
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void p(String str, ShuntInfo shuntInfo, String str2, AbsConfigStore absConfigStore, final r rVar, final s sVar) {
        try {
            String string = absConfigStore.l().getString(str2 == null ? null : ConstantsKt.toStoreConfigUrlName(str2), "");
            XLogUtil.Companion companion = XLogUtil.Companion;
            companion.getLog().i(XLogUtil.TAG, Intrinsics.p("storeConfigUrl --> ", string));
            companion.getLog().i(XLogUtil.TAG, Intrinsics.p("matchCacheUrl --> ", str));
            if (string != null && string.length() > 0 && Intrinsics.b(string, str)) {
                ExecutorUtils.main().execute(new Runnable(rVar, sVar) { // from class: j9.a

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ s f67943a;

                    {
                        this.f67943a = sVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        AbsConfigStore.q(null, this.f67943a);
                    }
                });
                return;
            }
            try {
                if (str.equals(CommonUtils.SHUNT_OPEN_FLAG)) {
                    ExecutorUtils.io().execute(new RequestRunnableShunt(str2, absConfigStore, h(), k(shuntInfo, str2), Constants.Companion.getShuntOpenUrl(absConfigStore.s()), rVar, sVar));
                } else {
                    ExecutorUtils.io().execute(new RequestRunnableShunt(str2, absConfigStore, null, null, str, rVar, sVar));
                }
            } catch (Throwable th2) {
                th = th2;
                XLogUtil log = XLogUtil.Companion.getLog();
                String stackTraceString = Log.getStackTraceString(th);
                Intrinsics.f(stackTraceString, "getStackTraceString(e)");
                log.e(XLogUtil.TAG, stackTraceString);
                ExecutorUtils.main().execute(new Runnable() { // from class: j9.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbsConfigStore.r(sVar);
                    }
                });
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public abstract boolean s();

    public final void t(MMKV mmkv) {
        this.f28857b = mmkv;
    }
}
