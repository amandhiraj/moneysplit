import React, { useContext } from 'react';
import { GlobalContext } from '../../context/GlobalState';

//Money formatter function
function moneyFormatter(num) {
  let p = num.toFixed(2).split('.');
  return (
    '$ ' + (p[0].split('')[0]=== '-' ? '-' : '') +
    p[0]
      .split('')
      .reverse()
      .reduce(function (acc, num, i, orig) {
        return num === '-' ? acc : num + (i && !(i % 3) ? ',' : '') + acc;
      }, '') +
    '.' +
    p[1]
  );
}

export const Balance = () => {
  const { expense, setUserBalance, memberID } = useContext(GlobalContext);
  //console.log("Member ID: " + memberID + " Name" + expense.membersList.find((mem) => mem.id === memberID).name);
  const amounts = expense.membersList.find((mem) => mem.id === memberID).transactions.map(transaction => transaction.amount);
  const total = amounts.reduce((acc, item) => (acc += item), 0);
  return (
    <>
      <h4>Your Balance</h4>
    <h1>{moneyFormatter(total)}</h1>
    </>
  )
}
