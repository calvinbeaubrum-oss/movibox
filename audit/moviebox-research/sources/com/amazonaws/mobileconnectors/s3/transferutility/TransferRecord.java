package com.amazonaws.mobileconnectors.s3.transferutility;

import android.database.Cursor;
import android.net.ConnectivityManager;
import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.util.json.JsonUtils;
import com.google.gson.Gson;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class TransferRecord {
    public static final Log M = LogFactory.b(TransferRecord.class);
    public String A;
    public String B;
    public Map<String, String> C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public TransferUtilityOptions J;
    public Future<?> K;
    public Gson L = new Gson();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f15821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f15822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f15823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f15824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f15825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f15826k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f15827l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f15828m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TransferType f15829n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TransferState f15830o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f15831p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f15832q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f15833r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f15834s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f15835t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f15836u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f15837v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f15838w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f15839x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f15840y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f15841z;

    public TransferRecord(int i11) {
        this.f15816a = i11;
    }

    public boolean b(final AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        if (e(this.f15830o)) {
            return false;
        }
        transferStatusUpdater.l(this.f15816a, TransferState.PENDING_CANCEL);
        if (f()) {
            this.K.cancel(true);
        }
        if (TransferType.UPLOAD.equals(this.f15829n) && this.f15819d == 1) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AmazonS3 amazonS4 = amazonS3;
                        TransferRecord transferRecord = TransferRecord.this;
                        amazonS4.e(new AbortMultipartUploadRequest(transferRecord.f15831p, transferRecord.f15832q, transferRecord.f15835t));
                        TransferRecord.M.a("Successfully clean up multipart upload: " + TransferRecord.this.f15816a);
                    } catch (AmazonClientException e11) {
                        TransferRecord.M.g("Failed to abort multiplart upload: " + TransferRecord.this.f15816a, e11);
                    }
                }
            }).start();
        } else if (TransferType.DOWNLOAD.equals(this.f15829n)) {
            new File(this.f15834s).delete();
        }
        return true;
    }

    public final boolean c() {
        return this.f15822g == 0 && !TransferState.COMPLETED.equals(this.f15830o);
    }

    public final boolean d(TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        TransferUtilityOptions transferUtilityOptions;
        if (connectivityManager == null || (transferUtilityOptions = this.J) == null || transferUtilityOptions.getTransferNetworkConnectionType().isConnected(connectivityManager)) {
            return true;
        }
        M.d("Network Connection " + this.J.getTransferNetworkConnectionType() + " is not available.");
        transferStatusUpdater.l(this.f15816a, TransferState.WAITING_FOR_NETWORK);
        return false;
    }

    public final boolean e(TransferState transferState) {
        return TransferState.COMPLETED.equals(transferState) || TransferState.FAILED.equals(transferState) || TransferState.CANCELED.equals(transferState);
    }

    public boolean f() {
        Future<?> future = this.K;
        return (future == null || future.isDone()) ? false : true;
    }

    public boolean g(AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        if (e(this.f15830o) || TransferState.PAUSED.equals(this.f15830o)) {
            return false;
        }
        TransferState transferState = TransferState.PENDING_PAUSE;
        if (transferState.equals(this.f15830o)) {
            return false;
        }
        transferStatusUpdater.l(this.f15816a, transferState);
        if (f()) {
            this.K.cancel(true);
        }
        return true;
    }

    public boolean h(AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        boolean zD = d(transferStatusUpdater, connectivityManager);
        boolean z11 = false;
        if (!zD && !e(this.f15830o)) {
            z11 = true;
            if (f()) {
                this.K.cancel(true);
            }
        }
        return z11;
    }

    public boolean i(AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        if (f() || !c() || !d(transferStatusUpdater, connectivityManager)) {
            return false;
        }
        if (this.f15829n.equals(TransferType.DOWNLOAD)) {
            this.K = TransferThreadPool.c(new DownloadTask(this, amazonS3, transferStatusUpdater));
            return true;
        }
        this.K = TransferThreadPool.c(new UploadTask(this, amazonS3, transferDBUtil, transferStatusUpdater));
        return true;
    }

    public void j(Cursor cursor) {
        this.f15816a = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        this.f15817b = cursor.getInt(cursor.getColumnIndexOrThrow("main_upload_id"));
        this.f15829n = TransferType.getType(cursor.getString(cursor.getColumnIndexOrThrow("type")));
        this.f15830o = TransferState.getState(cursor.getString(cursor.getColumnIndexOrThrow("state")));
        this.f15831p = cursor.getString(cursor.getColumnIndexOrThrow("bucket_name"));
        this.f15832q = cursor.getString(cursor.getColumnIndexOrThrow("key"));
        this.f15833r = cursor.getString(cursor.getColumnIndexOrThrow("version_id"));
        this.f15823h = cursor.getLong(cursor.getColumnIndexOrThrow("bytes_total"));
        this.f15824i = cursor.getLong(cursor.getColumnIndexOrThrow("bytes_current"));
        this.f15825j = cursor.getLong(cursor.getColumnIndexOrThrow("speed"));
        this.f15818c = cursor.getInt(cursor.getColumnIndexOrThrow("is_requester_pays"));
        this.f15819d = cursor.getInt(cursor.getColumnIndexOrThrow("is_multipart"));
        this.f15820e = cursor.getInt(cursor.getColumnIndexOrThrow("is_last_part"));
        this.f15821f = cursor.getInt(cursor.getColumnIndexOrThrow("is_encrypted"));
        this.f15822g = cursor.getInt(cursor.getColumnIndexOrThrow("part_num"));
        this.f15836u = cursor.getString(cursor.getColumnIndexOrThrow(DownloadModel.ETAG));
        this.f15834s = cursor.getString(cursor.getColumnIndexOrThrow("file"));
        this.f15835t = cursor.getString(cursor.getColumnIndexOrThrow("multipart_id"));
        this.f15826k = cursor.getLong(cursor.getColumnIndexOrThrow("range_start"));
        this.f15827l = cursor.getLong(cursor.getColumnIndexOrThrow("range_last"));
        this.f15828m = cursor.getLong(cursor.getColumnIndexOrThrow("file_offset"));
        this.f15837v = cursor.getString(cursor.getColumnIndexOrThrow("header_content_type"));
        this.f15838w = cursor.getString(cursor.getColumnIndexOrThrow("header_content_language"));
        this.f15839x = cursor.getString(cursor.getColumnIndexOrThrow("header_content_disposition"));
        this.f15840y = cursor.getString(cursor.getColumnIndexOrThrow("header_content_encoding"));
        this.f15841z = cursor.getString(cursor.getColumnIndexOrThrow("header_cache_control"));
        this.A = cursor.getString(cursor.getColumnIndexOrThrow("header_expire"));
        this.C = JsonUtils.d(cursor.getString(cursor.getColumnIndexOrThrow("user_metadata")));
        this.D = cursor.getString(cursor.getColumnIndexOrThrow("expiration_time_rule_id"));
        this.E = cursor.getString(cursor.getColumnIndexOrThrow("http_expires_date"));
        this.F = cursor.getString(cursor.getColumnIndexOrThrow("sse_algorithm"));
        this.G = cursor.getString(cursor.getColumnIndexOrThrow("kms_key"));
        this.H = cursor.getString(cursor.getColumnIndexOrThrow("content_md5"));
        this.I = cursor.getString(cursor.getColumnIndexOrThrow("canned_acl"));
        this.B = cursor.getString(cursor.getColumnIndexOrThrow("header_storage_class"));
        this.J = (TransferUtilityOptions) this.L.fromJson(cursor.getString(cursor.getColumnIndexOrThrow("transfer_utility_options")), TransferUtilityOptions.class);
    }

    public String toString() {
        return "[id:" + this.f15816a + ",bucketName:" + this.f15831p + ",key:" + this.f15832q + ",file:" + this.f15834s + ",type:" + this.f15829n + ",bytesTotal:" + this.f15823h + ",bytesCurrent:" + this.f15824i + ",fileOffset:" + this.f15828m + ",state:" + this.f15830o + ",cannedAcl:" + this.I + ",mainUploadId:" + this.f15817b + ",isMultipart:" + this.f15819d + ",isLastPart:" + this.f15820e + ",partNumber:" + this.f15822g + ",multipartId:" + this.f15835t + ",eTag:" + this.f15836u + ",storageClass:" + this.B + ",userMetadata:" + this.C.toString() + ",transferUtilityOptions:" + this.L.toJson(this.J) + "]";
    }
}
