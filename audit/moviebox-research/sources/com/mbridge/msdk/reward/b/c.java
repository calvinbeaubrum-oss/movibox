package com.mbridge.msdk.reward.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f46873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f46874b;

    public c(Context context, String str) {
        this.f46873a = context;
        this.f46874b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA;
        if (this.f46873a == null || TextUtils.isEmpty(this.f46874b)) {
            return;
        }
        try {
            com.mbridge.msdk.reward.c.a.a(this.f46873a, this.f46874b);
            ab.a();
            ab.a(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES));
            ab.a(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML));
            com.mbridge.msdk.videocommon.d.b.a().c(this.f46874b);
            if (af.a().a("c_d_v_w_i", false) || TextUtils.isEmpty(this.f46874b) || (copyOnWriteArrayListA = com.mbridge.msdk.videocommon.a.a.a().a(this.f46874b, 1)) == null || copyOnWriteArrayListA.size() <= 0) {
                return;
            }
            com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(this.f46873a, this.f46874b, copyOnWriteArrayListA, 94, (com.mbridge.msdk.videocommon.listener.a) null);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("RewardVideoControllerInitTask", "initRewardVideoController task ", e11);
            }
        }
    }
}
