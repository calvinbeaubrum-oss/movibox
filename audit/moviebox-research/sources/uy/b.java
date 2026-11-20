package uy;

import android.net.Uri;
import android.os.Build;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.constant.ComConstants;
import com.transsion.upload.bean.TstTokenEntity;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import com.transsion.upload.strategy.AbsUploadStrategy;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class b extends AbsUploadStrategy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TstTokenEntity f78649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OSS f78650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinkedHashMap<String, OSSAsyncTask<PutObjectResult>> f78651e = new LinkedHashMap<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements OSSCompletedCallback<PutObjectRequest, PutObjectResult> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f78653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ty.a f78654c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f78655d;

        public a(String str, ty.a aVar, String str2) {
            this.f78653b = str;
            this.f78654c = aVar;
            this.f78655d = str2;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onFailure(PutObjectRequest putObjectRequest, ClientException clientException, ServiceException serviceException) {
            vy.b.f79124a.c(b.this.d() + " --> OSSCompletedCallback() --> onFailure() --> clientException = " + clientException + " --> serviceException = " + serviceException);
            ty.a aVar = this.f78654c;
            if (aVar != null) {
                aVar.c(this.f78655d, clientException != null ? clientException.getMessage() : null, serviceException != null ? serviceException.getMessage() : null, b.this.g());
            }
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult result) {
            Intrinsics.g(result, "result");
            vy.b.f79124a.b(b.this.d() + " --> OSSCompletedCallback() --> onSuccess() --> remotePath = " + this.f78653b);
            ty.a aVar = this.f78654c;
            if (aVar != null) {
                String str = this.f78655d;
                String str2 = this.f78653b;
                String bucketName = putObjectRequest != null ? putObjectRequest.getBucketName() : null;
                if (bucketName == null) {
                    bucketName = "";
                }
                aVar.b(str, str2, bucketName);
            }
        }
    }

    public static final void n(ty.a aVar, String localFilePath, PutObjectRequest putObjectRequest, long j11, long j12) {
        Intrinsics.g(localFilePath, "$localFilePath");
        if (aVar != null) {
            aVar.a(localFilePath, j11, j12);
        }
    }

    @Override // com.transsion.upload.strategy.AbsUploadStrategy
    public void b() {
        Iterator<Map.Entry<String, OSSAsyncTask<PutObjectResult>>> it = this.f78651e.entrySet().iterator();
        while (it.hasNext()) {
            OSSAsyncTask<PutObjectResult> value = it.next().getValue();
            if (value != null) {
                value.cancel();
            }
        }
        this.f78651e.clear();
        vy.b.f79124a.b(d() + " --> cancel() --> end");
    }

    @Override // com.transsion.upload.strategy.AbsUploadStrategy
    public void c(TstTokenEntity tstToken, String localFilePath, UploadFileType uploadFileType, boolean z11, ty.a aVar) {
        Intrinsics.g(tstToken, "tstToken");
        Intrinsics.g(localFilePath, "localFilePath");
        Intrinsics.g(uploadFileType, "uploadFileType");
        m(uploadFileType, localFilePath, z11, aVar);
    }

    @Override // com.transsion.upload.strategy.AbsUploadStrategy
    public UploadTstTokenStorageType g() {
        return UploadTstTokenStorageType.TST_TOKEN_STORAGE_OSS;
    }

    @Override // com.transsion.upload.strategy.AbsUploadStrategy
    public void i(TstTokenEntity tstToken) {
        Intrinsics.g(tstToken, "tstToken");
        this.f78649c = tstToken;
        if (tstToken != null) {
            OSSStsTokenCredentialProvider oSSStsTokenCredentialProvider = new OSSStsTokenCredentialProvider(tstToken.getAccessKeyId(), tstToken.getAccessKeySecret(), tstToken.getSecurityToken());
            ClientConfiguration clientConfiguration = new ClientConfiguration();
            clientConfiguration.setConnectionTimeout(ComConstants.AD_TIMEOUT_MILLIS);
            clientConfiguration.setSocketTimeout(ComConstants.AD_TIMEOUT_MILLIS);
            clientConfiguration.setMaxConcurrentRequest(5);
            clientConfiguration.setMaxErrorRetry(3);
            OSS oss = this.f78650d;
            if (oss == null) {
                this.f78650d = new OSSClient(Utils.a(), tstToken.getEndPoint(), oSSStsTokenCredentialProvider);
            } else if (oss != null) {
                oss.updateCredentialProvider(oSSStsTokenCredentialProvider);
            }
        }
    }

    public final void l(String str, OSSAsyncTask<PutObjectResult> oSSAsyncTask) {
        this.f78651e.put(str, oSSAsyncTask);
    }

    public final void m(UploadFileType uploadFileType, final String str, boolean z11, final ty.a aVar) {
        PutObjectRequest putObjectRequest;
        String strA = a(uploadFileType, str);
        if (Build.VERSION.SDK_INT >= 29) {
            TstTokenEntity tstTokenEntity = this.f78649c;
            putObjectRequest = new PutObjectRequest(tstTokenEntity != null ? tstTokenEntity.getBucket() : null, strA, Uri.fromFile(new File(str)));
        } else {
            TstTokenEntity tstTokenEntity2 = this.f78649c;
            putObjectRequest = new PutObjectRequest(tstTokenEntity2 != null ? tstTokenEntity2.getBucket() : null, strA, str);
        }
        putObjectRequest.setProgressCallback(new OSSProgressCallback() { // from class: uy.a
            @Override // com.alibaba.sdk.android.oss.callback.OSSProgressCallback
            public final void onProgress(Object obj, long j11, long j12) {
                b.n(aVar, str, (PutObjectRequest) obj, j11, j12);
            }
        });
        OSS oss = this.f78650d;
        OSSAsyncTask<PutObjectResult> oSSAsyncTaskAsyncPutObject = oss != null ? oss.asyncPutObject(putObjectRequest, new a(strA, aVar, str)) : null;
        if (z11) {
            l(str, oSSAsyncTaskAsyncPutObject);
        }
    }
}
