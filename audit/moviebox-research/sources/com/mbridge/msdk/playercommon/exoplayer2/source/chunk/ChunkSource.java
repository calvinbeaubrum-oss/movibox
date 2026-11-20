package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface ChunkSource {
    long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters);

    void getNextChunk(MediaChunk mediaChunk, long j11, long j12, ChunkHolder chunkHolder);

    int getPreferredQueueSize(long j11, List<? extends MediaChunk> list);

    void maybeThrowError() throws IOException;

    void onChunkLoadCompleted(Chunk chunk);

    boolean onChunkLoadError(Chunk chunk, boolean z11, Exception exc);
}
