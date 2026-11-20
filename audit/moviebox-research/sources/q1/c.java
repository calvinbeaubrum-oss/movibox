package q1;

import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.i;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f74150a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ColorSchemeKeyTokens f74151b = ColorSchemeKeyTokens.OnSurface;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f74152c = i.h((float) 24.0d);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ColorSchemeKeyTokens f74153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ColorSchemeKeyTokens f74154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ColorSchemeKeyTokens f74155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ColorSchemeKeyTokens f74156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ShapeKeyTokens f74157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f74158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ColorSchemeKeyTokens f74159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ColorSchemeKeyTokens f74160k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ColorSchemeKeyTokens f74161l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ColorSchemeKeyTokens f74162m;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Primary;
        f74153d = colorSchemeKeyTokens;
        f74154e = colorSchemeKeyTokens;
        f74155f = colorSchemeKeyTokens;
        f74156g = colorSchemeKeyTokens;
        f74157h = ShapeKeyTokens.CornerFull;
        f74158i = i.h((float) 40.0d);
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurfaceVariant;
        f74159j = colorSchemeKeyTokens2;
        f74160k = colorSchemeKeyTokens2;
        f74161l = colorSchemeKeyTokens2;
        f74162m = colorSchemeKeyTokens2;
    }

    public final float a() {
        return f74152c;
    }
}
