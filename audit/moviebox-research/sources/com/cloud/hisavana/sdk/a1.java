package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
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
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j.a f29101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f29102b;

    public a1(j.a admListener) {
        Intrinsics.g(admListener, "admListener");
        this.f29101a = admListener;
        this.f29102b = "AdmActionBridge";
    }

    public static final void b(String path, a1 this$0) {
        Intrinsics.g(path, "$path");
        Intrinsics.g(this$0, "this$0");
        if (TextUtils.isEmpty(path)) {
            return;
        }
        if (kotlin.text.l.L(path, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null) || kotlin.text.l.L(path, "https", false, 2, null) || kotlin.text.l.L(path, "file", false, 2, null)) {
            this$0.f29101a.a(path, TaErrorCode.CODE_BITMAP_TAKE_FAILED);
        }
    }

    @JavascriptInterface
    public final void loadMaterialError(final String path) {
        Intrinsics.g(path, "path");
        z.a().w(this.f29102b, "loadMaterialError " + path);
        Preconditions.d(new Preconditions.a() { // from class: com.cloud.hisavana.sdk.w0
            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public final void onRun() {
                a1.b(path, this);
            }
        });
    }
}
