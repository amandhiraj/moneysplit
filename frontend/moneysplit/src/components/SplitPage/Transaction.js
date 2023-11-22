import React, { useState, useContext } from 'react';
import { GlobalContext } from '../../context/GlobalState';
import { MemberSelectionModal } from './MemberSelectionModel';
import {margin} from "@mui/system"; // Import the modal component

export const Transaction = ({ transaction }) => {
  const { deleteExpense, expense } = useContext(GlobalContext);
  const [showMembersPopup, setShowMembersPopup] = useState(false);
  const [selectedMembers, setSelectedMembers] = useState(transaction.sharedBy);

  // Function to toggle the display of the members modal
  const toggleMembersPopup = () => {
    setShowMembersPopup(!showMembersPopup);
  };

  // Function to handle member selection
  const handleMemberSelection = (memberId) => {
    if (selectedMembers.includes(memberId)) {
      setSelectedMembers(selectedMembers.filter((id) => id !== memberId));
    } else {
      setSelectedMembers([...selectedMembers, memberId]);
    }
  };

  return (
    <li className={transaction.amount < 0 ? 'minus' : 'plus'}>
      {transaction.text} <span>{'+$' + transaction.amount}   <span className="group-icon" onClick={toggleMembersPopup}>
      <button> 🧑‍🤝‍🧑</button>
      </span></span>
      <button onClick={() => deleteExpense(transaction.id)} className="delete-btn">x</button>
      {/* Add the group of people icon here */}

      {/* Render the modal conditionally */}
      {showMembersPopup && (
        <MemberSelectionModal
          membersList={expense.membersList}
          selectedMembers={selectedMembers}
          handleMemberSelection={handleMemberSelection}
          toggleMembersPopup={toggleMembersPopup}
          onSave={() => {
            toggleMembersPopup();
            transaction.sharedBy = selectedMembers;
          }}
        />
      )}
    </li>
  );
};
