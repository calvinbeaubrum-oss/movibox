package y6;

import android.graphics.Path;
import androidx.annotation.Nullable;
import java.util.List;
import x6.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends a<c7.i, Path> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c7.i f81268i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f81269j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Path f81270k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Path f81271l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<s> f81272m;

    public m(List<h7.a<c7.i>> list) {
        super(list);
        this.f81268i = new c7.i();
        this.f81269j = new Path();
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
    public Path i(h7.a<c7.i> aVar, float f11) {
        c7.i iVar = aVar.f66350b;
        c7.i iVar2 = aVar.f66351c;
        this.f81268i.c(iVar, iVar2 == null ? iVar : iVar2, f11);
        c7.i iVarA = this.f81268i;
        List<s> list = this.f81272m;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                iVarA = this.f81272m.get(size).a(iVarA);
            }
        }
        g7.k.h(iVarA, this.f81269j);
        if (this.f81231e == null) {
            return this.f81269j;
        }
        if (this.f81270k == null) {
            this.f81270k = new Path();
            this.f81271l = new Path();
        }
        g7.k.h(iVar, this.f81270k);
        if (iVar2 != null) {
            g7.k.h(iVar2, this.f81271l);
        }
        h7.c<A> cVar = this.f81231e;
        float f12 = aVar.f66355g;
        float fFloatValue = aVar.f66356h.floatValue();
        Path path = this.f81270k;
        return (Path) cVar.b(f12, fFloatValue, path, iVar2 == null ? path : this.f81271l, f11, e(), f());
    }

    public void r(@Nullable List<s> list) {
        this.f81272m = list;
    }
}
