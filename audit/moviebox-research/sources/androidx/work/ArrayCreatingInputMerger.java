package androidx.work;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
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
public final class ArrayCreatingInputMerger extends g {
    @Override // androidx.work.g
    public d b(List<d> inputs) throws Throwable {
        Intrinsics.g(inputs, "inputs");
        d.a aVar = new d.a();
        HashMap map = new HashMap();
        Iterator<d> it = inputs.iterator();
        while (it.hasNext()) {
            Map<String, Object> mapH = it.next().h();
            Intrinsics.f(mapH, "input.keyValueMap");
            for (Map.Entry<String, Object> entry : mapH.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Class<?> cls = value != null ? value.getClass() : String.class;
                Object obj = map.get(key);
                Intrinsics.f(key, "key");
                if (obj != null) {
                    Class<?> cls2 = obj.getClass();
                    if (Intrinsics.b(cls2, cls)) {
                        Intrinsics.f(value, "value");
                        value = d(obj, value);
                    } else {
                        if (!Intrinsics.b(cls2.getComponentType(), cls)) {
                            throw new IllegalArgumentException();
                        }
                        value = c(obj, value, cls);
                    }
                } else if (!cls.isArray()) {
                    value = e(value, cls);
                }
                Intrinsics.f(value, "if (existingValue == nul…      }\n                }");
                map.put(key, value);
            }
        }
        aVar.d(map);
        d dVarA = aVar.a();
        Intrinsics.f(dVarA, "output.build()");
        return dVarA;
    }

    public final Object c(Object obj, Object obj2, Class<?> cls) {
        int length = Array.getLength(obj);
        Object newArray = Array.newInstance(cls, length + 1);
        System.arraycopy(obj, 0, newArray, 0, length);
        Array.set(newArray, length, obj2);
        Intrinsics.f(newArray, "newArray");
        return newArray;
    }

    public final Object d(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        Class<?> componentType = obj.getClass().getComponentType();
        Intrinsics.d(componentType);
        Object newArray = Array.newInstance(componentType, length + length2);
        System.arraycopy(obj, 0, newArray, 0, length);
        System.arraycopy(obj2, 0, newArray, length, length2);
        Intrinsics.f(newArray, "newArray");
        return newArray;
    }

    public final Object e(Object obj, Class<?> cls) {
        Object newArray = Array.newInstance(cls, 1);
        Array.set(newArray, 0, obj);
        Intrinsics.f(newArray, "newArray");
        return newArray;
    }
}
