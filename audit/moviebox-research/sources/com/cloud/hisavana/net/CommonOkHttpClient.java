package com.cloud.hisavana.net;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.hisavana.net.disklrucache.impl.IDiskCache;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.net.impl.IHttpCallback;
import com.cloud.hisavana.net.ssl.HttpsTrustManager;
import com.cloud.hisavana.net.utils.ByteBufferUtil;
import com.cloud.sdk.commonutil.util.c;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import iq.g;
import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class CommonOkHttpClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f28925a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Dispatcher f28926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static EventListener.Factory f28927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Exception f28928d = new Exception("http response body is empty");

    /* JADX INFO: compiled from: source.java */
    public static class GeneralOkHttpClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OkHttpClient f28934a = b().build();

        private GeneralOkHttpClient() {
        }

        public static OkHttpClient.Builder b() {
            OkHttpClient.Builder builderEventListenerFactory;
            g gVar = new g(CommonOkHttpClient.f28927c, 0, CommonOkHttpClient.f28925a);
            if (CommonOkHttpClient.f28925a) {
                OkHttpClient.Builder builderHostnameVerifier = new OkHttpClient.Builder().sslSocketFactory(HttpsTrustManager.a(), new HttpsTrustManager()).hostnameVerifier(new HttpsTrustManager.TrustAllHostnameVerifier());
                TimeUnit timeUnit = TimeUnit.SECONDS;
                builderEventListenerFactory = builderHostnameVerifier.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).dispatcher(CommonOkHttpClient.f28926b != null ? CommonOkHttpClient.f28926b : new Dispatcher()).eventListenerFactory(gVar);
            } else {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit2 = TimeUnit.SECONDS;
                builderEventListenerFactory = builder.connectTimeout(30L, timeUnit2).readTimeout(30L, timeUnit2).writeTimeout(30L, timeUnit2).dispatcher(CommonOkHttpClient.f28926b != null ? CommonOkHttpClient.f28926b : new Dispatcher()).eventListenerFactory(gVar);
            }
            c.netLog("getBuilder: isTestRequest = " + CommonOkHttpClient.f28925a);
            return NetGroup.f(builderEventListenerFactory, gVar, NetGroup.e());
        }
    }

    private CommonOkHttpClient() {
        throw new IllegalStateException("Utility class");
    }

    public static String g(RequestParams requestParams, String str, Response response, byte[] bArr) {
        String strD = "";
        try {
            IDiskCache iDiskCacheG = DiskLruCacheUtil.g(requestParams.a());
            if (requestParams.g() && iDiskCacheG != null && response.code() < 300) {
                ImageCacheURL imageCacheURL = new ImageCacheURL(str);
                strD = requestParams.e() ? iDiskCacheG.d(imageCacheURL, response) : iDiskCacheG.b(imageCacheURL, bArr);
                if (Log.isLoggable("ADSDK", 3)) {
                    c.netLog("url :" + str + " , write cache finish.  filePath = " + strD);
                }
            }
        } catch (Exception e11) {
            c.netLog("cacheToDisk is failure, " + Log.getStackTraceString(e11));
        }
        return strD;
    }

    public static Call h(RequestParams requestParams, Request request, IHttpCallback iHttpCallback) {
        IDiskCache iDiskCacheG;
        if (Log.isLoggable("ADSDK", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("downLoadImg okhttp------> run Current Looper:");
            sb2.append(Looper.myLooper() == Looper.getMainLooper() ? "Main Looper" : "thread Looper");
            c.netLog(sb2.toString());
        }
        try {
            if (requestParams.g() && (iDiskCacheG = DiskLruCacheUtil.g(requestParams.a())) != null) {
                File fileC = iDiskCacheG.c(new ImageCacheURL(request.url().toString()));
                if (fileC == null || !fileC.exists() || fileC.length() <= 0) {
                    return n(requestParams, request, iHttpCallback);
                }
                if (Log.isLoggable("ADSDK", 3)) {
                    c.netLog("image url:" + request.url());
                    c.netLog("image path:" + fileC.getPath());
                }
                if (iHttpCallback != null) {
                    if (requestParams.f()) {
                        iHttpCallback.c(250, ByteBufferUtil.c(ByteBufferUtil.a(fileC)), fileC.getPath());
                    } else {
                        iHttpCallback.d(250, ByteBufferUtil.c(ByteBufferUtil.a(fileC)));
                    }
                    return null;
                }
            }
        } catch (IOException e11) {
            c.netLog("downLoadImg: --> " + Log.getStackTraceString(e11));
            if (iHttpCallback != null && 0 != 0) {
                iHttpCallback.e(256, null, e11);
            }
        }
        return n(requestParams, request, iHttpCallback);
    }

    public static Call i(Request request, final IHttpCallback iHttpCallback) {
        try {
            Call callNewCall = j().newCall(request);
            FirebasePerfOkHttpClient.enqueue(callNewCall, new Callback() { // from class: com.cloud.hisavana.net.CommonOkHttpClient.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    try {
                        IHttpCallback iHttpCallback2 = iHttpCallback;
                        if (iHttpCallback2 == null) {
                            return;
                        }
                        if (iOException instanceof SocketTimeoutException) {
                            iHttpCallback2.e(481, null, iOException);
                        } else if (iOException instanceof UnknownHostException) {
                            iHttpCallback2.e(484, null, iOException);
                        } else if (iOException instanceof NoRouteToHostException) {
                            iHttpCallback2.e(485, null, iOException);
                        } else if (iOException instanceof ProtocolException) {
                            iHttpCallback2.e(486, null, iOException);
                        } else if (iOException instanceof ConnectException) {
                            iHttpCallback2.e(483, null, iOException);
                        } else {
                            iHttpCallback2.e(480, null, iOException);
                        }
                    } catch (Exception e11) {
                        IHttpCallback iHttpCallback3 = iHttpCallback;
                        if (iHttpCallback3 != null) {
                            iHttpCallback3.e(480, null, iOException);
                        }
                        CommonOkHttpClient.m(e11);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        IHttpCallback iHttpCallback2 = iHttpCallback;
                        if (iHttpCallback2 == null) {
                            return;
                        }
                        if (response == null) {
                            iHttpCallback2.e(1027, null, CommonOkHttpClient.f28928d);
                        } else {
                            ResponseBody responseBodyBody = response.body();
                            iHttpCallback.f(response.code(), responseBodyBody == null ? new byte[0] : responseBodyBody.bytes(), response.headers());
                        }
                    } catch (Exception e11) {
                        if (response != null) {
                            iHttpCallback.e(response.code(), null, e11);
                        }
                    }
                }
            });
            return callNewCall;
        } catch (Throwable th2) {
            if (iHttpCallback != null) {
                iHttpCallback.e(480, null, th2);
            }
            m(th2);
            return null;
        }
    }

    public static OkHttpClient j() {
        return GeneralOkHttpClient.f28934a;
    }

    public static boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.length() > 0;
    }

    public static Call l(Request request, final IHttpCallback iHttpCallback) {
        if (iHttpCallback != null) {
            iHttpCallback.a();
        }
        try {
            Call callNewCall = j().newCall(request);
            FirebasePerfOkHttpClient.enqueue(callNewCall, new Callback() { // from class: com.cloud.hisavana.net.CommonOkHttpClient.2
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    try {
                        IHttpCallback iHttpCallback2 = iHttpCallback;
                        if (iHttpCallback2 == null) {
                            return;
                        }
                        if (iOException instanceof SocketTimeoutException) {
                            iHttpCallback2.e(481, null, iOException);
                        } else if (iOException instanceof UnknownHostException) {
                            iHttpCallback2.e(484, null, iOException);
                        } else if (iOException instanceof NoRouteToHostException) {
                            iHttpCallback2.e(485, null, iOException);
                        } else if (iOException instanceof ProtocolException) {
                            iHttpCallback2.e(486, null, iOException);
                        } else if (iOException instanceof ConnectException) {
                            iHttpCallback2.e(483, null, iOException);
                        } else {
                            iHttpCallback2.e(480, null, iOException);
                        }
                    } catch (Exception e11) {
                        IHttpCallback iHttpCallback3 = iHttpCallback;
                        if (iHttpCallback3 != null) {
                            iHttpCallback3.e(480, null, iOException);
                        }
                        CommonOkHttpClient.m(e11);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        IHttpCallback iHttpCallback2 = iHttpCallback;
                        if (iHttpCallback2 == null) {
                            return;
                        }
                        if (response == null) {
                            iHttpCallback2.e(1027, null, CommonOkHttpClient.f28928d);
                        } else {
                            ResponseBody responseBodyBody = response.body();
                            iHttpCallback.f(response.code(), responseBodyBody == null ? new byte[0] : responseBodyBody.bytes(), response.headers());
                        }
                    } catch (Exception e11) {
                        if (response != null) {
                            iHttpCallback.e(response.code(), null, e11);
                        }
                    }
                }
            });
            return callNewCall;
        } catch (Throwable th2) {
            if (iHttpCallback != null) {
                iHttpCallback.e(480, null, th2);
            }
            m(th2);
            return null;
        }
    }

    public static void m(Throwable th2) {
        if (!Log.isLoggable("ADSDK", 3) || th2 == null) {
            return;
        }
        c.netLog("onFailure:  " + Log.getStackTraceString(th2));
    }

    public static Call n(final RequestParams requestParams, final Request request, final IHttpCallback iHttpCallback) {
        try {
            Call callNewCall = j().newCall(request);
            FirebasePerfOkHttpClient.enqueue(callNewCall, new Callback() { // from class: com.cloud.hisavana.net.CommonOkHttpClient.3
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    try {
                        IHttpCallback iHttpCallback2 = iHttpCallback;
                        if (iHttpCallback2 == null) {
                            return;
                        }
                        if (iOException instanceof SocketTimeoutException) {
                            iHttpCallback2.e(481, null, iOException);
                        } else if (iOException instanceof UnknownHostException) {
                            iHttpCallback2.e(484, null, iOException);
                        } else if (iOException instanceof NoRouteToHostException) {
                            iHttpCallback2.e(485, null, iOException);
                        } else if (iOException instanceof ProtocolException) {
                            iHttpCallback2.e(486, null, iOException);
                        } else if (iOException instanceof ConnectException) {
                            iHttpCallback2.e(483, null, iOException);
                        } else {
                            iHttpCallback2.e(480, null, iOException);
                        }
                    } catch (Exception e11) {
                        IHttpCallback iHttpCallback3 = iHttpCallback;
                        if (iHttpCallback3 != null) {
                            iHttpCallback3.e(480, null, iOException);
                        }
                        CommonOkHttpClient.m(e11);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    try {
                        if (iHttpCallback == null) {
                            return;
                        }
                        if (response == null || !response.isSuccessful()) {
                            iHttpCallback.e(1027, null, CommonOkHttpClient.f28928d);
                        } else {
                            byte[] bArrBytes = requestParams.e() ? new byte[0] : response.body().bytes();
                            if (!requestParams.f()) {
                                iHttpCallback.f(response.code(), bArrBytes, response.headers());
                            }
                            String strG = CommonOkHttpClient.g(requestParams, request.url().toString(), response, bArrBytes);
                            if (Log.isLoggable("ADSDK", 3)) {
                                c.netLog("onResponse: url = " + request.url() + " , code = " + response.code() + " , filePath = " + strG);
                            }
                            if (requestParams.f()) {
                                if (CommonOkHttpClient.k(strG)) {
                                    iHttpCallback.c(response.code(), bArrBytes, strG);
                                } else {
                                    iHttpCallback.e(1026, null, new Exception("fail to cache file to disk"));
                                }
                            }
                        }
                        IHttpCallback iHttpCallback2 = iHttpCallback;
                        if (iHttpCallback2 != null) {
                            iHttpCallback2.b();
                        }
                    } catch (Exception e11) {
                        IHttpCallback iHttpCallback3 = iHttpCallback;
                        if (iHttpCallback3 != null && response != null) {
                            iHttpCallback3.e(response.code(), null, e11);
                        }
                    }
                }
            });
            return callNewCall;
        } catch (Throwable th2) {
            if (iHttpCallback != null) {
                iHttpCallback.e(480, null, th2);
            }
            m(th2);
            return null;
        }
    }

    public static void o(Dispatcher dispatcher, EventListener.Factory factory) {
        f28926b = dispatcher;
        f28927c = factory;
    }

    public static void p(Dispatcher dispatcher) {
        o(dispatcher, null);
    }
}
