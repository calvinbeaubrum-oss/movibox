package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmInline
@SourceDebugExtension
public final class a4 implements Comparable<a4> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3974a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final short f3975b = b(5120);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final short f3976c = b(-1025);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final short f3977d = b(31743);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final short f3978f = b(1024);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final short f3979g = b(1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final short f3980h = b(32256);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final short f3981i = b(-1024);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final short f3982j = b(Short.MIN_VALUE);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final short f3983k = b(31744);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final short f3984l = b(0);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static short a(float f11) {
        int i11;
        int iFloatToRawIntBits = Float.floatToRawIntBits(f11);
        int i12 = iFloatToRawIntBits >>> 31;
        int i13 = (iFloatToRawIntBits >>> 23) & 255;
        int i14 = 8388607 & iFloatToRawIntBits;
        int i15 = 31;
        int i16 = 0;
        if (i13 != 255) {
            int i17 = i13 - 112;
            if (i17 >= 31) {
                i15 = 49;
            } else {
                if (i17 > 0) {
                    i16 = i14 >> 13;
                    if ((iFloatToRawIntBits & 4096) != 0) {
                        i11 = (((i17 << 10) | i16) + 1) | (i12 << 15);
                    } else {
                        i15 = i17;
                    }
                    return b((short) i11);
                }
                if (i17 >= -10) {
                    int i18 = (8388608 | i14) >> (1 - i17);
                    if ((i18 & 4096) != 0) {
                        i18 += 8192;
                    }
                    i16 = i18 >> 13;
                }
                i15 = 0;
            }
        } else if (i14 != 0) {
            i16 = 512;
        }
        i11 = (i12 << 15) | (i15 << 10) | i16;
        return b((short) i11);
    }

    public static short b(short s11) {
        return s11;
    }
}
