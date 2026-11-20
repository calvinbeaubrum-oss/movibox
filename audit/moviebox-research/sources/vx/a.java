package vx;

import com.transsion.subtitle_download.db.SubtitleDownloadTable;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SubtitleDownloadTable f79118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f79119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f79120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f79121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f79122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f79123f;

    public a(SubtitleDownloadTable bean) {
        Intrinsics.g(bean, "bean");
        this.f79118a = bean;
        this.f79120c = "";
        this.f79123f = "";
    }

    public final String a() {
        return this.f79123f;
    }

    public final SubtitleDownloadTable b() {
        return this.f79118a;
    }

    public final String c() {
        return this.f79121d;
    }

    public final boolean d() {
        return this.f79118a.getStatus() == 5;
    }

    public final boolean e() {
        return this.f79122e;
    }

    public final boolean f() {
        return this.f79119b;
    }

    public final void g(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f79123f = str;
    }

    public final void h(SubtitleDownloadTable subtitleDownloadTable) {
        Intrinsics.g(subtitleDownloadTable, "<set-?>");
        this.f79118a = subtitleDownloadTable;
    }

    public final void i(String str) {
        this.f79121d = str;
    }

    public final void j(boolean z11) {
        this.f79122e = z11;
    }

    public final void k(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f79120c = str;
    }

    public final void l(boolean z11) {
        this.f79119b = z11;
    }
}
