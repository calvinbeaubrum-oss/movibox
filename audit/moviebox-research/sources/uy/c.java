package uy;

import android.text.TextUtils;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.blankj.utilcode.util.Utils;
import com.transsion.upload.bean.TstTokenEntity;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import com.transsion.upload.strategy.AbsUploadStrategy;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.g;
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
public final class c extends AbsUploadStrategy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TransferUtility f78656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f78657d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinkedHashMap<TransferUtility, List<TransferObserver>> f78658e = new LinkedHashMap<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements TransferListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f78660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ty.a f78661c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f78662d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TransferObserver f78663e;

        /* JADX INFO: renamed from: uy.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class C0871a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f78664a;

            static {
                int[] iArr = new int[TransferState.values().length];
                try {
                    iArr[TransferState.COMPLETED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TransferState.FAILED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[TransferState.CANCELED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f78664a = iArr;
            }
        }

        public a(String str, ty.a aVar, String str2, TransferObserver transferObserver) {
            this.f78660b = str;
            this.f78661c = aVar;
            this.f78662d = str2;
            this.f78663e = transferObserver;
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void a(int i11, TransferState transferState) {
            int i12 = transferState == null ? -1 : C0871a.f78664a[transferState.ordinal()];
            if (i12 == 1) {
                vy.b.f79124a.b(c.this.d() + " --> onStateChanged() --> COMPLETED --> file path == " + this.f78660b + " --> id = " + i11);
                ty.a aVar = this.f78661c;
                if (aVar != null) {
                    String str = this.f78662d;
                    String str2 = this.f78660b;
                    String strE = this.f78663e.e();
                    Intrinsics.f(strE, "transferObserver.bucket");
                    aVar.b(str, str2, strE);
                    return;
                }
                return;
            }
            if (i12 == 2) {
                vy.b.f79124a.c(c.this.d() + " --> onStateChanged() --> FAILED");
                ty.a aVar2 = this.f78661c;
                if (aVar2 != null) {
                    aVar2.c(this.f78662d, "failed", "", c.this.g());
                    return;
                }
                return;
            }
            if (i12 != 3) {
                return;
            }
            vy.b.f79124a.b(c.this.d() + " --> onStateChanged() --> CANCELED --> 取消了");
            ty.a aVar3 = this.f78661c;
            if (aVar3 != null) {
                aVar3.c(this.f78662d, "canceled", "", c.this.g());
            }
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void b(int i11, long j11, long j12) {
            vy.b.f79124a.b(c.this.d() + " --> onProgressChanged() --> id = " + i11 + " --> bytesCurrent = " + j11 + " --> bytesTotal = " + j12);
            ty.a aVar = this.f78661c;
            if (aVar != null) {
                aVar.a(this.f78662d, j11, j12);
            }
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void c(int i11, Exception exc) {
            vy.b.f79124a.b(c.this.d() + " --> onError() --> id = " + i11 + " --> ex = " + (exc != null ? exc.getMessage() : null));
            ty.a aVar = this.f78661c;
            if (aVar != null) {
                aVar.c(this.f78662d, exc != null ? exc.getMessage() : null, "", c.this.g());
            }
        }
    }

    @Override // com.transsion.upload.strategy.AbsUploadStrategy
    public void b() {
        for (Map.Entry<TransferUtility, List<TransferObserver>> entry : this.f78658e.entrySet()) {
            for (TransferObserver transferObserver : entry.getValue()) {
                TransferUtility key = entry.getKey();
                if (key != null) {
                    key.d(transferObserver != null ? transferObserver.f() : 0);
                }
                if (transferObserver != null) {
                    transferObserver.d();
                }
            }
        }
        this.f78658e.clear();
        vy.b.f79124a.b(d() + " --> cancel() --> end");
    }

    @Override // com.transsion.upload.strategy.AbsUploadStrategy
    public void c(TstTokenEntity tstToken, String localFilePath, UploadFileType uploadFileType, boolean z11, ty.a aVar) {
        Intrinsics.g(tstToken, "tstToken");
        Intrinsics.g(localFilePath, "localFilePath");
        Intrinsics.g(uploadFileType, "uploadFileType");
        m(tstToken, localFilePath, uploadFileType, z11, aVar);
    }

    @Override // com.transsion.upload.strategy.AbsUploadStrategy
    public UploadTstTokenStorageType g() {
        return UploadTstTokenStorageType.TST_TOKEN_STORAGE_S3;
    }

    @Override // com.transsion.upload.strategy.AbsUploadStrategy
    public void i(TstTokenEntity tstToken) {
        Intrinsics.g(tstToken, "tstToken");
        if (TextUtils.equals(this.f78657d, tstToken.getAccessKeyId())) {
            return;
        }
        String accessKeyId = tstToken.getAccessKeyId();
        if (accessKeyId == null) {
            accessKeyId = "";
        }
        this.f78657d = accessKeyId;
        l(tstToken);
    }

    public final void k(boolean z11, TransferObserver transferObserver) {
        if (z11) {
            if (!this.f78658e.containsKey(this.f78656c)) {
                this.f78658e.put(this.f78656c, g.q(transferObserver));
                return;
            }
            List<TransferObserver> list = this.f78658e.get(this.f78656c);
            if (list != null) {
                list.add(transferObserver);
            }
        }
    }

    public final void l(TstTokenEntity tstTokenEntity) {
        AmazonS3Client amazonS3Client = new AmazonS3Client(new BasicSessionCredentials(tstTokenEntity.getAccessKeyId(), tstTokenEntity.getAccessKeySecret(), tstTokenEntity.getSecurityToken()), Region.e(Regions.fromName(tstTokenEntity.getRegionId())));
        amazonS3Client.d0(S3ClientOptions.a().b(false).c(true).a());
        this.f78656c = TransferUtility.c().c(amazonS3Client).b(Utils.a()).a();
    }

    public final void m(TstTokenEntity tstTokenEntity, String str, UploadFileType uploadFileType, boolean z11, ty.a aVar) {
        String strA = a(uploadFileType, str);
        TransferUtility transferUtility = this.f78656c;
        TransferObserver transferObserverI = transferUtility != null ? transferUtility.i(tstTokenEntity.getBucket(), strA, new File(str)) : null;
        k(z11, transferObserverI);
        if (transferObserverI != null) {
            transferObserverI.g(new a(strA, aVar, str, transferObserverI));
        }
    }
}
