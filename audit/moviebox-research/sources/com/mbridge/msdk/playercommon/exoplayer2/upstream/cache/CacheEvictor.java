package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface CacheEvictor extends Cache.Listener {
    void onCacheInitialized();

    void onStartFile(Cache cache, String str, long j11, long j12);
}
