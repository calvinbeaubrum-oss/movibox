package com.bytedance.adsdk.ugeno.Ol.sc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.Ol.TRI.pFF;
import com.bytedance.adsdk.ugeno.We;
import com.bytedance.adsdk.ugeno.pFF.zY;
import com.bytedance.adsdk.ugeno.qr.Qj;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends pFF {
    private int GOt;
    private String HC;
    private com.bytedance.adsdk.ugeno.qr.sc.C0234sc Pu;
    private int VZ;
    private String We;

    /* JADX INFO: renamed from: ef, reason: collision with root package name */
    private boolean f26345ef;
    private String jcs;

    /* JADX INFO: renamed from: vl, reason: collision with root package name */
    private boolean f26346vl;
    private String ymG;

    public sc(Context context) {
        super(context);
        this.jcs = "row";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0037  */
    public void pFF(Drawable drawable) {
        byte b11;
        if (drawable == null) {
            return;
        }
        switch (this.jcs) {
            case "column_reverse":
                b11 = 2;
                break;
            case "column":
                b11 = 1;
                break;
            case "row_reverse":
                b11 = 0;
                break;
            case "row":
                b11 = 3;
                break;
            default:
                b11 = -1;
                break;
        }
        if (b11 == 0) {
            ((com.bytedance.adsdk.ugeno.Ol.TRI.sc) this.Qj).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            return;
        }
        if (b11 == 1) {
            ((com.bytedance.adsdk.ugeno.Ol.TRI.sc) this.Qj).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        } else if (b11 != 2) {
            ((com.bytedance.adsdk.ugeno.Ol.TRI.sc) this.Qj).setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ((com.bytedance.adsdk.ugeno.Ol.TRI.sc) this.Qj).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
        }
    }

    private void zY() {
        if (TextUtils.isEmpty(this.We)) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.Ol.TRI.sc) this.Qj).setCompoundDrawables(null, null, null, null);
        if (!this.We.startsWith("local://")) {
            We.sc().pFF().sc(this.Tf, this.We, new com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc() { // from class: com.bytedance.adsdk.ugeno.Ol.sc.sc.1
                @Override // com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc
                public void sc(final Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    Qj.sc(new Runnable() { // from class: com.bytedance.adsdk.ugeno.Ol.sc.sc.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            sc.this.pFF(new BitmapDrawable(((zY) sc.this).ExN.getResources(), bitmap));
                        }
                    });
                }
            });
            return;
        }
        try {
            String strReplace = this.We.replace("local://", "");
            Context context = this.ExN;
            pFF(Qj.sc(context, com.bytedance.adsdk.ugeno.qr.We.sc(context, strReplace)));
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void CYO() {
        super.CYO();
        if (this.f26345ef) {
            ((com.bytedance.adsdk.ugeno.Ol.TRI.sc) this.Qj).setTextColor(((pFF) this).pFF);
        }
        if (this.f26346vl) {
            if (this.TpG) {
                sc(this.f26422ds);
            } else {
                We(this.qKn);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void JoC() {
        super.JoC();
        if (this.f26345ef) {
            ((com.bytedance.adsdk.ugeno.Ol.TRI.sc) this.Qj).setTextColor(this.VZ);
        }
        if (this.f26346vl) {
            if (this.TpG) {
                sc(this.Pu);
            } else {
                We(this.GOt);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Ol.TRI.pFF, com.bytedance.adsdk.ugeno.pFF.zY
    public void pFF() {
        super.pFF();
        zY();
        ((com.bytedance.adsdk.ugeno.Ol.TRI.sc) this.Qj).setGravity(17);
    }

    @Override // com.bytedance.adsdk.ugeno.Ol.TRI.pFF, com.bytedance.adsdk.ugeno.pFF.zY
    public void sc(String str, String str2) {
        super.sc(str, str2);
        str.hashCode();
        switch (str) {
            case "direction":
                this.jcs = str2;
                break;
            case "highlightTextColor":
            case "highlightedTextColor":
                this.VZ = com.bytedance.adsdk.ugeno.qr.sc.sc(str2);
                this.f26345ef = true;
                break;
            case "image":
                this.We = str2;
                break;
            case "highlightImage":
                this.HC = str2;
                break;
            case "highlightBackgroundColor":
                if (com.bytedance.adsdk.ugeno.qr.sc.zY(str2)) {
                    this.TpG = true;
                    this.Pu = com.bytedance.adsdk.ugeno.qr.sc.pFF(str2);
                } else {
                    this.GOt = com.bytedance.adsdk.ugeno.qr.sc.sc(str2);
                    this.TpG = false;
                }
                this.f26346vl = true;
                break;
            case "highlightBackgroundImage":
                this.ymG = str2;
                break;
        }
    }
}
