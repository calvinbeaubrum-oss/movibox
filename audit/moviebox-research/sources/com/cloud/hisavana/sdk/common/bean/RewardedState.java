package com.cloud.hisavana.sdk.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class RewardedState implements Parcelable {
    public static final Parcelable.Creator<RewardedState> CREATOR = new Creator();
    private long countdownRemainDuration;
    private boolean isAlreadyMeasure;
    private boolean isPaused;
    private boolean isPlayComplete;
    private boolean isPlayStart;
    private boolean isRewarded;
    private boolean isShowRetainDialog;
    private boolean isShowRuDialog;
    private float videoVolume;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Creator implements Parcelable.Creator<RewardedState> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RewardedState createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new RewardedState(parcel.readLong(), parcel.readFloat(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RewardedState[] newArray(int i11) {
            return new RewardedState[i11];
        }
    }

    public RewardedState() {
        this(0L, 0.0f, false, false, false, false, false, false, false, 511, null);
    }

    public RewardedState(long j11, float f11, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
        this.countdownRemainDuration = j11;
        this.videoVolume = f11;
        this.isAlreadyMeasure = z11;
        this.isRewarded = z12;
        this.isPlayStart = z13;
        this.isPlayComplete = z14;
        this.isShowRetainDialog = z15;
        this.isShowRuDialog = z16;
        this.isPaused = z17;
    }

    public /* synthetic */ RewardedState(long j11, float f11, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0L : j11, (i11 & 2) != 0 ? 1.0f : f11, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? false : z12, (i11 & 16) != 0 ? false : z13, (i11 & 32) != 0 ? false : z14, (i11 & 64) != 0 ? false : z15, (i11 & 128) != 0 ? false : z16, (i11 & 256) == 0 ? z17 : false);
    }

    public final long component1() {
        return this.countdownRemainDuration;
    }

    public final float component2() {
        return this.videoVolume;
    }

    public final boolean component3() {
        return this.isAlreadyMeasure;
    }

    public final boolean component4() {
        return this.isRewarded;
    }

    public final boolean component5() {
        return this.isPlayStart;
    }

    public final boolean component6() {
        return this.isPlayComplete;
    }

    public final boolean component7() {
        return this.isShowRetainDialog;
    }

    public final boolean component8() {
        return this.isShowRuDialog;
    }

    public final boolean component9() {
        return this.isPaused;
    }

    public final RewardedState copy(long j11, float f11, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
        return new RewardedState(j11, f11, z11, z12, z13, z14, z15, z16, z17);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardedState)) {
            return false;
        }
        RewardedState rewardedState = (RewardedState) obj;
        return this.countdownRemainDuration == rewardedState.countdownRemainDuration && Float.compare(this.videoVolume, rewardedState.videoVolume) == 0 && this.isAlreadyMeasure == rewardedState.isAlreadyMeasure && this.isRewarded == rewardedState.isRewarded && this.isPlayStart == rewardedState.isPlayStart && this.isPlayComplete == rewardedState.isPlayComplete && this.isShowRetainDialog == rewardedState.isShowRetainDialog && this.isShowRuDialog == rewardedState.isShowRuDialog && this.isPaused == rewardedState.isPaused;
    }

    public final long getCountdownRemainDuration() {
        return this.countdownRemainDuration;
    }

    public final float getVideoVolume() {
        return this.videoVolume;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iA = ((p.a(this.countdownRemainDuration) * 31) + Float.floatToIntBits(this.videoVolume)) * 31;
        boolean z11 = this.isAlreadyMeasure;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iA + r11) * 31;
        boolean z12 = this.isRewarded;
        ?? r12 = z12;
        if (z12) {
            r12 = 1;
        }
        int i12 = (i11 + r12) * 31;
        boolean z13 = this.isPlayStart;
        ?? r13 = z13;
        if (z13) {
            r13 = 1;
        }
        int i13 = (i12 + r13) * 31;
        boolean z14 = this.isPlayComplete;
        ?? r14 = z14;
        if (z14) {
            r14 = 1;
        }
        int i14 = (i13 + r14) * 31;
        boolean z15 = this.isShowRetainDialog;
        ?? r15 = z15;
        if (z15) {
            r15 = 1;
        }
        int i15 = (i14 + r15) * 31;
        boolean z16 = this.isShowRuDialog;
        ?? r16 = z16;
        if (z16) {
            r16 = 1;
        }
        int i16 = (i15 + r16) * 31;
        boolean z17 = this.isPaused;
        return i16 + (z17 ? 1 : z17);
    }

    public final boolean isAlreadyMeasure() {
        return this.isAlreadyMeasure;
    }

    public final boolean isPaused() {
        return this.isPaused;
    }

    public final boolean isPlayComplete() {
        return this.isPlayComplete;
    }

    public final boolean isPlayStart() {
        return this.isPlayStart;
    }

    public final boolean isRewarded() {
        return this.isRewarded;
    }

    public final boolean isShowRetainDialog() {
        return this.isShowRetainDialog;
    }

    public final boolean isShowRuDialog() {
        return this.isShowRuDialog;
    }

    public final void setAlreadyMeasure(boolean z11) {
        this.isAlreadyMeasure = z11;
    }

    public final void setCountdownRemainDuration(long j11) {
        this.countdownRemainDuration = j11;
    }

    public final void setPaused(boolean z11) {
        this.isPaused = z11;
    }

    public final void setPlayComplete(boolean z11) {
        this.isPlayComplete = z11;
    }

    public final void setPlayStart(boolean z11) {
        this.isPlayStart = z11;
    }

    public final void setRewarded(boolean z11) {
        this.isRewarded = z11;
    }

    public final void setShowRetainDialog(boolean z11) {
        this.isShowRetainDialog = z11;
    }

    public final void setShowRuDialog(boolean z11) {
        this.isShowRuDialog = z11;
    }

    public final void setVideoVolume(float f11) {
        this.videoVolume = f11;
    }

    public String toString() {
        return "RewardedState(countdownRemainDuration=" + this.countdownRemainDuration + ", videoVolume=" + this.videoVolume + ", isAlreadyMeasure=" + this.isAlreadyMeasure + ", isRewarded=" + this.isRewarded + ", isPlayStart=" + this.isPlayStart + ", isPlayComplete=" + this.isPlayComplete + ", isShowRetainDialog=" + this.isShowRetainDialog + ", isShowRuDialog=" + this.isShowRuDialog + ", isPaused=" + this.isPaused + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeLong(this.countdownRemainDuration);
        out.writeFloat(this.videoVolume);
        out.writeInt(this.isAlreadyMeasure ? 1 : 0);
        out.writeInt(this.isRewarded ? 1 : 0);
        out.writeInt(this.isPlayStart ? 1 : 0);
        out.writeInt(this.isPlayComplete ? 1 : 0);
        out.writeInt(this.isShowRetainDialog ? 1 : 0);
        out.writeInt(this.isShowRuDialog ? 1 : 0);
        out.writeInt(this.isPaused ? 1 : 0);
    }
}
