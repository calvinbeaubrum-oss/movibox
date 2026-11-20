package com.transsion.ad.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TestAdActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f50611b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pq.g f50612a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(AppCompatActivity activity) {
            Intrinsics.g(activity, "activity");
            activity.startActivity(new Intent(activity, (Class<?>) TestAdActivity.class));
        }
    }

    public static final void W(TestAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) TestAdBannerActivity.class));
    }

    public static final void X(TestAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) TestAdSplashActivity.class));
    }

    public static final void Y(TestAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) TestAdVideoActivity.class));
    }

    public static final void Z(TestAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) TestAdInterstitialActivity.class));
    }

    public static final void a0(TestAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) TestAdNativeActivity.class));
    }

    public static final void b0(TestAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) TestAdNativeListActivity.class));
    }

    public static final void c0(TestAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) TestAdSceneActivity.class));
    }

    public static final void d0(TestAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) TestAdPlansActivity.class));
    }

    public static final void e0(TestAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) TestAdOtherConfigActivity.class));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pq.g gVarC = pq.g.c(getLayoutInflater());
        Intrinsics.f(gVarC, "inflate(layoutInflater)");
        this.f50612a = gVarC;
        pq.g gVar = null;
        if (gVarC == null) {
            Intrinsics.y("binding");
            gVarC = null;
        }
        setContentView(gVarC.getRoot());
        pq.g gVar2 = this.f50612a;
        if (gVar2 == null) {
            Intrinsics.y("binding");
            gVar2 = null;
        }
        gVar2.f74016c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.W(this.f50642a, view);
            }
        });
        pq.g gVar3 = this.f50612a;
        if (gVar3 == null) {
            Intrinsics.y("binding");
            gVar3 = null;
        }
        gVar3.f74020h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.X(this.f50643a, view);
            }
        });
        pq.g gVar4 = this.f50612a;
        if (gVar4 == null) {
            Intrinsics.y("binding");
            gVar4 = null;
        }
        gVar4.f74021i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.Y(this.f50644a, view);
            }
        });
        pq.g gVar5 = this.f50612a;
        if (gVar5 == null) {
            Intrinsics.y("binding");
            gVar5 = null;
        }
        gVar5.f74017d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.Z(this.f50645a, view);
            }
        });
        pq.g gVar6 = this.f50612a;
        if (gVar6 == null) {
            Intrinsics.y("binding");
            gVar6 = null;
        }
        gVar6.f74018f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.a0(this.f50646a, view);
            }
        });
        pq.g gVar7 = this.f50612a;
        if (gVar7 == null) {
            Intrinsics.y("binding");
            gVar7 = null;
        }
        gVar7.f74019g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.b0(this.f50647a, view);
            }
        });
        pq.g gVar8 = this.f50612a;
        if (gVar8 == null) {
            Intrinsics.y("binding");
            gVar8 = null;
        }
        gVar8.f74023k.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.c0(this.f50648a, view);
            }
        });
        pq.g gVar9 = this.f50612a;
        if (gVar9 == null) {
            Intrinsics.y("binding");
            gVar9 = null;
        }
        gVar9.f74015b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.d0(this.f50649a, view);
            }
        });
        pq.g gVar10 = this.f50612a;
        if (gVar10 == null) {
            Intrinsics.y("binding");
        } else {
            gVar = gVar10;
        }
        gVar.f74022j.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdActivity.e0(this.f50650a, view);
            }
        });
    }
}
