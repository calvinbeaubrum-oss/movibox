package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class BT {
    public static boolean ExN(Context context) {
        return zY(context) == 5;
    }

    public static boolean Qj(Context context) {
        if (context == null) {
            return false;
        }
        int iZY = zY(context);
        return iZY == 2 || iZY == 3 || iZY == 4 || iZY == 5 || iZY == 6;
    }

    public static boolean TRI(Context context) {
        return zY(context) == 6;
    }

    public static boolean We(Context context) {
        return zY(context) == 4;
    }

    public static int pFF(Context context) {
        int iZY = zY(context);
        if (iZY == 1) {
            return 0;
        }
        if (iZY == 4) {
            return 1;
        }
        if (iZY == 5) {
            return 4;
        }
        if (iZY != 6) {
            return iZY;
        }
        return 6;
    }

    public static String qr(Context context) {
        int iZY = zY(context);
        if (iZY == 2) {
            return "2g";
        }
        if (iZY == 3) {
            return "3g";
        }
        if (iZY == 4) {
            return "wifi";
        }
        if (iZY != 5) {
            return iZY != 6 ? "mobile" : "5g";
        }
        return "4g";
    }

    public static boolean sc(Context context) {
        return zY(context) != 0;
    }

    public static boolean sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith(AgentPageJsBridge.HTTPS);
    }

    public static int zY(Context context) {
        return uEA.sc(context, ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
    }
}
