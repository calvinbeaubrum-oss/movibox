package com.bytedance.sdk.openadsdk.api.init;

import android.text.TextUtils;
import com.bytedance.sdk.component.qr.We.zY;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.api.PAGConstant;
import com.bytedance.sdk.openadsdk.core.II;
import com.bytedance.sdk.openadsdk.utils.Dl;
import com.bytedance.sdk.openadsdk.utils.cJ;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class PAGConfig implements InitConfig {
    private static String UFX;
    private String Ol;
    private boolean Qj;
    private String WH;
    private boolean pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f27656sc;
    private int zY;
    private int We = -1;
    private int ExN = -1;
    private int TRI = -1;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f27655qr = 0;

    /* JADX INFO: compiled from: source.java */
    public static class Builder {
        private String[] Ol;
        private String UFX;
        private String WH;
        private boolean pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private String f27658sc;
        private int zY;
        private int We = -1;
        private int ExN = -1;
        private int TRI = -1;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private int f27657qr = 0;
        private boolean Qj = false;

        public Builder appIcon(int i11) {
            this.zY = i11;
            return this;
        }

        public Builder appId(String str) {
            this.f27658sc = str;
            return this;
        }

        public PAGConfig build() {
            PAGConfig pAGConfig = new PAGConfig();
            pAGConfig.pFF(this.f27658sc);
            pAGConfig.pFF(this.We);
            pAGConfig.sc(this.zY);
            pAGConfig.ExN(this.f27657qr);
            pAGConfig.pFF(this.Qj);
            pAGConfig.zY(this.ExN);
            pAGConfig.We(this.TRI);
            pAGConfig.sc(this.pFF);
            pAGConfig.zY(this.WH);
            pAGConfig.sc(this.UFX);
            return pAGConfig;
        }

        public Builder debugLog(boolean z11) {
            this.pFF = z11;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.Ol = strArr;
            return this;
        }

        public Builder setChildDirected(@PAGConstant.PAGChildDirectedType int i11) {
            this.We = i11;
            return this;
        }

        public Builder setDoNotSell(@PAGConstant.PAGDoNotSellType int i11) {
            this.TRI = i11;
            return this;
        }

        public Builder setGDPRConsent(@PAGConstant.PAGGDPRConsentType int i11) {
            this.ExN = i11;
            return this;
        }

        public Builder setPackageName(String str) {
            this.WH = str;
            return this;
        }

        public Builder setUserData(String str) {
            this.UFX = str;
            return this;
        }

        public Builder supportMultiProcess(boolean z11) {
            this.Qj = z11;
            return this;
        }

        public Builder titleBarTheme(int i11) {
            this.f27657qr = i11;
            return this;
        }

        public Builder useTextureView(boolean z11) {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public void ExN(int i11) {
        this.f27655qr = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We(int i11) {
        if (i11 < -1 || i11 > 1) {
            i11 = -1;
        }
        this.TRI = i11;
    }

    public static void debugLog(boolean z11) {
        if (II.sc() != null) {
            if (z11) {
                II.sc().ExN(1);
                II.sc().sc();
                return;
            }
            II.sc().ExN(0);
            zY.sc(zY.sc.OFF);
            Tf.zY();
            v8.c.a();
            Dl.pFF();
        }
    }

    public static int getChildDirected() {
        if (cJ.Ol("getCoppa")) {
            return II.sc().pFF();
        }
        return -1;
    }

    public static int getDoNotSell() {
        if (cJ.Ol("getCCPA")) {
            return II.sc().TRI();
        }
        return -1;
    }

    public static int getGDPRConsent() {
        if (!cJ.Ol("getGdpr")) {
            return -1;
        }
        int iZY = II.sc().zY();
        if (iZY == 1) {
            return 0;
        }
        if (iZY == 0) {
            return 1;
        }
        return iZY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(int i11) {
        if (i11 < -1 || i11 > 1) {
            i11 = -1;
        }
        this.We = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(String str) {
        this.f27656sc = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(boolean z11) {
        this.Qj = z11;
        q8.c.i(z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(int i11) {
        this.zY = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(String str) {
        this.WH = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(boolean z11) {
        this.pFF = z11;
    }

    public static void setAppIconId(int i11) {
        if (II.sc() != null) {
            II.sc().TRI(i11);
        }
    }

    public static void setChildDirected(@PAGConstant.PAGChildDirectedType int i11) {
        if (cJ.Ol("setCoppa")) {
            if (i11 < -1 || i11 > 1) {
                i11 = -1;
            }
            II.sc().pFF(i11);
        }
    }

    public static void setDoNotSell(@PAGConstant.PAGDoNotSellType int i11) {
        if (cJ.Ol("setCCPA")) {
            if (i11 < -1 || i11 > 1) {
                i11 = -1;
            }
            II.sc().We(i11);
        }
    }

    public static void setGDPRConsent(@PAGConstant.PAGGDPRConsentType int i11) {
        cJ.Ol("setGdpr");
        if (i11 < -1 || i11 > 1) {
            i11 = -1;
        }
        II.sc().zY(i11);
    }

    public static void setPackageName(String str) {
        UFX = str;
    }

    public static void setUserData(String str) {
        if (II.sc() != null) {
            II.sc().pFF(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY(int i11) {
        if (i11 < -1 || i11 > 1) {
            i11 = -1;
        }
        this.ExN = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY(String str) {
        this.Ol = str;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getAppIconId() {
        return this.zY;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getAppId() {
        return this.f27656sc;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getCcpa() {
        return this.TRI;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getCoppa() {
        return this.We;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getData() {
        return this.WH;
    }

    public boolean getDebugLog() {
        return this.pFF;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getGdpr() {
        return this.ExN;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getPackageName() {
        return TextUtils.isEmpty(this.Ol) ? UFX : this.Ol;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getTitleBarTheme() {
        return this.f27655qr;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public boolean isSupportMultiProcess() {
        return this.Qj;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public boolean isUseTextureView() {
        return true;
    }
}
