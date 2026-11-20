package com.transsion.sunflower;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class FSNConfig {

    @SerializedName("banTimeScope")
    private final int[] banTimeScope;

    @SerializedName("deepLink")
    private final String deepLink;

    @SerializedName("delayTime")
    private final long delayTime;

    @SerializedName("effectInterval")
    private final long effectInterval;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("localBanEndHour")
    private final int localBanEndHour;

    @SerializedName("localBanStartHour")
    private final int localBanStartHour;

    @SerializedName("only4SilentUser")
    private final boolean only4SilentUser;

    public FSNConfig(boolean z11, long j11, int[] banTimeScope, int i11, int i12, long j12, boolean z12, String deepLink) {
        Intrinsics.g(banTimeScope, "banTimeScope");
        Intrinsics.g(deepLink, "deepLink");
        this.enable = z11;
        this.delayTime = j11;
        this.banTimeScope = banTimeScope;
        this.localBanStartHour = i11;
        this.localBanEndHour = i12;
        this.effectInterval = j12;
        this.only4SilentUser = z12;
        this.deepLink = deepLink;
    }

    public /* synthetic */ FSNConfig(boolean z11, long j11, int[] iArr, int i11, int i12, long j12, boolean z12, String str, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? false : z11, j11, (i13 & 4) != 0 ? new int[0] : iArr, (i13 & 8) != 0 ? 8 : i11, (i13 & 16) != 0 ? 22 : i12, j12, z12, str);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final long component2() {
        return this.delayTime;
    }

    public final int[] component3() {
        return this.banTimeScope;
    }

    public final int component4() {
        return this.localBanStartHour;
    }

    public final int component5() {
        return this.localBanEndHour;
    }

    public final long component6() {
        return this.effectInterval;
    }

    public final boolean component7() {
        return this.only4SilentUser;
    }

    public final String component8() {
        return this.deepLink;
    }

    public final FSNConfig copy(boolean z11, long j11, int[] banTimeScope, int i11, int i12, long j12, boolean z12, String deepLink) {
        Intrinsics.g(banTimeScope, "banTimeScope");
        Intrinsics.g(deepLink, "deepLink");
        return new FSNConfig(z11, j11, banTimeScope, i11, i12, j12, z12, deepLink);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FSNConfig)) {
            return false;
        }
        FSNConfig fSNConfig = (FSNConfig) obj;
        return this.enable == fSNConfig.enable && this.delayTime == fSNConfig.delayTime && Intrinsics.b(this.banTimeScope, fSNConfig.banTimeScope) && this.localBanStartHour == fSNConfig.localBanStartHour && this.localBanEndHour == fSNConfig.localBanEndHour && this.effectInterval == fSNConfig.effectInterval && this.only4SilentUser == fSNConfig.only4SilentUser && Intrinsics.b(this.deepLink, fSNConfig.deepLink);
    }

    public final int[] getBanTimeScope() {
        return this.banTimeScope;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final long getDelayTime() {
        return this.delayTime;
    }

    public final long getEffectInterval() {
        return this.effectInterval;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getLocalBanEndHour() {
        return this.localBanEndHour;
    }

    public final int getLocalBanStartHour() {
        return this.localBanStartHour;
    }

    public final boolean getOnly4SilentUser() {
        return this.only4SilentUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        boolean z11 = this.enable;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int iA = ((((((((((r11 * 31) + p.a(this.delayTime)) * 31) + Arrays.hashCode(this.banTimeScope)) * 31) + this.localBanStartHour) * 31) + this.localBanEndHour) * 31) + p.a(this.effectInterval)) * 31;
        boolean z12 = this.only4SilentUser;
        return ((iA + (z12 ? 1 : z12)) * 31) + this.deepLink.hashCode();
    }

    public final void setEnable(boolean z11) {
        this.enable = z11;
    }

    public String toString() {
        return "FSNConfig(enable=" + this.enable + ", delayTime=" + this.delayTime + ", banTimeScope=" + Arrays.toString(this.banTimeScope) + ", localBanStartHour=" + this.localBanStartHour + ", localBanEndHour=" + this.localBanEndHour + ", effectInterval=" + this.effectInterval + ", only4SilentUser=" + this.only4SilentUser + ", deepLink=" + this.deepLink + ")";
    }
}
