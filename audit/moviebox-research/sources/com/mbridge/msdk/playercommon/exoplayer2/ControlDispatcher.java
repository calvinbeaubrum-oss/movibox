package com.mbridge.msdk.playercommon.exoplayer2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface ControlDispatcher {
    boolean dispatchSeekTo(Player player, int i11, long j11);

    boolean dispatchSetPlayWhenReady(Player player, boolean z11);

    boolean dispatchSetRepeatMode(Player player, int i11);

    boolean dispatchSetShuffleModeEnabled(Player player, boolean z11);

    boolean dispatchStop(Player player, boolean z11);
}
