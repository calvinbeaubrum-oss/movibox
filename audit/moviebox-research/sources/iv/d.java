package iv;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.transsion.player.config.RenderType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RenderType f67719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f67720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f67721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f67722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f67723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f67724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f67725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f67726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f67727i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f67728j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f67729k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f67730l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f67731m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f67732n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f67733o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f67734p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f67735q;

    public d() {
        this(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, null, 131071, null);
    }

    public d(RenderType type, boolean z11, int i11, int i12, int i13, int i14, int i15, int i16, long j11, int i17, int i18, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, String traceId) {
        Intrinsics.g(type, "type");
        Intrinsics.g(traceId, "traceId");
        this.f67719a = type;
        this.f67720b = z11;
        this.f67721c = i11;
        this.f67722d = i12;
        this.f67723e = i13;
        this.f67724f = i14;
        this.f67725g = i15;
        this.f67726h = i16;
        this.f67727i = j11;
        this.f67728j = i17;
        this.f67729k = i18;
        this.f67730l = z12;
        this.f67731m = z13;
        this.f67732n = z14;
        this.f67733o = z15;
        this.f67734p = z16;
        this.f67735q = traceId;
    }

    public /* synthetic */ d(RenderType renderType, boolean z11, int i11, int i12, int i13, int i14, int i15, int i16, long j11, int i17, int i18, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, String str, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? RenderType.SURFACE_VIEW : renderType, (i19 & 2) != 0 ? true : z11, (i19 & 4) != 0 ? 50 : i11, (i19 & 8) != 0 ? DefaultLoadControl.DEFAULT_MAX_BUFFER_MS : i12, (i19 & 16) != 0 ? AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS : i13, (i19 & 32) != 0 ? 500 : i14, (i19 & 64) != 0 ? 2 : i15, (i19 & 128) != 0 ? 3 : i16, (i19 & 256) != 0 ? 4000L : j11, (i19 & 512) == 0 ? i17 : 50, (i19 & 1024) != 0 ? ComConstants.AD_TIMEOUT_MILLIS : i18, (i19 & 2048) != 0 ? true : z12, (i19 & 4096) != 0 ? false : z13, (i19 & 8192) != 0 ? false : z14, (i19 & 16384) == 0 ? z15 : false, (32768 & i19) != 0 ? true : z16, (i19 & 65536) != 0 ? "" : str);
    }

    public final int a() {
        return this.f67728j;
    }

    public final boolean b() {
        return this.f67731m;
    }

    public final boolean c() {
        return this.f67733o;
    }

    public final boolean d() {
        return this.f67732n;
    }

    public final boolean e() {
        return this.f67730l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f67719a == dVar.f67719a && this.f67720b == dVar.f67720b && this.f67721c == dVar.f67721c && this.f67722d == dVar.f67722d && this.f67723e == dVar.f67723e && this.f67724f == dVar.f67724f && this.f67725g == dVar.f67725g && this.f67726h == dVar.f67726h && this.f67727i == dVar.f67727i && this.f67728j == dVar.f67728j && this.f67729k == dVar.f67729k && this.f67730l == dVar.f67730l && this.f67731m == dVar.f67731m && this.f67732n == dVar.f67732n && this.f67733o == dVar.f67733o && this.f67734p == dVar.f67734p && Intrinsics.b(this.f67735q, dVar.f67735q);
    }

    public final int f() {
        return this.f67723e;
    }

    public final int g() {
        return this.f67722d;
    }

    public final int h() {
        return this.f67729k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v29, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.f67719a.hashCode() * 31;
        boolean z11 = this.f67720b;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int iA = (((((((((((((((((((iHashCode + r11) * 31) + this.f67721c) * 31) + this.f67722d) * 31) + this.f67723e) * 31) + this.f67724f) * 31) + this.f67725g) * 31) + this.f67726h) * 31) + p.a(this.f67727i)) * 31) + this.f67728j) * 31) + this.f67729k) * 31;
        boolean z12 = this.f67730l;
        ?? r12 = z12;
        if (z12) {
            r12 = 1;
        }
        int i11 = (iA + r12) * 31;
        boolean z13 = this.f67731m;
        ?? r13 = z13;
        if (z13) {
            r13 = 1;
        }
        int i12 = (i11 + r13) * 31;
        boolean z14 = this.f67732n;
        ?? r14 = z14;
        if (z14) {
            r14 = 1;
        }
        int i13 = (i12 + r14) * 31;
        boolean z15 = this.f67733o;
        ?? r15 = z15;
        if (z15) {
            r15 = 1;
        }
        int i14 = (i13 + r15) * 31;
        boolean z16 = this.f67734p;
        return ((i14 + (z16 ? 1 : z16)) * 31) + this.f67735q.hashCode();
    }

    public final boolean i() {
        return this.f67734p;
    }

    public final boolean j() {
        return this.f67720b;
    }

    public final int k() {
        return this.f67721c;
    }

    public final long l() {
        return this.f67727i;
    }

    public final int m() {
        return this.f67725g;
    }

    public final int n() {
        return this.f67724f;
    }

    public final String o() {
        return this.f67735q;
    }

    public final RenderType p() {
        return this.f67719a;
    }

    public String toString() {
        return "VodConfig(type=" + this.f67719a + ", openCache=" + this.f67720b + ", positionTimerIntervalMs=" + this.f67721c + ", maxBufferDuration=" + this.f67722d + ", highBufferDuration=" + this.f67723e + ", startBufferDuration=" + this.f67724f + ", retryCount=" + this.f67725g + ", preloadCount=" + this.f67726h + ", preloadDuration=" + this.f67727i + ", cacheMaxSizeMB=" + this.f67728j + ", networkTimeout=" + this.f67729k + ", enableHardwareDecoder=" + this.f67730l + ", clearFrameWhenStop=" + this.f67731m + ", disableVideo=" + this.f67732n + ", disableAudio=" + this.f67733o + ", openAudioFocus=" + this.f67734p + ", traceId=" + this.f67735q + ")";
    }
}
