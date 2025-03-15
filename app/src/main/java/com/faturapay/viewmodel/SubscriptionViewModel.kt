package com.faturapay.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faturapay.data.mock.MockDataProvider
import com.faturapay.data.model.Subscription

class SubscriptionViewModel : ViewModel() {
    private val _subscriptions = MutableLiveData<List<Subscription>>(MockDataProvider.getMockSubscriptions())
    val subscriptions: LiveData<List<Subscription>> = _subscriptions

    fun addSubscription(subscription: Subscription) {
        _subscriptions.value = _subscriptions.value?.plus(subscription)
    }

    fun updateSubscription(updatedSubscription: Subscription) {
        _subscriptions.value = _subscriptions.value?.map {
            if (it.id == updatedSubscription.id) updatedSubscription else it
        }
    }

    fun deleteSubscription(subscription: Subscription) {
        _subscriptions.value = _subscriptions.value?.filter { it.id != subscription.id }
    }
}
