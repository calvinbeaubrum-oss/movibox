package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.OggPageHeader;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jg f19692a = new jg();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bh f19693b = new bh(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19694c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f19695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19696e;

    private int a(int i11) {
        int i12;
        int i13 = 0;
        this.f19695d = 0;
        do {
            int i14 = this.f19695d;
            int i15 = i11 + i14;
            jg jgVar = this.f19692a;
            if (i15 >= jgVar.f19954g) {
                break;
            }
            int[] iArr = jgVar.f19957j;
            this.f19695d = i14 + 1;
            i12 = iArr[i15];
            i13 += i12;
        } while (i12 == 255);
        return i13;
    }

    public jg a() {
        return this.f19692a;
    }

    public boolean a(l8 l8Var) {
        int i11;
        b1.b(l8Var != null);
        if (this.f19696e) {
            this.f19696e = false;
            this.f19693b.d(0);
        }
        while (!this.f19696e) {
            if (this.f19694c < 0) {
                if (!this.f19692a.a(l8Var) || !this.f19692a.a(l8Var, true)) {
                    return false;
                }
                jg jgVar = this.f19692a;
                int iA = jgVar.f19955h;
                if ((jgVar.f19949b & 1) == 1 && this.f19693b.e() == 0) {
                    iA += a(0);
                    i11 = this.f19695d;
                } else {
                    i11 = 0;
                }
                if (!n8.a(l8Var, iA)) {
                    return false;
                }
                this.f19694c = i11;
            }
            int iA2 = a(this.f19694c);
            int i12 = this.f19694c + this.f19695d;
            if (iA2 > 0) {
                bh bhVar = this.f19693b;
                bhVar.a(bhVar.e() + iA2);
                if (!n8.b(l8Var, this.f19693b.c(), this.f19693b.e(), iA2)) {
                    return false;
                }
                bh bhVar2 = this.f19693b;
                bhVar2.e(bhVar2.e() + iA2);
                this.f19696e = this.f19692a.f19957j[i12 + (-1)] != 255;
            }
            if (i12 == this.f19692a.f19954g) {
                i12 = -1;
            }
            this.f19694c = i12;
        }
        return true;
    }

    public bh b() {
        return this.f19693b;
    }

    public void c() {
        this.f19692a.a();
        this.f19693b.d(0);
        this.f19694c = -1;
        this.f19696e = false;
    }

    public void d() {
        if (this.f19693b.c().length == 65025) {
            return;
        }
        bh bhVar = this.f19693b;
        bhVar.a(Arrays.copyOf(bhVar.c(), Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, this.f19693b.e())), this.f19693b.e());
    }
}
