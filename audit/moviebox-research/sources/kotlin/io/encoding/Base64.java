package kotlin.io.encoding;

import com.applovin.exoplayer2.common.base.Ascii;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
@ExperimentalEncodingApi
@SinceKotlin
@Metadata
public class Base64 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Default f68864c = new Default(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f68865d = {Ascii.CR, 10};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Base64 f68866e = new Base64(true, false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Base64 f68867f = new Base64(false, true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f68868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f68869b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Default extends Base64 {
        /* JADX WARN: Illegal instructions before constructor call */
        private Default() {
            boolean z11 = false;
            super(z11, z11, null);
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Base64(boolean z11, boolean z12) {
        this.f68868a = z11;
        this.f68869b = z12;
        if (z11 && z12) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public /* synthetic */ Base64(boolean z11, boolean z12, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, z12);
    }
}
