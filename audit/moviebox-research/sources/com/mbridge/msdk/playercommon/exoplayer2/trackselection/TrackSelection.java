package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.MediaChunk;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface TrackSelection {

    /* JADX INFO: compiled from: source.java */
    public interface Factory {
        TrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr);
    }

    boolean blacklist(int i11, long j11);

    void disable();

    void enable();

    int evaluateQueueSize(long j11, List<? extends MediaChunk> list);

    Format getFormat(int i11);

    int getIndexInTrackGroup(int i11);

    Format getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    Object getSelectionData();

    int getSelectionReason();

    TrackGroup getTrackGroup();

    int indexOf(int i11);

    int indexOf(Format format);

    int length();

    void onPlaybackSpeed(float f11);

    void updateSelectedTrack(long j11, long j12, long j13);
}
