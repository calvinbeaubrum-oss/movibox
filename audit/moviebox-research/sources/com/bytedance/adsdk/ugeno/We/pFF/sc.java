package com.bytedance.adsdk.ugeno.We.pFF;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final HashSet<String> f26375sc = new HashSet<>(Arrays.asList("convert", "dislike", "openAppPermission", "openAppPolicy", "openPrivacy", "openAppFunction", CampaignEx.JSON_NATIVE_VIDEO_CLOSE, "skip", "videoControl", "pauseVideo", "resumeVideo", "muteVideo", "preventEvent"));
    protected String ExN;
    protected Map<String, String> TRI;
    protected String We;
    protected com.bytedance.adsdk.ugeno.We.pFF.sc pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected String f26376qr;
    protected com.bytedance.adsdk.ugeno.pFF.zY zY;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.We.pFF.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0229sc {
        public static sc sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar, String str, com.bytedance.adsdk.ugeno.We.pFF.sc scVar) {
            if (scVar == null) {
                return null;
            }
            String strPFF = scVar.pFF();
            if (sc.f26375sc.contains(strPFF)) {
                return new zY(zYVar, str, scVar);
            }
            strPFF.hashCode();
            if (strPFF.equals("update")) {
                return new We(zYVar, str, scVar);
            }
            if (strPFF.equals("emit")) {
                return new pFF(zYVar, str, scVar);
            }
            return null;
        }
    }

    public sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar, String str, com.bytedance.adsdk.ugeno.We.pFF.sc scVar) {
        this.zY = zYVar;
        this.pFF = scVar;
        this.f26376qr = str;
        pFF();
    }

    private void pFF() {
        com.bytedance.adsdk.ugeno.We.pFF.sc scVar = this.pFF;
        if (scVar == null) {
            return;
        }
        this.We = scVar.sc();
        this.ExN = this.pFF.pFF();
        this.TRI = this.pFF.zY();
    }

    public abstract void sc();
}
