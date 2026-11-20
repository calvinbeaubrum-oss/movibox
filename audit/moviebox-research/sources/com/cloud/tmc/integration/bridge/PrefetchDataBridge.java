package com.cloud.tmc.integration.bridge;

import android.content.Context;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class PrefetchDataBridge implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30567a = "PrefetchDataBridge";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, MiniPrefetchData> f30568b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f30569c = "mini_PrefetchData";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f30570d = "prefetchData";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f30571e = "prefetchToken";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f30572f = "expiredTime";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f30573g = "prefetchTime";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class MiniPrefetchData extends rc.b {
        private bc.a callback;
        private String callbackId;
        private long expiredTime;

        public MiniPrefetchData(long j11, bc.a aVar, String str) {
            this.expiredTime = j11;
            this.callback = aVar;
            this.callbackId = str;
        }

        public static /* synthetic */ MiniPrefetchData copy$default(MiniPrefetchData miniPrefetchData, long j11, bc.a aVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                j11 = miniPrefetchData.expiredTime;
            }
            if ((i11 & 2) != 0) {
                aVar = miniPrefetchData.callback;
            }
            if ((i11 & 4) != 0) {
                str = miniPrefetchData.callbackId;
            }
            return miniPrefetchData.copy(j11, aVar, str);
        }

        public final long component1() {
            return this.expiredTime;
        }

        public final bc.a component2() {
            return this.callback;
        }

        public final String component3() {
            return this.callbackId;
        }

        public final MiniPrefetchData copy(long j11, bc.a aVar, String str) {
            return new MiniPrefetchData(j11, aVar, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MiniPrefetchData)) {
                return false;
            }
            MiniPrefetchData miniPrefetchData = (MiniPrefetchData) obj;
            return this.expiredTime == miniPrefetchData.expiredTime && Intrinsics.b(this.callback, miniPrefetchData.callback) && Intrinsics.b(this.callbackId, miniPrefetchData.callbackId);
        }

        public final bc.a getCallback() {
            return this.callback;
        }

        public final String getCallbackId() {
            return this.callbackId;
        }

        public final long getExpiredTime() {
            return this.expiredTime;
        }

        public int hashCode() {
            int iA = l.p.a(this.expiredTime) * 31;
            bc.a aVar = this.callback;
            int iHashCode = (iA + (aVar == null ? 0 : aVar.hashCode())) * 31;
            String str = this.callbackId;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public final void setCallback(bc.a aVar) {
            this.callback = aVar;
        }

        public final void setCallbackId(String str) {
            this.callbackId = str;
        }

        public final void setExpiredTime(long j11) {
            this.expiredTime = j11;
        }

        public String toString() {
            return "MiniPrefetchData(expiredTime=" + this.expiredTime + ", callback=" + this.callback + ", callbackId=" + this.callbackId + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements bc.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30576c;

        public a(Context context, String str) {
            this.f30575b = context;
            this.f30576c = str;
        }

        @Override // bc.a
        public void a(JsonObject jsonObject) {
        }

        @Override // bc.a
        public void b() {
        }

        @Override // bc.a
        public String c() {
            String token = this.f30576c;
            Intrinsics.f(token, "token");
            return token;
        }

        @Override // bc.a
        public void close() {
        }

        @Override // bc.a
        public void d(JsonObject jsonObject) {
            JsonElement jsonElement;
            MiniPrefetchData miniPrefetchDataRemove = null;
            String asString = (jsonObject == null || (jsonElement = jsonObject.get("callbackId")) == null) ? null : jsonElement.getAsString();
            if (asString == null) {
                return;
            }
            jsonObject.addProperty(PrefetchDataBridge.this.f30571e, asString);
            MiniPrefetchData miniPrefetchData = PrefetchDataBridge.this.getMTempDataMap().get(asString);
            if (miniPrefetchData != null) {
                PrefetchDataBridge prefetchDataBridge = PrefetchDataBridge.this;
                Context context = this.f30575b;
                jsonObject.addProperty("callbackId", miniPrefetchData.getCallbackId());
                JsonElement jsonElement2 = jsonObject.get("response");
                String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                TmcLogger.c(prefetchDataBridge.getTAG(), "token:" + asString + ",response:" + asString2);
                long expiredTime = miniPrefetchData.getExpiredTime();
                HashMap map = new HashMap();
                map.put(prefetchDataBridge.f30570d, asString2);
                map.put(prefetchDataBridge.f30572f, String.valueOf(expiredTime));
                map.put(prefetchDataBridge.f30573g, String.valueOf(System.currentTimeMillis()));
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, prefetchDataBridge.f30569c, asString, com.cloud.tmc.miniutils.util.k.j(map));
                bc.a callback = miniPrefetchData.getCallback();
                if (callback != null) {
                    callback.d(jsonObject);
                }
                miniPrefetchDataRemove = prefetchDataBridge.getMTempDataMap().remove(asString);
            }
            if (miniPrefetchDataRemove == null) {
                TmcLogger.c(PrefetchDataBridge.this.getTAG(), "miniPrefetchData is null");
            }
        }

        @Override // bc.a
        public void e(JsonObject jsonObject) {
            MiniPrefetchData miniPrefetchData;
            JsonElement jsonElement;
            String asString = (jsonObject == null || (jsonElement = jsonObject.get("callbackId")) == null) ? null : jsonElement.getAsString();
            if (asString == null || (miniPrefetchData = PrefetchDataBridge.this.getMTempDataMap().get(asString)) == null) {
                return;
            }
            PrefetchDataBridge prefetchDataBridge = PrefetchDataBridge.this;
            TmcLogger.c(prefetchDataBridge.getTAG(), "token:" + asString + ",预取的网络请求失败了,errorCode:" + jsonObject);
            jsonObject.addProperty("callbackId", miniPrefetchData.getCallbackId());
            bc.a callback = miniPrefetchData.getCallback();
            if (callback != null) {
                callback.e(jsonObject);
            }
            prefetchDataBridge.getMTempDataMap().remove(asString);
        }

        @Override // bc.a
        public void f() {
        }

        @Override // bc.a
        public void g() {
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    public final ConcurrentHashMap<String, MiniPrefetchData> getMTempDataMap() {
        return this.f30568b;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0019  */
    /* JADX WARN: Code duplicated, block: B:44:0x0160 A[Catch: all -> 0x0016, TryCatch #0 {all -> 0x0016, blocks: (B:6:0x000b, B:8:0x0011, B:14:0x001e, B:17:0x0039, B:19:0x004e, B:21:0x0067, B:25:0x006f, B:28:0x008a, B:30:0x0096, B:32:0x009c, B:34:0x00a6, B:35:0x00aa, B:37:0x00f4, B:39:0x010c, B:40:0x0126, B:42:0x0143, B:44:0x0160, B:46:0x017d), top: B:51:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:46:0x017d A[Catch: all -> 0x0016, TRY_LEAVE, TryCatch #0 {all -> 0x0016, blocks: (B:6:0x000b, B:8:0x0011, B:14:0x001e, B:17:0x0039, B:19:0x004e, B:21:0x0067, B:25:0x006f, B:28:0x008a, B:30:0x0096, B:32:0x009c, B:34:0x00a6, B:35:0x00aa, B:37:0x00f4, B:39:0x010c, B:40:0x0126, B:42:0x0143, B:44:0x0160, B:46:0x017d), top: B:51:0x000b }] */
    /* JADX WARN: Instruction removed from duplicated block: B:44:0x0160, please report this as an issue */
    @zb.a
    @zb.e(ExecutorType.IO)
    public final void getPrefetchData(@cc.f(App.class) App app, @cc.g({"prefetchToken"}) String prefetchToken, @cc.c bc.a aVar) {
        Context context;
        Intrinsics.g(prefetchToken, "prefetchToken");
        synchronized (this.f30568b) {
            Unit unit = null;
            if (app != null) {
                try {
                    tb.b appContext = app.getAppContext();
                    if (appContext != null) {
                        context = appContext.getContext();
                    } else {
                        context = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } else {
                context = null;
            }
            if (context == null) {
                if (aVar != null) {
                    aVar.e(z.a().d(this.f30571e, prefetchToken).d("errMsg", "Failed Prefetch data, context is null: PD001").e());
                }
                return;
            }
            Intrinsics.f(context, "app?.appContext?.context…     return\n            }");
            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, this.f30569c, prefetchToken);
            if (string != null) {
                Map map = (Map) com.cloud.tmc.miniutils.util.k.e(string, new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.integration.bridge.PrefetchDataBridge$getPrefetchData$1$1$map$1
                }.getType());
                Object obj = map.get(this.f30570d);
                String str = obj instanceof String ? (String) obj : null;
                if (str == null) {
                    if (aVar != null) {
                        aVar.d(z.a().d(this.f30570d, "").d(this.f30571e, prefetchToken).e());
                    }
                    return;
                }
                String str2 = (String) map.get(this.f30573g);
                long j11 = str2 != null ? Long.parseLong(str2) : 0L;
                String str3 = (String) map.get(this.f30572f);
                long j12 = str3 != null ? Long.parseLong(str3) : 0L;
                long jCurrentTimeMillis = System.currentTimeMillis();
                TmcLogger.c(this.f30567a, "token:" + prefetchToken + ",prefetchData is exist");
                TmcLogger.c(this.f30567a, "prefetchTime:" + j11 + ",expiredTime:" + j12 + ',' + jCurrentTimeMillis);
                if (j11 + j12 >= jCurrentTimeMillis) {
                    TmcLogger.c(this.f30567a, "prefetchData: " + str);
                    if (aVar != null) {
                        aVar.d(z.a().d(this.f30570d, str).d(this.f30571e, prefetchToken).e());
                        unit = Unit.f68710a;
                    }
                } else {
                    TmcLogger.c(this.f30567a, "token:" + prefetchToken + ",prefetchData expired");
                    if (aVar != null) {
                        aVar.d(z.a().d(this.f30570d, "").d(this.f30571e, prefetchToken).e());
                        unit = Unit.f68710a;
                    }
                }
                if (unit == null) {
                    TmcLogger.c(this.f30567a, "token:" + prefetchToken + ",prefetchData is not exist");
                    if (aVar != null) {
                        aVar.d(z.a().d(this.f30570d, "").d(this.f30571e, prefetchToken).e());
                        Unit unit2 = Unit.f68710a;
                    }
                }
            } else {
                TmcLogger.c(this.f30567a, "token:" + prefetchToken + ",prefetchData is not exist");
                if (aVar != null) {
                    aVar.d(z.a().d(this.f30570d, "").d(this.f30571e, prefetchToken).e());
                    Unit unit3 = Unit.f68710a;
                }
            }
        }
    }

    public final String getTAG() {
        return this.f30567a;
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

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public final void prefetchAndSaveToTemp(@cc.f(App.class) App app, @cc.g({"url"}) String str, @cc.g({"method"}) String str2, @cc.g({"requestHeader"}) String str3, @cc.g({"requestParam"}) String str4, @cc.g({"requestTimeout"}) Long l11, @cc.g({"prefetchExpiredTime"}) Long l12, @cc.g({"callbackId"}) String str5, @cc.c bc.a aVar) {
        Context context;
        String strA;
        synchronized (this.f30568b) {
            if (app != null) {
                try {
                    tb.b appContext = app.getAppContext();
                    if (appContext != null) {
                        context = appContext.getContext();
                    } else {
                        context = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } else {
                context = null;
            }
            if (context == null) {
                if (aVar != null) {
                    aVar.e(z.a().d("errMsg", "Failed Prefetch data, context is null: PD001").d("callbackId", str5).e());
                }
                return;
            }
            Intrinsics.f(context, "app?.appContext?.context…     return\n            }");
            String appId = app.getAppId();
            if (appId == null) {
                if (aVar != null) {
                    aVar.e(z.a().d("errMsg", "Failed Prefetch data, appId is null: PD002").d("callbackId", str5).e());
                }
                return;
            }
            Intrinsics.f(appId, "app.appId ?: kotlin.run …     return\n            }");
            String token = com.cloud.tmc.miniutils.util.h.b(appId + '_' + System.currentTimeMillis());
            ConcurrentHashMap<String, MiniPrefetchData> concurrentHashMap = this.f30568b;
            Intrinsics.f(token, "token");
            concurrentHashMap.put(token, new MiniPrefetchData(l12 != null ? l12.longValue() : 0L, aVar, str5));
            try {
                HashMap map = new HashMap();
                Map mapG = TmcGsonUtils.g(str3);
                if (mapG != null) {
                    map.putAll(mapG);
                }
                map.put("requestChannel", "prefetch");
                strA = com.cloud.tmc.kernel.utils.o.a(map);
            } catch (Throwable unused) {
                strA = str3;
            }
            BridgeExtension bridgeExtensionF = app.getExtensionManager().f(PermissionConstant.ACTION_REQUEST);
            if (bridgeExtensionF instanceof NativeRequestBridge) {
                TmcLogger.c(this.f30567a, "url:" + str + ",requestParam:" + str4 + ",header:" + strA + ",method:" + str2 + ",requestTimeout:" + l11 + ",prefetchExpiredTime:" + l12 + ",token:" + token);
                ((NativeRequestBridge) bridgeExtensionF).request(str, str4, strA, str2, l11, token, new a(context, token), app);
            }
            Unit unit = Unit.f68710a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0017  */
    @zb.a
    @zb.e(ExecutorType.IO)
    public final void removePrefetchData(@cc.f(App.class) App app, @cc.g({"prefetchToken"}) String prefetchToken, @cc.c bc.a aVar) {
        Context context;
        Intrinsics.g(prefetchToken, "prefetchToken");
        synchronized (this.f30568b) {
            if (app != null) {
                try {
                    tb.b appContext = app.getAppContext();
                    if (appContext != null) {
                        context = appContext.getContext();
                    } else {
                        context = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } else {
                context = null;
            }
            if (context == null) {
                if (aVar != null) {
                    aVar.e(z.a().d(this.f30571e, prefetchToken).d("errMsg", "Failed Prefetch data, context is null: PD001").e());
                }
                return;
            }
            Intrinsics.f(context, "app?.appContext?.context…     return\n            }");
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).remove(context, this.f30569c, prefetchToken);
            if (aVar != null) {
                aVar.d(z.a().d(this.f30571e, prefetchToken).e());
                Unit unit = Unit.f68710a;
            }
        }
    }
}
