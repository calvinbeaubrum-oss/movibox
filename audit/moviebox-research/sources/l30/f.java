package l30;

import org.mvel2.integration.VariableResolverFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f {
    public static <T extends VariableResolverFactory> T a(VariableResolverFactory variableResolverFactory, T t11) {
        if (variableResolverFactory.getNextFactory() == null) {
            variableResolverFactory.setNextFactory(t11);
        } else {
            while (variableResolverFactory.getNextFactory() != null) {
                variableResolverFactory = variableResolverFactory.getNextFactory();
            }
            variableResolverFactory.setNextFactory(t11);
        }
        return t11;
    }
}
