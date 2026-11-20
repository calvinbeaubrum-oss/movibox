package com.mbridge.msdk.foundation.download;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class DownloadError {
    private Exception exception;

    public DownloadError(Exception exc) {
        this.exception = exc;
    }

    public Exception getException() {
        return this.exception;
    }
}
