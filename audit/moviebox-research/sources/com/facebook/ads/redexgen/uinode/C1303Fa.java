package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.AdError;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1303Fa extends AbstractC1883aq {
    public static String[] A04 = {"9yCAU6vHH5iW2uzgCW6HgdGPEZSQZZfL", "J47", "6rlZoFx9Uu0Bsrona1cKRXumzm4YYBbS", "bhq", "umQrlUDl61wUXIIBom7yT3QugrS", "j4Wkewb2uBFqLUCHLR63rcK9C", "eNU4QeIs11d2vjS0Im22LGZCKxJhHCKO", "6j5HGQ5u8FmBkqYMwiejF76PKOqfr1XC"};
    public final /* synthetic */ FY A00;
    public final /* synthetic */ AbstractC1902b9 A01;
    public final /* synthetic */ FS A02;
    public final /* synthetic */ boolean A03;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1303Fa(FY fy2, boolean z11, boolean z12, FS fs2, AbstractC1902b9 abstractC1902b9) {
        super(z11);
        this.A00 = fy2;
        this.A03 = z12;
        this.A02 = fs2;
        this.A01 = abstractC1902b9;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1883aq
    public final void A00() {
        this.A00.A01.AD1(this.A01, AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1883aq
    public final void A01(boolean z11) {
        if (C1384Ih.A1R(this.A00.A04) && this.A03) {
            FY fy2 = this.A00;
            fy2.A06 = PC.A01(fy2.A04, this.A02, 0, new C1909bG(this));
            return;
        }
        AtomicBoolean atomicBoolean = this.A00.A0C;
        if (A04[4].length() == 16) {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[1] = "NG7";
        strArr[3] = "cbl";
        atomicBoolean.set(true);
        this.A00.A01.ACy(this.A01);
    }
}
