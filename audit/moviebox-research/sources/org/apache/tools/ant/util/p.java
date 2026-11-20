package org.apache.tools.ant.util;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f72993a = System.getProperty("line.separator");

    public static long a(String str) throws Exception {
        long j11;
        char cCharAt = str.charAt(0);
        int i11 = 1;
        long j12 = 1;
        if (cCharAt == '+') {
            str = str.substring(1);
        } else if (cCharAt == '-') {
            str = str.substring(1);
            j12 = -1;
        }
        char cCharAt2 = str.charAt(str.length() - 1);
        if (!Character.isDigit(cCharAt2)) {
            if (cCharAt2 == 'G') {
                j11 = 1073741824;
            } else if (cCharAt2 == 'K') {
                j11 = 1024;
            } else if (cCharAt2 == 'M') {
                j11 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            } else if (cCharAt2 != 'P') {
                if (cCharAt2 != 'T') {
                    i11 = 0;
                } else {
                    j11 = 1099511627776L;
                }
                str = str.substring(0, str.length() - i11);
            } else {
                j11 = 1125899906842624L;
            }
            j12 *= j11;
            str = str.substring(0, str.length() - i11);
        }
        return j12 * Long.parseLong(str);
    }
}
