import React, {createContext, useReducer, useEffect, useState} from 'react';
import AppReducer from './AppReducer';
import {NotFoundPage} from "../components/NotFoundPage";

// Initial state
const initialState = {
  expense: {
    name: "Example",
    groupID: 0,
    membersList: [
      { id: 1, name: 'Bob', balance: 0, transactions: [] },
      { id: 2, name: 'Charle', balance: 0, transactions: [] }]

  },
  memberID: 1
}

// Create context
export const GlobalContext = createContext(initialState);

// Provider component
export const GlobalProvider = ({ children }) => {
  const [state, dispatch] = useReducer(AppReducer, initialState);
  const [error, setError] = useState(null);

  const path = window.location.pathname;

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(`http://localhost:8080/api/v1/expenses${path}`);
        if (!response.ok) {
          throw new Error('Network response was not ok.');
        }

        const data = await response.json();
        console.log(data)
        // Dispatch an action to update the state with fetched data
        dispatch({ type: 'FETCH_SUCCESS', payload: data});
      } catch (error) {
        //console.error('There was a problem fetching the data:', error);
        setError(error);
        // Handle error, show error message, etc.
      }
    };

    fetchData(); // Call the function to fetch the data on component mount
  }, []);
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

  if (error) {
    return <NotFoundPage />; // Render the 404 page if there's an error
  }

  return (<GlobalContext.Provider value={{
    expense: state.expense,
    memberID: state.memberID,
    deleteExpense,
    addExpense,
    changeMemberID,

  }}>
    {children}
  </GlobalContext.Provider>);
}