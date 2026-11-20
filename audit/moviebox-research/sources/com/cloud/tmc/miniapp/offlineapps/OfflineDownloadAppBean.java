package com.cloud.tmc.miniapp.offlineapps;

import hd.j;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class OfflineDownloadAppBean extends b {
    private String appId;
    private String zipPath;

    public OfflineDownloadAppBean(String appId, String zipPath) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(zipPath, "zipPath");
        this.appId = appId;
        this.zipPath = zipPath;
    }

    public static /* synthetic */ OfflineDownloadAppBean copy$default(OfflineDownloadAppBean offlineDownloadAppBean, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = offlineDownloadAppBean.appId;
        }
        if ((i11 & 2) != 0) {
            str2 = offlineDownloadAppBean.zipPath;
        }
        return offlineDownloadAppBean.copy(str, str2);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.zipPath;
    }

    public final OfflineDownloadAppBean copy(String appId, String zipPath) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(zipPath, "zipPath");
        return new OfflineDownloadAppBean(appId, zipPath);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfflineDownloadAppBean)) {
            return false;
        }
        OfflineDownloadAppBean offlineDownloadAppBean = (OfflineDownloadAppBean) obj;
        return Intrinsics.b(this.appId, offlineDownloadAppBean.appId) && Intrinsics.b(this.zipPath, offlineDownloadAppBean.zipPath);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getZipPath() {
        return this.zipPath;
    }

    public int hashCode() {
        return this.zipPath.hashCode() + (this.appId.hashCode() * 31);
    }

    public final void setAppId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.appId = str;
    }

    public final void setZipPath(String str) {
        Intrinsics.g(str, "<set-?>");
        this.zipPath = str;
    }

    public String toString() {
        StringBuilder sbA = j.a("OfflineDownloadAppBean(appId=");
        sbA.append(this.appId);
        sbA.append(", zipPath=");
        sbA.append(this.zipPath);
        sbA.append(')');
        return sbA.toString();
    }
}
