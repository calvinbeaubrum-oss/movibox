package androidx.compose.animation.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

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
public final class w0 {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<g0> f2153a;

        /* JADX WARN: Incorrect types in method signature: (TV;FF)V */
        public a(o oVar, float f11, float f12) {
            IntRange intRangeR = kotlin.ranges.a.r(0, oVar.b());
            ArrayList arrayList = new ArrayList(kotlin.collections.h.v(intRangeR, 10));
            Iterator<Integer> it = intRangeR.iterator();
            while (it.hasNext()) {
                arrayList.add(new g0(f11, f12, oVar.a(((IntIterator) it).a())));
            }
            this.f2153a = arrayList;
        }

        @Override // androidx.compose.animation.core.q
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g0 get(int i11) {
            return this.f2153a.get(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g0 f2154a;

        public b(float f11, float f12) {
            this.f2154a = new g0(f11, f12, 0.0f, 4, null);
        }

        @Override // androidx.compose.animation.core.q
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g0 get(int i11) {
            return this.f2154a;
        }
    }

    public static final <V extends o> q b(V v11, float f11, float f12) {
        return v11 != null ? new a(v11, f11, f12) : new b(f11, f12);
    }
}
