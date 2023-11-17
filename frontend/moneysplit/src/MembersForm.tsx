import React, { useState } from 'react';
import {
    TextField,
    Button,
    Box,
    Paper,
    Grid,
    Typography,
    IconButton,
    Stack,
} from '@mui/material';
import AddIcon from '@mui/icons-material/Add';
import RemoveIcon from '@mui/icons-material/Remove';

const TeamForm: React.FC = () => {
    const [numOfMembers, setNumOfMembers] = useState<number>(0);
    const [teamName, setTeamName] = useState<string>('');
    const [memberNames, setMemberNames] = useState<string[]>([]);

    const handleNextClick = () => {
        // Handle what happens when the "Next" button is clicked
        console.log('Team Name:', teamName);
        console.log('Number of Team Members:', numOfMembers);
        console.log('Member Names:', memberNames);
    };

    const handleMemberNameChange = (index: number, name: string) => {
        const updatedMembers = [...memberNames];
        updatedMembers[index] = name;
        setMemberNames(updatedMembers);
    };

    const increaseMembers = () => {
        setNumOfMembers(numOfMembers + 1);
    };

    const decreaseMembers = () => {
        if (numOfMembers > 0) {
            setNumOfMembers(numOfMembers - 1);
        }
    };

    const generateMemberFields = () => {
        const fields = [];
        for (let i = 0; i < numOfMembers; i++) {
            fields.push(
                <Grid key={i} item xs={12} sm={6} md={4}>
                    <TextField
                        label={`Member ${i + 1}`}
                        variant="outlined"
                        value={memberNames[i] || ''}
                        onChange={(e) => handleMemberNameChange(i, e.target.value)}
                        fullWidth
                        margin="normal"
                    />
                </Grid>
            );
        }
        return fields;
    };

    return (
        <Box
            component="main"
            sx={{
                backgroundColor: 'rgba(255, 255, 255, 0.5)',
                flexGrow: 1,
                minHeight: '50vh',
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
                padding: '40px',
            }}
        >
            <Paper
                elevation={1}
                sx={{
                    width: '100%',
                    maxWidth: '600px',
                    padding: '20px',
                    borderRadius: '10px',
                }}
            >
                <Typography variant="h5" gutterBottom>
                    Team Information
                </Typography>
                <Box sx={{ marginBottom: '20px', display: 'flex', alignItems: 'center' }}>
                    <IconButton onClick={decreaseMembers} disabled={numOfMembers === 0}>
                        <RemoveIcon />
                    </IconButton>
                    <TextField
                        label="Number of Team Members"
                        variant="outlined"
                        value={numOfMembers}
                        margin="normal"
                        type="number"
                        InputProps={{
                            inputProps: { min: 0 },
                        }}
                        sx={{ width: '120px', mx: '10px' }}
                    />
                    <IconButton onClick={increaseMembers}>
                        <AddIcon />
                    </IconButton>
                    <TextField
                        label="Team Name"
                        variant="outlined"
                        value={teamName}
                        onChange={(e) => setTeamName(e.target.value)}
                        margin="normal"
                        fullWidth
                    />
                </Box>
                {numOfMembers > 0 && (
                    <Paper elevation={3} sx={{ padding: '20px' }}>
                        <Grid container spacing={2}>
                            {generateMemberFields()}
                        </Grid>
                    </Paper>
                )}
                <Stack direction="row" spacing={2} sx={{ marginTop: '20px' }}>
                    {/*<Button variant="contained" color="primary" onClick={handleNextClick}>*/}
                    {/*    Primary Button*/}
                    {/*</Button>*/}
                    {/*<Button variant="outlined" color="secondary">*/}
                    {/*    Secondary Button*/}
                    {/*</Button>*/}
                    <Button variant="contained" color="info">
                        Success Button
                    </Button>
                    {/*<Button variant="outlined" color="error">*/}
                    {/*    Error Button*/}
                    {/*</Button>*/}
                </Stack>
            </Paper>
        </Box>
    );
};

export default TeamForm;
