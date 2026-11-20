package com.bytedance.sdk.component.qr.zY;

import com.bytedance.sdk.component.pFF.sc.BT;
import com.bytedance.sdk.component.pFF.sc.Ql;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr implements com.bytedance.sdk.component.pFF.sc.Qj {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26987sc;

    @Override // com.bytedance.sdk.component.pFF.sc.Qj
    public BT sc(com.bytedance.sdk.component.pFF.sc.Qj.sc scVar) throws IOException {
        BT btSc;
        Exception e11;
        Ql qlSc = scVar.sc();
        if (Qj.sc().sc(this.f26987sc).pFF() != null) {
            Qj.sc().sc(this.f26987sc).pFF().ExN();
        }
        String string = qlSc.pFF().toString();
        String strSc = Qj.sc().sc(this.f26987sc).sc(string);
        if (!string.equals(strSc)) {
            qlSc = qlSc.Ol().pFF(strSc).pFF();
        }
        IOException iOException = null;
        try {
            btSc = scVar.sc(qlSc);
            try {
                if (btSc.zY() == -1) {
                    Qj.sc().sc(this.f26987sc).sc(qlSc, new IOException());
                }
            } catch (Exception e12) {
                e11 = e12;
                IOException iOException2 = new IOException(e11.getMessage());
                Qj.sc().sc(this.f26987sc).sc(qlSc, e11);
                iOException = iOException2;
            }
        } catch (Exception e13) {
            btSc = null;
            e11 = e13;
        }
        Qj.sc().sc(this.f26987sc).sc(qlSc, btSc);
        if (iOException == null) {
            return btSc == null ? scVar.sc(qlSc) : btSc;
        }
        throw iOException;
    }

    public void sc(int i11) {
        this.f26987sc = i11;
    }
}
