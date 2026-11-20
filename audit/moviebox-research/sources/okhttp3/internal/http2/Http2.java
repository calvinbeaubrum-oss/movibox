package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import okhttp3.internal.Util;
import okio.ByteString;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class Http2 {
    private static final String[] BINARY;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;
    public static final Http2 INSTANCE = new Http2();

    @JvmField
    public static final ByteString CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    private static final String[] FLAGS = new String[64];

    static {
        String[] strArr = new String[256];
        for (int i11 = 0; i11 < 256; i11++) {
            String binaryString = Integer.toBinaryString(i11);
            Intrinsics.f(binaryString, "Integer.toBinaryString(it)");
            strArr[i11] = l.E(Util.format("%8s", binaryString), ' ', '0', false, 4, null);
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i12 = iArr[0];
        strArr2[i12 | 8] = Intrinsics.p(strArr2[i12], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i13 = 0; i13 < 3; i13++) {
            int i14 = iArr2[i13];
            int i15 = iArr[0];
            String[] strArr3 = FLAGS;
            int i16 = i15 | i14;
            strArr3[i16] = strArr3[i15] + "|" + strArr3[i14];
            strArr3[i16 | 8] = strArr3[i15] + "|" + strArr3[i14] + "|PADDED";
        }
        int length = FLAGS.length;
        for (int i17 = 0; i17 < length; i17++) {
            String[] strArr4 = FLAGS;
            if (strArr4[i17] == null) {
                strArr4[i17] = BINARY[i17];
            }
        }
    }

    private Http2() {
    }

    public final String formatFlags(int i11, int i12) {
        String str;
        if (i12 == 0) {
            return "";
        }
        if (i11 != 2 && i11 != 3) {
            if (i11 == 4 || i11 == 6) {
                return i12 == 1 ? "ACK" : BINARY[i12];
            }
            if (i11 != 7 && i11 != 8) {
                String[] strArr = FLAGS;
                if (i12 < strArr.length) {
                    str = strArr[i12];
                    Intrinsics.d(str);
                } else {
                    str = BINARY[i12];
                }
                String str2 = str;
                if (i11 != 5 || (i12 & 4) == 0) {
                    return (i11 != 0 || (i12 & 32) == 0) ? str2 : l.F(str2, "PRIORITY", "COMPRESSED", false, 4, null);
                }
                return l.F(str2, "HEADERS", "PUSH_PROMISE", false, 4, null);
            }
        }
        return BINARY[i12];
    }

    public final String formattedType$okhttp(int i11) {
        String[] strArr = FRAME_NAMES;
        return i11 < strArr.length ? strArr[i11] : Util.format("0x%02x", Integer.valueOf(i11));
    }

    public final String frameLog(boolean z11, int i11, int i12, int i13, int i14) {
        return Util.format("%s 0x%08x %5d %-13s %s", z11 ? "<<" : ">>", Integer.valueOf(i11), Integer.valueOf(i12), formattedType$okhttp(i13), formatFlags(i13, i14));
    }
}
