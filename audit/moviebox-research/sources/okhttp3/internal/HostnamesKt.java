package okhttp3.internal;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import okio.Buffer;

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
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            if (Intrinsics.i(cCharAt, 31) <= 0 || Intrinsics.i(cCharAt, 127) >= 0 || StringsKt__StringsKt.c0(" #%/:?@[\\]", cCharAt, 0, false, 6, null) != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i11, int i12, byte[] bArr, int i13) {
        int i14 = i13;
        while (i11 < i12) {
            if (i14 == bArr.length) {
                return false;
            }
            if (i14 != i13) {
                if (str.charAt(i11) != '.') {
                    return false;
                }
                i11++;
            }
            int i15 = i11;
            int i16 = 0;
            while (i15 < i12) {
                char cCharAt = str.charAt(i15);
                if (Intrinsics.i(cCharAt, 48) < 0 || Intrinsics.i(cCharAt, 57) > 0) {
                    break;
                }
                if ((i16 == 0 && i11 != i15) || (i16 = ((i16 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i15++;
            }
            if (i15 - i11 == 0) {
                return false;
            }
            bArr[i14] = (byte) i16;
            i14++;
            i11 = i15;
        }
        return i14 == i13 + 4;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0076 A[LOOP:1: B:30:0x0069->B:34:0x0076, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x007c A[EDGE_INSN: B:55:0x007c->B:35:0x007c BREAK  A[LOOP:1: B:30:0x0069->B:34:0x0076], SYNTHETIC] */
    private static final InetAddress decodeIpv6(String str, int i11, int i12) {
        int i13;
        int i14;
        int hexDigit;
        byte[] bArr = new byte[16];
        int i15 = i11;
        int i16 = 0;
        int i17 = -1;
        int i18 = -1;
        while (i15 < i12) {
            if (i16 == 16) {
                return null;
            }
            int i19 = i15 + 2;
            if (i19 <= i12 && l.K(str, "::", i15, false, 4, null)) {
                if (i17 != -1) {
                    return null;
                }
                i16 += 2;
                if (i19 == i12) {
                    i17 = i16;
                    break;
                }
                i18 = i19;
                i17 = i16;
                i15 = i18;
                i13 = 0;
                while (i15 < i12) {
                    hexDigit = Util.parseHexDigit(str.charAt(i15));
                    if (hexDigit == -1) {
                        break;
                        break;
                    }
                    i13 = (i13 << 4) + hexDigit;
                    i15++;
                }
                i14 = i15 - i18;
                if (i14 != 0) {
                }
                return null;
            }
            if (i16 != 0) {
                if (!l.K(str, ":", i15, false, 4, null)) {
                    if (!l.K(str, InstructionFileId.DOT, i15, false, 4, null) || !decodeIpv4Suffix(str, i18, i12, bArr, i16 - 2)) {
                        return null;
                    }
                    i16 += 2;
                    break;
                }
                i15++;
            }
            i18 = i15;
            i15 = i18;
            i13 = 0;
            while (i15 < i12) {
                hexDigit = Util.parseHexDigit(str.charAt(i15));
                if (hexDigit == -1) {
                    break;
                }
                i13 = (i13 << 4) + hexDigit;
                i15++;
            }
            i14 = i15 - i18;
            if (i14 != 0 || i14 > 4) {
                return null;
            }
            int i21 = i16 + 1;
            bArr[i16] = (byte) ((i13 >>> 8) & 255);
            i16 += 2;
            bArr[i21] = (byte) (i13 & 255);
        }
        if (i16 != 16) {
            if (i17 == -1) {
                return null;
            }
            int i22 = i16 - i17;
            System.arraycopy(bArr, i17, bArr, 16 - i22, i22);
            Arrays.fill(bArr, i17, (16 - i16) + i17, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i11 = -1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i13 < bArr.length) {
            int i15 = i13;
            while (i15 < 16 && bArr[i15] == 0 && bArr[i15 + 1] == 0) {
                i15 += 2;
            }
            int i16 = i15 - i13;
            if (i16 > i14 && i16 >= 4) {
                i11 = i13;
                i14 = i16;
            }
            i13 = i15 + 2;
        }
        Buffer buffer = new Buffer();
        while (i12 < bArr.length) {
            if (i12 == i11) {
                buffer.writeByte(58);
                i12 += i14;
                if (i12 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i12 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((Util.and(bArr[i12], 255) << 8) | Util.and(bArr[i12 + 1], 255));
                i12 += 2;
            }
        }
        return buffer.readUtf8();
    }

    public static final String toCanonicalHost(String toCanonicalHost) {
        Intrinsics.g(toCanonicalHost, "$this$toCanonicalHost");
        if (!StringsKt__StringsKt.Q(toCanonicalHost, ":", false, 2, null)) {
            try {
                String ascii = IDN.toASCII(toCanonicalHost);
                Intrinsics.f(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                Intrinsics.f(locale, "Locale.US");
                if (ascii == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = ascii.toLowerCase(locale);
                Intrinsics.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() != 0 && !containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return lowerCase;
                }
                return null;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressDecodeIpv6 = (l.L(toCanonicalHost, "[", false, 2, null) && l.u(toCanonicalHost, "]", false, 2, null)) ? decodeIpv6(toCanonicalHost, 1, toCanonicalHost.length() - 1) : decodeIpv6(toCanonicalHost, 0, toCanonicalHost.length());
        if (inetAddressDecodeIpv6 == null) {
            return null;
        }
        byte[] address = inetAddressDecodeIpv6.getAddress();
        if (address.length == 16) {
            Intrinsics.f(address, "address");
            return inet6AddressToAscii(address);
        }
        if (address.length == 4) {
            return inetAddressDecodeIpv6.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + toCanonicalHost + '\'');
    }
}
