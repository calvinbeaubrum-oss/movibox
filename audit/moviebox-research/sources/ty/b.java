package ty;

import android.text.TextUtils;
import com.transsion.upload.auth.AuthCheckManager;
import com.transsion.upload.bean.TstTokenEntity;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import com.transsion.upload.strategy.AbsUploadStrategy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import uy.c;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f78077a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, AbsUploadStrategy> f78078b = new LinkedHashMap();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements com.transsion.upload.auth.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f78079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UploadFileType f78080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f78081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final WeakReference<ty.a> f78082d;

        public a(String localFilePath, UploadFileType uploadFileType, boolean z11, WeakReference<ty.a> callbackRef) {
            Intrinsics.g(localFilePath, "localFilePath");
            Intrinsics.g(uploadFileType, "uploadFileType");
            Intrinsics.g(callbackRef, "callbackRef");
            this.f78079a = localFilePath;
            this.f78080b = uploadFileType;
            this.f78081c = z11;
            this.f78082d = callbackRef;
        }

        @Override // com.transsion.upload.auth.a
        public void a(TstTokenEntity tstTokenEntity) {
            ty.a aVar = this.f78082d.get();
            if (aVar != null) {
                if (tstTokenEntity == null) {
                    aVar.c(this.f78079a, "TstTokenEntity is empty", "", null);
                    return;
                }
                AbsUploadStrategy absUploadStrategyC = b.f78077a.c(tstTokenEntity.getStorage());
                if (absUploadStrategyC != null) {
                    absUploadStrategyC.j(tstTokenEntity, this.f78079a, this.f78080b, this.f78081c, this.f78082d.get());
                }
            }
        }

        @Override // com.transsion.upload.auth.a
        public void onFail(String str) {
            ty.a aVar = this.f78082d.get();
            if (aVar != null) {
                ty.a.C0857a.a(aVar, this.f78079a, "client authorization failed", null, null, 12, null);
            }
        }
    }

    public final void b() {
        Iterator<Map.Entry<String, AbsUploadStrategy>> it = f78078b.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().b();
        }
    }

    public final AbsUploadStrategy c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, AbsUploadStrategy> map = f78078b;
        if (!map.containsKey(str)) {
            UploadTstTokenStorageType uploadTstTokenStorageType = UploadTstTokenStorageType.TST_TOKEN_STORAGE_OSS;
            if (Intrinsics.b(str, uploadTstTokenStorageType.getType())) {
                map.put(uploadTstTokenStorageType.getType(), new uy.b());
            } else {
                UploadTstTokenStorageType uploadTstTokenStorageType2 = UploadTstTokenStorageType.TST_TOKEN_STORAGE_S3;
                if (Intrinsics.b(str, uploadTstTokenStorageType2.getType())) {
                    map.put(uploadTstTokenStorageType2.getType(), new c());
                }
            }
        }
        return map.get(str);
    }

    public final void d(String localFilePath, UploadFileType uploadFileType, boolean z11, ty.a aVar) {
        Intrinsics.g(localFilePath, "localFilePath");
        Intrinsics.g(uploadFileType, "uploadFileType");
        AuthCheckManager.f59256a.g(new a(localFilePath, uploadFileType, z11, new WeakReference(aVar)));
    }
}
