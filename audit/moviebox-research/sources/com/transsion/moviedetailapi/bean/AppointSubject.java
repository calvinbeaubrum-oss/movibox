package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import kotlin.Metadata;
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
@Keep
@Metadata
public final class AppointSubject extends Subject {
    private String appointmentDate;

    public AppointSubject(String str) {
        super(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -1, 4194303, null);
        this.appointmentDate = str;
    }

    public static /* synthetic */ AppointSubject copy$default(AppointSubject appointSubject, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = appointSubject.appointmentDate;
        }
        return appointSubject.copy(str);
    }

    public final String component1() {
        return this.appointmentDate;
    }

    public final AppointSubject copy(String str) {
        return new AppointSubject(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AppointSubject) && Intrinsics.b(this.appointmentDate, ((AppointSubject) obj).appointmentDate);
    }

    public final String getAppointmentDate() {
        return this.appointmentDate;
    }

    public int hashCode() {
        String str = this.appointmentDate;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setAppointmentDate(String str) {
        this.appointmentDate = str;
    }

    public String toString() {
        return "AppointSubject(appointmentDate=" + this.appointmentDate + ")";
    }
}
