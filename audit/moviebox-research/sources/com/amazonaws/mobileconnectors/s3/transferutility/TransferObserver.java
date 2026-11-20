package com.amazonaws.mobileconnectors.s3.transferutility;

import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TransferObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TransferDBUtil f15806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f15808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f15809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f15810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TransferState f15811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f15812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TransferListener f15813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TransferStatusListener f15814j;

    /* JADX INFO: compiled from: source.java */
    public class TransferStatusListener implements TransferListener {
        public TransferStatusListener() {
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void a(int i11, TransferState transferState) {
            TransferObserver.this.f15811g = transferState;
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void b(int i11, long j11, long j12) {
            TransferObserver.this.f15810f = j11;
            TransferObserver.this.f15809e = j12;
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void c(int i11, Exception exc) {
        }
    }

    public TransferObserver(int i11, TransferDBUtil transferDBUtil, String str, String str2, File file) {
        this.f15805a = i11;
        this.f15806b = transferDBUtil;
        this.f15807c = str;
        this.f15808d = str2;
        this.f15812h = file.getAbsolutePath();
        this.f15809e = file.length();
        this.f15811g = TransferState.WAITING;
    }

    public TransferObserver(int i11, TransferDBUtil transferDBUtil, String str, String str2, File file, TransferListener transferListener) {
        this(i11, transferDBUtil, str, str2, file);
        g(transferListener);
    }

    public void d() {
        synchronized (this) {
            try {
                TransferListener transferListener = this.f15813i;
                if (transferListener != null) {
                    TransferStatusUpdater.j(this.f15805a, transferListener);
                    this.f15813i = null;
                }
                TransferStatusListener transferStatusListener = this.f15814j;
                if (transferStatusListener != null) {
                    TransferStatusUpdater.j(this.f15805a, transferStatusListener);
                    this.f15814j = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String e() {
        return this.f15807c;
    }

    public int f() {
        return this.f15805a;
    }

    public void g(TransferListener transferListener) {
        if (transferListener != null) {
            synchronized (this) {
                d();
                TransferStatusListener transferStatusListener = new TransferStatusListener();
                this.f15814j = transferStatusListener;
                TransferStatusUpdater.g(this.f15805a, transferStatusListener);
                this.f15813i = transferListener;
                TransferStatusUpdater.g(this.f15805a, transferListener);
            }
        }
    }

    public String toString() {
        return "TransferObserver{id=" + this.f15805a + ", bucket='" + this.f15807c + "', key='" + this.f15808d + "', bytesTotal=" + this.f15809e + ", bytesTransferred=" + this.f15810f + ", transferState=" + this.f15811g + ", filePath='" + this.f15812h + "'}";
    }
}
