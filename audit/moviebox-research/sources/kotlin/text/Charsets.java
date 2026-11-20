package kotlin.text;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

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
public final class Charsets {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charsets f69090a = new Charsets();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public static final Charset f69091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public static final Charset f69092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public static final Charset f69093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public static final Charset f69094e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JvmField
    public static final Charset f69095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public static final Charset f69096g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile Charset f69097h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile Charset f69098i;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.f(charsetForName, "forName(...)");
        f69091b = charsetForName;
        Charset charsetForName2 = Charset.forName(C.UTF16_NAME);
        Intrinsics.f(charsetForName2, "forName(...)");
        f69092c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        Intrinsics.f(charsetForName3, "forName(...)");
        f69093d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        Intrinsics.f(charsetForName4, "forName(...)");
        f69094e = charsetForName4;
        Charset charsetForName5 = Charset.forName(C.ASCII_NAME);
        Intrinsics.f(charsetForName5, "forName(...)");
        f69095f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        Intrinsics.f(charsetForName6, "forName(...)");
        f69096g = charsetForName6;
    }

    private Charsets() {
    }

    @JvmName
    public final Charset a() {
        Charset charset = f69098i;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        Intrinsics.f(charsetForName, "forName(...)");
        f69098i = charsetForName;
        return charsetForName;
    }

    @JvmName
    public final Charset b() {
        Charset charset = f69097h;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        Intrinsics.f(charsetForName, "forName(...)");
        f69097h = charsetForName;
        return charsetForName;
    }
}
