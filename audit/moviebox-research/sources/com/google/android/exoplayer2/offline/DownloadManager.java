package com.google.android.exoplayer2.offline;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class DownloadManager {

    /* JADX INFO: compiled from: source.java */
    public static class Task extends Thread implements com.google.android.exoplayer2.offline.b.a {
        private long contentLength;
        private final com.google.android.exoplayer2.offline.a downloadProgress;
        private final com.google.android.exoplayer2.offline.b downloader;

        @Nullable
        private Exception finalException;

        @Nullable
        private volatile b internalHandler;
        private volatile boolean isCanceled;
        private final boolean isRemove;
        private final int minRetryCount;
        private final DownloadRequest request;

        private Task(DownloadRequest downloadRequest, com.google.android.exoplayer2.offline.b bVar, com.google.android.exoplayer2.offline.a aVar, boolean z11, int i11, b bVar2) {
            this.request = downloadRequest;
            this.downloader = bVar;
            this.isRemove = z11;
            this.minRetryCount = i11;
            this.contentLength = -1L;
        }

        private static int getRetryDelayMillis(int i11) {
            return Math.min((i11 - 1) * 1000, 5000);
        }

        public void cancel(boolean z11) {
            if (this.isCanceled) {
                return;
            }
            this.isCanceled = true;
            this.downloader.cancel();
            interrupt();
        }

        @Override // com.google.android.exoplayer2.offline.b.a
        public void onProgress(long j11, long j12, float f11) {
            throw null;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                try {
                    if (this.isRemove) {
                        this.downloader.remove();
                        return;
                    }
                    while (!this.isCanceled) {
                        try {
                            this.downloader.a(this);
                            return;
                        } catch (IOException unused) {
                            if (!this.isCanceled) {
                                throw null;
                            }
                        }
                    }
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            } catch (Exception e11) {
                this.finalException = e11;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends Handler {
    }
}
