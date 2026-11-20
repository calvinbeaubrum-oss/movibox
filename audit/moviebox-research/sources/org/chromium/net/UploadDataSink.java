package org.chromium.net;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class UploadDataSink {
    public abstract void onReadError(Exception exc);

    public abstract void onReadSucceeded(boolean z11);

    public abstract void onRewindError(Exception exc);

    public abstract void onRewindSucceeded();
}
