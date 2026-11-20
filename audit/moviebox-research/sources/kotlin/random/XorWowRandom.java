package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class XorWowRandom extends Random implements Serializable {
    private static final a Companion = new a(null);
    private static final long serialVersionUID = 0;
    private int addend;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f68945v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f68946w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f68947x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f68948y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f68949z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public XorWowRandom(int i11, int i12) {
        this(i11, i12, 0, 0, ~i11, (i11 << 10) ^ (i12 >>> 4));
    }

    public XorWowRandom(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f68947x = i11;
        this.f68948y = i12;
        this.f68949z = i13;
        this.f68946w = i14;
        this.f68945v = i15;
        this.addend = i16;
        if ((i11 | i12 | i13 | i14 | i15) == 0) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i17 = 0; i17 < 64; i17++) {
            nextInt();
        }
    }

    @Override // kotlin.random.Random
    public int nextBits(int i11) {
        return RandomKt.g(nextInt(), i11);
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        int i11 = this.f68947x;
        int i12 = i11 ^ (i11 >>> 2);
        this.f68947x = this.f68948y;
        this.f68948y = this.f68949z;
        this.f68949z = this.f68946w;
        int i13 = this.f68945v;
        this.f68946w = i13;
        int i14 = ((i12 ^ (i12 << 1)) ^ i13) ^ (i13 << 4);
        this.f68945v = i14;
        int i15 = this.addend + 362437;
        this.addend = i15;
        return i14 + i15;
    }
}
