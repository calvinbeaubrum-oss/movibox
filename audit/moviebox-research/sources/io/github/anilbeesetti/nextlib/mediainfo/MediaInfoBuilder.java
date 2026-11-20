package io.github.anilbeesetti.nextlib.mediainfo;

import androidx.annotation.Keep;
import f10.a;
import f10.b;
import f10.c;
import f10.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

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
public final class MediaInfoBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f67290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f67291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f67292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f67293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f67294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<a> f67295f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<c> f67296g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<b> f67297h = new ArrayList();

    public MediaInfoBuilder() {
        System.loadLibrary("mediainfo");
    }

    @Keep
    private final native void nativeCreateFromFD(int i11);

    @Keep
    private final native void nativeCreateFromPath(String str);

    @Keep
    private final void onAudioStreamFound(int i11, String str, String str2, String str3, int i12, long j11, String str4, int i13, int i14, String str5) {
        this.f67295f.add(new a(i11, str, str2, str3, i12, j11, str4, i13, i14, str5));
    }

    @Keep
    private final void onChapterFound(int i11, String str, long j11, long j12) {
        this.f67297h.add(new b(i11, j11, j12, str));
    }

    @Keep
    private final void onError() {
        this.f67290a = true;
    }

    @Keep
    private final void onMediaInfoFound(String str, long j11) {
        this.f67291b = str;
        this.f67292c = Long.valueOf(j11);
    }

    @Keep
    private final void onSubtitleStreamFound(int i11, String str, String str2, String str3, int i12) {
        this.f67296g.add(new c(i11, str, str2, str3, i12));
    }

    @Keep
    private final void onVideoStreamFound(int i11, String str, String str2, String str3, int i12, long j11, double d11, int i13, int i14, long j12) {
        if (this.f67294e == null) {
            this.f67294e = new d(i11, str, str2, str3, i12, j11, d11, i13, i14);
            if (j12 != -1) {
                this.f67293d = Long.valueOf(j12);
            }
        }
    }
}
