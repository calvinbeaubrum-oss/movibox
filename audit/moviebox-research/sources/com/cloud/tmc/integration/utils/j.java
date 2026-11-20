package com.cloud.tmc.integration.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class j {
    public static int a(@Nullable Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    @NonNull
    public static byte[] b(byte... bArr) {
        return bArr;
    }

    @Nullable
    public static Object c(@Nullable Object obj, int i11, int i12) {
        if (obj == null) {
            return null;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        int iA = a(obj);
        if (i12 > iA) {
            i12 = iA;
        }
        int i13 = i12 - i11;
        Class<?> componentType = obj.getClass().getComponentType();
        if (i13 <= 0) {
            return Array.newInstance(componentType, 0);
        }
        Object objNewInstance = Array.newInstance(componentType, i13);
        System.arraycopy(obj, i11, objNewInstance, 0, i13);
        return objNewInstance;
    }

    @Nullable
    public static byte[] d(@Nullable byte[] bArr, int i11, int i12) {
        return (byte[]) c(bArr, i11, i12);
    }
}
