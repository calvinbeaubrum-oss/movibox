package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.util.json.JsonUtils;
import com.google.gson.Gson;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class TransferDBUtil {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Log f15794b = LogFactory.b(TransferDBUtil.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f15795c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static TransferDBBase f15796d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Gson f15797a = new Gson();

    public TransferDBUtil(Context context) {
        synchronized (f15795c) {
            try {
                if (f15796d == null) {
                    f15796d = new TransferDBBase(context);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int a(ContentValues[] contentValuesArr) {
        TransferDBBase transferDBBase = f15796d;
        return transferDBBase.a(transferDBBase.d(), contentValuesArr);
    }

    public final String b(int i11) {
        if (i11 <= 0) {
            f15794b.f("Cannot create a string of 0 or less placeholders.");
            return null;
        }
        StringBuilder sb2 = new StringBuilder((i11 * 2) - 1);
        sb2.append("?");
        for (int i12 = 1; i12 < i11; i12++) {
            sb2.append(",?");
        }
        return sb2.toString();
    }

    public int c(int i11) {
        return f15796d.b(i(i11), null, null);
    }

    public ContentValues d(String str, String str2, File file, long j11, int i11, String str3, long j12, int i12, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferUtilityOptions transferUtilityOptions) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", TransferType.UPLOAD.toString());
        contentValues.put("state", TransferState.WAITING.toString());
        contentValues.put("bucket_name", str);
        contentValues.put("key", str2);
        contentValues.put("file", file.getAbsolutePath());
        contentValues.put("bytes_current", (Long) 0L);
        contentValues.put("bytes_total", Long.valueOf(j12));
        contentValues.put("is_multipart", (Integer) 1);
        contentValues.put("part_num", Integer.valueOf(i11));
        contentValues.put("file_offset", Long.valueOf(j11));
        contentValues.put("multipart_id", str3);
        contentValues.put("is_last_part", Integer.valueOf(i12));
        contentValues.put("is_encrypted", (Integer) 0);
        contentValues.putAll(e(objectMetadata));
        if (cannedAccessControlList != null) {
            contentValues.put("canned_acl", cannedAccessControlList.toString());
        }
        if (transferUtilityOptions != null) {
            contentValues.put("transfer_utility_options", this.f15797a.toJson(transferUtilityOptions));
        }
        return contentValues;
    }

    public final ContentValues e(ObjectMetadata objectMetadata) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_metadata", JsonUtils.e(objectMetadata.getUserMetadata()));
        contentValues.put("header_content_type", objectMetadata.getContentType());
        contentValues.put("header_content_encoding", objectMetadata.getContentEncoding());
        contentValues.put("header_cache_control", objectMetadata.getCacheControl());
        contentValues.put("content_md5", objectMetadata.getContentMD5());
        contentValues.put("header_content_disposition", objectMetadata.getContentDisposition());
        contentValues.put("sse_algorithm", objectMetadata.getSSEAlgorithm());
        contentValues.put("kms_key", objectMetadata.getSSEAwsKmsKeyId());
        contentValues.put("expiration_time_rule_id", objectMetadata.getExpirationTimeRuleId());
        if (objectMetadata.getHttpExpiresDate() != null) {
            contentValues.put("http_expires_date", String.valueOf(objectMetadata.getHttpExpiresDate().getTime()));
        }
        if (objectMetadata.getStorageClass() != null) {
            contentValues.put("header_storage_class", objectMetadata.getStorageClass());
        }
        return contentValues;
    }

    public final ContentValues f(TransferType transferType, String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferUtilityOptions transferUtilityOptions) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", transferType.toString());
        contentValues.put("state", TransferState.WAITING.toString());
        contentValues.put("bucket_name", str);
        contentValues.put("key", str2);
        contentValues.put("file", file.getAbsolutePath());
        contentValues.put("bytes_current", (Long) 0L);
        if (transferType.equals(TransferType.UPLOAD)) {
            contentValues.put("bytes_total", Long.valueOf(file.length()));
        }
        contentValues.put("is_multipart", (Integer) 0);
        contentValues.put("part_num", (Integer) 0);
        contentValues.put("is_encrypted", (Integer) 0);
        contentValues.putAll(e(objectMetadata));
        if (cannedAccessControlList != null) {
            contentValues.put("canned_acl", cannedAccessControlList.toString());
        }
        if (transferUtilityOptions != null) {
            contentValues.put("transfer_utility_options", this.f15797a.toJson(transferUtilityOptions));
        }
        return contentValues;
    }

    public List<UploadPartRequest> g(int i11, String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorF = null;
        try {
            cursorF = f15796d.f(h(i11), null, null, null, null);
            while (cursorF.moveToNext()) {
                if (!TransferState.PART_COMPLETED.equals(TransferState.getState(cursorF.getString(cursorF.getColumnIndexOrThrow("state"))))) {
                    UploadPartRequest uploadPartRequestWithPartSize = new UploadPartRequest().withId(cursorF.getInt(cursorF.getColumnIndexOrThrow("_id"))).withMainUploadId(cursorF.getInt(cursorF.getColumnIndexOrThrow("main_upload_id"))).withBucketName(cursorF.getString(cursorF.getColumnIndexOrThrow("bucket_name"))).withKey(cursorF.getString(cursorF.getColumnIndexOrThrow("key"))).withUploadId(str).withFile(new File(cursorF.getString(cursorF.getColumnIndexOrThrow("file")))).withFileOffset(cursorF.getLong(cursorF.getColumnIndexOrThrow("file_offset"))).withPartNumber(cursorF.getInt(cursorF.getColumnIndexOrThrow("part_num"))).withPartSize(cursorF.getLong(cursorF.getColumnIndexOrThrow("bytes_total")));
                    boolean z11 = true;
                    if (1 != cursorF.getInt(cursorF.getColumnIndexOrThrow("is_last_part"))) {
                        z11 = false;
                    }
                    arrayList.add(uploadPartRequestWithPartSize.withLastPart(z11));
                }
            }
            cursorF.close();
            return arrayList;
        } catch (Throwable th2) {
            if (cursorF != null) {
                cursorF.close();
            }
            throw th2;
        }
    }

    public Uri h(int i11) {
        return Uri.parse(f15796d.d() + "/part/" + i11);
    }

    public Uri i(int i11) {
        return Uri.parse(f15796d.d() + "/" + i11);
    }

    public TransferRecord j(int i11) throws Throwable {
        Cursor cursor = null;
        TransferRecord transferRecord = null;
        try {
            Cursor cursorN = n(i11);
            try {
                if (cursorN.moveToFirst()) {
                    transferRecord = new TransferRecord(i11);
                    transferRecord.j(cursorN);
                }
                cursorN.close();
                return transferRecord;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorN;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public Uri k(TransferType transferType, String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferUtilityOptions transferUtilityOptions) {
        ContentValues contentValuesF = f(transferType, str, str2, file, objectMetadata, cannedAccessControlList, transferUtilityOptions);
        TransferDBBase transferDBBase = f15796d;
        return transferDBBase.e(transferDBBase.d(), contentValuesF);
    }

    public long l(int i11) {
        Cursor cursorF = null;
        try {
            cursorF = f15796d.f(h(i11), null, null, null, null);
            long j11 = 0;
            while (cursorF.moveToNext()) {
                if (TransferState.PART_COMPLETED.equals(TransferState.getState(cursorF.getString(cursorF.getColumnIndexOrThrow("state"))))) {
                    j11 += cursorF.getLong(cursorF.getColumnIndexOrThrow("bytes_total"));
                }
            }
            cursorF.close();
            return j11;
        } catch (Throwable th2) {
            if (cursorF != null) {
                cursorF.close();
            }
            throw th2;
        }
    }

    public List<PartETag> m(int i11) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorF = null;
        try {
            cursorF = f15796d.f(h(i11), null, null, null, null);
            while (cursorF.moveToNext()) {
                arrayList.add(new PartETag(cursorF.getInt(cursorF.getColumnIndexOrThrow("part_num")), cursorF.getString(cursorF.getColumnIndexOrThrow(DownloadModel.ETAG))));
            }
            cursorF.close();
            return arrayList;
        } catch (Throwable th2) {
            if (cursorF != null) {
                cursorF.close();
            }
            throw th2;
        }
    }

    public Cursor n(int i11) {
        return f15796d.f(i(i11), null, null, null, null);
    }

    public Cursor o(TransferType transferType, TransferState[] transferStateArr) {
        String str;
        String[] strArr;
        int length = transferStateArr.length;
        String strB = b(length);
        int i11 = 0;
        if (transferType == TransferType.ANY) {
            String str2 = "state in (" + strB + ")";
            String[] strArr2 = new String[length];
            while (i11 < length) {
                strArr2[i11] = transferStateArr[i11].toString();
                i11++;
            }
            str = str2;
            strArr = strArr2;
        } else {
            String str3 = "state in (" + strB + ") and type=?";
            String[] strArr3 = new String[length + 1];
            while (i11 < length) {
                strArr3[i11] = transferStateArr[i11].toString();
                i11++;
            }
            strArr3[i11] = transferType.toString();
            str = str3;
            strArr = strArr3;
        }
        TransferDBBase transferDBBase = f15796d;
        return transferDBBase.f(transferDBBase.d(), null, str, strArr, null);
    }

    public int p(int i11, long j11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("bytes_current", Long.valueOf(j11));
        return f15796d.g(i(i11), contentValues, null, null);
    }

    public int q(int i11, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadModel.ETAG, str);
        return f15796d.g(i(i11), contentValues, null, null);
    }

    public int r(int i11, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("multipart_id", str);
        return f15796d.g(i(i11), contentValues, null, null);
    }

    public int s(int i11, TransferState transferState) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", transferState.toString());
        return TransferState.FAILED.equals(transferState) ? f15796d.g(i(i11), contentValues, "state not in (?,?,?,?,?) ", new String[]{TransferState.COMPLETED.toString(), TransferState.PENDING_NETWORK_DISCONNECT.toString(), TransferState.PAUSED.toString(), TransferState.CANCELED.toString(), TransferState.WAITING_FOR_NETWORK.toString()}) : f15796d.g(i(i11), contentValues, null, null);
    }

    public int t(TransferRecord transferRecord) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(transferRecord.f15816a));
        contentValues.put("state", transferRecord.f15830o.toString());
        contentValues.put("bytes_total", Long.valueOf(transferRecord.f15823h));
        contentValues.put("bytes_current", Long.valueOf(transferRecord.f15824i));
        return f15796d.g(i(transferRecord.f15816a), contentValues, null, null);
    }
}
