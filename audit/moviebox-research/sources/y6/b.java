package y6;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends g<Integer> {
    public b(List<h7.a<Integer>> list) {
        super(list);
    }

    public int q() {
        return r(b(), d());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public int r(h7.a<Integer> aVar, float f11) {
        Float f12;
        Integer num;
        if (aVar.f66350b == null || aVar.f66351c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        h7.c<A> cVar = this.f81231e;
        return (cVar == 0 || (f12 = aVar.f66356h) == null || (num = (Integer) cVar.b(aVar.f66355g, f12.floatValue(), aVar.f66350b, aVar.f66351c, f11, e(), f())) == null) ? g7.d.c(g7.k.b(f11, 0.0f, 1.0f), aVar.f66350b.intValue(), aVar.f66351c.intValue()) : num.intValue();
    }

    @Override // y6.a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Integer i(h7.a<Integer> aVar, float f11) {
        return Integer.valueOf(r(aVar, f11));
    }
}
