package iv;

import com.transsion.player.config.PlayerType;
import com.transsion.player.p006enum.ScaleMode;
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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f67710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PlayerType f67711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f67712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f67713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f67714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ScaleMode f67715f;

    public a(d vodConfig, PlayerType playerType, boolean z11, boolean z12, float f11, ScaleMode scaleMode) {
        Intrinsics.g(vodConfig, "vodConfig");
        Intrinsics.g(playerType, "playerType");
        Intrinsics.g(scaleMode, "scaleMode");
        this.f67710a = vodConfig;
        this.f67711b = playerType;
        this.f67712c = z11;
        this.f67713d = z12;
        this.f67714e = f11;
        this.f67715f = scaleMode;
    }

    public /* synthetic */ a(d dVar, PlayerType playerType, boolean z11, boolean z12, float f11, ScaleMode scaleMode, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar, (i11 & 2) != 0 ? PlayerType.EXO : playerType, (i11 & 4) != 0 ? true : z11, (i11 & 8) != 0 ? true : z12, f11, scaleMode);
    }

    public final ScaleMode a() {
        return this.f67715f;
    }

    public final float b() {
        return this.f67714e;
    }

    public final boolean c() {
        return this.f67713d;
    }

    public final d d() {
        return this.f67710a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f67710a, aVar.f67710a) && this.f67711b == aVar.f67711b && this.f67712c == aVar.f67712c && this.f67713d == aVar.f67713d && Float.compare(this.f67714e, aVar.f67714e) == 0 && this.f67715f == aVar.f67715f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((this.f67710a.hashCode() * 31) + this.f67711b.hashCode()) * 31;
        boolean z11 = this.f67712c;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode + r11) * 31;
        boolean z12 = this.f67713d;
        return ((((i11 + (z12 ? 1 : z12)) * 31) + Float.floatToIntBits(this.f67714e)) * 31) + this.f67715f.hashCode();
    }

    public String toString() {
        return "LongVodConfig(vodConfig=" + this.f67710a + ", playerType=" + this.f67711b + ", openMediaNotification=" + this.f67712c + ", useSurface=" + this.f67713d + ", speed=" + this.f67714e + ", scaleMode=" + this.f67715f + ")";
    }
}
