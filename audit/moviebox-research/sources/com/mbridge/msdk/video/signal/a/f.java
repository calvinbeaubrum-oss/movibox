package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.video.module.MBridgeVideoView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class f implements com.mbridge.msdk.video.signal.g {
    @Override // com.mbridge.msdk.video.signal.g
    public void a(int i11) {
        ad.a("DefaultJSNotifyProxy", "onVideoStatusNotify:" + i11);
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(int i11, int i12, int i13, int i14) {
        ad.a("DefaultJSNotifyProxy", "showDataInfo");
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(int i11, String str) {
        ad.a("DefaultJSNotifyProxy", "onClick:" + i11 + ",pt:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(MBridgeVideoView.b bVar) {
        ad.a("DefaultJSNotifyProxy", "onProgressNotify:" + bVar.toString());
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(Object obj) {
        ad.a("DefaultJSNotifyProxy", "onWebviewShow:" + obj);
    }
}
