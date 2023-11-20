import React, {useContext} from 'react'
import { GlobalContext } from '../context/GlobalState';
export const Header = () => {
    const { expense, memberID } = useContext(GlobalContext);
  return (
      <div style={{ display: 'flex', alignItems: 'center' }}>
          <h2 style={{ margin: '0 auto' }}>{expense.name}</h2>
      </div>
  )
}
