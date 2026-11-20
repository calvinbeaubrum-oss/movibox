package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.cloud.config.utils.XLogUtil;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f34607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f34608b;

    public t(a aVar, Uri uri) {
        com.google.android.exoplayer2.util.a.a(aVar.f34432i.containsKey("control"));
        this.f34607a = b(aVar);
        this.f34608b = a(uri, (String) o0.j(aVar.f34432i.get("control")));
    }

    public static Uri a(Uri uri, String str) {
        Uri uri2 = Uri.parse(str);
        if (uri2.isAbsolute()) {
            return uri2;
        }
        return str.equals("*") ? uri : uri.buildUpon().appendEncodedPath(str).build();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:54:0x00de  */
    /* JADX WARN: switch over string: strings are not added: [[audio/ac3, audio/g711-alaw, audio/g711-mlaw]] */
    public static j b(a aVar) {
        int iD;
        m1.b bVar = new m1.b();
        int i11 = aVar.f34428e;
        if (i11 > 0) {
            bVar.G(i11);
        }
        a.c cVar = aVar.f34433j;
        int i12 = cVar.f34443a;
        String str = cVar.f34444b;
        String strA = j.a(str);
        bVar.e0(strA);
        int i13 = aVar.f34433j.f34445c;
        if (MimeTypes.BASE_TYPE_AUDIO.equals(aVar.f34424a)) {
            iD = d(aVar.f34433j.f34446d, strA);
            bVar.f0(i13).H(iD);
        } else {
            iD = -1;
        }
        ImmutableMap<String, String> immutableMapA = aVar.a();
        switch (strA) {
            case "audio/mp4a-latm":
                com.google.android.exoplayer2.util.a.a(iD != -1);
                com.google.android.exoplayer2.util.a.a(!immutableMapA.isEmpty());
                e(bVar, immutableMapA, iD, i13);
                break;
            case "audio/3gpp":
            case "audio/amr-wb":
                com.google.android.exoplayer2.util.a.b(iD == 1, "Multi channel AMR is not currently supported.");
                com.google.android.exoplayer2.util.a.b(!immutableMapA.isEmpty(), "fmtp parameters must include octet-align.");
                com.google.android.exoplayer2.util.a.b(immutableMapA.containsKey("octet-align"), "Only octet aligned mode is currently supported.");
                com.google.android.exoplayer2.util.a.b(!immutableMapA.containsKey("interleaving"), "Interleaving mode is not currently supported.");
                break;
            case "audio/opus":
                com.google.android.exoplayer2.util.a.a(iD != -1);
                com.google.android.exoplayer2.util.a.b(i13 == 48000, "Invalid OPUS clock rate.");
                break;
            case "video/mp4v-es":
                com.google.android.exoplayer2.util.a.a(!immutableMapA.isEmpty());
                h(bVar, immutableMapA);
                break;
            case "video/3gpp":
                bVar.j0(352).Q(288);
                break;
            case "video/avc":
                com.google.android.exoplayer2.util.a.a(!immutableMapA.isEmpty());
                f(bVar, immutableMapA);
                break;
            case "video/hevc":
                com.google.android.exoplayer2.util.a.a(!immutableMapA.isEmpty());
                g(bVar, immutableMapA);
                break;
            case "video/x-vnd.on2.vp8":
                bVar.j0(320).Q(240);
                break;
            case "video/x-vnd.on2.vp9":
                bVar.j0(320).Q(240);
                break;
            case "audio/raw":
                bVar.Y(j.b(str));
                break;
        }
        com.google.android.exoplayer2.util.a.a(i13 > 0);
        return new j(bVar.E(), i12, i13, immutableMapA);
    }

    public static byte[] c(String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        int length = bArrDecode.length;
        byte[] bArr = com.google.android.exoplayer2.util.x.f35652a;
        byte[] bArr2 = new byte[length + bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(bArrDecode, 0, bArr2, bArr.length, bArrDecode.length);
        return bArr2;
    }

    public static int d(int i11, String str) {
        if (i11 != -1) {
            return i11;
        }
        return str.equals(MimeTypes.AUDIO_AC3) ? 6 : 1;
    }

    public static void e(m1.b bVar, ImmutableMap<String, String> immutableMap, int i11, int i12) {
        com.google.android.exoplayer2.util.a.a(immutableMap.containsKey("profile-level-id"));
        bVar.I("mp4a.40." + ((String) com.google.android.exoplayer2.util.a.e(immutableMap.get("profile-level-id"))));
        bVar.T(ImmutableList.of(com.google.android.exoplayer2.audio.a.a(i12, i11)));
    }

    public static void f(m1.b bVar, ImmutableMap<String, String> immutableMap) {
        com.google.android.exoplayer2.util.a.a(immutableMap.containsKey("sprop-parameter-sets"));
        String[] strArrT0 = o0.T0((String) com.google.android.exoplayer2.util.a.e(immutableMap.get("sprop-parameter-sets")), ",");
        com.google.android.exoplayer2.util.a.a(strArrT0.length == 2);
        ImmutableList immutableListOf = ImmutableList.of(c(strArrT0[0]), c(strArrT0[1]));
        bVar.T(immutableListOf);
        byte[] bArr = immutableListOf.get(0);
        com.google.android.exoplayer2.util.x.c cVarL = com.google.android.exoplayer2.util.x.l(bArr, com.google.android.exoplayer2.util.x.f35652a.length, bArr.length);
        bVar.a0(cVarL.f35676h);
        bVar.Q(cVarL.f35675g);
        bVar.j0(cVarL.f35674f);
        String str = immutableMap.get("profile-level-id");
        if (str == null) {
            bVar.I(com.google.android.exoplayer2.util.f.a(cVarL.f35669a, cVarL.f35670b, cVarL.f35671c));
            return;
        }
        bVar.I("avc1." + str);
    }

    public static void g(m1.b bVar, ImmutableMap<String, String> immutableMap) {
        if (immutableMap.containsKey("sprop-max-don-diff")) {
            int i11 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(immutableMap.get("sprop-max-don-diff")));
            com.google.android.exoplayer2.util.a.b(i11 == 0, "non-zero sprop-max-don-diff " + i11 + " is not supported");
        }
        com.google.android.exoplayer2.util.a.a(immutableMap.containsKey("sprop-vps"));
        String str = (String) com.google.android.exoplayer2.util.a.e(immutableMap.get("sprop-vps"));
        com.google.android.exoplayer2.util.a.a(immutableMap.containsKey("sprop-sps"));
        String str2 = (String) com.google.android.exoplayer2.util.a.e(immutableMap.get("sprop-sps"));
        com.google.android.exoplayer2.util.a.a(immutableMap.containsKey("sprop-pps"));
        ImmutableList immutableListOf = ImmutableList.of(c(str), c(str2), c((String) com.google.android.exoplayer2.util.a.e(immutableMap.get("sprop-pps"))));
        bVar.T(immutableListOf);
        byte[] bArr = immutableListOf.get(1);
        com.google.android.exoplayer2.util.x.a aVarH = com.google.android.exoplayer2.util.x.h(bArr, com.google.android.exoplayer2.util.x.f35652a.length, bArr.length);
        bVar.a0(aVarH.f35665j);
        bVar.Q(aVarH.f35664i).j0(aVarH.f35663h);
        bVar.I(com.google.android.exoplayer2.util.f.c(aVarH.f35656a, aVarH.f35657b, aVarH.f35658c, aVarH.f35659d, aVarH.f35660e, aVarH.f35661f));
    }

    public static void h(m1.b bVar, ImmutableMap<String, String> immutableMap) {
        String str = immutableMap.get(XLogUtil.TAG);
        if (str != null) {
            byte[] bArrJ = o0.J(str);
            bVar.T(ImmutableList.of(bArrJ));
            Pair<Integer, Integer> pairF = com.google.android.exoplayer2.util.f.f(bArrJ);
            bVar.j0(((Integer) pairF.first).intValue()).Q(((Integer) pairF.second).intValue());
        } else {
            bVar.j0(352).Q(288);
        }
        String str2 = immutableMap.get("profile-level-id");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mp4v.");
        if (str2 == null) {
            str2 = "1";
        }
        sb2.append(str2);
        bVar.I(sb2.toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        return this.f34607a.equals(tVar.f34607a) && this.f34608b.equals(tVar.f34608b);
    }

    public int hashCode() {
        return ((217 + this.f34607a.hashCode()) * 31) + this.f34608b.hashCode();
    }
}
