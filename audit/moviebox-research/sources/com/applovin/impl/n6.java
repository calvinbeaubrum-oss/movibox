package com.applovin.impl;

import android.util.SparseArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n6 implements dp.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f21289b;

    public n6(int i11) {
        this(i11, eb.h());
    }

    public n6(int i11, List list) {
        this.f21288a = i11;
        this.f21289b = list;
    }

    private nj a(dp.b bVar) {
        return new nj(c(bVar));
    }

    private boolean a(int i11) {
        return (i11 & this.f21288a) != 0;
    }

    private vp b(dp.b bVar) {
        return new vp(c(bVar));
    }

    private List c(dp.b bVar) {
        String str;
        int i11;
        if (a(32)) {
            return this.f21289b;
        }
        bh bhVar = new bh(bVar.f18489d);
        List arrayList = this.f21289b;
        while (bhVar.a() > 0) {
            int iW = bhVar.w();
            int iD = bhVar.d() + bhVar.w();
            if (iW == 134) {
                arrayList = new ArrayList();
                int iW2 = bhVar.w() & 31;
                for (int i12 = 0; i12 < iW2; i12++) {
                    String strC = bhVar.c(3);
                    int iW3 = bhVar.w();
                    boolean z11 = (iW3 & 128) != 0;
                    if (z11) {
                        i11 = iW3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i11 = 1;
                    }
                    byte bW = (byte) bhVar.w();
                    bhVar.g(1);
                    arrayList.add(new f9.b().f(str).e(strC).a(i11).a(z11 ? o3.a((bW & 64) != 0) : null).a());
                }
            }
            bhVar.f(iD);
        }
        return arrayList;
    }

    @Override // com.applovin.impl.dp.c
    public SparseArray a() {
        return new SparseArray();
    }

    @Override // com.applovin.impl.dp.c
    public dp a(int i11, dp.b bVar) {
        if (i11 == 2) {
            return new ih(new fa(b(bVar)));
        }
        if (i11 == 3 || i11 == 4) {
            return new ih(new sf(bVar.f18487b));
        }
        if (i11 == 21) {
            return new ih(new ab());
        }
        if (i11 == 27) {
            if (a(4)) {
                return null;
            }
            return new ih(new ha(a(bVar), a(1), a(8)));
        }
        if (i11 == 36) {
            return new ih(new ia(a(bVar)));
        }
        if (i11 == 89) {
            return new ih(new m7(bVar.f18488c));
        }
        if (i11 != 138) {
            if (i11 == 172) {
                return new ih(new m(bVar.f18487b));
            }
            if (i11 == 257) {
                return new hj(new eh("application/vnd.dvb.ait"));
            }
            if (i11 != 129) {
                if (i11 != 130) {
                    if (i11 == 134) {
                        if (a(16)) {
                            return null;
                        }
                        return new hj(new eh(MimeTypes.APPLICATION_SCTE35));
                    }
                    if (i11 != 135) {
                        switch (i11) {
                            case 15:
                                if (a(2)) {
                                    return null;
                                }
                                return new ih(new k0(false, bVar.f18487b));
                            case 16:
                                return new ih(new ga(b(bVar)));
                            case 17:
                                if (a(2)) {
                                    return null;
                                }
                                return new ih(new bc(bVar.f18487b));
                            default:
                                return null;
                        }
                    }
                } else if (!a(64)) {
                    return null;
                }
            }
            return new ih(new j(bVar.f18487b));
        }
        return new ih(new e7(bVar.f18487b));
    }
}
