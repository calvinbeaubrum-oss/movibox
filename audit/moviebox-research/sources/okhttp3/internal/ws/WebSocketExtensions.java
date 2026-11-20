package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.k;
import kotlin.text.l;
import okhttp3.Headers;
import okhttp3.internal.Util;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";

    @JvmField
    public final Integer clientMaxWindowBits;

    @JvmField
    public final boolean clientNoContextTakeover;

    @JvmField
    public final boolean perMessageDeflate;

    @JvmField
    public final Integer serverMaxWindowBits;

    @JvmField
    public final boolean serverNoContextTakeover;

    @JvmField
    public final boolean unknownValues;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:28:0x008b A[PHI: r7 r9
  0x008b: PHI (r7v6 java.lang.Integer) = (r7v4 java.lang.Integer), (r7v4 java.lang.Integer), (r7v7 java.lang.Integer) binds: [B:47:0x00ba, B:44:0x00b1, B:27:0x0089] A[DONT_GENERATE, DONT_INLINE]
  0x008b: PHI (r9v7 java.lang.Integer) = (r9v4 java.lang.Integer), (r9v5 java.lang.Integer), (r9v4 java.lang.Integer) binds: [B:47:0x00ba, B:44:0x00b1, B:27:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
        public final WebSocketExtensions parse(Headers responseHeaders) throws IOException {
            Intrinsics.g(responseHeaders, "responseHeaders");
            int size = responseHeaders.size();
            boolean z11 = false;
            Integer num = null;
            boolean z12 = false;
            Integer num2 = null;
            boolean z13 = false;
            boolean z14 = false;
            for (int i11 = 0; i11 < size; i11++) {
                if (l.v(responseHeaders.name(i11), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true)) {
                    String strValue = responseHeaders.value(i11);
                    int i12 = 0;
                    while (i12 < strValue.length()) {
                        int iDelimiterOffset$default = Util.delimiterOffset$default(strValue, ',', i12, 0, 4, (Object) null);
                        int iDelimiterOffset = Util.delimiterOffset(strValue, ';', i12, iDelimiterOffset$default);
                        String strTrimSubstring = Util.trimSubstring(strValue, i12, iDelimiterOffset);
                        int i13 = iDelimiterOffset + 1;
                        if (l.v(strTrimSubstring, "permessage-deflate", true)) {
                            if (z11) {
                                z14 = true;
                            }
                            while (i13 < iDelimiterOffset$default) {
                                int iDelimiterOffset2 = Util.delimiterOffset(strValue, ';', i13, iDelimiterOffset$default);
                                int iDelimiterOffset3 = Util.delimiterOffset(strValue, '=', i13, iDelimiterOffset2);
                                String strTrimSubstring2 = Util.trimSubstring(strValue, i13, iDelimiterOffset3);
                                String strW0 = iDelimiterOffset3 < iDelimiterOffset2 ? StringsKt__StringsKt.w0(Util.trimSubstring(strValue, iDelimiterOffset3 + 1, iDelimiterOffset2), "\"") : null;
                                int i14 = iDelimiterOffset2 + 1;
                                if (l.v(strTrimSubstring2, "client_max_window_bits", true)) {
                                    if (num != null) {
                                        z14 = true;
                                    }
                                    Integer numL = strW0 != null ? k.l(strW0) : null;
                                    num = numL;
                                    if (numL == null) {
                                        z14 = true;
                                    }
                                } else if (l.v(strTrimSubstring2, "client_no_context_takeover", true)) {
                                    if (z12) {
                                        z14 = true;
                                    }
                                    if (strW0 != null) {
                                        z14 = true;
                                    }
                                    z12 = true;
                                } else if (l.v(strTrimSubstring2, "server_max_window_bits", true)) {
                                    if (num2 != null) {
                                        z14 = true;
                                    }
                                    Integer numL2 = strW0 != null ? k.l(strW0) : null;
                                    num2 = numL2;
                                    if (numL2 == null) {
                                        z14 = true;
                                    }
                                } else if (l.v(strTrimSubstring2, "server_no_context_takeover", true)) {
                                    if (z13) {
                                        z14 = true;
                                    }
                                    if (strW0 != null) {
                                        z14 = true;
                                    }
                                    z13 = true;
                                } else {
                                    z14 = true;
                                }
                                i13 = i14;
                            }
                            i12 = i13;
                            z11 = true;
                        } else {
                            i12 = i13;
                            z14 = true;
                        }
                    }
                }
            }
            return new WebSocketExtensions(z11, num, z12, num2, z13, z14);
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public WebSocketExtensions(boolean z11, Integer num, boolean z12, Integer num2, boolean z13, boolean z14) {
        this.perMessageDeflate = z11;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z12;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z13;
        this.unknownValues = z14;
    }

    public /* synthetic */ WebSocketExtensions(boolean z11, Integer num, boolean z12, Integer num2, boolean z13, boolean z14, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? false : z12, (i11 & 8) == 0 ? num2 : null, (i11 & 16) != 0 ? false : z13, (i11 & 32) != 0 ? false : z14);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z11, Integer num, boolean z12, Integer num2, boolean z13, boolean z14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = webSocketExtensions.perMessageDeflate;
        }
        if ((i11 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i11 & 4) != 0) {
            z12 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z15 = z12;
        if ((i11 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i11 & 16) != 0) {
            z13 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z16 = z13;
        if ((i11 & 32) != 0) {
            z14 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z11, num3, z15, num4, z16, z14);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z11, Integer num, boolean z12, Integer num2, boolean z13, boolean z14) {
        return new WebSocketExtensions(z11, num, z12, num2, z13, z14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && Intrinsics.b(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && Intrinsics.b(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z11 = this.perMessageDeflate;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        Integer num = this.clientMaxWindowBits;
        int iHashCode = (i11 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z12 = this.clientNoContextTakeover;
        ?? r12 = z12;
        if (z12) {
            r12 = 1;
        }
        int i12 = (iHashCode + r12) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int iHashCode2 = (i12 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z13 = this.serverNoContextTakeover;
        ?? r13 = z13;
        if (z13) {
            r13 = 1;
        }
        int i13 = (iHashCode2 + r13) * 31;
        boolean z14 = this.unknownValues;
        return i13 + (z14 ? 1 : z14);
    }

    public final boolean noContextTakeover(boolean z11) {
        return z11 ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ")";
    }
}
