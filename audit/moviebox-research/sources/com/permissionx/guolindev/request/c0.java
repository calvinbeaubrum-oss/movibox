package com.permissionx.guolindev.request;

import android.os.Build;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
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
public final class c0 extends BaseTask {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(PermissionBuilder permissionBuilder) {
        super(permissionBuilder);
        Intrinsics.g(permissionBuilder, "permissionBuilder");
    }

    @Override // com.permissionx.guolindev.request.c
    public void a(List<String> permissions) {
        Intrinsics.g(permissions, "permissions");
        this.f48647a.w(this);
    }

    @Override // com.permissionx.guolindev.request.c
    public void request() {
        boolean zJ;
        if (!this.f48647a.H()) {
            finish();
            return;
        }
        if (Build.VERSION.SDK_INT < 23 || this.f48647a.l() < 23) {
            this.f48647a.f48675j.add("android.permission.SYSTEM_ALERT_WINDOW");
            this.f48647a.f48671f.remove("android.permission.SYSTEM_ALERT_WINDOW");
            finish();
            return;
        }
        if (Settings.canDrawOverlays(this.f48647a.i())) {
            finish();
            return;
        }
        this.f48647a.getClass();
        if (this.f48647a.f48682q == null) {
            finish();
            return;
        }
        if (c().getBoolean("android.permission.SYSTEM_ALERT_WINDOW", false)) {
            zJ = ActivityCompat.j(this.f48647a.i(), "android.permission.SYSTEM_ALERT_WINDOW");
        } else {
            c().putBoolean("android.permission.SYSTEM_ALERT_WINDOW", true);
            zJ = true;
        }
        this.f48647a.A(this);
        List<String> listQ = kotlin.collections.g.q("android.permission.SYSTEM_ALERT_WINDOW");
        PermissionBuilder permissionBuilder = this.f48647a;
        ao.b bVar = permissionBuilder.f48682q;
        if (bVar != null) {
            Intrinsics.d(bVar);
            bVar.a(b(), listQ, true, !zJ);
        } else {
            permissionBuilder.getClass();
            Intrinsics.d(null);
            b();
            throw null;
        }
    }
}
