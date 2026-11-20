package com.permissionx.guolindev.request;

import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.permissionx.guolindev.PermissionX;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class u extends BaseTask {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f48709f = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(PermissionBuilder permissionBuilder) {
        super(permissionBuilder);
        Intrinsics.g(permissionBuilder, "permissionBuilder");
    }

    @Override // com.permissionx.guolindev.request.c
    public void a(List<String> permissions) {
        Intrinsics.g(permissions, "permissions");
        this.f48647a.p(this);
    }

    @Override // com.permissionx.guolindev.request.c
    public void request() {
        boolean zJ;
        if (this.f48647a.B()) {
            if (Build.VERSION.SDK_INT < 29) {
                this.f48647a.f48671f.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
                this.f48647a.f48674i.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                finish();
                return;
            }
            PermissionX permissionX = PermissionX.f48641a;
            if (permissionX.e(this.f48647a.i(), "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                finish();
                return;
            }
            boolean zE = permissionX.e(this.f48647a.i(), "android.permission.ACCESS_FINE_LOCATION");
            boolean zE2 = permissionX.e(this.f48647a.i(), "android.permission.ACCESS_COARSE_LOCATION");
            if (zE || zE2) {
                this.f48647a.getClass();
                if (this.f48647a.f48682q == null) {
                    a(kotlin.collections.g.l());
                    return;
                }
                if (c().getBoolean("android.permission.ACCESS_BACKGROUND_LOCATION", false)) {
                    zJ = ActivityCompat.j(this.f48647a.i(), "android.permission.ACCESS_BACKGROUND_LOCATION");
                } else {
                    c().putBoolean("android.permission.ACCESS_BACKGROUND_LOCATION", true);
                    zJ = true;
                }
                this.f48647a.A(this);
                List<String> listQ = kotlin.collections.g.q("android.permission.ACCESS_BACKGROUND_LOCATION");
                PermissionBuilder permissionBuilder = this.f48647a;
                ao.b bVar = permissionBuilder.f48682q;
                if (bVar != null) {
                    Intrinsics.d(bVar);
                    bVar.a(b(), listQ, true, !zJ);
                    return;
                } else {
                    permissionBuilder.getClass();
                    Intrinsics.d(null);
                    b();
                    throw null;
                }
            }
        }
        finish();
    }
}
