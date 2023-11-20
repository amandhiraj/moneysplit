import React, { useState, useContext } from 'react';
import { GlobalContext } from '../context/GlobalState';
import { Alert, AlertTitle } from '@mui/material';

export const AddTransaction = () => {
  const [text, setText] = useState('');
  const [amount, setAmount] = useState(0);
  const [sharedBy, setSharedBy] = useState([]);
  const [error, setError] = useState(null); // State to handle error message

  const { expense, updateDatabase } = useContext(GlobalContext);
  const { addExpense } = useContext(GlobalContext);

  const onSubmit = (e) => {
    e.preventDefault();

    if (!text || !amount) {
      setError('Please fill in all fields.');
      return;
    }

    const newExpense = {
      id: Math.floor(Math.random() * 100000000),
      text,
      amount: +amount,
      sharedBy: sharedBy.map((memberId) => memberId),
    };

    addExpense(newExpense);
    setText('');
    setAmount(0);
    setSharedBy([]);
    setError(null);
  };

  const handleCheckboxChange = (event) => {
    const { value, checked } = event.target;

    if (checked) {
      setSharedBy([...sharedBy, value]);
    } else {
      setSharedBy(sharedBy.filter((id) => id !== value));
    }
  };
  const handleSaveAndCalculate = async () => {
    console.log("insinde handele")
    const urlGroupID = expense.groupID


    try {
      const response = await fetch(`http://localhost:8080/api/v1/expenses/update/${urlGroupID}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
          // Add other headers if needed
        },
        body: JSON.stringify(expense) // Replace yourDataObject with the actual data you want to send
      });

      if (!response.ok) {
        throw new Error('Network response was not ok.');
      }

      const data = await response.json();
      console.log('POST request successful:', data);
      // Handle the response data here
    } catch (error) {
      console.error('There was a problem with the POST request:', error);
      // Handle error, show error message, etc.
    }
  };
  return (
      <>
        <form onSubmit={onSubmit}>
          <div className="form-control">
            <label htmlFor="text">Item Name</label>
            <input
                type="text"
                value={text}
                onChange={(e) => setText(e.target.value)}
                placeholder="Enter Item. eg. (Food)"
                required
            />
          </div>
          <div className="form-control">
            <label htmlFor="amount">Item Cost</label>
            <input
                type="number"
                value={amount}
                onChange={(e) => setAmount(e.target.value)}
                placeholder="Enter the cost amount..."
                required
            />
          </div>
          <div className="form-control">
            <label>Shared By:</label>
            {expense.membersList.map((member) => (
                <div key={member.id}>
                  <label>
                    <input
                        type="checkbox"
                        value={member.id}
                        checked={sharedBy.includes(member.id)}
                        onChange={handleCheckboxChange}
                    />
                    {member.name}
                  </label>
                </div>
            ))}
          </div>
          {error && (
              <Alert severity="error">
                <AlertTitle>Error</AlertTitle>
                {error}
              </Alert>
          )}
          <button className="btn">Add transaction</button>
        </form>
        <button className="btn" onClick={handleSaveAndCalculate}>Save and Calculate</button>
      </>
  );
};

export default AddTransaction;
