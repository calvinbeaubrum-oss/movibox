package com.cloud.tmc.miniapp.bridge;

import OooOoOO.o0OOO0o;
import android.content.Context;
import android.net.Uri;
import cc.f;
import cc.g;
import com.cloud.tmc.integration.bridge.FrameworkStorageBridge;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.miniapp.bridge.PrefetchStrategyBridge;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.j;
import com.cloud.tmc.miniutils.util.k;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.tracking.TrackingKey;
import com.tmc.network.HttpRequestor;
import com.tmc.network.INetworkCallback;
import com.transsion.push.PushConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class PrefetchStrategyBridge implements BridgeExtension {
    public static final a Companion = new a();
    public static final String TAG = "PrefetchStrategyBridge";

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function2<PrefetchConfigModel, PrefetchConfigModel, Integer> {
        public static final OooO0O0 OooO00o = new OooO0O0();

        public OooO0O0() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Integer invoke(PrefetchConfigModel prefetchConfigModel, PrefetchConfigModel prefetchConfigModel2) {
            PrefetchConfigModel prefetchConfigModel3 = prefetchConfigModel;
            PrefetchConfigModel prefetchConfigModel4 = prefetchConfigModel2;
            return Integer.valueOf((prefetchConfigModel3 != null ? prefetchConfigModel3.getPriority() : 0) - (prefetchConfigModel4 != null ? prefetchConfigModel4.getPriority() : 0));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @SourceDebugExtension
    public static final class OooOO0O extends Lambda implements Function2<Response, bc.a, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ String OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooOO0O(String str, String str2) {
            super(2);
            this.OooO00o = str;
            this.OooO0O0 = str2;
        }

        /* JADX WARN: Code duplicated, block: B:71:0x0157 A[Catch: all -> 0x0155, TRY_LEAVE, TryCatch #3 {all -> 0x0155, blocks: (B:68:0x0151, B:71:0x0157), top: B:96:0x0151 }] */
        /* JADX WARN: Code duplicated, block: B:73:0x015c A[Catch: all -> 0x0144, TRY_ENTER, TryCatch #2 {all -> 0x0144, blocks: (B:60:0x0140, B:63:0x0146, B:73:0x015c, B:75:0x0161), top: B:95:0x0085 }] */
        /* JADX WARN: Code duplicated, block: B:75:0x0161 A[Catch: all -> 0x0144, TRY_LEAVE, TryCatch #2 {all -> 0x0144, blocks: (B:60:0x0140, B:63:0x0146, B:73:0x015c, B:75:0x0161), top: B:95:0x0085 }] */
        /* JADX WARN: Code duplicated, block: B:83:0x0173 A[Catch: all -> 0x016f, TRY_LEAVE, TryCatch #5 {all -> 0x016f, blocks: (B:79:0x016b, B:83:0x0173), top: B:100:0x016b }] */
        /* JADX WARN: Code duplicated, block: B:96:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Response response, bc.a aVar) {
            String strValueOf;
            InputStream inputStream;
            Throwable th2;
            Integer numValueOf;
            Response response2 = response;
            bc.a aVar2 = aVar;
            Intrinsics.g(response2, "response");
            if (response2.code() == 200) {
                String str = response2.headers().get("content-type");
                JsonObject jsonObject = new JsonObject();
                FileOutputStream fileOutputStream = null;
                if (Intrinsics.b(str, "application/json")) {
                    ResponseBody responseBodyBody = response2.body();
                    jsonObject.addProperty("data", responseBodyBody != null ? responseBodyBody.string() : null);
                    if (aVar2 != null) {
                        aVar2.d(jsonObject);
                    }
                } else {
                    String path = Uri.parse(this.OooO00o).getPath();
                    if (path == null || path.length() == 0) {
                        strValueOf = String.valueOf(System.currentTimeMillis());
                    } else {
                        int length = path.length() - 1;
                        if (length < 0) {
                            length = -1;
                            break;
                        }
                        while (true) {
                            int i11 = length - 1;
                            if (path.charAt(length) == '/') {
                                break;
                            }
                            if (i11 < 0) {
                                length = -1;
                                break;
                            }
                            length = i11;
                        }
                        strValueOf = path.substring(length);
                        Intrinsics.f(strValueOf, "this as java.lang.String).substring(startIndex)");
                    }
                    byte[] bArr = new byte[2048];
                    try {
                        try {
                            ResponseBody responseBodyBody2 = response2.body();
                            InputStream inputStreamByteStream = responseBodyBody2 != null ? responseBodyBody2.byteStream() : null;
                            try {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(this.OooO0O0));
                                String str2 = File.separator;
                                sb2.append(str2);
                                sb2.append("temp_data");
                                String string = sb2.toString();
                                j.i(new File(string));
                                File file = new File(string + str2 + strValueOf);
                                if (file.exists()) {
                                    file.delete();
                                }
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                while (true) {
                                    if (inputStreamByteStream != null) {
                                        try {
                                            numValueOf = Integer.valueOf(inputStreamByteStream.read(bArr));
                                        } catch (Throwable th3) {
                                            th2 = th3;
                                            fileOutputStream = fileOutputStream2;
                                            if (aVar2 != null) {
                                                try {
                                                    aVar2.b();
                                                    TmcLogger.h(PrefetchStrategyBridge.TAG, th2);
                                                    if (inputStreamByteStream != null) {
                                                        inputStreamByteStream.close();
                                                    }
                                                    if (fileOutputStream != null) {
                                                        fileOutputStream.close();
                                                    }
                                                } catch (Throwable th4) {
                                                    if (inputStreamByteStream != null) {
                                                        try {
                                                            inputStreamByteStream.close();
                                                            if (fileOutputStream != null) {
                                                                fileOutputStream.close();
                                                            }
                                                        } catch (Throwable th5) {
                                                            TmcLogger.h(PrefetchStrategyBridge.TAG, th5);
                                                            throw th4;
                                                        }
                                                    } else if (fileOutputStream != null) {
                                                        fileOutputStream.close();
                                                    }
                                                    throw th4;
                                                }
                                            } else {
                                                TmcLogger.h(PrefetchStrategyBridge.TAG, th2);
                                                if (inputStreamByteStream != null) {
                                                    inputStreamByteStream.close();
                                                }
                                                if (fileOutputStream != null) {
                                                    fileOutputStream.close();
                                                }
                                            }
                                        }
                                    } else {
                                        numValueOf = null;
                                    }
                                    int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
                                    if (numValueOf != null && numValueOf.intValue() == -1) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, iIntValue);
                                }
                                fileOutputStream2.flush();
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(FileUtil.U(this.OooO0O0));
                                String str3 = File.separator;
                                sb3.append(str3);
                                sb3.append("temp_data");
                                sb3.append(str3);
                                sb3.append(file.getName());
                                jsonObject.addProperty("data", sb3.toString());
                                if (aVar2 != null) {
                                    aVar2.d(jsonObject);
                                }
                                if (inputStreamByteStream != null) {
                                    inputStreamByteStream.close();
                                }
                                fileOutputStream2.close();
                            } catch (Throwable th6) {
                                inputStream = inputStreamByteStream;
                                th = th6;
                                InputStream inputStream2 = inputStream;
                                th2 = th;
                                inputStreamByteStream = inputStream2;
                                if (aVar2 != null) {
                                    aVar2.b();
                                    TmcLogger.h(PrefetchStrategyBridge.TAG, th2);
                                    if (inputStreamByteStream != null) {
                                        inputStreamByteStream.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                } else {
                                    TmcLogger.h(PrefetchStrategyBridge.TAG, th2);
                                    if (inputStreamByteStream != null) {
                                        inputStreamByteStream.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                }
                                return Unit.f68710a;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            inputStream = null;
                        }
                    } catch (Throwable th8) {
                        TmcLogger.h(PrefetchStrategyBridge.TAG, th8);
                    }
                }
            } else if (aVar2 != null) {
                aVar2.b();
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements INetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f31495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2<Response, bc.a, Unit> f31496b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(bc.a aVar, Function2<? super Response, ? super bc.a, Unit> function2) {
            this.f31495a = aVar;
            this.f31496b = function2;
        }

        @Override // com.tmc.network.INetworkCallback
        public void onFailure(Call call, Exception e11) {
            Intrinsics.g(e11, "e");
            bc.a aVar = this.f31495a;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.tmc.network.INetworkCallback
        public void onResponse(Call call, Response response) {
            Intrinsics.g(call, "call");
            Intrinsics.g(response, "response");
            this.f31496b.invoke(response, this.f31495a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements INetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f31497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2<Response, bc.a, Unit> f31498b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(bc.a aVar, Function2<? super Response, ? super bc.a, Unit> function2) {
            this.f31497a = aVar;
            this.f31498b = function2;
        }

        @Override // com.tmc.network.INetworkCallback
        public void onFailure(Call call, Exception e11) {
            Intrinsics.g(e11, "e");
            bc.a aVar = this.f31497a;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.tmc.network.INetworkCallback
        public void onResponse(Call call, Response response) {
            Intrinsics.g(call, "call");
            Intrinsics.g(response, "response");
            this.f31498b.invoke(response, this.f31497a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements INetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f31499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2<Response, bc.a, Unit> f31500b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(bc.a aVar, Function2<? super Response, ? super bc.a, Unit> function2) {
            this.f31499a = aVar;
            this.f31500b = function2;
        }

        @Override // com.tmc.network.INetworkCallback
        public void onFailure(Call call, Exception e11) {
            Intrinsics.g(e11, "e");
            bc.a aVar = this.f31499a;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.tmc.network.INetworkCallback
        public void onResponse(Call call, Response response) {
            Intrinsics.g(call, "call");
            Intrinsics.g(response, "response");
            this.f31500b.invoke(response, this.f31499a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements INetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f31501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2<Response, bc.a, Unit> f31502b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(bc.a aVar, Function2<? super Response, ? super bc.a, Unit> function2) {
            this.f31501a = aVar;
            this.f31502b = function2;
        }

        @Override // com.tmc.network.INetworkCallback
        public void onFailure(Call call, Exception e11) {
            Intrinsics.g(e11, "e");
            bc.a aVar = this.f31501a;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.tmc.network.INetworkCallback
        public void onResponse(Call call, Response response) {
            Intrinsics.g(call, "call");
            Intrinsics.g(response, "response");
            this.f31502b.invoke(response, this.f31501a);
        }
    }

    public static final int OooO00o(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.g(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @zb.a
    public final void changePrefetchStatus(@f(App.class) App app) {
        Context context;
        JsonObject jsonObject;
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext != null) {
                    context = appContext.getContext();
                } else {
                    context = null;
                }
            } catch (Throwable th2) {
                TmcLogger.h(TAG, th2);
                return;
            }
        } else {
            context = null;
        }
        if (context == null || (jsonObject = (JsonObject) k.d(((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, FrameworkStorageBridge.FRAMEWORK_STORAGE_KEY, "prefetch_state_key"), JsonObject.class)) == null) {
            return;
        }
        JsonElement jsonElement = jsonObject.get(PushConstants.PROVIDER_FIELD_APP_ID);
        if (Intrinsics.b(jsonElement != null ? jsonElement.getAsString() : null, app.getAppId())) {
            TmcLogger.f(TAG, app.getAppId() + " destroy. change prefetch state");
            jsonObject.addProperty("state", Boolean.FALSE);
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, FrameworkStorageBridge.FRAMEWORK_STORAGE_KEY, "prefetch_state_key", jsonObject.toString());
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void getPreStrategy(@f(App.class) App app, @cc.c bc.a aVar) {
        String string;
        String string2;
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        try {
            List<PrefetchConfigModel> listJ0 = CollectionsKt___CollectionsKt.J0(o0OOO0o.f191d.snapshot().keySet());
            final OooO0O0 oooO0O0 = OooO0O0.OooO00o;
            Collections.sort(listJ0, new Comparator() { // from class: ld.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return PrefetchStrategyBridge.OooO00o(oooO0O0, obj, obj2);
                }
            });
            for (PrefetchConfigModel prefetchConfigModel : listJ0) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("sceneId", prefetchConfigModel.getSceneId());
                jsonObject2.addProperty(PushConstants.PROVIDER_FIELD_APP_ID, prefetchConfigModel.getAppId());
                jsonObject2.addProperty(TrackingKey.PRIORITY, Integer.valueOf(prefetchConfigModel.getPriority()));
                jsonObject2.addProperty("dataType", prefetchConfigModel.getDataType());
                ArrayList<JsonObject> source = prefetchConfigModel.getSource();
                String str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                if (source == null || (string = source.toString()) == null) {
                    string = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                }
                jsonObject2.addProperty("source", string);
                ArrayList<String> h5Url = prefetchConfigModel.getH5Url();
                if (h5Url != null && (string2 = h5Url.toString()) != null) {
                    str = string2;
                }
                jsonObject2.addProperty("h5Url", str);
                jsonObject2.addProperty("netType", Integer.valueOf(prefetchConfigModel.getNetType()));
                jsonObject2.addProperty("expiredTime", Long.valueOf(prefetchConfigModel.getExpiredTime()));
                jsonObject2.addProperty("executeTime", Long.valueOf(prefetchConfigModel.getExecuteTime()));
                jsonArray.add(jsonObject2);
            }
            jsonObject.add("data", jsonArray);
            if (aVar != null) {
                aVar.d(jsonObject);
            }
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public final void requestStrategy(@f(App.class) App app, @g({PushConstants.PROVIDER_FIELD_APP_ID}) String str, @g({"url"}) String str2, @g({"header"}) String str3, @g({"method"}) String str4, @g({"param"}) String str5, @g({"supportCell"}) boolean z11, @cc.c bc.a aVar) {
        Map<String, String> mapA;
        Map<String, String> mapA2;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str4 == null || str4.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            if (NetworkUtils.t() && !z11) {
                TmcLogger.f(TAG, "current netType is cellular");
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (str5 != null && str5.length() != 0 && (mapA2 = TmcGsonUtils.a(str5)) != null) {
                for (Map.Entry<String, String> entry : mapA2.entrySet()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Map<String, String> mapG = h.f31061a.g(new LinkedHashMap(), true);
            if (str3 != null && str3.length() != 0 && (mapA = TmcGsonUtils.a(str5)) != null) {
                for (Map.Entry<String, String> entry2 : mapA.entrySet()) {
                    mapG.put(entry2.getKey(), entry2.getValue());
                }
            }
            OooOO0O oooOO0O = new OooOO0O(str2, str);
            int iHashCode = str4.hashCode();
            if (iHashCode != -2019344435) {
                if (iHashCode == 102230) {
                    if (str4.equals("get")) {
                        HttpRequestor companion = HttpRequestor.Companion.getInstance();
                        if (companion != null) {
                            companion.get(str2, mapG, linkedHashMap, new b(aVar, oooOO0O));
                            return;
                        }
                        return;
                    }
                } else if (iHashCode != 3446944) {
                    if (iHashCode == 2002678055 && str4.equals("post_json")) {
                        HttpRequestor companion2 = HttpRequestor.Companion.getInstance();
                        if (companion2 != null) {
                            companion2.postJSON(str2, mapG, new LinkedHashMap(), linkedHashMap, new c(aVar, oooOO0O));
                            return;
                        }
                        return;
                    }
                } else if (str4.equals("post")) {
                    HttpRequestor companion3 = HttpRequestor.Companion.getInstance();
                    if (companion3 != null) {
                        companion3.post(str2, mapG, new LinkedHashMap(), linkedHashMap, new d(aVar, oooOO0O));
                        return;
                    }
                    return;
                }
            } else if (str4.equals("post_multipart")) {
                HttpRequestor companion4 = HttpRequestor.Companion.getInstance();
                if (companion4 != null) {
                    companion4.postMultipart(str2, mapG, new LinkedHashMap(), linkedHashMap, new e(aVar, oooOO0O));
                    return;
                }
                return;
            }
            if (aVar != null) {
                aVar.b();
            }
        } catch (Throwable th2) {
            if (aVar != null) {
                aVar.b();
            }
            TmcLogger.h(TAG, th2);
        }
    }
}
