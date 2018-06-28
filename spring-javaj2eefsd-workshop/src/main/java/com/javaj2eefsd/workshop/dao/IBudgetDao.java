package com.javaj2eefsd.workshop.dao;

import java.util.List;

import com.javaj2eefsd.workshop.model.Budget;
import com.javaj2eefsd.workshop.model.DateRange;

public interface IBudgetDao {

	List<Budget> getAllBudget(DateRange body) throws Exception;

}
