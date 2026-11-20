package com.permissionx.guolindev.request;

import androidx.core.app.ActivityCompat;
import com.permissionx.guolindev.PermissionX;
import java.util.ArrayList;
import java.util.HashSet;
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
public final class z extends BaseTask {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(PermissionBuilder permissionBuilder) {
        super(permissionBuilder);
        Intrinsics.g(permissionBuilder, "permissionBuilder");
    }

    @Override // com.permissionx.guolindev.request.c
    public void a(List<String> permissions) {
        Intrinsics.g(permissions, "permissions");
        HashSet hashSet = new HashSet(this.f48647a.f48675j);
        hashSet.addAll(permissions);
        if (!hashSet.isEmpty()) {
            this.f48647a.u(hashSet, this);
        } else {
            finish();
        }
    }

    @Override // com.permissionx.guolindev.request.c
    public void request() {
        boolean zJ;
        ArrayList arrayList = new ArrayList();
        for (String str : this.f48647a.f48670e) {
            if (PermissionX.f48641a.e(this.f48647a.i(), str)) {
                this.f48647a.f48675j.add(str);
            } else {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            finish();
            return;
        }
        PermissionBuilder permissionBuilder = this.f48647a;
        if (permissionBuilder.f48672g) {
            permissionBuilder.getClass();
            if (this.f48647a.f48682q != null) {
                if (arrayList.size() == 1) {
                    Object obj = arrayList.get(0);
                    Intrinsics.f(obj, "requestList[0]");
                    String str2 = (String) obj;
                    if (c().getBoolean(str2, false)) {
                        zJ = ActivityCompat.j(this.f48647a.i(), str2);
                    } else {
                        c().putBoolean(str2, true);
                        zJ = true;
                    }
                } else {
                    zJ = true;
                }
                PermissionBuilder permissionBuilder2 = this.f48647a;
                permissionBuilder2.f48672g = false;
                permissionBuilder2.f48676k.addAll(arrayList);
                this.f48647a.A(this);
                PermissionBuilder permissionBuilder3 = this.f48647a;
                ao.b bVar = permissionBuilder3.f48682q;
                if (bVar != null) {
                    Intrinsics.d(bVar);
                    bVar.a(b(), arrayList, true, !zJ);
                    return;
                } else {
                    permissionBuilder3.getClass();
                    Intrinsics.d(null);
                    b();
                    throw null;
                }
            }
        }
        PermissionBuilder permissionBuilder4 = this.f48647a;
        permissionBuilder4.u(permissionBuilder4.f48670e, this);
    }
}
