package com.transsion.http.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class StringCallback extends r {
    public StringCallback() {
    }

    public StringCallback(boolean z11) {
        super(z11);
    }

    public static String C(byte[] bArr, String str) throws UnsupportedEncodingException {
        String str2 = bArr == null ? null : new String(bArr, str);
        return (str2 == null || !str2.startsWith("\ufeff")) ? str2 : str2.substring(1);
    }

    public abstract void D(int i11, String str, Throwable th2);

    public abstract void E(int i11, String str);

    @Override // com.transsion.http.impl.r
    public void o(int i11, byte[] bArr, Throwable th2) {
        o oVar = new o(this, bArr, i11, th2);
        if (m() || l()) {
            oVar.run();
        } else {
            new Thread(oVar).start();
        }
    }

    @Override // com.transsion.http.impl.r
    public void s(Map<String, List<String>> map) {
    }

    @Override // com.transsion.http.impl.r
    public void v(int i11, byte[] bArr) {
        l lVar = new l(this, bArr, i11);
        if (m() || l()) {
            lVar.run();
        } else {
            new Thread(lVar).start();
        }
    }
}
