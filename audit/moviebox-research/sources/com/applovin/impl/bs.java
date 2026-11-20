package com.applovin.impl;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.drm.WidevineUtil;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class bs {
    private static long a(Map map, String str) {
        if (map == null) {
            return C.TIME_UNSET;
        }
        try {
            String str2 = (String) map.get(str);
            return str2 != null ? Long.parseLong(str2) : C.TIME_UNSET;
        } catch (NumberFormatException unused) {
            return C.TIME_UNSET;
        }
    }

    public static Pair a(z6 z6Var) {
        Map mapD = z6Var.d();
        if (mapD == null) {
            return null;
        }
        return new Pair(Long.valueOf(a(mapD, WidevineUtil.PROPERTY_LICENSE_DURATION_REMAINING)), Long.valueOf(a(mapD, WidevineUtil.PROPERTY_PLAYBACK_DURATION_REMAINING)));
    }
}
