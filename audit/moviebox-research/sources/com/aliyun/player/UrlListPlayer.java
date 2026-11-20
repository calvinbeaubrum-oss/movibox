package com.aliyun.player;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface UrlListPlayer extends IListPlayer, UrlPlayer {
    void addUrl(String str, String str2);

    boolean moveTo(String str);

    boolean moveToNext();

    boolean moveToPrev();
}
