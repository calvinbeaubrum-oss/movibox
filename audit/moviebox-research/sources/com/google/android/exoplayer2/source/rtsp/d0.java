package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d0 f34460c = new d0(0, C.TIME_UNSET);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f34461d = Pattern.compile("npt[:=]([.\\d]+|now)\\s?-\\s?([.\\d]+)?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f34462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34463b;

    public d0(long j11, long j12) {
        this.f34462a = j11;
        this.f34463b = j12;
    }

    public static String b(long j11) {
        return o0.C("npt=%.3f-", Double.valueOf(j11 / 1000.0d));
    }

    public static d0 d(String str) throws ParserException {
        long j11;
        Matcher matcher = f34461d.matcher(str);
        y.a(matcher.matches(), str);
        String strGroup = matcher.group(1);
        y.a(strGroup != null, str);
        long j12 = ((String) o0.j(strGroup)).equals("now") ? 0L : (long) (Float.parseFloat(strGroup) * 1000.0f);
        String strGroup2 = matcher.group(2);
        if (strGroup2 != null) {
            try {
                j11 = (long) (Float.parseFloat(strGroup2) * 1000.0f);
                y.a(j11 >= j12, str);
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedManifest(strGroup2, e11);
            }
        } else {
            j11 = C.TIME_UNSET;
        }
        return new d0(j12, j11);
    }

    public long a() {
        return this.f34463b - this.f34462a;
    }

    public boolean c() {
        return this.f34463b == C.TIME_UNSET;
    }
}
