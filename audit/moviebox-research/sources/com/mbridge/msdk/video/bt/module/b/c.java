package com.mbridge.msdk.video.bt.module.b;

import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.video.bt.module.a.b f47512a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f47513d;

    public c(com.mbridge.msdk.video.bt.module.a.b bVar, String str) {
        this.f47512a = bVar;
        this.f47513d = str;
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(int i11, String str, String str2) {
        if (this.f47512a != null) {
            ad.a("H5ShowRewardListener", "onAutoLoad");
            this.f47512a.a(this.f47513d, i11, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar) {
        if (this.f47512a != null) {
            ad.a("H5ShowRewardListener", "onAdShow");
            this.f47512a.a(this.f47513d);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar, String str) {
        if (this.f47512a != null) {
            ad.a("H5ShowRewardListener", "onShowFail");
            this.f47512a.a(this.f47513d, str);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar, boolean z11, com.mbridge.msdk.videocommon.b.c cVar) {
        if (this.f47512a != null) {
            ad.a("H5ShowRewardListener", "onAdClose");
            this.f47512a.a(this.f47513d, z11, cVar);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(String str, String str2) {
        if (this.f47512a != null) {
            ad.a("H5ShowRewardListener", "onVideoComplete");
            this.f47512a.b(this.f47513d, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(boolean z11, String str, String str2) {
        if (this.f47512a != null) {
            ad.a("H5ShowRewardListener", "onVideoAdClicked");
            this.f47512a.a(this.f47513d, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void b(String str, String str2) {
        if (this.f47512a != null) {
            ad.a("H5ShowRewardListener", "onEndcardShow");
            this.f47512a.c(this.f47513d, str, str2);
        }
    }
}
