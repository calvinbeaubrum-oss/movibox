package com.cloud.tmc.integration.utils;

import android.text.TextUtils;
import com.cloud.tmc.integration.model.AbilityConfig;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.google.gson.reflect.TypeToken;
import com.transsion.push.PushConstants;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;

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
public final class MiniRequestUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MiniRequestUtils f31014a = new MiniRequestUtils();

    @JvmStatic
    public static final void a(String gaid, String appId, wc.b callback) {
        Intrinsics.g(gaid, "gaid");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(callback, "callback");
        HashMap map = new HashMap();
        map.put("gaid", gaid);
        HashMap map2 = new HashMap();
        map2.put(PushConstants.PROVIDER_FIELD_APP_ID, appId);
        ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).get(mb.d.g(), map, map2, Boolean.TRUE, callback);
    }

    @JvmStatic
    public static final void b() {
        if (AbilitiesUtils.f30983a.d()) {
            ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).get(((IConfigStrategyProxy) tc.a.a(IConfigStrategyProxy.class)).getAbilitiesCdnUrl(), new LinkedHashMap(), new LinkedHashMap(), Boolean.FALSE, new wc.b() { // from class: com.cloud.tmc.integration.utils.MiniRequestUtils$requestAbilityConfig$1
                @Override // wc.b
                public void a(int i11, String str, Map<String, String> map, List<Cookie> list, String str2) {
                    ArrayList arrayList;
                    TmcLogger.c("TmcApp: MiniRequestUtils", "onSuccess: " + str);
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    try {
                        Object objE = com.cloud.tmc.miniutils.util.k.e(str, new TypeToken<ArrayList<AbilityConfig>>() { // from class: com.cloud.tmc.integration.utils.MiniRequestUtils$requestAbilityConfig$1$onSuccess$abilitiesConfig$1
                        }.getType());
                        Intrinsics.f(objE, "{\n                      …  )\n                    }");
                        arrayList = (ArrayList) objE;
                    } catch (Exception e11) {
                        TmcLogger.h("Failed to parse ability config", e11);
                        arrayList = new ArrayList();
                    }
                    if (!arrayList.isEmpty()) {
                        AbilitiesUtils.f30983a.f(str);
                    }
                }

                @Override // wc.b
                public void b(String errCode, String str, String str2) {
                    Intrinsics.g(errCode, "errCode");
                    TmcLogger.c("TmcApp: MiniRequestUtils", "onFail: " + str);
                }
            });
        }
    }

    @JvmStatic
    public static final void c(App app, Function1<? super BaseResponse<AppInfoModel>, Unit> function1, Function1<? super BaseResponse<? extends Object>, Unit> function2) {
        Intrinsics.g(app, "app");
        e(app, function1, function2);
    }

    @JvmStatic
    public static final void d(String appId, final Function1<? super BaseResponse<AppInfoModel>, Unit> function1, final Function1<? super BaseResponse<? extends Object>, Unit> function2) {
        Intrinsics.g(appId, "appId");
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("requestChannel", "server_api");
        map.put(PushConstants.PROVIDER_FIELD_APP_ID, appId);
        map.put("needClassification", "1");
        String strC = mb.d.c();
        String strD = q.d();
        if (!TextUtils.isEmpty(strD)) {
            map2.put("gaid", strD);
        }
        TmcLogger.c("TmcApp: MiniRequestUtils", "updateAppInfoForServer: url: " + strC);
        ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).postJson(strC, map2, null, map, Boolean.TRUE, new mb.c<AppInfoModel>() { // from class: com.cloud.tmc.integration.utils.MiniRequestUtils$updateAppInfoForCdn$1
            @Override // mb.c
            public Type d() {
                Type type = new TypeToken<BaseResponse<? extends AppInfoModel>>() { // from class: com.cloud.tmc.integration.utils.MiniRequestUtils$updateAppInfoForCdn$1$getType$1
                }.getType();
                Intrinsics.f(type, "object : TypeToken<BaseR…ppInfoModel?>?>() {}.type");
                return type;
            }

            @Override // mb.c
            public void e(BaseResponse<? extends Object> fail, Map<String, String> map3) {
                Intrinsics.g(fail, "fail");
                TmcLogger.c("TmcApp: MiniRequestUtils", "updateAppInfoForServer failed");
                Function1<BaseResponse<? extends Object>, Unit> function3 = function2;
                if (function3 != null) {
                    function3.invoke(fail);
                }
            }

            @Override // mb.c
            public void g(BaseResponse<? extends AppInfoModel> bean, Map<String, String> map3) {
                Intrinsics.g(bean, "bean");
                TmcLogger.c("TmcApp: MiniRequestUtils", "updateAppInfoForServer success");
                Function1<BaseResponse<AppInfoModel>, Unit> function3 = function1;
                if (function3 != null) {
                    function3.invoke(bean);
                }
            }
        });
    }

    @JvmStatic
    public static final void e(App app, final Function1<? super BaseResponse<AppInfoModel>, Unit> function1, final Function1<? super BaseResponse<? extends Object>, Unit> function2) {
        Intrinsics.g(app, "app");
        String string = app.getStartParams().getString("mode");
        String str = "";
        if (string == null) {
            string = "";
        }
        String string2 = app.getStartParams().getString("sign");
        if (string2 == null) {
            string2 = "";
        }
        boolean z11 = kotlin.text.l.v("debug", string, true) || kotlin.text.l.v("dev", string, true);
        if (kotlin.text.l.v("debug", string, true)) {
            str = "0";
        } else if (kotlin.text.l.v("dev", string, true)) {
            str = "1";
        } else if (kotlin.text.l.v("develop", string, true)) {
            str = "2";
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("requestChannel", "server_api");
        map.put(PushConstants.PROVIDER_FIELD_APP_ID, app.getAppId());
        map.put("needClassification", "1");
        String strC = mb.d.c();
        String strD = q.d();
        if (!TextUtils.isEmpty(strD)) {
            map2.put("gaid", strD);
        }
        if (z11) {
            map.put("version", app.getAppVersion());
            map.put("typeCode", str);
            strC = mb.d.b();
            if (!TextUtils.isEmpty(string2)) {
                map2.put("miniapp-token", string2);
            }
        }
        String str2 = strC;
        TmcLogger.c("TmcApp: MiniRequestUtils", "updateAppInfoForServer: url: " + str2);
        ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).postJson(str2, map2, null, map, Boolean.TRUE, new mb.c<AppInfoModel>() { // from class: com.cloud.tmc.integration.utils.MiniRequestUtils$updateAppInfoForServer$1
            @Override // mb.c
            public Type d() {
                Type type = new TypeToken<BaseResponse<? extends AppInfoModel>>() { // from class: com.cloud.tmc.integration.utils.MiniRequestUtils$updateAppInfoForServer$1$getType$1
                }.getType();
                Intrinsics.f(type, "object : TypeToken<BaseR…ppInfoModel?>?>() {}.type");
                return type;
            }

            @Override // mb.c
            public void e(BaseResponse<? extends Object> fail, Map<String, String> map3) {
                Intrinsics.g(fail, "fail");
                TmcLogger.c("TmcApp: MiniRequestUtils", "updateAppInfoForServer failed");
                Function1<BaseResponse<? extends Object>, Unit> function3 = function2;
                if (function3 != null) {
                    function3.invoke(fail);
                }
            }

            @Override // mb.c
            public void g(BaseResponse<? extends AppInfoModel> bean, Map<String, String> map3) {
                Intrinsics.g(bean, "bean");
                TmcLogger.c("TmcApp: MiniRequestUtils", "updateAppInfoForServer success");
                Function1<BaseResponse<AppInfoModel>, Unit> function3 = function1;
                if (function3 != null) {
                    function3.invoke(bean);
                }
            }
        });
    }
}
