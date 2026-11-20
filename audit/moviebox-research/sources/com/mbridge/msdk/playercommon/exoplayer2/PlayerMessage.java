package com.mbridge.msdk.playercommon.exoplayer2;

import android.os.Handler;
import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class PlayerMessage {
    private Handler handler;
    private boolean isCanceled;
    private boolean isDelivered;
    private boolean isProcessed;
    private boolean isSent;
    private Object payload;
    private final Sender sender;
    private final Target target;
    private final Timeline timeline;
    private int type;
    private int windowIndex;
    private long positionMs = C.TIME_UNSET;
    private boolean deleteAfterDelivery = true;

    /* JADX INFO: compiled from: source.java */
    public interface Sender {
        void sendMessage(PlayerMessage playerMessage);
    }

    /* JADX INFO: compiled from: source.java */
    public interface Target {
        void handleMessage(int i11, Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(Sender sender, Target target, Timeline timeline, int i11, Handler handler) {
        this.sender = sender;
        this.target = target;
        this.timeline = timeline;
        this.handler = handler;
        this.windowIndex = i11;
    }

    public final synchronized boolean blockUntilDelivered() throws InterruptedException, TimeoutException {
        boolean z11;
        try {
            Assertions.checkState(this.isSent);
            Assertions.checkState(this.handler.getLooper().getThread() != Thread.currentThread());
            long jElapsedRealtime = 500;
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() + 500;
            while (true) {
                z11 = this.isProcessed;
                if (z11 || jElapsedRealtime <= 0) {
                    break;
                }
                wait(jElapsedRealtime);
                jElapsedRealtime = jElapsedRealtime2 - SystemClock.elapsedRealtime();
            }
            if (!z11) {
                throw new TimeoutException("Message delivery time out");
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.isDelivered;
    }

    public final synchronized PlayerMessage cancel() {
        Assertions.checkState(this.isSent);
        this.isCanceled = true;
        markAsProcessed(false);
        return this;
    }

    public final boolean getDeleteAfterDelivery() {
        return this.deleteAfterDelivery;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final Object getPayload() {
        return this.payload;
    }

    public final long getPositionMs() {
        return this.positionMs;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final Timeline getTimeline() {
        return this.timeline;
    }

    public final int getType() {
        return this.type;
    }

    public final int getWindowIndex() {
        return this.windowIndex;
    }

    public final synchronized boolean isCanceled() {
        return this.isCanceled;
    }

    public final synchronized void markAsProcessed(boolean z11) {
        this.isDelivered = z11 | this.isDelivered;
        this.isProcessed = true;
        notifyAll();
    }

    public final PlayerMessage send() {
        Assertions.checkState(!this.isSent);
        if (this.positionMs == C.TIME_UNSET) {
            Assertions.checkArgument(this.deleteAfterDelivery);
        }
        this.isSent = true;
        this.sender.sendMessage(this);
        return this;
    }

    public final PlayerMessage setDeleteAfterDelivery(boolean z11) {
        Assertions.checkState(!this.isSent);
        this.deleteAfterDelivery = z11;
        return this;
    }

    public final PlayerMessage setHandler(Handler handler) {
        Assertions.checkState(!this.isSent);
        this.handler = handler;
        return this;
    }

    public final PlayerMessage setPayload(Object obj) {
        Assertions.checkState(!this.isSent);
        this.payload = obj;
        return this;
    }

    public final PlayerMessage setPosition(int i11, long j11) {
        Assertions.checkState(!this.isSent);
        Assertions.checkArgument(j11 != C.TIME_UNSET);
        if (i11 < 0 || (!this.timeline.isEmpty() && i11 >= this.timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(this.timeline, i11, j11);
        }
        this.windowIndex = i11;
        this.positionMs = j11;
        return this;
    }

    public final PlayerMessage setPosition(long j11) {
        Assertions.checkState(!this.isSent);
        this.positionMs = j11;
        return this;
    }

    public final PlayerMessage setType(int i11) {
        Assertions.checkState(!this.isSent);
        this.type = i11;
        return this;
    }
}
