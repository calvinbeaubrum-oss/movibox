package lv;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.transsion.player.p006enum.PlayMimeType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlayMimeType f70570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f70571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f70572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f70573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f70574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f70575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f70576g;

    public c(PlayMimeType format, String id2, String url, String resolutions, String size, String duration, String signCookie) {
        Intrinsics.g(format, "format");
        Intrinsics.g(id2, "id");
        Intrinsics.g(url, "url");
        Intrinsics.g(resolutions, "resolutions");
        Intrinsics.g(size, "size");
        Intrinsics.g(duration, "duration");
        Intrinsics.g(signCookie, "signCookie");
        this.f70570a = format;
        this.f70571b = id2;
        this.f70572c = url;
        this.f70573d = resolutions;
        this.f70574e = size;
        this.f70575f = duration;
        this.f70576g = signCookie;
    }

    public final PlayMimeType a() {
        return this.f70570a;
    }

    public final String b() {
        return this.f70571b;
    }

    public final String c() {
        return this.f70573d;
    }

    public final String d() {
        return this.f70576g;
    }

    public final String e() {
        return this.f70574e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f70570a == cVar.f70570a && Intrinsics.b(this.f70571b, cVar.f70571b) && Intrinsics.b(this.f70572c, cVar.f70572c) && Intrinsics.b(this.f70573d, cVar.f70573d) && Intrinsics.b(this.f70574e, cVar.f70574e) && Intrinsics.b(this.f70575f, cVar.f70575f) && Intrinsics.b(this.f70576g, cVar.f70576g);
    }

    public final String f() {
        return this.f70572c;
    }

    public final boolean g() {
        return StringsKt__StringsKt.Q(this.f70572c, ".mp3", false, 2, null);
    }

    public final boolean h() {
        return l.L(this.f70572c, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null);
    }

    public int hashCode() {
        return (((((((((((this.f70570a.hashCode() * 31) + this.f70571b.hashCode()) * 31) + this.f70572c.hashCode()) * 31) + this.f70573d.hashCode()) * 31) + this.f70574e.hashCode()) * 31) + this.f70575f.hashCode()) * 31) + this.f70576g.hashCode();
    }

    public final boolean i() {
        PlayMimeType playMimeType = this.f70570a;
        return playMimeType == PlayMimeType.DASH || playMimeType == PlayMimeType.HLS;
    }

    public String toString() {
        return "LongVdPlayerStreamBean(format=" + this.f70570a + ", id=" + this.f70571b + ", url=" + this.f70572c + ", resolutions=" + this.f70573d + ", size=" + this.f70574e + ", duration=" + this.f70575f + ", signCookie=" + this.f70576g + ")";
    }
}
