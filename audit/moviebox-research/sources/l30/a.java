package l30;

import java.util.Iterator;
import java.util.List;
import org.mvel2.integration.VariableResolverFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<c> f69772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<c> f69773b;

    public static boolean a() {
        List<c> list = f69772a;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static boolean b() {
        List<c> list = f69773b;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static void c(Object obj, String str, VariableResolverFactory variableResolverFactory) {
        List<c> list = f69772a;
        if (list != null) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(obj, str, variableResolverFactory, null);
            }
        }
    }

    public static void d(Object obj, String str, VariableResolverFactory variableResolverFactory, Object obj2) {
        List<c> list = f69773b;
        if (list != null) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(obj, str, variableResolverFactory, obj2);
            }
        }
    }
}
