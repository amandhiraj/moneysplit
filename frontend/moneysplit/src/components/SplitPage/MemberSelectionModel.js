import React from 'react';
const MemberSelectionModal = ({
                                  membersList,
                                  selectedMembers,
                                  handleMemberSelection,
                                  onSave,
                              }) => {
    return (
        <div className="modal-overlay">
            <div className="members-modal">
                <h3 className="modal-title">Who Shares this cost?</h3>
                <ul className="members-list">
                    {membersList.map((member) => (
                        <li key={member.id} className="member-item">
                            <label className="member-label">
                                <input
                                    type="checkbox"
                                    value={member.id}
                                    checked={selectedMembers.includes(member.id)}
                                    onChange={() => handleMemberSelection(member.id)}
                                />
                                <span className="checkmark"></span>
                                {member.name}
                            </label>
                        </li>
                    ))}
                </ul>
                {/* Confirm or Save button for selected members */}
                <button className="save-button" onClick={onSave}>
                    Save Selection
                </button>
            </div>
        </div>
    );
};

export { MemberSelectionModal };
