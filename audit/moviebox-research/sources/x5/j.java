package x5;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements i0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f80046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<androidx.media3.common.y> f80047b;

    public j(int i11) {
        this(i11, ImmutableList.of());
    }

    public j(int i11, List<androidx.media3.common.y> list) {
        this.f80046a = i11;
        this.f80047b = list;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x0053  */
    @Override // x5.i0.c
    @Nullable
    public i0 a(int i11, i0.b bVar) {
        if (i11 != 2) {
            if (i11 == 3 || i11 == 4) {
                return new w(new t(bVar.f80037b, bVar.a()));
            }
            if (i11 == 21) {
                return new w(new r());
            }
            if (i11 == 27) {
                if (e(4)) {
                    return null;
                }
                return new w(new p(b(bVar), e(1), e(8)));
            }
            if (i11 == 36) {
                return new w(new q(b(bVar)));
            }
            if (i11 == 89) {
                return new w(new l(bVar.f80039d));
            }
            if (i11 == 172) {
                return new w(new f(bVar.f80037b, bVar.a()));
            }
            if (i11 == 257) {
                return new c0(new v("application/vnd.dvb.ait"));
            }
            if (i11 != 138) {
                if (i11 == 139) {
                    return new w(new k(bVar.f80037b, bVar.a(), 5408));
                }
                switch (i11) {
                    case 15:
                        if (e(2)) {
                            return null;
                        }
                        return new w(new i(false, bVar.f80037b, bVar.a()));
                    case 16:
                        return new w(new o(c(bVar)));
                    case 17:
                        if (e(2)) {
                            return null;
                        }
                        return new w(new s(bVar.f80037b, bVar.a()));
                    default:
                        switch (i11) {
                            case 128:
                                break;
                            case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
                                return new w(new c(bVar.f80037b, bVar.a()));
                            case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                                if (!e(64)) {
                                    return null;
                                }
                                break;
                            default:
                                switch (i11) {
                                    case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
                                        if (e(16)) {
                                            return null;
                                        }
                                        return new c0(new v(MimeTypes.APPLICATION_SCTE35));
                                    case TsExtractor.TS_STREAM_TYPE_E_AC3 /* 135 */:
                                        return new w(new c(bVar.f80037b, bVar.a()));
                                    case 136:
                                        break;
                                    default:
                                        return null;
                                }
                                break;
                        }
                        break;
                }
            }
            return new w(new k(bVar.f80037b, bVar.a(), 4096));
        }
        return new w(new n(c(bVar)));
    }

    public final d0 b(i0.b bVar) {
        return new d0(d(bVar));
    }

    public final k0 c(i0.b bVar) {
        return new k0(d(bVar));
    }

    @Override // x5.i0.c
    public SparseArray<i0> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    public final List<androidx.media3.common.y> d(i0.b bVar) {
        String str;
        int i11;
        if (e(32)) {
            return this.f80047b;
        }
        z3.c0 c0Var = new z3.c0(bVar.f80040e);
        List<androidx.media3.common.y> arrayList = this.f80047b;
        while (c0Var.a() > 0) {
            int iH = c0Var.H();
            int iF = c0Var.f() + c0Var.H();
            if (iH == 134) {
                arrayList = new ArrayList<>();
                int iH2 = c0Var.H() & 31;
                for (int i12 = 0; i12 < iH2; i12++) {
                    String strE = c0Var.E(3);
                    int iH3 = c0Var.H();
                    boolean z11 = (iH3 & 128) != 0;
                    if (z11) {
                        i11 = iH3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i11 = 1;
                    }
                    byte bH = (byte) c0Var.H();
                    c0Var.V(1);
                    arrayList.add(new androidx.media3.common.y.b().k0(str).b0(strE).J(i11).Y(z11 ? z3.e.b((bH & 64) != 0) : null).I());
                }
            }
            c0Var.U(iF);
        }
        return arrayList;
    }

    public final boolean e(int i11) {
        return (i11 & this.f80046a) != 0;
    }
}
