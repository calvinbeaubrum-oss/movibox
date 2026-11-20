package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.kernel.proxy.performanceanalyse.BuildConfigProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class BuildConfigProxyImp implements BuildConfigProxy {
    @Override // com.cloud.tmc.kernel.proxy.performanceanalyse.BuildConfigProxy
    public Boolean isDebug() {
        return Boolean.valueOf(AppDynamicBuildConfig.v());
    }
}
