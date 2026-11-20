package o30;

import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.dynamic.DynamicOptimizer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f72303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f72304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f72305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f72306d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f72307f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f72308g = System.currentTimeMillis();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ParserContext f72309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final org.mvel2.compiler.a f72310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public org.mvel2.compiler.a f72311j;

    public e(ParserContext parserContext, char[] cArr, int i11, int i12, org.mvel2.compiler.a aVar) {
        this.f72311j = aVar;
        this.f72310i = aVar;
        this.f72309h = parserContext;
        this.f72303a = cArr;
        this.f72304b = i11;
        this.f72305c = i12;
    }

    @Override // o30.a
    public void a() {
        this.f72311j = this.f72310i;
        this.f72306d = false;
        this.f72307f = 0;
        this.f72308g = System.currentTimeMillis();
    }

    public final Object b(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        if (DynamicOptimizer.isOverloaded()) {
            DynamicOptimizer.enforceTenureLimit();
        }
        this.f72311j = org.mvel2.optimizers.b.b("ASM").optimizeSetAccessor(this.f72309h, this.f72303a, this.f72304b, this.f72305c, obj, obj2, variableResolverFactory, false, obj3, obj3 != null ? obj3.getClass() : Object.class);
        return obj3;
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.f72310i.getKnownEgressType();
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        throw new RuntimeException("value cannot be read with this accessor");
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        if (!this.f72306d) {
            int i11 = this.f72307f + 1;
            this.f72307f = i11;
            if (i11 > DynamicOptimizer.tenuringThreshold) {
                if (System.currentTimeMillis() - this.f72308g < DynamicOptimizer.timeSpan) {
                    this.f72306d = true;
                    return b(obj, obj2, variableResolverFactory, obj3);
                }
                this.f72307f = 0;
                this.f72308g = System.currentTimeMillis();
            }
        }
        this.f72311j.setValue(obj, obj2, variableResolverFactory, obj3);
        return obj3;
    }
}
