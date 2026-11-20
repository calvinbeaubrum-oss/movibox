package d9;

import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f62955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f62956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DiffUtil.e<T> f62957c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0648a f62958d = new C0648a(null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Object f62959e = new Object();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static Executor f62960f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DiffUtil.e<T> f62961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Executor f62962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Executor f62963c;

        /* JADX INFO: renamed from: d9.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0648a {
            public C0648a() {
            }

            public /* synthetic */ C0648a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(DiffUtil.e<T> mDiffCallback) {
            Intrinsics.g(mDiffCallback, "mDiffCallback");
            this.f62961a = mDiffCallback;
        }

        public final b<T> a() {
            if (this.f62963c == null) {
                synchronized (f62959e) {
                    try {
                        if (f62960f == null) {
                            f62960f = Executors.newFixedThreadPool(2);
                        }
                        Unit unit = Unit.f68710a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                this.f62963c = f62960f;
            }
            Executor executor = this.f62962b;
            Executor executor2 = this.f62963c;
            Intrinsics.d(executor2);
            return new b<>(executor, executor2, this.f62961a);
        }
    }

    public b(Executor executor, Executor backgroundThreadExecutor, DiffUtil.e<T> diffCallback) {
        Intrinsics.g(backgroundThreadExecutor, "backgroundThreadExecutor");
        Intrinsics.g(diffCallback, "diffCallback");
        this.f62955a = executor;
        this.f62956b = backgroundThreadExecutor;
        this.f62957c = diffCallback;
    }

    public final Executor a() {
        return this.f62955a;
    }
}
