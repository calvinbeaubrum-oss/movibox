package com.amazonaws.mobileconnectors.s3.transferutility;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface TransferListener {
    void a(int i11, TransferState transferState);

    void b(int i11, long j11, long j12);

    void c(int i11, Exception exc);
}
