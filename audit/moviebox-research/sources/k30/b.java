package k30;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.mvel2.ast.LineLabel;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.integration.VariableResolverFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f68234b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Set<Integer>> f68233a = new HashMap();

    public int a(LineLabel lineLabel, VariableResolverFactory variableResolverFactory, CompiledExpression compiledExpression) {
        if (this.f68234b == 1 || b(lineLabel)) {
            throw new RuntimeException("no debugger registered to handle breakpoint");
        }
        return 0;
    }

    public boolean b(LineLabel lineLabel) {
        return this.f68233a.containsKey(lineLabel.getSourceFile()) && this.f68233a.get(lineLabel.getSourceFile()).contains(Integer.valueOf(lineLabel.getLineNumber()));
    }
}
