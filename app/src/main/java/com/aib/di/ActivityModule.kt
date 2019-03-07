package com.aib.di

import com.aib.activity.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [
    FragmentModule::class
])
interface ActivityModule {
    /**
     * 欢迎界面
     */
    @ContributesAndroidInjector
    abstract fun SplashActivity(): SplashActivity

    /**
     * 主Activity
     */
    @ContributesAndroidInjector
    abstract fun MainActivity(): MainActivity

    /**
     * 用户注册
     */
    @ContributesAndroidInjector
    fun UserRegistActivity(): RegistActivity

    /**
     * 关于
     */
    @ContributesAndroidInjector
    fun AboutActivity(): AboutActivity

    /**
     * 设置
     */
    @ContributesAndroidInjector
    fun SettingsActivity(): SettingsActivity

    /**
     * 登录
     */
    @ContributesAndroidInjector
    fun LoginActivity(): LoginActivity
}