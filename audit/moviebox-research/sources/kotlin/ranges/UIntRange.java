package kotlin.ranges;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.WasExperimental;
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
@SinceKotlin
@Metadata
@WasExperimental
public final class UIntRange extends UIntProgression implements ClosedRange<UInt>, OpenEndRange<UInt> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f68984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final UIntRange f68985g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        f68984f = new Companion(defaultConstructorMarker);
        f68985g = new UIntRange(-1, 0, defaultConstructorMarker);
    }

    public UIntRange(int i11, int i12) {
        super(i11, i12, 1, null);
    }

    public /* synthetic */ UIntRange(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12);
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean equals(Object obj) {
        if (obj instanceof UIntRange) {
            if (!isEmpty() || !((UIntRange) obj).isEmpty()) {
                UIntRange uIntRange = (UIntRange) obj;
                if (g() != uIntRange.g() || i() != uIntRange.i()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.UIntProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + i();
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean isEmpty() {
        return Integer.compare(g() ^ Integer.MIN_VALUE, i() ^ Integer.MIN_VALUE) > 0;
    }

    @Override // kotlin.ranges.UIntProgression
    public String toString() {
        return ((Object) UInt.e(g())) + ".." + ((Object) UInt.e(i()));
    }
}
