package com.marina.expensetracker.feature.stats

import com.github.mikephil.charting.data.Entry
import com.marina.expensetracker.Utils
import com.marina.expensetracker.base.BaseViewModel
import com.marina.expensetracker.base.UiEvent
import com.marina.expensetracker.data.dao.ExpenseDao
import com.marina.expensetracker.data.model.ExpenseSummary
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatsViewModel @Inject constructor(dao: ExpenseDao) : BaseViewModel() {
    val entries = dao.getAllExpensesByDate()
    val topEntries = dao.getTopExpenses()

    fun getEntriesForChart(entries: List<ExpenseSummary>): List<Entry> {
        val list = mutableListOf<Entry>()
        for (entry in entries) {
            val formattedDate = Utils.getMilliFromDate(entry.date)
            list.add(Entry(formattedDate.toFloat(), entry.total_amount.toFloat()))
        }
        return list
    }

    override fun onEvent(event: UiEvent) {
    }
}
