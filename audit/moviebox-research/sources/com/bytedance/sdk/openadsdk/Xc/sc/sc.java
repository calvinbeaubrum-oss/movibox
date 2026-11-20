package com.bytedance.sdk.openadsdk.Xc.sc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.ExN.Qj;
import com.bytedance.sdk.component.ExN.UFX;
import com.bytedance.sdk.component.ExN.dE;
import com.bytedance.sdk.openadsdk.Ol.We;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.Xc.sc.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0277sc {
        void sc(int i11, String str, Throwable th2);

        void sc(String str, pFF pff);
    }

    private int sc(UFX ufx) {
        Object obj;
        Map<String, String> mapWe = ufx.We();
        if (mapWe == null || (obj = mapWe.get(CampaignEx.JSON_KEY_IMAGE_SIZE)) == null || !(obj instanceof Integer)) {
            return 0;
        }
        return ((Integer) obj).intValue();
    }

    public void sc(int i11, String str, Throwable th2, InterfaceC0277sc interfaceC0277sc) {
        if (interfaceC0277sc != null) {
            interfaceC0277sc.sc(i11, str, th2);
        }
    }

    public void sc(UFX ufx, InterfaceC0277sc interfaceC0277sc) {
        if (interfaceC0277sc != null) {
            Object objPFF = ufx.pFF();
            int iSc = sc(ufx);
            if (objPFF instanceof byte[]) {
                interfaceC0277sc.sc(ufx.sc(), new pFF((byte[]) objPFF, iSc));
                return;
            }
            if (objPFF instanceof Bitmap) {
                interfaceC0277sc.sc(ufx.sc(), new pFF((Bitmap) objPFF, ufx.zY() instanceof Bitmap ? (Bitmap) ufx.zY() : null, iSc));
            } else {
                interfaceC0277sc.sc(0, "not bitmap or gif result!", null);
            }
        }
    }

    public void sc(com.bytedance.sdk.openadsdk.Xc.sc scVar, final InterfaceC0277sc interfaceC0277sc, int i11, int i12, ImageView.ScaleType scaleType, String str, final int i13, Sfl sfl) {
        We.sc(scVar.f27477sc).sc(scVar.pFF).sc(i11).pFF(i12).ExN(kX.We(Xc.sc())).We(kX.zY(Xc.sc())).pFF(str).sc(Bitmap.Config.RGB_565).sc(scaleType).sc(!TextUtils.isEmpty(str)).sc(new Qj() { // from class: com.bytedance.sdk.openadsdk.Xc.sc.sc.2
            @Override // com.bytedance.sdk.component.ExN.Qj
            public Bitmap sc(Bitmap bitmap) {
                return i13 <= 0 ? bitmap : com.bytedance.sdk.component.adexpress.We.sc.sc(Xc.sc(), bitmap, i13);
            }
        }).sc(new com.bytedance.sdk.openadsdk.Ol.pFF(sfl, scVar.f27477sc, new dE() { // from class: com.bytedance.sdk.openadsdk.Xc.sc.sc.1
            @Override // com.bytedance.sdk.component.ExN.dE
            public void sc(int i14, String str2, Throwable th2) {
                sc.this.sc(i14, str2, th2, interfaceC0277sc);
            }

            @Override // com.bytedance.sdk.component.ExN.dE
            public void sc(UFX ufx) {
                sc.this.sc(ufx, interfaceC0277sc);
            }
        }));
    }
}
