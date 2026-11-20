package com.amazonaws.event;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ProgressReportingInputStream extends SdkFilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProgressListenerCallbackExecutor f15709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15711d;

    public ProgressReportingInputStream(InputStream inputStream, ProgressListenerCallbackExecutor progressListenerCallbackExecutor) {
        super(inputStream);
        this.f15708a = 8192;
        this.f15709b = progressListenerCallbackExecutor;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int i11 = this.f15710c;
        if (i11 > 0) {
            this.f15709b.c(new ProgressEvent(i11));
            this.f15710c = 0;
        }
        super.close();
    }

    public final void d(int i11) {
        int i12 = this.f15710c + i11;
        this.f15710c = i12;
        if (i12 >= this.f15708a) {
            this.f15709b.c(new ProgressEvent(i12));
            this.f15710c = 0;
        }
    }

    public final void e() {
        if (this.f15711d) {
            ProgressEvent progressEvent = new ProgressEvent(this.f15710c);
            progressEvent.c(4);
            this.f15710c = 0;
            this.f15709b.c(progressEvent);
        }
    }

    public void g(boolean z11) {
        this.f15711d = z11;
    }

    public void h(int i11) {
        this.f15708a = i11 * 1024;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i11 = super.read();
        if (i11 == -1) {
            e();
        } else {
            d(1);
        }
        return i11;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = super.read(bArr, i11, i12);
        if (i13 == -1) {
            e();
        }
        if (i13 != -1) {
            d(i13);
        }
        return i13;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        ProgressEvent progressEvent = new ProgressEvent(this.f15710c);
        progressEvent.c(32);
        this.f15709b.c(progressEvent);
        this.f15710c = 0;
    }
}
