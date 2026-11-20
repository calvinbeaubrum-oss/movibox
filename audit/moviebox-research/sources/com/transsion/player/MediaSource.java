package com.transsion.player;

import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.p006enum.PlayMimeType;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

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
public final class MediaSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f54216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PlayMimeType f54217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MediaItem f54218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f54219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f54220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f54221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f54222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, String> f54223j;

    public MediaSource(String str, String url, int i11, PlayMimeType mimeType, MediaItem mediaItem) {
        Intrinsics.g(url, "url");
        Intrinsics.g(mimeType, "mimeType");
        this.f54214a = str;
        this.f54215b = url;
        this.f54216c = i11;
        this.f54217d = mimeType;
        this.f54218e = mediaItem;
        this.f54220g = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.transsion.player.MediaSource$key$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.b();
            }
        });
    }

    public /* synthetic */ MediaSource(String str, String str2, int i11, PlayMimeType playMimeType, MediaItem mediaItem, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i12 & 4) != 0 ? -1 : i11, (i12 & 8) != 0 ? PlayMimeType.DEFAULT : playMimeType, (i12 & 16) != 0 ? null : mediaItem);
    }

    public final String b() {
        int iD0 = StringsKt__StringsKt.d0(this.f54215b, "?", 0, false, 6, null);
        if (iD0 < 0) {
            return com.transsion.player.utils.a.f54864a.a(this.f54215b);
        }
        com.transsion.player.utils.a.C0585a c0585a = com.transsion.player.utils.a.f54864a;
        String strSubstring = this.f54215b.substring(0, iD0);
        Intrinsics.f(strSubstring, "substring(...)");
        return c0585a.a(strSubstring);
    }

    public final boolean c() {
        return this.f54221h;
    }

    public final Map<String, String> d() {
        return this.f54223j;
    }

    public final String e() {
        return this.f54214a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSource)) {
            return false;
        }
        MediaSource mediaSource = (MediaSource) obj;
        return Intrinsics.b(this.f54214a, mediaSource.f54214a) && Intrinsics.b(this.f54215b, mediaSource.f54215b) && this.f54216c == mediaSource.f54216c && this.f54217d == mediaSource.f54217d && Intrinsics.b(this.f54218e, mediaSource.f54218e);
    }

    public final String f() {
        return (String) this.f54220g.getValue();
    }

    public final String g() {
        return this.f54219f;
    }

    public final MediaItem h() {
        return this.f54218e;
    }

    public int hashCode() {
        String str = this.f54214a;
        int iHashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + this.f54215b.hashCode()) * 31) + this.f54216c) * 31) + this.f54217d.hashCode()) * 31;
        MediaItem mediaItem = this.f54218e;
        return iHashCode + (mediaItem != null ? mediaItem.hashCode() : 0);
    }

    public final PlayMimeType i() {
        return this.f54217d;
    }

    public final String j() {
        return this.f54215b;
    }

    public final int k() {
        return this.f54216c;
    }

    public final boolean l() {
        return this.f54222i;
    }

    public final boolean m() {
        PlayMimeType playMimeType = this.f54217d;
        return playMimeType == PlayMimeType.DASH || playMimeType == PlayMimeType.HLS || StringsKt__StringsKt.Q(this.f54215b, ".mpd", false, 2, null) || StringsKt__StringsKt.Q(this.f54215b, ".m3u8", false, 2, null);
    }

    public final void n(Map<String, String> map) {
        this.f54223j = map;
    }

    public final void o(String str) {
        this.f54219f = str;
    }

    public final void p(PlayMimeType playMimeType) {
        Intrinsics.g(playMimeType, "<set-?>");
        this.f54217d = playMimeType;
    }

    public String toString() {
        return "MediaSource(id=" + this.f54214a + ", url=" + this.f54215b + ", weights=" + this.f54216c + ", mimeType=" + this.f54217d + ", mediaItem=" + this.f54218e + ")";
    }
}
