import React from 'react';

const MemberSelectionModal = ({
  membersList,
  selectedMembers,
  handleMemberSelection,
  toggleMembersPopup,
  onSave,
}) => {
  return (
    <div className="modal-overlay">
      <div className="members-modal">
        <h3>Select Members</h3>
        <ul>
          {membersList.map((member) => (
            <li key={member.id}>
              <label>
                <input
                  type="checkbox"
                  value={member.id}
                  checked={selectedMembers.includes(member.id)}
                  onChange={() => handleMemberSelection(member.id)}
                />
                {member.name}
              </label>
            </li>
          ))}
        </ul>
        {/* Confirm or Save button for selected members */}
        <button onClick={onSave}>Save Selection</button>
      </div>
    </div>
  );
};

export {MemberSelectionModal};
