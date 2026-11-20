package com.bytedance.sdk.component.pFF.sc.sc.sc;

import android.text.TextUtils;
import com.bytedance.sdk.component.pFF.sc.Ql;
import com.bytedance.sdk.component.pFF.sc.UFX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends UFX {
    public sc Ol;
    public ExN Qj;

    public We(UFX.sc scVar) {
        super(scVar);
        ExN exN = new ExN();
        this.Qj = exN;
        this.Ol = new sc(exN.pFF());
    }

    @Override // com.bytedance.sdk.component.pFF.sc.UFX
    public com.bytedance.sdk.component.pFF.sc.We sc() {
        return this.Qj;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.UFX
    public com.bytedance.sdk.component.pFF.sc.pFF sc(Ql ql2) {
        ql2.sc(this);
        if (ql2.pFF() == null || ql2.pFF().sc() == null || TextUtils.isEmpty(ql2.pFF().sc().toString())) {
            return null;
        }
        if (sc.f26962sc == null || !sc.f26962sc.pFF() || !this.Ol.ExN() || "setting".equals(ql2.TRI())) {
            pFF pff = new pFF(ql2, this.Qj);
            this.Qj.zY().add(pff);
            return pff;
        }
        pFF pff2 = new pFF(ql2, this.Ol);
        this.Ol.zY().add(pff2);
        return pff2;
    }
}
