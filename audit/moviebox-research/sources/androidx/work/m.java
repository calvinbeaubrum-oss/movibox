package androidx.work;

import android.os.Build;
import java.util.concurrent.TimeUnit;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class m extends r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f13575e = new b(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends r.a<a, m> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class<? extends i> workerClass, long j11, TimeUnit repeatIntervalTimeUnit) {
            super(workerClass);
            Intrinsics.g(workerClass, "workerClass");
            Intrinsics.g(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
            h().k(repeatIntervalTimeUnit.toMillis(j11));
        }

        @Override // androidx.work.r.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public m c() {
            if (d() && Build.VERSION.SDK_INT >= 23 && h().f76208j.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job".toString());
            }
            if (!h().f76215q) {
                return new m(this);
            }
            throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited".toString());
        }

        @Override // androidx.work.r.a
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public a g() {
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(a builder) {
        super(builder.e(), builder.h(), builder.f());
        Intrinsics.g(builder, "builder");
    }
}
