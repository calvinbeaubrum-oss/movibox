package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class UploadPartTask implements Callable<Boolean> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Log f15873g = LogFactory.b(UploadPartTask.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UploadTask.UploadPartTaskMetadata f15874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UploadTask.UploadTaskProgressListener f15875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UploadPartRequest f15876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AmazonS3 f15877d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TransferDBUtil f15878f;

    /* JADX INFO: compiled from: source.java */
    public class UploadPartTaskProgressListener implements ProgressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public UploadTask.UploadTaskProgressListener f15879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f15880b;

        public UploadPartTaskProgressListener(UploadTask.UploadTaskProgressListener uploadTaskProgressListener) {
            this.f15879a = uploadTaskProgressListener;
        }

        @Override // com.amazonaws.event.ProgressListener
        public void a(ProgressEvent progressEvent) {
            if (32 == progressEvent.b()) {
                UploadPartTask.f15873g.d("Reset Event triggered. Resetting the bytesCurrent to 0.");
                this.f15880b = 0L;
            } else {
                this.f15880b += progressEvent.a();
            }
            this.f15879a.b(UploadPartTask.this.f15876c.getPartNumber(), this.f15880b);
        }
    }

    public UploadPartTask(UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata, UploadTask.UploadTaskProgressListener uploadTaskProgressListener, UploadPartRequest uploadPartRequest, AmazonS3 amazonS3, TransferDBUtil transferDBUtil) {
        this.f15874a = uploadPartTaskMetadata;
        this.f15875b = uploadTaskProgressListener;
        this.f15876c = uploadPartRequest;
        this.f15877d = amazonS3;
        this.f15878f = transferDBUtil;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean call() throws Exception {
        try {
            this.f15874a.f15893d = TransferState.IN_PROGRESS;
            this.f15876c.setGeneralProgressListener(new UploadPartTaskProgressListener(this.f15875b));
            UploadPartResult uploadPartResultD = this.f15877d.d(this.f15876c);
            UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata = this.f15874a;
            TransferState transferState = TransferState.PART_COMPLETED;
            uploadPartTaskMetadata.f15893d = transferState;
            this.f15878f.s(this.f15876c.getId(), transferState);
            this.f15878f.q(this.f15876c.getId(), uploadPartResultD.getETag());
            return Boolean.TRUE;
        } catch (Exception e11) {
            Log log = f15873g;
            log.f("Upload part interrupted: " + e11);
            new ProgressEvent(0L).c(32);
            this.f15875b.a(new ProgressEvent(0L));
            try {
                if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                    log.d("Thread: [" + Thread.currentThread().getId() + "]: Network wasn't available.");
                    UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata2 = this.f15874a;
                    TransferState transferState2 = TransferState.WAITING_FOR_NETWORK;
                    uploadPartTaskMetadata2.f15893d = transferState2;
                    this.f15878f.s(this.f15876c.getId(), transferState2);
                    log.d("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                    return Boolean.FALSE;
                }
            } catch (TransferUtilityException e12) {
                f15873g.f("TransferUtilityException: [" + e12 + "]");
            }
            UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata3 = this.f15874a;
            TransferState transferState3 = TransferState.FAILED;
            uploadPartTaskMetadata3.f15893d = transferState3;
            this.f15878f.s(this.f15876c.getId(), transferState3);
            f15873g.e("Encountered error uploading part ", e11);
            throw e11;
        }
    }
}
