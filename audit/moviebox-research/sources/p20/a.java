package p20;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.c0;
import org.apache.tools.ant.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    public static final void a(Object obj) throws BuildException {
        b bVar;
        Object objF;
        try {
            try {
                String str = null;
                if (obj instanceof b) {
                    bVar = (b) obj;
                } else {
                    bVar = ((obj instanceof c0) && (objF = ((c0) obj).F()) != null && (objF instanceof b) && (objF instanceof z)) ? (b) objF : null;
                }
                if (bVar == null) {
                    Method method = obj.getClass().getMethod("execute", new Class[0]);
                    if (method != null) {
                        method.invoke(obj, null);
                        if (obj instanceof c0) {
                            ((c0) obj).W(null);
                            return;
                        }
                        return;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("No public ");
                    stringBuffer.append("execute");
                    stringBuffer.append("() in ");
                    stringBuffer.append(obj.getClass());
                    throw new BuildException(stringBuffer.toString());
                }
                try {
                    String strA = bVar.a();
                    if (strA == null || strA.trim().length() <= 0) {
                        throw new BuildException("Action Parameter Name must not be empty for Dispatchable Task.");
                    }
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("get");
                    stringBuffer2.append(strA.trim().substring(0, 1).toUpperCase());
                    String string = stringBuffer2.toString();
                    try {
                        if (strA.length() > 1) {
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append(string);
                            stringBuffer3.append(strA.substring(1));
                            string = stringBuffer3.toString();
                        }
                        Method method2 = bVar.getClass().getMethod(string, new Class[0]);
                        if (method2 != null) {
                            Object objInvoke = method2.invoke(bVar, null);
                            if (objInvoke == null) {
                                StringBuffer stringBuffer4 = new StringBuffer();
                                stringBuffer4.append("Dispatchable Task attribute '");
                                stringBuffer4.append(strA.trim());
                                stringBuffer4.append("' not set or value is empty.");
                                throw new BuildException(stringBuffer4.toString());
                            }
                            String string2 = objInvoke.toString();
                            if (string2 == null || string2.trim().length() <= 0) {
                                StringBuffer stringBuffer5 = new StringBuffer();
                                stringBuffer5.append("Dispatchable Task attribute '");
                                stringBuffer5.append(strA.trim());
                                stringBuffer5.append("' not set or value is empty.");
                                throw new BuildException(stringBuffer5.toString());
                            }
                            String strTrim = string2.trim();
                            Method method3 = bVar.getClass().getMethod(strTrim, new Class[0]);
                            if (method3 != null) {
                                method3.invoke(bVar, null);
                                if (obj instanceof c0) {
                                    ((c0) obj).W(null);
                                    return;
                                }
                                return;
                            }
                            StringBuffer stringBuffer6 = new StringBuffer();
                            stringBuffer6.append("No public ");
                            stringBuffer6.append(strTrim);
                            stringBuffer6.append("() in ");
                            stringBuffer6.append(bVar.getClass());
                            throw new BuildException(stringBuffer6.toString());
                        }
                    } catch (NoSuchMethodException unused) {
                        str = string;
                        StringBuffer stringBuffer7 = new StringBuffer();
                        stringBuffer7.append("No public ");
                        stringBuffer7.append(str);
                        stringBuffer7.append("() in ");
                        stringBuffer7.append(obj.getClass());
                        throw new BuildException(stringBuffer7.toString());
                    }
                } catch (NoSuchMethodException unused2) {
                }
            } catch (NoSuchMethodException e11) {
                throw new BuildException(e11);
            }
        } catch (IllegalAccessException e12) {
            throw new BuildException(e12);
        } catch (InvocationTargetException e13) {
            Throwable targetException = e13.getTargetException();
            if (!(targetException instanceof BuildException)) {
                throw new BuildException(targetException);
            }
            throw ((BuildException) targetException);
        }
    }
}
