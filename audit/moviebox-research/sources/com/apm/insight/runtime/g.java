package com.apm.insight.runtime;

import android.content.Context;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.hisavana.common.constant.ComConstants;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f17074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, Long> f17075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f17077d;

    public g(Context context) {
        this.f17075b = null;
        this.f17076c = 50;
        this.f17077d = 100;
        this.f17074a = context;
        this.f17075b = b();
        this.f17076c = a.a(this.f17076c, "custom_event_settings", "npth_simple_setting", "crash_limit_issue");
        this.f17077d = a.a(this.f17077d, "custom_event_settings", "npth_simple_setting", "crash_limit_all");
    }

    private HashMap<String, Long> b() {
        File fileH = com.apm.insight.l.j.h(this.f17074a);
        HashMap<String, Long> map = new HashMap<>();
        map.put("time", Long.valueOf(System.currentTimeMillis()));
        try {
            JSONArray jSONArrayA = com.apm.insight.l.f.a(fileH.getAbsolutePath());
            if (com.apm.insight.a.a(jSONArrayA)) {
                return map;
            }
            Long lDecode = Long.decode(jSONArrayA.optString(0, null));
            if (System.currentTimeMillis() - lDecode.longValue() > ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
                File fileG = com.apm.insight.l.j.g(this.f17074a);
                fileH.renameTo(new File(fileG, String.valueOf(System.currentTimeMillis())));
                String[] list = fileG.list();
                if (list != null && list.length > 5) {
                    Arrays.sort(list);
                    new File(fileG, list[0]).delete();
                }
                return map;
            }
            map.put("time", lDecode);
            for (int i11 = 1; i11 < jSONArrayA.length(); i11++) {
                String[] strArrSplit = jSONArrayA.optString(i11, "").split(" ");
                if (strArrSplit.length == 2) {
                    map.put(strArrSplit[0], Long.decode(strArrSplit[1]));
                }
            }
            return map;
        } catch (IOException unused) {
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            k.a(th2, "NPTH_CATCH");
        }
    }

    public final void a() throws Throwable {
        HashMap<String, Long> map = this.f17075b;
        Long lRemove = map.remove("time");
        if (lRemove == null) {
            com.apm.insight.c.a();
            k.a(new RuntimeException("err times, no time"), "NPTH_CATCH");
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(lRemove);
        sb2.append('\n');
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append(' ');
            sb2.append(entry.getValue());
            sb2.append('\n');
        }
        try {
            com.apm.insight.l.f.a(com.apm.insight.l.j.h(this.f17074a), sb2.toString(), false);
        } catch (IOException unused) {
        }
    }

    public final boolean a(String str) {
        if (str == null) {
            str = TmcEngineFactory.ENGINE_TYPE_DEFAULT;
        }
        return com.apm.insight.l.c.AnonymousClass1.a(this.f17075b, str, 1L).longValue() < ((long) this.f17076c) && com.apm.insight.l.c.AnonymousClass1.a(this.f17075b, "all", 1L).longValue() < ((long) this.f17077d);
    }
}
