package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Reflection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ReflectionFactory f68909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KClass[] f68910b;

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        f68909a = reflectionFactory;
        f68910b = new KClass[0];
    }

    public static KFunction a(FunctionReference functionReference) {
        return f68909a.a(functionReference);
    }

    public static KClass b(Class cls) {
        return f68909a.b(cls);
    }

    @SinceKotlin
    public static KDeclarationContainer c(Class cls) {
        return f68909a.c(cls, "");
    }

    public static KMutableProperty0 d(MutablePropertyReference0 mutablePropertyReference0) {
        return f68909a.d(mutablePropertyReference0);
    }

    public static KMutableProperty1 e(MutablePropertyReference1 mutablePropertyReference1) {
        return f68909a.e(mutablePropertyReference1);
    }

    public static KMutableProperty2 f(MutablePropertyReference2 mutablePropertyReference2) {
        return f68909a.f(mutablePropertyReference2);
    }

    public static KProperty0 g(PropertyReference0 propertyReference0) {
        return f68909a.g(propertyReference0);
    }

    public static KProperty1 h(PropertyReference1 propertyReference1) {
        return f68909a.h(propertyReference1);
    }

    public static KProperty2 i(PropertyReference2 propertyReference2) {
        return f68909a.i(propertyReference2);
    }

    @SinceKotlin
    public static String j(FunctionBase functionBase) {
        return f68909a.j(functionBase);
    }

    @SinceKotlin
    public static String k(Lambda lambda) {
        return f68909a.k(lambda);
    }
}
