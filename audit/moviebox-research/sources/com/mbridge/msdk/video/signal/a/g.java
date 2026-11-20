package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class g implements com.mbridge.msdk.video.signal.i {
    @Override // com.mbridge.msdk.video.signal.i
    public String a() {
        ad.a("js", "getEndScreenInfo");
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.i
    public void a(String str) {
        ad.a("js", "triggerCloseBtn,state=" + str);
    }

    @Override // com.mbridge.msdk.video.signal.i
    public void b(String str) {
        ad.a("js", "setOrientation,landscape=" + str);
    }

    @Override // com.mbridge.msdk.video.signal.i
    public void c(String str) {
        ad.a("js", "handlerPlayableException，msg=" + str);
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void notifyCloseBtn(int i11) {
        ad.a("js", "notifyCloseBtn,state=" + i11);
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void toggleCloseBtn(int i11) {
        ad.a("js", "toggleCloseBtn,state=" + i11);
    }
}
