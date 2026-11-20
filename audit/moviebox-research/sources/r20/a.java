package r20;

import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.h;
import org.apache.tools.ant.types.m;
import org.apache.tools.ant.types.n;
import q20.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static /* synthetic */ Class f75100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static /* synthetic */ Class f75101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static /* synthetic */ Class f75102g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Reader f75103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f75104b = 8192;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Vector f75105c = new Vector();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Project f75106d = null;

    public static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5 */
    public Reader b() throws BuildException {
        Class<?> cls;
        Reader readerA = this.f75103a;
        if (readerA == 0) {
            throw new BuildException("primaryReader must not be null.");
        }
        int size = this.f75105c.size();
        Vector vector = new Vector();
        for (int i11 = 0; i11 < size; i11++) {
            Vector vectorC = ((h) this.f75105c.elementAt(i11)).c();
            int size2 = vectorC.size();
            for (int i12 = 0; i12 < size2; i12++) {
                vector.addElement(vectorC.elementAt(i12));
            }
        }
        int size3 = vector.size();
        if (size3 > 0) {
            int i13 = 0;
            while (i13 < size3) {
                Object objElementAt = vector.elementAt(i13);
                if (objElementAt instanceof org.apache.tools.ant.types.a) {
                    org.apache.tools.ant.types.a aVar = (org.apache.tools.ant.types.a) vector.elementAt(i13);
                    String strC = aVar.c();
                    n nVarD = aVar.d();
                    Project project = aVar.getProject();
                    if (strC != null) {
                        if (nVarD == null) {
                            try {
                                readerA = readerA;
                                cls = Class.forName(strC);
                            } catch (ClassNotFoundException e11) {
                                throw new BuildException(e11);
                            } catch (IllegalAccessException e12) {
                                throw new BuildException(e12);
                            } catch (InstantiationException e13) {
                                throw new BuildException(e13);
                            } catch (InvocationTargetException e14) {
                                throw new BuildException(e14);
                            }
                        } else {
                            cls = Class.forName(strC, true, project.g(nVarD));
                        }
                        if (cls != null) {
                            Class clsA = f75100e;
                            if (clsA == null) {
                                readerA = readerA;
                                clsA = a("java.io.FilterReader");
                                f75100e = clsA;
                            }
                            readerA = readerA;
                            if (!clsA.isAssignableFrom(cls)) {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append(strC);
                                stringBuffer.append(" does not extend java.io.FilterReader");
                                throw new BuildException(stringBuffer.toString());
                            }
                            Constructor<?>[] constructors = cls.getConstructors();
                            int i14 = 0;
                            while (true) {
                                if (i14 >= constructors.length) {
                                    StringBuffer stringBuffer2 = new StringBuffer();
                                    stringBuffer2.append(strC);
                                    stringBuffer2.append(" does not define a public constructor");
                                    stringBuffer2.append(" that takes in a Reader as its ");
                                    stringBuffer2.append("single argument.");
                                    throw new BuildException(stringBuffer2.toString());
                                }
                                Class<?>[] parameterTypes = constructors[i14].getParameterTypes();
                                if (parameterTypes.length == 1) {
                                    Class<?> cls2 = parameterTypes[0];
                                    Class<?> clsA2 = f75101f;
                                    if (clsA2 == null) {
                                        clsA2 = a("java.io.Reader");
                                        f75101f = clsA2;
                                    }
                                    if (cls2.isAssignableFrom(clsA2)) {
                                        readerA = (Reader) constructors[i14].newInstance(readerA);
                                        f(readerA);
                                        Class clsA3 = f75102g;
                                        if (clsA3 == null) {
                                            clsA3 = a("org.apache.tools.ant.types.Parameterizable");
                                            f75102g = clsA3;
                                        }
                                        if (!clsA3.isAssignableFrom(cls)) {
                                            break;
                                        }
                                        ((m) readerA).a(aVar.h());
                                        break;
                                    }
                                }
                                i14++;
                            }
                        } else {
                            readerA = readerA;
                            continue;
                        }
                    } else {
                        readerA = readerA;
                        continue;
                    }
                } else if (objElementAt instanceof b) {
                    readerA = readerA;
                    f(objElementAt);
                    readerA = ((b) objElementAt).a(readerA);
                    f(readerA);
                } else {
                    readerA = readerA;
                }
                i13++;
                readerA = readerA;
            }
            readerA = readerA;
        }
        return readerA;
    }

    public void c(Vector vector) {
        this.f75105c = vector;
    }

    public void d(Reader reader) {
        this.f75103a = reader;
    }

    public void e(Project project) {
        this.f75106d = project;
    }

    public final void f(Object obj) {
        Project project = this.f75106d;
        if (project == null) {
            return;
        }
        if (obj instanceof q20.a) {
            ((q20.a) obj).a(project);
        } else {
            project.K(obj);
        }
    }
}
