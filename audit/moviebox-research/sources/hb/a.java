package hb;

import ac.b;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.bridge.model.ProtocolData;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType;
import com.cloud.tmc.miniutils.util.k;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static void a(i iVar, String str, JsonObject jsonObject) {
        TmcLogger.c("subPkg", "dispatchEventToRender recive");
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("eventName", str);
        jsonObject2.addProperty("dataJson", k.j(jsonObject));
        JsonObject asJsonObject = JsonParser.parseString(new Gson().toJson(new ProtocolData("DispatchEvent", "render", "native", System.currentTimeMillis(), "", jsonObject2))).getAsJsonObject();
        if (iVar == null) {
            TmcLogger.c("subPkg", "dispatchEventToRender recive render is null");
            return;
        }
        TmcLogger.c("subPkg", "dispatchEventToRender recive render un null");
        Node nodeI = iVar.i();
        App app = nodeI instanceof Page ? ((Page) nodeI).getApp() : null;
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app == null ? null : app.getAppId(), RenderAnalyseType.LOAD_URL, k.j(asJsonObject));
        b.a aVarI = b.b(iVar).g("message").j(NotificationCompat.CATEGORY_CALL).i(asJsonObject);
        if (iVar.getRenderBridge() == null) {
            TmcLogger.c("subPkg", "dispatchEventToRender recive getRenderBridge is null");
        } else {
            TmcLogger.c("subPkg", "dispatchEventToRender recive getRenderBridge un null");
            iVar.getRenderBridge().a(aVarI.h(), null);
        }
    }

    public static void b(gd.b bVar, String str, JsonObject jsonObject) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap map2 = new HashMap();
        JsonObject jsonObject2 = new JsonObject();
        map2.put("eventName", str);
        jsonObject2.addProperty("eventName", str);
        map2.put("dataJson", k.j(jsonObject));
        jsonObject2.addProperty("dataJson", k.j(jsonObject));
        map.put("abilityName", "DispatchEvent");
        map.put("target", "worker");
        map.put("source", "native");
        map.put("time", Long.valueOf(System.currentTimeMillis()));
        map.put("callbackId", "");
        map.put("dataJson", map2);
        ProtocolData protocolData = new ProtocolData("DispatchEvent", "worker", "native", System.currentTimeMillis(), "", jsonObject2);
        if (jsonObject != null && jsonObject.has("renderId")) {
            map.put("renderId", jsonObject.get("renderId").getAsString());
            protocolData.setRenderId(jsonObject.get("renderId").getAsString());
        }
        JsonObject asJsonObject = JsonParser.parseString(new Gson().toJson(protocolData)).getAsJsonObject();
        if (bVar == null) {
            return;
        }
        if (bVar.workerType() == 1) {
            bVar.j(map, null);
        } else if (bVar.workerType() == 3) {
            bVar.k(asJsonObject, null);
        }
    }

    public static void c(gd.b bVar, String str, JsonObject jsonObject) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap map2 = new HashMap();
        JsonObject jsonObject2 = new JsonObject();
        map2.put("eventName", str);
        jsonObject2.addProperty("eventName", str);
        map2.put("dataJson", k.j(jsonObject));
        jsonObject2.addProperty("dataJson", k.j(jsonObject));
        map.put("abilityName", "Lifecycle");
        map.put("target", "worker");
        map.put("source", "native");
        map.put("time", Long.valueOf(System.currentTimeMillis()));
        map.put("callbackId", "");
        map.put("dataJson", map2);
        ProtocolData protocolData = new ProtocolData("Lifecycle", "worker", "native", System.currentTimeMillis(), "", jsonObject2);
        if (jsonObject != null && jsonObject.has("renderId")) {
            map.put("renderId", jsonObject.get("renderId").getAsString());
            protocolData.setRenderId(jsonObject.get("renderId").getAsString());
        }
        JsonObject asJsonObject = JsonParser.parseString(new Gson().toJson(protocolData)).getAsJsonObject();
        if (bVar == null) {
            return;
        }
        if (bVar.workerType() == 1) {
            bVar.j(map, null);
        } else if (bVar.workerType() == 3) {
            bVar.k(asJsonObject, null);
        }
    }
}
