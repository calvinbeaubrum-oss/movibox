package androidx.work;

import android.os.Build;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.w;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import s6.u;

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
public abstract class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f13576d = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f13577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f13578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f13579c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static abstract class a<B extends a<B, ?>, W extends r> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends i> f13580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f13581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public UUID f13582c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public u f13583d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Set<String> f13584e;

        public a(Class<? extends i> workerClass) {
            Intrinsics.g(workerClass, "workerClass");
            this.f13580a = workerClass;
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.f(uuidRandomUUID, "randomUUID()");
            this.f13582c = uuidRandomUUID;
            String string = this.f13582c.toString();
            Intrinsics.f(string, "id.toString()");
            String name = workerClass.getName();
            Intrinsics.f(name, "workerClass.name");
            this.f13583d = new u(string, name);
            String name2 = workerClass.getName();
            Intrinsics.f(name2, "workerClass.name");
            this.f13584e = w.g(name2);
        }

        public final B a(String tag) {
            Intrinsics.g(tag, "tag");
            this.f13584e.add(tag);
            return (B) g();
        }

        public final W b() {
            W w11 = (W) c();
            androidx.work.b bVar = this.f13583d.f76208j;
            int i11 = Build.VERSION.SDK_INT;
            boolean z11 = (i11 >= 24 && bVar.e()) || bVar.f() || bVar.g() || (i11 >= 23 && bVar.h());
            u uVar = this.f13583d;
            if (uVar.f76215q) {
                if (!(!z11)) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints".toString());
                }
                if (uVar.f76205g > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed".toString());
                }
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.f(uuidRandomUUID, "randomUUID()");
            j(uuidRandomUUID);
            return w11;
        }

        public abstract W c();

        public final boolean d() {
            return this.f13581b;
        }

        public final UUID e() {
            return this.f13582c;
        }

        public final Set<String> f() {
            return this.f13584e;
        }

        public abstract B g();

        public final u h() {
            return this.f13583d;
        }

        public final B i(androidx.work.b constraints) {
            Intrinsics.g(constraints, "constraints");
            this.f13583d.f76208j = constraints;
            return (B) g();
        }

        public final B j(UUID id2) {
            Intrinsics.g(id2, "id");
            this.f13582c = id2;
            String string = id2.toString();
            Intrinsics.f(string, "id.toString()");
            this.f13583d = new u(string, this.f13583d);
            return (B) g();
        }

        public B k(long j11, TimeUnit timeUnit) {
            Intrinsics.g(timeUnit, "timeUnit");
            this.f13583d.f76205g = timeUnit.toMillis(j11);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.f13583d.f76205g) {
                return (B) g();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!".toString());
        }

        public final B l(d inputData) {
            Intrinsics.g(inputData, "inputData");
            this.f13583d.f76203e = inputData;
            return (B) g();
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

    public r(UUID id2, u workSpec, Set<String> tags) {
        Intrinsics.g(id2, "id");
        Intrinsics.g(workSpec, "workSpec");
        Intrinsics.g(tags, "tags");
        this.f13577a = id2;
        this.f13578b = workSpec;
        this.f13579c = tags;
    }

    public UUID a() {
        return this.f13577a;
    }

    public final String b() {
        String string = a().toString();
        Intrinsics.f(string, "id.toString()");
        return string;
    }

    public final Set<String> c() {
        return this.f13579c;
    }

    public final u d() {
        return this.f13578b;
    }
}
