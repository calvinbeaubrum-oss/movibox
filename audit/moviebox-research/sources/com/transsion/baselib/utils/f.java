package com.transsion.baselib.utils;

import com.transsion.player.longvideo.ui.LongVodPlayerView;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements nu.a {
    @Override // nu.a
    public HashSet a() {
        HashSet hashSet = new HashSet();
        hashSet.add("lowMemoryValue");
        hashSet.add(LongVodPlayerView.PK_NEW_PLAYER_UI_KEY);
        hashSet.add("pull_notification_deadline");
        hashSet.add("sb_player_type");
        return hashSet;
    }
}
