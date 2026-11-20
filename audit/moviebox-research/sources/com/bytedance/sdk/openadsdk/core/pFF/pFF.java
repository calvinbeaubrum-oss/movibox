package com.bytedance.sdk.openadsdk.core.pFF;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.cD;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.SR;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.WH;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends zY {
    private static int cJ = Integer.MIN_VALUE;
    protected boolean BT;
    public SR ExN;
    protected WeakReference<View> Ol;
    protected final int Qj;
    protected PAGNativeAd Ql;
    protected c SR;
    protected com.bytedance.sdk.openadsdk.core.Qj.pFF Sfl;
    protected final Sfl TRI;
    protected sc Tf;
    protected WH UFX;
    protected WeakReference<View> WH;
    protected Context We;
    protected Map<String, Object> Xc;
    protected int YIK;
    protected com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI dE;
    private WeakReference<Activity> pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected final String f28460qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f28461sc;
    protected PangleAd wjp;
    private boolean zY;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(View view, int i11);
    }

    public pFF(@NonNull Context context, @NonNull Sfl sfl, @NonNull String str, int i11) {
        this.BT = false;
        this.YIK = 0;
        this.zY = false;
        this.We = context;
        this.TRI = sfl;
        this.f28460qr = str;
        this.Qj = i11;
    }

    public pFF(@NonNull Context context, @NonNull Sfl sfl, @NonNull String str, int i11, boolean z11) {
        this(context, sfl, str, i11);
        this.zY = z11;
    }

    private static int sc(Context context) {
        if (cJ == Integer.MIN_VALUE) {
            cJ = com.bytedance.sdk.component.utils.Sfl.ExN(context, "btn_native_creative");
        }
        return cJ;
    }

    public static boolean sc(View view, Sfl sfl, boolean z11) {
        if (view != null && sfl != null) {
            try {
                int i11 = com.bytedance.sdk.component.adexpress.dynamic.sc.YIK;
                String strValueOf = String.valueOf(view.getTag(i11));
                if (view.getTag(i11) != null && !TextUtils.isEmpty(strValueOf)) {
                    if ("click".equals(strValueOf)) {
                        return z11;
                    }
                    return true;
                }
            } catch (Exception unused) {
            }
            if (zY(view)) {
                return sfl.YIK() != 1 || z11;
            }
            if (sfl.Sfl() == 1 && !z11) {
                return false;
            }
        }
        return true;
    }

    public static boolean zY(View view) {
        return 520093705 == view.getId() || 520093707 == view.getId() || 520093703 == view.getId() || sc(view.getContext()) == view.getId() || com.bytedance.sdk.openadsdk.utils.SR.JP == view.getId() || com.bytedance.sdk.openadsdk.utils.SR.zGQ == view.getId();
    }

    public View ExN() {
        WeakReference<Activity> weakReference = this.pFF;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        View viewFindViewById = this.pFF.get().findViewById(520093713);
        return viewFindViewById == null ? this.pFF.get().findViewById(520093713) : viewFindViewById;
    }

    public void ExN(boolean z11) {
        this.BT = z11;
    }

    public String TRI() {
        return this.f28461sc;
    }

    public View We() {
        WeakReference<Activity> weakReference = this.pFF;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.pFF.get().findViewById(R.id.content);
    }

    public void We(int i11) {
        this.YIK = i11;
    }

    public void pFF(int i11) {
        this.McK = i11;
    }

    public void pFF(View view) {
        if (view == null) {
            return;
        }
        this.WH = new WeakReference<>(view);
    }

    public WH sc(float f11, float f12, float f13, float f14, SparseArray<zY.sc> sparseArray, long j11, long j12, View view, View view2, String str, float f15, int i11, float f16, int i12, JSONObject jSONObject, JSONObject jSONObject2) {
        return new WH.sc().TRI(f11).ExN(f12).We(f13).zY(f14).pFF(j11).sc(j12).pFF(kX.sc(view)).sc(kX.sc(view2)).zY(kX.zY(view)).We(kX.zY(view2)).We(this.II).ExN(this.McK).TRI(this.HJN).sc(sparseArray).pFF(Ol.pFF().sc() ? 1 : 2).sc(str).sc(f15).zY(i11).pFF(f16).sc(i12).sc(jSONObject).pFF(jSONObject2).sc();
    }

    public void sc(int i11) {
        this.HJN = i11;
    }

    public void sc(Activity activity) {
        if (activity == null) {
            return;
        }
        this.pFF = new WeakReference<>(activity);
    }

    public void sc(View view) {
        if (view == null) {
            return;
        }
        this.Ol = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pFF.zY
    public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<zY.sc> sparseArray, boolean z11) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        int i11;
        boolean z12;
        Sfl sfl;
        if (this.We == null) {
            this.We = Xc.sc();
        }
        if ((this.zY || !sc(view, 1, f11, f12, f13, f14, sparseArray, z11)) && this.We != null) {
            SR sr2 = this.ExN;
            if (sr2 != null) {
                int i12 = sr2.Tf;
                JSONObject jSONObject3 = sr2.Ql;
                JSONObject jSONObject4 = sr2.Xc;
                z12 = sr2.wjp;
                i11 = i12;
                jSONObject = jSONObject3;
                jSONObject2 = jSONObject4;
            } else {
                jSONObject = null;
                jSONObject2 = null;
                i11 = -1;
                z12 = false;
            }
            long j11 = this.WP;
            long j12 = this.cvk;
            WeakReference<View> weakReference = this.Ol;
            View view2 = weakReference == null ? null : weakReference.get();
            WeakReference<View> weakReference2 = this.WH;
            WH whSc = sc(f11, f12, f13, f14, sparseArray, j11, j12, view2, weakReference2 == null ? null : weakReference2.get(), TRI(), kX.ExN(this.We), kX.qr(this.We), kX.TRI(this.We), i11, jSONObject, jSONObject2);
            this.UFX = whSc;
            if (sc(whSc, this.Xc)) {
                return;
            }
            if (this.SR != null) {
                if (this.Xc == null) {
                    this.Xc = new HashMap();
                }
                this.Xc.put("duration", Long.valueOf(this.SR.ExN()));
            }
            if (this.zY || z12) {
                com.bytedance.sdk.openadsdk.We.zY.sc("click", this.TRI, this.UFX, this.f28460qr, true, this.Xc, z11 ? 1 : 2);
                return;
            }
            sc scVar = this.Tf;
            if (scVar != null) {
                scVar.sc(view, -1);
            }
            if (sc(view, z11)) {
                boolean zPFF = JPJ.pFF(this.TRI);
                String strSc = zPFF ? this.f28460qr : cJ.sc(this.Qj);
                if (view != null) {
                    try {
                        if (((Boolean) view.getTag(520093762)).booleanValue()) {
                            cD.sc(true);
                        }
                    } catch (Exception unused) {
                    }
                }
                Activity activitySc = view != null ? com.bytedance.sdk.component.utils.pFF.sc(view) : null;
                boolean zSc = cD.sc(activitySc == null ? this.We : activitySc, this.TRI, this.Qj, this.Ql, this.wjp, strSc, this.dE, zPFF, 0);
                cD.sc(false);
                if (zSc || (sfl = this.TRI) == null || sfl.otH() == null || this.TRI.otH().zY() != 2) {
                    Sfl sfl2 = this.TRI;
                    if (sfl2 != null && !zSc && TextUtils.isEmpty(sfl2.ko()) && com.bytedance.sdk.openadsdk.We.pFF.sc(this.f28460qr)) {
                        com.bytedance.sdk.openadsdk.wjp.sc.sc.qr.sc(this.We, this.TRI, this.f28460qr).We();
                    }
                    com.bytedance.sdk.openadsdk.We.zY.sc("click", this.TRI, this.UFX, this.f28460qr, zSc, this.Xc, z11 ? 1 : 2);
                }
            }
        }
    }

    public void sc(PangleAd pangleAd) {
        this.wjp = pangleAd;
    }

    public void sc(PAGNativeAd pAGNativeAd) {
        this.Ql = pAGNativeAd;
    }

    public void sc(com.bytedance.sdk.openadsdk.core.Qj.pFF pff) {
        this.Sfl = pff;
    }

    public void sc(sc scVar) {
        this.Tf = scVar;
    }

    public void sc(com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI tri) {
        this.dE = tri;
    }

    public void sc(String str) {
        this.f28461sc = str;
    }

    public void sc(Map<String, Object> map) {
        Map<String, Object> map2 = this.Xc;
        if (map2 != null) {
            map2.putAll(map);
            map.putAll(this.Xc);
        }
        this.Xc = map;
    }

    public void sc(c cVar) {
        this.SR = cVar;
    }

    public boolean sc(View view, int i11, float f11, float f12, float f13, float f14, SparseArray<zY.sc> sparseArray, boolean z11) {
        if (this.Sfl == null) {
            return false;
        }
        int[] iArrSc = new int[2];
        int[] iArrZY = new int[2];
        WeakReference<View> weakReference = this.WH;
        if (weakReference != null) {
            iArrSc = kX.sc(weakReference.get());
            iArrZY = kX.zY(this.WH.get());
        }
        this.Sfl.sc(view, i11, new SR.sc().We(f11).zY(f12).pFF(f13).sc(f14).pFF(this.WP).sc(this.cvk).zY(iArrSc[0]).We(iArrSc[1]).ExN(iArrZY[0]).TRI(iArrZY[1]).sc(sparseArray).sc(z11).sc());
        return true;
    }

    public boolean sc(View view, boolean z11) {
        return sc(view, this.TRI, z11);
    }

    public boolean sc(WH wh2, Map<String, Object> map) {
        return false;
    }

    public void zY(int i11) {
        this.II = i11;
    }
}
