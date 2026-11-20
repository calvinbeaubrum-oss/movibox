package y6;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends g<Float> {
    public d(List<h7.a<Float>> list) {
        super(list);
    }

    public float q() {
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
    public float r(h7.a<Float> aVar, float f11) {
        Float f12;
        if (aVar.f66350b == null || aVar.f66351c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        h7.c<A> cVar = this.f81231e;
        return (cVar == 0 || (f12 = (Float) cVar.b(aVar.f66355g, aVar.f66356h.floatValue(), aVar.f66350b, aVar.f66351c, f11, e(), f())) == null) ? g7.k.i(aVar.g(), aVar.d(), f11) : f12.floatValue();
    }

    @Override // y6.a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Float i(h7.a<Float> aVar, float f11) {
        return Float.valueOf(r(aVar, f11));
    }
}
