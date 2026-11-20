package com.mbridge.msdk.video.module.a.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class i extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.mbridge.msdk.video.module.a.a f48022b;

    public i(com.mbridge.msdk.video.module.a.a aVar) {
        this.f48022b = aVar;
    }

    @Override // com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public void a(int i11, Object obj) {
        super.a(i11, obj);
        com.mbridge.msdk.video.module.a.a aVar = this.f48022b;
        if (aVar != null) {
            aVar.a(i11, obj);
        }
    }
}
