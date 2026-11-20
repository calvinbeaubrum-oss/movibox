package y6;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends g<Integer> {
    public f(List<h7.a<Integer>> list) {
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
        Integer num;
        if (aVar.f66350b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iH = aVar.f66351c == null ? aVar.h() : aVar.e();
        h7.c<A> cVar = this.f81231e;
        return (cVar == 0 || (num = (Integer) cVar.b(aVar.f66355g, aVar.f66356h.floatValue(), aVar.f66350b, Integer.valueOf(iH), f11, e(), f())) == null) ? g7.k.j(aVar.h(), iH, f11) : num.intValue();
    }

    @Override // y6.a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Integer i(h7.a<Integer> aVar, float f11) {
        return Integer.valueOf(r(aVar, f11));
    }
}
