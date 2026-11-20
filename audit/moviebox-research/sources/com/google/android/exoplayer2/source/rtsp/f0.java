package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f34490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f34492c;

    public f0(long j11, int i11, Uri uri) {
        this.f34490a = j11;
        this.f34491b = i11;
        this.f34492c = uri;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0069  */
    public static ImmutableList<f0> a(String str, Uri uri) throws ParserException {
        byte b11;
        ImmutableList.a aVar = new ImmutableList.a();
        String[] strArrT0 = o0.T0(str, ",");
        int length = strArrT0.length;
        char c11 = 0;
        int i11 = 0;
        while (i11 < length) {
            String str2 = strArrT0[i11];
            String[] strArrT1 = o0.T0(str2, ";");
            int length2 = strArrT1.length;
            int i12 = 0;
            Uri uriB = null;
            int i13 = -1;
            long j11 = C.TIME_UNSET;
            while (i12 < length2) {
                String str3 = strArrT1[i12];
                try {
                    String[] strArrU0 = o0.U0(str3, "=");
                    String str4 = strArrU0[c11];
                    String str5 = strArrU0[1];
                    int iHashCode = str4.hashCode();
                    String[] strArr = strArrT0;
                    if (iHashCode != 113759) {
                        if (iHashCode != 116079) {
                            if (iHashCode == 1524180539 && str4.equals("rtptime")) {
                                b11 = 2;
                            } else {
                                b11 = -1;
                            }
                        } else if (str4.equals("url")) {
                            b11 = 0;
                        } else {
                            b11 = -1;
                        }
                    } else if (str4.equals("seq")) {
                        b11 = 1;
                    } else {
                        b11 = -1;
                    }
                    if (b11 == 0) {
                        uriB = b(str5, uri);
                    } else if (b11 == 1) {
                        i13 = Integer.parseInt(str5);
                    } else {
                        if (b11 != 2) {
                            throw ParserException.createForMalformedManifest(str4, null);
                        }
                        j11 = Long.parseLong(str5);
                    }
                    i12++;
                    strArrT0 = strArr;
                    c11 = 0;
                } catch (Exception e11) {
                    throw ParserException.createForMalformedManifest(str3, e11);
                }
            }
            String[] strArr2 = strArrT0;
            if (uriB != null && uriB.getScheme() != null) {
                long j12 = j11;
                if (i13 != -1 || j12 != C.TIME_UNSET) {
                    aVar.a(new f0(j12, i13, uriB));
                    i11++;
                    strArrT0 = strArr2;
                    c11 = 0;
                }
            }
            throw ParserException.createForMalformedManifest(str2, null);
        }
        return aVar.m();
    }

    public static Uri b(String str, Uri uri) {
        com.google.android.exoplayer2.util.a.a(((String) com.google.android.exoplayer2.util.a.e(uri.getScheme())).equals("rtsp"));
        Uri uri2 = Uri.parse(str);
        if (uri2.isAbsolute()) {
            return uri2;
        }
        Uri uri3 = Uri.parse("rtsp://" + str);
        String string = uri.toString();
        if (((String) com.google.android.exoplayer2.util.a.e(uri3.getHost())).equals(uri.getHost())) {
            return uri3;
        }
        if (string.endsWith("/")) {
            return m0.e(string, str);
        }
        return m0.e(string + "/", str);
    }
}
