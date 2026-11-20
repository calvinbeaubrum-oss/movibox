package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class M8 implements View.OnClickListener {
    public final /* synthetic */ C09701a A00;
    public final /* synthetic */ JA A01;
    public final /* synthetic */ M9 A02;
    public final /* synthetic */ MC A03;
    public final /* synthetic */ String A04;

    public M8(M9 m11, JA ja2, MC mc2, String str, C09701a c09701a) {
        this.A02 = m11;
        this.A01 = ja2;
        this.A03 = mc2;
        this.A04 = str;
        this.A00 = c09701a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A04(J9.A0A, null);
            if (this.A02.A02.A0O(this.A02.A03.A01(), true)) {
                this.A03.A9M(this.A04, this.A00);
            } else {
                if (TextUtils.isEmpty(this.A00.A00())) {
                    return;
                }
                C1443Kv.A0M(new C1443Kv(), this.A02.A03, AbstractC1446Ky.A00(this.A00.A00()), this.A04);
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
