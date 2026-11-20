package o30;

import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.dynamic.DynamicOptimizer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ParserContext f72281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f72282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class f72283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public char[] f72284d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f72285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f72286g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f72288i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f72289j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public org.mvel2.compiler.a f72291l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public org.mvel2.compiler.a f72292m;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f72290k = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f72287h = System.currentTimeMillis();

    public c(ParserContext parserContext, Object obj, Class cls, char[] cArr, int i11, int i12, int i13, org.mvel2.compiler.a aVar) {
        this.f72281a = parserContext;
        this.f72282b = obj;
        this.f72283c = cls;
        this.f72292m = aVar;
        this.f72291l = aVar;
        this.f72288i = i13;
        this.f72284d = cArr;
        this.f72285f = i11;
        this.f72286g = i12;
    }

    @Override // o30.a
    public void a() {
        this.f72292m = this.f72291l;
        this.f72290k = false;
        this.f72289j = 0;
        this.f72287h = System.currentTimeMillis();
    }

    public final Object b(ParserContext parserContext, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (DynamicOptimizer.isOverloaded()) {
            DynamicOptimizer.enforceTenureLimit();
        }
        org.mvel2.compiler.a aVarOptimizeCollection = org.mvel2.optimizers.b.b("ASM").optimizeCollection(parserContext, this.f72282b, this.f72283c, this.f72284d, this.f72285f, this.f72286g, obj, obj2, variableResolverFactory);
        this.f72292m = aVarOptimizeCollection;
        return aVarOptimizeCollection.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.f72283c;
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (!this.f72290k) {
            int i11 = this.f72289j + 1;
            this.f72289j = i11;
            if (i11 > DynamicOptimizer.tenuringThreshold) {
                if (System.currentTimeMillis() - this.f72287h < DynamicOptimizer.timeSpan) {
                    this.f72290k = true;
                    return b(this.f72281a, obj, obj2, variableResolverFactory);
                }
                this.f72289j = 0;
                this.f72287h = System.currentTimeMillis();
            }
        }
        return this.f72292m.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        this.f72289j++;
        return this.f72292m.setValue(obj, obj2, variableResolverFactory, obj3);
    }
}
