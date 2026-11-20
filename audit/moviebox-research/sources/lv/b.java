package lv;

import com.transsion.player.longvideo.constants.LongVodPlayerConfigType;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f70567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f70568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LongVodPlayerConfigType f70569c;

    public b() {
        this(false, null, null, 7, null);
    }

    public b(boolean z11, String content, LongVodPlayerConfigType configType) {
        Intrinsics.g(content, "content");
        Intrinsics.g(configType, "configType");
        this.f70567a = z11;
        this.f70568b = content;
        this.f70569c = configType;
    }

    public /* synthetic */ b(boolean z11, String str, LongVodPlayerConfigType longVodPlayerConfigType, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? LongVodPlayerConfigType.BITRATE : longVodPlayerConfigType);
    }

    public final LongVodPlayerConfigType a() {
        return this.f70569c;
    }

    public final String b() {
        return this.f70568b;
    }

    public final boolean c() {
        return this.f70567a;
    }

    public final void d(boolean z11) {
        this.f70567a = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f70567a == bVar.f70567a && Intrinsics.b(this.f70568b, bVar.f70568b) && this.f70569c == bVar.f70569c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z11 = this.f70567a;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return (((r11 * 31) + this.f70568b.hashCode()) * 31) + this.f70569c.hashCode();
    }

    public String toString() {
        return "LongVdPlayerConfigBean(isSelected=" + this.f70567a + ", content=" + this.f70568b + ", configType=" + this.f70569c + ")";
    }
}
