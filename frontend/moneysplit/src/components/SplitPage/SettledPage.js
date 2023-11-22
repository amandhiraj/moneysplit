import React, {useContext} from 'react';
import { Grid, Paper, Typography, Button } from '@mui/material';
import {GlobalContext} from "../../context/GlobalState";
import {useNavigate} from "react-router-dom";
const SettledPage = ({ hasSettledTransactions, setSettledTransactions }) => {
    const { expense } = useContext(GlobalContext);
    const navigate = useNavigate();
    function handleViewAndEdit(){
        navigate(`/split/${expense.groupId}`);
        setSettledTransactions(false);
    }
    return (
        <Grid container spacing={2} justifyContent="center">
            <Paper
                elevation={0}
                tabIndex={0}
                component="div"
                style={{
                    padding: '10px',
                    fontSize: '32px',
                    borderLeft: '4px solid #2ecc71',
                    borderRight: '4px solid #2ecc71',
                    marginBottom: '10px',
                    backgroundColor: '#dcdcdc'
                }}
            >
                {expense.name} Settlement
            </Paper>
            {hasSettledTransactions === false ? (
                <div>
                    <h2 style={{alignContent: 'center'}}>No settled transactions to display.</h2>
                    {/* Additional content or components */}
                </div>
            ) : (
                <>
                    {expense.settledTransactions.map((transaction, index) => (
                        <Grid item xs={12} key={index}>
                            <Paper style={{
                                padding: '10px',
                                backgroundColor: '#d9f6e5',
                                borderLeft: '4px solid #2ecc71',
                                marginBottom: '10px',
                            }}>
                                <Typography variant="h6" style={{ color: '#333', marginBottom: '5px' }}>
                                    {transaction.giver} owes {transaction.receiver}

                                    <Paper
                                        elevation={0}
                                        tabIndex={0}
                                        component="div"
                                        style={{
                                            padding: '10px',
                                            cursor: 'pointer',
                                            backgroundColor: 'rgba(16,20,24,0.18)'
                                        }}
                                    >
                                        ${transaction.value}

                                    </Paper>
                                </Typography>
                            </Paper>
                        </Grid>

                    ))}
                </>
            )}
            <Button variant="outlined" color="error" onClick={handleViewAndEdit}>
                View/Edit Expense
            </Button>
        </Grid>
    );
};

export {SettledPage};
