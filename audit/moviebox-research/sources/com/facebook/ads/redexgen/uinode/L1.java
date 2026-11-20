package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class L1 {
    public static AdError A00(C1401Jb c1401Jb) {
        return c1401Jb.A03().isPublicError() ? new AdError(c1401Jb.A03().getErrorCode(), c1401Jb.A04()) : new AdError(AdErrorType.UNKNOWN_ERROR.getErrorCode(), AdErrorType.UNKNOWN_ERROR.getDefaultErrorMessage());
    }
}
