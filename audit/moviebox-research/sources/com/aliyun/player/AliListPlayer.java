package com.aliyun.player;

import com.aliyun.player.source.StsInfo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface AliListPlayer extends UrlListPlayer, AliPlayer {
    void addVid(String str, String str2);

    boolean moveTo(String str, StsInfo stsInfo);

    boolean moveToNext(StsInfo stsInfo);

    boolean moveToPrev(StsInfo stsInfo);

    void setDefinition(String str);
}
