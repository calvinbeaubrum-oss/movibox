package com.facebook.ads.redexgen.uinode;

import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: assets/audience_network.dex */
public interface MD {
    void A9Q(Intent intent, Bundle bundle, C5V c5v);

    void ACW(boolean z11);

    void ACu(boolean z11);

    void AFT(Bundle bundle);

    String getCurrentClientToken();

    boolean onActivityResult(int i11, int i12, Intent intent);

    void onDestroy();
}
