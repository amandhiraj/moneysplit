import React, { useContext } from 'react';
import { Transaction } from './Transaction';

import { GlobalContext } from '../context/GlobalState';

export const TransactionList = () => {
  const { expense,memberID } = useContext(GlobalContext);
  const trans = expense.membersList.find((mem) => mem.id === Number(memberID)).transactions;
  return (
    <>
      <h3>History</h3>
      <ul className="list">
        {trans.map(T => (<Transaction key={T.id} transaction={T} />))}
      </ul>
    </>
  )
}