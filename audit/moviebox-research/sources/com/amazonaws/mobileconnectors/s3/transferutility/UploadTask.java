package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.SSEAwsKeyManagementParams;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.util.Mimetypes;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class UploadTask implements Callable<Boolean> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Log f15882h = LogFactory.b(UploadTask.class);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<String, CannedAccessControlList> f15883i = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AmazonS3 f15884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TransferRecord f15885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TransferDBUtil f15886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TransferStatusUpdater f15887d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<Integer, UploadPartTaskMetadata> f15888f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<UploadPartRequest> f15889g;

    /* JADX INFO: compiled from: source.java */
    public class UploadPartTaskMetadata {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public UploadPartRequest f15890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Future<Boolean> f15891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f15892c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TransferState f15893d;

        public UploadPartTaskMetadata() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class UploadTaskProgressListener implements ProgressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f15895a;

        public UploadTaskProgressListener(TransferRecord transferRecord) {
            this.f15895a = transferRecord.f15824i;
        }

        @Override // com.amazonaws.event.ProgressListener
        public void a(ProgressEvent progressEvent) {
        }

        public synchronized void b(int i11, long j11) {
            UploadPartTaskMetadata uploadPartTaskMetadata = UploadTask.this.f15888f.get(Integer.valueOf(i11));
            if (uploadPartTaskMetadata == null) {
                UploadTask.f15882h.d("Update received for unknown part. Ignoring.");
                return;
            }
            uploadPartTaskMetadata.f15892c = j11;
            Iterator<Map.Entry<Integer, UploadPartTaskMetadata>> it = UploadTask.this.f15888f.entrySet().iterator();
            long j12 = 0;
            while (it.hasNext()) {
                j12 += it.next().getValue().f15892c;
            }
            if (j12 > this.f15895a) {
                UploadTask.this.f15887d.k(UploadTask.this.f15885b.f15816a, j12, UploadTask.this.f15885b.f15823h, true);
                this.f15895a = j12;
            }
        }
    }

    static {
        for (CannedAccessControlList cannedAccessControlList : CannedAccessControlList.values()) {
            f15883i.put(cannedAccessControlList.toString(), cannedAccessControlList);
        }
    }

    public UploadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater) {
        this.f15885b = transferRecord;
        this.f15884a = amazonS3;
        this.f15886c = transferDBUtil;
        this.f15887d = transferStatusUpdater;
    }

    public static CannedAccessControlList h(String str) {
        if (str == null) {
            return null;
        }
        return f15883i.get(str);
    }

    public final void a(int i11, String str, String str2, String str3) {
        Log log = f15882h;
        log.d("Aborting the multipart since complete multipart failed.");
        try {
            this.f15884a.e(new AbortMultipartUploadRequest(str, str2, str3));
            log.a("Successfully aborted multipart upload: " + i11);
        } catch (AmazonClientException e11) {
            f15882h.g("Failed to abort the multipart upload: " + i11, e11);
        }
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Boolean call() throws Exception {
        try {
            if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                f15882h.d("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                this.f15887d.l(this.f15885b.f15816a, TransferState.WAITING_FOR_NETWORK);
                return Boolean.FALSE;
            }
        } catch (TransferUtilityException e11) {
            f15882h.f("TransferUtilityException: [" + e11 + "]");
        }
        this.f15887d.l(this.f15885b.f15816a, TransferState.IN_PROGRESS);
        TransferRecord transferRecord = this.f15885b;
        int i11 = transferRecord.f15819d;
        if (i11 == 1 && transferRecord.f15822g == 0) {
            return j();
        }
        return i11 == 0 ? k() : Boolean.FALSE;
    }

    public final void f(int i11, String str, String str2, String str3) throws AmazonClientException {
        CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(str, str2, str3, this.f15886c.m(i11));
        TransferUtility.a(completeMultipartUploadRequest);
        this.f15884a.a(completeMultipartUploadRequest);
    }

    public final PutObjectRequest g(TransferRecord transferRecord) {
        File file = new File(transferRecord.f15834s);
        PutObjectRequest putObjectRequest = new PutObjectRequest(transferRecord.f15831p, transferRecord.f15832q, file);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.length());
        String str = transferRecord.f15841z;
        if (str != null) {
            objectMetadata.setCacheControl(str);
        }
        String str2 = transferRecord.f15839x;
        if (str2 != null) {
            objectMetadata.setContentDisposition(str2);
        }
        String str3 = transferRecord.f15840y;
        if (str3 != null) {
            objectMetadata.setContentEncoding(str3);
        }
        String str4 = transferRecord.f15837v;
        if (str4 != null) {
            objectMetadata.setContentType(str4);
        } else {
            objectMetadata.setContentType(Mimetypes.a().b(file));
        }
        String str5 = transferRecord.B;
        if (str5 != null) {
            putObjectRequest.setStorageClass(str5);
        }
        String str6 = transferRecord.D;
        if (str6 != null) {
            objectMetadata.setExpirationTimeRuleId(str6);
        }
        if (transferRecord.E != null) {
            objectMetadata.setHttpExpiresDate(new Date(Long.valueOf(transferRecord.E).longValue()));
        }
        String str7 = transferRecord.F;
        if (str7 != null) {
            objectMetadata.setSSEAlgorithm(str7);
        }
        Map<String, String> map = transferRecord.C;
        if (map != null) {
            objectMetadata.setUserMetadata(map);
            String str8 = transferRecord.C.get("x-amz-tagging");
            if (str8 != null) {
                try {
                    String[] strArrSplit = str8.split("&");
                    ArrayList arrayList = new ArrayList();
                    for (String str9 : strArrSplit) {
                        String[] strArrSplit2 = str9.split("=");
                        arrayList.add(new Tag(strArrSplit2[0], strArrSplit2[1]));
                    }
                    putObjectRequest.setTagging(new ObjectTagging(arrayList));
                } catch (Exception e11) {
                    f15882h.e("Error in passing the object tags as request headers.", e11);
                }
            }
            String str10 = transferRecord.C.get("x-amz-website-redirect-location");
            if (str10 != null) {
                putObjectRequest.setRedirectLocation(str10);
            }
            String str11 = transferRecord.C.get("x-amz-request-payer");
            if (str11 != null) {
                putObjectRequest.setRequesterPays("requester".equals(str11));
            }
        }
        String str12 = transferRecord.H;
        if (str12 != null) {
            objectMetadata.setContentMD5(str12);
        }
        String str13 = transferRecord.G;
        if (str13 != null) {
            putObjectRequest.setSSEAwsKeyManagementParams(new SSEAwsKeyManagementParams(str13));
        }
        putObjectRequest.setMetadata(objectMetadata);
        putObjectRequest.setCannedAcl(h(transferRecord.I));
        return putObjectRequest;
    }

    public final String i(PutObjectRequest putObjectRequest) {
        InitiateMultipartUploadRequest initiateMultipartUploadRequestWithTagging = new InitiateMultipartUploadRequest(putObjectRequest.getBucketName(), putObjectRequest.getKey()).withCannedACL(putObjectRequest.getCannedAcl()).withObjectMetadata(putObjectRequest.getMetadata()).withSSEAwsKeyManagementParams(putObjectRequest.getSSEAwsKeyManagementParams()).withTagging(putObjectRequest.getTagging());
        TransferUtility.a(initiateMultipartUploadRequestWithTagging);
        return this.f15884a.b(initiateMultipartUploadRequestWithTagging).a();
    }

    public final Boolean j() throws ExecutionException {
        long j11;
        String str = this.f15885b.f15835t;
        if (str == null || str.isEmpty()) {
            PutObjectRequest putObjectRequestG = g(this.f15885b);
            TransferUtility.a(putObjectRequestG);
            try {
                this.f15885b.f15835t = i(putObjectRequestG);
                TransferDBUtil transferDBUtil = this.f15886c;
                TransferRecord transferRecord = this.f15885b;
                transferDBUtil.r(transferRecord.f15816a, transferRecord.f15835t);
                j11 = 0;
            } catch (AmazonClientException e11) {
                f15882h.e("Error initiating multipart upload: " + this.f15885b.f15816a + " due to " + e11.getMessage(), e11);
                this.f15887d.i(this.f15885b.f15816a, e11);
                this.f15887d.l(this.f15885b.f15816a, TransferState.FAILED);
                return Boolean.FALSE;
            }
        } else {
            long jL = this.f15886c.l(this.f15885b.f15816a);
            if (jL > 0) {
                f15882h.d(String.format("Resume transfer %d from %d bytes", Integer.valueOf(this.f15885b.f15816a), Long.valueOf(jL)));
            }
            j11 = jL;
        }
        UploadTaskProgressListener uploadTaskProgressListener = new UploadTaskProgressListener(this.f15885b);
        TransferStatusUpdater transferStatusUpdater = this.f15887d;
        TransferRecord transferRecord2 = this.f15885b;
        transferStatusUpdater.k(transferRecord2.f15816a, j11, transferRecord2.f15823h, false);
        TransferDBUtil transferDBUtil2 = this.f15886c;
        TransferRecord transferRecord3 = this.f15885b;
        this.f15889g = transferDBUtil2.g(transferRecord3.f15816a, transferRecord3.f15835t);
        f15882h.d("Multipart upload " + this.f15885b.f15816a + " in " + this.f15889g.size() + " parts.");
        for (UploadPartRequest uploadPartRequest : this.f15889g) {
            TransferUtility.a(uploadPartRequest);
            UploadPartTaskMetadata uploadPartTaskMetadata = new UploadPartTaskMetadata();
            uploadPartTaskMetadata.f15890a = uploadPartRequest;
            uploadPartTaskMetadata.f15892c = 0L;
            uploadPartTaskMetadata.f15893d = TransferState.WAITING;
            this.f15888f.put(Integer.valueOf(uploadPartRequest.getPartNumber()), uploadPartTaskMetadata);
            uploadPartTaskMetadata.f15891b = TransferThreadPool.c(new UploadPartTask(uploadPartTaskMetadata, uploadTaskProgressListener, uploadPartRequest, this.f15884a, this.f15886c));
        }
        try {
            Iterator<UploadPartTaskMetadata> it = this.f15888f.values().iterator();
            boolean zBooleanValue = true;
            while (it.hasNext()) {
                zBooleanValue &= it.next().f15891b.get().booleanValue();
            }
            if (!zBooleanValue) {
                try {
                    if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                        f15882h.d("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                        this.f15887d.l(this.f15885b.f15816a, TransferState.WAITING_FOR_NETWORK);
                        return Boolean.FALSE;
                    }
                } catch (TransferUtilityException e12) {
                    f15882h.f("TransferUtilityException: [" + e12 + "]");
                }
            }
            f15882h.d("Completing the multi-part upload transfer for " + this.f15885b.f15816a);
            try {
                TransferRecord transferRecord4 = this.f15885b;
                f(transferRecord4.f15816a, transferRecord4.f15831p, transferRecord4.f15832q, transferRecord4.f15835t);
                TransferStatusUpdater transferStatusUpdater2 = this.f15887d;
                TransferRecord transferRecord5 = this.f15885b;
                int i11 = transferRecord5.f15816a;
                long j12 = transferRecord5.f15823h;
                transferStatusUpdater2.k(i11, j12, j12, true);
                this.f15887d.l(this.f15885b.f15816a, TransferState.COMPLETED);
                return Boolean.TRUE;
            } catch (AmazonClientException e13) {
                f15882h.e("Failed to complete multipart: " + this.f15885b.f15816a + " due to " + e13.getMessage(), e13);
                TransferRecord transferRecord6 = this.f15885b;
                a(transferRecord6.f15816a, transferRecord6.f15831p, transferRecord6.f15832q, transferRecord6.f15835t);
                this.f15887d.i(this.f15885b.f15816a, e13);
                this.f15887d.l(this.f15885b.f15816a, TransferState.FAILED);
                return Boolean.FALSE;
            }
        } catch (Exception e14) {
            f15882h.f("Upload resulted in an exception. " + e14);
            Iterator<UploadPartTaskMetadata> it2 = this.f15888f.values().iterator();
            while (it2.hasNext()) {
                it2.next().f15891b.cancel(true);
            }
            if (TransferState.PENDING_CANCEL.equals(this.f15885b.f15830o)) {
                TransferStatusUpdater transferStatusUpdater3 = this.f15887d;
                int i12 = this.f15885b.f15816a;
                TransferState transferState = TransferState.CANCELED;
                transferStatusUpdater3.l(i12, transferState);
                f15882h.d("Transfer is " + transferState);
                return Boolean.FALSE;
            }
            if (TransferState.PENDING_PAUSE.equals(this.f15885b.f15830o)) {
                TransferStatusUpdater transferStatusUpdater4 = this.f15887d;
                int i13 = this.f15885b.f15816a;
                TransferState transferState2 = TransferState.PAUSED;
                transferStatusUpdater4.l(i13, transferState2);
                f15882h.d("Transfer is " + transferState2);
                return Boolean.FALSE;
            }
            for (UploadPartTaskMetadata uploadPartTaskMetadata2 : this.f15888f.values()) {
                TransferState transferState3 = TransferState.WAITING_FOR_NETWORK;
                if (transferState3.equals(uploadPartTaskMetadata2.f15893d)) {
                    f15882h.d("Individual part is WAITING_FOR_NETWORK.");
                    this.f15887d.l(this.f15885b.f15816a, transferState3);
                    return Boolean.FALSE;
                }
            }
            try {
                if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                    f15882h.d("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                    this.f15887d.l(this.f15885b.f15816a, TransferState.WAITING_FOR_NETWORK);
                    return Boolean.FALSE;
                }
            } catch (TransferUtilityException e15) {
                f15882h.f("TransferUtilityException: [" + e15 + "]");
            }
            if (RetryUtils.b(e14)) {
                f15882h.d("Transfer is interrupted. " + e14);
                this.f15887d.l(this.f15885b.f15816a, TransferState.FAILED);
                return Boolean.FALSE;
            }
            f15882h.e("Error encountered during multi-part upload: " + this.f15885b.f15816a + " due to " + e14.getMessage(), e14);
            this.f15887d.i(this.f15885b.f15816a, e14);
            this.f15887d.l(this.f15885b.f15816a, TransferState.FAILED);
            return Boolean.FALSE;
        }
    }

    public final Boolean k() {
        PutObjectRequest putObjectRequestG = g(this.f15885b);
        ProgressListener progressListenerF = this.f15887d.f(this.f15885b.f15816a);
        long length = putObjectRequestG.getFile().length();
        TransferUtility.b(putObjectRequestG);
        putObjectRequestG.setGeneralProgressListener(progressListenerF);
        try {
            this.f15884a.f(putObjectRequestG);
            this.f15887d.k(this.f15885b.f15816a, length, length, true);
            this.f15887d.l(this.f15885b.f15816a, TransferState.COMPLETED);
            return Boolean.TRUE;
        } catch (Exception e11) {
            if (TransferState.PENDING_CANCEL.equals(this.f15885b.f15830o)) {
                TransferStatusUpdater transferStatusUpdater = this.f15887d;
                int i11 = this.f15885b.f15816a;
                TransferState transferState = TransferState.CANCELED;
                transferStatusUpdater.l(i11, transferState);
                f15882h.d("Transfer is " + transferState);
                return Boolean.FALSE;
            }
            if (TransferState.PENDING_PAUSE.equals(this.f15885b.f15830o)) {
                TransferStatusUpdater transferStatusUpdater2 = this.f15887d;
                int i12 = this.f15885b.f15816a;
                TransferState transferState2 = TransferState.PAUSED;
                transferStatusUpdater2.l(i12, transferState2);
                f15882h.d("Transfer is " + transferState2);
                new ProgressEvent(0L).c(32);
                progressListenerF.a(new ProgressEvent(0L));
                return Boolean.FALSE;
            }
            try {
                if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                    Log log = f15882h;
                    log.d("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                    this.f15887d.l(this.f15885b.f15816a, TransferState.WAITING_FOR_NETWORK);
                    log.a("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                    new ProgressEvent(0L).c(32);
                    progressListenerF.a(new ProgressEvent(0L));
                    return Boolean.FALSE;
                }
            } catch (TransferUtilityException e12) {
                f15882h.f("TransferUtilityException: [" + e12 + "]");
            }
            if (RetryUtils.b(e11)) {
                f15882h.d("Transfer is interrupted. " + e11);
                this.f15887d.l(this.f15885b.f15816a, TransferState.FAILED);
                return Boolean.FALSE;
            }
            f15882h.a("Failed to upload: " + this.f15885b.f15816a + " due to " + e11.getMessage());
            this.f15887d.i(this.f15885b.f15816a, e11);
            this.f15887d.l(this.f15885b.f15816a, TransferState.FAILED);
            return Boolean.FALSE;
        }
    }
}
