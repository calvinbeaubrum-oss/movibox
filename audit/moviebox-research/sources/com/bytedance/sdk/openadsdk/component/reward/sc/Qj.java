package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.webkit.DownloadListener;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj {
    public static int pFF = 1;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static int f27866sc = 0;
    public static int zY = 2;

    @Nullable
    private WH ExN;

    @Nullable
    private Ol TRI;
    private final boolean We;

    public Qj(sc scVar, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        boolean zNW = sfl.nW();
        this.We = zNW;
        if (zNW) {
            this.ExN = JPJ.TRI(sfl) ? new qr(scVar) : new WH(scVar);
        } else {
            this.TRI = new Ol(scVar);
        }
    }

    public void BT() {
        if (this.We) {
            WH wh2 = this.ExN;
            if (wh2 != null) {
                wh2.sc();
                return;
            }
            return;
        }
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.sc();
        }
    }

    public void ExN() {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.TRI();
        }
    }

    public void ExN(int i11) {
        if (this.We) {
            WH wh2 = this.ExN;
            if (wh2 != null) {
                wh2.sc(i11);
                return;
            }
            return;
        }
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.sc(i11);
        }
    }

    public void ExN(boolean z11) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.ExN(z11);
        }
    }

    public long Ol() {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            return ol2.Ol();
        }
        return 0L;
    }

    public void Qj() {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.pFF();
        }
    }

    public boolean Qj(int i11) {
        if (this.We && i11 == pFF) {
            WH wh2 = this.ExN;
            if (wh2 != null) {
                return wh2.WH();
            }
            return false;
        }
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            return ol2.Qj();
        }
        return false;
    }

    public void Ql() {
        if (this.We) {
            WH wh2 = this.ExN;
            if (wh2 != null) {
                wh2.We();
                return;
            }
            return;
        }
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.UFX();
        }
    }

    public void SR() {
        if (this.We) {
            WH wh2 = this.ExN;
            if (wh2 != null) {
                wh2.Qj();
                return;
            }
            return;
        }
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.Ql();
        }
    }

    public void TRI() {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.qr();
        }
    }

    public void TRI(int i11) {
        if (this.We) {
            WH wh2 = this.ExN;
            if (wh2 != null) {
                wh2.pFF(i11);
                return;
            }
            return;
        }
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.TRI(i11);
        }
    }

    public void TRI(boolean z11) {
        WH wh2 = this.ExN;
        if (wh2 != null) {
            wh2.zY(z11);
        }
    }

    public void Tf() {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.We();
        }
    }

    public com.bytedance.sdk.openadsdk.Tf.We UFX() {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            return ol2.SR();
        }
        return null;
    }

    public void WH() {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.ExN();
        }
    }

    public com.bytedance.sdk.openadsdk.Sfl.Qj We() {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            return ol2.wjp();
        }
        return null;
    }

    public void We(boolean z11) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.We(z11);
        }
    }

    public boolean We(int i11) {
        if (this.We) {
            WH wh2 = this.ExN;
            if (wh2 != null) {
                return wh2.Ol();
            }
        } else {
            Ol ol2 = this.TRI;
            if (ol2 != null && ol2.Ol() - this.TRI.WH() >= i11) {
                return true;
            }
        }
        return false;
    }

    public void Xc() {
        WH wh2 = this.ExN;
        if (wh2 != null) {
            wh2.UFX();
        }
    }

    public void dE() {
        if (this.We) {
            WH wh2 = this.ExN;
            if (wh2 != null) {
                wh2.ExN();
                return;
            }
            return;
        }
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.Tf();
        }
    }

    public float pFF() {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            return ol2.WH();
        }
        return 0.0f;
    }

    public int pFF(int i11) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            return ol2.We(i11);
        }
        return 0;
    }

    public void pFF(String str) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.pFF(str);
        }
    }

    public void pFF(boolean z11) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.TRI(z11);
        }
    }

    public void qr(int i11) {
        WH wh2;
        if (this.We && i11 != zY && (wh2 = this.ExN) != null) {
            wh2.TRI();
            return;
        }
        Ol ol2 = this.TRI;
        if (ol2 == null || i11 == pFF) {
            return;
        }
        ol2.zY();
    }

    public boolean qr() {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            return ol2.BT();
        }
        return false;
    }

    public void sc(int i11) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.pFF(i11);
        }
    }

    public void sc(int i11, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, boolean z11) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.sc(i11, sfl, z11);
        }
    }

    public void sc(int i11, String str, String str2) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.sc(i11, str, str2);
        }
    }

    public void sc(DownloadListener downloadListener) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.sc(downloadListener);
        }
    }

    public void sc(com.bytedance.sdk.openadsdk.Tf.ExN exN, boolean z11) {
        if (this.We) {
            WH wh2 = this.ExN;
            if (wh2 != null) {
                wh2.pFF(z11);
                return;
            }
            return;
        }
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.sc(exN, z11);
        }
    }

    public void sc(com.bytedance.sdk.openadsdk.core.pFF.ExN exN) {
        if (this.We) {
            WH wh2 = this.ExN;
            if (wh2 != null) {
                wh2.sc(exN);
                return;
            }
            return;
        }
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.sc(exN);
        }
    }

    public void sc(String str) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.zY(str);
        }
    }

    public void sc(JSONObject jSONObject) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.sc(jSONObject);
        }
    }

    public void sc(boolean z11) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.pFF(z11);
        }
    }

    public void sc(boolean z11, String str, int i11) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.sc(z11, str, i11);
        }
    }

    public boolean sc() {
        Ol ol2 = this.TRI;
        return ol2 != null && ol2.Xc();
    }

    public void wjp() {
        WH wh2 = this.ExN;
        if (wh2 != null) {
            wh2.zY();
        }
    }

    public void zY(int i11) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.zY(i11);
        }
    }

    public void zY(String str) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.sc(str);
        }
    }

    public void zY(boolean z11) {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            ol2.sc(z11);
        }
    }

    public boolean zY() {
        Ol ol2 = this.TRI;
        if (ol2 != null) {
            return ol2.dE();
        }
        return true;
    }
}
