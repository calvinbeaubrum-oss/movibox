package com.bytedance.sdk.openadsdk.We.sc;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.Sfl;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.JPJ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH implements com.bytedance.sdk.component.TRI.sc.pFF.zY {
    private final zY pFF = zY.sc();

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public Sfl<com.bytedance.sdk.openadsdk.We.sc> f27393sc;

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, List<com.bytedance.sdk.component.TRI.sc.We.sc>> We(List<com.bytedance.sdk.component.TRI.sc.We.sc> list) {
        HashMap<String, List<com.bytedance.sdk.component.TRI.sc.We.sc>> map = new HashMap<>();
        new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            com.bytedance.sdk.component.TRI.sc.We.sc scVar = list.get(i11);
            JSONObject jSONObjectQr = scVar.qr();
            if (jSONObjectQr != null) {
                String strOptString = jSONObjectQr.optString("app_log_url");
                List<com.bytedance.sdk.component.TRI.sc.We.sc> arrayList = map.get(strOptString);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    map.put(strOptString, arrayList);
                }
                arrayList.add(scVar);
            }
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sc(List<com.bytedance.sdk.openadsdk.We.sc> list, com.bytedance.sdk.openadsdk.We.ExN exN) {
        int i11;
        return !zY(list) && (i11 = exN.pFF) >= 400 && i11 < 500;
    }

    private boolean zY(List<com.bytedance.sdk.openadsdk.We.sc> list) {
        JSONObject jSONObjectZY;
        if (list == null || list.size() == 0 || (jSONObjectZY = list.get(0).zY()) == null) {
            return true;
        }
        return TextUtils.isEmpty(jSONObjectZY.optString("app_log_url"));
    }

    public com.bytedance.sdk.openadsdk.We.ExN pFF(List<com.bytedance.sdk.openadsdk.SR.zY.zY.sc> list) {
        if (this.f27393sc == null) {
            this.f27393sc = Xc.zY();
        }
        if (list != null && list.size() != 0 && com.bytedance.sdk.openadsdk.core.settings.Tf.sc()) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<com.bytedance.sdk.openadsdk.SR.zY.zY.sc> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().pFF);
                }
                jSONObject.put("stats_list", jSONArray);
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j11 = jCurrentTimeMillis / 1000;
                jSONObject.put("ts", j11);
                jSONObject.put("ts_ms", jCurrentTimeMillis);
                String strWe = com.bytedance.sdk.openadsdk.core.Ol.pFF().We();
                if (strWe == null) {
                    strWe = "";
                }
                StringBuilder sb2 = new StringBuilder(JPJ.sc());
                sb2.append("-");
                sb2.append(jCurrentTimeMillis);
                jSONObject.put("req_sign", com.bytedance.sdk.component.utils.ExN.sc(strWe + j11 + BuildConfig.VERSION_NAME));
                jSONObject.put("req_uniq", com.bytedance.sdk.component.utils.ExN.sc(sb2.toString()));
                return this.f27393sc.pFF(jSONObject);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.We.ExN sc(List<com.bytedance.sdk.openadsdk.We.sc> list) {
        if (this.f27393sc == null) {
            this.f27393sc = Xc.zY();
        }
        if (this.f27393sc == null) {
            return null;
        }
        int iBSP = dE.ef().bSP();
        if (3 == iBSP) {
            return this.f27393sc.sc(this.pFF.sc(this.pFF.sc(list, false), System.currentTimeMillis(), this.pFF.pFF(), true), this.pFF.sc(list), true);
        }
        if (2 != iBSP) {
            return this.f27393sc.sc(this.pFF.sc(list, System.currentTimeMillis(), this.pFF.pFF(), false), this.pFF.sc(list), false);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObjectPFF = this.pFF.pFF();
        this.f27393sc.sc(this.pFF.sc(this.pFF.sc(list, true), jCurrentTimeMillis, jSONObjectPFF, true), this.pFF.sc(list), true);
        return this.f27393sc.sc(this.pFF.sc(this.pFF.pFF(list), jCurrentTimeMillis, jSONObjectPFF, false), this.pFF.sc(list), false);
    }

    @Override // com.bytedance.sdk.component.TRI.sc.pFF.zY
    public void sc(final List<com.bytedance.sdk.component.TRI.sc.We.sc> list, @Nullable final com.bytedance.sdk.component.TRI.sc.pFF.pFF pff) {
        com.bytedance.sdk.component.TRI.sc.We.sc scVar;
        if (list == null || list.isEmpty() || !Xc.We().Pu() || (scVar = list.get(0)) == null) {
            return;
        }
        byte bWe = scVar.We();
        final ArrayList arrayList = new ArrayList();
        if (bWe == 0) {
            com.bytedance.sdk.openadsdk.dE.zY.sc(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.We.sc.WH.1
                @Override // com.bytedance.sdk.openadsdk.dE.We
                public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                    com.bytedance.sdk.openadsdk.dE.pFF.sc scVar2 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                    scVar2.pFF("applog");
                    return scVar2;
                }
            });
            Cb.sc(new com.bytedance.sdk.component.Qj.zY.pFF(7, "upload_ad_event") { // from class: com.bytedance.sdk.openadsdk.We.sc.WH.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it;
                    try {
                        it = WH.this.We(list).entrySet().iterator();
                    } catch (Throwable th2) {
                        com.bytedance.sdk.component.utils.Tf.sc("OverSeaEventUploadImp", th2.getMessage());
                        it = null;
                    }
                    if (it == null) {
                        com.bytedance.sdk.component.TRI.sc.pFF.pFF pff2 = pff;
                        if (pff2 != null) {
                            pff2.sc(arrayList);
                            return;
                        }
                        return;
                    }
                    while (it.hasNext()) {
                        try {
                            sc.sc(sc.We);
                            List<com.bytedance.sdk.component.TRI.sc.We.sc> list2 = (List) ((Map.Entry) it.next()).getValue();
                            ArrayList arrayList2 = new ArrayList();
                            for (com.bytedance.sdk.component.TRI.sc.We.sc scVar2 : list2) {
                                arrayList2.add(new com.bytedance.sdk.openadsdk.We.sc(scVar2.zY(), scVar2.qr()));
                            }
                            com.bytedance.sdk.openadsdk.We.ExN exNSc = WH.this.sc(arrayList2);
                            if (pff != null && exNSc != null) {
                                boolean z11 = exNSc.We;
                                if (WH.this.sc(arrayList2, exNSc)) {
                                    z11 = true;
                                }
                                arrayList.add(new com.bytedance.sdk.component.TRI.sc.pFF.zY.sc(new com.bytedance.sdk.component.TRI.sc.pFF.zY.pFF(exNSc.f27303sc, exNSc.pFF, exNSc.zY, z11, ""), list2));
                                if (exNSc.pFF == 200) {
                                    sc.sc(sc.We, true);
                                    com.bytedance.sdk.openadsdk.dE.zY.pFF(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.We.sc.WH.2.1
                                        @Override // com.bytedance.sdk.openadsdk.dE.We
                                        public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                            com.bytedance.sdk.openadsdk.dE.pFF.sc scVar3 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                            scVar3.pFF("applog");
                                            return scVar3;
                                        }
                                    });
                                } else if (z11) {
                                    sc.sc(sc.We, false);
                                    com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.We.sc.WH.2.2
                                        @Override // com.bytedance.sdk.openadsdk.dE.We
                                        public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                            com.bytedance.sdk.openadsdk.dE.pFF.sc scVar3 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                            scVar3.pFF("applog");
                                            return scVar3;
                                        }
                                    });
                                } else {
                                    com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.We.sc.WH.2.3
                                        @Override // com.bytedance.sdk.openadsdk.dE.We
                                        public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                            com.bytedance.sdk.openadsdk.dE.pFF.sc scVar3 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                            scVar3.pFF("applog");
                                            return scVar3;
                                        }
                                    });
                                }
                            }
                            if (pff != null && exNSc == null) {
                                com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.We.sc.WH.2.4
                                    @Override // com.bytedance.sdk.openadsdk.dE.We
                                    public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                        com.bytedance.sdk.openadsdk.dE.pFF.sc scVar3 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                        scVar3.pFF("applog");
                                        return scVar3;
                                    }
                                });
                            }
                        } catch (Throwable th3) {
                            com.bytedance.sdk.component.utils.Tf.sc("OverSeaEventUploadImp", th3.getMessage());
                        }
                    }
                    com.bytedance.sdk.component.TRI.sc.pFF.pFF pff3 = pff;
                    if (pff3 != null) {
                        pff3.sc(arrayList);
                    }
                }
            });
            return;
        }
        if (bWe == 1) {
            final ArrayList arrayList2 = new ArrayList();
            for (com.bytedance.sdk.component.TRI.sc.We.sc scVar2 : list) {
                arrayList2.add(new com.bytedance.sdk.openadsdk.SR.zY.zY.sc(scVar2.zY(), scVar2.qr()));
            }
            sc.sc(sc.ExN);
            if (arrayList2.size() > 0) {
                com.bytedance.sdk.openadsdk.dE.zY.sc(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.We.sc.WH.3
                    @Override // com.bytedance.sdk.openadsdk.dE.We
                    public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                        com.bytedance.sdk.openadsdk.dE.pFF.sc scVar3 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                        scVar3.pFF("stats");
                        return scVar3;
                    }
                });
                Cb.sc(new com.bytedance.sdk.component.Qj.zY.pFF(6, "upload_stats_event") { // from class: com.bytedance.sdk.openadsdk.We.sc.WH.4
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.openadsdk.We.ExN exNPFF = WH.this.pFF(arrayList2);
                        if (pff != null && exNPFF != null) {
                            arrayList.add(new com.bytedance.sdk.component.TRI.sc.pFF.zY.sc(new com.bytedance.sdk.component.TRI.sc.pFF.zY.pFF(exNPFF.f27303sc, exNPFF.pFF, exNPFF.zY, exNPFF.We, ""), list));
                            pff.sc(arrayList);
                            if (exNPFF.pFF == 200) {
                                sc.sc(sc.ExN, true);
                                com.bytedance.sdk.openadsdk.dE.zY.pFF(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.We.sc.WH.4.1
                                    @Override // com.bytedance.sdk.openadsdk.dE.We
                                    public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                        com.bytedance.sdk.openadsdk.dE.pFF.sc scVar3 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                        scVar3.pFF("stats");
                                        return scVar3;
                                    }
                                });
                            } else if (exNPFF.We) {
                                sc.sc(sc.ExN, false);
                                com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.We.sc.WH.4.2
                                    @Override // com.bytedance.sdk.openadsdk.dE.We
                                    public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                        com.bytedance.sdk.openadsdk.dE.pFF.sc scVar3 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                        scVar3.pFF("stats");
                                        return scVar3;
                                    }
                                });
                            } else {
                                com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.We.sc.WH.4.3
                                    @Override // com.bytedance.sdk.openadsdk.dE.We
                                    public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                        com.bytedance.sdk.openadsdk.dE.pFF.sc scVar3 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                        scVar3.pFF("stats");
                                        return scVar3;
                                    }
                                });
                            }
                        }
                        if (pff == null || exNPFF != null) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.We.sc.WH.4.4
                            @Override // com.bytedance.sdk.openadsdk.dE.We
                            public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                com.bytedance.sdk.openadsdk.dE.pFF.sc scVar3 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                scVar3.pFF("stats");
                                return scVar3;
                            }
                        });
                    }
                });
            }
        }
    }
}
