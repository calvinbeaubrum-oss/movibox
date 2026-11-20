package com.cloud.tmc.integration.defaultImpl;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.bridge.NativeRequestBridge;
import com.cloud.tmc.integration.utils.i0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.kernel.utils.l;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.tmc.network.HttpClient;
import com.tmc.network.HttpClientConfig;
import com.tmc.network.HttpRequestor;
import com.tmc.network.INetworkCallback;
import com.tmc.network.NetworkConfig;
import com.tmc.network.ProgressListener;
import com.transsion.api.gateway.config.WorkMode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.h;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class TmcNetworkImpl implements INetWorkProxy {
    public static final b Companion = new b(null);
    public static final int TIME_OUT_VALUE = 60000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f30724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f30725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Call> f30726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Call> f30727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, Call> f30728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f30729f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements ProgressListener {
        public a() {
        }

        @Override // com.tmc.network.ProgressListener
        public void onProgress(long j11, long j12, boolean z11) {
            TmcLogger.f(TmcNetworkImpl.this.getTAG(), "currentBytes=" + j11 + ", contentLength=" + j12 + ", done=" + z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class c implements INetworkCallback {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ wc.b f30732b;

        public c(wc.b bVar) {
            this.f30732b = bVar;
        }

        @Override // com.tmc.network.INetworkCallback
        public void onFailure(Call call, Exception e11) {
            Intrinsics.g(e11, "e");
            TmcNetworkImpl.this.g("R004", "Http Request Fail,onFailure_" + e11 + ":R004", this.f30732b, TmcNetworkImpl.this.e(call));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.tmc.network.INetworkCallback
        public void onResponse(Call call, Response response) {
            Intrinsics.g(call, "call");
            Intrinsics.g(response, "response");
            try {
                if (response.code() != 200) {
                    TmcNetworkImpl.this.g(String.valueOf(response.code()), "Http Request Fail,response.code=" + response.code() + ':' + response.code(), this.f30732b, TmcNetworkImpl.this.e(call));
                    return;
                }
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody != null) {
                    TmcNetworkImpl tmcNetworkImpl = TmcNetworkImpl.this;
                    wc.b bVar = this.f30732b;
                    String strString = responseBodyBody.string();
                    List<Cookie> all = Cookie.Companion.parseAll(response.request().url(), response.headers());
                    Headers headers = response.headers();
                    Set<String> setNames = headers.names();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.a.d(r.e(h.v(setNames, 10)), 16));
                    for (Object obj : setNames) {
                        linkedHashMap.put(obj, headers.get((String) obj));
                    }
                    String strE = tmcNetworkImpl.e(call);
                    if (!TextUtils.isEmpty(strE) && tmcNetworkImpl.getRequestMap().containsKey(strE)) {
                        TypeIntrinsics.d(tmcNetworkImpl.getRequestMap()).remove(strE);
                    }
                    bVar.a(response.code(), strString, linkedHashMap, all, strE);
                }
            } catch (Throwable th2) {
                TmcNetworkImpl.this.g("R005", "Http Request Fail,onResponse_" + th2 + ":R005", this.f30732b, TmcNetworkImpl.this.e(call));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class d implements Callback {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ wc.f f30735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f30736d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f30737f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f30738g;

        public d(String str, wc.f fVar, Map<String, String> map, String str2, String str3) {
            this.f30734b = str;
            this.f30735c = fVar;
            this.f30736d = map;
            this.f30737f = str2;
            this.f30738g = str3;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e11) {
            Intrinsics.g(call, "call");
            Intrinsics.g(e11, "e");
            if (call.isCanceled() || Intrinsics.b("Canceled", e11.getMessage())) {
                TmcNetworkImpl.this.b(this.f30734b, "D006", "Download Fail,onFailure_" + e11 + ":D006", e11, this.f30735c, TmcNetworkImpl.this.d(this.f30736d));
                return;
            }
            TmcNetworkImpl.this.c(this.f30734b, "D006", "Download Fail,onFailure_" + e11 + ":D006", e11, this.f30735c, TmcNetworkImpl.this.d(this.f30736d));
        }

        /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:87:0x0232 A[Catch: IOException -> 0x01c3, TRY_ENTER, TryCatch #3 {IOException -> 0x01c3, blocks: (B:74:0x01bf, B:77:0x01c5, B:87:0x0232, B:89:0x0237), top: B:111:0x0015 }] */
        /* JADX WARN: Code duplicated, block: B:89:0x0237 A[Catch: IOException -> 0x01c3, TRY_LEAVE, TryCatch #3 {IOException -> 0x01c3, blocks: (B:74:0x01bf, B:77:0x01c5, B:87:0x0232, B:89:0x0237), top: B:111:0x0015 }] */
        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            FileOutputStream fileOutputStream;
            long jContentLength;
            Integer numValueOf;
            Intrinsics.g(call, "call");
            Intrinsics.g(response, "response");
            byte[] bArr = new byte[2048];
            InputStream inputStream = null;
            try {
                try {
                    ResponseBody responseBodyBody = response.body();
                    MediaType mediaTypeContentType = responseBodyBody != null ? responseBodyBody.contentType() : null;
                    wc.f fVar = this.f30735c;
                    if (fVar instanceof wc.d) {
                        if (!((wc.d) fVar).e(response.headers())) {
                            IOException iOException = new IOException("responseHeader not allowed go on");
                            TmcNetworkImpl.this.c(this.f30734b, "D008", "Download Fail,onFailure_" + iOException + ":D008", iOException, this.f30735c, TmcNetworkImpl.this.d(this.f30736d));
                            if (TextUtils.isEmpty(this.f30738g) || !TmcNetworkImpl.this.getDownloadMap().containsKey(this.f30738g)) {
                                return;
                            }
                            TypeIntrinsics.d(TmcNetworkImpl.this.getDownloadMap()).remove(this.f30738g);
                            return;
                        }
                        if (!((wc.d) this.f30735c).d(mediaTypeContentType)) {
                            IOException iOException2 = new IOException(mediaTypeContentType + " not supported!");
                            TmcNetworkImpl.this.c(this.f30734b, "D009", "Download Fail,onFailure_" + iOException2 + ":D009", iOException2, this.f30735c, TmcNetworkImpl.this.d(this.f30736d));
                            if (TextUtils.isEmpty(this.f30738g) || !TmcNetworkImpl.this.getDownloadMap().containsKey(this.f30738g)) {
                                return;
                            }
                            TypeIntrinsics.d(TmcNetworkImpl.this.getDownloadMap()).remove(this.f30738g);
                            return;
                        }
                    }
                    InputStream inputStreamByteStream = responseBodyBody != null ? responseBodyBody.byteStream() : null;
                    if (responseBodyBody != null) {
                        try {
                            jContentLength = responseBodyBody.contentLength();
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = null;
                            inputStream = inputStreamByteStream;
                            try {
                                th.printStackTrace();
                                TmcNetworkImpl.this.c(this.f30734b, "D007", "Download Fail,onResponse_" + th + ":D007", new IOException(th), this.f30735c, TmcNetworkImpl.this.d(this.f30736d));
                                if (!TextUtils.isEmpty(this.f30738g)) {
                                    TypeIntrinsics.d(TmcNetworkImpl.this.getDownloadMap()).remove(this.f30738g);
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th3) {
                                if (!TextUtils.isEmpty(this.f30738g) && TmcNetworkImpl.this.getDownloadMap().containsKey(this.f30738g)) {
                                    TypeIntrinsics.d(TmcNetworkImpl.this.getDownloadMap()).remove(this.f30738g);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e11) {
                                        e11.printStackTrace();
                                        TmcLogger.f(TmcNetworkImpl.this.getTAG(), e11.toString());
                                        throw th3;
                                    }
                                }
                                if (fileOutputStream == null) {
                                    throw th3;
                                }
                                fileOutputStream.close();
                                throw th3;
                            }
                        }
                    } else {
                        jContentLength = 1;
                    }
                    File file = new File(this.f30737f);
                    if (file.exists()) {
                        file.delete();
                    }
                    fileOutputStream = new FileOutputStream(file);
                    int i11 = 0;
                    int i12 = 0;
                    while (true) {
                        if (inputStreamByteStream != null) {
                            try {
                                numValueOf = Integer.valueOf(inputStreamByteStream.read(bArr));
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream = inputStreamByteStream;
                                th.printStackTrace();
                                TmcNetworkImpl.this.c(this.f30734b, "D007", "Download Fail,onResponse_" + th + ":D007", new IOException(th), this.f30735c, TmcNetworkImpl.this.d(this.f30736d));
                                if (!TextUtils.isEmpty(this.f30738g) && TmcNetworkImpl.this.getDownloadMap().containsKey(this.f30738g)) {
                                    TypeIntrinsics.d(TmcNetworkImpl.this.getDownloadMap()).remove(this.f30738g);
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                    return;
                                }
                                return;
                            }
                        } else {
                            numValueOf = null;
                        }
                        int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
                        if (numValueOf != null && numValueOf.intValue() == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, i11, iIntValue);
                        int i13 = i12 + iIntValue;
                        int i14 = (int) (((i13 * 1.0f) / jContentLength) * 100);
                        wc.f fVar2 = this.f30735c;
                        if (fVar2 != null) {
                            fVar2.f(this.f30734b, i14, TmcNetworkImpl.this.e(call));
                        }
                        wc.f fVar3 = this.f30735c;
                        if (fVar3 != null) {
                            fVar3.a(this.f30734b, i14, TmcNetworkImpl.this.e(call), i13, jContentLength);
                        }
                        i12 = i13;
                        i11 = 0;
                    }
                    fileOutputStream.flush();
                    wc.f fVar4 = this.f30735c;
                    if (fVar4 != null) {
                        fVar4.c(this.f30734b, TmcNetworkImpl.this.e(call));
                    }
                    if (!TextUtils.isEmpty(this.f30738g) && TmcNetworkImpl.this.getDownloadMap().containsKey(this.f30738g)) {
                        TypeIntrinsics.d(TmcNetworkImpl.this.getDownloadMap()).remove(this.f30738g);
                    }
                    if (inputStreamByteStream != null) {
                        inputStreamByteStream.close();
                    }
                    fileOutputStream.close();
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                }
            } catch (IOException e12) {
                e12.printStackTrace();
                TmcLogger.f(TmcNetworkImpl.this.getTAG(), e12.toString());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements Interceptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wc.c f30739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30740b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30741c;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a implements mb.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ wc.c f30742a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f30743b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f30744c;

            public a(wc.c cVar, String str, String str2) {
                this.f30742a = cVar;
                this.f30743b = str;
                this.f30744c = str2;
            }

            @Override // mb.b
            public void a(long j11, long j12, boolean z11) {
                this.f30742a.a(this.f30743b, (int) (((j11 * 1.0f) / j12) * 100), this.f30744c, j11, j12);
            }
        }

        public e(wc.c cVar, String str, String str2) {
            this.f30739a = cVar;
            this.f30740b = str;
            this.f30741c = str2;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            MediaType mediaTypeContentType;
            String strString;
            Intrinsics.g(chain, "chain");
            Request request = chain.request();
            Request.Builder builderNewBuilder = request.newBuilder();
            if (request.header("upload") != null) {
                builderNewBuilder.method(request.method(), new mb.a(request.body(), new a(this.f30739a, this.f30740b, this.f30741c)));
            }
            Response responseProceed = chain.proceed(builderNewBuilder.build());
            ResponseBody responseBodyBody = responseProceed.body();
            if (responseBodyBody == null || (mediaTypeContentType = responseBodyBody.contentType()) == null) {
                mediaTypeContentType = MediaType.Companion.get("multipart/form-data");
            }
            ResponseBody responseBodyBody2 = responseProceed.body();
            if (responseBodyBody2 == null || (strString = responseBodyBody2.string()) == null) {
                strString = "";
            }
            return responseProceed.newBuilder().body(ResponseBody.Companion.create(mediaTypeContentType, strString)).build();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HttpClient f30745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Interceptor f30746b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TmcNetworkImpl f30747c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30748d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ wc.c f30749f;

        public f(HttpClient httpClient, Interceptor interceptor, TmcNetworkImpl tmcNetworkImpl, String str, wc.c cVar) {
            this.f30745a = httpClient;
            this.f30746b = interceptor;
            this.f30747c = tmcNetworkImpl;
            this.f30748d = str;
            this.f30749f = cVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e11) {
            List<Interceptor> interceptors;
            Intrinsics.g(call, "call");
            Intrinsics.g(e11, "e");
            HttpClientConfig config = this.f30745a.getConfig();
            if (config != null && (interceptors = config.getInterceptors()) != null) {
                interceptors.remove(this.f30746b);
            }
            this.f30745a.resetHttpClient();
            this.f30747c.h(this.f30748d, "U005", "UploadFile fail,onFailure_" + e11 + ":U005", this.f30749f, this.f30747c.e(call));
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            List<Interceptor> interceptors;
            Intrinsics.g(call, "call");
            Intrinsics.g(response, "response");
            HttpClientConfig config = this.f30745a.getConfig();
            if (config != null && (interceptors = config.getInterceptors()) != null) {
                interceptors.remove(this.f30746b);
            }
            this.f30745a.resetHttpClient();
            String strE = this.f30747c.e(call);
            if (!TextUtils.isEmpty(strE) && this.f30747c.getUploadMap().containsKey(strE)) {
                TypeIntrinsics.d(this.f30747c.getUploadMap()).remove(strE);
            }
            try {
                if (response.code() != 200 && response.code() != 204) {
                    this.f30747c.h(this.f30748d, String.valueOf(response.code()), "UploadFile fail,response.code=" + response.code() + ':' + response.code(), this.f30749f, strE);
                    return;
                }
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody != null) {
                    this.f30749f.b(this.f30748d, responseBodyBody.string(), strE);
                }
            } catch (Throwable th2) {
                this.f30747c.h(this.f30748d, "U006", "UploadFile fail,onResponse_" + th2 + ":U006", this.f30749f, strE);
            }
        }
    }

    public TmcNetworkImpl(Context context) {
        Intrinsics.g(context, "context");
        this.f30724a = context;
        this.f30725b = "TmcNetworkImpl";
        this.f30726c = new HashMap<>();
        this.f30727d = new HashMap<>();
        this.f30728e = new ConcurrentHashMap<>();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(AppDynamicBuildConfig.n());
            arrayList.add(AppDynamicBuildConfig.c());
            l.e();
            if (l.e()) {
                NetworkConfig networkConfig = NetworkConfig.INSTANCE;
                networkConfig.setPreHostList(arrayList);
                if (System.currentTimeMillis() % ((long) 10) < ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getInt(context, "miniLauncherGlobal", "network_improve_key")) {
                    this.f30729f = true;
                }
                networkConfig.setNetworkImproveEnable(this.f30729f);
            }
            HttpRequestor.Companion companion = HttpRequestor.Companion;
            companion.setLoggable(false);
            HttpRequestor companion2 = companion.getInstance();
            if (companion2 != null) {
                companion2.init(context, "Lp84tK50u1uwuN3zNQ", Intrinsics.b(AppDynamicBuildConfig.l(), "test") ? WorkMode.MODE_TEST : WorkMode.MODE_ONLINE, new a(), true);
            }
            try {
                companion.setPostMode(MiniAppConfigHelper.f30370a.b("merqm", true));
            } catch (Throwable th2) {
                TmcLogger.f(this.f30725b, "setPostMode error: " + th2);
            }
        } catch (Throwable th3) {
            TmcLogger.h(this.f30725b, th3);
        }
    }

    public final INetworkCallback a(wc.b bVar) {
        return new c(bVar);
    }

    public final void b(String str, String str2, String str3, IOException iOException, wc.f fVar, String str4) {
        if (fVar != null) {
            try {
                fVar.g(str, str4);
            } catch (Throwable unused) {
                return;
            }
        }
        TmcLogger.f(this.f30725b, "errorCode: " + str2 + " errorMsg: " + str3);
        if (TextUtils.isEmpty(str4) || !this.f30726c.containsKey(str4)) {
            return;
        }
        TypeIntrinsics.d(this.f30726c).remove(str4);
    }

    public final void c(String str, String str2, String str3, IOException iOException, wc.f fVar, String str4) {
        if (fVar != null) {
            try {
                fVar.b(str, str2, str3, iOException, str4);
            } catch (Throwable unused) {
                return;
            }
        }
        TmcLogger.f(this.f30725b, str3);
        if (TextUtils.isEmpty(str4) || !this.f30726c.containsKey(str4)) {
            return;
        }
        TypeIntrinsics.d(this.f30726c).remove(str4);
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public void cancelDownloadCall(String str, wc.a aVar) {
        TmcLogger.c(this.f30725b, "cancelDownloadCall, id: " + str);
        try {
            Call call = this.f30726c.get(str);
            if (call != null && !call.isCanceled()) {
                Call call2 = this.f30726c.get(str);
                if (call2 != null) {
                    call2.cancel();
                }
                if (aVar != null) {
                    aVar.success();
                }
            } else if (aVar != null) {
                aVar.a("download task un exist");
            }
            if (TextUtils.isEmpty(str) || !this.f30726c.containsKey(str)) {
            }
        } catch (Throwable th2) {
            if (aVar != null) {
                try {
                    aVar.a(th2.toString());
                } finally {
                    if (!TextUtils.isEmpty(str) && this.f30726c.containsKey(str)) {
                        TypeIntrinsics.d(this.f30726c).remove(str);
                    }
                }
            }
            TmcLogger.e("cancel downloadCall error");
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public void cancelHttpRequest(String id2, wc.a aVar) {
        Intrinsics.g(id2, "id");
        TmcLogger.c(this.f30725b, "cancelHttpRequest, id: " + id2);
        try {
            Call call = this.f30728e.get(id2);
            if (call != null && !call.isCanceled()) {
                Call call2 = this.f30728e.get(id2);
                if (call2 != null) {
                    call2.cancel();
                }
                if (aVar != null) {
                    aVar.success();
                }
            } else if (aVar != null) {
                aVar.a("request task un exist");
            }
            if (TextUtils.isEmpty(id2) || !this.f30728e.containsKey(id2)) {
            }
        } catch (Throwable th2) {
            if (aVar != null) {
                try {
                    aVar.a(th2.toString());
                } finally {
                    if (!TextUtils.isEmpty(id2) && this.f30728e.containsKey(id2)) {
                        this.f30728e.remove(id2);
                    }
                }
            }
            TmcLogger.e("cancel requestCall error:" + th2);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public void cancelUploadCall(String str, wc.a aVar) {
        TmcLogger.c(this.f30725b, "cancelUploadCall, id: " + str);
        try {
            Call call = this.f30727d.get(str);
            if (call != null && !call.isCanceled()) {
                Call call2 = this.f30727d.get(str);
                if (call2 != null) {
                    call2.cancel();
                }
                if (aVar != null) {
                    aVar.success();
                }
            } else if (aVar != null) {
                aVar.a("upload task un exist");
            }
            if (TextUtils.isEmpty(str) || !this.f30727d.containsKey(str)) {
            }
        } catch (Throwable th2) {
            if (aVar != null) {
                try {
                    aVar.a(th2.toString());
                } finally {
                    if (!TextUtils.isEmpty(str) && this.f30727d.containsKey(str)) {
                        TypeIntrinsics.d(this.f30727d).remove(str);
                    }
                }
            }
            TmcLogger.e("cancel uploadCall error");
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public void clearDownloadCall() {
        TmcLogger.c(this.f30725b, "clearDownloadCall");
        try {
            Iterator<Map.Entry<String, Call>> it = this.f30726c.entrySet().iterator();
            while (it.hasNext()) {
                Call value = it.next().getValue();
                if (value != null && !value.isCanceled()) {
                    value.cancel();
                }
            }
        } catch (Throwable unused) {
            TmcLogger.e("clear downloadMap error");
        }
    }

    public final String d(Map<String, String> map) {
        if (map == null || !map.containsKey("callbackId")) {
            return null;
        }
        return map.get("callbackId");
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void delete(String str, Map map, Map map2, Map map3, Boolean bool, wc.b bVar) {
        delete(str, (Map<String, String>) map, (Map<String, String>) map2, (Map<String, String>) map3, bool.booleanValue(), bVar);
    }

    public void delete(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z11, wc.b callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        try {
            TmcLogger.c(this.f30725b, "delete, url: " + url);
            HttpRequestor companion = HttpRequestor.Companion.getInstance();
            Call callDelete = companion != null ? companion.delete(url, com.cloud.tmc.integration.utils.h.f31061a.g(map, z11), map2, map3, a(callback)) : null;
            String strD = d(map);
            if (strD != null) {
                this.f30728e.put(strD, callDelete);
            }
        } catch (Throwable th2) {
            g("R002", "Http Request Fail,Exception_" + th2 + ":R002", callback, d(map));
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public void downloadPackage(String str, String str2, String str3, Map<String, String> map, String str4, wc.f fVar) {
        String str5;
        Timeout timeout;
        HttpClient httpClient;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    if (str2 != null && str2.length() != 0 && i0.b(str2)) {
                        if (str3 != null && str3.length() != 0) {
                            TmcLogger.c(this.f30725b, "downloadPackage, downloadUrl: " + str2);
                            Request.Builder builderUrl = new Request.Builder().url(str2);
                            if (map != null) {
                                builderUrl.headers(Headers.Companion.of(map));
                            }
                            if (str4 != null) {
                                builderUrl.addHeader("callbackId", str4);
                            }
                            Request requestBuild = builderUrl.build();
                            HttpRequestor companion = HttpRequestor.Companion.getInstance();
                            Call callNewCall = (companion == null || (httpClient = companion.getHttpClient()) == null) ? null : httpClient.newCall(requestBuild);
                            if (map != null && (str5 = map.get(NativeRequestBridge.KEY_TIME_OUT)) != null) {
                                long j11 = Long.parseLong(str5);
                                if (callNewCall != null && (timeout = callNewCall.timeout()) != null) {
                                    timeout.timeout(j11, TimeUnit.MILLISECONDS);
                                }
                            }
                            this.f30726c.put(str, callNewCall);
                            if (callNewCall != null) {
                                FirebasePerfOkHttpClient.enqueue(callNewCall, new d(str2, fVar, map, str3, str4));
                                return;
                            }
                            return;
                        }
                        c(str2, "D005", "Download Fail,downloadPath is empty:D005", new IOException("Download Fail,downloadPath is empty:D005"), fVar, d(map));
                        return;
                    }
                    c(str2, "D004", "Download Fail,downloadUrl is error:D004", new IOException("Download Fail,downloadUrl is error:D004"), fVar, d(map));
                    return;
                }
            } catch (Throwable th2) {
                c(str2, "D002", "Download Fail,Exception_" + th2 + ":D002", new IOException(th2), fVar, d(map));
                return;
            }
        }
        c(str2, "D003", "Download Fail,appId is empty:D003", new IOException("Download Fail,appId is empty:D003"), fVar, d(map));
    }

    public final String e(Call call) {
        if (call == null || !call.request().headers().names().contains("callbackId")) {
            return null;
        }
        return call.request().header("callbackId");
    }

    public final Interceptor f(String str, String str2, wc.c cVar) {
        return new e(cVar, str, str2);
    }

    public final void g(String str, String str2, wc.b bVar, String str3) {
        try {
            bVar.b(str, str2, str3);
            TmcLogger.f(this.f30725b, str2);
            if (TextUtils.isEmpty(str3) || !this.f30728e.containsKey(str3)) {
                return;
            }
            TypeIntrinsics.d(this.f30728e).remove(str3);
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void get(String str, Map map, Map map2, Boolean bool, wc.b bVar) {
        get(str, (Map<String, String>) map, (Map<String, String>) map2, bool.booleanValue(), bVar);
    }

    public void get(String url, Map<String, String> map, Map<String, String> map2, boolean z11, wc.b callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        try {
            TmcLogger.c(this.f30725b, "get, url: " + url);
            HttpRequestor companion = HttpRequestor.Companion.getInstance();
            Call call = companion != null ? companion.get(url, com.cloud.tmc.integration.utils.h.f31061a.g(map, z11), map2, a(callback)) : null;
            String strD = d(map);
            if (strD != null) {
                this.f30728e.put(strD, call);
            }
        } catch (Throwable th2) {
            g("R002", "Http Request Fail,Exception_" + th2 + ":R002", callback, d(map));
        }
    }

    public final Context getContext() {
        return this.f30724a;
    }

    public final HashMap<String, Call> getDownloadMap() {
        return this.f30726c;
    }

    public final ConcurrentHashMap<String, Call> getRequestMap() {
        return this.f30728e;
    }

    public final String getTAG() {
        return this.f30725b;
    }

    public final HashMap<String, Call> getUploadMap() {
        return this.f30727d;
    }

    public final void h(String str, String str2, String str3, wc.c cVar, String str4) {
        if (cVar != null) {
            try {
                cVar.c(str, str2, str3, str4);
            } catch (Throwable unused) {
                return;
            }
        }
        TmcLogger.f(this.f30725b, str3);
        if (TextUtils.isEmpty(str4) || !this.f30727d.containsKey(str4)) {
            return;
        }
        TypeIntrinsics.d(this.f30727d).remove(str4);
    }

    public final boolean isNetworkImprove() {
        return this.f30729f;
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void post(String str, Map map, Map map2, Map map3, Boolean bool, wc.b bVar) {
        post(str, (Map<String, String>) map, (Map<String, String>) map2, (Map<String, String>) map3, bool.booleanValue(), bVar);
    }

    public void post(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z11, wc.b callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        try {
            TmcLogger.c(this.f30725b, "post, url: " + url);
            HttpRequestor companion = HttpRequestor.Companion.getInstance();
            Call callPost = companion != null ? companion.post(url, com.cloud.tmc.integration.utils.h.f31061a.g(map, z11), map2, map3, a(callback)) : null;
            String strD = d(map);
            if (strD != null) {
                this.f30728e.put(strD, callPost);
            }
        } catch (Throwable th2) {
            g("R002", "Http Request Fail,Exception_" + th2 + ":R002", callback, d(map));
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void postJson(String str, Map map, Map map2, Object obj, Boolean bool, wc.b bVar) {
        postJson(str, (Map<String, String>) map, (Map<String, String>) map2, obj, bool.booleanValue(), bVar);
    }

    public void postJson(String url, Map<String, String> map, Map<String, String> map2, Object obj, boolean z11, wc.b callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        try {
            TmcLogger.c(this.f30725b, "postJson, url: " + url);
            HttpRequestor companion = HttpRequestor.Companion.getInstance();
            Call callPostJSON = companion != null ? companion.postJSON(url, com.cloud.tmc.integration.utils.h.f31061a.g(map, z11), map2, obj, a(callback)) : null;
            String strD = d(map);
            if (strD != null) {
                this.f30728e.put(strD, callPostJSON);
            }
        } catch (Throwable th2) {
            g("R002", "Http Request Fail,Exception_" + th2 + ":R002", callback, d(map));
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void postMultipart(String str, Map map, Map map2, Map map3, Boolean bool, wc.b bVar) {
        postMultipart(str, (Map<String, String>) map, (Map<String, String>) map2, (Map<String, String>) map3, bool.booleanValue(), bVar);
    }

    public void postMultipart(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z11, wc.b callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        try {
            HttpRequestor companion = HttpRequestor.Companion.getInstance();
            Call callPostMultipart = companion != null ? companion.postMultipart(url, com.cloud.tmc.integration.utils.h.f31061a.g(map, z11), map2, map3, a(callback)) : null;
            String strD = d(map);
            if (strD != null) {
                this.f30728e.put(strD, callPostMultipart);
            }
        } catch (Throwable th2) {
            g("R002", "Http Request Fail,Exception_" + th2 + ":R002", callback, d(map));
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void postV2(String str, Map map, Map map2, Map map3, Boolean bool, wc.b bVar) {
        postV2(str, (Map<String, String>) map, (Map<String, String>) map2, (Map<String, String>) map3, bool.booleanValue(), bVar);
    }

    public void postV2(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z11, wc.b callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        try {
            TmcLogger.c(this.f30725b, "post, url: " + url);
            HttpRequestor companion = HttpRequestor.Companion.getInstance();
            Call callPostV2 = companion != null ? companion.postV2(url, com.cloud.tmc.integration.utils.h.f31061a.g(map, z11), map2, map3, a(callback)) : null;
            String strD = d(map);
            if (strD != null) {
                this.f30728e.put(strD, callPostV2);
            }
        } catch (Throwable th2) {
            g("R002", "Http Request Fail,Exception_" + th2 + ":R002", callback, d(map));
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void put(String str, Map map, Map map2, Map map3, Boolean bool, wc.b bVar) {
        put(str, (Map<String, String>) map, (Map<String, String>) map2, (Map<String, String>) map3, bool.booleanValue(), bVar);
    }

    public void put(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z11, wc.b callback) {
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        try {
            TmcLogger.c(this.f30725b, "put, url: " + url);
            HttpRequestor companion = HttpRequestor.Companion.getInstance();
            Call callPut = companion != null ? companion.put(url, com.cloud.tmc.integration.utils.h.f31061a.g(map, z11), map2, map3, a(callback)) : null;
            String strD = d(map);
            if (strD != null) {
                this.f30728e.put(strD, callPut);
            }
        } catch (Throwable th2) {
            g("R002", "Http Request Fail,Exception_" + th2 + ":R002", callback, d(map));
        }
    }

    public final void setNetworkImprove(boolean z11) {
        this.f30729f = z11;
    }

    public final void setTAG(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f30725b = str;
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public void startPreConnect() {
        if (NetworkConfig.INSTANCE.isNetworkImproveEnable()) {
            com.tmc.network.strategy.c cVar = new com.tmc.network.strategy.c(AppDynamicBuildConfig.n());
            com.tmc.network.strategy.c cVar2 = new com.tmc.network.strategy.c(AppDynamicBuildConfig.c());
            cVar.a();
            cVar2.a();
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void uploadFile(String str, String str2, String str3, Map map, Map map2, Map map3, Boolean bool, wc.c cVar) {
        uploadFile(str, str2, str3, (Map<String, String>) map, (Map<String, String>) map2, (Map<String, String>) map3, bool.booleanValue(), cVar);
    }

    public void uploadFile(String url, String filePath, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, boolean z11, wc.c callback) {
        String str2;
        Timeout timeout;
        HttpClientConfig config;
        Intrinsics.g(url, "url");
        Intrinsics.g(filePath, "filePath");
        Intrinsics.g(callback, "callback");
        TmcLogger.c(this.f30725b, "uploadFile, url: " + url);
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("callbackId", str == null ? "" : str);
            linkedHashMap.put("upload", "true");
            if (map != null) {
                linkedHashMap.putAll(map);
            }
            File file = new File(filePath);
            String value = "multipart/form-data";
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (kotlin.text.l.v("content-type", entry.getKey(), true)) {
                        value = entry.getValue();
                    }
                }
            }
            RequestBody requestBodyCreate = RequestBody.Companion.create(MediaType.Companion.parse(value), file);
            MultipartBody.Builder type = new MultipartBody.Builder(null, 1, null).setType(MultipartBody.FORM);
            if (map3 != null) {
                for (Map.Entry<String, String> entry2 : map3.entrySet()) {
                    type.addFormDataPart(entry2.getKey(), entry2.getValue());
                }
            }
            type.addFormDataPart("file", file.getName(), requestBodyCreate);
            Request requestBuild = new Request.Builder().url(url).post(type.build()).headers(Headers.Companion.of(linkedHashMap)).build();
            HttpRequestor companion = HttpRequestor.Companion.getInstance();
            HttpClient httpClient = companion != null ? companion.getHttpClient() : null;
            Interceptor interceptorF = f(url, str, callback);
            if (httpClient != null && (config = httpClient.getConfig()) != null) {
                config.addInterceptor(interceptorF);
            }
            if (httpClient != null) {
                httpClient.resetHttpClient();
            }
            Call callNewCall = httpClient != null ? httpClient.newCall(requestBuild) : null;
            if (map != null && (str2 = map.get(NativeRequestBridge.KEY_TIME_OUT)) != null) {
                long j11 = Long.parseLong(str2);
                if (callNewCall != null && (timeout = callNewCall.timeout()) != null) {
                    timeout.timeout(j11, TimeUnit.MILLISECONDS);
                }
            }
            if (str != null) {
                this.f30727d.put(str, callNewCall);
            }
            if (callNewCall != null) {
                FirebasePerfOkHttpClient.enqueue(callNewCall, new f(httpClient, interceptorF, this, url, callback));
            }
        } catch (Throwable th2) {
            h(url, "U002", "UploadFile fail,Exception_" + th2 + ":U002", callback, d(map));
        }
    }
}
