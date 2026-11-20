package com.bytedance.adsdk.ugeno.Ol.pFF;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends com.bytedance.adsdk.ugeno.pFF.sc<com.bytedance.adsdk.ugeno.Ol.pFF.sc> {
    private com.bytedance.adsdk.ugeno.Ol.pFF.sc pFF;

    /* JADX INFO: compiled from: source.java */
    public static class sc extends com.bytedance.adsdk.ugeno.pFF.sc.C0233sc {
        protected int cvk;

        public sc(com.bytedance.adsdk.ugeno.pFF.sc scVar) {
            super(scVar);
            this.cvk = -1;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:4:0x000e  */
        private int pFF(String str) {
            str.hashCode();
            switch (str) {
                case "bottom":
                    return 80;
                case "center":
                    return 17;
                case "center_vertical":
                    return 16;
                case "top":
                    return 48;
                case "left":
                    return 3;
                case "right":
                    return 5;
                case "center_horizontal":
                    return 1;
                default:
                    return -1;
            }
        }

        private int sc(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\|")) == null || strArrSplit.length <= 0) {
                return -1;
            }
            int iPFF = 0;
            for (String str2 : strArrSplit) {
                iPFF |= pFF(str2);
            }
            return iPFF;
        }

        @Override // com.bytedance.adsdk.ugeno.pFF.sc.C0233sc
        /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams sc() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f26419sc, (int) this.pFF);
            layoutParams.leftMargin = (int) this.TRI;
            layoutParams.rightMargin = (int) this.f26418qr;
            layoutParams.topMargin = (int) this.Qj;
            layoutParams.bottomMargin = (int) this.Ol;
            layoutParams.gravity = this.cvk;
            return layoutParams;
        }

        @Override // com.bytedance.adsdk.ugeno.pFF.sc.C0233sc
        public void sc(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.sc(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.cvk = sc(str2);
            }
        }
    }

    public pFF(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    /* JADX INFO: renamed from: eo, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.ugeno.Ol.pFF.sc We() {
        com.bytedance.adsdk.ugeno.Ol.pFF.sc scVar = new com.bytedance.adsdk.ugeno.Ol.pFF.sc(this.ExN);
        this.pFF = scVar;
        scVar.sc(this);
        return this.pFF;
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.sc, com.bytedance.adsdk.ugeno.pFF.zY
    public void pFF() {
        this.pFF.setEventMap(this.hE);
        super.pFF();
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.sc
    public com.bytedance.adsdk.ugeno.pFF.sc.C0233sc zY() {
        return new sc(this);
    }
}
