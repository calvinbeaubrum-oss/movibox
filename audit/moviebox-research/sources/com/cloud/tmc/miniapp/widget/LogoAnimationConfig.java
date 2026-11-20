package com.cloud.tmc.miniapp.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class LogoAnimationConfig extends rc.b {
    private int loadingAnimMemorySize;
    private Boolean miniAnimateEnable;

    public LogoAnimationConfig(Boolean bool, int i11) {
        this.miniAnimateEnable = bool;
        this.loadingAnimMemorySize = i11;
    }

    public static /* synthetic */ LogoAnimationConfig copy$default(LogoAnimationConfig logoAnimationConfig, Boolean bool, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            bool = logoAnimationConfig.miniAnimateEnable;
        }
        if ((i12 & 2) != 0) {
            i11 = logoAnimationConfig.loadingAnimMemorySize;
        }
        return logoAnimationConfig.copy(bool, i11);
    }

    public final Boolean component1() {
        return this.miniAnimateEnable;
    }

    public final int component2() {
        return this.loadingAnimMemorySize;
    }

    public final LogoAnimationConfig copy(Boolean bool, int i11) {
        return new LogoAnimationConfig(bool, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogoAnimationConfig)) {
            return false;
        }
        LogoAnimationConfig logoAnimationConfig = (LogoAnimationConfig) obj;
        return Intrinsics.b(this.miniAnimateEnable, logoAnimationConfig.miniAnimateEnable) && this.loadingAnimMemorySize == logoAnimationConfig.loadingAnimMemorySize;
    }

    public final int getLoadingAnimMemorySize() {
        return this.loadingAnimMemorySize;
    }

    public final Boolean getMiniAnimateEnable() {
        return this.miniAnimateEnable;
    }

    public int hashCode() {
        Boolean bool = this.miniAnimateEnable;
        return this.loadingAnimMemorySize + ((bool == null ? 0 : bool.hashCode()) * 31);
    }

    public final void setLoadingAnimMemorySize(int i11) {
        this.loadingAnimMemorySize = i11;
    }

    public final void setMiniAnimateEnable(Boolean bool) {
        this.miniAnimateEnable = bool;
    }

    public String toString() {
        StringBuilder sbA = hd.j.a("LogoAnimationConfig(miniAnimateEnable=");
        sbA.append(this.miniAnimateEnable);
        sbA.append(", loadingAnimMemorySize=");
        sbA.append(this.loadingAnimMemorySize);
        sbA.append(')');
        return sbA.toString();
    }
}
