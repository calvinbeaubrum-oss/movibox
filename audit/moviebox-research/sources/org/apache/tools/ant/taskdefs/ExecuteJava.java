package org.apache.tools.ant.taskdefs;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.util.Watchdog;
import org.apache.tools.ant.util.r;
import org.apache.tools.ant.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ExecuteJava implements Runnable, r {
    static /* synthetic */ Class array$Ljava$lang$String;
    private org.apache.tools.ant.types.o perm;
    private org.apache.tools.ant.types.c javaCommand = null;
    private org.apache.tools.ant.types.n classpath = null;
    private org.apache.tools.ant.types.d.a sysProperties = null;
    private Method main = null;
    private Long timeout = null;
    private volatile Throwable caught = null;
    private volatile boolean timedOut = false;
    private Thread thread = null;

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static void setupCommandLineForVMS(g gVar, String[] strArr) throws Throwable {
        gVar.t(true);
        try {
            String[] strArr2 = new String[strArr.length - 1];
            System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
            File fileC = org.apache.tools.ant.util.f.c(strArr2);
            fileC.deleteOnExit();
            gVar.p(new String[]{strArr[0], "-V", fileC.getPath()});
        } catch (IOException unused) {
            throw new BuildException("Failed to create a temporary file for \"-V\" switch");
        }
    }

    public void execute(Project project) throws ClassNotFoundException, BuildException {
        org.apache.tools.ant.a aVar;
        Class<?> cls;
        String strK = this.javaCommand.k();
        org.apache.tools.ant.a aVar2 = null;
        try {
            try {
                org.apache.tools.ant.types.d.a aVar3 = this.sysProperties;
                if (aVar3 != null) {
                    aVar3.h();
                }
                try {
                    org.apache.tools.ant.types.n nVar = this.classpath;
                    if (nVar == null) {
                        cls = Class.forName(strK);
                        aVar = null;
                    } else {
                        org.apache.tools.ant.a aVarG = project.g(nVar);
                        try {
                            aVarG.F(project.o());
                            aVarG.G(false);
                            aVarG.e();
                            aVarG.E(true);
                            aVarG.I();
                            aVarG.p(strK);
                            aVar = aVarG;
                            cls = Class.forName(strK, true, aVarG);
                        } catch (ClassNotFoundException unused) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("Could not find ");
                            stringBuffer.append(strK);
                            stringBuffer.append(InstructionFileId.DOT);
                            stringBuffer.append(" Make sure you have it in your");
                            stringBuffer.append(" classpath");
                            throw new BuildException(stringBuffer.toString());
                        } catch (SecurityException e11) {
                            throw e11;
                        } catch (ThreadDeath e12) {
                            throw e12;
                        } catch (BuildException e13) {
                            throw e13;
                        } catch (Throwable th2) {
                            th = th2;
                            throw new BuildException(th);
                        }
                    }
                    try {
                        Class<?>[] clsArr = new Class[1];
                        Class<?> clsClass$ = array$Ljava$lang$String;
                        if (clsClass$ == null) {
                            clsClass$ = class$("[Ljava.lang.String;");
                            array$Ljava$lang$String = clsClass$;
                        }
                        clsArr[0] = clsClass$;
                        Method method = cls.getMethod("main", clsArr);
                        this.main = method;
                        if (method == null) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("Could not find main() method in ");
                            stringBuffer2.append(strK);
                            throw new BuildException(stringBuffer2.toString());
                        }
                        if ((method.getModifiers() & 8) == 0) {
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append("main() method in ");
                            stringBuffer3.append(strK);
                            stringBuffer3.append(" is not declared static");
                            throw new BuildException(stringBuffer3.toString());
                        }
                        if (this.timeout == null) {
                            run();
                        } else {
                            this.thread = new Thread(this, "ExecuteJava");
                            project.A(this.thread, project.v(Thread.currentThread()));
                            this.thread.setDaemon(true);
                            Watchdog watchdog = new Watchdog(this.timeout.longValue());
                            watchdog.addTimeoutObserver(this);
                            synchronized (this) {
                                this.thread.start();
                                watchdog.start();
                                try {
                                    wait();
                                } catch (InterruptedException unused2) {
                                }
                                if (this.timedOut) {
                                    project.x("Timeout: sub-process interrupted", 1);
                                } else {
                                    this.thread = null;
                                    watchdog.stop();
                                }
                            }
                        }
                        if (this.caught != null) {
                            throw this.caught;
                        }
                        if (aVar != null) {
                            aVar.C();
                            aVar.j();
                        }
                        org.apache.tools.ant.types.d.a aVar4 = this.sysProperties;
                        if (aVar4 != null) {
                            aVar4.g();
                        }
                    } catch (SecurityException e14) {
                        throw e14;
                    } catch (ThreadDeath e15) {
                        throw e15;
                    } catch (BuildException e16) {
                        throw e16;
                    } catch (Throwable th3) {
                        th = th3;
                        throw new BuildException(th);
                    }
                } catch (ClassNotFoundException unused3) {
                }
            } catch (Throwable th4) {
                if (0 != 0) {
                    aVar2.C();
                    aVar2.j();
                }
                org.apache.tools.ant.types.d.a aVar5 = this.sysProperties;
                if (aVar5 != null) {
                    aVar5.g();
                }
                throw th4;
            }
        } catch (SecurityException e17) {
        } catch (ThreadDeath e18) {
        } catch (BuildException e19) {
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public int fork(v vVar) throws Throwable {
        org.apache.tools.ant.types.d dVar = new org.apache.tools.ant.types.d();
        dVar.m(this.javaCommand.k());
        for (String str : this.javaCommand.h()) {
            dVar.d().d(str);
        }
        if (this.classpath != null) {
            dVar.f(vVar.getProject()).k(this.classpath);
        }
        org.apache.tools.ant.types.d.a aVar = this.sysProperties;
        if (aVar != null) {
            dVar.b(aVar);
        }
        n nVar = new n(vVar);
        h hVarE = nVar.e();
        Long l11 = this.timeout;
        g gVar = new g(hVarE, l11 == null ? null : new i(l11.longValue()));
        gVar.o(vVar.getProject());
        if (v20.a.a("openvms")) {
            setupCommandLineForVMS(gVar, dVar.j());
        } else {
            gVar.p(dVar.j());
        }
        try {
            try {
                int iF = gVar.f();
                nVar.d();
                this.timedOut = gVar.l();
                return iF;
            } catch (IOException e11) {
                throw new BuildException(e11);
            }
        } catch (Throwable th2) {
            this.timedOut = gVar.l();
            throw th2;
        }
    }

    public synchronized boolean killedProcess() {
        return this.timedOut;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    this.main.invoke(null, this.javaCommand.h());
                    synchronized (this) {
                        notifyAll();
                    }
                } catch (InvocationTargetException e11) {
                    Throwable targetException = e11.getTargetException();
                    if (!(targetException instanceof InterruptedException)) {
                        this.caught = targetException;
                    }
                    synchronized (this) {
                        notifyAll();
                    }
                }
            } catch (Throwable th2) {
                this.caught = th2;
                synchronized (this) {
                    notifyAll();
                }
            }
        } catch (Throwable th3) {
            synchronized (this) {
                notifyAll();
                throw th3;
            }
        }
    }

    public void setClasspath(org.apache.tools.ant.types.n nVar) {
        this.classpath = nVar;
    }

    public void setJavaCommand(org.apache.tools.ant.types.c cVar) {
        this.javaCommand = cVar;
    }

    public void setOutput(PrintStream printStream) {
    }

    public void setPermissions(org.apache.tools.ant.types.o oVar) {
    }

    public void setSystemProperties(org.apache.tools.ant.types.d.a aVar) {
        this.sysProperties = aVar;
    }

    public void setTimeout(Long l11) {
        this.timeout = l11;
    }

    @Override // org.apache.tools.ant.util.r
    public synchronized void timeoutOccured(Watchdog watchdog) {
        try {
            if (this.thread != null) {
                this.timedOut = true;
                this.thread.interrupt();
            }
            notifyAll();
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
