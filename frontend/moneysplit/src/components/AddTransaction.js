import React, { useState, useContext } from 'react';
import { GlobalContext } from '../context/GlobalState';

export const AddTransaction = () => {
  const [text, setText] = useState('');
  const [amount, setAmount] = useState(0);
  const [sharedBy, setSharedBy] = useState([]); // State to hold shared by members

  // Get members from context or other source
  const { membersList } = useContext(GlobalContext)
  const { addTransaction } = useContext(GlobalContext);

  const onSubmit = (e) => {
    e.preventDefault();

    const newTransaction = {
      id: Math.floor(Math.random() * 100000000),
      text,
      amount: +amount,
      sharedBy: sharedBy.map((memberId) => Number(memberId)), // Convert IDs to numbers
    };

    addTransaction(newTransaction);
  };

  const handleCheckboxChange = (event) => {
    const { value, checked } = event.target;

    if (checked) {
      setSharedBy([...sharedBy, value]); // Add selected member ID to sharedBy
    }
  };

  return (
    <>
      <h3>Add new transaction</h3>
      <form onSubmit={onSubmit}>
        <div className="form-control">
          <label htmlFor="text">Text</label>
          <input
            type="text"
            value={text}
            onChange={(e) => setText(e.target.value)}
            placeholder="Enter text..."
          />
        </div>
        <div className="form-control">
          <label htmlFor="amount">Amount</label>
          <input
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            placeholder="Enter amount..."
          />
        </div>
        <div className="form-control">
          <label>Shared By:</label>
          {membersList.map((member) => (
            <div key={member.id}>
              <label>
                <input
                  type="checkbox"
                  value={member.id}
                  checked={sharedBy.includes(String(member.id))}
                  onChange={handleCheckboxChange}
                />
                {member.name}
              </label>
            </div>
          ))}
        </div>
        <button className="btn">Add transaction</button>
      </form>
    </>
  );
};
