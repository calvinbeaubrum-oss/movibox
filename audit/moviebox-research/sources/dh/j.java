package dh;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j implements i0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f63198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<m1> f63199b;

    public j(int i11) {
        this(i11, ImmutableList.of());
    }

    public j(int i11, List<m1> list) {
        this.f63198a = i11;
        this.f63199b = list;
    }

    @Override // dh.i0.c
    @Nullable
    public i0 a(int i11, i0.b bVar) {
        if (i11 != 2) {
            if (i11 == 3 || i11 == 4) {
                return new w(new t(bVar.f63190b));
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
                return new w(new l(bVar.f63191c));
            }
            if (i11 != 138) {
                if (i11 == 172) {
                    return new w(new f(bVar.f63190b));
                }
                if (i11 == 257) {
                    return new c0(new v("application/vnd.dvb.ait"));
                }
                if (i11 == 134) {
                    if (e(16)) {
                        return null;
                    }
                    return new c0(new v(MimeTypes.APPLICATION_SCTE35));
                }
                if (i11 != 135) {
                    switch (i11) {
                        case 15:
                            if (e(2)) {
                                return null;
                            }
                            return new w(new i(false, bVar.f63190b));
                        case 16:
                            return new w(new o(c(bVar)));
                        case 17:
                            if (e(2)) {
                                return null;
                            }
                            return new w(new s(bVar.f63190b));
                        default:
                            switch (i11) {
                                case 128:
                                    break;
                                case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
                                    break;
                                case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                                    if (!e(64)) {
                                        return null;
                                    }
                                    break;
                                default:
                                    return null;
                            }
                            break;
                    }
                }
                return new w(new c(bVar.f63190b));
            }
            return new w(new k(bVar.f63190b));
        }
        return new w(new n(c(bVar)));
    }

    public final d0 b(i0.b bVar) {
        return new d0(d(bVar));
    }

    public final k0 c(i0.b bVar) {
        return new k0(d(bVar));
    }

    @Override // dh.i0.c
    public SparseArray<i0> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    public final List<m1> d(i0.b bVar) {
        String str;
        int i11;
        if (e(32)) {
            return this.f63199b;
        }
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(bVar.f63192d);
        List<m1> arrayList = this.f63199b;
        while (c0Var.a() > 0) {
            int iD = c0Var.D();
            int iE = c0Var.e() + c0Var.D();
            if (iD == 134) {
                arrayList = new ArrayList<>();
                int iD2 = c0Var.D() & 31;
                for (int i12 = 0; i12 < iD2; i12++) {
                    String strA = c0Var.A(3);
                    int iD3 = c0Var.D();
                    boolean z11 = (iD3 & 128) != 0;
                    if (z11) {
                        i11 = iD3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i11 = 1;
                    }
                    byte bD = (byte) c0Var.D();
                    c0Var.Q(1);
                    arrayList.add(new m1.b().e0(str).V(strA).F(i11).T(z11 ? com.google.android.exoplayer2.util.f.b((bD & 64) != 0) : null).E());
                }
            }
            c0Var.P(iE);
        }
        return arrayList;
    }

    public final boolean e(int i11) {
        return (i11 & this.f63198a) != 0;
    }
}
