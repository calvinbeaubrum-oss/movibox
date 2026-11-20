package androidx.window.layout;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class HardwareFoldingFeature implements r {
    public static final a Companion = new a(null);
    private final androidx.window.core.b featureBounds;
    private final r.c state;
    private final Type type;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Type {
        public static final a Companion = new a(null);
        private static final Type FOLD = new Type("FOLD");
        private static final Type HINGE = new Type("HINGE");
        private final String description;

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes2.dex */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Type a() {
                return Type.FOLD;
            }

            public final Type b() {
                return Type.HINGE;
            }
        }

        private Type(String str) {
            this.description = str;
        }

        public String toString() {
            return this.description;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(androidx.window.core.b bounds) {
            Intrinsics.g(bounds, "bounds");
            if (bounds.d() == 0 && bounds.a() == 0) {
                throw new IllegalArgumentException("Bounds must be non zero".toString());
            }
            if (bounds.b() != 0 && bounds.c() != 0) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features".toString());
            }
        }
    }

    public HardwareFoldingFeature(androidx.window.core.b featureBounds, Type type, r.c state) {
        Intrinsics.g(featureBounds, "featureBounds");
        Intrinsics.g(type, "type");
        Intrinsics.g(state, "state");
        this.featureBounds = featureBounds;
        this.type = type;
        this.state = state;
        Companion.a(featureBounds);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.b(HardwareFoldingFeature.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        }
        HardwareFoldingFeature hardwareFoldingFeature = (HardwareFoldingFeature) obj;
        return Intrinsics.b(this.featureBounds, hardwareFoldingFeature.featureBounds) && Intrinsics.b(this.type, hardwareFoldingFeature.type) && Intrinsics.b(getState(), hardwareFoldingFeature.getState());
    }

    @Override // androidx.window.layout.l
    public Rect getBounds() {
        return this.featureBounds.f();
    }

    public r.a getOcclusionType() {
        return (this.featureBounds.d() == 0 || this.featureBounds.a() == 0) ? r.a.f13200c : r.a.f13201d;
    }

    @Override // androidx.window.layout.r
    public r.b getOrientation() {
        return this.featureBounds.d() > this.featureBounds.a() ? r.b.f13205d : r.b.f13204c;
    }

    @Override // androidx.window.layout.r
    public r.c getState() {
        return this.state;
    }

    public final Type getType$window_release() {
        return this.type;
    }

    public int hashCode() {
        return (((this.featureBounds.hashCode() * 31) + this.type.hashCode()) * 31) + getState().hashCode();
    }

    @Override // androidx.window.layout.r
    public boolean isSeparating() {
        Type type = this.type;
        Type.a aVar = Type.Companion;
        if (Intrinsics.b(type, aVar.b())) {
            return true;
        }
        return Intrinsics.b(this.type, aVar.a()) && Intrinsics.b(getState(), r.c.f13209d);
    }

    public String toString() {
        return ((Object) HardwareFoldingFeature.class.getSimpleName()) + " { " + this.featureBounds + ", type=" + this.type + ", state=" + getState() + " }";
    }
}
