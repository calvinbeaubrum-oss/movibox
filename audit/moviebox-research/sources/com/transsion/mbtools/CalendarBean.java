package com.transsion.mbtools;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CalendarBean implements Serializable {
    private String des;
    private Long endTime;
    private String endTimeZone;
    private String location;
    private Integer remindTime;
    private Long startTime;
    private String timeZone;
    private String title;

    public CalendarBean() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public CalendarBean(Long l11, Long l12, String str, String str2, String str3, String str4, String str5, Integer num) {
        this.startTime = l11;
        this.endTime = l12;
        this.title = str;
        this.des = str2;
        this.location = str3;
        this.timeZone = str4;
        this.endTimeZone = str5;
        this.remindTime = num;
    }

    public /* synthetic */ CalendarBean(Long l11, Long l12, String str, String str2, String str3, String str4, String str5, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : l11, (i11 & 2) != 0 ? null : l12, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3, (i11 & 32) != 0 ? null : str4, (i11 & 64) != 0 ? null : str5, (i11 & 128) == 0 ? num : null);
    }

    public final Long component1() {
        return this.startTime;
    }

    public final Long component2() {
        return this.endTime;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.des;
    }

    public final String component5() {
        return this.location;
    }

    public final String component6() {
        return this.timeZone;
    }

    public final String component7() {
        return this.endTimeZone;
    }

    public final Integer component8() {
        return this.remindTime;
    }

    public final CalendarBean copy(Long l11, Long l12, String str, String str2, String str3, String str4, String str5, Integer num) {
        return new CalendarBean(l11, l12, str, str2, str3, str4, str5, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarBean)) {
            return false;
        }
        CalendarBean calendarBean = (CalendarBean) obj;
        return Intrinsics.b(this.startTime, calendarBean.startTime) && Intrinsics.b(this.endTime, calendarBean.endTime) && Intrinsics.b(this.title, calendarBean.title) && Intrinsics.b(this.des, calendarBean.des) && Intrinsics.b(this.location, calendarBean.location) && Intrinsics.b(this.timeZone, calendarBean.timeZone) && Intrinsics.b(this.endTimeZone, calendarBean.endTimeZone) && Intrinsics.b(this.remindTime, calendarBean.remindTime);
    }

    public final String getDes() {
        return this.des;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final String getEndTimeZone() {
        return this.endTimeZone;
    }

    public final String getLocation() {
        return this.location;
    }

    public final Integer getRemindTime() {
        return this.remindTime;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Long l11 = this.startTime;
        int iHashCode = (l11 == null ? 0 : l11.hashCode()) * 31;
        Long l12 = this.endTime;
        int iHashCode2 = (iHashCode + (l12 == null ? 0 : l12.hashCode())) * 31;
        String str = this.title;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.des;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.location;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.timeZone;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.endTimeZone;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.remindTime;
        return iHashCode7 + (num != null ? num.hashCode() : 0);
    }

    public final void setDes(String str) {
        this.des = str;
    }

    public final void setEndTime(Long l11) {
        this.endTime = l11;
    }

    public final void setEndTimeZone(String str) {
        this.endTimeZone = str;
    }

    public final void setLocation(String str) {
        this.location = str;
    }

    public final void setRemindTime(Integer num) {
        this.remindTime = num;
    }

    public final void setStartTime(Long l11) {
        this.startTime = l11;
    }

    public final void setTimeZone(String str) {
        this.timeZone = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "CalendarBean(startTime=" + this.startTime + ", endTime=" + this.endTime + ", title=" + this.title + ", des=" + this.des + ", location=" + this.location + ", timeZone=" + this.timeZone + ", endTimeZone=" + this.endTimeZone + ", remindTime=" + this.remindTime + ")";
    }
}
