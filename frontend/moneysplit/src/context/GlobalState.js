import React, {createContext, useReducer, useEffect, useState} from 'react';
import AppReducer from './AppReducer';
import {NotFoundPage} from "../components/NotFoundPage";

// Initial state
const initialState = {
  expense: {
    name: "Example",
    groupId: 0,
    membersList: [
      { id: 1, name: 'Bob', balance: 0, transactions: [] },
      { id: 2, name: 'Charle', balance: 0, transactions: [] }],
    settledTransactions: [],
    revisionVersion: ''

  },
  memberID: 1
}

// Create context
export const GlobalContext = createContext(initialState);

// Provider component
export const GlobalProvider = ({ children }) => {
  const [state, dispatch] = useReducer(AppReducer, initialState);
  // Actions
  function deleteExpense(id) {
    dispatch({
      type: 'DELETE_EXPENSE',
      payload: id
    });
  }

  function addExpense(expense) {
    dispatch({
      type: 'ADD_EXPENSE',
      payload: expense
    });
  }

  function changeMemberID(id) {
    dispatch({
      type: 'MODIFY_EDITOR',
      payload: id
    });

  }
  function updateExpenseData(expense) {
    dispatch({
      type: 'FETCH_SUCCESS',
      payload: expense
    });

  }

  return (<GlobalContext.Provider value={{
    expense: state.expense,
    memberID: state.memberID,
    deleteExpense,
    addExpense,
    changeMemberID,
    updateExpenseData
  }}>
    {children}
  </GlobalContext.Provider>);
}