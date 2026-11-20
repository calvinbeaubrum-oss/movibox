package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.collections.r;
import kotlin.collections.s;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringsKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f68894b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Class<? extends Function<?>>, Integer> f68895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, String> f68896d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap<String, String> f68897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashMap<String, String> f68898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, String> f68899h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f68900a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Class<?> jClass) {
            String str;
            Intrinsics.g(jClass, "jClass");
            String str2 = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (!jClass.isArray()) {
                String str3 = (String) ClassReference.f68898g.get(jClass.getName());
                return str3 == null ? jClass.getCanonicalName() : str3;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = (String) ClassReference.f68898g.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 == null ? "kotlin.Array" : str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
        
            if (r2 == null) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String b(Class<?> jClass) {
            String strN0;
            String str;
            Intrinsics.g(jClass, "jClass");
            String str2 = null;
            if (jClass.isAnonymousClass()) {
                return null;
            }
            if (jClass.isLocalClass()) {
                String simpleName = jClass.getSimpleName();
                Method enclosingMethod = jClass.getEnclosingMethod();
                if (enclosingMethod != null) {
                    Intrinsics.d(simpleName);
                    strN0 = StringsKt__StringsKt.N0(simpleName, enclosingMethod.getName() + '$', null, 2, null);
                }
                Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
                if (enclosingConstructor == null) {
                    Intrinsics.d(simpleName);
                    return StringsKt__StringsKt.M0(simpleName, '$', null, 2, null);
                }
                Intrinsics.d(simpleName);
                return StringsKt__StringsKt.N0(simpleName, enclosingConstructor.getName() + '$', null, 2, null);
            }
            if (!jClass.isArray()) {
                String str3 = (String) ClassReference.f68899h.get(jClass.getName());
                return str3 == null ? jClass.getSimpleName() : str3;
            }
            Class<?> componentType = jClass.getComponentType();
            strN0 = "Array";
            if (componentType.isPrimitive() && (str = (String) ClassReference.f68899h.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            if (str2 != null) {
                return str2;
            }
            return strN0;
        }

        public final boolean c(Object obj, Class<?> jClass) {
            Intrinsics.g(jClass, "jClass");
            Map map = ClassReference.f68895c;
            Intrinsics.e(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(jClass);
            if (num != null) {
                return TypeIntrinsics.k(obj, num.intValue());
            }
            if (jClass.isPrimitive()) {
                jClass = JvmClassMappingKt.b(JvmClassMappingKt.c(jClass));
            }
            return jClass.isInstance(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i11 = 0;
        List listO = kotlin.collections.g.o(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(listO, 10));
        for (Object obj : listO) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            arrayList.add(TuplesKt.a((Class) obj, Integer.valueOf(i11)));
            i11 = i12;
        }
        f68895c = s.r(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f68896d = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f68897f = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        Intrinsics.f(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("kotlin.jvm.internal.");
            Intrinsics.d(str);
            sb2.append(StringsKt__StringsKt.Q0(str, '.', null, 2, null));
            sb2.append("CompanionObject");
            Pair pairA = TuplesKt.a(sb2.toString(), str + ".Companion");
            map3.put(pairA.getFirst(), pairA.getSecond());
        }
        for (Map.Entry<Class<? extends Function<?>>, Integer> entry : f68895c.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f68898g = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(r.e(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), StringsKt__StringsKt.Q0((String) entry2.getValue(), '.', null, 2, null));
        }
        f68899h = linkedHashMap;
    }

    public ClassReference(Class<?> jClass) {
        Intrinsics.g(jClass, "jClass");
        this.f68900a = jClass;
    }

    @Override // kotlin.reflect.KClass
    @SinceKotlin
    public boolean b(Object obj) {
        return f68894b.c(obj, c());
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> c() {
        return this.f68900a;
    }

    @Override // kotlin.reflect.KClass
    public String d() {
        return f68894b.a(c());
    }

    @Override // kotlin.reflect.KClass
    public String e() {
        return f68894b.b(c());
    }

    public boolean equals(Object obj) {
        return (obj instanceof ClassReference) && Intrinsics.b(JvmClassMappingKt.b(this), JvmClassMappingKt.b((KClass) obj));
    }

    public int hashCode() {
        return JvmClassMappingKt.b(this).hashCode();
    }

    public String toString() {
        return c().toString() + " (Kotlin reflection is not available)";
    }
}
