package androidx.lifecycle;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class w0 {
    public static t0 a(v0.c cVar, Class modelClass) {
        Intrinsics.g(modelClass, "modelClass");
        return s3.g.f75955a.d();
    }

    public static t0 b(v0.c cVar, Class modelClass, r3.a extras) {
        Intrinsics.g(modelClass, "modelClass");
        Intrinsics.g(extras, "extras");
        return cVar.create(modelClass);
    }

    public static t0 c(v0.c cVar, KClass modelClass, r3.a extras) {
        Intrinsics.g(modelClass, "modelClass");
        Intrinsics.g(extras, "extras");
        return cVar.create(JvmClassMappingKt.a(modelClass), extras);
    }
}
