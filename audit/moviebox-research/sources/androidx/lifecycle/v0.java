package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

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
public class v0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f8780b = new b(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public static final r3.a.b<String> f8781c = s3.g.a.f75956a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r3.c f8782a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static class a extends d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static a f8784f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Application f8786d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f8783e = new b(null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @JvmField
        public static final r3.a.b<Application> f8785g = new C0085a();

        /* JADX INFO: renamed from: androidx.lifecycle.v0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0085a implements r3.a.b<Application> {
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class b {
            public b() {
            }

            public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final a a(Application application) {
                Intrinsics.g(application, "application");
                if (a.f8784f == null) {
                    a.f8784f = new a(application);
                }
                a aVar = a.f8784f;
                Intrinsics.d(aVar);
                return aVar;
            }
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            Intrinsics.g(application, "application");
        }

        public a(Application application, int i11) {
            this.f8786d = application;
        }

        @Override // androidx.lifecycle.v0.d, androidx.lifecycle.v0.c
        public <T extends t0> T create(Class<T> modelClass) {
            Intrinsics.g(modelClass, "modelClass");
            Application application = this.f8786d;
            if (application != null) {
                return (T) e(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.v0.d, androidx.lifecycle.v0.c
        public <T extends t0> T create(Class<T> modelClass, r3.a extras) {
            Intrinsics.g(modelClass, "modelClass");
            Intrinsics.g(extras, "extras");
            if (this.f8786d != null) {
                return (T) create(modelClass);
            }
            Application application = (Application) extras.a(f8785g);
            if (application != null) {
                return (T) e(modelClass, application);
            }
            if (androidx.lifecycle.b.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return (T) super.create(modelClass);
        }

        public final <T extends t0> T e(Class<T> cls, Application application) {
            if (!androidx.lifecycle.b.class.isAssignableFrom(cls)) {
                return (T) super.create(cls);
            }
            try {
                T tNewInstance = cls.getConstructor(Application.class).newInstance(application);
                Intrinsics.f(tNewInstance, "{\n                try {\n…          }\n            }");
                return tNewInstance;
            } catch (IllegalAccessException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (InstantiationException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            } catch (NoSuchMethodException e13) {
                throw new RuntimeException("Cannot create an instance of " + cls, e13);
            } catch (InvocationTargetException e14) {
                throw new RuntimeException("Cannot create an instance of " + cls, e14);
            }
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

        @JvmStatic
        public final v0 a(x0 store, c factory, r3.a extras) {
            Intrinsics.g(store, "store");
            Intrinsics.g(factory, "factory");
            Intrinsics.g(extras, "extras");
            return new v0(store, factory, extras);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface c {
        <T extends t0> T create(Class<T> cls);

        <T extends t0> T create(Class<T> cls, r3.a aVar);

        <T extends t0> T create(KClass<T> kClass, r3.a aVar);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static class d implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static d f8788b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8787a = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public static final r3.a.b<String> f8789c = s3.g.a.f75956a;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final d a() {
                if (d.f8788b == null) {
                    d.f8788b = new d();
                }
                d dVar = d.f8788b;
                Intrinsics.d(dVar);
                return dVar;
            }
        }

        @Override // androidx.lifecycle.v0.c
        public <T extends t0> T create(Class<T> modelClass) {
            Intrinsics.g(modelClass, "modelClass");
            return (T) s3.d.f75950a.a(modelClass);
        }

        @Override // androidx.lifecycle.v0.c
        public <T extends t0> T create(Class<T> modelClass, r3.a extras) {
            Intrinsics.g(modelClass, "modelClass");
            Intrinsics.g(extras, "extras");
            return (T) create(modelClass);
        }

        @Override // androidx.lifecycle.v0.c
        public <T extends t0> T create(KClass<T> modelClass, r3.a extras) {
            Intrinsics.g(modelClass, "modelClass");
            Intrinsics.g(extras, "extras");
            return (T) create(JvmClassMappingKt.a(modelClass), extras);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static class e {
        public void a(t0 viewModel) {
            Intrinsics.g(viewModel, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public v0(x0 store, c factory) {
        this(store, factory, null, 4, null);
        Intrinsics.g(store, "store");
        Intrinsics.g(factory, "factory");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public v0(x0 store, c factory, r3.a defaultCreationExtras) {
        this(new r3.c(store, factory, defaultCreationExtras));
        Intrinsics.g(store, "store");
        Intrinsics.g(factory, "factory");
        Intrinsics.g(defaultCreationExtras, "defaultCreationExtras");
    }

    public /* synthetic */ v0(x0 x0Var, c cVar, r3.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(x0Var, cVar, (i11 & 4) != 0 ? r3.a.C0824a.f75108b : aVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public v0(y0 owner) {
        Intrinsics.g(owner, "owner");
        x0 viewModelStore = owner.getViewModelStore();
        s3.g gVar = s3.g.f75955a;
        this(viewModelStore, gVar.b(owner), gVar.a(owner));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v0(y0 owner, c factory) {
        this(owner.getViewModelStore(), factory, s3.g.f75955a.a(owner));
        Intrinsics.g(owner, "owner");
        Intrinsics.g(factory, "factory");
    }

    public v0(r3.c cVar) {
        this.f8782a = cVar;
    }

    public <T extends t0> T a(Class<T> modelClass) {
        Intrinsics.g(modelClass, "modelClass");
        return (T) c(JvmClassMappingKt.c(modelClass));
    }

    public <T extends t0> T b(String key, Class<T> modelClass) {
        Intrinsics.g(key, "key");
        Intrinsics.g(modelClass, "modelClass");
        return (T) this.f8782a.a(JvmClassMappingKt.c(modelClass), key);
    }

    public final <T extends t0> T c(KClass<T> modelClass) {
        Intrinsics.g(modelClass, "modelClass");
        return (T) r3.c.b(this.f8782a, modelClass, null, 2, null);
    }
}
