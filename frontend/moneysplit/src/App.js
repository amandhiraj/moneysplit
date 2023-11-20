import React, {useContext, useEffect, useState} from 'react';
import { Header } from './components/Header';
import { Balance } from './components/Balance';
import { IncomeExpenses } from './components/IncomeExpenses';
import { TransactionList } from './components/TransactionList';
import { AddTransaction } from './components/AddTransaction';
import { MemberList } from './components/MemberList';
import {GlobalContext, GlobalProvider} from './context/GlobalState';
import { AppBar, Toolbar, Typography } from '@mui/material';

import logo from "./components/logo.png";
import './App.css';


function App() {
  return (
    <GlobalProvider>
        <AppBar position="fixed" style={{ background: 'transparent', boxShadow: 'none', top: 30, left: 0, right: 0 }}>
            <Toolbar style={{ display: 'flex', justifyContent: 'center' }}>
                <img src={logo} alt="Logo" style={{ height: 40 }} />
            </Toolbar>
        </AppBar>
      <div className="container">
        <MemberList />
      </div>
      <Header />
      <div className="main-container">
        <Balance />
        {/*<IncomeExpenses />*/}
        <TransactionList />
        <AddTransaction />
      </div>
    </GlobalProvider>
  );
}

export default App;
