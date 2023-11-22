import React, { useContext, useEffect, useState } from 'react';
import { Header } from '../Header';
import { Balance } from './Balance';
import { TransactionList } from './TransactionList';
import { AddTransaction } from './AddTransaction';
import { MemberList } from './MemberList';
import { GlobalContext } from '../../context/GlobalState';
import {Alert, AlertTitle, AppBar, Toolbar} from '@mui/material';
import logo from '../logo.png';
import '../../App.css';
import { useParams } from 'react-router-dom';
import { NotFoundPage } from '../NotFoundPage';
import { ShareBox } from "./ShareBox";
import { useNavigate } from 'react-router-dom';
import {SettledPage} from "./SettledPage";

function SplitHomePage() {
    const [error, setError] = useState(null);
    const { splitId } = useParams(); // Access splitId from the route parameters
    const { updateExpenseData, expense } = useContext(GlobalContext);
    const [isLoading, setIsLoading] = useState(true);
    const [isNotFound, setIsNotFound] = useState(false);
    const navigate = useNavigate();
    const [hasSettledTransactions, setSettledTransactions] = useState(false);
    const [unsavedChanges, setUnsavedChanges] = useState(false); // Track unsaved changes

    console.log(expense.settledTransactions.length <= 0 + "  " + hasSettledTransactions)
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(`http://localhost:8080/api/v1/expenses/${splitId}`);

                if (!response.ok) {
                    setIsNotFound(true);
                } else {
                    const dataApi = await response.json();
                    console.log(dataApi.settledTransactions.length)
                    setSettledTransactions(dataApi.settledTransactions.length > 1)
                    updateExpenseData(dataApi);
                }
            } catch (error) {
                navigate('/server-down');
                setError('Failed to fetch data. Please try again later.'); // Set error message
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

    if (error) {
        return <div>Error: {error}</div>; // Render an error message if an error occurred
    }

    return (
        <>
            <AppBar position="fixed" style={{ background: '#f7f7f7', boxShadow: 'none', top: 0, left: 0, right: 0 }}>
                <Toolbar style={{ display: 'flex', justifyContent: 'center' }}>
                    <img src={logo} alt="Logo" style={{ height: 40 }} />
                </Toolbar>
            </AppBar>
            <div className="main-container">
                {hasSettledTransactions === false ? (
                    <>
                        <MemberList />
                        <Header />
                        <br/>
                        <Balance />
                        <TransactionList setUnsavedChanges={setUnsavedChanges} />
                        <AddTransaction unsavedChanges={unsavedChanges} setUnsavedChanges={setUnsavedChanges}/>
                        <ShareBox />
                    </>
                ) : (
                    <>
                        <SettledPage
                            hasSettledTransactions={hasSettledTransactions}
                            setSettledTransactions={setSettledTransactions} />
                    </>

                    )}
            </div>
        </>
    );
}

export { SplitHomePage };
