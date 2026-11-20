package com.mbridge.msdk.foundation.same.report.d;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f44850a = new HashMap();

    public final Map<String, String> a() {
        return this.f44850a;
    }

    public final void a(d dVar) {
        Map<String, String> map;
        Map<String, String> map2;
        if (dVar == null || (map = dVar.f44850a) == null || (map2 = this.f44850a) == null) {
            return;
        }
        map2.putAll(map);
    }

    public final void a(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            if (!(obj instanceof String)) {
                this.f44850a.put(str, obj + "");
            } else if (!TextUtils.isEmpty((String) obj)) {
                this.f44850a.put(str, (String) obj);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(Map map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.f44850a.putAll(map);
    }

    public final boolean a(String str) {
        return this.f44850a.containsKey(str);
    }

    public final Object b(String str) {
        return this.f44850a.get(str);
    }

    public final void c(String str) {
        if (this.f44850a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f44850a.remove(str);
    }
}
