package com.tmc.network;

import android.content.Context;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.gson.Gson;
import com.tmc.network.strategy.d;
import com.transsion.api.gateway.GateWaySdk;
import com.transsion.api.gateway.config.WorkMode;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Timeout;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public class HttpRequestor {
    private static final String CALL_TIMEOUT = "m-timeout";
    private static final long MAX_CALL_TIMEOUT = 90000;
    private boolean ifGatewayAlwaysAccess;
    private int versionCode;
    public static final Companion Companion = new Companion(null);
    private static final String ENCODING = "UTF-8";
    private static final String CONTENT_TYPE = HttpHeaders.CONTENT_TYPE;
    private static final String TIME_ZONE = "Accept-Timezone";
    private static final String LANGUAGE = "Accept-Language";
    private static final String COUNTRY = "Accept-Country";
    private static final String GATEWAY_ALWAYS_ACCESS = "x-tr-region";
    private static final String APP_NAME = "appName";
    private static final String APP_VERSION = "appVersion";
    private static final String VERSION_CODE = "versionCode";
    private static boolean enablePostMode = true;
    private boolean ifCommonHeader = true;
    private String appName = "";
    private String appVersion = "";
    private String language = "";
    private String country = "";
    private final HttpClient httpClient = new HttpClient(null, 1, 0 == true ? 1 : 0);
    private final AtomicBoolean isInit = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HttpRequestor getInstance() {
            return HttpRequestorHolder.INSTANCE.getSInstance();
        }

        public final void setCacheMode(boolean z11, boolean z12) {
            HttpClient.Companion.setCacheMode(z11, z12);
        }

        public final void setLoggable(boolean z11) {
            po.b.f73956a.h(z11);
        }

        public final void setPostMode(boolean z11) {
            HttpRequestor.enablePostMode = z11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class HttpRequestorHolder {
        public static final HttpRequestorHolder INSTANCE = new HttpRequestorHolder();
        private static final HttpRequestor sInstance = new HttpRequestor();

        private HttpRequestorHolder() {
        }

        public HttpRequestor getSInstance() {
            return sInstance;
        }
    }

    private final RequestBody buildRequestBody(Map<String, String> map, Map<String, String> map2) {
        Map<String, String> mapH = map2 == null ? s.h() : map2;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (l.v(CONTENT_TYPE, key, true)) {
                    if (StringsKt__StringsKt.Q(value, "application/x-www-form-urlencoded", false, 2, null)) {
                        Intrinsics.d(map2);
                        return getFormBody(map2);
                    }
                    if (StringsKt__StringsKt.Q(value, "multipart/form-data", false, 2, null)) {
                        Intrinsics.d(map2);
                        return getMultipartBody(map2);
                    }
                    RequestBody.Companion companion = RequestBody.Companion;
                    String json = new Gson().toJson(mapH);
                    Intrinsics.f(json, "Gson().toJson(data)");
                    return companion.create(json, MediaType.Companion.parse(value));
                }
            }
        }
        Intrinsics.d(map2);
        return getFormBody(map2);
    }

    private final FormBody getFormBody(Map<String, String> map) {
        FormBody.Builder builder = new FormBody.Builder(Charset.forName(ENCODING));
        if (po.a.f73954a.c(map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }

    private final Headers getHeaders(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (!this.ifCommonHeader) {
            return new Headers.Builder().build();
        }
        String str = TIME_ZONE;
        po.a aVar = po.a.f73954a;
        map.put(str, aVar.a());
        if (this.ifGatewayAlwaysAccess) {
            map.put(GATEWAY_ALWAYS_ACCESS, "CN");
        }
        if (!aVar.b(this.appName)) {
            map.put(APP_NAME, this.appName);
        }
        if (!aVar.b(this.appVersion)) {
            map.put(APP_VERSION, this.appVersion);
        }
        int i11 = this.versionCode;
        if (i11 > 0) {
            map.put(VERSION_CODE, Intrinsics.p("", Integer.valueOf(i11)));
        }
        if (!aVar.b(this.language)) {
            map.put(LANGUAGE, this.language);
        }
        if (!aVar.b(this.country)) {
            map.put(COUNTRY, this.country);
        }
        return Headers.Companion.of(map);
    }

    private final HttpUrl getHttpUrl(String str, Map<String, String> map) {
        HttpUrl httpUrl = HttpUrl.Companion.parse(str);
        HttpUrl.Builder builderNewBuilder = httpUrl == null ? null : httpUrl.newBuilder();
        if (po.a.f73954a.c(map) && map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (builderNewBuilder != null) {
                    builderNewBuilder.addQueryParameter(key, value);
                }
            }
        }
        if (builderNewBuilder == null) {
            return null;
        }
        return builderNewBuilder.build();
    }

    private final RequestBody getJSONBody(Object obj) {
        String json = new Gson().toJson(obj);
        Intrinsics.f(json, "Gson().toJson(json)");
        return getRawBody(json, MediaType.Companion.parse(ContentType.JSON.toString()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final MultipartBody getMultipartBody(Map<String, String> map) {
        MultipartBody.Builder builder = new MultipartBody.Builder(null, 1, 0 == true ? 1 : 0);
        if (po.a.f73954a.c(map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.addFormDataPart(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }

    private final RequestBody getRawBody(String str, MediaType mediaType) {
        return RequestBody.Companion.create(mediaType, str);
    }

    public static /* synthetic */ void init$default(HttpRequestor httpRequestor, Context context, String str, WorkMode workMode, ProgressListener progressListener, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
        if ((i11 & 4) != 0) {
            workMode = WorkMode.MODE_ONLINE;
        }
        if ((i11 & 8) != 0) {
            progressListener = null;
        }
        httpRequestor.init(context, str, workMode, progressListener);
    }

    public static /* synthetic */ void init$default(HttpRequestor httpRequestor, Context context, String str, WorkMode workMode, ProgressListener progressListener, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
        if ((i11 & 4) != 0) {
            workMode = WorkMode.MODE_ONLINE;
        }
        WorkMode workMode2 = workMode;
        if ((i11 & 8) != 0) {
            progressListener = null;
        }
        httpRequestor.init(context, str, workMode2, progressListener, (i11 & 16) != 0 ? false : z11);
    }

    private final Call post(String str, Map<String, String> map, Map<String, String> map2, RequestBody requestBody, INetworkCallback iNetworkCallback) {
        Timeout timeout;
        NetworkCallback networkCallback = new NetworkCallback(iNetworkCallback);
        Call call = null;
        String str2 = null;
        try {
            Request.Builder builder = new Request.Builder();
            HttpUrl httpUrl = getHttpUrl(str, map2);
            Intrinsics.d(httpUrl);
            Call callNewCall = this.httpClient.newCall(builder.url(httpUrl).headers(getHeaders(map)).post(requestBody).build());
            if (map != null) {
                try {
                    str2 = map.get("m-timeout");
                } catch (Exception e11) {
                    e = e11;
                    call = callNewCall;
                    po.b.f73956a.e(e);
                    iNetworkCallback.onFailure(call, e);
                    return call;
                }
            }
            Long callTimeout = getCallTimeout(str2);
            if (callTimeout != null) {
                callTimeout.longValue();
                if (callNewCall != null && (timeout = callNewCall.timeout()) != null) {
                    timeout.timeout(callTimeout.longValue(), TimeUnit.MILLISECONDS);
                }
            }
            if (callNewCall == null) {
                return callNewCall;
            }
            FirebasePerfOkHttpClient.enqueue(callNewCall, networkCallback);
            return callNewCall;
        } catch (Exception e12) {
            e = e12;
        }
    }

    private final void post(String str, Map<String, String> map, Map<String, String> map2, RequestBody requestBody, Callback callback) {
        try {
            Request.Builder builder = new Request.Builder();
            HttpUrl httpUrl = getHttpUrl(str, map2);
            Intrinsics.d(httpUrl);
            Call callNewCall = this.httpClient.newCall(builder.url(httpUrl).headers(getHeaders(map)).post(requestBody).build());
            if (callNewCall == null) {
                return;
            }
            FirebasePerfOkHttpClient.enqueue(callNewCall, callback);
        } catch (Exception e11) {
            po.b.f73956a.e(e11);
        }
    }

    public final Call delete(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, INetworkCallback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map4 = map;
        String str = CONTENT_TYPE;
        if (map4.get(str) == null) {
            map4.put(str, ContentType.FORM.toString());
        }
        Intrinsics.d(map3);
        return delete(url, map4, map2, getFormBody(map3), callback);
    }

    public final Call delete(String url, Map<String, String> map, Map<String, String> map2, RequestBody requestBody, INetworkCallback callback) {
        Timeout timeout;
        Intrinsics.g(url, "url");
        Intrinsics.g(requestBody, "requestBody");
        Intrinsics.g(callback, "callback");
        NetworkCallback networkCallback = new NetworkCallback(callback);
        Call call = null;
        String str = null;
        try {
            Request.Builder builder = new Request.Builder();
            HttpUrl httpUrl = getHttpUrl(url, map2);
            Intrinsics.d(httpUrl);
            Call callNewCall = this.httpClient.newCall(builder.url(httpUrl).headers(getHeaders(map)).delete(requestBody).build());
            if (map != null) {
                try {
                    str = map.get("m-timeout");
                } catch (Exception e11) {
                    e = e11;
                    call = callNewCall;
                    po.b.f73956a.e(e);
                    callback.onFailure(call, e);
                    return call;
                }
            }
            Long callTimeout = getCallTimeout(str);
            if (callTimeout != null) {
                callTimeout.longValue();
                if (callNewCall != null && (timeout = callNewCall.timeout()) != null) {
                    timeout.timeout(callTimeout.longValue(), TimeUnit.MILLISECONDS);
                }
            }
            if (callNewCall == null) {
                return callNewCall;
            }
            FirebasePerfOkHttpClient.enqueue(callNewCall, networkCallback);
            return callNewCall;
        } catch (Exception e12) {
            e = e12;
        }
    }

    public final void delete(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Callback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map4 = map;
        String str = CONTENT_TYPE;
        if (map4.get(str) == null) {
            map4.put(str, ContentType.FORM.toString());
        }
        Intrinsics.d(map3);
        delete(url, map4, map2, getFormBody(map3), callback);
    }

    public final void delete(String url, Map<String, String> map, Map<String, String> map2, RequestBody requestBody, Callback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(requestBody, "requestBody");
        Intrinsics.g(callback, "callback");
        try {
            Request.Builder builder = new Request.Builder();
            HttpUrl httpUrl = getHttpUrl(url, map2);
            Intrinsics.d(httpUrl);
            Call callNewCall = this.httpClient.newCall(builder.url(httpUrl).headers(getHeaders(map)).delete(requestBody).build());
            if (callNewCall == null) {
                return;
            }
            FirebasePerfOkHttpClient.enqueue(callNewCall, callback);
        } catch (Exception e11) {
            po.b.f73956a.e(e11);
        }
    }

    public final Call get(String url, Map<String, String> params, INetworkCallback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(params, "params");
        Intrinsics.g(callback, "callback");
        return get(url, (Map<String, String>) null, params, callback);
    }

    public final Call get(String url, Map<String, String> map, Map<String, String> map2, INetworkCallback callback) {
        Timeout timeout;
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        NetworkCallback networkCallback = new NetworkCallback(callback);
        Call call = null;
        String str = null;
        try {
            Request.Builder builder = new Request.Builder();
            HttpUrl httpUrl = getHttpUrl(url, map2);
            Intrinsics.d(httpUrl);
            Call callNewCall = this.httpClient.newCall(builder.url(httpUrl).headers(getHeaders(map)).get().build());
            if (map != null) {
                try {
                    str = map.get("m-timeout");
                } catch (Exception e11) {
                    e = e11;
                    call = callNewCall;
                    callback.onFailure(call, e);
                    po.b.f73956a.e(e);
                    return call;
                }
            }
            Long callTimeout = getCallTimeout(str);
            if (callTimeout != null) {
                callTimeout.longValue();
                if (callNewCall != null && (timeout = callNewCall.timeout()) != null) {
                    timeout.timeout(callTimeout.longValue(), TimeUnit.MILLISECONDS);
                }
            }
            if (callNewCall == null) {
                return callNewCall;
            }
            FirebasePerfOkHttpClient.enqueue(callNewCall, networkCallback);
            return callNewCall;
        } catch (Exception e12) {
            e = e12;
        }
    }

    public final void get(String url, Map<String, String> map, Map<String, String> map2, Callback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        try {
            Request.Builder builder = new Request.Builder();
            HttpUrl httpUrl = getHttpUrl(url, map2);
            Intrinsics.d(httpUrl);
            Call callNewCall = this.httpClient.newCall(builder.url(httpUrl).headers(getHeaders(map)).get().build());
            if (callNewCall == null) {
                return;
            }
            FirebasePerfOkHttpClient.enqueue(callNewCall, callback);
        } catch (Exception e11) {
            po.b.f73956a.e(e11);
        }
    }

    public final void get(String url, Map<String, String> params, Callback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(params, "params");
        Intrinsics.g(callback, "callback");
        get(url, (Map<String, String>) null, params, callback);
    }

    public final Long getCallTimeout(String str) {
        if (str == null) {
            return null;
        }
        try {
            long j11 = Long.parseLong(str);
            if (j11 <= 0) {
                return null;
            }
            return j11 >= MAX_CALL_TIMEOUT ? Long.valueOf(MAX_CALL_TIMEOUT) : Long.valueOf(j11);
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
            return null;
        }
    }

    public final HttpClient getHttpClient() {
        return this.httpClient;
    }

    public final Call head(String url, Map<String, String> map, Map<String, String> map2, INetworkCallback callback) {
        Timeout timeout;
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        Call call = null;
        String str = null;
        try {
            NetworkCallback networkCallback = new NetworkCallback(callback);
            Request.Builder builder = new Request.Builder();
            HttpUrl httpUrl = getHttpUrl(url, map2);
            Intrinsics.d(httpUrl);
            Call callNewCall = this.httpClient.newCall(builder.url(httpUrl).headers(getHeaders(map)).head().build());
            if (map != null) {
                try {
                    str = map.get("m-timeout");
                } catch (Exception e11) {
                    e = e11;
                    call = callNewCall;
                    callback.onFailure(call, e);
                    po.b.f73956a.e(e);
                    return call;
                }
            }
            Long callTimeout = getCallTimeout(str);
            if (callTimeout != null) {
                callTimeout.longValue();
                if (callNewCall != null && (timeout = callNewCall.timeout()) != null) {
                    timeout.timeout(callTimeout.longValue(), TimeUnit.MILLISECONDS);
                }
            }
            if (callNewCall == null) {
                return callNewCall;
            }
            FirebasePerfOkHttpClient.enqueue(callNewCall, networkCallback);
            return callNewCall;
        } catch (Exception e12) {
            e = e12;
        }
    }

    public final void init(Context context, String str, WorkMode workMode, ProgressListener progressListener) {
        try {
            if (this.isInit.get()) {
                return;
            }
            po.b bVar = po.b.f73956a;
            bVar.d("HttpRequestor", "HttpRequestor will init");
            synchronized (this) {
                bVar.d("HttpRequestor", "HttpRequestor start init.");
                if (this.isInit.get()) {
                    return;
                }
                NetworkConfig.INSTANCE.setNetworkMonitorEnable(false);
                GateWaySdk.init(context, str, workMode);
                HttpClient.Companion.setProgressListener(progressListener);
                NetworkMonitor.INSTANCE.init(context);
                d.f49369b.a().a(context);
                NetworkAdapter.INSTANCE.init();
                this.isInit.set(true);
                Unit unit = Unit.f68710a;
            }
        } catch (Exception e11) {
            po.b.f73956a.e(e11);
        }
    }

    public final void init(Context context, String str, WorkMode workMode, ProgressListener progressListener, boolean z11) {
        try {
            if (this.isInit.get()) {
                return;
            }
            po.b bVar = po.b.f73956a;
            bVar.d("HttpRequestor", "HttpRequestor will init");
            synchronized (this) {
                bVar.d("HttpRequestor", Intrinsics.p("HttpRequestor start init. isNetworkMonitorEnable =", Boolean.valueOf(z11)));
                if (this.isInit.get()) {
                    return;
                }
                NetworkConfig.INSTANCE.setNetworkMonitorEnable(z11);
                GateWaySdk.init(context, str, workMode);
                bVar.d("HttpRequestor", "HttpRequestor GateWaySdk init finish");
                HttpClient.Companion.setProgressListener(progressListener);
                NetworkMonitor.INSTANCE.init(context);
                d.f49369b.a().a(context);
                NetworkAdapter.INSTANCE.init();
                this.isInit.set(true);
                Unit unit = Unit.f68710a;
            }
        } catch (Exception e11) {
            po.b.f73956a.e(e11);
        }
    }

    public final Call post(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, INetworkCallback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map4 = map;
        String str = CONTENT_TYPE;
        if (map4.get(str) == null) {
            map4.put(str, ContentType.FORM.toString());
        }
        Intrinsics.d(map3);
        return post(url, map4, map2, getFormBody(map3), callback);
    }

    public final void post(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Callback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map4 = map;
        String str = CONTENT_TYPE;
        if (map4.get(str) == null) {
            map4.put(str, ContentType.FORM.toString());
        }
        Intrinsics.d(map3);
        post(url, map4, map2, getFormBody(map3), callback);
    }

    @Deprecated
    public final Call postJSON(String url, Map<String, String> map, Map<String, String> map2, Object obj, INetworkCallback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map3 = map;
        String str = CONTENT_TYPE;
        if (map3.get(str) == null) {
            map3.put(str, ContentType.JSON.toString());
        }
        RequestBody jSONBody = getJSONBody(obj);
        Intrinsics.d(jSONBody);
        return post(url, map3, map2, jSONBody, callback);
    }

    @Deprecated
    public final void postJSON(String url, Map<String, String> map, Map<String, String> map2, Object obj, Callback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map3 = map;
        String str = CONTENT_TYPE;
        if (map3.get(str) == null) {
            map3.put(str, ContentType.JSON.toString());
        }
        RequestBody jSONBody = getJSONBody(obj);
        Intrinsics.d(jSONBody);
        post(url, map3, map2, jSONBody, callback);
    }

    @Deprecated
    public final Call postMultipart(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, INetworkCallback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map4 = map;
        String str = CONTENT_TYPE;
        if (map4.get(str) == null) {
            map4.put(str, ContentType.MULTIPART.toString());
        }
        Intrinsics.d(map3);
        return post(url, map4, map2, getMultipartBody(map3), callback);
    }

    @Deprecated
    public final void postMultipart(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Callback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map4 = map;
        String str = CONTENT_TYPE;
        if (map4.get(str) == null) {
            map4.put(str, ContentType.MULTIPART.toString());
        }
        Intrinsics.d(map3);
        post(url, map4, map2, getMultipartBody(map3), callback);
    }

    @Deprecated
    public final Call postRequestBody(String url, Map<String, String> map, Map<String, String> map2, RequestBody requestBody, INetworkCallback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(requestBody, "requestBody");
        Intrinsics.g(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map3 = map;
        String str = CONTENT_TYPE;
        if (map3.get(str) == null) {
            map3.put(str, ContentType.MULTIPART.toString());
        }
        return post(url, map3, map2, requestBody, callback);
    }

    @Deprecated
    public final void postRequestBody(String url, Map<String, String> map, Map<String, String> map2, RequestBody requestBody, Callback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(requestBody, "requestBody");
        Intrinsics.g(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map3 = map;
        String str = CONTENT_TYPE;
        if (map3.get(str) == null) {
            map3.put(str, ContentType.MULTIPART.toString());
        }
        post(url, map3, map2, requestBody, callback);
    }

    public final Call postV2(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, INetworkCallback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map4 = map;
        String str = CONTENT_TYPE;
        if (map4.get(str) == null) {
            map4.put(str, ContentType.FORM.toString());
        }
        if (enablePostMode) {
            Intrinsics.d(map3);
            return post(url, map4, map2, buildRequestBody(map4, map3), callback);
        }
        Intrinsics.d(map3);
        return post(url, map4, map2, getFormBody(map3), callback);
    }

    public final Call put(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, INetworkCallback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map4 = map;
        String str = CONTENT_TYPE;
        if (map4.get(str) == null) {
            map4.put(str, ContentType.FORM.toString());
        }
        Intrinsics.d(map3);
        return put(url, map4, map2, getFormBody(map3), callback);
    }

    public final Call put(String url, Map<String, String> map, Map<String, String> map2, RequestBody requestBody, INetworkCallback callback) {
        Timeout timeout;
        Intrinsics.g(url, "url");
        Intrinsics.g(requestBody, "requestBody");
        Intrinsics.g(callback, "callback");
        NetworkCallback networkCallback = new NetworkCallback(callback);
        Call call = null;
        String str = null;
        try {
            Request.Builder builder = new Request.Builder();
            HttpUrl httpUrl = getHttpUrl(url, map2);
            Intrinsics.d(httpUrl);
            Call callNewCall = this.httpClient.newCall(builder.url(httpUrl).headers(getHeaders(map)).put(requestBody).build());
            if (map != null) {
                try {
                    str = map.get("m-timeout");
                } catch (Exception e11) {
                    e = e11;
                    call = callNewCall;
                    po.b.f73956a.e(e);
                    callback.onFailure(call, e);
                    return call;
                }
            }
            Long callTimeout = getCallTimeout(str);
            if (callTimeout != null) {
                callTimeout.longValue();
                if (callNewCall != null && (timeout = callNewCall.timeout()) != null) {
                    timeout.timeout(callTimeout.longValue(), TimeUnit.MILLISECONDS);
                }
            }
            if (callNewCall == null) {
                return callNewCall;
            }
            FirebasePerfOkHttpClient.enqueue(callNewCall, networkCallback);
            return callNewCall;
        } catch (Exception e12) {
            e = e12;
        }
    }

    public final void put(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Callback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map4 = map;
        String str = CONTENT_TYPE;
        if (map4.get(str) == null) {
            map4.put(str, ContentType.FORM.toString());
        }
        Intrinsics.d(map3);
        put(url, map4, map2, getFormBody(map3), callback);
    }

    public final void put(String url, Map<String, String> map, Map<String, String> map2, RequestBody requestBody, Callback callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(requestBody, "requestBody");
        Intrinsics.g(callback, "callback");
        try {
            Request.Builder builder = new Request.Builder();
            HttpUrl httpUrl = getHttpUrl(url, map2);
            Intrinsics.d(httpUrl);
            Call callNewCall = this.httpClient.newCall(builder.url(httpUrl).headers(getHeaders(map)).put(requestBody).build());
            if (callNewCall == null) {
                return;
            }
            FirebasePerfOkHttpClient.enqueue(callNewCall, callback);
        } catch (Exception e11) {
            po.b.f73956a.e(e11);
        }
    }

    public final void setAppInfo(String appName, String appVersion, int i11) {
        Intrinsics.g(appName, "appName");
        Intrinsics.g(appVersion, "appVersion");
        this.appName = appName;
        this.appVersion = appVersion;
        this.versionCode = i11;
    }

    public final void setCountry(String country) {
        Intrinsics.g(country, "country");
        this.country = country;
    }

    public final void setGateWayActivateSignConfig(List<String> hostList, List<String> pathList) {
        Intrinsics.g(hostList, "hostList");
        Intrinsics.g(pathList, "pathList");
        GateWaySdk.setActivateSignConfig(hostList, pathList);
    }

    public final void setGatewayAlwaysAccess(boolean z11) {
        this.ifGatewayAlwaysAccess = z11;
    }

    public final void setIfCommonHeader(boolean z11) {
        this.ifCommonHeader = z11;
    }

    public final void setLanguage(String language) {
        Intrinsics.g(language, "language");
        this.language = language;
    }
}
