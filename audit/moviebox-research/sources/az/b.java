package az;

import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import com.transsion.usercenter.edit.api.RequstUserEntity;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class b extends az.a<com.transsion.usercenter.edit.b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zy.a f13847b = new zy.a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements com.transsion.usercenter.edit.a<String> {
        public a() {
        }

        @Override // com.transsion.usercenter.edit.a
        public void a(String str, String str2) {
            if (b.this.d()) {
                com.transsion.usercenter.edit.b bVarC = b.this.c();
                if (bVarC != null) {
                    bVarC.onEditProfile(false);
                }
                com.transsion.usercenter.edit.b bVarC2 = b.this.c();
                if (bVarC2 != null) {
                    bVarC2.onError(str, str2);
                }
            }
        }

        @Override // com.transsion.usercenter.edit.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(String str, boolean z11, String bucket) {
            com.transsion.usercenter.edit.b bVarC;
            Intrinsics.g(bucket, "bucket");
            if (!b.this.d() || (bVarC = b.this.c()) == null) {
                return;
            }
            bVarC.onEditProfile(true);
        }
    }

    /* JADX INFO: renamed from: az.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0137b implements com.transsion.usercenter.edit.a<UserInfo> {
        public C0137b() {
        }

        @Override // com.transsion.usercenter.edit.a
        public void a(String str, String str2) {
            if (b.this.d()) {
                com.transsion.usercenter.edit.b bVarC = b.this.c();
                if (bVarC != null) {
                    bVarC.onEditProfile(false);
                }
                com.transsion.usercenter.edit.b bVarC2 = b.this.c();
                if (bVarC2 != null) {
                    bVarC2.onError(str, str2);
                }
            }
        }

        @Override // com.transsion.usercenter.edit.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(UserInfo userInfo, boolean z11, String bucket) {
            Intrinsics.g(bucket, "bucket");
            if (b.this.d()) {
                if (userInfo != null) {
                    com.transsion.usercenter.edit.b bVarC = b.this.c();
                    if (bVarC != null) {
                        bVarC.onUserInfo(userInfo);
                        return;
                    }
                    return;
                }
                com.transsion.usercenter.edit.b bVarC2 = b.this.c();
                if (bVarC2 != null) {
                    bVarC2.onUserInfo(null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements ty.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.transsion.usercenter.edit.a<String> f13850a;

        public c(com.transsion.usercenter.edit.a<String> aVar) {
            this.f13850a = aVar;
        }

        @Override // ty.a
        public void a(String localFilePath, long j11, long j12) {
            Intrinsics.g(localFilePath, "localFilePath");
        }

        @Override // ty.a
        public void b(String localFilePath, String url, String bucket) {
            Intrinsics.g(localFilePath, "localFilePath");
            Intrinsics.g(url, "url");
            Intrinsics.g(bucket, "bucket");
            this.f13850a.b(url, false, bucket);
        }

        @Override // ty.a
        public void c(String localFilePath, String str, String str2, UploadTstTokenStorageType uploadTstTokenStorageType) {
            Intrinsics.g(localFilePath, "localFilePath");
            uo.b.a.g(uo.b.f78622a, "uploadKey: " + localFilePath + "; clientMessage:" + str + "; serviceMessage: " + str2, false, 2, null);
            this.f13850a.a("-1", "clientMessage");
        }
    }

    @Override // az.a
    public void b() {
        super.b();
        ty.b.f78077a.b();
    }

    public final void e(RequstUserEntity entity) {
        Intrinsics.g(entity, "entity");
        zy.a aVar = this.f13847b;
        if (aVar != null) {
            aVar.a(entity, new a());
        }
    }

    public final void f() {
        zy.a aVar = this.f13847b;
        if (aVar != null) {
            aVar.b(new C0137b());
        }
    }

    public final void g(String imagePath, com.transsion.usercenter.edit.a<String> apiCallback) {
        Intrinsics.g(imagePath, "imagePath");
        Intrinsics.g(apiCallback, "apiCallback");
        ty.b.f78077a.d(imagePath, UploadFileType.OBJECT_NAME_IMAGE, true, new c(apiCallback));
    }
}
