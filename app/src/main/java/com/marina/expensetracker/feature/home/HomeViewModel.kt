package com.marina.expensetracker.feature.home

import androidx.lifecycle.viewModelScope
import com.marina.expensetracker.utils.Utils
import com.marina.expensetracker.base.BaseViewModel
import com.marina.expensetracker.base.HomeNavigationEvent
import com.marina.expensetracker.base.UiEvent
import com.marina.expensetracker.data.dao.ExpenseDao
import com.marina.expensetracker.data.model.ExpenseEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(dao: ExpenseDao) : BaseViewModel() {
    val expenses = dao.getAllExpenses()

    override fun onEvent(event: UiEvent) {
        when (event) {
            is HomeUiEvent.OnAddExpenseClicked -> {
                viewModelScope.launch {
                    _navigationEvent.emit(HomeNavigationEvent.NavigateToAddExpense)
                }
            }

            is HomeUiEvent.OnAddIncomeClicked -> {
                viewModelScope.launch {
                    _navigationEvent.emit(HomeNavigationEvent.NavigateToAddIncome)
                }
            }

            is HomeUiEvent.OnSeeAllClicked -> {
                viewModelScope.launch {
                    _navigationEvent.emit(HomeNavigationEvent.NavigateToSeeAll)
                }
            }
        }
    }

    fun getBalance(list: List<ExpenseEntity>): String {
        var balance = 0.0
        for (expense in list) {
            if (expense.type == "Income") {
                balance += expense.amount
            } else {
                balance -= expense.amount
            }
        }
        return Utils.formatCurrency(balance)
    }

    fun getTotalExpense(list: List<ExpenseEntity>): String {
        var total = 0.0
        for (expense in list) {
            if (expense.type != "Income") {
                total += expense.amount
            }
        }
        return Utils.formatCurrency(total)
    }

    fun getTotalIncome(list: List<ExpenseEntity>): String {
        var totalIncome = 0.0
        for (expense in list) {
            if (expense.type == "Income") {
                totalIncome += expense.amount
            }
        }
        return Utils.formatCurrency(totalIncome)
    }
}

sealed class HomeUiEvent : UiEvent() {
    data object OnAddExpenseClicked : HomeUiEvent()
    data object OnAddIncomeClicked : HomeUiEvent()
    data object OnSeeAllClicked : HomeUiEvent()
}
