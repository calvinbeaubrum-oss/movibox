package org.apache.tools.ant.taskdefs;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.ComponentHelper;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.a0;
import org.apache.tools.ant.c0;
import org.apache.tools.ant.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a extends z implements a0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static /* synthetic */ Class f72750k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ClassLoader f72751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f72752i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f72753j = new ArrayList();

    public static /* synthetic */ Class v(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static a x(Project project, URL url, String str) {
        try {
            ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection())).connect();
            ComponentHelper componentHelperJ = ComponentHelper.j(project);
            componentHelperJ.g(str);
            try {
                c0 c0VarK = new s20.b().k(project, url);
                if (!c0VarK.G().equals("antlib")) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unexpected tag ");
                    stringBuffer.append(c0VarK.G());
                    stringBuffer.append(" expecting ");
                    stringBuffer.append("antlib");
                    throw new BuildException(stringBuffer.toString(), c0VarK.getLocation());
                }
                a aVar = new a();
                aVar.setProject(project);
                aVar.setLocation(c0VarK.getLocation());
                aVar.s("antlib");
                aVar.m();
                c0VarK.y(aVar);
                componentHelperJ.h();
                return aVar;
            } catch (Throwable th2) {
                componentHelperJ.h();
                throw th2;
            }
        } catch (IOException e11) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Unable to find ");
            stringBuffer2.append(url);
            throw new BuildException(stringBuffer2.toString(), e11);
        }
    }

    public void A(String str) {
        this.f72752i = str;
    }

    @Override // org.apache.tools.ant.a0
    public void b(z zVar) {
        this.f72753j.add(zVar);
    }

    @Override // org.apache.tools.ant.z
    public void c() {
        for (c0 c0Var : this.f72753j) {
            setLocation(c0Var.getLocation());
            c0Var.n();
            Object objF = c0Var.F();
            if (objF != null) {
                if (!(objF instanceof b)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Invalid task in antlib ");
                    stringBuffer.append(c0Var.G());
                    stringBuffer.append(" ");
                    stringBuffer.append(objF.getClass());
                    stringBuffer.append(" does not ");
                    stringBuffer.append("extend org.apache.tools.ant.taskdefs.AntlibDefinition");
                    throw new BuildException(stringBuffer.toString());
                }
                b bVar = (b) objF;
                bVar.z(this.f72752i);
                bVar.y(y());
                bVar.m();
                bVar.c();
            }
        }
    }

    public final ClassLoader y() {
        if (this.f72751h == null) {
            Class clsV = f72750k;
            if (clsV == null) {
                clsV = v("org.apache.tools.ant.taskdefs.Antlib");
                f72750k = clsV;
            }
            this.f72751h = clsV.getClassLoader();
        }
        return this.f72751h;
    }

    public void z(ClassLoader classLoader) {
        this.f72751h = classLoader;
    }
}
