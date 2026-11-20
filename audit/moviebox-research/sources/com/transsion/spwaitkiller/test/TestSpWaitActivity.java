package com.transsion.spwaitkiller.test;

import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.spwaitkiller.R;
import com.transsion.spwaitkiller.SpWaitKiller;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.lsposed.hiddenapibypass.l;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TestSpWaitActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "SpWaitKillerTest";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void init() {
        findViewById(R.id.btn_mode_case1).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.spwaitkiller.test.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestSpWaitActivity.init$lambda$0(this.f57958a, view);
            }
        });
        findViewById(R.id.mock).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.spwaitkiller.test.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestSpWaitActivity.init$lambda$1(this.f57959a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(TestSpWaitActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        SpWaitKiller.Companion companion = SpWaitKiller.Companion;
        Application application = this$0.getApplication();
        Intrinsics.f(application, "application");
        companion.builder(application).build().work();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1(TestSpWaitActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.mockInsertHeavyWorkToQueuedWork(10);
        this$0.startActivity(new Intent(this$0, (Class<?>) TestSpWait2Activity.class));
    }

    private final void mockInsertHeavyWorkToQueuedWork(final int i11) {
        try {
            Class<?> cls = Class.forName("android.app.QueuedWork");
            Method declaredMethod = cls.getDeclaredMethod("getHandler", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Intrinsics.e(objInvoke, "null cannot be cast to non-null type android.os.Handler");
            Intrinsics.f(((Handler) objInvoke).getLooper(), "handler.looper");
            Field declaredField = cls.getDeclaredField("sWork");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Intrinsics.e(obj, "null cannot be cast to non-null type java.util.LinkedList<java.lang.Runnable>");
            Field declaredField2 = cls.getDeclaredField("sFinishers");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(null);
            Intrinsics.e(obj2, "null cannot be cast to non-null type java.util.LinkedList<java.lang.Runnable>");
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ((LinkedList) obj2).add(new Runnable() { // from class: com.transsion.spwaitkiller.test.a
                @Override // java.lang.Runnable
                public final void run() {
                    TestSpWaitActivity.mockInsertHeavyWorkToQueuedWork$lambda$2(countDownLatch);
                }
            });
            ((LinkedList) obj).add(new Runnable() { // from class: com.transsion.spwaitkiller.test.TestSpWaitActivity.mockInsertHeavyWorkToQueuedWork.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Log.e(TestSpWaitActivity.TAG, "run work " + this + " on Thread " + Thread.currentThread().getName() + " begin");
                        Thread.sleep((long) (i11 * 1000));
                        countDownLatch.countDown();
                    } catch (InterruptedException e11) {
                        e11.printStackTrace();
                    }
                    Log.e(TestSpWaitActivity.TAG, "run work " + this + " on Thread " + Thread.currentThread().getName() + " finish");
                }
            });
            getSharedPreferences("test", 0).edit().putString(CampaignEx.JSON_KEY_AD_K, "v").apply();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mockInsertHeavyWorkToQueuedWork$lambda$2(CountDownLatch writtenToDiskLatch) {
        Intrinsics.g(writtenToDiskLatch, "$writtenToDiskLatch");
        Log.e(TAG, "wait runnable run on thread " + Thread.currentThread().getId() + ", is MainThread ? " + (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? " true" : " false"));
        try {
            writtenToDiskLatch.await();
        } catch (InterruptedException e11) {
            e11.printStackTrace();
        }
        Log.e(TAG, "wait runnable end");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_test_sp_wait);
        if (Build.VERSION.SDK_INT >= 28) {
            l.b("");
        }
        init();
    }
}
