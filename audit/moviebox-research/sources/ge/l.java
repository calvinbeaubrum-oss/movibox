package ge;

import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zc.p;

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
public final class l extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f65491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p f65492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final fe.f f65493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zc.a f65494g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, p pVar, fe.f fVar, zc.a aVar) {
        super(context, pVar, fVar);
        Intrinsics.g(context, "context");
        this.f65491d = context;
        this.f65492e = pVar;
        this.f65493f = fVar;
        this.f65494g = aVar;
    }

    @Override // ge.b
    public Context b() {
        return this.f65491d;
    }

    @Override // ge.b
    public p c() {
        return this.f65492e;
    }

    @Override // ge.b
    public fe.f d() {
        return this.f65493f;
    }

    @Override // ge.b
    public void e(p pVar) {
        this.f65492e = pVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        zc.a aVar = this.f65494g;
        if (aVar != null) {
            aVar.b();
        }
        super.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        zc.a aVar = this.f65494g;
        if (aVar != null) {
            aVar.a(view, customViewCallback);
        }
        super.onShowCustomView(view, customViewCallback);
    }
}
