package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
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
public final class WebSocketProtocol {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    public final String acceptHeader(String key) {
        Intrinsics.g(key, "key");
        return ByteString.Companion.encodeUtf8(key + ACCEPT_MAGIC).sha1().base64();
    }

    public final String closeCodeExceptionMessage(int i11) {
        if (i11 < 1000 || i11 >= 5000) {
            return "Code must be in range [1000,5000): " + i11;
        }
        if ((1004 > i11 || 1006 < i11) && (1015 > i11 || 2999 < i11)) {
            return null;
        }
        return "Code " + i11 + " is reserved and may not be used.";
    }

    public final void toggleMask(Buffer.UnsafeCursor cursor, byte[] key) {
        Intrinsics.g(cursor, "cursor");
        Intrinsics.g(key, "key");
        int length = key.length;
        int i11 = 0;
        do {
            byte[] bArr = cursor.data;
            int i12 = cursor.start;
            int i13 = cursor.end;
            if (bArr != null) {
                while (i12 < i13) {
                    int i14 = i11 % length;
                    bArr[i12] = (byte) (bArr[i12] ^ key[i14]);
                    i12++;
                    i11 = i14 + 1;
                }
            }
        } while (cursor.next() != -1);
    }

    public final void validateCloseCode(int i11) {
        String strCloseCodeExceptionMessage = closeCodeExceptionMessage(i11);
        if (strCloseCodeExceptionMessage == null) {
            return;
        }
        Intrinsics.d(strCloseCodeExceptionMessage);
        throw new IllegalArgumentException(strCloseCodeExceptionMessage.toString());
    }
}
