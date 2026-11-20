package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public abstract class Lifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicReference<Object> f8655a = new AtomicReference<>(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static final a Companion = new a(null);

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes2.dex */
        @Metadata
        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.Lifecycle$Event$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            public /* synthetic */ class C0084a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f8656a;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[State.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f8656a = iArr;
                }
            }

            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final Event a(State state) {
                Intrinsics.g(state, "state");
                int i11 = C0084a.f8656a[state.ordinal()];
                if (i11 == 1) {
                    return Event.ON_DESTROY;
                }
                if (i11 == 2) {
                    return Event.ON_STOP;
                }
                if (i11 != 3) {
                    return null;
                }
                return Event.ON_PAUSE;
            }

            @JvmStatic
            public final Event b(State state) {
                Intrinsics.g(state, "state");
                int i11 = C0084a.f8656a[state.ordinal()];
                if (i11 == 1) {
                    return Event.ON_STOP;
                }
                if (i11 == 2) {
                    return Event.ON_PAUSE;
                }
                if (i11 != 4) {
                    return null;
                }
                return Event.ON_DESTROY;
            }

            @JvmStatic
            public final Event c(State state) {
                Intrinsics.g(state, "state");
                int i11 = C0084a.f8656a[state.ordinal()];
                if (i11 == 1) {
                    return Event.ON_START;
                }
                if (i11 == 2) {
                    return Event.ON_RESUME;
                }
                if (i11 != 5) {
                    return null;
                }
                return Event.ON_CREATE;
            }

            @JvmStatic
            public final Event d(State state) {
                Intrinsics.g(state, "state");
                int i11 = C0084a.f8656a[state.ordinal()];
                if (i11 == 1) {
                    return Event.ON_CREATE;
                }
                if (i11 == 2) {
                    return Event.ON_START;
                }
                if (i11 != 3) {
                    return null;
                }
                return Event.ON_RESUME;
            }
        }

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes2.dex */
        @Metadata
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f8657a;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f8657a = iArr;
            }
        }

        @JvmStatic
        public static final Event downFrom(State state) {
            return Companion.a(state);
        }

        @JvmStatic
        public static final Event downTo(State state) {
            return Companion.b(state);
        }

        @JvmStatic
        public static final Event upFrom(State state) {
            return Companion.c(state);
        }

        @JvmStatic
        public static final Event upTo(State state) {
            return Companion.d(state);
        }

        public final State getTargetState() {
            switch (b.f8657a[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean isAtLeast(State state) {
            Intrinsics.g(state, "state");
            return compareTo(state) >= 0;
        }
    }

    public abstract void a(t tVar);

    public abstract State b();

    public final AtomicReference<Object> c() {
        return this.f8655a;
    }

    public abstract void d(t tVar);
}
