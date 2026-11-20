package t30;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.mvel2.CompileException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f76804a = Logger.getLogger(f.class.getName());

    public static CompileException a(CompileException compileException, char[] cArr, int i11) {
        if (cArr != compileException.getExpr()) {
            if (compileException.getExpr().length <= compileException.getCursor()) {
                compileException.setCursor(compileException.getExpr().length - 1);
            }
            try {
                String strSubstring = new String(compileException.getExpr()).substring(compileException.getCursor());
                compileException.setExpr(cArr);
                String str = new String(cArr);
                compileException.setCursor(str.substring(str.indexOf(new String(compileException.getExpr()))).indexOf(strSubstring));
            } catch (Throwable th2) {
                f76804a.log(Level.WARNING, "", th2);
            }
        }
        return compileException;
    }

    public static org.mvel2.c b(org.mvel2.c cVar, char[] cArr, int i11) {
        if (cArr != cVar.d()) {
            String strSubstring = new String(cVar.d()).substring(cVar.c());
            cVar.j(cArr);
            cVar.i(i11 + new String(cArr).substring(i11).indexOf(strSubstring));
        }
        return cVar;
    }
}
