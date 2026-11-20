package es;

import java.util.HashMap;
import java.util.ServiceLoader;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0666a f64348a = new C0666a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, Object> f64349b = new HashMap<>();

    /* JADX INFO: renamed from: es.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0666a {
        public C0666a() {
        }

        public /* synthetic */ C0666a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> T a(Class<T> clazz) {
            Intrinsics.g(clazz, "clazz");
            if (a.f64349b.containsKey(clazz.getName())) {
                T t11 = (T) a.f64349b.get(clazz.getName());
                Intrinsics.e(t11, "null cannot be cast to non-null type T of com.transsion.baselib.service.BusinessServiceManager.Companion.getService");
                return t11;
            }
            ServiceLoader serviceLoaderLoad = ServiceLoader.load(clazz);
            if (serviceLoaderLoad.iterator().hasNext()) {
                T service = (T) serviceLoaderLoad.iterator().next();
                HashMap map = a.f64349b;
                String name = clazz.getName();
                Intrinsics.f(name, "clazz.name");
                Intrinsics.f(service, "service");
                map.put(name, service);
                return service;
            }
            uo.b.a.k(uo.b.f78622a, "Service " + clazz + " has not implemented", false, 2, null);
            return null;
        }
    }
}
