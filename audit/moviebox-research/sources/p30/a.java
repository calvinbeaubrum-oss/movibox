package p30;

import java.lang.reflect.Array;
import org.mvel2.integration.VariableResolverFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements org.mvel2.compiler.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.mvel2.compiler.a[] f73518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class f73519b;

    public a(org.mvel2.compiler.a[] aVarArr, Class cls) {
        this.f73518a = aVarArr;
        this.f73519b = cls;
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.f73519b;
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        int i11 = 0;
        if (Object.class.equals(this.f73519b)) {
            int length = this.f73518a.length;
            Object[] objArr = new Object[length];
            while (i11 < length) {
                objArr[i11] = this.f73518a[i11].getValue(obj, obj2, variableResolverFactory);
                i11++;
            }
            return objArr;
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.f73519b, this.f73518a.length);
        while (true) {
            org.mvel2.compiler.a[] aVarArr = this.f73518a;
            if (i11 >= aVarArr.length) {
                return objNewInstance;
            }
            Array.set(objNewInstance, i11, aVarArr[i11].getValue(obj, obj2, variableResolverFactory));
            i11++;
        }
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return null;
    }
}
