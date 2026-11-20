package com.cloud.tmc.miniapp.utils;

import java.util.ArrayList;
import rc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class LauncherMiniAppMsgInfoBean extends b {
    private Integer messageInfosSize = 0;
    private String miniappId;
    private ArrayList<LauncherMiniAppMsgInfoDetailBean> miniappMessageInfos;

    public final Integer getMessageInfosSize() {
        return this.messageInfosSize;
    }

    public final String getMiniappId() {
        return this.miniappId;
    }

    public final ArrayList<LauncherMiniAppMsgInfoDetailBean> getMiniappMessageInfos() {
        return this.miniappMessageInfos;
    }

    public final void setMessageInfosSize(Integer num) {
        this.messageInfosSize = num;
    }

    public final void setMiniappId(String str) {
        this.miniappId = str;
    }

    public final void setMiniappMessageInfos(ArrayList<LauncherMiniAppMsgInfoDetailBean> arrayList) {
        this.miniappMessageInfos = arrayList;
    }
}
