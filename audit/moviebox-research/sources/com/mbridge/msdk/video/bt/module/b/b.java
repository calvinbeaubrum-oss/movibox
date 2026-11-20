package com.mbridge.msdk.video.bt.module.b;

import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f47510b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f47511c = false;

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void a(int i11, String str, String str2) {
        ad.a("ShowRewardListener", "onAutoLoad: " + str2);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void a(com.mbridge.msdk.foundation.same.report.d.b bVar) {
        ad.a("ShowRewardListener", "onAdShow");
    }

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void a(com.mbridge.msdk.foundation.same.report.d.b bVar, String str) {
        ad.a("ShowRewardListener", "onShowFail:" + str);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void a(com.mbridge.msdk.foundation.same.report.d.b bVar, boolean z11, com.mbridge.msdk.videocommon.b.c cVar) {
        ad.a("ShowRewardListener", "onAdClose:isCompleteView:" + z11 + ",reward:" + cVar);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void a(String str, String str2) {
        ad.a("ShowRewardListener", "onVideoComplete: " + str2);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void a(boolean z11, int i11) {
        ad.a("ShowRewardListener", "onAdCloseWithIVReward: " + z11 + "  " + i11);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void a(boolean z11, String str, String str2) {
        ad.a("ShowRewardListener", "onVideoAdClicked:" + str2);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void b(String str, String str2) {
        ad.a("ShowRewardListener", "onEndcardShow: " + str2);
    }
}
