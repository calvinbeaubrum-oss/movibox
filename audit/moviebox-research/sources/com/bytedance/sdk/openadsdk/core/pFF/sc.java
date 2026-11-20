package com.bytedance.sdk.openadsdk.core.pFF;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.BT;
import com.bytedance.sdk.openadsdk.core.Qj.Qj;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.cD;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.WH;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends pFF {
    private int BR;
    private WeakReference<InterfaceC0305sc> cJ;
    private boolean kX;
    private boolean pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private boolean f28463sc;
    private boolean zY;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.pFF.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0305sc {
        long getVideoProgress();
    }

    public sc(@NonNull Context context, @NonNull Sfl sfl, @NonNull String str, int i11) {
        super(context, sfl, str, i11);
        this.f28463sc = true;
        this.pFF = false;
        this.zY = false;
        this.kX = false;
    }

    private boolean Ol() {
        return this instanceof Qj;
    }

    private boolean Qj() {
        return Sfl.ExN(((pFF) this).TRI) && ((pFF) this).TRI.WP() == 1;
    }

    private boolean WH() {
        if (((pFF) this).TRI == null || Ol()) {
            return false;
        }
        if (((pFF) this).TRI.dix() != 5 && ((pFF) this).TRI.dix() != 15) {
            return false;
        }
        if (this.BR == 0) {
            this.BR = ((pFF) this).TRI.qY();
        }
        pFF();
        sc();
        zY();
        if (this.BR == 5 && Qj() && sc() && !pFF() && !zY()) {
            return false;
        }
        int i11 = this.BR;
        return i11 == 1 || i11 == 2 || i11 == 5;
    }

    private boolean We(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI) || view.getId() == SR.f28745ef || view.getId() == SR.qKn || view.getId() == SR.f28751pc || view.getId() == SR.GI || view.getId() == SR.MxZ || view.getId() == 520093726 || view.getId() == SR.WgX) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        int i11 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i11 >= viewGroup.getChildCount()) {
                return false;
            }
            if (We(viewGroup.getChildAt(i11))) {
                return true;
            }
            i11++;
        }
    }

    private String pFF(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return "banner_call";
            case "open_ad":
                return "open_ad";
            case "embeded_ad":
                return "feed_call";
            case "interaction":
                return "interaction_call";
            case "slide_banner_ad":
                return "banner_call";
            default:
                return "";
        }
    }

    public void We(boolean z11) {
        this.kX = z11;
    }

    public void pFF(boolean z11) {
        this.pFF = z11;
    }

    public boolean pFF() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0255  */
    /* JADX WARN: Code duplicated, block: B:160:0x0334  */
    /* JADX WARN: Code duplicated, block: B:173:0x0378  */
    /* JADX WARN: Code duplicated, block: B:175:0x037c  */
    /* JADX WARN: Code duplicated, block: B:177:0x0380  */
    /* JADX WARN: Code duplicated, block: B:179:0x038d  */
    /* JADX WARN: Code duplicated, block: B:180:0x038f  */
    /* JADX WARN: Code duplicated, block: B:185:0x039e A[Catch: Exception -> 0x03a3, TryCatch #0 {Exception -> 0x03a3, blocks: (B:183:0x0395, B:185:0x039e, B:191:0x03b4, B:189:0x03a5), top: B:214:0x0395 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x03a5 A[Catch: Exception -> 0x03a3, TryCatch #0 {Exception -> 0x03a3, blocks: (B:183:0x0395, B:185:0x039e, B:191:0x03b4, B:189:0x03a5), top: B:214:0x0395 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x03b4 A[Catch: Exception -> 0x03a3, TRY_LEAVE, TryCatch #0 {Exception -> 0x03a3, blocks: (B:183:0x0395, B:185:0x039e, B:191:0x03b4, B:189:0x03a5), top: B:214:0x0395 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:195:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:196:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:199:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:202:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:205:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:207:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:208:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:214:0x0395 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x00e9  */
    @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF, com.bytedance.sdk.openadsdk.core.pFF.zY
    public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<zY.sc> sparseArray, boolean z11) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        int i11;
        boolean z12;
        View view2;
        int i12;
        Activity activitySc;
        Context context;
        boolean z13;
        int i13;
        String strKo;
        String str;
        if (sc(view, 2, f11, f12, f13, f14, sparseArray, z11)) {
            return;
        }
        ((pFF) this).TRI.ExN(true);
        ((pFF) this).TRI.pXW();
        if (!((pFF) this).TRI.ExN()) {
            ((pFF) this).TRI.sc(true);
        }
        if (Sfl.ExN(((pFF) this).TRI)) {
            Sfl sfl = ((pFF) this).TRI;
            com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, ((pFF) this).f28460qr, sfl.ap());
        }
        if (this.SR != null) {
            if (this.Xc == null) {
                this.Xc = new HashMap();
            }
            this.Xc.put("duration", Long.valueOf(this.SR.ExN()));
        }
        int iQOv = ((pFF) this).TRI.qOv();
        ((pFF) this).TRI.OXF(0);
        com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI tri = this.dE;
        if (tri != null) {
            tri.sc(iQOv > 0 ? iQOv : 0);
        }
        Map<String, Object> map = this.Xc;
        if (map != null) {
            map.remove("dsp_click_type");
            this.Xc.remove("click_probability_jump");
            this.Xc.remove("auto_click");
        }
        if (iQOv > 0) {
            if (this.Xc == null) {
                this.Xc = new HashMap();
            }
            if (((pFF) this).TRI.ymG() && iQOv < 11) {
                this.Xc.put("dsp_click_type", Integer.valueOf(iQOv));
            }
            if (iQOv >= 11 && ((pFF) this).TRI.Vb() == 0) {
                this.Xc.put("click_probability_jump", Integer.valueOf(com.bytedance.sdk.openadsdk.core.model.TRI.sc(iQOv)));
            }
        }
        if (((pFF) this).TRI.ymG()) {
            if (view != null) {
                Object tag = view.getTag(570425345);
                if (tag instanceof String) {
                    str = (String) tag;
                } else {
                    str = "VAST_ACTION_BUTTON";
                }
            } else {
                str = "VAST_ACTION_BUTTON";
            }
            ((pFF) this).TRI.GOt().ExN(str);
            if (!TextUtils.isEmpty(str)) {
                sc(str);
            }
            WeakReference<InterfaceC0305sc> weakReference = this.cJ;
            long videoProgress = (weakReference == null || weakReference.get() == null) ? 0L : this.cJ.get().getVideoProgress();
            if ("VAST_ICON".equals(str)) {
                if (((pFF) this).TRI.GOt().pFF() != null) {
                    ((pFF) this).TRI.GOt().pFF().sc(videoProgress);
                }
            } else if (!"VAST_END_CARD".equals(str)) {
                ((pFF) this).TRI.GOt().sc().qr(videoProgress);
            } else if (((pFF) this).TRI.GOt().zY() != null) {
                ((pFF) this).TRI.GOt().zY().sc(videoProgress);
            }
        }
        if (WH() && We(view) && !this.zY) {
            super.sc(view, f11, f12, f13, f14, sparseArray, z11);
            return;
        }
        if (this.We == null) {
            this.We = Xc.sc();
        }
        if (this.We != null && sc(view, z11)) {
            JSONObject jSONObjectSc = com.bytedance.sdk.openadsdk.core.Qj.Sfl.sc(view);
            com.bytedance.sdk.openadsdk.core.model.SR sr2 = this.ExN;
            if (sr2 != null) {
                int i14 = sr2.Tf;
                JSONObject jSONObject3 = sr2.Ql;
                JSONObject jSONObject4 = sr2.Xc;
                i11 = i14;
                z12 = sr2.wjp;
                jSONObject = jSONObject3;
                jSONObject2 = jSONObject4;
            } else {
                jSONObject = jSONObjectSc;
                jSONObject2 = null;
                i11 = -1;
                z12 = false;
            }
            long j11 = this.WP;
            long j12 = this.cvk;
            WeakReference<View> weakReference2 = this.Ol;
            View viewWe = weakReference2 == null ? We() : weakReference2.get();
            WeakReference<View> weakReference3 = this.WH;
            WH whSc = sc(f11, f12, f13, f14, sparseArray, j11, j12, viewWe, weakReference3 == null ? ExN() : weakReference3.get(), TRI(), kX.ExN(this.We), kX.qr(this.We), kX.TRI(this.We), i11, jSONObject, jSONObject2);
            this.UFX = whSc;
            if (z12) {
                com.bytedance.sdk.openadsdk.We.zY.sc("click", ((pFF) this).TRI, whSc, ((pFF) this).f28460qr, true, this.Xc, z11 ? 1 : 2);
                return;
            }
            int iQLv = ((pFF) this).TRI.QLv();
            if (iQLv == 2 || iQLv == 3) {
                view2 = view;
                if (iQLv == 3) {
                    strKo = ((pFF) this).TRI.ko();
                    if (TextUtils.isEmpty(strKo) && strKo.contains("play.google.com/store")) {
                        if (!com.bytedance.sdk.openadsdk.wjp.sc.sc.We.sc(this.We, strKo, strKo.substring(strKo.indexOf("?id=") + 4), ((pFF) this).f28460qr, ((pFF) this).TRI)) {
                            if (this.Ql == null) {
                                Sfl sfl2 = ((pFF) this).TRI;
                                WH wh2 = this.UFX;
                                String str2 = ((pFF) this).f28460qr;
                                Map<String, Object> map2 = this.Xc;
                                if (z11) {
                                    i12 = 1;
                                } else {
                                    i12 = 2;
                                }
                                com.bytedance.sdk.openadsdk.We.zY.sc("click_button", sfl2, wh2, str2, true, map2, i12);
                            } else {
                                Sfl sfl3 = ((pFF) this).TRI;
                                WH wh3 = this.UFX;
                                String str3 = ((pFF) this).f28460qr;
                                Map<String, Object> map3 = this.Xc;
                                if (z11) {
                                    i12 = 1;
                                } else {
                                    i12 = 2;
                                }
                                com.bytedance.sdk.openadsdk.We.zY.sc("click_button", sfl3, wh3, str3, true, map3, i12);
                            }
                            if (view2 != null) {
                                if (view.getId() != 520093726) {
                                }
                                cD.sc(true);
                            } else if (((Boolean) view2.getTag(520093762)).booleanValue()) {
                                cD.sc(true);
                            }
                            if (view2 != null) {
                            }
                            if (activitySc == null) {
                                context = this.We;
                            } else {
                                context = activitySc;
                            }
                            if (com.bytedance.sdk.openadsdk.core.model.Xc.zY(((pFF) this).TRI)) {
                                boolean zSc = cD.sc(context, ((pFF) this).TRI, this.Qj, this.Ql, this.wjp, ((pFF) this).f28460qr, this.dE, true, iQOv);
                                cD.sc(false);
                                z13 = zSc;
                            } else {
                                boolean zSc2 = cD.sc(context, ((pFF) this).TRI, this.Qj, this.Ql, this.wjp, ((pFF) this).f28460qr, this.dE, true, iQOv);
                                cD.sc(false);
                                z13 = zSc2;
                            }
                            if (this.f28463sc) {
                                Sfl sfl4 = ((pFF) this).TRI;
                                WH wh4 = this.UFX;
                                String str4 = ((pFF) this).f28460qr;
                                Map<String, Object> map4 = this.Xc;
                                if (z11) {
                                    i13 = 1;
                                } else {
                                    i13 = 2;
                                }
                                com.bytedance.sdk.openadsdk.We.zY.sc("click", sfl4, wh4, str4, z13, map4, i13);
                            }
                        } else if (this.f28463sc) {
                            com.bytedance.sdk.openadsdk.We.zY.sc("click", ((pFF) this).TRI, this.UFX, ((pFF) this).f28460qr, true, this.Xc, z11 ? 1 : 2);
                        }
                    } else {
                        if (this.Ql == null || this.pFF) {
                            Sfl sfl5 = ((pFF) this).TRI;
                            WH wh5 = this.UFX;
                            String str5 = ((pFF) this).f28460qr;
                            Map<String, Object> map5 = this.Xc;
                            if (z11) {
                                i12 = 1;
                            } else {
                                i12 = 2;
                            }
                            com.bytedance.sdk.openadsdk.We.zY.sc("click_button", sfl5, wh5, str5, true, map5, i12);
                        }
                        if (view2 != null) {
                            try {
                                if (view.getId() != 520093726 || (view2 instanceof com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI)) {
                                    cD.sc(true);
                                } else if (((Boolean) view2.getTag(520093762)).booleanValue()) {
                                    cD.sc(true);
                                }
                            } catch (Exception unused) {
                            }
                        } else if (((Boolean) view2.getTag(520093762)).booleanValue()) {
                            cD.sc(true);
                        }
                        activitySc = view2 != null ? com.bytedance.sdk.component.utils.pFF.sc(view) : null;
                        if (activitySc == null) {
                            context = this.We;
                        } else {
                            context = activitySc;
                        }
                        if (com.bytedance.sdk.openadsdk.core.model.Xc.zY(((pFF) this).TRI) || !this.kX) {
                            boolean zSc3 = cD.sc(context, ((pFF) this).TRI, this.Qj, this.Ql, this.wjp, ((pFF) this).f28460qr, this.dE, true, iQOv);
                            cD.sc(false);
                            z13 = zSc3;
                        } else {
                            z13 = false;
                        }
                        if (this.f28463sc) {
                            Sfl sfl6 = ((pFF) this).TRI;
                            WH wh6 = this.UFX;
                            String str6 = ((pFF) this).f28460qr;
                            Map<String, Object> map6 = this.Xc;
                            if (z11) {
                                i13 = 1;
                            } else {
                                i13 = 2;
                            }
                            com.bytedance.sdk.openadsdk.We.zY.sc("click", sfl6, wh6, str6, z13, map6, i13);
                        }
                    }
                } else {
                    if (this.Ql == null) {
                        Sfl sfl7 = ((pFF) this).TRI;
                        WH wh7 = this.UFX;
                        String str7 = ((pFF) this).f28460qr;
                        Map<String, Object> map7 = this.Xc;
                        if (z11) {
                            i12 = 1;
                        } else {
                            i12 = 2;
                        }
                        com.bytedance.sdk.openadsdk.We.zY.sc("click_button", sfl7, wh7, str7, true, map7, i12);
                    } else {
                        Sfl sfl8 = ((pFF) this).TRI;
                        WH wh8 = this.UFX;
                        String str8 = ((pFF) this).f28460qr;
                        Map<String, Object> map8 = this.Xc;
                        if (z11) {
                            i12 = 1;
                        } else {
                            i12 = 2;
                        }
                        com.bytedance.sdk.openadsdk.We.zY.sc("click_button", sfl8, wh8, str8, true, map8, i12);
                    }
                    if (view2 != null) {
                        if (view.getId() != 520093726) {
                        }
                        cD.sc(true);
                    } else if (((Boolean) view2.getTag(520093762)).booleanValue()) {
                        cD.sc(true);
                    }
                    if (view2 != null) {
                    }
                    if (activitySc == null) {
                        context = this.We;
                    } else {
                        context = activitySc;
                    }
                    if (com.bytedance.sdk.openadsdk.core.model.Xc.zY(((pFF) this).TRI)) {
                        boolean zSc4 = cD.sc(context, ((pFF) this).TRI, this.Qj, this.Ql, this.wjp, ((pFF) this).f28460qr, this.dE, true, iQOv);
                        cD.sc(false);
                        z13 = zSc4;
                    } else {
                        boolean zSc5 = cD.sc(context, ((pFF) this).TRI, this.Qj, this.Ql, this.wjp, ((pFF) this).f28460qr, this.dE, true, iQOv);
                        cD.sc(false);
                        z13 = zSc5;
                    }
                    if (this.f28463sc) {
                        Sfl sfl9 = ((pFF) this).TRI;
                        WH wh9 = this.UFX;
                        String str9 = ((pFF) this).f28460qr;
                        Map<String, Object> map9 = this.Xc;
                        if (z11) {
                            i13 = 1;
                        } else {
                            i13 = 2;
                        }
                        com.bytedance.sdk.openadsdk.We.zY.sc("click", sfl9, wh9, str9, z13, map9, i13);
                    }
                }
            } else if (iQLv != 4) {
                if (iQLv == 5) {
                    String strPFF = pFF(((pFF) this).f28460qr);
                    if (!TextUtils.isEmpty(strPFF)) {
                        com.bytedance.sdk.openadsdk.We.zY.sc("click_call", ((pFF) this).TRI, this.UFX, strPFF, true, this.Xc, z11 ? 1 : 2);
                    }
                    com.bytedance.sdk.openadsdk.We.zY.sc("click", ((pFF) this).TRI, this.UFX, ((pFF) this).f28460qr, cJ.zY(view.getContext(), ((pFF) this).TRI.ZM()), this.Xc, z11 ? 1 : 2);
                    view2 = view;
                } else if (iQLv != 8) {
                    view2 = view;
                    iQLv = -1;
                } else {
                    view2 = view;
                    if (iQLv == 3) {
                        strKo = ((pFF) this).TRI.ko();
                        if (TextUtils.isEmpty(strKo)) {
                            if (this.Ql == null) {
                                Sfl sfl10 = ((pFF) this).TRI;
                                WH wh10 = this.UFX;
                                String str10 = ((pFF) this).f28460qr;
                                Map<String, Object> map10 = this.Xc;
                                if (z11) {
                                    i12 = 1;
                                } else {
                                    i12 = 2;
                                }
                                com.bytedance.sdk.openadsdk.We.zY.sc("click_button", sfl10, wh10, str10, true, map10, i12);
                            } else {
                                Sfl sfl11 = ((pFF) this).TRI;
                                WH wh11 = this.UFX;
                                String str11 = ((pFF) this).f28460qr;
                                Map<String, Object> map11 = this.Xc;
                                if (z11) {
                                    i12 = 1;
                                } else {
                                    i12 = 2;
                                }
                                com.bytedance.sdk.openadsdk.We.zY.sc("click_button", sfl11, wh11, str11, true, map11, i12);
                            }
                            if (view2 != null) {
                                if (view.getId() != 520093726) {
                                }
                                cD.sc(true);
                            } else if (((Boolean) view2.getTag(520093762)).booleanValue()) {
                                cD.sc(true);
                            }
                            if (view2 != null) {
                            }
                            if (activitySc == null) {
                                context = this.We;
                            } else {
                                context = activitySc;
                            }
                            if (com.bytedance.sdk.openadsdk.core.model.Xc.zY(((pFF) this).TRI)) {
                                boolean zSc6 = cD.sc(context, ((pFF) this).TRI, this.Qj, this.Ql, this.wjp, ((pFF) this).f28460qr, this.dE, true, iQOv);
                                cD.sc(false);
                                z13 = zSc6;
                            } else {
                                boolean zSc7 = cD.sc(context, ((pFF) this).TRI, this.Qj, this.Ql, this.wjp, ((pFF) this).f28460qr, this.dE, true, iQOv);
                                cD.sc(false);
                                z13 = zSc7;
                            }
                            if (this.f28463sc) {
                                Sfl sfl12 = ((pFF) this).TRI;
                                WH wh12 = this.UFX;
                                String str12 = ((pFF) this).f28460qr;
                                Map<String, Object> map12 = this.Xc;
                                if (z11) {
                                    i13 = 1;
                                } else {
                                    i13 = 2;
                                }
                                com.bytedance.sdk.openadsdk.We.zY.sc("click", sfl12, wh12, str12, z13, map12, i13);
                            }
                        } else {
                            if (this.Ql == null) {
                                Sfl sfl13 = ((pFF) this).TRI;
                                WH wh13 = this.UFX;
                                String str13 = ((pFF) this).f28460qr;
                                Map<String, Object> map13 = this.Xc;
                                if (z11) {
                                    i12 = 1;
                                } else {
                                    i12 = 2;
                                }
                                com.bytedance.sdk.openadsdk.We.zY.sc("click_button", sfl13, wh13, str13, true, map13, i12);
                            } else {
                                Sfl sfl14 = ((pFF) this).TRI;
                                WH wh14 = this.UFX;
                                String str14 = ((pFF) this).f28460qr;
                                Map<String, Object> map14 = this.Xc;
                                if (z11) {
                                    i12 = 1;
                                } else {
                                    i12 = 2;
                                }
                                com.bytedance.sdk.openadsdk.We.zY.sc("click_button", sfl14, wh14, str14, true, map14, i12);
                            }
                            if (view2 != null) {
                                if (view.getId() != 520093726) {
                                }
                                cD.sc(true);
                            } else if (((Boolean) view2.getTag(520093762)).booleanValue()) {
                                cD.sc(true);
                            }
                            if (view2 != null) {
                            }
                            if (activitySc == null) {
                                context = this.We;
                            } else {
                                context = activitySc;
                            }
                            if (com.bytedance.sdk.openadsdk.core.model.Xc.zY(((pFF) this).TRI)) {
                                boolean zSc8 = cD.sc(context, ((pFF) this).TRI, this.Qj, this.Ql, this.wjp, ((pFF) this).f28460qr, this.dE, true, iQOv);
                                cD.sc(false);
                                z13 = zSc8;
                            } else {
                                boolean zSc9 = cD.sc(context, ((pFF) this).TRI, this.Qj, this.Ql, this.wjp, ((pFF) this).f28460qr, this.dE, true, iQOv);
                                cD.sc(false);
                                z13 = zSc9;
                            }
                            if (this.f28463sc) {
                                Sfl sfl15 = ((pFF) this).TRI;
                                WH wh15 = this.UFX;
                                String str15 = ((pFF) this).f28460qr;
                                Map<String, Object> map15 = this.Xc;
                                if (z11) {
                                    i13 = 1;
                                } else {
                                    i13 = 2;
                                }
                                com.bytedance.sdk.openadsdk.We.zY.sc("click", sfl15, wh15, str15, z13, map15, i13);
                            }
                        }
                    } else {
                        if (this.Ql == null) {
                            Sfl sfl16 = ((pFF) this).TRI;
                            WH wh16 = this.UFX;
                            String str16 = ((pFF) this).f28460qr;
                            Map<String, Object> map16 = this.Xc;
                            if (z11) {
                                i12 = 1;
                            } else {
                                i12 = 2;
                            }
                            com.bytedance.sdk.openadsdk.We.zY.sc("click_button", sfl16, wh16, str16, true, map16, i12);
                        } else {
                            Sfl sfl17 = ((pFF) this).TRI;
                            WH wh17 = this.UFX;
                            String str17 = ((pFF) this).f28460qr;
                            Map<String, Object> map17 = this.Xc;
                            if (z11) {
                                i12 = 1;
                            } else {
                                i12 = 2;
                            }
                            com.bytedance.sdk.openadsdk.We.zY.sc("click_button", sfl17, wh17, str17, true, map17, i12);
                        }
                        if (view2 != null) {
                            if (view.getId() != 520093726) {
                            }
                            cD.sc(true);
                        } else if (((Boolean) view2.getTag(520093762)).booleanValue()) {
                            cD.sc(true);
                        }
                        if (view2 != null) {
                        }
                        if (activitySc == null) {
                            context = this.We;
                        } else {
                            context = activitySc;
                        }
                        if (com.bytedance.sdk.openadsdk.core.model.Xc.zY(((pFF) this).TRI)) {
                            boolean zSc10 = cD.sc(context, ((pFF) this).TRI, this.Qj, this.Ql, this.wjp, ((pFF) this).f28460qr, this.dE, true, iQOv);
                            cD.sc(false);
                            z13 = zSc10;
                        } else {
                            boolean zSc11 = cD.sc(context, ((pFF) this).TRI, this.Qj, this.Ql, this.wjp, ((pFF) this).f28460qr, this.dE, true, iQOv);
                            cD.sc(false);
                            z13 = zSc11;
                        }
                        if (this.f28463sc) {
                            Sfl sfl18 = ((pFF) this).TRI;
                            WH wh18 = this.UFX;
                            String str18 = ((pFF) this).f28460qr;
                            Map<String, Object> map18 = this.Xc;
                            if (z11) {
                                i13 = 1;
                            } else {
                                i13 = 2;
                            }
                            com.bytedance.sdk.openadsdk.We.zY.sc("click", sfl18, wh18, str18, z13, map18, i13);
                        }
                    }
                }
            } else if (!JPJ.pFF(((pFF) this).TRI) || (this.Ql == null && this.wjp == null)) {
                view2 = view;
                com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI tri2 = this.dE;
                if (tri2 != null) {
                    tri2.We();
                    Map<String, Object> map19 = this.Xc;
                    if (((pFF) this).TRI.ExN() && !((pFF) this).TRI.We()) {
                        map19.put("auto_click", Boolean.TRUE);
                        ((pFF) this).TRI.pFF(false);
                    }
                    if (this.f28463sc) {
                        com.bytedance.sdk.openadsdk.We.zY.sc("click", ((pFF) this).TRI, this.UFX, ((pFF) this).f28460qr, true, map19, z11 ? 1 : 2);
                    }
                }
            } else {
                view2 = view;
                activitySc = view2 != null ? com.bytedance.sdk.component.utils.pFF.sc(view) : null;
                boolean zSc12 = cD.sc(activitySc == null ? this.We : activitySc, ((pFF) this).TRI, this.Qj, this.Ql, this.wjp, ((pFF) this).f28460qr, this.dE, true, iQOv);
                if (this.f28463sc) {
                    com.bytedance.sdk.openadsdk.We.zY.sc("click", ((pFF) this).TRI, this.UFX, ((pFF) this).f28460qr, zSc12, this.Xc, z11 ? 1 : 2);
                }
            }
            pFF.sc scVar = this.Tf;
            if (scVar != null) {
                scVar.sc(view2, iQLv);
            }
        }
    }

    public void sc(InterfaceC0305sc interfaceC0305sc) {
        this.cJ = new WeakReference<>(interfaceC0305sc);
    }

    public void sc(boolean z11) {
        this.f28463sc = z11;
    }

    public boolean sc() {
        Sfl sfl = ((pFF) this).TRI;
        if (sfl == null) {
            return true;
        }
        int iPFF = Xc.We().pFF(sfl.QT());
        int iZY = BT.zY(Xc.sc());
        if (iPFF == 1) {
            return cJ.We(iZY);
        }
        if (iPFF == 2) {
            return cJ.ExN(iZY) || cJ.We(iZY) || cJ.TRI(iZY);
        }
        if (iPFF != 3) {
            return iPFF != 5 || cJ.We(iZY) || cJ.TRI(iZY);
        }
        return false;
    }

    public void zY(boolean z11) {
        this.zY = z11;
    }

    public boolean zY() {
        return false;
    }
}
