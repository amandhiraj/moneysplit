import React, { createContext, useReducer } from 'react';
import AppReducer from './AppReducer';

// Initial state
const initialState = {
  expense: {
    name: "Dr Trip",
    groupID: 0,
    membersList: [
      { id: 1, name: 'Aman', balance: 0, transactions: [] },
      { id: 2, name: 'Vamsi', balance: 0, transactions: [] },
      { id: 3, name: 'Pranav', balance: 0, transactions: [] }]
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


  return (<GlobalContext.Provider value={{
    expense: state.expense,
    memberID: state.memberID,
    deleteExpense,
    addExpense,
    changeMemberID

  }}>
    {children}
  </GlobalContext.Provider>);
}