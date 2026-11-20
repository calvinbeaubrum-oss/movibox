package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ih implements dp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q7 f19697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f19698b = new ah(new byte[10]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19699c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f19700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ho f19701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f19703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f19704h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f19705i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f19706j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f19707k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f19708l;

    public ih(q7 q7Var) {
        this.f19697a = q7Var;
    }

    private void a(int i11) {
        this.f19699c = i11;
        this.f19700d = 0;
    }

    private boolean a(bh bhVar, byte[] bArr, int i11) {
        int iMin = Math.min(bhVar.a(), i11 - this.f19700d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            bhVar.g(iMin);
        } else {
            bhVar.a(bArr, this.f19700d, iMin);
        }
        int i12 = this.f19700d + iMin;
        this.f19700d = i12;
        return i12 == i11;
    }

    private boolean b() {
        this.f19698b.c(0);
        int iA = this.f19698b.a(24);
        if (iA != 1) {
            pc.d("PesReader", "Unexpected start code prefix: " + iA);
            this.f19706j = -1;
            return false;
        }
        this.f19698b.d(8);
        int iA2 = this.f19698b.a(16);
        this.f19698b.d(5);
        this.f19707k = this.f19698b.f();
        this.f19698b.d(2);
        this.f19702f = this.f19698b.f();
        this.f19703g = this.f19698b.f();
        this.f19698b.d(6);
        int iA3 = this.f19698b.a(8);
        this.f19705i = iA3;
        if (iA2 == 0) {
            this.f19706j = -1;
        } else {
            int i11 = (iA2 - 3) - iA3;
            this.f19706j = i11;
            if (i11 < 0) {
                pc.d("PesReader", "Found negative packet payload size: " + this.f19706j);
                this.f19706j = -1;
            }
        }
        return true;
    }

    private void c() {
        this.f19698b.c(0);
        this.f19708l = C.TIME_UNSET;
        if (this.f19702f) {
            this.f19698b.d(4);
            long jA = ((long) this.f19698b.a(3)) << 30;
            this.f19698b.d(1);
            long jA2 = jA | ((long) (this.f19698b.a(15) << 15));
            this.f19698b.d(1);
            long jA3 = jA2 | ((long) this.f19698b.a(15));
            this.f19698b.d(1);
            if (!this.f19704h && this.f19703g) {
                this.f19698b.d(4);
                long jA4 = ((long) this.f19698b.a(3)) << 30;
                this.f19698b.d(1);
                long jA5 = jA4 | ((long) (this.f19698b.a(15) << 15));
                this.f19698b.d(1);
                long jA6 = jA5 | ((long) this.f19698b.a(15));
                this.f19698b.d(1);
                this.f19701e.b(jA6);
                this.f19704h = true;
            }
            this.f19708l = this.f19701e.b(jA3);
        }
    }

    @Override // com.applovin.impl.dp
    public final void a() {
        this.f19699c = 0;
        this.f19700d = 0;
        this.f19704h = false;
        this.f19697a.a();
    }

    @Override // com.applovin.impl.dp
    public final void a(bh bhVar, int i11) {
        b1.b(this.f19701e);
        if ((i11 & 1) != 0) {
            int i12 = this.f19699c;
            if (i12 != 0 && i12 != 1) {
                if (i12 == 2) {
                    pc.d("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i12 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.f19706j != -1) {
                        pc.d("PesReader", "Unexpected start indicator: expected " + this.f19706j + " more bytes");
                    }
                    this.f19697a.b();
                }
            }
            a(1);
        }
        while (bhVar.a() > 0) {
            int i13 = this.f19699c;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 == 2) {
                        if (a(bhVar, this.f19698b.f17657a, Math.min(10, this.f19705i)) && a(bhVar, (byte[]) null, this.f19705i)) {
                            c();
                            i11 |= this.f19707k ? 4 : 0;
                            this.f19697a.a(this.f19708l, i11);
                            a(3);
                        }
                    } else {
                        if (i13 != 3) {
                            throw new IllegalStateException();
                        }
                        int iA = bhVar.a();
                        int i14 = this.f19706j;
                        int i15 = i14 != -1 ? iA - i14 : 0;
                        if (i15 > 0) {
                            iA -= i15;
                            bhVar.e(bhVar.d() + iA);
                        }
                        this.f19697a.a(bhVar);
                        int i16 = this.f19706j;
                        if (i16 != -1) {
                            int i17 = i16 - iA;
                            this.f19706j = i17;
                            if (i17 == 0) {
                                this.f19697a.b();
                                a(1);
                            }
                        }
                    }
                } else if (a(bhVar, this.f19698b.f17657a, 9)) {
                    a(b() ? 2 : 0);
                }
            } else {
                bhVar.g(bhVar.a());
            }
        }
    }

    @Override // com.applovin.impl.dp
    public void a(ho hoVar, m8 m8Var, dp.d dVar) {
        this.f19701e = hoVar;
        this.f19697a.a(m8Var, dVar);
    }
}
