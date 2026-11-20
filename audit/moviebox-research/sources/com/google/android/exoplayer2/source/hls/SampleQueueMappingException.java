package com.google.android.exoplayer2.source.hls;

import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class SampleQueueMappingException extends IOException {
    public SampleQueueMappingException(@Nullable String str) {
        super("Unable to bind a sample queue to TrackGroup with mime type " + str + InstructionFileId.DOT);
    }
}
