package com.cloud.tmc.integration.utils;

import android.os.Bundle;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.gson.JsonObject;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import okhttp3.HttpUrl;

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
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f31050a = new f0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f31051b = "MiniForceAddHomeManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f31052c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f31053d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f31054e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ua.c> f31055f = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentHashMap<String, bc.a> f31056g = new ConcurrentHashMap<>();

    public static /* synthetic */ void l(f0 f0Var, String str, bc.a aVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            aVar = null;
        }
        f0Var.k(str, aVar);
    }

    public final void a(String appId, bc.a callback) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(callback, "callback");
        try {
            ConcurrentHashMap<String, bc.a> concurrentHashMap = f31056g;
            if (concurrentHashMap.get(appId) != null) {
                TmcLogger.c(f31051b, "autoRemoveHideLoadingCallback " + appId);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("autoClose", Boolean.TRUE);
                callback.e(jsonObject);
                callback.close();
            }
            TmcLogger.c(f31051b, "addHideLoadingCallback " + appId);
            concurrentHashMap.put(appId, callback);
        } catch (Throwable th2) {
            TmcLogger.g(f31051b, "addHideLoadingCallback", th2);
        }
    }

    public final void b(String str) {
        try {
            TmcLogger.c(f31051b, "addInterectMFAH");
            if (str != null && str.length() != 0) {
                f31053d.put(str, Boolean.TRUE);
            }
        } catch (Throwable th2) {
            TmcLogger.h(f31051b, th2);
        }
    }

    public final void c(String str, ua.c listener) {
        Intrinsics.g(listener, "listener");
        if (str != null) {
            try {
                if (str.length() == 0) {
                    return;
                }
                f31055f.put(str, listener);
            } catch (Throwable th2) {
                TmcLogger.g(f31051b, "addMFAHListener", th2);
            }
        }
    }

    public final boolean d(Bundle bundle) {
        String string;
        List arrayList;
        String string2;
        try {
            MiniAppConfigHelper miniAppConfigHelper = MiniAppConfigHelper.f30370a;
            boolean zB = miniAppConfigHelper.b("enableForceAddHome", true);
            String str = "";
            if (bundle == null || (string = bundle.getString("mfah")) == null) {
                string = "";
            }
            if (bundle != null && (string2 = bundle.getString(PushConstants.PROVIDER_FIELD_APP_ID)) != null) {
                str = string2;
            }
            if (string.length() > 0 && Intrinsics.b(string, "1")) {
                TmcLogger.c(f31051b, "checkForceAddHome mfah -> true");
                if (zB) {
                    b(str);
                    f31052c.put(str, Boolean.TRUE);
                }
                return true;
            }
            if (str.length() > 0) {
                try {
                    Object objD = com.cloud.tmc.miniutils.util.k.d(miniAppConfigHelper.e("mfahList", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI), List.class);
                    arrayList = objD instanceof List ? (List) objD : null;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                } catch (Throwable th2) {
                    TmcLogger.h(f31051b, th2);
                    arrayList = new ArrayList();
                }
                if (arrayList.contains(str)) {
                    TmcLogger.c(f31051b, "checkForceAddHome appId in mfahList");
                    if (zB) {
                        b(str);
                        f31052c.put(str, Boolean.TRUE);
                    }
                    return true;
                }
                if (h(str)) {
                    f31054e.put(str, Boolean.TRUE);
                }
            }
            TmcLogger.c(f31051b, "checkForceAddHome mfah -> false");
            return false;
        } catch (Throwable th3) {
            TmcLogger.g(f31051b, "checkForceAddHome", th3);
            return false;
        }
    }

    public final boolean e(String str) {
        try {
            Boolean bool = f31053d.get(str);
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            Boolean bool2 = f31054e.get(str);
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : false;
            boolean z11 = zBooleanValue || zBooleanValue2;
            TmcLogger.c(f31051b, "checkInterectmfah: " + str + " -> mfahStatus -> " + zBooleanValue + ",privacyStatus ->" + zBooleanValue2);
            return z11;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean f(String str) {
        try {
            Boolean bool = f31053d.get(str);
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            TmcLogger.c(f31051b, "checkInterectmfah: " + str + " -> mfahStatus -> " + zBooleanValue);
            return zBooleanValue;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean g(String str) {
        Boolean bool;
        try {
            Boolean bool2 = f31053d.get(str);
            boolean zBooleanValue = bool2 != null ? bool2.booleanValue() : false;
            if (zBooleanValue && !q.f31091a.j() && ((bool = f31052c.get(str)) == null || !bool.booleanValue())) {
                zBooleanValue = false;
            }
            TmcLogger.c(f31051b, "checkInterectmfah: " + str + " -> mfahStatus -> " + zBooleanValue);
            return zBooleanValue;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean h(String str) {
        try {
            Boolean first = ((ReportProxy) tc.a.a(ReportProxy.class)).checkReportIntercept(str, Boolean.FALSE).getFirst();
            Intrinsics.f(first, "checkReportIntercept.first");
            return first.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public final ConcurrentHashMap<String, Boolean> i() {
        return f31052c;
    }

    public final void j(String str) {
        try {
            TmcLogger.c(f31051b, "noticeClickAllowBtn " + str);
            ua.c cVar = f31055f.get(str);
            if (cVar != null) {
                cVar.p(str);
            }
        } catch (Throwable th2) {
            TmcLogger.h(f31051b, th2);
        }
    }

    public final void k(String appId, bc.a aVar) {
        Intrinsics.g(appId, "appId");
        if (aVar == null) {
            try {
                aVar = f31056g.get(appId);
            } catch (Throwable th2) {
                TmcLogger.g(f31051b, "notifyHideLoading", th2);
                return;
            }
        }
        if (aVar != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("isHideLoding", Boolean.TRUE);
            aVar.d(jsonObject);
            aVar.close();
            n(appId);
            return;
        }
        TmcLogger.c(f31051b, "notifyHideLoading " + appId + " not found");
    }

    public final void m(String str) {
        try {
            TmcLogger.c(f31051b, "removeAllMfahListener -> appId: ->" + str);
            if (str != null && str.length() != 0) {
                f31055f.remove(str);
            }
        } catch (Throwable th2) {
            TmcLogger.h(f31051b, th2);
        }
    }

    public final void n(String appId) {
        Intrinsics.g(appId, "appId");
        try {
            f31056g.remove(appId);
        } catch (Throwable th2) {
            TmcLogger.g(f31051b, "removeHideLoadingCallback", th2);
        }
    }

    public final void o(String str, boolean z11) {
        try {
            TmcLogger.c(f31051b, "removeInterectMFAH " + str);
            TypeIntrinsics.d(f31053d).remove(str);
            TypeIntrinsics.d(f31054e).remove(str);
            TypeIntrinsics.d(f31052c).remove(str);
            n(str == null ? "" : str);
            if (z11) {
                q(str);
            }
        } catch (Throwable th2) {
            TmcLogger.h(f31051b, th2);
        }
    }

    public final void p(String str) {
        try {
            TmcLogger.c(f31051b, "removeMFAHListener -> appId: ->" + str);
            if (str != null && str.length() != 0) {
                m(str);
            }
        } catch (Throwable th2) {
            TmcLogger.h(f31051b, th2);
        }
    }

    public final void q(String str) {
        try {
            ReportProxy reportProxy = (ReportProxy) tc.a.a(ReportProxy.class);
            if (str == null) {
                str = "";
            }
            reportProxy.mfahCacheDataReport(str);
        } catch (Throwable th2) {
            TmcLogger.g(f31051b, "reportAthenaData", th2);
        }
    }
}
