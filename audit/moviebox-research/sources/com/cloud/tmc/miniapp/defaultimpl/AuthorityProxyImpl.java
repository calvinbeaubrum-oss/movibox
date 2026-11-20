package com.cloud.tmc.miniapp.defaultimpl;

import android.content.Context;
import com.cloud.tmc.integration.proxy.AuthorityProxy;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.model.permission.ScopesV2Bean;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import com.transsion.al.ka.KaManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class AuthorityProxyImpl implements AuthorityProxy {
    @Override // com.cloud.tmc.integration.proxy.AuthorityProxy
    public boolean checkFullScreenAuthority(Page page) {
        ScopeUtils scopeUtils = ScopeUtils.f31808a;
        ScopesV2Bean scopesV2BeanA = scopeUtils.a(KaManager.NOTIFICATION_GROUP_FULLSCREEN, scopeUtils.c(page));
        TmcLogger.c("AuthorityUtils", "checkFullScreenAuthority: " + scopesV2BeanA);
        return scopesV2BeanA != null;
    }

    @Override // com.cloud.tmc.integration.proxy.AuthorityProxy
    public void clearPermissionData(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        try {
            ScopeUtils.f31808a.n(context, appId);
        } catch (Throwable th2) {
            TmcLogger.g("AuthorityProxyImpl", "clearPermissionData", th2);
        }
    }
}
