package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.AdExperienceType;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.EnumSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1u, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C09901u {
    public int A00;
    public long A01;
    public RewardData A02;
    public JL A03;
    public String A04;
    public String A05;
    public boolean A06;
    public final C8Z A07;
    public final EnumC1403Je A08;
    public final EnumC1405Jg A09;
    public final String A0A;
    public final EnumSet<CacheFlag> A0B;
    public final int A0C;
    public final AdPlacementType A0D;

    public C09901u(String str, EnumC1405Jg enumC1405Jg, AdPlacementType adPlacementType, EnumC1403Je enumC1403Je, int i11, C8Z c8z) {
        this(str, enumC1405Jg, adPlacementType, enumC1403Je, i11, EnumSet.of(CacheFlag.NONE), c8z);
    }

    public C09901u(String str, EnumC1405Jg enumC1405Jg, AdPlacementType adPlacementType, EnumC1403Je enumC1403Je, int i11, EnumSet<CacheFlag> enumSet, C8Z c8z) {
        this.A0A = str;
        this.A0D = adPlacementType;
        this.A08 = enumC1403Je;
        this.A0C = i11;
        this.A0B = enumSet;
        this.A09 = enumC1405Jg;
        this.A00 = -1;
        this.A07 = c8z;
    }

    public final AdPlacementType A00() {
        AdPlacementType adPlacementType = this.A0D;
        if (adPlacementType != null) {
            return adPlacementType;
        }
        EnumC1403Je enumC1403Je = this.A08;
        if (enumC1403Je == null) {
            return AdPlacementType.NATIVE;
        }
        return enumC1403Je == EnumC1403Je.A07 ? AdPlacementType.INTERSTITIAL : AdPlacementType.BANNER;
    }

    public final K1 A01(C1795Yn c1795Yn, C1410Jl c1410Jl, AdExperienceType adExperienceType) {
        String str = this.A0A;
        EnumC1403Je enumC1403Je = this.A08;
        return new K1(c1795Yn, str, enumC1403Je != null ? new LQ(enumC1403Je.A03(), this.A08.A02()) : null, this.A09, this.A0C, c1410Jl, LW.A01(C1384Ih.A0J(c1795Yn)), this.A04, adExperienceType != null ? adExperienceType.getAdExperienceType() : null, this.A07);
    }

    public final void A02(int i11) {
        this.A00 = i11;
    }

    public final void A03(long j11) {
        this.A01 = j11;
    }

    public final void A04(RewardData rewardData) {
        this.A02 = rewardData;
    }

    public final void A05(JL jl2) {
        this.A03 = jl2;
    }

    public final void A06(String str) {
        this.A04 = str;
    }

    public final void A07(String str) {
        this.A05 = str;
    }

    public final void A08(boolean z11) {
        this.A06 = z11;
    }
}
