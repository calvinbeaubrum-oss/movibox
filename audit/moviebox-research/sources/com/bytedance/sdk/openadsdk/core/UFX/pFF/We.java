package com.bytedance.sdk.openadsdk.core.UFX.pFF;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We extends com.bytedance.adsdk.ugeno.Ol.zY.sc {
    public We(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.Ol.zY.sc
    public String qr(String str) {
        str.hashCode();
        switch (str) {
            case "unmuted":
                return "tt_reward_full_unmute";
            case "feedback":
                return "tt_reward_full_feedback";
            case "right_arrow":
                return "tt_skip_btn";
            case "logo":
                return "tt_ad_logo";
            case "close":
                return "tt_close_btn";
            case "muted":
                return "tt_reward_full_mute";
            default:
                return null;
        }
    }
}
