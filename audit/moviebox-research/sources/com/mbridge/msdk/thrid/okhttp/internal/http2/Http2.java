package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.ByteString;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class Http2 {
    static final byte FLAG_ACK = 1;
    static final byte FLAG_COMPRESSED = 32;
    static final byte FLAG_END_HEADERS = 4;
    static final byte FLAG_END_PUSH_PROMISE = 4;
    static final byte FLAG_END_STREAM = 1;
    static final byte FLAG_NONE = 0;
    static final byte FLAG_PADDED = 8;
    static final byte FLAG_PRIORITY = 32;
    static final int INITIAL_MAX_FRAME_SIZE = 16384;
    static final byte TYPE_CONTINUATION = 9;
    static final byte TYPE_DATA = 0;
    static final byte TYPE_GOAWAY = 7;
    static final byte TYPE_HEADERS = 1;
    static final byte TYPE_PING = 6;
    static final byte TYPE_PRIORITY = 2;
    static final byte TYPE_PUSH_PROMISE = 5;
    static final byte TYPE_RST_STREAM = 3;
    static final byte TYPE_SETTINGS = 4;
    static final byte TYPE_WINDOW_UPDATE = 8;
    static final ByteString CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] FLAGS = new String[64];
    static final String[] BINARY = new String[256];

    static {
        int i11 = 0;
        int i12 = 0;
        while (true) {
            String[] strArr = BINARY;
            if (i12 >= strArr.length) {
                break;
            }
            strArr[i12] = Util.format("%8s", Integer.toBinaryString(i12)).replace(' ', '0');
            i12++;
        }
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i13 = iArr[0];
        strArr2[i13 | 8] = strArr2[i13] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i14 = 0; i14 < 3; i14++) {
            int i15 = iArr2[i14];
            int i16 = iArr[0];
            String[] strArr3 = FLAGS;
            int i17 = i16 | i15;
            strArr3[i17] = strArr3[i16] + '|' + strArr3[i15];
            strArr3[i17 | 8] = strArr3[i16] + '|' + strArr3[i15] + "|PADDED";
        }
        while (true) {
            String[] strArr4 = FLAGS;
            if (i11 >= strArr4.length) {
                return;
            }
            if (strArr4[i11] == null) {
                strArr4[i11] = BINARY[i11];
            }
            i11++;
        }
    }

    private Http2() {
    }

    public static String formatFlags(byte b11, byte b12) {
        if (b12 == 0) {
            return "";
        }
        if (b11 != 2 && b11 != 3) {
            if (b11 == 4 || b11 == 6) {
                return b12 == 1 ? "ACK" : BINARY[b12];
            }
            if (b11 != 7 && b11 != 8) {
                String[] strArr = FLAGS;
                String str = b12 < strArr.length ? strArr[b12] : BINARY[b12];
                if (b11 != 5 || (b12 & 4) == 0) {
                    return (b11 != 0 || (b12 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return BINARY[b12];
    }

    public static String frameLog(boolean z11, int i11, int i12, byte b11, byte b12) {
        String[] strArr = FRAME_NAMES;
        String str = b11 < strArr.length ? strArr[b11] : Util.format("0x%02x", Byte.valueOf(b11));
        String flags = formatFlags(b11, b12);
        Object[] objArr = new Object[5];
        objArr[0] = z11 ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i11);
        objArr[2] = Integer.valueOf(i12);
        objArr[3] = str;
        objArr[4] = flags;
        return Util.format("%s 0x%08x %5d %-13s %s", objArr);
    }

    public static IllegalArgumentException illegalArgument(String str, Object... objArr) {
        throw new IllegalArgumentException(Util.format(str, objArr));
    }

    public static IOException ioException(String str, Object... objArr) throws IOException {
        throw new IOException(Util.format(str, objArr));
    }
}
