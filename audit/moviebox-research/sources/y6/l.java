package y6;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends g<h7.d> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h7.d f81267i;

    public l(List<h7.a<h7.d>> list) {
        super(list);
        this.f81267i = new h7.d();
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
    @Override // y6.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public h7.d i(h7.a<h7.d> aVar, float f11) {
        h7.d dVar;
        h7.d dVar2;
        h7.d dVar3 = aVar.f66350b;
        if (dVar3 == null || (dVar = aVar.f66351c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        h7.d dVar4 = dVar3;
        h7.d dVar5 = dVar;
        h7.c<A> cVar = this.f81231e;
        if (cVar != 0 && (dVar2 = (h7.d) cVar.b(aVar.f66355g, aVar.f66356h.floatValue(), dVar4, dVar5, f11, e(), f())) != null) {
            return dVar2;
        }
        this.f81267i.d(g7.k.i(dVar4.b(), dVar5.b(), f11), g7.k.i(dVar4.c(), dVar5.c(), f11));
        return this.f81267i;
    }
}
