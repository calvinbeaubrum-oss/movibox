package com.cloud.hisavana.sdk;

import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class i2 extends com.cloud.hisavana.sdk.common.tranmeasure.g {
    @Override // com.cloud.hisavana.sdk.common.tranmeasure.g
    public int d(b2 b2Var, View view) {
        if (view == null || b2Var == null || !view.getGlobalVisibleRect(this.f29505a)) {
            return 0;
        }
        long jHeight = ((long) this.f29505a.height()) * ((long) this.f29505a.width());
        long height = ((long) view.getHeight()) * ((long) view.getWidth());
        this.f29506b = this.f29505a.width() + "*" + this.f29505a.height();
        if (height <= 0) {
            return 0;
        }
        return (int) ((jHeight * 100) / height);
    }
}
