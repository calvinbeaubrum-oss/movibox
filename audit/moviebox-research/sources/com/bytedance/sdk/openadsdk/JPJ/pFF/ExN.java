package com.bytedance.sdk.openadsdk.JPJ.pFF;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final Map<Integer, pFF> f27089sc = new ConcurrentHashMap();

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public int pFF = -1;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public int f27090sc;

        public sc(int i11) {
            this.f27090sc = i11;
        }
    }

    public static Integer pFF(Sfl sfl) {
        return Integer.valueOf((sfl.ofL() + sfl.kDg()).hashCode());
    }

    public static void pFF(Integer num) {
        f27089sc.remove(num);
    }

    private static pFF sc(View view, Sfl sfl, boolean z11, sc scVar) {
        if (view == null || sfl == null || sfl.kDg() == null) {
            return null;
        }
        Integer numPFF = pFF(sfl);
        Map<Integer, pFF> map = f27089sc;
        if (!map.containsKey(numPFF)) {
            pFF pffSc = pFF.sc(z11, numPFF, view, sfl, scVar);
            map.put(numPFF, pffSc);
            return pffSc;
        }
        pFF pff = map.get(numPFF);
        if (pff != null) {
            pff.sc(view);
        }
        return pff;
    }

    public static pFF sc(Integer num) {
        return f27089sc.get(num);
    }

    public static void sc(View view, Sfl sfl, sc scVar) {
        if (view == null || sfl == null || sfl.bp()) {
            return;
        }
        boolean zZY = zY(sfl);
        if (JPJ.pFF(sfl) && scVar != null) {
            scVar.f27090sc = -1;
        }
        sc(sc(view, sfl, zZY, scVar));
    }

    private static void sc(pFF pff) {
        if (pff == null) {
            return;
        }
        pff.sc();
    }

    public static void sc(pFF pff, int i11) {
        if (pff == null) {
            return;
        }
        pff.sc(i11);
    }

    public static void sc(Sfl sfl) {
        if (sfl == null || sfl.kDg() == null) {
            return;
        }
        Integer numPFF = pFF(sfl);
        Map<Integer, pFF> map = f27089sc;
        pFF pff = map.get(numPFF);
        if (pff != null) {
            pff.WH();
        }
        pFF(numPFF);
        if (map.size() <= 0) {
            qr.sc();
        }
    }

    public static void sc(Sfl sfl, int i11) {
        if (sfl == null || sfl.kDg() == null) {
            return;
        }
        sc(f27089sc.get(pFF(sfl)), i11);
    }

    private static boolean zY(Sfl sfl) {
        if (sfl == null) {
            return false;
        }
        String strSc = cJ.sc(sfl);
        return ((!"open_ad".equals(strSc) && !"fullscreen_interstitial_ad".equals(strSc) && !"rewarded_video".equals(strSc)) || JPJ.pFF(sfl) || sfl.Xc() == 5 || sfl.Xc() == 33 || !Sfl.ExN(sfl) || sfl.GI() == null) ? false : true;
    }
}
