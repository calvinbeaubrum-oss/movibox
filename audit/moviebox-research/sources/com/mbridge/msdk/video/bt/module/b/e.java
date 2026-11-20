package com.mbridge.msdk.video.bt.module.b;

import com.mbridge.msdk.video.bt.module.MBTempContainer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends MBTempContainer.a.C0523a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f47523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.d.b f47524b;

    public e(com.mbridge.msdk.foundation.same.report.d.b bVar, h hVar) {
        this.f47523a = hVar;
        this.f47524b = bVar;
    }

    @Override // com.mbridge.msdk.video.bt.module.MBTempContainer.a.C0523a, com.mbridge.msdk.video.bt.module.MBTempContainer.a
    public final void a(String str) {
        super.a(str);
        h hVar = this.f47523a;
        if (hVar != null) {
            hVar.a(this.f47524b, str);
        }
    }
}
