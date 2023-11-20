import React, { createContext, useReducer } from 'react';
import AppReducer from './AppReducer';

// Initial state
const initialState = {
  transactions: [],
  membersList : [
    { id: 1, name: 'Aman', balance: 0 },
    { id: 2, name: 'Vamsi', balance: 0 },
    { id: 3, name: 'Pranav', balance: 0},
    // Add more members as needed
  ]
}

// Create context
export const GlobalContext = createContext(initialState);

// Provider component
export const GlobalProvider = ({ children }) => {
  const [state, dispatch] = useReducer(AppReducer, initialState);

  // Actions
  function deleteTransaction(id) {
    dispatch({
      type: 'DELETE_TRANSACTION',
      payload: id
    });
  }

  function addTransaction(transaction) {
    dispatch({
      type: 'ADD_TRANSACTION',
      payload: transaction
    });
  }

  function modifyTranscation(transaction) {
    dispatch({
      type: 'MODIFY_TRANSACTION',
      payload: transaction
    });
    
  }


  return (<GlobalContext.Provider value={{
    transactions: state.transactions,
    membersList: state.membersList,
    deleteTransaction,
    addTransaction,
    modifyTranscation,
  
  }}>
    {children}
  </GlobalContext.Provider>);
}