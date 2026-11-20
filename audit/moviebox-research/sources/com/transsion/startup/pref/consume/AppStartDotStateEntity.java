package com.transsion.startup.pref.consume;

import androidx.annotation.Keep;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class AppStartDotStateEntity implements Serializable {
    public static final a Companion = new a(null);
    public static final int DOT_STATE_END = 3;
    public static final int DOT_STATE_PROCESS = 2;
    public static final int DOT_STATE_START = 1;
    public static final int DOT_TYPE_CONSUME = 3;
    public static final int DOT_TYPE_NET = 2;
    public static final int DOT_TYPE_UI = 1;
    private final String alias;
    private String availMem;
    private String availableSize;
    private Integer coreSize;
    private final int state;
    private String threshold;
    private final long timestamp;
    private String totalMem;
    private String totalSize;
    private long totalTime;
    private final int type;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AppStartDotStateEntity(int i11, String alias, int i12, long j11, long j12, String str, String str2, String str3, String str4, String str5, Integer num) {
        Intrinsics.g(alias, "alias");
        this.state = i11;
        this.alias = alias;
        this.type = i12;
        this.timestamp = j11;
        this.totalTime = j12;
        this.totalMem = str;
        this.availMem = str2;
        this.threshold = str3;
        this.totalSize = str4;
        this.availableSize = str5;
        this.coreSize = num;
    }

    public /* synthetic */ AppStartDotStateEntity(int i11, String str, int i12, long j11, long j12, String str2, String str3, String str4, String str5, String str6, Integer num, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, str, i12, j11, (i13 & 16) != 0 ? 0L : j12, (i13 & 32) != 0 ? "" : str2, (i13 & 64) != 0 ? "" : str3, (i13 & 128) != 0 ? "" : str4, (i13 & 256) != 0 ? "" : str5, (i13 & 512) != 0 ? "" : str6, (i13 & 1024) != 0 ? 0 : num);
    }

    public final int component1() {
        return this.state;
    }

    public final String component10() {
        return this.availableSize;
    }

    public final Integer component11() {
        return this.coreSize;
    }

    public final String component2() {
        return this.alias;
    }

    public final int component3() {
        return this.type;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final long component5() {
        return this.totalTime;
    }

    public final String component6() {
        return this.totalMem;
    }

    public final String component7() {
        return this.availMem;
    }

    public final String component8() {
        return this.threshold;
    }

    public final String component9() {
        return this.totalSize;
    }

    public final AppStartDotStateEntity copy(int i11, String alias, int i12, long j11, long j12, String str, String str2, String str3, String str4, String str5, Integer num) {
        Intrinsics.g(alias, "alias");
        return new AppStartDotStateEntity(i11, alias, i12, j11, j12, str, str2, str3, str4, str5, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppStartDotStateEntity)) {
            return false;
        }
        AppStartDotStateEntity appStartDotStateEntity = (AppStartDotStateEntity) obj;
        return this.state == appStartDotStateEntity.state && Intrinsics.b(this.alias, appStartDotStateEntity.alias) && this.type == appStartDotStateEntity.type && this.timestamp == appStartDotStateEntity.timestamp && this.totalTime == appStartDotStateEntity.totalTime && Intrinsics.b(this.totalMem, appStartDotStateEntity.totalMem) && Intrinsics.b(this.availMem, appStartDotStateEntity.availMem) && Intrinsics.b(this.threshold, appStartDotStateEntity.threshold) && Intrinsics.b(this.totalSize, appStartDotStateEntity.totalSize) && Intrinsics.b(this.availableSize, appStartDotStateEntity.availableSize) && Intrinsics.b(this.coreSize, appStartDotStateEntity.coreSize);
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getAvailMem() {
        return this.availMem;
    }

    public final String getAvailableSize() {
        return this.availableSize;
    }

    public final Integer getCoreSize() {
        return this.coreSize;
    }

    public final int getState() {
        return this.state;
    }

    public final String getThreshold() {
        return this.threshold;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTotalMem() {
        return this.totalMem;
    }

    public final String getTotalSize() {
        return this.totalSize;
    }

    public final long getTotalTime() {
        return this.totalTime;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.state * 31) + this.alias.hashCode()) * 31) + this.type) * 31) + p.a(this.timestamp)) * 31) + p.a(this.totalTime)) * 31;
        String str = this.totalMem;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.availMem;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.threshold;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.totalSize;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.availableSize;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.coreSize;
        return iHashCode6 + (num != null ? num.hashCode() : 0);
    }

    public final void setAvailMem(String str) {
        this.availMem = str;
    }

    public final void setAvailableSize(String str) {
        this.availableSize = str;
    }

    public final void setCoreSize(Integer num) {
        this.coreSize = num;
    }

    public final void setThreshold(String str) {
        this.threshold = str;
    }

    public final void setTotalMem(String str) {
        this.totalMem = str;
    }

    public final void setTotalSize(String str) {
        this.totalSize = str;
    }

    public final void setTotalTime(long j11) {
        this.totalTime = j11;
    }

    public String toString() {
        return "AppStartDotStateEntity(state=" + this.state + ", alias=" + this.alias + ", type=" + this.type + ", timestamp=" + this.timestamp + ", totalTime=" + this.totalTime + ", totalMem=" + this.totalMem + ", availMem=" + this.availMem + ", threshold=" + this.threshold + ", totalSize=" + this.totalSize + ", availableSize=" + this.availableSize + ", coreSize=" + this.coreSize + ")";
    }
}
