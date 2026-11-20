package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.common.widget.video.AdVideoView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.manager.VideoMeasureManager;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.lang.ref.WeakReference;
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
public final class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdsDTO f30184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<AdVideoView> f30185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<f2> f30186c;

    public w1(AdsDTO key, AdVideoView view, f2 measureListener) {
        Intrinsics.g(key, "key");
        Intrinsics.g(view, "view");
        Intrinsics.g(measureListener, "measureListener");
        this.f30184a = key;
        this.f30185b = new WeakReference<>(view);
        this.f30186c = new WeakReference<>(measureListener);
    }

    public static final void c(f2 f2Var, AdVideoView adVideoView) {
        f2Var.a(VideoMeasureManager.INSTANCE.d(adVideoView));
    }

    public final AdsDTO b() {
        return this.f30184a;
    }

    public final void d() {
        final AdVideoView adVideoView = this.f30185b.get();
        final f2 f2Var = this.f30186c.get();
        if (adVideoView == null || f2Var == null) {
            return;
        }
        Preconditions.d(new Preconditions.a() { // from class: com.cloud.hisavana.sdk.v1
            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public final void onRun() {
                w1.c(f2Var, adVideoView);
            }
        });
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return Intrinsics.b(w1.class, obj != null ? obj.getClass() : null) && (obj instanceof w1) && Intrinsics.b(this.f30184a, ((w1) obj).f30184a);
    }

    public int hashCode() {
        return this.f30184a.hashCode();
    }
}
