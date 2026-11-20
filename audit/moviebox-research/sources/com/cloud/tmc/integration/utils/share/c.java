package com.cloud.tmc.integration.utils.share;

import android.content.ClipData;
import android.net.Uri;
import java.io.File;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f31115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f31116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f31117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f31118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CharSequence f31119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CharSequence f31120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ClipData f31121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f31122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Uri f31123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f31124j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public yb.a f31125k;

    public c(CharSequence content, String shareType, File file, int i11, CharSequence charSequence, CharSequence charSequence2, ClipData clipData, String str, Uri uri, boolean z11, yb.a aVar) {
        Intrinsics.g(content, "content");
        Intrinsics.g(shareType, "shareType");
        this.f31115a = content;
        this.f31116b = shareType;
        this.f31117c = file;
        this.f31118d = i11;
        this.f31119e = charSequence;
        this.f31120f = charSequence2;
        this.f31121g = clipData;
        this.f31122h = str;
        this.f31123i = uri;
        this.f31124j = z11;
        this.f31125k = aVar;
    }

    public /* synthetic */ c(CharSequence charSequence, String str, File file, int i11, CharSequence charSequence2, CharSequence charSequence3, ClipData clipData, String str2, Uri uri, boolean z11, yb.a aVar, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, str, (i12 & 4) != 0 ? null : file, (i12 & 8) != 0 ? 1 : i11, (i12 & 16) != 0 ? null : charSequence2, (i12 & 32) != 0 ? null : charSequence3, (i12 & 64) != 0 ? null : clipData, (i12 & 128) != 0 ? null : str2, (i12 & 256) != 0 ? null : uri, (i12 & 512) != 0 ? false : z11, (i12 & 1024) != 0 ? null : aVar);
    }

    public final int a() {
        return this.f31118d;
    }

    public final CharSequence b() {
        return this.f31115a;
    }

    public final Uri c() {
        return this.f31123i;
    }

    public final File d() {
        return this.f31117c;
    }

    public final String e() {
        return this.f31116b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.b(this.f31115a, cVar.f31115a) && Intrinsics.b(this.f31116b, cVar.f31116b) && Intrinsics.b(this.f31117c, cVar.f31117c) && this.f31118d == cVar.f31118d && Intrinsics.b(this.f31119e, cVar.f31119e) && Intrinsics.b(this.f31120f, cVar.f31120f) && Intrinsics.b(this.f31121g, cVar.f31121g) && Intrinsics.b(this.f31122h, cVar.f31122h) && Intrinsics.b(this.f31123i, cVar.f31123i) && this.f31124j == cVar.f31124j && Intrinsics.b(this.f31125k, cVar.f31125k);
    }

    public final yb.a f() {
        return this.f31125k;
    }

    public final CharSequence g() {
        return this.f31120f;
    }

    public final String h() {
        return this.f31122h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v31 */
    public int hashCode() {
        int iHashCode = ((this.f31115a.hashCode() * 31) + this.f31116b.hashCode()) * 31;
        File file = this.f31117c;
        int iHashCode2 = (((iHashCode + (file == null ? 0 : file.hashCode())) * 31) + this.f31118d) * 31;
        CharSequence charSequence = this.f31119e;
        int iHashCode3 = (iHashCode2 + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
        CharSequence charSequence2 = this.f31120f;
        int iHashCode4 = (iHashCode3 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
        ClipData clipData = this.f31121g;
        int iHashCode5 = (iHashCode4 + (clipData == null ? 0 : clipData.hashCode())) * 31;
        String str = this.f31122h;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        Uri uri = this.f31123i;
        int iHashCode7 = (iHashCode6 + (uri == null ? 0 : uri.hashCode())) * 31;
        boolean z11 = this.f31124j;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode7 + r11) * 31;
        yb.a aVar = this.f31125k;
        return i11 + (aVar != null ? aVar.hashCode() : 0);
    }

    public final ClipData i() {
        return this.f31121g;
    }

    public final CharSequence j() {
        return this.f31119e;
    }

    public final boolean k() {
        return this.f31124j;
    }

    public final void l(Uri uri) {
        this.f31123i = uri;
    }

    public final void m(yb.a aVar) {
        this.f31125k = aVar;
    }

    public String toString() {
        return "ShareParams(content=" + ((Object) this.f31115a) + ", shareType=" + this.f31116b + ", shareFile=" + this.f31117c + ", channel=" + this.f31118d + ", title=" + ((Object) this.f31119e) + ", subLine=" + ((Object) this.f31120f) + ", thumbnail=" + this.f31121g + ", targetPackageName=" + this.f31122h + ", fileUri=" + this.f31123i + ", isFileProvider=" + this.f31124j + ", strategy=" + this.f31125k + ')';
    }
}
