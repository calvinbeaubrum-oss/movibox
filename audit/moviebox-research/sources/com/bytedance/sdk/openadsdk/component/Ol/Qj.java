package com.bytedance.sdk.openadsdk.component.Ol;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.widget.Xc;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj {
    private static Drawable pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static boolean f27739sc;
    private TextView We;
    private Xc zY;

    public static Drawable zY() {
        return pFF;
    }

    public void pFF() {
        if (f27739sc) {
            return;
        }
        try {
            int iQr = Ol.pFF().qr();
            if (iQr != 0) {
                pFF = com.bytedance.sdk.openadsdk.core.Xc.sc().getResources().getDrawable(iQr);
            }
            f27739sc = true;
        } catch (Throwable unused) {
            f27739sc = true;
        }
    }

    public void sc() {
        String strTRI = Ol.pFF().TRI();
        if (TextUtils.isEmpty(strTRI)) {
            this.We.setVisibility(8);
        } else {
            this.We.setText(strTRI);
        }
        pFF();
        try {
            Drawable drawable = pFF;
            if (drawable == null) {
                this.zY.setVisibility(8);
                return;
            }
            this.zY.setImageDrawable(drawable);
            if (this.We.getVisibility() == 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.zY.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, 0, 0);
                this.zY.setLayoutParams(marginLayoutParams);
            }
        } catch (Throwable unused) {
            this.zY.setVisibility(8);
        }
    }

    public void sc(zY zYVar, Sfl sfl, float f11, float f12, boolean z11) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        if (zYVar != null) {
            this.zY = zYVar.getHostAppIcon();
            this.We = zYVar.getHostAppName();
            View userInfo = zYVar.getUserInfo();
            if (zYVar instanceof We) {
                Xc xc2 = this.zY;
                if (xc2 != null && (layoutParams2 = xc2.getLayoutParams()) != null) {
                    if (sfl.gx() == 1) {
                        int iZY = kX.zY(this.zY.getContext(), 40.0f);
                        layoutParams2.width = iZY;
                        layoutParams2.height = iZY;
                    } else {
                        int iZY2 = kX.zY(this.zY.getContext(), 30.0f);
                        layoutParams2.width = iZY2;
                        layoutParams2.height = iZY2;
                    }
                    this.zY.setLayoutParams(layoutParams2);
                }
                if (this.We != null) {
                    if (sfl.gx() == 1) {
                        this.We.setTextSize(30.0f);
                    } else {
                        this.We.setTextSize(24.0f);
                    }
                }
                if (userInfo != null && (layoutParams = userInfo.getLayoutParams()) != null) {
                    if (sfl.gx() == 1) {
                        layoutParams.height = kX.zY(userInfo.getContext(), 107.0f);
                    } else {
                        layoutParams.height = kX.zY(userInfo.getContext(), 60.0f);
                    }
                    userInfo.setLayoutParams(layoutParams);
                }
            }
            if (userInfo != null) {
                userInfo.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.Ol.Qj.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                });
            }
        }
    }
}
