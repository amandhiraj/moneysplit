// MemberList.js

import React, { useContext } from 'react';
import { GlobalContext } from '../context/GlobalState';

const MemberList = () => {
  const { membersList } = useContext(GlobalContext);
  return (
    <div className="members-container">
      <ul className="members-list">
        {membersList.map((member) => (
          <li key={member.id} className="member-card">
            <div>
              <h4>{member.name}</h4>
            </div>
            <div>
              <p className="money plus">{member.balance}</p>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export { MemberList };
