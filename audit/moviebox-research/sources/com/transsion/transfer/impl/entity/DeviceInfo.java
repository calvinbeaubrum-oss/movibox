package com.transsion.transfer.impl.entity;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class DeviceInfo {
    private FileData deviceAvatar;
    private String deviceName;

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public DeviceInfo(FileData fileData, String str) {
        this.deviceAvatar = fileData;
        this.deviceName = str;
    }

    public /* synthetic */ DeviceInfo(FileData fileData, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : fileData, (i11 & 2) != 0 ? null : str);
    }

    public static /* synthetic */ DeviceInfo copy$default(DeviceInfo deviceInfo, FileData fileData, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            fileData = deviceInfo.deviceAvatar;
        }
        if ((i11 & 2) != 0) {
            str = deviceInfo.deviceName;
        }
        return deviceInfo.copy(fileData, str);
    }

    public final FileData component1() {
        return this.deviceAvatar;
    }

    public final String component2() {
        return this.deviceName;
    }

    public final DeviceInfo copy(FileData fileData, String str) {
        return new DeviceInfo(fileData, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return Intrinsics.b(this.deviceAvatar, deviceInfo.deviceAvatar) && Intrinsics.b(this.deviceName, deviceInfo.deviceName);
    }

    public final FileData getDeviceAvatar() {
        return this.deviceAvatar;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public int hashCode() {
        FileData fileData = this.deviceAvatar;
        int iHashCode = (fileData == null ? 0 : fileData.hashCode()) * 31;
        String str = this.deviceName;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setDeviceAvatar(FileData fileData) {
        this.deviceAvatar = fileData;
    }

    public final void setDeviceName(String str) {
        this.deviceName = str;
    }

    public String toString() {
        return "DeviceInfo(deviceAvatar=" + this.deviceAvatar + ", deviceName=" + this.deviceName + ")";
    }
}
