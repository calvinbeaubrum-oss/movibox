package com.facebook.ads.redexgen.uinode;

import android.os.Build;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3r, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C10393r extends C1278Eb {
    public C10393r(C1795Yn c1795Yn) {
        super(c1795Yn);
        setCarouselLayoutManager(c1795Yn);
    }

    private void setCarouselLayoutManager(C1795Yn c1795Yn) {
        C1821Zo c1821Zo = new C1821Zo(c1795Yn, 0, false);
        if (Build.VERSION.SDK_INT >= 24) {
            c1821Zo.A1R(true);
        }
        super.setLayoutManager(c1821Zo);
    }

    public AbstractC1630Sa getFullscreenCarouselRecyclerViewAdapter() {
        getAdapter();
        if (0 == 0) {
            return null;
        }
        getAdapter();
        return null;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1278Eb
    public C1821Zo getLayoutManager() {
        return (C1821Zo) super.getLayoutManager();
    }

    public AbstractC10664t getOnScrollListener() {
        return new US(this);
    }

    @Override // com.facebook.ads.redexgen.uinode.C1278Eb
    public void setLayoutManager(AbstractC10614o abstractC10614o) {
    }
}
