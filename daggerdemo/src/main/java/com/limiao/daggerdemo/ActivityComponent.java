package com.limiao.daggerdemo;

import dagger.Component;

/**
 * Created by miao on 2019/3/11.
 */
@Component(modules = ActivityModule.class)
public interface ActivityComponent {

    // inject  方法的具体实现在 DaggerMainActivityComponent 类里
    // 在 DaggerMainActivityComponent 执行 mainActivityMembersInjector.injectMembers(mainActivity);

    // MainActivity_MembersInjector 实现了 injectMembers 方法
    // 在 injectMembers 方法是  instance.mStudent = mStudentProvider.get();
    // 实现了 activity 与 student 实例的绑定。

    // 在 对应的 activity 里调用并传入相应的 activity 实例
    void inject(MainActivity mainActivity);
}
