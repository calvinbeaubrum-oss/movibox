package com.mbridge.msdk.videocommon.download;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f48557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f48558b;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f48559a = new h();
    }

    private h() {
    }

    public static h a() {
        return a.f48559a;
    }

    public final int a(String str, int i11) {
        try {
            return af.a().a(str, i11);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardVideoRefactorManager", "getRewardVideoCampaignRequestTimeout error: " + e11.getMessage());
            }
            return i11;
        }
    }

    public final boolean a(int i11) {
        if (MBridgeConstans.DEBUG) {
            ad.c("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i11 + ", key: REWARD_VIDEO_REFACTOR_FOR_LOAD");
        }
        if (i11 != 94 && i11 != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.f48557a;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.f48557a = new AtomicBoolean(af.a().a("r_v_r_f_l", false));
        } catch (Exception e11) {
            this.f48557a = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardVideoRefactorManager", "isRewardVideoRefactor error: " + e11.getMessage());
            }
        }
        return this.f48557a.get();
    }

    public final boolean b(int i11) {
        if (MBridgeConstans.DEBUG) {
            ad.c("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i11 + ", key: REWARD_VIDEO_REFACTOR_FOR_CAMPAIGN_REQUEST");
        }
        if (i11 != 94 && i11 != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.f48558b;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.f48558b = new AtomicBoolean(af.a().a("r_v_r_f_c_r", false));
        } catch (Exception e11) {
            this.f48558b = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardVideoRefactorManager", "isRewardVideoRefactor error: " + e11.getMessage());
            }
        }
        return this.f48558b.get();
    }
}
