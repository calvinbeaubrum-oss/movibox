package com.permissionx.guolindev.request;

import com.permissionx.guolindev.PermissionX;
import java.util.List;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b0 extends BaseTask {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(PermissionBuilder permissionBuilder) {
        super(permissionBuilder);
        Intrinsics.g(permissionBuilder, "permissionBuilder");
    }

    @Override // com.permissionx.guolindev.request.c
    public void a(List<String> permissions) {
        Intrinsics.g(permissions, "permissions");
        this.f48647a.v(this);
    }

    @Override // com.permissionx.guolindev.request.c
    public void request() {
        if (this.f48647a.G()) {
            if (PermissionX.f48641a.b(this.f48647a.i())) {
                finish();
                return;
            }
            this.f48647a.getClass();
            PermissionBuilder permissionBuilder = this.f48647a;
            if (permissionBuilder.f48682q != null) {
                permissionBuilder.A(this);
                List<String> listQ = kotlin.collections.g.q("android.permission.PICTURE_IN_PICTURE");
                PermissionBuilder permissionBuilder2 = this.f48647a;
                ao.b bVar = permissionBuilder2.f48682q;
                if (bVar != null) {
                    Intrinsics.d(bVar);
                    bVar.a(b(), listQ, true, true);
                    return;
                } else {
                    permissionBuilder2.getClass();
                    Intrinsics.d(null);
                    b();
                    throw null;
                }
            }
        }
        finish();
    }
}
