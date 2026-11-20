package com.mbridge.msdk.newreward.function.c.b.a;

import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.newreward.function.common.MBridgeDailyPlayModel;
import com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements com.mbridge.msdk.newreward.function.c.b.b {
    private boolean a(String str, com.mbridge.msdk.newreward.function.c.d dVar, Map map) {
        if (map.get(str) == null) {
            return false;
        }
        dVar.a(map.get(str));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    @Override // com.mbridge.msdk.newreward.function.c.b.b
    public final void a(Object obj) {
        byte b11;
        try {
            Map map = (Map) obj;
            com.mbridge.msdk.newreward.function.c.d dVar = (com.mbridge.msdk.newreward.function.c.d) map.get("result");
            Map map2 = (Map) map.get("obj_map");
            String str = (String) map.get("type");
            int iHashCode = str.hashCode();
            if (iHashCode != -2057274110) {
                if (iHashCode != -1019779949) {
                    if (iHashCode == 95346201 && str.equals("daily")) {
                        b11 = 0;
                    } else {
                        b11 = -1;
                    }
                } else if (str.equals("offset")) {
                    b11 = 1;
                } else {
                    b11 = -1;
                }
            } else if (str.equals("bridge_ids")) {
                b11 = 2;
            } else {
                b11 = -1;
            }
            if (b11 == 0) {
                if (a("daily", dVar, map2)) {
                    return;
                }
                MBridgeDailyPlayModel mBridgeDailyPlayModel = new MBridgeDailyPlayModel(((Integer) map.get("mb_ad_type")).intValue(), (String) map.get("mb_ad_pid"), (String) map.get("mb_ad_unit_id"));
                map2.put("daily", mBridgeDailyPlayModel);
                dVar.a(mBridgeDailyPlayModel);
                return;
            }
            if (b11 == 1) {
                if (a("offset", dVar, map2)) {
                    return;
                }
                MBridgeOffsetManager mBridgeOffsetManager = new MBridgeOffsetManager();
                map2.put("offset", mBridgeOffsetManager);
                dVar.a(mBridgeOffsetManager);
                return;
            }
            if (b11 == 2 && !a("bridge_ids", dVar, map2)) {
                MBridgeIds mBridgeIds = new MBridgeIds((String) map.get("mb_ad_pid"), (String) map.get("mb_ad_unit_id"));
                map2.put("bridge_ids", mBridgeIds);
                dVar.a(mBridgeIds);
            }
        } catch (Exception e11) {
            ad.a("CreateObjectReceiver", "action", e11);
        }
    }
}
