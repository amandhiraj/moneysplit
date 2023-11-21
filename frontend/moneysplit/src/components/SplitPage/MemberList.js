// MemberList.js

import React, { useContext } from 'react';
import { GlobalContext } from '../../context/GlobalState';

const MemberList = () => {

    const { expense, changeMemberID,memberID } = useContext(GlobalContext);
    const handleMemberClick = (memberId) => {
        // Handle the click for the member with the given ID
        console.log(`Clicked member with ID ${expense}`);
        changeMemberID(memberId)
        // Perform any other actions based on the click
    };
    return (
        <div className="members-container">
            <ul className="members-list">
                {expense.membersList.map((member) => (
                    <li key={member.id} className={`member-card ${memberID === member.id ? 'selected' : ''}`}>
                        <div onClick={() => handleMemberClick(member.id)} style={{ cursor: 'pointer' }}>
                            <h4>{member.name}</h4>
                        </div>
                    </li>
                ))}
            </ul>
        </div>
    );

};

export { MemberList };
