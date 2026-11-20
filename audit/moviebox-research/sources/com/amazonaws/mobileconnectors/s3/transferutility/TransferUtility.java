package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.VersionInfoUtils;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TransferUtility {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Log f15860g = LogFactory.b(TransferUtility.class);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f15861h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f15862i = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TransferStatusUpdater f15863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TransferDBUtil f15864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConnectivityManager f15865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AmazonS3 f15866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f15867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TransferUtilityOptions f15868f;

    /* JADX INFO: compiled from: source.java */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AmazonS3 f15869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Context f15870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f15871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TransferUtilityOptions f15872d;

        public TransferUtility a() {
            if (this.f15869a == null) {
                throw new IllegalArgumentException("AmazonS3 client is required please set using .s3Client(yourClient)");
            }
            if (this.f15870b == null) {
                throw new IllegalArgumentException("Context is required please set using .context(applicationContext)");
            }
            if (this.f15872d == null) {
                this.f15872d = new TransferUtilityOptions();
            }
            return new TransferUtility(this.f15869a, this.f15870b, this.f15871c, this.f15872d);
        }

        public Builder b(Context context) {
            this.f15870b = context.getApplicationContext();
            return this;
        }

        public Builder c(AmazonS3 amazonS3) {
            this.f15869a = amazonS3;
            return this;
        }
    }

    public TransferUtility(AmazonS3 amazonS3, Context context, String str, TransferUtilityOptions transferUtilityOptions) {
        this.f15866d = amazonS3;
        this.f15867e = str;
        this.f15868f = transferUtilityOptions;
        this.f15864b = new TransferDBUtil(context.getApplicationContext());
        this.f15863a = TransferStatusUpdater.c(context.getApplicationContext());
        TransferThreadPool.b(transferUtilityOptions.getTransferThreadPoolSize());
        this.f15865c = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static <X extends AmazonWebServiceRequest> X a(X x11) {
        x11.getRequestClientOptions().a("TransferService_multipart/" + f() + VersionInfoUtils.c());
        return x11;
    }

    public static <X extends AmazonWebServiceRequest> X b(X x11) {
        x11.getRequestClientOptions().a("TransferService/" + f() + VersionInfoUtils.c());
        return x11;
    }

    public static Builder c() {
        return new Builder();
    }

    public static String f() {
        synchronized (f15861h) {
            try {
                String str = f15862i;
                if (str != null && !str.trim().isEmpty()) {
                    return f15862i.trim() + "/";
                }
                return "";
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean d(int i11) {
        h("cancel_transfer", i11);
        return true;
    }

    public final int e(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        long length = file.length();
        double d11 = length;
        long jMax = (long) Math.max(Math.ceil(d11 / 10000.0d), 5242880.0d);
        int iCeil = ((int) Math.ceil(d11 / jMax)) + 1;
        ContentValues[] contentValuesArr = new ContentValues[iCeil];
        contentValuesArr[0] = this.f15864b.d(str, str2, file, 0L, 0, "", file.length(), 0, objectMetadata, cannedAccessControlList, this.f15868f);
        long j11 = 0;
        int i11 = 1;
        for (int i12 = 1; i12 < iCeil; i12++) {
            long jMin = Math.min(jMax, length);
            length -= jMax;
            contentValuesArr[i12] = this.f15864b.d(str, str2, file, j11, i11, "", jMin, length <= 0 ? 1 : 0, objectMetadata, cannedAccessControlList, this.f15868f);
            j11 += jMax;
            i11++;
        }
        return this.f15864b.a(contentValuesArr);
    }

    public final boolean g(File file) {
        return file != null && file.length() > 5242880;
    }

    public final synchronized void h(String str, int i11) {
        S3ClientReference.b(Integer.valueOf(i11), this.f15866d);
        TransferRecord transferRecordD = this.f15863a.d(i11);
        if (transferRecordD == null) {
            transferRecordD = this.f15864b.j(i11);
            if (transferRecordD == null) {
                f15860g.f("Cannot find transfer with id: " + i11);
                return;
            }
            this.f15863a.b(transferRecordD);
        } else if ("add_transfer".equals(str)) {
            f15860g.j("Transfer has already been added: " + i11);
            return;
        }
        if ("add_transfer".equals(str) || "resume_transfer".equals(str)) {
            transferRecordD.i(this.f15866d, this.f15864b, this.f15863a, this.f15865c);
        } else if ("pause_transfer".equals(str)) {
            transferRecordD.g(this.f15866d, this.f15863a);
        } else if ("cancel_transfer".equals(str)) {
            transferRecordD.b(this.f15866d, this.f15863a);
        } else {
            f15860g.f("Unknown action: " + str);
        }
    }

    public TransferObserver i(String str, String str2, File file) {
        return j(str, str2, file, new ObjectMetadata());
    }

    public TransferObserver j(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return k(str, str2, file, objectMetadata, null);
    }

    public TransferObserver k(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        return l(str, str2, file, objectMetadata, cannedAccessControlList, null);
    }

    public TransferObserver l(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferListener transferListener) {
        if (file == null || file.isDirectory() || !file.exists()) {
            throw new IllegalArgumentException("Invalid file: " + file);
        }
        int iE = g(file) ? e(str, str2, file, objectMetadata, cannedAccessControlList) : Integer.parseInt(this.f15864b.k(TransferType.UPLOAD, str, str2, file, objectMetadata, cannedAccessControlList, this.f15868f).getLastPathSegment());
        TransferObserver transferObserver = new TransferObserver(iE, this.f15864b, str, str2, file, transferListener);
        h("add_transfer", iE);
        return transferObserver;
    }
}
