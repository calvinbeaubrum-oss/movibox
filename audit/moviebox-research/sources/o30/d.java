package o30;

import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.OptimizationNotSupported;
import org.mvel2.optimizers.dynamic.DynamicOptimizer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f72293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f72294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f72295c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f72297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f72298g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ParserContext f72300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public org.mvel2.compiler.a f72301j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public org.mvel2.compiler.a f72302k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f72299h = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f72296d = System.currentTimeMillis();

    public d(ParserContext parserContext, char[] cArr, int i11, int i12, int i13, org.mvel2.compiler.a aVar) {
        this.f72302k = aVar;
        this.f72301j = aVar;
        this.f72297f = i13;
        this.f72293a = cArr;
        this.f72294b = i11;
        this.f72295c = i12;
        this.f72300i = parserContext;
    }

    @Override // o30.a
    public void a() {
        this.f72302k = this.f72301j;
        this.f72299h = false;
        this.f72298g = 0;
        this.f72296d = System.currentTimeMillis();
    }

    public final Object b(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (DynamicOptimizer.isOverloaded()) {
            DynamicOptimizer.enforceTenureLimit();
        }
        org.mvel2.optimizers.a aVarB = org.mvel2.optimizers.b.b("ASM");
        int i11 = this.f72297f;
        if (i11 == 0) {
            this.f72302k = aVarB.optimizeAccessor(this.f72300i, this.f72293a, this.f72294b, this.f72295c, obj, obj2, variableResolverFactory, false, null);
            return aVarB.getResultOptPass();
        }
        if (i11 == 2) {
            org.mvel2.compiler.a aVarOptimizeCollection = aVarB.optimizeCollection(this.f72300i, obj, null, this.f72293a, this.f72294b, this.f72295c, obj, obj2, variableResolverFactory);
            this.f72302k = aVarOptimizeCollection;
            return aVarOptimizeCollection.getValue(obj, obj2, variableResolverFactory);
        }
        if (i11 != 3) {
            return null;
        }
        org.mvel2.compiler.a aVarOptimizeObjectCreation = aVarB.optimizeObjectCreation(this.f72300i, this.f72293a, this.f72294b, this.f72295c, obj, obj2, variableResolverFactory);
        this.f72302k = aVarOptimizeObjectCreation;
        return aVarOptimizeObjectCreation.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.f72301j.getKnownEgressType();
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (!this.f72299h) {
            int i11 = this.f72298g + 1;
            this.f72298g = i11;
            if (i11 > DynamicOptimizer.tenuringThreshold) {
                if (System.currentTimeMillis() - this.f72296d < DynamicOptimizer.timeSpan) {
                    this.f72299h = true;
                    try {
                        return b(obj, obj2, variableResolverFactory);
                    } catch (OptimizationNotSupported unused) {
                    }
                } else {
                    this.f72298g = 0;
                    this.f72296d = System.currentTimeMillis();
                }
            }
        }
        return this.f72302k.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        this.f72298g++;
        return this.f72302k.setValue(obj, obj2, variableResolverFactory, obj3);
    }
}
