package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class s1 extends xl {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f22221e = {5512, 11025, 22050, 44100};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f22222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f22223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f22224d;

    public s1(qo qoVar) {
        super(qoVar);
    }

    @Override // com.applovin.impl.xl
    public boolean a(bh bhVar) throws xl.a {
        if (this.f22222b) {
            bhVar.g(1);
        } else {
            int iW = bhVar.w();
            int i11 = (iW >> 4) & 15;
            this.f22224d = i11;
            if (i11 == 2) {
                this.f24345a.a(new f9.b().f(MimeTypes.AUDIO_MPEG).c(1).n(f22221e[(iW >> 2) & 3]).a());
                this.f22223c = true;
            } else if (i11 == 7 || i11 == 8) {
                this.f24345a.a(new f9.b().f(i11 == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW).c(1).n(8000).a());
                this.f22223c = true;
            } else if (i11 != 10) {
                throw new xl.a("Audio format not supported: " + this.f22224d);
            }
            this.f22222b = true;
        }
        return true;
    }

    @Override // com.applovin.impl.xl
    public boolean b(bh bhVar, long j11) {
        if (this.f22224d == 2) {
            int iA = bhVar.a();
            this.f24345a.a(bhVar, iA);
            this.f24345a.a(j11, 1, iA, 0, null);
            return true;
        }
        int iW = bhVar.w();
        if (iW != 0 || this.f22223c) {
            if (this.f22224d == 10 && iW != 1) {
                return false;
            }
            int iA2 = bhVar.a();
            this.f24345a.a(bhVar, iA2);
            this.f24345a.a(j11, 1, iA2, 0, null);
            return true;
        }
        int iA3 = bhVar.a();
        byte[] bArr = new byte[iA3];
        bhVar.a(bArr, 0, iA3);
        a.b bVarA = a.a(bArr);
        this.f24345a.a(new f9.b().f(MimeTypes.AUDIO_AAC).a(bVarA.f17406c).c(bVarA.f17405b).n(bVarA.f17404a).a(Collections.singletonList(bArr)).a());
        this.f22223c = true;
        return false;
    }
}
