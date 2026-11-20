package com.cloud.tmc.integration.permission;

import android.text.TextUtils;
import com.cloud.tmc.integration.permission.config.ApiPermissionHelper;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.g;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dd.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kc.b;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PermissionConfig {
    public static final String GROUPS = "groups";
    public static final String WHITELIST = "whitelist";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static PermissionConfig f30887d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f30888e = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Map<String, f>> f30889a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, List<String>> f30890b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f30891c = new HashSet();

    public PermissionConfig() {
        initConfig();
    }

    public static PermissionConfig getInstance() {
        PermissionConfig permissionConfig = f30887d;
        if (permissionConfig != null) {
            return permissionConfig;
        }
        synchronized (PermissionConfig.class) {
            try {
                if (f30887d == null) {
                    f30887d = new PermissionConfig();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f30887d;
    }

    public final void a(String str) {
        JsonObject jsonObjectE;
        if (TextUtils.isEmpty(str)) {
            TmcLogger.c("Tmcintegration:PermissionConfig", "permissionConfig is empty");
            return;
        }
        try {
            jsonObjectE = g.e(str);
        } catch (Exception e11) {
            TmcLogger.h("Tmcintegration:PermissionConfig", e11);
            jsonObjectE = null;
        }
        if (jsonObjectE == null || jsonObjectE.size() == 0) {
            TmcLogger.c("Tmcintegration:PermissionConfig", "permissionConfig json object is empty");
            return;
        }
        for (String str2 : jsonObjectE.keySet()) {
            if (TextUtils.isEmpty(str2) || !(jsonObjectE.get(str2) instanceof JsonObject)) {
                TmcLogger.c("Tmcintegration:PermissionConfig", jsonObjectE.get(str2) + " is not JsonObject ");
            } else {
                JsonObject jsonObject = (JsonObject) jsonObjectE.get(str2);
                if (jsonObject == null || jsonObject.size() == 0) {
                    TmcLogger.c("Tmcintegration:PermissionConfig", jsonObjectE.get(str2) + " json object is empty ");
                } else {
                    Iterator<JsonElement> it = g.a(jsonObject, GROUPS, new JsonArray()).iterator();
                    while (it.hasNext()) {
                        String asString = it.next().getAsString();
                        b bVar = new b(str2, str2);
                        Map<String, f> map = this.f30889a.get(asString);
                        if (map == null) {
                            map = new HashMap<>();
                            this.f30889a.put(asString, map);
                        }
                        map.put(str2, bVar);
                        this.f30891c.add(str2);
                    }
                }
            }
        }
    }

    public Map<String, Map<String, f>> getGroupPermissionMap() {
        return this.f30889a;
    }

    public void initConfig() {
        if (f30888e) {
            return;
        }
        f30888e = true;
        String presetPermissionStr = ApiPermissionHelper.getPresetPermissionStr();
        long[] jArr = {System.currentTimeMillis()};
        a(presetPermissionStr);
        TmcLogger.c("Tmcintegration:PermissionConfig", "put OFFLINE config speed time:" + (System.currentTimeMillis() - jArr[0]));
        ConfigService configService = (ConfigService) a.a(ConfigService.class);
        if (configService != null) {
            String configString = configService.getConfigString(PermissionConstant.jsapiPermission, "{\"setClipboard\":{\"groups\":[\"partner\",\"external\",\"internal\"]}}");
            if (!TextUtils.isEmpty(configString)) {
                jArr[0] = System.currentTimeMillis();
                a(configString);
                TmcLogger.c("Tmcintegration:PermissionConfig", "put ONLINE config speed time:" + (System.currentTimeMillis() - jArr[0]));
            }
            TmcLogger.d("Tmcintegration:PermissionConfig", "from online config  " + configString);
        }
    }

    public boolean isNeedCheckPermission(f fVar) {
        return this.f30891c.contains(fVar.authority()) || "rpc".equalsIgnoreCase(fVar.authority());
    }
}
