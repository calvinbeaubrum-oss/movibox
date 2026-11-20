package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class E6 implements Runnable {
    public final /* synthetic */ E7 A00;
    public final /* synthetic */ DownloadAction[] A01;

    public E6(E7 e11, DownloadAction[] downloadActionArr) {
        this.A00 = e11;
        this.A01 = downloadActionArr;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A00.A00.A03) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.A00.A00.A0C);
            this.A00.A00.A0C.clear();
            for (DownloadAction downloadAction : this.A01) {
                this.A00.A00.A02(downloadAction);
            }
            this.A00.A00.A02 = true;
            Iterator it = this.A00.A00.A0D.iterator();
            while (it.hasNext()) {
                ((E9) it.next()).ABk(this.A00.A00);
            }
            if (!arrayList.isEmpty()) {
                this.A00.A00.A0C.addAll(arrayList);
                this.A00.A00.A0B();
            }
            this.A00.A00.A0A();
            for (int i11 = 0; i11 < this.A00.A00.A0C.size(); i11++) {
                ED ed2 = (ED) this.A00.A00.A0C.get(i11);
                if (ed2.A06 == 0) {
                    this.A00.A00.A0D(ed2);
                }
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
