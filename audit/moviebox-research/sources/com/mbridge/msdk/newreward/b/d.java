package com.mbridge.msdk.newreward.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.a.f;
import com.mbridge.msdk.newreward.function.common.MBridgeDailyPlayModel;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends a implements RewardVideoListener, c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    RewardVideoListener f46129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f46130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f46131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f46132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f46133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f46134i;

    public d(int i11, String str, String str2, boolean z11) {
        super(i11, str, str2, z11);
        this.f46130e = 2;
        this.f46131f = false;
        if (i11 == 287) {
            this.f46130e = com.mbridge.msdk.foundation.same.a.W;
        } else {
            this.f46130e = com.mbridge.msdk.foundation.same.a.V;
        }
    }

    @Override // com.mbridge.msdk.newreward.b.a
    public final void a() {
        this.f46120b.a(this.f46119a, this.f46121c);
    }

    public final void a(int i11) {
        this.f46130e = i11;
        com.mbridge.msdk.newreward.a.c cVar = this.f46120b;
        if (cVar != null) {
            Iterator<e> it = cVar.a().iterator();
            while (it.hasNext()) {
                it.next().d(i11);
            }
        }
    }

    public final void a(int i11, int i12, int i13) {
        this.f46132g = i11;
        this.f46133h = i12;
        if (i12 == com.mbridge.msdk.foundation.same.a.J) {
            this.f46134i = i13 < 0 ? 5 : i13;
        }
        if (i12 == com.mbridge.msdk.foundation.same.a.I) {
            this.f46134i = i13 < 0 ? 80 : i13;
        }
        com.mbridge.msdk.newreward.function.h.a.a(this.f46121c.c(), i11, i12, i13);
    }

    @Override // com.mbridge.msdk.newreward.b.c
    public final void a(RewardVideoListener rewardVideoListener) {
        this.f46129d = rewardVideoListener;
        this.f46120b.a(this);
    }

    @Override // com.mbridge.msdk.newreward.b.c
    public final void a(String str) {
        this.f46120b.c();
    }

    public final void a(boolean z11) {
        this.f46131f = z11;
    }

    @Override // com.mbridge.msdk.newreward.b.c
    public final void a(boolean z11, String str) {
        f fVar = new f(this.f46119a);
        e eVar = new e(z11, this.f46121c.e(), str, this.f46121c.c(), this.f46121c.f());
        eVar.c(this.f46121c.d());
        eVar.d(this.f46130e);
        eVar.b(com.mbridge.msdk.foundation.controller.c.m().k());
        eVar.c(this.f46121c.f() ? 2 : 1);
        eVar.d(com.mbridge.msdk.newreward.function.h.b.a(str));
        eVar.a(this.f46131f);
        eVar.a(this.f46132g, this.f46133h, this.f46134i);
        this.f46120b.a(eVar, fVar);
    }

    @Override // com.mbridge.msdk.newreward.b.c
    public final boolean b() {
        return this.f46120b.d();
    }

    public final String c() {
        e eVarB;
        com.mbridge.msdk.newreward.function.f.a aVarV;
        com.mbridge.msdk.newreward.function.d.a.b bVarB;
        com.mbridge.msdk.newreward.a.c cVar = this.f46120b;
        if (cVar == null || (eVarB = cVar.b()) == null || (aVarV = eVarB.v()) == null || (bVarB = aVarV.b()) == null) {
            return "";
        }
        String strD = bVarB.d();
        return TextUtils.isEmpty(strD) ? "" : strD;
    }

    public final String d() {
        e eVarB;
        com.mbridge.msdk.newreward.function.f.a aVarV;
        com.mbridge.msdk.newreward.function.d.a.b bVarB;
        com.mbridge.msdk.newreward.a.c cVar = this.f46120b;
        return (cVar == null || (eVarB = cVar.b()) == null || (aVarV = eVarB.v()) == null || (bVarB = aVarV.b()) == null) ? "" : com.mbridge.msdk.foundation.same.b.a(bVarB.C());
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        RewardVideoListener rewardVideoListener = this.f46129d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onAdClose(mBridgeIds, rewardInfo);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onAdCloseWithIVReward(MBridgeIds mBridgeIds, boolean z11, int i11) {
        RewardVideoListener rewardVideoListener = this.f46129d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onAdCloseWithIVReward(mBridgeIds, z11, i11);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onAdShow(MBridgeIds mBridgeIds) {
        try {
            ((MBridgeDailyPlayModel) this.f46119a.a((Object) null, com.mbridge.msdk.newreward.function.c.e.CREATE_DAILY)).insertDailyCap();
        } catch (Exception e11) {
            ad.b("RewardVideoController", "updateDailyShowCap error:" + e11.getMessage());
        }
        RewardVideoListener rewardVideoListener = this.f46129d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onAdShow(mBridgeIds);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onEndcardShow(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f46129d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onEndcardShow(mBridgeIds);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onLoadSuccess(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f46129d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onLoadSuccess(mBridgeIds);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onShowFail(MBridgeIds mBridgeIds, String str) {
        RewardVideoListener rewardVideoListener = this.f46129d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onShowFail(mBridgeIds, str);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onVideoAdClicked(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f46129d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoAdClicked(mBridgeIds);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onVideoComplete(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f46129d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoComplete(mBridgeIds);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
        RewardVideoListener rewardVideoListener = this.f46129d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoLoadFail(mBridgeIds, str);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f46129d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoLoadSuccess(mBridgeIds);
        }
    }
}
