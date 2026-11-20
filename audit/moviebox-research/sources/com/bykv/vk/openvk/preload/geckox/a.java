package com.bykv.vk.openvk.preload.geckox;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.hisavana.common.tracking.TrackingKey;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f25678a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.falconx.a.a f25679b = new com.bykv.vk.openvk.preload.falconx.a.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Queue<String> f25680c = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f25681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f25682e;

    private a(b bVar) {
        this.f25681d = bVar;
        File fileL = bVar.l();
        this.f25682e = fileL;
        fileL.mkdirs();
        com.bykv.vk.openvk.preload.geckox.statistic.b.a(this, this.f25681d);
    }

    public static a a(b bVar) {
        List<String> listE = bVar.e();
        if (listE == null || listE.isEmpty()) {
            throw new IllegalArgumentException("access key empty");
        }
        return new a(bVar);
    }

    private boolean a() {
        List<String> listD = this.f25681d.d();
        List<String> listE = this.f25681d.e();
        if (listD == null || listD.isEmpty() || listE == null || listE.isEmpty()) {
            return false;
        }
        for (String str : listE) {
            Iterator<String> it = listD.iterator();
            boolean z11 = false;
            while (it.hasNext()) {
                if (TextUtils.equals(str, it.next())) {
                    z11 = true;
                }
            }
            if (!z11) {
                return false;
            }
        }
        return true;
    }

    private boolean b(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        if (map != null && !map.isEmpty()) {
            List<String> listE = this.f25681d.e();
            for (Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>> entry : map.entrySet()) {
                Iterator<String> it = listE.iterator();
                boolean z11 = false;
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next(), entry.getKey())) {
                        z11 = true;
                    }
                }
                if (!z11) {
                    return false;
                }
            }
        }
        return true;
    }

    public static /* synthetic */ void d(a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.f25681d.e());
        try {
            String strA = com.bykv.vk.openvk.preload.geckox.c.b.a().b().a(new com.bykv.vk.openvk.preload.geckox.a.c(arrayList));
            if (aVar.f25680c.size() < 10) {
                aVar.f25680c.add(strA);
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(Class<? extends d<?, ?>> cls, com.bykv.vk.openvk.preload.b.b.a aVar) {
        this.f25679b.a(cls, aVar);
    }

    public final void a(final Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        final String str = TmcEngineFactory.ENGINE_TYPE_DEFAULT;
        if (TextUtils.isEmpty(TmcEngineFactory.ENGINE_TYPE_DEFAULT)) {
            throw new IllegalArgumentException("groupType == null");
        }
        if (!a()) {
            throw new IllegalArgumentException("deployments keys not in local keys");
        }
        if (!b(map)) {
            throw new IllegalArgumentException("target keys not in deployments keys");
        }
        b.h().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.a.1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private /* synthetic */ com.bykv.vk.openvk.preload.geckox.e.a.a f25684b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private /* synthetic */ Map f25685c = null;

            @Override // java.lang.Runnable
            public final void run() {
                com.bykv.vk.openvk.preload.geckox.a.a.b bVarA;
                GeckoLogger.d("gecko-debug-tag", "start check update...", str);
                if (a.this.f25681d.b() != null) {
                    bVarA = a.this.f25681d.b().a();
                    bVarA.a(a.this.f25681d.b(), a.this.f25681d.l(), a.this.f25681d.e());
                } else {
                    bVarA = null;
                }
                try {
                    try {
                        a.this.f25681d.a(new JSONObject());
                        GeckoLogger.d("gecko-debug-tag", "update finished", com.bykv.vk.openvk.preload.geckox.g.a.a(a.this.f25682e, a.this.f25681d, a.this.f25679b, map, str).a(str));
                        if (bVarA != null) {
                            bVarA.a();
                        }
                        a.this.f25681d.n().upload("download_gecko_end", a.this.f25681d.f());
                        GeckoLogger.d("gecko-debug-tag", "all channel update finished");
                    } catch (Throwable th2) {
                        if (bVarA != null) {
                            bVarA.a();
                        }
                        a.this.f25681d.n().upload("download_gecko_end", a.this.f25681d.f());
                        GeckoLogger.d("gecko-debug-tag", "all channel update finished");
                        throw th2;
                    }
                } catch (Exception e11) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("success", false);
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, e11.toString());
                        jSONObject.put(TrackingKey.CODE, 2);
                        a.this.f25681d.a(jSONObject);
                    } catch (Throwable unused) {
                    }
                    GeckoLogger.w("gecko-debug-tag", "Gecko update failed:", e11);
                    if (bVarA != null) {
                        bVarA.a();
                    }
                    a.this.f25681d.n().upload("download_gecko_end", a.this.f25681d.f());
                    GeckoLogger.d("gecko-debug-tag", "all channel update finished");
                }
                a.d(a.this);
            }
        });
    }
}
