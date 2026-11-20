package q1;

import androidx.compose.ui.graphics.y1;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.gslb.Worker;
import kotlin.Metadata;
import okhttp3.internal.ws.WebSocketProtocol;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f74163a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f74165b = y1.f(0, 0, 0, 0, 8, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f74167c = y1.f(0, 0, 0, 0, 8, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f74169d = y1.f(65, 14, 11, 0, 8, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f74171e = y1.f(255, 255, 255, 0, 8, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f74173f = y1.f(96, 20, 16, 0, 8, null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f74175g = y1.f(140, 29, 24, 0, 8, null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f74177h = y1.f(179, 38, 30, 0, 8, null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f74179i = y1.f(220, 54, 46, 0, 8, null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f74181j = y1.f(228, 105, 98, 0, 8, null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f74183k = y1.f(236, 146, 142, 0, 8, null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f74185l = y1.f(242, 184, 181, 0, 8, null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f74187m = y1.f(249, 222, 220, 0, 8, null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f74189n = y1.f(252, 238, 238, 0, 8, null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f74191o = y1.f(255, 251, 249, 0, 8, null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f74193p = y1.f(0, 0, 0, 0, 8, null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f74195q = y1.f(28, 27, 31, 0, 8, null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f74197r = y1.f(255, 255, 255, 0, 8, null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f74199s = y1.f(49, 48, 51, 0, 8, null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f74201t = y1.f(72, 70, 73, 0, 8, null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f74203u = y1.f(96, 93, 98, 0, 8, null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long f74205v = y1.f(120, 117, 121, 0, 8, null);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final long f74207w = y1.f(147, 144, 148, 0, 8, null);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final long f74209x = y1.f(174, 170, 174, 0, 8, null);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final long f74211y = y1.f(201, 197, 202, 0, 8, null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final long f74213z = y1.f(230, 225, 229, 0, 8, null);
    public static final long A = y1.f(244, 239, 244, 0, 8, null);
    public static final long B = y1.f(255, 251, 254, 0, 8, null);
    public static final long C = y1.f(0, 0, 0, 0, 8, null);
    public static final long D = y1.f(29, 26, 34, 0, 8, null);
    public static final long E = y1.f(255, 255, 255, 0, 8, null);
    public static final long F = y1.f(50, 47, 55, 0, 8, null);
    public static final long G = y1.f(73, 69, 79, 0, 8, null);
    public static final long H = y1.f(96, 93, 102, 0, 8, null);
    public static final long I = y1.f(121, 116, WebSocketProtocol.PAYLOAD_SHORT, 0, 8, null);
    public static final long J = y1.f(147, 143, 153, 0, 8, null);
    public static final long K = y1.f(174, 169, 180, 0, 8, null);
    public static final long L = y1.f(202, 196, 208, 0, 8, null);
    public static final long M = y1.f(231, 224, 236, 0, 8, null);
    public static final long N = y1.f(245, 238, 250, 0, 8, null);
    public static final long O = y1.f(255, 251, 254, 0, 8, null);
    public static final long P = y1.f(0, 0, 0, 0, 8, null);
    public static final long Q = y1.f(33, 0, 93, 0, 8, null);
    public static final long R = y1.f(255, 255, 255, 0, 8, null);
    public static final long S = y1.f(56, 30, 114, 0, 8, null);
    public static final long T = y1.f(79, 55, 139, 0, 8, null);
    public static final long U = y1.f(Worker.WHAT_SYNC_DATA, 80, 164, 0, 8, null);
    public static final long V = y1.f(127, Worker.WHAT_SYNC_DATA, 190, 0, 8, null);
    public static final long W = y1.f(154, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 219, 0, 8, null);
    public static final long X = y1.f(182, 157, 248, 0, 8, null);
    public static final long Y = y1.f(208, 188, 255, 0, 8, null);
    public static final long Z = y1.f(234, 221, 255, 0, 8, null);

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final long f74164a0 = y1.f(246, 237, 255, 0, 8, null);

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final long f74166b0 = y1.f(255, 251, 254, 0, 8, null);

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final long f74168c0 = y1.f(0, 0, 0, 0, 8, null);

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final long f74170d0 = y1.f(29, 25, 43, 0, 8, null);

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final long f74172e0 = y1.f(255, 255, 255, 0, 8, null);

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final long f74174f0 = y1.f(51, 45, 65, 0, 8, null);

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final long f74176g0 = y1.f(74, 68, 88, 0, 8, null);

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final long f74178h0 = y1.f(98, 91, 113, 0, 8, null);

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final long f74180i0 = y1.f(122, 114, 137, 0, 8, null);

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final long f74182j0 = y1.f(149, 141, 165, 0, 8, null);

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final long f74184k0 = y1.f(176, 167, PsExtractor.AUDIO_STREAM, 0, 8, null);

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final long f74186l0 = y1.f(204, 194, 220, 0, 8, null);

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final long f74188m0 = y1.f(232, 222, 248, 0, 8, null);

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final long f74190n0 = y1.f(246, 237, 255, 0, 8, null);

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final long f74192o0 = y1.f(255, 251, 254, 0, 8, null);

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final long f74194p0 = y1.f(0, 0, 0, 0, 8, null);

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final long f74196q0 = y1.f(49, 17, 29, 0, 8, null);

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final long f74198r0 = y1.f(255, 255, 255, 0, 8, null);

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final long f74200s0 = y1.f(73, 37, 50, 0, 8, null);

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final long f74202t0 = y1.f(99, 59, 72, 0, 8, null);

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final long f74204u0 = y1.f(125, 82, 96, 0, 8, null);

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final long f74206v0 = y1.f(152, 105, 119, 0, 8, null);

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final long f74208w0 = y1.f(181, 131, 146, 0, 8, null);

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final long f74210x0 = y1.f(210, 157, 172, 0, 8, null);

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final long f74212y0 = y1.f(239, 184, 200, 0, 8, null);

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final long f74214z0 = y1.f(255, 216, 228, 0, 8, null);
    public static final long A0 = y1.f(255, 236, 241, 0, 8, null);
    public static final long B0 = y1.f(255, 251, 250, 0, 8, null);
    public static final long C0 = y1.f(255, 255, 255, 0, 8, null);

    public final long a() {
        return f74169d;
    }

    public final long b() {
        return f74171e;
    }

    public final long c() {
        return f74177h;
    }

    public final long d() {
        return f74187m;
    }

    public final long e() {
        return f74193p;
    }

    public final long f() {
        return f74195q;
    }

    public final long g() {
        return f74199s;
    }

    public final long h() {
        return A;
    }

    public final long i() {
        return B;
    }

    public final long j() {
        return G;
    }

    public final long k() {
        return I;
    }

    public final long l() {
        return L;
    }

    public final long m() {
        return M;
    }

    public final long n() {
        return Q;
    }

    public final long o() {
        return R;
    }

    public final long p() {
        return U;
    }

    public final long q() {
        return Y;
    }

    public final long r() {
        return Z;
    }

    public final long s() {
        return f74170d0;
    }

    public final long t() {
        return f74172e0;
    }

    public final long u() {
        return f74178h0;
    }

    public final long v() {
        return f74188m0;
    }

    public final long w() {
        return f74196q0;
    }

    public final long x() {
        return f74198r0;
    }

    public final long y() {
        return f74204u0;
    }

    public final long z() {
        return f74214z0;
    }
}
