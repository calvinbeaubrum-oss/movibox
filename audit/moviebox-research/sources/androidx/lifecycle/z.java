package androidx.lifecycle;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f8803a = new z();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, Integer> f8804b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Class<?>, List<Constructor<? extends k>>> f8805c = new HashMap();

    @JvmStatic
    public static final String c(String className) {
        Intrinsics.g(className, "className");
        return kotlin.text.l.F(className, InstructionFileId.DOT, "_", false, 4, null) + "_LifecycleAdapter";
    }

    @JvmStatic
    public static final r f(Object object) {
        Intrinsics.g(object, "object");
        boolean z11 = object instanceof r;
        boolean z12 = object instanceof f;
        if (z11 && z12) {
            return new g((f) object, (r) object);
        }
        if (z12) {
            return new g((f) object, null);
        }
        if (z11) {
            return (r) object;
        }
        Class<?> cls = object.getClass();
        z zVar = f8803a;
        if (zVar.d(cls) != 2) {
            return new i0(object);
        }
        List<Constructor<? extends k>> list = f8805c.get(cls);
        Intrinsics.d(list);
        List<Constructor<? extends k>> list2 = list;
        if (list2.size() == 1) {
            return new s0(zVar.a(list2.get(0), object));
        }
        int size = list2.size();
        k[] kVarArr = new k[size];
        for (int i11 = 0; i11 < size; i11++) {
            kVarArr[i11] = f8803a.a(list2.get(i11), object);
        }
        return new d(kVarArr);
    }

    public final k a(Constructor<? extends k> constructor, Object obj) {
        try {
            k kVarNewInstance = constructor.newInstance(obj);
            Intrinsics.f(kVarNewInstance, "{\n            constructo…tance(`object`)\n        }");
            return kVarNewInstance;
        } catch (IllegalAccessException e11) {
            throw new RuntimeException(e11);
        } catch (InstantiationException e12) {
            throw new RuntimeException(e12);
        } catch (InvocationTargetException e13) {
            throw new RuntimeException(e13);
        }
    }

    public final Constructor<? extends k> b(Class<?> cls) {
        try {
            Package r11 = cls.getPackage();
            String name = cls.getCanonicalName();
            String fullPackage = r11 != null ? r11.getName() : "";
            Intrinsics.f(fullPackage, "fullPackage");
            if (fullPackage.length() != 0) {
                Intrinsics.f(name, "name");
                name = name.substring(fullPackage.length() + 1);
                Intrinsics.f(name, "this as java.lang.String).substring(startIndex)");
            }
            Intrinsics.f(name, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String strC = c(name);
            if (fullPackage.length() != 0) {
                strC = fullPackage + '.' + strC;
            }
            Class<?> cls2 = Class.forName(strC);
            Intrinsics.e(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final int d(Class<?> cls) {
        Map<Class<?>, Integer> map = f8804b;
        Integer num = map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    public final boolean e(Class<?> cls) {
        return cls != null && t.class.isAssignableFrom(cls);
    }

    public final int g(Class<?> cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends k> constructorB = b(cls);
        if (constructorB != null) {
            f8805c.put(cls, kotlin.collections.f.e(constructorB));
            return 2;
        }
        if (c.f8708c.d(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (e(superclass)) {
            Intrinsics.f(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            List<Constructor<? extends k>> list = f8805c.get(superclass);
            Intrinsics.d(list);
            arrayList = new ArrayList(list);
        } else {
            arrayList = null;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        Intrinsics.f(interfaces, "klass.interfaces");
        for (Class<?> intrface : interfaces) {
            if (e(intrface)) {
                Intrinsics.f(intrface, "intrface");
                if (d(intrface) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                List<Constructor<? extends k>> list2 = f8805c.get(intrface);
                Intrinsics.d(list2);
                arrayList.addAll(list2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f8805c.put(cls, arrayList);
        return 2;
    }
}
