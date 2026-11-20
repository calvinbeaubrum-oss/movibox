package com.cloud.tupdate.utils;

import android.content.Context;
import android.os.Bundle;
import com.cloud.tupdate.TUpdate;
import com.cloud.tupdate.bean.AppScoreContent;
import com.cloud.tupdate.bean.UpdateContent;
import com.cloud.tupdate.bean.UpdateEntity;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.ga.AthenaAnalytics;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f32235a = new b();

    public static /* synthetic */ Bundle b(b bVar, Bundle bundle, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bundle = null;
        }
        return bVar.a(bundle);
    }

    public final Bundle a(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        d dVar = d.f32241a;
        bundle.putString(PlaceTypes.COUNTRY, dVar.d());
        bundle.putString("language", dVar.h());
        bundle.putString("brand", dVar.c());
        bundle.putString("os_version", dVar.p());
        bundle.putString("app_version", dVar.j(TUpdate.f32174c.a()));
        return bundle;
    }

    public final void c(Context context, boolean z11) {
        AthenaAnalytics.F(context, "upgradeSdk", 7936, z11, false);
        AthenaAnalytics.N(z11);
        AthenaAnalytics.L(z11);
    }

    public final void d(Bundle bundle) {
        Bundle bundleA = a(bundle);
        bundleA.putString("terminal_type", "sdk");
        bundleA.putString("sdk_channel_id", "");
        new dr.a("upgrade_common_click", 7936).c(bundleA, null).b();
    }

    public final void e(String pageName, String action, int i11) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(action, "action");
        Bundle bundle = new Bundle();
        bundle.putString("page", pageName);
        bundle.putString("action", action);
        bundle.putInt("ignore_type", i11);
        d(bundle);
    }

    public final void f() {
        Bundle bundle = new Bundle();
        bundle.putInt("install_status", 1);
        i("install_status", bundle);
    }

    public final void g(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("user_version", str);
        bundle.putString("update_version", str2);
        i("need_update", bundle);
    }

    public final void h(int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt("reason_code", i11);
        i("no_show_dialog_reason", bundle);
    }

    public final void i(String eventName, Bundle bundle1) {
        Intrinsics.g(eventName, "eventName");
        Intrinsics.g(bundle1, "bundle1");
        Bundle bundleA = a(bundle1);
        bundleA.putString("terminal_type", "sdk");
        bundleA.putString("sdk_channel_id", "");
        new dr.a(eventName, 7936).c(bundleA, null).b();
    }

    public final void j(Bundle bundle) {
        bundle.putString("terminal_type", "sdk");
        bundle.putString("sdk_channel_id", "");
        new dr.a("upgrade_common_exposure", 7936).c(bundle, null).b();
    }

    public final void k(String pageName, UpdateEntity updateEntity) {
        AppScoreContent appScoreContent;
        UpdateContent updateContent;
        UpdateContent updateContent2;
        Intrinsics.g(pageName, "pageName");
        String updateVersion = null;
        Bundle bundleB = b(this, null, 1, null);
        bundleB.putString("action", "exposure");
        bundleB.putString("page", pageName);
        if (updateEntity != null && (updateContent2 = updateEntity.getUpdateContent()) != null) {
            updateVersion = updateContent2.getUpdateVersion();
        }
        bundleB.putString("upgrade_version", updateVersion);
        if (updateEntity == null || (updateContent = updateEntity.getUpdateContent()) == null || !Intrinsics.b(updateContent.getForce(), Boolean.TRUE)) {
            bundleB.putString("upgrade_type", "optional");
        } else {
            bundleB.putString("upgrade_type", "force");
        }
        if (updateEntity == null || (appScoreContent = updateEntity.getAppScoreContent()) == null || !Intrinsics.b(appScoreContent.getShowAfterUpdate(), Boolean.TRUE)) {
            bundleB.putInt("show_after_update", 0);
        } else {
            bundleB.putInt("show_after_update", 1);
        }
        j(bundleB);
    }

    public final void l(String type, String str) {
        Intrinsics.g(type, "type");
        Bundle bundle = new Bundle();
        bundle.putString("page", "score");
        bundle.putString("action", "score_click");
        bundle.putString("button_type", type);
        bundle.putString("action_url", str);
        d(bundle);
    }

    public final void m(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("headers", str);
        bundle.putString("params", str2);
        i("update_request", bundle);
    }

    public final void n(int i11, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("response_state", i11);
        bundle.putString("response_code", str);
        bundle.putString("response_message", str2);
        i("update_request_result", bundle);
    }

    public final void o(String type, String str) {
        Intrinsics.g(type, "type");
        Bundle bundle = new Bundle();
        bundle.putString("page", "upgrade");
        bundle.putString("action", "upgrade_click");
        bundle.putString("button_type", type);
        bundle.putString("action_url", str);
        d(bundle);
    }
}
