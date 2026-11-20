package androidx.media3.exoplayer.hls;

import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class SampleQueueMappingException extends IOException {
    public SampleQueueMappingException(@Nullable String str) {
        super("Unable to bind a sample queue to TrackGroup with MIME type " + str + InstructionFileId.DOT);
    }
}
