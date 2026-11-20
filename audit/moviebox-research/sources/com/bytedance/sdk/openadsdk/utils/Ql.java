package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ql implements com.bytedance.sdk.openadsdk.oem.sc {
    private static com.bytedance.sdk.openadsdk.component.reward.sc.sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final Ql f28739sc = new Ql();
    private static boolean zY;

    public static void pFF() {
        zY = true;
    }

    public static void sc() {
        if (pFF == null) {
            return;
        }
        pFF = null;
        IPMiBroadcastReceiver iPMiBroadcastReceiverSc = IPMiBroadcastReceiver.sc(com.bytedance.sdk.openadsdk.core.Xc.sc());
        if (iPMiBroadcastReceiverSc != null) {
            iPMiBroadcastReceiverSc.sc();
        }
        zY = false;
    }

    public static void sc(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        com.bytedance.sdk.openadsdk.core.model.uEA ueaAf = scVar.pFF.Af();
        if (ueaAf == null || !ueaAf.sc()) {
            return;
        }
        pFF = scVar;
        IPMiBroadcastReceiver iPMiBroadcastReceiverSc = IPMiBroadcastReceiver.sc(scVar.f27911pc);
        if (iPMiBroadcastReceiverSc != null) {
            iPMiBroadcastReceiverSc.sc(f28739sc);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.oem.sc
    public void sc(String str, final int i11) {
        com.bytedance.sdk.openadsdk.core.model.zY zYVarNP;
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = pFF;
        if (scVar == null || (zYVarNP = scVar.pFF.NP()) == null) {
            return;
        }
        String strZY = zYVarNP.zY();
        if (TextUtils.isEmpty(strZY) || !strZY.equals(str)) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.Ql.1
            @Override // java.lang.Runnable
            public void run() {
                int i12;
                if (Ql.pFF == null || (i12 = i11) <= 0 || i12 > 5) {
                    return;
                }
                boolean z11 = i12 == 1;
                if (Ql.zY) {
                    Ql.pFF.qKn.We();
                    HashMap map = new HashMap();
                    map.put("click_scence", 4);
                    com.bytedance.sdk.openadsdk.We.zY.sc("click", Ql.pFF.pFF, new com.bytedance.sdk.openadsdk.core.model.WH.sc().sc(), Ql.pFF.ExN, true, (Map<String, Object>) map, 1);
                } else if (!z11) {
                    return;
                }
                Ql.sc();
            }
        });
    }
}
