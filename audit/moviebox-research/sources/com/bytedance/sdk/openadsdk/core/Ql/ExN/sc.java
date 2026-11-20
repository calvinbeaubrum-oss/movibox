package com.bytedance.sdk.openadsdk.core.Ql.ExN;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.sc.sc.sc.zY.zY;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.pFF.sc.qr;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.Ol;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.Tf;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.UFX;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.WH;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import org.json.JSONObject;
import r8.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final b f28111sc = new o8.b();

    private static void pFF(zY zYVar, Sfl sfl, AdSlot adSlot) {
        if (sc(zYVar)) {
            com.bytedance.sdk.openadsdk.SR.zY.sc("load_video_start", new com.bytedance.sdk.openadsdk.We.ExN.pFF.sc(sfl, cJ.zY(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(sfl, (String) null, -1, zYVar), new UFX(zYVar.Ql(), zYVar.WH() ? zYVar.Ol() : zYVar.zY())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pFF(zY zYVar, Sfl sfl, AdSlot adSlot, long j11) {
        if (sc(zYVar)) {
            String strZY = cJ.zY(adSlot.getDurationSlotType());
            JSONObject jSONObjectSc = com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(sfl, (String) null, -1, zYVar);
            Tf tf2 = new Tf();
            tf2.sc(zYVar.Ql());
            tf2.sc(zYVar.zY());
            tf2.pFF(j11);
            if (zYVar.Sfl() == 1) {
                tf2.zY(1L);
            } else {
                tf2.zY(0L);
            }
            com.bytedance.sdk.openadsdk.SR.zY.sc("load_video_success", new com.bytedance.sdk.openadsdk.We.ExN.pFF.sc(sfl, strZY, jSONObjectSc, tf2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pFF(zY zYVar, Sfl sfl, AdSlot adSlot, long j11, int i11, String str) {
        if (sc(zYVar)) {
            String strZY = cJ.zY(adSlot.getDurationSlotType());
            JSONObject jSONObjectSc = com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(sfl, (String) null, -1, zYVar);
            WH wh2 = new WH();
            wh2.sc(zYVar.Ql());
            wh2.sc(zYVar.zY());
            wh2.pFF(j11);
            wh2.sc(i11);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            wh2.pFF(str);
            wh2.zY("");
            com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc((com.bytedance.sdk.openadsdk.We.ExN.pFF.sc<WH>) new com.bytedance.sdk.openadsdk.We.ExN.pFF.sc(sfl, strZY, jSONObjectSc, wh2));
        }
    }

    public static void sc(final zY zYVar, final b.a aVar) {
        Sfl sfl;
        AdSlot adSlot;
        if ((zYVar.zY() > 0 || zYVar.WH()) && zYVar.BT() != -2) {
            if (zYVar.BT() != 1) {
                zYVar.We(6000);
                zYVar.ExN(6000);
                zYVar.TRI(6000);
                boolean z11 = zYVar.ExN("material_meta") != null && (zYVar.ExN("material_meta") instanceof Sfl);
                boolean z12 = zYVar.ExN("ad_slot") != null && (zYVar.ExN("ad_slot") instanceof AdSlot);
                if (z11 && z12) {
                    sfl = (Sfl) zYVar.ExN("material_meta");
                    AdSlot adSlot2 = (AdSlot) zYVar.ExN("ad_slot");
                    pFF(zYVar, sfl, adSlot2);
                    adSlot = adSlot2;
                } else {
                    sfl = null;
                    adSlot = null;
                }
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                final Sfl sfl2 = sfl;
                final AdSlot adSlot3 = adSlot;
                final b.a aVar2 = new b.a() { // from class: com.bytedance.sdk.openadsdk.core.Ql.ExN.sc.1
                    @Override // r8.b.a
                    public void pFF(zY zYVar2, int i11) {
                        AdSlot adSlot4;
                        b.a aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.sc(zYVar2, i11);
                        }
                        Sfl sfl3 = sfl2;
                        if (sfl3 != null && (adSlot4 = adSlot3) != null) {
                            sc.zY(zYVar, sfl3, adSlot4);
                        }
                        zYVar.SR();
                    }

                    @Override // r8.b.a
                    public void sc(zY zYVar2, int i11) {
                        b.a aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.sc(zYVar2, i11);
                        }
                        if (sfl2 == null || adSlot3 == null) {
                            return;
                        }
                        sc.pFF(zYVar, sfl2, adSlot3, SystemClock.elapsedRealtime() - jElapsedRealtime);
                    }

                    @Override // r8.b.a
                    public void sc(zY zYVar2, int i11, String str) {
                        b.a aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.sc(zYVar2, i11, str);
                        }
                        if (sfl2 == null || adSlot3 == null) {
                            return;
                        }
                        sc.pFF(zYVar, sfl2, adSlot3, SystemClock.elapsedRealtime() - jElapsedRealtime, i11, str);
                    }
                };
                if (sc(zYVar.Ql())) {
                    Qj qj2 = new Qj("VideoPreload") { // from class: com.bytedance.sdk.openadsdk.core.Ql.ExN.sc.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT < 23) {
                                if (sc.sc()) {
                                    com.bykv.vk.openvk.sc.sc.pFF.pFF.TRI.sc.c().d(zYVar);
                                }
                            } else {
                                try {
                                    sc.f28111sc.a(Xc.sc(), zYVar, aVar2);
                                } catch (Throwable th2) {
                                    th2.getMessage();
                                }
                            }
                        }
                    };
                    if (Cb.ExN()) {
                        Cb.pFF(qj2);
                        return;
                    } else {
                        qj2.run();
                        return;
                    }
                }
                if (aVar != null) {
                    aVar.sc(zYVar, 404, "unexpected url: " + zYVar.Ql());
                }
                pFF(zYVar, sfl, adSlot, SystemClock.elapsedRealtime() - jElapsedRealtime, -1, "video url is invalid");
                return;
            }
        }
        if (aVar != null) {
            aVar.sc(zYVar, 100);
        }
    }

    public static boolean sc() {
        return com.bytedance.sdk.openadsdk.YIK.sc.sc("video_lower_support_discard", 0) == 0;
    }

    private static boolean sc(zY zYVar) {
        return Build.VERSION.SDK_INT >= 23 || zYVar.BT() != 0;
    }

    public static boolean sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.regionMatches(true, 0, "ws:", 0, 3)) {
            str = "http:" + str.substring(3);
        } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
            str = "https:" + str.substring(4);
        }
        return qr.zY(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zY(zY zYVar, Sfl sfl, AdSlot adSlot) {
        if (sc(zYVar)) {
            com.bytedance.sdk.openadsdk.We.ExN.sc.sc.pFF((com.bytedance.sdk.openadsdk.We.ExN.pFF.sc<Ol>) new com.bytedance.sdk.openadsdk.We.ExN.pFF.sc(sfl, cJ.zY(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(sfl, (String) null, -1, zYVar), new Ol(zYVar.Ql(), zYVar.zY())));
        }
    }
}
