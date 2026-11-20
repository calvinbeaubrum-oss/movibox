package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Za, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1808Za extends AbstractC10574k {
    public static String[] A01 = {"ufm8s7LRmOM7", "sIBwdoM05ajejE", "0NxvrnR7UZDHrBy4xVhLU5lsqzWJ5R3x", "FsILnIqpIa8iE3wffvJrO4tNlZdDmpUd", "wKnqjXSh8f61FKWyknAGi8xlXXoDdiLA", "lpMPMGmveEx5YZPPZgDkriuB4nzdouJK", "fQPzW90JHWOApVaaQbndX59CGXgCnXlm", "Pp9SKBa6RS3IfLIGXA9e4oeVKGHa5CsE"};
    public boolean A00 = true;

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10574k
    public final boolean A0D(AnonymousClass56 anonymousClass56) {
        return !this.A00 || anonymousClass56.A0Z();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10574k
    public final boolean A0E(AnonymousClass56 anonymousClass56, C10564j c10564j, C10564j c10564j2) {
        return (c10564j == null || (c10564j.A01 == c10564j2.A01 && c10564j.A03 == c10564j2.A03)) ? A0R(anonymousClass56) : A0T(anonymousClass56, c10564j.A01, c10564j.A03, c10564j2.A01, c10564j2.A03);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10574k
    public final boolean A0F(AnonymousClass56 anonymousClass56, C10564j c10564j, C10564j c10564j2) {
        int i11 = c10564j.A01;
        int i12 = c10564j.A03;
        View view = anonymousClass56.A0H;
        int left = c10564j2 == null ? view.getLeft() : c10564j2.A01;
        int top = c10564j2 == null ? view.getTop() : c10564j2.A03;
        if (anonymousClass56.A0a() || (i11 == left && i12 == top)) {
            return A0S(anonymousClass56);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return A0T(anonymousClass56, i11, i12, left, top);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10574k
    public final boolean A0G(AnonymousClass56 anonymousClass56, C10564j c10564j, C10564j c10564j2) {
        if (c10564j.A01 != c10564j2.A01 || c10564j.A03 != c10564j2.A03) {
            return A0T(anonymousClass56, c10564j.A01, c10564j.A03, c10564j2.A01, c10564j2.A03);
        }
        A0O(anonymousClass56);
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10574k
    public final boolean A0H(AnonymousClass56 anonymousClass56, AnonymousClass56 anonymousClass57, C10564j c10564j, C10564j c10564j2) {
        int i11;
        int i12;
        int i13 = c10564j.A01;
        int i14 = c10564j.A03;
        if (anonymousClass57.A0f()) {
            i11 = c10564j.A01;
            i12 = c10564j.A03;
        } else {
            i11 = c10564j2.A01;
            i12 = c10564j2.A03;
        }
        if (A01[1].length() != 14) {
            throw new RuntimeException();
        }
        A01[1] = "7F8ns227Orjao7";
        return A0U(anonymousClass56, anonymousClass57, i13, i14, i11, i12);
    }

    public final void A0N(AnonymousClass56 anonymousClass56) {
        A0C(anonymousClass56);
    }

    public final void A0O(AnonymousClass56 anonymousClass56) {
        A0C(anonymousClass56);
    }

    public final void A0P(AnonymousClass56 anonymousClass56) {
        A0C(anonymousClass56);
    }

    public final void A0Q(AnonymousClass56 anonymousClass56, boolean z11) {
        A0C(anonymousClass56);
    }

    public abstract boolean A0R(AnonymousClass56 anonymousClass56);

    public abstract boolean A0S(AnonymousClass56 anonymousClass56);

    public abstract boolean A0T(AnonymousClass56 anonymousClass56, int i11, int i12, int i13, int i14);

    public abstract boolean A0U(AnonymousClass56 anonymousClass56, AnonymousClass56 anonymousClass57, int i11, int i12, int i13, int i14);
}
