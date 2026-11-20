package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class DownloadTask implements Callable<Boolean> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Log f15782d = LogFactory.b(DownloadTask.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AmazonS3 f15783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TransferRecord f15784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TransferStatusUpdater f15785c;

    public DownloadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        this.f15784b = transferRecord;
        this.f15783a = amazonS3;
        this.f15785c = transferStatusUpdater;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean call() throws Throwable {
        try {
            if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                f15782d.d("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                this.f15785c.l(this.f15784b.f15816a, TransferState.WAITING_FOR_NETWORK);
                return Boolean.FALSE;
            }
        } catch (TransferUtilityException e11) {
            f15782d.f("TransferUtilityException: [" + e11 + "]");
        }
        this.f15785c.l(this.f15784b.f15816a, TransferState.IN_PROGRESS);
        ProgressListener progressListenerF = this.f15785c.f(this.f15784b.f15816a);
        try {
            TransferRecord transferRecord = this.f15784b;
            GetObjectRequest getObjectRequest = new GetObjectRequest(transferRecord.f15831p, transferRecord.f15832q);
            TransferUtility.b(getObjectRequest);
            File file = new File(this.f15784b.f15834s);
            long length = file.length();
            if (length > 0) {
                f15782d.a(String.format("Resume transfer %d from %d bytes", Integer.valueOf(this.f15784b.f15816a), Long.valueOf(length)));
                getObjectRequest.setRange(length, -1L);
            }
            getObjectRequest.setGeneralProgressListener(progressListenerF);
            S3Object s3ObjectC = this.f15783a.c(getObjectRequest);
            if (s3ObjectC == null) {
                this.f15785c.i(this.f15784b.f15816a, new IllegalStateException("AmazonS3.getObject returns null"));
                this.f15785c.l(this.f15784b.f15816a, TransferState.FAILED);
                return Boolean.FALSE;
            }
            long instanceLength = s3ObjectC.getObjectMetadata().getInstanceLength();
            this.f15785c.k(this.f15784b.f15816a, length, instanceLength, true);
            b(s3ObjectC.getObjectContent(), file);
            this.f15785c.k(this.f15784b.f15816a, instanceLength, instanceLength, true);
            this.f15785c.l(this.f15784b.f15816a, TransferState.COMPLETED);
            return Boolean.TRUE;
        } catch (Exception e12) {
            if (TransferState.PENDING_CANCEL.equals(this.f15784b.f15830o)) {
                TransferStatusUpdater transferStatusUpdater = this.f15785c;
                int i11 = this.f15784b.f15816a;
                TransferState transferState = TransferState.CANCELED;
                transferStatusUpdater.l(i11, transferState);
                f15782d.d("Transfer is " + transferState);
                return Boolean.FALSE;
            }
            if (TransferState.PENDING_PAUSE.equals(this.f15784b.f15830o)) {
                TransferStatusUpdater transferStatusUpdater2 = this.f15785c;
                int i12 = this.f15784b.f15816a;
                TransferState transferState2 = TransferState.PAUSED;
                transferStatusUpdater2.l(i12, transferState2);
                f15782d.d("Transfer is " + transferState2);
                new ProgressEvent(0L).c(32);
                progressListenerF.a(new ProgressEvent(0L));
                return Boolean.FALSE;
            }
            try {
                if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                    Log log = f15782d;
                    log.d("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                    this.f15785c.l(this.f15784b.f15816a, TransferState.WAITING_FOR_NETWORK);
                    log.a("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                    new ProgressEvent(0L).c(32);
                    progressListenerF.a(new ProgressEvent(0L));
                    return Boolean.FALSE;
                }
            } catch (TransferUtilityException e13) {
                f15782d.f("TransferUtilityException: [" + e13 + "]");
            }
            if (RetryUtils.b(e12)) {
                f15782d.d("Transfer is interrupted. " + e12);
                this.f15785c.l(this.f15784b.f15816a, TransferState.FAILED);
                return Boolean.FALSE;
            }
            f15782d.a("Failed to download: " + this.f15784b.f15816a + " due to " + e12.getMessage());
            this.f15785c.i(this.f15784b.f15816a, e12);
            this.f15785c.l(this.f15784b.f15816a, TransferState.FAILED);
            return Boolean.FALSE;
        }
    }

    public final void b(InputStream inputStream, File file) throws Throwable {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file, file.length() > 0));
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int i11 = inputStream.read(bArr);
                        if (i11 != -1) {
                            bufferedOutputStream2.write(bArr, 0, i11);
                        } else {
                            try {
                                break;
                            } catch (IOException e11) {
                                f15782d.i("got exception", e11);
                            }
                        }
                    }
                    bufferedOutputStream2.close();
                    try {
                        inputStream.close();
                    } catch (IOException e12) {
                        f15782d.i("got exception", e12);
                    }
                } catch (SocketTimeoutException e13) {
                    e = e13;
                    String str = "SocketTimeoutException: Unable to retrieve contents over network: " + e.getMessage();
                    f15782d.f(str);
                    throw new AmazonClientException(str, e);
                } catch (IOException e14) {
                    e = e14;
                    throw new AmazonClientException("Unable to store object contents to disk: " + e.getMessage(), e);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e15) {
                            f15782d.i("got exception", e15);
                        }
                    }
                    if (inputStream == null) {
                        throw th;
                    }
                    try {
                        inputStream.close();
                        throw th;
                    } catch (IOException e16) {
                        f15782d.i("got exception", e16);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (SocketTimeoutException e17) {
            e = e17;
        } catch (IOException e18) {
            e = e18;
        }
    }
}
