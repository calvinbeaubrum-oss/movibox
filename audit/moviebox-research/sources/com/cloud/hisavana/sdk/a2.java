package com.cloud.hisavana.sdk;

import android.os.Build;
import android.text.TextUtils;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a2 f29104e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Cipher f29107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Cipher f29108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f29103d = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f29105f = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ a2 a(a aVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = aVar.c();
            }
            return aVar.b(str);
        }

        public final synchronized a2 b(String id2) {
            a2 a2Var;
            Intrinsics.g(id2, "id");
            a2Var = a2.f29104e;
            if (a2Var == null) {
                a2Var = new a2(id2);
                a2.f29104e = a2Var;
            }
            return a2Var;
        }

        public final String c() {
            if (TextUtils.isEmpty(a2.f29105f)) {
                a2.f29105f = "ew3s" + d(1, 2) + f() + e();
            }
            return a2.f29105f;
        }

        public final String d(int i11, int i12) {
            int i13 = i11 * i12;
            if (1 <= i13) {
                while (true) {
                    int i14 = ((i14 % i11 == 0 && i14 % i12 == 0) || i14 == i13) ? 1 : i14 + 1;
                }
            }
            return "U3N0";
        }

        public final String e() {
            String string = com.cloud.sdk.commonutil.util.f.a().getResources().getString(R$string.abk4);
            Intrinsics.f(string, "getContext().resources.getString(R.string.abk4)");
            return string;
        }

        public final String f() {
            return "Gdef";
        }
    }

    public a2(String secretKey) {
        Intrinsics.g(secretKey, "secretKey");
        this.f29106a = "AttrUtil";
        try {
            byte[] bytes = secretKey.getBytes(Charsets.f69091b);
            Intrinsics.f(bytes, "getBytes(...)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            this.f29107b = Cipher.getInstance("AES");
            this.f29108c = Cipher.getInstance("AES");
            Cipher cipher = this.f29107b;
            if (cipher != null) {
                cipher.init(1, secretKeySpec);
            }
            Cipher cipher2 = this.f29108c;
            if (cipher2 != null) {
                cipher2.init(2, secretKeySpec);
            }
        } catch (Exception e11) {
            z.a().e(this.f29106a, "e: " + e11);
        }
    }

    public final String e(String str) {
        if (str != null && !kotlin.text.l.y(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256);
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.f(UTF_8, "UTF_8");
                byte[] bytes = str.getBytes(UTF_8);
                Intrinsics.f(bytes, "getBytes(...)");
                byte[] hash = messageDigest.digest(bytes);
                StringBuilder sb2 = new StringBuilder();
                Intrinsics.f(hash, "hash");
                for (byte b11 : hash) {
                    String hexString = Integer.toHexString(b11 & 255);
                    if (hexString.length() == 1) {
                        sb2.append('0');
                    }
                    sb2.append(hexString);
                }
                String string = sb2.toString();
                Intrinsics.f(string, "hexString.toString()");
                return string;
            } catch (NoSuchAlgorithmException e11) {
                z.a().e("SHA-256 algorithm not found, e: " + e11);
            }
        }
        return "";
    }

    public final String f(String str) {
        byte[] bArrDoFinal;
        String strEncodeToString;
        String str2;
        if (str != null && !kotlin.text.l.y(str)) {
            try {
                Cipher cipher = this.f29107b;
                if (cipher != null) {
                    byte[] bytes = str.getBytes(Charsets.f69091b);
                    Intrinsics.f(bytes, "getBytes(...)");
                    bArrDoFinal = cipher.doFinal(bytes);
                } else {
                    bArrDoFinal = null;
                }
                if (bArrDoFinal == null) {
                    return "";
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    strEncodeToString = Base64.getEncoder().encodeToString(bArrDoFinal);
                    str2 = "{\n                Base64…(encrypted)\n            }";
                } else {
                    strEncodeToString = android.util.Base64.encodeToString(bArrDoFinal, 2);
                    str2 = "{\n                androi…64.NO_WRAP)\n            }";
                }
                Intrinsics.f(strEncodeToString, str2);
                return strEncodeToString;
            } catch (Exception e11) {
                z.a().e(this.f29106a, "encrypt e: " + e11);
            }
        }
        return "";
    }
}
