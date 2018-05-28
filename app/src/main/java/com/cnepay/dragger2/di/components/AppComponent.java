package com.cnepay.dragger2.di.components;

import com.cnepay.dragger2.MyApplication;
import com.cnepay.dragger2.bean.Student;
import com.cnepay.dragger2.di.modules.AppModule;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by master on 2018/5/23.
 * 在Application中进行初始化
 * <p>
 * 要想注入到目标类中： void injectMainApp(MyApplication application);
 * 其中 方法名怎么命名都行，只不过为了便于理解一般都会以 inject开头，类似于 injectxxxx(Object object)括号里面的注入目标类,必须严格的和目标类相同
 *
 * @module 只能修饰一个类或者一个接口
 * <p>
 * <p>
 * 1.在Dagger中一个没有声明Scope的Component不能dependence有Scope声明的Component
 * 2.声明相同scope的Component之间不能相互依赖
 * 3.同时一个声明特定Scope的Component 不能有一个声明相同Scope的子组件。
 * 4.声明了Scope属性的类，则其Component必须声明相同的Scope
 * <p>
 * <p>
 * Error:(24, 1) 错误: com.cnepay.dragger2.di.components.AppComponent (unscoped) may not reference scoped bindings:
 * @Provides @Singleton com.squareup.okhttp.OkHttpClient com.cnepay.dragger2.di.modules.AppModule.provideOkHttpClient()
 * module中如果有scope修饰则component中也需要使用Scope进行修饰
 * <p>
 * Error:(15, 1) 错误: @Modules cannot be scoped. Did you mean to scope a method instead?
 * 声明 module 的注解不能同时声明 scope注解
 * <p>
 * <p>
 * Error:(17, 10) 错误: com.cnepay.dragger2.bean.SomeClassB1 cannot be provided without an @Inject constructor or from an @Provides- or @Produces-annotated method.
 * Activity中@Inject SomeClassB 类，但是在SomeClassB中并没有对构造器进行@Inject，同时Compondent中也没有提供初始化该类的方法。
 * <p>
 * <p>
 * dependence :
 * 1.Component(SonComponent) 仅继承 被依赖Component(FatherComponent) 中显示提供的依赖方法，如果不提供，则无法使用@Inject注入被依赖的Component(FatherComponent)中的对象
 * 2.dependence 会生成两个独立的DaggerSonComponent 和 DaggerFatherComponent 两个独立类。
 * <p>
 * 代码示例
 * SomeClassComponent someClassComponent = DaggerSomeClassComponent.create();
 * DaggerMainComponent.builder().someClassComponent(someClassComponent).build().injectMainActivity(this);
 * <p>
 * note:
 * (有待探究)SonComponent 和 FatherComponent 是依赖关系，如果其中一个声明了作用域的话，另外一个也必须声明，而且它们的 Scope 不能相同，FatherComponent 的生命周期 >= SonComponent *的声明周期。SonComponent 的 Scope 不能是 @Singleton，因为 Dagger 2 中 @Singleton 的 Component 不能依赖其他的 Component。所以这在Android中SingleTon 就会多被用于Application.
 * <p>
 * <p>
 * SubComponent:
 * 1.
 * <p>
 * <p>
 **/


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    OkHttpClient getOkHttpClient();

    Student getStudent();

    void injectMainApp(MyApplication application);

}
