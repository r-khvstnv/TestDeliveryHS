package com.rkhvstnv.testdeliveryhs.di

import com.rkhvstnv.testdeliveryhs.presentation.menu.MenuFragment
import dagger.Component
import javax.inject.Singleton


@[Singleton Component(modules = [AppModule::class])]
interface AppComponent {
    fun inject(menuFragment: MenuFragment)
}