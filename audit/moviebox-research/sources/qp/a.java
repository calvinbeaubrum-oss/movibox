package qp;

import com.applovin.exoplayer2.common.base.Ascii;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0819a f74869a = new C0819a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f74870b = {"0", "1", "2", "3", "4", "5", PrepareException.ERROR_NO_URL, "7", PrepareException.ERROR_MANIFEST_INFO, PrepareException.ERROR_MINI_APP_CLOSE, "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "e", "f"};

    /* JADX INFO: renamed from: qp.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0819a {
        public C0819a() {
        }

        public /* synthetic */ C0819a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String a(String data) {
            Intrinsics.g(data, "data");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bytes = data.getBytes(Charsets.f69091b);
                Intrinsics.f(bytes, "this as java.lang.String).getBytes(charset)");
                byte[] bArrDigest = messageDigest.digest(bytes);
                Intrinsics.f(bArrDigest, "getInstance(encoder).digest(data.toByteArray())");
                return b(bArrDigest);
            } catch (Exception e11) {
                e11.printStackTrace();
                return data;
            }
        }

        public final String b(byte[] bArr) {
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b11 : bArr) {
                stringBuffer.append(c(b11));
            }
            String string = stringBuffer.toString();
            Intrinsics.f(string, "resultSb.toString()");
            return string;
        }

        public final String c(byte b11) {
            int i11 = b11;
            if (b11 < 0) {
                i11 = b11 + Ascii.NUL;
            }
            return a.f74870b[i11 / 16] + a.f74870b[i11 % 16];
        }

        public final String d(String buf) {
            Intrinsics.g(buf, "buf");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                Intrinsics.f(messageDigest, "getInstance(\"MD5\")");
                Charset charsetForName = Charset.forName("UTF-8");
                Intrinsics.f(charsetForName, "forName(charsetName)");
                byte[] bytes = buf.getBytes(charsetForName);
                Intrinsics.f(bytes, "this as java.lang.String).getBytes(charset)");
                messageDigest.update(bytes);
                String tempString = new BigInteger(1, messageDigest.digest()).toString(16);
                if (tempString.length() >= 32) {
                    Intrinsics.f(tempString, "tempString");
                    return tempString;
                }
                String str = "";
                for (int i11 = 0; i11 < 32 - tempString.length(); i11++) {
                    str = "0" + str;
                }
                return str + tempString;
            } catch (Exception e11) {
                e11.printStackTrace();
                return buf;
            }
        }
    }
}
