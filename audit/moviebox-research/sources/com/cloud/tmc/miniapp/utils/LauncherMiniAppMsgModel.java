package com.cloud.tmc.miniapp.utils;

import java.util.ArrayList;
import rc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class LauncherMiniAppMsgModel extends b {
    private LauncherLastlyMessageInfo lastlyMessageInfo;
    private ArrayList<LauncherMiniAppMsgInfoBean> miniappMessageInfos;
    private Boolean successUpdateSwitchStatus = Boolean.TRUE;
    private Long webQueryTimestamp;

    public final LauncherLastlyMessageInfo getLastlyMessageInfo() {
        return this.lastlyMessageInfo;
    }

    public final ArrayList<LauncherMiniAppMsgInfoBean> getMiniappMessageInfos() {
        return this.miniappMessageInfos;
    }

    public final Boolean getSuccessUpdateSwitchStatus() {
        return this.successUpdateSwitchStatus;
    }

    public final Long getWebQueryTimestamp() {
        return this.webQueryTimestamp;
    }

    public final void setLastlyMessageInfo(LauncherLastlyMessageInfo launcherLastlyMessageInfo) {
        this.lastlyMessageInfo = launcherLastlyMessageInfo;
    }

    public final void setMiniappMessageInfos(ArrayList<LauncherMiniAppMsgInfoBean> arrayList) {
        this.miniappMessageInfos = arrayList;
    }

    public final void setSuccessUpdateSwitchStatus(Boolean bool) {
        this.successUpdateSwitchStatus = bool;
    }

    public final void setWebQueryTimestamp(Long l11) {
        this.webQueryTimestamp = l11;
    }
}
