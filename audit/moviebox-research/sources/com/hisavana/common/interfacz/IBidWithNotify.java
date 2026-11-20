package com.hisavana.common.interfacz;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public interface IBidWithNotify {
    String getPayload();

    boolean isExpired();

    void notifyLoss();

    void notifyWin();
}
