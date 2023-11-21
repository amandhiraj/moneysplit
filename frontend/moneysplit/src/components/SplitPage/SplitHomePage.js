import React, { useContext, useEffect, useState } from 'react';
import { Header } from '../Header';
import { Balance } from './Balance';
import { TransactionList } from './TransactionList';
import { AddTransaction } from './AddTransaction';
import { MemberList } from './MemberList';
import { GlobalContext, GlobalProvider } from '../../context/GlobalState';
import { AppBar, Toolbar } from '@mui/material';
import logo from '../logo.png';
import '../../App.css';
import { useParams } from 'react-router-dom';
import { NotFoundPage } from '../NotFoundPage';
import {ShareBox} from "./ShareBox";

function SplitHomePage() {
    const [error, setError] = useState(null);
    const { splitId } = useParams(); // Access splitId from the route parameters
    const { updateExpenseData } = useContext(GlobalContext);
    const [isLoading, setIsLoading] = useState(true);
    const [isNotFound, setIsNotFound] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(`http://localhost:8080/api/v1/expenses/${splitId}`);

                if (!response.ok) {
                    setIsNotFound(true);
                } else {
                    const dataApi = await response.json();
                    updateExpenseData(dataApi);
                }
            } catch (error) {
                setError(error);
                // Handle error, show error message, etc.
            } finally {
                setIsLoading(false); // Set loading to false when data fetching is completed
            }
        };

        fetchData(); // Call the function to fetch the data on component mount
    }, [splitId]); // Make sure to add splitId as a dependency if you want to refetch when it changes

    if (isLoading) {
        return <div>Loading...</div>; // Render a loading indicator while waiting for data
    }

    if (isNotFound) {
        return <NotFoundPage />;
    }

    return (
        <>
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
                <TransactionList />
                <AddTransaction />
                <ShareBox/>
            </div>
        </>
    );
}

export { SplitHomePage };
