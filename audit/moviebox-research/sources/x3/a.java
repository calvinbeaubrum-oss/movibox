package x3;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.g0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    boolean a(boolean z11);

    g0 b(g0 g0Var);

    AudioProcessor[] getAudioProcessors();

    long getMediaDuration(long j11);

    long getSkippedOutputFrameCount();
}
