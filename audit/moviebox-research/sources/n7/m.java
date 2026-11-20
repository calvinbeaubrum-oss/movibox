package n7;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class m implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f71697a = new m();

    @Override // m7.b2
    public int b() {
        return 14;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        if (obj instanceof AtomicInteger) {
            j1Var.b0(((AtomicInteger) obj).get());
            return;
        }
        if (obj instanceof AtomicLong) {
            j1Var.e0(((AtomicLong) obj).get());
            return;
        }
        if (obj instanceof AtomicBoolean) {
            j1Var.append(((AtomicBoolean) obj).get() ? "true" : "false");
            return;
        }
        if (obj == null) {
            j1Var.i0(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int i12 = 0;
        if (obj instanceof AtomicIntegerArray) {
            AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
            int length = atomicIntegerArray.length();
            j1Var.write(91);
            while (i12 < length) {
                int i13 = atomicIntegerArray.get(i12);
                if (i12 != 0) {
                    j1Var.write(44);
                }
                j1Var.b0(i13);
                i12++;
            }
            j1Var.write(93);
            return;
        }
        AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
        int length2 = atomicLongArray.length();
        j1Var.write(91);
        while (i12 < length2) {
            long j11 = atomicLongArray.get(i12);
            if (i12 != 0) {
                j1Var.write(44);
            }
            j1Var.e0(j11);
            i12++;
        }
        j1Var.write(93);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.util.concurrent.atomic.AtomicLongArray] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.util.concurrent.atomic.AtomicIntegerArray] */
    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        if (aVar.f70077g.k0() == 8) {
            aVar.f70077g.W(16);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        aVar.d0(jSONArray);
        int i11 = 0;
        if (type == AtomicIntegerArray.class) {
            ?? r11 = (T) new AtomicIntegerArray(jSONArray.size());
            while (i11 < jSONArray.size()) {
                r11.set(i11, jSONArray.getInteger(i11).intValue());
                i11++;
            }
            return r11;
        }
        ?? r12 = (T) new AtomicLongArray(jSONArray.size());
        while (i11 < jSONArray.size()) {
            r12.set(i11, jSONArray.getLong(i11).longValue());
            i11++;
        }
        return r12;
    }
}
