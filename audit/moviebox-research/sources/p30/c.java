package p30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mvel2.integration.VariableResolverFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c implements org.mvel2.compiler.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.mvel2.compiler.a[] f73521a;

    public c(org.mvel2.compiler.a[] aVarArr) {
        this.f73521a = aVarArr;
    }

    public org.mvel2.compiler.a[] b() {
        return this.f73521a;
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return List.class;
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        Object[] objArr = new Object[b().length];
        for (int i11 = 0; i11 < b().length; i11++) {
            objArr[i11] = b()[i11].getValue(obj, obj2, variableResolverFactory);
        }
        return new ArrayList(Arrays.asList(objArr));
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return null;
    }
}
