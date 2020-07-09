package com.aib.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aib.lib.base.bean.BannerBean
import com.aib.lib.base.bean.ProductBean
import com.aib.lib.base.net.Resource
import com.aib.lib.base.net.convert
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel() {
    /**
     * 获取Banner数据
     */
    fun getBanner(): LiveData<List<BannerBean>> {
        val data = MutableLiveData<List<BannerBean>>()
        viewModelScope.launch {
            val bean = api.getBanner().convert()
            data.value = bean
        }
        return data
    }

    /**
     * 获取产品列表
     */
    fun getProductList(): LiveData<Resource<List<ProductBean>>> {
        val data = MutableLiveData<Resource<List<ProductBean>>>()
        data.value = Resource.load()
        viewModelScope.launch {
            runCatching {
                val bean = api.getProductList().convert()
                if (bean.isNullOrEmpty()) {
                    data.value = Resource.empty()
                } else {
                    data.value = Resource.success(bean)
                }
            }.onFailure {
                data.value = Resource.error(it.message ?: "加载失败")
            }
        }
        return data
    }
}