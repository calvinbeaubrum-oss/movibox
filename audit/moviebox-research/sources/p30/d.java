package p30;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.integration.VariableResolverFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d implements org.mvel2.compiler.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.mvel2.compiler.a[] f73522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.mvel2.compiler.a[] f73523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f73524c;

    public d(org.mvel2.compiler.a[] aVarArr, org.mvel2.compiler.a[] aVarArr2) {
        this.f73522a = aVarArr;
        this.f73524c = aVarArr.length;
        this.f73523b = aVarArr2;
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return Map.class;
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        HashMap map = new HashMap(this.f73524c * 2);
        int i11 = this.f73524c;
        while (true) {
            i11--;
            if (i11 == -1) {
                return map;
            }
            map.put(this.f73522a[i11].getValue(obj, obj2, variableResolverFactory), this.f73523b[i11].getValue(obj, obj2, variableResolverFactory));
        }
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return null;
    }
}
