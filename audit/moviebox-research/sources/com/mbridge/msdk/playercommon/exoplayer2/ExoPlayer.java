package com.mbridge.msdk.playercommon.exoplayer2;

import android.os.Looper;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface ExoPlayer extends Player {
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_OFF = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int STATE_BUFFERING = 2;
    public static final int STATE_ENDED = 4;
    public static final int STATE_IDLE = 1;
    public static final int STATE_READY = 3;

    /* JADX INFO: compiled from: source.java */
    public interface EventListener extends Player.EventListener {
    }

    /* JADX INFO: compiled from: source.java */
    public interface ExoPlayerComponent extends PlayerMessage.Target {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class ExoPlayerMessage {
        public final Object message;
        public final int messageType;
        public final PlayerMessage.Target target;

        public ExoPlayerMessage(PlayerMessage.Target target, int i11, Object obj) {
            this.target = target;
            this.messageType = i11;
            this.message = obj;
        }
    }

    void blockingSendMessages(ExoPlayerMessage... exoPlayerMessageArr);

    PlayerMessage createMessage(PlayerMessage.Target target);

    Looper getPlaybackLooper();

    void prepare(MediaSource mediaSource);

    void prepare(MediaSource mediaSource, boolean z11, boolean z12);

    void sendMessages(ExoPlayerMessage... exoPlayerMessageArr);

    void setSeekParameters(SeekParameters seekParameters);
}
