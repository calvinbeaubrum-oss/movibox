package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.proxy.IRefreshProxy;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.miniapp.base.MiniAppBaseFragment;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class RefreshProxyImpl implements IRefreshProxy {
    @Override // com.cloud.tmc.integration.proxy.IRefreshProxy
    public void enableLoadMore(TmcFragment tmcFragment, boolean z11) {
        if (tmcFragment instanceof MiniAppBaseFragment) {
            ((MiniAppBaseFragment) tmcFragment).B0(z11);
        }
    }

    @Override // com.cloud.tmc.integration.proxy.IRefreshProxy
    public void enableRefresh(TmcFragment tmcFragment, boolean z11) {
        if (tmcFragment instanceof MiniAppBaseFragment) {
            ((MiniAppBaseFragment) tmcFragment).C0(z11);
        }
    }

    @Override // com.cloud.tmc.integration.proxy.IRefreshProxy
    public boolean startPullDownRefresh(TmcFragment tmcFragment) {
        if (tmcFragment instanceof MiniAppBaseFragment) {
            return ((MiniAppBaseFragment) tmcFragment).l1();
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.proxy.IRefreshProxy
    public boolean stopPullDownRefresh(TmcFragment tmcFragment) {
        if (tmcFragment instanceof MiniAppBaseFragment) {
            return ((MiniAppBaseFragment) tmcFragment).n1();
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.proxy.IRefreshProxy
    public boolean stopPullUpRefresh(TmcFragment tmcFragment) {
        if (tmcFragment instanceof MiniAppBaseFragment) {
            return ((MiniAppBaseFragment) tmcFragment).m1();
        }
        return false;
    }
}
